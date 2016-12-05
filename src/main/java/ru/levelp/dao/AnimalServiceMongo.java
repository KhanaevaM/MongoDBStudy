package ru.levelp.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import ru.levelp.Animal;
import ru.levelp.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AnimalServiceMongo extends BaseMongoService<Animal> {

    private long cursorId;

    public AnimalServiceMongo() {
        super(Animal.class);
    }

    public List<Animal> getAll() {
        return request().createQuery(Animal.class)
                .asList();
    }

    public Animal getByName(String name) {
        return request().createQuery(Animal.class)
                .field("name").equal(name)
                .get();
    }

    public Animal getByType(String type) {
        return request().createQuery(Animal.class)
                .field("type").equal(type)
                .get();
    }

    public List<Animal> getAllBoys() {
        return request().createQuery(Animal.class).field("gender").equal(Animal.MALE)
                .asList();
    }

    public List<Animal> getAllGirls() {
        return request().createQuery(Animal.class).field("gender").equal(Animal.FEMALE)
                .asList();
    }

    public List<Animal> getAllDark() {
        return request().createQuery(Animal.class).field("color").greaterThanOrEq(7829368)
                .asList();
    }

    public List<Animal> getAllLight() {
        return request().createQuery(Animal.class).field("color").lessThanOrEq(7829368)
                .asList();
    }

    public List<Animal> getYounger(int age) {
        return request().createQuery(Animal.class).field("age").lessThan(age)
                .asList();
    }

    public List<Animal> getOlder(int age) {
        return request().createQuery(Animal.class).field("age").greaterThan(age)
                .asList();
    }

    public Animal getYoungest() {
        String name = request().getCollection(Animal.class).find().sort(new BasicDBObject("age", 1)).toArray().get(0).get("name").toString();
        return request().createQuery(Animal.class).field("name").equal(name).get();
    }

    public Animal getYoungestBoy() {
//
        String name = "";
        ArrayList<DBObject> animals = new ArrayList<DBObject>(request().getCollection(Animal.class).find().sort(new BasicDBObject("age", 1)).toArray());
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).get("gender").equals("male")) {
                name = animals.get(i).get("name").toString();
                break;
            }
        }

        return request().createQuery(Animal.class).field("name").equal(name).get();
    }

    public Animal getOldestGirl() {
        String name = "";
        ArrayList<DBObject> animals = new ArrayList<DBObject>(request().getCollection(Animal.class).find().sort(new BasicDBObject("age", -1)).toArray());
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).get("gender").equals("female")) {
                name = animals.get(i).get("name").toString();
                break;
            }
        }
//
        return request().createQuery(Animal.class).field("name").equal(name).get();
    }


}
