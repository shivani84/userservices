package com.mk.vo;

/**
 * Created by shivani on 8/4/15.
 */
public class UserDetails {
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private int age;
    private String username;
    private String firstName;
    private String lastName;
    private String type;

    public UserDetails(String username, String firstName, String lastName, String type, int age) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.type = type;
        this.age = age;
    }

    public UserDetails() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
