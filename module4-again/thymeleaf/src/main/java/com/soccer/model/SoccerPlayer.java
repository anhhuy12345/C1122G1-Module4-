package com.soccer.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SoccerPlayer {
    @Id
    private int id;
    private String name;
    private String birthDay;
    private String experience;
    private String position;
    private String picture;

    public SoccerPlayer() {

    }

    public SoccerPlayer(int id, String name, String birthDay, String experience, String position, String picture) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
        this.experience = experience;
        this.position = position;
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

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
