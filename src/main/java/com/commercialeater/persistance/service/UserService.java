package com.commercialeater.persistance.service;

import com.commercialeater.config.HibernateUtil;
import com.commercialeater.persistance.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.query.Query;

import java.util.List;

public class UserService {

    public void createUser(UserEntity userEntity) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(userEntity);
            transaction.commit();
        }
        catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }

            exception.printStackTrace();
        }
    }

    public List<UserEntity> getUsers() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from UserEntity", UserEntity.class).list();
        }
    }

    public List<UserEntity> getUsers(String email, String firstName, String lastName, Long city, String role) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            StringBuilder hql = new StringBuilder("from UserEntity where firstName like :fname " +
                    "and lastName like :lname and email like :email");

            if (email.equals("")) { email = "%"; }

            if (firstName.equals("")) { firstName = "%"; }

            if (lastName.equals("")) { lastName = "%"; }

            if (city > 0) {
                hql.append(" and city_id = :city");
            }

            if (!role.equalsIgnoreCase("all")) {
                hql.append("and role = :role ");
            }

            Query<UserEntity> query = session.createQuery(hql.toString(), UserEntity.class);
            query.setParameter("fname", MatchMode.START.toMatchString(firstName));
            query.setParameter("lname", MatchMode.START.toMatchString(lastName));
            query.setParameter("email", MatchMode.START.toMatchString(email));

            if (city > 0)
                query.setParameter("city", MatchMode.EXACT.toMatchString(String.valueOf(city)));
            if (!role.equalsIgnoreCase("all"))
                query.setParameter("role", role);

            return query.list();
        }
    }

    public void deleteUser(Long userId) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            UserEntity userEntity = session.get(UserEntity.class, userId);
            session.delete(userEntity);
            transaction.commit();
        }
        catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }

            exception.printStackTrace();
        }
    }

    public UserEntity getUserById(Long id) {

        UserEntity result = null;
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            result = session.get(UserEntity.class, id);
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

    public void updateUser(UserEntity userEntity) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(userEntity);
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
