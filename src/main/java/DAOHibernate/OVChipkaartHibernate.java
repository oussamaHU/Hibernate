package DAOHibernate;

import domain.Adres;
import domain.OVChipkaart;
import domain.Reiziger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class OVChipkaartHibernate implements OVChipkaartDAO {
    private SessionFactory sessionFactory;
    private Session sess;



    
    @Override
    public boolean save(OVChipkaart ovChipkaart) {
        sess = sessionFactory.openSession();
        Transaction transaction = sess.beginTransaction();
        sess.save(ovChipkaart);
        transaction.commit();
        sess.close();
        return true;
    }

    @Override
    public boolean update(OVChipkaart ovChipkaart) {
        sess = sessionFactory.openSession();
        Transaction transaction = sess.beginTransaction();
        sess.update(ovChipkaart);
        transaction.commit();
        sess.close();
        return true;
    }

    @Override
    public boolean delete(OVChipkaart ovChipkaart) {
        sess = sessionFactory.openSession();
        Transaction transaction = sess.beginTransaction();
        sess.delete(ovChipkaart);
        transaction.commit();
        sess.close();
        return true;
    }

    @Override
    public OVChipkaart findById(int kaartnummer) {
        Session session = sessionFactory.openSession();
        OVChipkaart ov = session.get(OVChipkaart.class, kaartnummer);
        session.close();
        return ov;
        }


    @Override
    public List<OVChipkaart> findAll() throws SQLException {
        Session sess = sessionFactory.openSession();
        //noinspection unchecked
        List<OVChipkaart> ovChipkaarts = sess.
                createQuery("select a from OVChipkaart a").
                list();
        sess.close();

        return ovChipkaarts;
    }

    @Override
    public OVChipkaart findByReiziger(Reiziger reiziger) {
        Session sess = sessionFactory.openSession();
        List<OVChipkaart> ovChipkaart = sess.
                createQuery("from OVChipkaart where reiziger = :reiziger").
                setParameter("reiziger", reiziger).list();
        sess.close();
        return ovChipkaart.get(0);
    }



}
