package com.soccer.repository;

import com.soccer.model.SoccerPlayer;

import java.util.List;

public interface ISoccerRepository {
    List<SoccerPlayer> findAll();

    void save(SoccerPlayer soccerPlayer);

    SoccerPlayer findById(int id);

    void update(SoccerPlayer soccerPlayer);

    void remove(int id);

    List<SoccerPlayer> findByName(String name);

}

