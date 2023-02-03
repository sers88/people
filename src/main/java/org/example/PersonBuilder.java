package org.example;

public class PersonBuilder {
    private String name;
    private String surname;
    private int age;
    private String address;

    public PersonBuilder(String surname, String address) {
        this.surname = surname;
        this.address = address;
    }

    public PersonBuilder() {

    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setAge(int age) {
        this.age = age;
        if (this.age > 0) {
            return this;
        } else {
            throw new IllegalArgumentException("Возраст не может быть отрицательным");
        }
    }

    public Person build() {
        if (this.name == null || this.surname == null) {
            throw new IllegalStateException("Не хватает обязательных полей");
        }
        return new Person(this.name, this.surname, this.age, this.address);
    }

}
