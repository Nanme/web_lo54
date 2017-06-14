package com.repository;

import com.entity.CourseSession;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class CourseSessionDAO extends AbstractDAO<CourseSession> implements IDAO<CourseSession> {

    public List<CourseSession> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<CourseSession> list = null;
        try {
            session.beginTransaction();

            Query query = session.createQuery("from CourseSession");
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

    public CourseSession getFromId(Object id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CourseSession cs = null;
        try {
            session.beginTransaction();

            cs = (CourseSession) session.get(CourseSession.class, (Integer) id);

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
            return cs;
        }
    }
}
