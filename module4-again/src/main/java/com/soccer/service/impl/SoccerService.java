package com.soccer.service.impl;

import com.soccer.model.Soccer;
import com.soccer.service.ISoccerService;

import java.util.ArrayList;
import java.util.List;

public class SoccerService implements ISoccerService {
    static List<Soccer> soccerList = new ArrayList<>();

    static {
        soccerList.add(new Soccer(1, " Franz Beckenbauer", "12/12/1968",
                45, "FW"));
        soccerList.add(new Soccer(2, " Van NisterRooy", "17/01/1958",
                40, "ST"));
        soccerList.add(new Soccer(3, " Cassilas", "02/12/1995",
                25, "GK"));
        soccerList.add(new Soccer(4, "Iniesta", "12/12/1982",
                30, "LB"));
        soccerList.add(new Soccer(5, "Nguyễn Văn Toàn", "14/04/1997",
                20, "FB"));
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
