package DAOHibernate;

import DAOHibernate.AdresDAO;
import domain.Adres;
import domain.Reiziger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class AdresHibernate implements AdresDAO {
    private SessionFactory sessionFactory;
    private Session session;

    public AdresHibernate(Session session) {
        this.session = session;
    }


    @Override
    public boolean save(Adres adres) {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(adres);
        transaction.commit();
        session.close();
        return true;
    }



    @Override
    public boolean update(Adres adres) {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(adres);
        transaction.commit();
        session.close();
        return false;
    }

    @Override
    public boolean delete(Adres adres) {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(adres);
        transaction.commit();
        session.close();
        return false;
    }

    @Override
    public Adres findByReiziger(Reiziger reiziger) {
        Session session = sessionFactory.openSession();
        List<Adres> adres = session.createQuery("from adres where reiziger = :reiziger")
                .setParameter("reiziger", reiziger).list();
        session.close();
        return adres.get(0);

    }

    @Override
    public List<Adres> findAll() throws SQLException {
        Session session = sessionFactory.openSession();
        List<Adres> adressen = session.createQuery(" from adres").list();
        session.close();

        return adressen;

    }
}
