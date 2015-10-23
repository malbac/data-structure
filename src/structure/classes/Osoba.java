package structure.classes;

import data.implementation.treap.TNode;

/**
 * Created by Malbac on 11.10.2015.
 */
public class Osoba {
    private String rodneCislo;
    private String menoPriezvisko;
    private String trvalyPobyt;

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
    }

}
