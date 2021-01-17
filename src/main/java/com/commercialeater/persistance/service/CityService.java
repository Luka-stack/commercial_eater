package com.commercialeater.persistance.service;

import com.commercialeater.config.HibernateUtil;
import com.commercialeater.persistance.entity.CityEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CityService {

    public Long createCity(CityEntity city) {

        Long generatedID = -1L;
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            generatedID = (Long) session.save(city);
            transaction.commit();
        }
        catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }

            exception.printStackTrace();
        }

        return generatedID;
    }

    public List<CityEntity> getCities() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from CityEntity", CityEntity.class).list();
        }
    }

    public void deleteCity(Long cityId) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            CityEntity cityEntity = session.get(CityEntity.class, cityId);
            session.delete(cityEntity);
            transaction.commit();
        }
        catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }

            exception.printStackTrace();
        }
    }

    public CityEntity getCityByName(String name) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            Query query = session.createQuery("from CityEntity where name = :name");
            query.setParameter("name", name);
            return (CityEntity) query.list().get(0);
        }
    }
}
