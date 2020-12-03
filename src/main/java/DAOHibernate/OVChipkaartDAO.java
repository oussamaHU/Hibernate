package DAOHibernate;

import domain.Adres;
import domain.OVChipkaart;
import domain.Reiziger;

import java.sql.SQLException;
import java.util.List;

public interface OVChipkaartDAO {
    public boolean save(OVChipkaart ovChipkaart);
    public boolean update(OVChipkaart ovChipkaart);
    public boolean delete(OVChipkaart ovChipkaart);
    public OVChipkaart findById(int kaartnummer );
    public List<OVChipkaart> findAll() throws SQLException;
    public OVChipkaart findByReiziger(Reiziger reiziger);


}
