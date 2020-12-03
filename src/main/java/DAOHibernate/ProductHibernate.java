package DAOHibernate;

import domain.OVChipkaart;
import domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ProductHibernate implements ProductDAO {
    private SessionFactory sessionFactory;
    private Session sess;
    @Override
    public boolean save(Product product) {
        sess = sessionFactory.openSession();
        Transaction transaction = sess.beginTransaction();
        sess.save(product);
        transaction.commit();
        sess.close();
        return true;
    }

    @Override
    public boolean update(Product product) {
        sess = sessionFactory.openSession();
        Transaction transaction = sess.beginTransaction();
        sess.update(product);
        transaction.commit();
        sess.close();
        return true;
    }

    @Override
    public boolean delete(Product product) {
        sess = sessionFactory.openSession();
        Transaction transaction = sess.beginTransaction();
        sess.delete(product);
        transaction.commit();
        sess.close();
        return true;
    }

    @Override
    public List<Product> findByOvkaart(OVChipkaart ovChipkaart) {
        Session sess = sessionFactory.openSession();
        List<Product> product = sess.
                createQuery("from Product where OVChipkaart = :reiziger").setParameter("reiziger", ovChipkaart).list();
        sess.close();
        return product;
    }

    @Override
    public List<Product> findAll() {
        Session sess = sessionFactory.openSession();
        List<Product> products = sess.createQuery("from Product ").list();
        sess.close();

        return products;
    }
}
