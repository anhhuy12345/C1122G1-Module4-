package com.soccer.service;

import com.soccer.model.Soccer;

import java.util.List;

public interface ISoccerService {
    List<Soccer> getSoccerList();

    void add(Soccer soccer);

    Soccer findById(int id);

    boolean update(Soccer soccer);

    boolean delete(int idDelete);

    List<Soccer> searchByName(String soccerNameSearch);
}

