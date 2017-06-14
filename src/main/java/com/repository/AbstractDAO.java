package com.repository;

import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * Created by renaud on 02/06/2017.
 */
public abstract class AbstractDAO<T> implements IDAO<T> {

    public void add(T toAdd) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();

            session.merge(toAdd);

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
        }
    }

    public void delete(T toDelete) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();

            session.delete(toDelete);

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
        }
    }
}
