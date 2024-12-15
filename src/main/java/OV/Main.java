package OV;

import OV.DAO.AdresDAO;
import OV.DAO.AdresDAOHibernate;
import OV.DAO.ReizigerDAO;
import OV.DAO.ReizigerDAOHibernate;
import OV.Domein.Adres;
import OV.Domein.Reiziger;

import java.sql.Date;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        ReizigerDAO reizigerDAO = new ReizigerDAOHibernate();
        AdresDAO adresDAO = new AdresDAOHibernate();

        Reiziger reiziger1 = new Reiziger(609, "G", "van", "Rijn", Date.valueOf("2002-09-17"));
        Adres adres1 = new Adres(6, "3511 LX", "37", "Oudegracht", "Utrecht");
        reiziger1.setAdres(adres1);
        adres1.setReiziger(reiziger1);
        reizigerDAO.save(reiziger1);

        Reiziger reiziger2 = new Reiziger(798, "B", "van", "Rijn", Date.valueOf("2002-10-22"));
        Adres adres2 = new Adres(34, "3521 AL", "6A", "Vismarkt", "Utrecht");
        reiziger2.setAdres(adres2);
        adres2.setReiziger(reiziger2);
        reizigerDAO.save(reiziger2);

        Reiziger reiziger3 = new Reiziger(597, "H", "", "Lubben", Date.valueOf("1998-08-11"));
        Adres adres3 = new Adres(43, "6707 AA", "375", "Hoofdstraat", "Wageningen");
        reiziger3.setAdres(adres3);
        adres3.setReiziger(reiziger3);
        reizigerDAO.save(reiziger3);

        Reiziger reiziger4 = new Reiziger(886, "F", "", "Memari", Date.valueOf("2002-12-03"));
        Adres adres4 = new Adres(23, "3817 CH", "4", "Koningstraat", "Amersfoort");
        reiziger4.setAdres(adres4);
        adres4.setReiziger(reiziger4);
        reizigerDAO.save(reiziger4);

        Reiziger reiziger5 = new Reiziger(702, "G", "", "Piccardo", Date.valueOf("2002-12-03"));
        Adres adres5 = new Adres(0, "3572 WP", "22", "Maliebaan", "Utrecht");
        reiziger5.setAdres(adres5);
        adres5.setReiziger(reiziger5);
        reizigerDAO.save(reiziger5);
        List<Reiziger> allReizigers = reizigerDAO.findAll();
        for (Reiziger reiziger : allReizigers) {
            System.out.println(reiziger);
        }
    }
}
