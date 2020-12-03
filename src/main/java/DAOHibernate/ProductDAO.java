package DAOHibernate;

import domain.OVChipkaart;
import domain.Product;

import java.util.List;

public interface ProductDAO {
    boolean save(Product product);
    boolean update(Product product);
    boolean delete(Product product);
    List<Product> findByOvkaart(OVChipkaart ovChipkaart);
    List<Product> findAll();
    }


