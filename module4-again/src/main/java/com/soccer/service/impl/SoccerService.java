package com.soccer.service.impl;

import com.soccer.model.Soccer;
import com.soccer.repository.ISoccerRepository;
import com.soccer.service.ISoccerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class SoccerService implements ISoccerService {

    @Autowired
    private ISoccerRepository iSoccerRepository;


    @Override
    public List<Soccer> getSoccerList() {
        return iSoccerRepository.getSoccerList();
    }

    @Override
    public boolean add(Soccer soccer) {
        iSoccerRepository.add(soccer);
        return true;
    }

    @Override
    public Soccer findById(int id) {

        return iSoccerRepository.findById(id);
    }

    @Override
    public boolean update(Soccer soccer) {

        return iSoccerRepository.update(soccer);
    }

    @Override
    public boolean delete(int idDelete) {

        return iSoccerRepository.delete(idDelete);
    }

    @Override
    public List<Soccer> searchByName(String soccerNameSearch) {

        return iSoccerRepository.searchByName(soccerNameSearch);
    }
}
