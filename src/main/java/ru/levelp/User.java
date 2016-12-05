package ru.levelp;


import javax.persistence.*;

//hibernate
@Entity
//morphia
@org.mongodb.morphia.annotations.Entity("users")
//hibernate
@Table(name = "users")
public class User {
    public static final String MALE = "male";
    public static final String FEMALE = "female";
    //hibernate
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //morphia
    @org.mongodb.morphia.annotations.Id
    private long id;
    @Column(name = "name") //hib
    private String name;
    @Column(name = "email") //hib
    private String email;
    @Column(name = "pass") //hib
    private String password;
    @Column(name = "age") //hib
    private int age;
    @Column(name = "gender") //hib
    private String gender;

    public User() {
    }

    public User(String name, String email, String password, int age, String gender) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
        this.gender = gender;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}