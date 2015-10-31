package dataLogic.operations;

import data.DataManager;
import data.DataStateEntity;
import data.implementation.treap.Treap;
import structure.classes.KatastralneUzemie;
import structure.classes.Nehnutelnost;
import structure.classes.Osoba;
import structure.searchIndex.KatastralneUzemieId;
import structure.searchIndex.KatastralneUzemieNazov;
import structure.searchIndex.NehnutelnostSupisneCislo;
import structure.searchIndex.OsobaRodCislo;

/**
 * Created by Malbac on 23.10.2015.
 * 11. Zmena majite�a (definovan� rodn�m ��slom) nehnute�nosti (definovan� s�pisn�m
 ��slom) v zadanom katastr�lnom �zem� (definovan� jeho ��slom). Nov� majite� je
 definovan� rodn�m ��slom.
 */
public class Operation11 {

    Treap katUzemieIdTreap;
    DataManager dataManager;

    public Operation11(){

        dataManager =  DataStateEntity.getDataManager();

        katUzemieIdTreap = dataManager.getListKatastralneUzemiePodlaId();
        //System.out.println(vypisNehnutelnostiPodlaKatUzemia("Zilina"));


    }




    public String zmenaTrvalehoPobytuDoNehnutelnosti(String rodneCislo, int supisneCislo,String nazovKatastralnehoUzemia){
        String result = "*********************************************************************************************************\n";
        result += "****************************Zmena trval�ho pobytu obyvate�a do nehnute�nosti**********\n" +
                "         Supisne cislo: " + supisneCislo + ", nazov kat uzemia"+ nazovKatastralnehoUzemia + ", rodne cislo: " + rodneCislo + "\n\n";

        OsobaRodCislo osobaRodCislo;
        NehnutelnostSupisneCislo nehnutelnostSupisneCislo;

        // najdenie osoby, kt updatujeme
        osobaRodCislo = (OsobaRodCislo) osobaRodCisloTreap.search(new OsobaRodCislo(new Osoba(rodneCislo,null,null)));
        if(osobaRodCislo==null){
            return "Zadana osoba neexistuje";
        }

        // najdenie nehnutelnosti z ktorej zoberieme novu adresu
        KatastralneUzemieNazov katastralneUzemieNazov;
        katastralneUzemieNazov = (KatastralneUzemieNazov) katUzemieNazovTreap.search(new KatastralneUzemieNazov(new KatastralneUzemie(-1,null,nazovKatastralnehoUzemia)));
        if(katastralneUzemieNazov==null){
            return "Nebolo najdene zadane kat. uzemie";
        }
        Treap treapNehnutelnost = katastralneUzemieNazov.getDataReference().getListNehnutelnost();

        // mame nehnutelnost z ktorej zoberieme adresu a tu priradime najdenej osobe
        nehnutelnostSupisneCislo = (NehnutelnostSupisneCislo) treapNehnutelnost.search(new NehnutelnostSupisneCislo(new Nehnutelnost(supisneCislo,null,null)));
        if(nehnutelnostSupisneCislo==null){
            return "zadane katastralne uzemie neobsahuje nehnutelnost";
        }

        // samotna zmena dat
        String novyTrvalyPobyt;
        novyTrvalyPobyt = nehnutelnostSupisneCislo.getDataReference().getAdresa();
        osobaRodCislo.getDataReference().setTrvalyPobyt(novyTrvalyPobyt);


        return "Uspesne vlozene";
    }


    public static void main(String[] args){
        new Operation11();
    }
}
