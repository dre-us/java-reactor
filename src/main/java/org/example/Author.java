package org.example;

public class Author {
    private String surname;
    private int age;
    private Gender gender;

    public Author(String surname, int age, Gender gender) {
        this.surname = surname;
        this.age = age;
        this.gender = gender;
    }

    public Author() {
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
