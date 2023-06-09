package com.soccer.model;


public class Soccer {

    private int id;
    private String name;
    private String birthDay;
    private int experience;
    private String position;
    private String picture;

    public Soccer() {

    }

    public Soccer(int id, String name, String birthDay, int experience, String position, String picture) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
        this.experience = experience;
        this.position = position;
        this.picture = picture;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
