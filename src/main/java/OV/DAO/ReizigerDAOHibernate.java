package OV.DAO;

import OV.Domein.Reiziger;
import OV.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ReizigerDAOHibernate implements ReizigerDAO {

    @Override
    public boolean save(Reiziger reiziger) {
        if (reiziger.getAdres() == null) {
            throw new IllegalArgumentException("Reiziger moet gekoppeld zijn aan een Adres.");
        }
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(reiziger);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public boolean update(Reiziger reiziger) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(reiziger);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Reiziger reiziger) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(reiziger);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Reiziger findById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Reiziger reiziger = session.get(Reiziger.class, id);
            if (reiziger != null && reiziger.getAdres() != null) {
                reiziger.getAdres().getStraat();
            }
            return reiziger;
        }
    }

    @Override
    public List<Reiziger> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Reiziger", Reiziger.class).list();
        }
    }
}
