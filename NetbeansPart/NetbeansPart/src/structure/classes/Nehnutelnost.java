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


    public LinkedList<Podiel> getListPodiely() {
        return listPodiely;
    }

    public boolean addToListPodiely(Podiel podiel){
        if(!listPodiely.contains(podiel)) {
            return listPodiely.add(podiel);
        } return false;
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
            result += "\nPodiely:\n";
            Podiel localPodiel;
            for(int i=0;i<listPodiely.size();i++){
                localPodiel = listPodiely.get(i);
                result += localPodiel.getMajitel().getMenoPriezvisko() + " ma " + localPodiel.getPodiel() + "%\n";
            }

        }
        return result;
    }
}
