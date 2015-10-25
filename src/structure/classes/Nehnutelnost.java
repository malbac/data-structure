package structure.classes;

import java.util.LinkedList;

/**
 * Created by Malbac on 23.10.2015.
 */
public class Nehnutelnost {

    private int idSupisneCislo;
    private ListVlastnictva listVlastnictva;
    private String adresa;

    private LinkedList<Podiel> listPodiely;


    public LinkedList getListPodiely() {
        return listPodiely;
    }

    public boolean addToListPodiely(Podiel podiel){
        return listPodiely.add(podiel);
    }

    public boolean removeToListPodiely(Podiel podiel){
        return listPodiely.remove(podiel);
    }

    public Nehnutelnost(int idSupisneCislo, ListVlastnictva listVlastnictva, String adresa) {
        this.idSupisneCislo = idSupisneCislo;
        this.listVlastnictva = listVlastnictva;
        this.adresa = adresa;
        listPodiely = new LinkedList<Podiel>();
    }

    public int getIdSupisneCislo() {
        return idSupisneCislo;
    }

    public void setIdSupisneCislo(int idSupisneCislo) {
        this.idSupisneCislo = idSupisneCislo;
    }

    public ListVlastnictva getListVlastnictva() {
        return listVlastnictva;
    }

    public void setListVlastnictva(ListVlastnictva listVlastnictva) {
        this.listVlastnictva = listVlastnictva;
    }


    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    @Override
    public String toString() {
        String result = "Nehnutelnost:  " +
                "idSupisneCislo=" + idSupisneCislo +
                ", idListVlastnictva=" + listVlastnictva.getIdListVlastnictva() +
                ", adresa='" + adresa + '\'';
        if(listPodiely!=null && !listPodiely.isEmpty()){
            result += ", podiel=" + listPodiely.getFirst().getPodiel() + "%";
        }
        return result;
    }
}
