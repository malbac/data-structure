package structure.classes;

import data.implementation.treap.TNode;
import data.implementation.treap.Treap;

import java.util.LinkedList;

/**
 * Created by Malbac on 11.10.2015.
 */
public class Osoba {
    private String rodneCislo;
    private String menoPriezvisko;
    private String trvalyPobyt;


    private LinkedList<Podiel> listPodiely;


    public LinkedList getListPodiely() {
        return listPodiely;
    }

    public boolean addToListPodiely(Podiel podiel){
        if(!listPodiely.contains(podiel)) {
            return listPodiely.add(podiel);
        } else return false;
    }

    public boolean removeFromListPodiely(Podiel podiel){
        return listPodiely.remove(podiel);
    }


    public String getRodneCislo() {
        return rodneCislo;
    }

    public void setRodneCislo(String rodneCislo) {
        this.rodneCislo = rodneCislo;
    }

    public String getMenoPriezvisko() {
        return menoPriezvisko;
    }

    public void setMenoPriezvisko(String menoPriezvisko) {
        this.menoPriezvisko = menoPriezvisko;
    }

    public String getTrvalyPobyt() {
        return trvalyPobyt;
    }

    public void setTrvalyPobyt(String trvalyPobyt) {
        this.trvalyPobyt = trvalyPobyt;
    }

    public Osoba(String rodneCislo, String menoPriezvisko, String trvalyPobyt) {
        this.rodneCislo = rodneCislo;
        this.menoPriezvisko = menoPriezvisko;
        this.trvalyPobyt = trvalyPobyt;
        listPodiely = new LinkedList<Podiel>();
    }

    @Override
    public String toString() {
        return "Osoba " +
                "rodneCislo='" + rodneCislo + '\'' +
                ", menoPriezvisko='" + menoPriezvisko + '\'' +
                ", trvalyPobyt='" + trvalyPobyt + '\'';
    }
}
