package com.commercialeater.persistance.service;

import com.commercialeater.config.HibernateUtil;
import com.commercialeater.persistance.entity.TransactionEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.stream.Collectors;

public class TransactionService {

    public List<TransactionEntity> getTransactions() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            return session.createQuery("from TransactionEntity", TransactionEntity.class).list();
        }
    }

    public List<TransactionEntity> getTransactions(String startDate, String endDate, String user, String transType) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            StringBuilder hql = new StringBuilder("from TransactionEntity where ");
            String date = null;

            if (startDate != null && endDate != null) {
                hql.append("dateTime between :startDate and :endDate ");
                date = "Between";
            }
            else if (endDate != null) {
                hql.append("dateTime <= :date");
                date = endDate;
            }
            else if (startDate != null) {
                hql.append("startDate >= :date AND");
                date = startDate;
            }

            if (!transType.equalsIgnoreCase("all")) {
                hql.append("and transactionType = :trans ");
            }

            hql.append("ORDER BY dateTime DESC");

            Query<TransactionEntity> query = session.createQuery(hql.toString(), TransactionEntity.class);

            if (date != null) {
                if (date.equals("Between")) {
                    query.setParameter("startDate", startDate);
                    query.setParameter("endDate", endDate);
                }
                else {
                    query.setParameter("date", date);
                }
            }

            if (!transType.equalsIgnoreCase("all"))
                query.setParameter("trans", transType);

            List<TransactionEntity> result = query.list();

            return result.stream().filter(trans -> {
                if (trans.getUser().getFirstName().contains(user)) return true;
                if (trans.getUser().getLastName().contains(user)) return true;
                if (trans.getUser().getEmail().contains(user)) return true;
                return false;
            }).collect(Collectors.toList());
        }

    }
}
