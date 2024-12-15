package OV.Domein;


import jakarta.persistence.*;

@Entity
@Table(name = "adres")
public class Adres {
    @Id
    @Column(name = "adres_id")
    private int id;

    @Column(name = "postcode")
    private String postcode;

    @Column(name = "huisnummer")
    private String huisnummer;

    @Column(name = "straat")
    private String straat;

    @Column(name = "woonplaats")
    private String woonplaats;

    @OneToOne
    @JoinColumn(name = "reiziger_id", unique = true)
    private Reiziger reiziger;



    public Adres() {}

    public Adres(int id, String postcode, String huisnummer, String straat, String woonplaats) {
        this.id = id;
        this.postcode = postcode;
        this.huisnummer = huisnummer;
        this.straat = straat;
        this.woonplaats = woonplaats;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getPostcode() { return postcode; }
    public void setPostcode(String postcode) { this.postcode = postcode; }
    public String getHuisnummer() { return huisnummer; }
    public void setHuisnummer(String huisnummer) { this.huisnummer = huisnummer; }
    public String getStraat() { return straat; }
    public void setStraat(String straat) { this.straat = straat; }
    public String getWoonplaats() { return woonplaats; }
    public void setWoonplaats(String woonplaats) { this.woonplaats = woonplaats; }
    public Reiziger getReiziger() { return reiziger; }
    public void setReiziger(Reiziger reiziger) { this.reiziger = reiziger; }

    @Override
    public String toString() {
        return String.format("Adres {#%d %s-%s}", id, postcode, huisnummer);
    }
}

