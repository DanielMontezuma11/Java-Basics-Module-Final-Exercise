package model;

public class Student {

    private static int counter = 0;
    private String document;
    private String name;
    private int age;
    private int id;

    public Student(String document, String name, int age) {
        this.document = document;
        this.name = name;
        this.age = age;
        this.id = counter++;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
