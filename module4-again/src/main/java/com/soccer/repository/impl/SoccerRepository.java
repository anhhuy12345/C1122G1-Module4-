package com.soccer.repository.impl;

import com.soccer.model.Soccer;
import com.soccer.repository.ISoccerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SoccerRepository implements ISoccerRepository {

   private static final List<Soccer> soccerList = new ArrayList<>();

    static {
        soccerList.add(new Soccer(1, " Franz Beckenbauer", "12/12/1968",
                45, "FW", "https://images2.thanhnien.vn/Uploaded/trantuananh/2018_06_10/franz-beckenbauer_EWMK.jpg?width=600"));
        soccerList.add(new Soccer(2, " Van NisterRooy", "17/01/1958",
                40, "ST", "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9d/Ruud_van_Nistelrooy_2017.jpg/800px-Ruud_van_Nistelrooy_2017.jpg"));
        soccerList.add(new Soccer(3, " Cassilas", "02/12/1995",
                25, "GK", "data:image/jpeg;base64,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"));
        soccerList.add(new Soccer(4, "Iniesta", "12/12/1982",
                30, "LB", "https://cdn.britannica.com/92/163892-050-420A2632/Andres-Iniesta-FC-Barcelona.jpg"));
        soccerList.add(new Soccer(5, "Nguyễn Văn Toàn", "14/04/1997",
                20, "FB", "https://vcdn1-vnexpress.vnecdn.net/2021/09/09/van-toan-2993-1631177996.jpg?w=0&h=0&q=100&dpr=1&fit=crop&s=N4f76LQmsgxwbUMaGcAGCw"));
    }


    @Override
    public List<Soccer> getSoccerList() {
        return soccerList;
    }

    @Override
    public boolean add(Soccer soccer) {
        soccerList.add(soccer);
        return true;
    }

    @Override
    public Soccer findById(int id) {
        for (Soccer x : soccerList) {
            if (x.getId() == id) {
                return x;
            }
        }
        return null;
    }

    @Override
    public boolean update(Soccer soccer) {
        for (Soccer x : soccerList) {
            if (x.getId() == soccer.getId()) {
                x.setName(soccer.getName());
                x.setBirthDay(soccer.getBirthDay());
                x.setExperience(soccer.getExperience());
                x.setPosition(soccer.getPosition());
            }
        }
        return false;
    }

    @Override
    public boolean delete(int idDelete) {
        soccerList.removeIf(x -> x.getId() == idDelete);
        return false;
    }

    @Override
    public List<Soccer> searchByName(String soccerNameSearch) {
        List<Soccer> soccers = new ArrayList<>();
        for (Soccer x : soccerList) {
            if (x.getName().contains(soccerNameSearch)) {
                soccers.add(x);
            }
        }
        return soccers;
    }
}