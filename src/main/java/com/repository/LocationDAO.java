package com.repository;

import com.entity.Location;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by renaud on 12/05/2017.
 */
public final class LocationDAO extends AbstractDAO<Location> implements IDAO<Location>{

    public List<Location> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Location> list = null;
        try {
            session.beginTransaction();

            Query query = session.createQuery("from Location");
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

    public Location getFromId(Object id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Location loc = null;
        try {
            session.beginTransaction();

            loc = (Location) session.get(Location.class, (Integer) id);

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
            return loc;
        }
    }

//    public void add(Location toAdd) {
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
//    public void delete(Location toDelete) {
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
