package com.repository;

import com.entity.Course;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by renaud on 12/05/2017.
 */
public final class CourseDAO extends AbstractDAO<Course> implements IDAO<Course>{

    public List<Course> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Course> list = null;
        try {
            session.beginTransaction();

            Query query = session.createQuery("from Course");
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

    public Course getFromId(Object id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Course cou = null;
        try {
            session.beginTransaction();

            cou = (Course) session.get(Course.class, (String) id);

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
            return cou;
        }
    }

//    public void add(Course toAdd) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        try {
//            session.beginTransaction();
//
//            session.merge(toAdd);
//
//            session.getTransaction().commit();
//        } catch (HibernateException e) {
//            e.printStackTrace();
//            if (session.getTransaction() != null) {
//                try {
//                    session.getTransaction().rollback();
//                } catch (HibernateException e2) {
//                    e2.printStackTrace();
//                }
//            }
//        } finally {
//            if (session != null) {
//                try {
//                    session.close();
//                } catch (HibernateException e3) {
//                    e3.printStackTrace();
//                }
//            }
//        }
//    }
//
//    public void delete(Course toDelete) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        try {
//            session.beginTransaction();
//
//            session.delete(toDelete);
//
//            session.getTransaction().commit();
//        } catch (HibernateException e) {
//            e.printStackTrace();
//            if (session.getTransaction() != null) {
//                try {
//                    session.getTransaction().rollback();
//                } catch (HibernateException e2) {
//                    e2.printStackTrace();
//                }
//            }
//        } finally {
//            if (session != null) {
//                try {
//                    session.close();
//                } catch (HibernateException e3) {
//                    e3.printStackTrace();
//                }
//            }
//        }
//    }
}
