package OV.DAO;

import OV.Domein.Adres;
import OV.Domein.Reiziger;
import OV.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AdresDAOHibernate implements AdresDAO {

    @Override
    public boolean save(Adres adres) {
        if (adres.getReiziger() == null) {
            throw new IllegalArgumentException("Adres moet gekoppeld zijn aan een Reiziger.");
        }
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(adres);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public boolean update(Adres adres) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(adres);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Adres adres) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(adres);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Adres findById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                    "SELECT a FROM Adres a LEFT JOIN FETCH a.reiziger WHERE a.id = :id", Adres.class
            ).setParameter("id", id).uniqueResult();
        }
    }


    public Adres findByReiziger(Reiziger reiziger) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                    "SELECT a FROM Adres a JOIN FETCH a.reiziger WHERE a.reiziger = :reiziger", Adres.class
            ).setParameter("reiziger", reiziger).uniqueResult();
        }
    }


    @Override
    public List<Adres> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Adres", Adres.class).list();
        }
    }
}
