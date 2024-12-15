package OV.DAO;

import OV.Domein.Adres;
import OV.Domein.Reiziger;

import java.util.List;

public interface AdresDAO {
    boolean save(Adres adres);
    boolean update(Adres adres);
    boolean delete(Adres adres);

    Adres findById(int id);

    List<Adres> findAll();
}
