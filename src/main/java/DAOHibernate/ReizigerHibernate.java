package DAOHibernate;

import DAOHibernate.ReizigerDAO;
import domain.Reiziger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class ReizigerHibernate implements ReizigerDAO {
    private SessionFactory sessionFactory;
    private Session session;

    public ReizigerHibernate(Session session) {
        this.session = session;

    }
    @Override
    public boolean save(Reiziger reiziger) throws SQLException {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(reiziger);
        transaction.commit();
        session.close();
        return true;

    }

    @Override
    public boolean update(Reiziger reiziger) throws SQLException {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(reiziger);
        transaction.commit();
        session.close();
        return false;
    }

    @Override
    public boolean delete(Reiziger reiziger) {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(reiziger);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Reiziger findById(int id) throws SQLException {
        Session session = sessionFactory.openSession();
        Reiziger reiziger = session.get(Reiziger.class, id);
        session.close();
        return reiziger;
    }

    @Override
    public List<Reiziger> findByGbdatum(String datum) throws SQLException {
        Session session = sessionFactory.openSession();
        List<Reiziger> lijst = session.createQuery("from reiziger where geboortedatum = :gbdatum").setParameter("gbdatum", datum).list();
        session.close();
        return lijst;
    }

    @Override
    public List<Reiziger> findAll() throws SQLException {
        Session session = sessionFactory.openSession();
        //noinspection unchecked
        List<Reiziger> reizigers = session.createQuery("from reiziger ").list();
        session.close();

        return reizigers;
    }
}
