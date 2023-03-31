package com.soccer.service.impl;

import com.soccer.model.SoccerPlayer;
import com.soccer.repository.ISoccerRepository;
import com.soccer.service.ISoccerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoccerService implements ISoccerService {
    @Autowired
    private ISoccerRepository iSoccerRepository;

    @Override
    public List<SoccerPlayer> findAll() {
        return iSoccerRepository.findAll();
    }

    @Override
    public void save(SoccerPlayer soccerPlayer) {
        iSoccerRepository.save(soccerPlayer);
    }

    @Override
    public SoccerPlayer findById(int id) {
        return iSoccerRepository.findById(id);
    }

    @Override
    public void update(SoccerPlayer soccerPlayer) {
        iSoccerRepository.update(soccerPlayer);
    }

    @Override
    public void remove(int id) {
        iSoccerRepository.remove(id);
    }

    @Override
    public List<SoccerPlayer> findByName(String name) {
        return iSoccerRepository.findByName(name);
    }
}
