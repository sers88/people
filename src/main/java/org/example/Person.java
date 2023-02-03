package org.example;

import java.util.OptionalInt;

public class Person {

    protected final String name;
    protected final String surname;
    private int age;
    private String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public boolean hasAge() {
        if (this.age > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean hasAddress() {
        if (this.address != null) {
            return true;
        } else {
            return false;
        }
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public OptionalInt getAge() {
        if (this.hasAge()) {
            return OptionalInt.of(this.age);
        } else {
            return OptionalInt.empty();
        }
    }

    public String getAddress() {
        if (this.hasAddress()) {
            return this.address;
        } else {
            return null;
        }
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (this.hasAge()) {
            this.age++;
        }
    }

    @Override
    public String toString() {
        return this.name + " " + this.surname;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 97 * hash + (this.surname != null ? this.surname.hashCode() : 0);
        return hash;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder(this.surname, this.address);
    }
}
