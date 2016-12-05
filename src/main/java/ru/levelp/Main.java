package ru.levelp;

import ru.levelp.dao.AnimalServiceMongo;
import ru.levelp.dao.UserDAO;
import ru.levelp.dao.UserServiceMySQL;

public class Main {
    public static void main(String[] args) {


        UserDAO userService = new UserServiceMySQL();

        AuthController authController = new AuthController(userService);
        AnimalServiceMongo animalService = new AnimalServiceMongo();
        animalService.add(new Animal("hb4", "bbb", 1276, Animal.FEMALE, 5465));
        System.out.println(animalService.getYoungest().getName() + " " + animalService.getYoungest().getAge());
        System.out.println(animalService.getYoungestBoy().getName()  + " " + animalService.getYoungestBoy().getAge() + " "+ animalService.getYoungestBoy().getGender());
        System.out.println(animalService.getOldestGirl().getName() + " " + animalService.getOldestGirl().getAge()+ " "+ animalService.getOldestGirl().getGender());
        System.out.println(animalService.getOlder(50).toString());
        System.out.println(animalService.getYounger(100));
        System.out.println(animalService.getByName("sf").getAge());
        System.out.println(animalService.getByType("hb4").getAge());
    }
}