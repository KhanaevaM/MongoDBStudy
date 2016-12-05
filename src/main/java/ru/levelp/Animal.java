package ru.levelp;


import javax.persistence.*;
import java.util.UUID;

//hibernate
@Entity
//morphia
@org.mongodb.morphia.annotations.Entity("animals")
//hibernate
@Table(name = "animals")
public class Animal {
    public static final String MALE = "male";
    public static final String FEMALE = "female";
    //hibernate
    @Id
    //@GeneratedValue(strategy = UUID.randomUUID().toString())
    //morphia
    @org.mongodb.morphia.annotations.Id
    private String id = UUID.randomUUID().toString();
    @Column(name = "type") //hib
    private String type;
    @Column(name = "name") //hib
    private String name;
    @Column(name = "age") //hib
    private int age;
    @Column(name = "gender") //hib
    private String gender;
    @Column(name = "color") //hib
    private int color;
    public Animal() {
    }

    public Animal(String type, String name, int age, String gender, int color) {
        this.type = type;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.color = color;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getColor() {
        return color;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}