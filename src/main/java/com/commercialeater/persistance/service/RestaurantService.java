package com.commercialeater.persistance.service;

import com.commercialeater.config.HibernateUtil;
import com.commercialeater.persistance.entity.RestaurantEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class RestaurantService {

    public void createRestaurant(RestaurantEntity restaurantEntity) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(restaurantEntity);
            transaction.commit();
        }
        catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }

            exception.printStackTrace();
        }
    }

    public List<RestaurantEntity> getRestaurants() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from RestaurantEntity", RestaurantEntity.class).list();
        }
    }

    public List<RestaurantEntity> getRestaurants(String name, String address) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<RestaurantEntity> query = criteriaBuilder.createQuery(RestaurantEntity.class);
            Root<RestaurantEntity> restaurantInfo = query.from(RestaurantEntity.class);
            query.where(criteriaBuilder.like(restaurantInfo.get("name"), name));
            query.where(criteriaBuilder.like(restaurantInfo.get("address"), address));

            return session.createQuery(query.select(restaurantInfo)).getResultList();
        }

    }

    public void updateRestaurant(RestaurantEntity restaurantEntity) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(restaurantEntity);
            transaction.commit();
        }
        catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }

            exception.printStackTrace();
        }
    }

    public RestaurantEntity getRestaurantById(Long id) {

        RestaurantEntity result = null;
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            result = session.get(RestaurantEntity.class, id);
            transaction.commit();
        }
        catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }

            exception.printStackTrace();
        }

        return result;
    }

    public void deleteRestaurant(Long restaurantId) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            RestaurantEntity restaurantEntity = session.get(RestaurantEntity.class, restaurantId);
            session.delete(restaurantEntity);
            transaction.commit();
        }
        catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }

            exception.printStackTrace();
        }
    }
}
