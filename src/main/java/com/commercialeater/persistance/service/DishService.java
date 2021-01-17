package com.commercialeater.persistance.service;

import com.commercialeater.config.HibernateUtil;
import com.commercialeater.models.Diet;
import com.commercialeater.models.DishType;
import com.commercialeater.persistance.entity.DishEntity;
import com.commercialeater.persistance.entity.RestaurantEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.util.List;

public class DishService {

    public void createDish(Long restaurantId, DishEntity dishEntity) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            RestaurantEntity restaurant = session.get(RestaurantEntity.class, restaurantId);
            restaurant.getDishes().add(dishEntity);
            dishEntity.setRestaurant(restaurant);
            session.save(dishEntity);

            transaction.commit();
        }
        catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }

            exception.printStackTrace();
        }
    }

    public List<DishEntity> getDishes(Long id) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from DishEntity where restaurant_id ="+id, DishEntity.class).list();
        }
    }

    public List<DishEntity> getDishes(Long restaurantId, String name, BigDecimal price, String dishType, String diet,
                                      String pattern) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            StringBuilder hql = new StringBuilder("from DishEntity where restaurant_id = :id ");

            if (pattern.equals("<")) {
                hql.append("and price < :price ");
            }
            else if (pattern.equals("=")){
                hql.append("and price = :price ");
            }
            else {
                hql.append("and price > :price ");
            }

            if (!name.equals("")) {
                hql.append("and name = :name ");
            }

            if (!dishType.toLowerCase().equals("all")) {
                hql.append("and type = :type ");
            }

            if (!diet.toLowerCase().equals("all")) {
                hql.append("and diet = :diet ");
            }

            Query query = session.createQuery(hql.toString(), DishEntity.class);
            query.setParameter("price", price);
            query.setParameter("id", restaurantId);

            if (!dishType.toLowerCase().equals("all")) {
                query.setParameter("type", DishType.fromString(dishType));
            }

            if (!diet.toLowerCase().equals("all")) {
                query.setParameter("diet", Diet.fromString(diet));
            }

            if (!name.equals("")) {
                query.setParameter("name", name);
            }

            return query.list();
        }
    }

    public void updateDish(DishEntity dishEntity) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(dishEntity);
            transaction.commit();
        }
        catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }

            exception.printStackTrace();
        }
    }

    public DishEntity getDishById(Long id) {

        DishEntity result = null;
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            result = session.get(DishEntity.class, id);
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

    public void deleteDish(Long dishId) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            DishEntity dishEntity = session.get(DishEntity.class, dishId);
            session.delete(dishEntity);
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
