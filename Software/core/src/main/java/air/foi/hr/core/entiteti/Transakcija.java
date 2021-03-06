package air.foi.hr.core.entiteti;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;


@Entity(tableName = "transakcija")
public class Transakcija {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private float iznos;
    private String datum;
    @ForeignKey(entity = Racun.class,parentColumns ="id",childColumns = "racun")
    private int racunTerecenja;
    @ForeignKey(entity=Racun.class,parentColumns = "id",childColumns = "racun")
    private int racunPrijenosa;
    private int tipTransakcije;
    private String memo;
    private String opis;
    private boolean ponavljajuciTrosak;
    private String ikona;
    private String boja;
    @ForeignKey(entity = Korisnik.class,parentColumns = "id",childColumns = "korisnik")
    private int korisnik;
    private String doDatuma;
    private int intervalPonavljanja;
    @ForeignKey(entity = KategorijaTransakcije.class,parentColumns = "id",childColumns = "kategorijaTransakcije")
    private int kategorijaTransakcije;

    public Transakcija() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getIznos() {
        return iznos;
    }

    public void setIznos(float iznos) {
        this.iznos = iznos;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public int getRacunTerecenja() {
        return racunTerecenja;
    }

    public void setRacunTerecenja(int racunTerecenja) {
        this.racunTerecenja = racunTerecenja;
    }

    public int getRacunPrijenosa() {
        return racunPrijenosa;
    }

    public void setRacunPrijenosa(int racunPrijenosa) {
        this.racunPrijenosa = racunPrijenosa;
    }

    public int getTipTransakcije() {
        return tipTransakcije;
    }

    public void setTipTransakcije(int tipTransakcije) {
        this.tipTransakcije = tipTransakcije;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public boolean isPonavljajuciTrosak() {
        return ponavljajuciTrosak;
    }

    public void setPonavljajuciTrosak(boolean ponavljajuciTrosak) {
        this.ponavljajuciTrosak = ponavljajuciTrosak;
    }

    public String getIkona() {
        return ikona;
    }

    public void setIkona(String ikona) {
        this.ikona = ikona;
    }

    public String getBoja() {
        return boja;
    }

    public void setBoja(String boja) {
        this.boja = boja;
    }

    public int getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(int korisnik) {
        this.korisnik = korisnik;
    }

    public String getDoDatuma() {
        return doDatuma;
    }

    public void setDoDatuma(String doDatuma) {
        this.doDatuma = doDatuma;
    }

    public int getIntervalPonavljanja() {
        return intervalPonavljanja;
    }

    public void setIntervalPonavljanja(int intervalPonavljanja) {
        this.intervalPonavljanja = intervalPonavljanja;
    }

    public int getKategorijaTransakcije() {
        return kategorijaTransakcije;
    }

    public void setKategorijaTransakcije(int kategorijaTransakcije) {
        this.kategorijaTransakcije = kategorijaTransakcije;
    }
}
