package com.repository;

import com.entity.Client;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class ClientDAO extends AbstractDAO<Client> implements IDAO<Client> {

    public List<Client> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Client> list = null;
        try {
            session.beginTransaction();

            Query query = session.createQuery("from Client");
            list = query.list();

            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (session.getTransaction() != null) {
                try {
                    session.getTransaction().rollback();

                } catch (HibernateException e2) {
                    e2.printStackTrace();
                }
            }
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch ( HibernateException e3) {
                    e3.printStackTrace();
                }
            }
            return list;
        }
    }

    public Client getFromId(Object id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Client cli = null;
        try {
            session.beginTransaction();

            cli = (Client) session.get(Client.class, (Integer) id);

            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (session.getTransaction() != null) {
                try {
                    session.getTransaction().rollback();
                } catch (HibernateException e2) {
                    e2.printStackTrace();
                }
            }
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (HibernateException e3) {
                    e3.printStackTrace();
                }
            }
            return cli;
        }
    }
}
