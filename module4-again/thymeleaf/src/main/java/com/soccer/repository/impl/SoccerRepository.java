package com.soccer.repository.impl;

import com.soccer.model.SoccerPlayer;
import com.soccer.repository.ConnectionUtil;
import com.soccer.repository.ISoccerRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SoccerRepository implements ISoccerRepository {


    @Override
    public List<SoccerPlayer> findAll() {
        Session session = null;
        List<SoccerPlayer> soccerPlayers;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            soccerPlayers = session.createQuery("From SoccerPlayer").getResultList();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return soccerPlayers;
    }

    @Override
    public void save(SoccerPlayer soccerPlayer) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(soccerPlayer);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }

        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    @Override
    public SoccerPlayer findById(int id) {

        Session session = null;
        SoccerPlayer soccerPlayer;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            soccerPlayer = (SoccerPlayer) session.createQuery("FROM SoccerPlayer where id = :id").setParameter("id", id).getSingleResult();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return soccerPlayer;
    }

    @Override
    public void update(SoccerPlayer soccerPlayer) {
        Transaction transaction = null;
        Session session = null;

        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.update(soccerPlayer);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void remove(int id) {
        Transaction transaction = null;
        Session session = null;

        SoccerPlayer soccerPlayer = findById(id);

        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.delete(soccerPlayer);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<SoccerPlayer> findByName(String name) {
        TypedQuery<SoccerPlayer> query = ConnectionUtil.entityManager.createQuery("SELECT c FROM SoccerPlayer AS c WHERE c.name like :param", SoccerPlayer.class);
        query.setParameter("param", "%" + name + "%");
        return query.getResultList();
    }
}
