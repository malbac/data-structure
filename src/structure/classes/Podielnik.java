package structure.classes;

/**
 * Created by Malbac on 11.10.2015.
 */
public class Podielnik {
    private int idPodielnik;
    private ListVlastnictva listVlastnictva;
    private Osoba osoba;

    public Podielnik(int idPodielnik, ListVlastnictva listVlastnictva, Osoba osoba) {
        this.idPodielnik = idPodielnik;
        this.listVlastnictva = listVlastnictva;
        this.osoba = osoba;
    }

    public int getIdPodielnik() {
        return idPodielnik;
    }

    public void setIdPodielnik(int idPodielnik) {
        this.idPodielnik = idPodielnik;
    }

    public ListVlastnictva getListVlastnictva() {
        return listVlastnictva;
    }

    public void setListVlastnictva(ListVlastnictva listVlastnictva) {
        this.listVlastnictva = listVlastnictva;
    }

    public Osoba getOsoba() {
        return osoba;
    }

    public void setOsoba(Osoba osoba) {
        this.osoba = osoba;
    }
}
