package dataLogic.operations;

import data.DataManager;
import data.DataStateEntity;
import data.implementation.treap.Treap;
import structure.classes.KatastralneUzemie;
import structure.classes.Nehnutelnost;
import structure.searchIndex.KatastralneUzemieId;
import structure.searchIndex.NehnutelnostSupisneCislo;

/**
 * Created by Malbac on 23.10.2015.
 * Odstránenie nehnute¾nosti (definovaná popisným èíslom) z listu vlastníctva (definovaný
 * èíslom) v zadanom katastrálnom území (definované jeho èíslom).
 *
 */
public class Operation20 {

    Treap nehnutelnostSupCisloTreap;
    DataManager dataManager;

    public Operation20(){

        dataManager =  DataStateEntity.getDataManager();

        nehnutelnostSupCisloTreap = dataManager.getListNehnutelnostPodlaSupC();
        //System.out.println(vypisNehnutelnostiPodlaKatUzemia("Zilina"));


    }




    public String odstranenieNehnutelnostiZListuVlastnictva(int supisneCislo,int idListVlastnictva, int idKatastralnehoUzemia){
        NehnutelnostSupisneCislo nehnutelnostSupisneCislo;
        nehnutelnostSupisneCislo = (NehnutelnostSupisneCislo)nehnutelnostSupCisloTreap.search(new NehnutelnostSupisneCislo(new Nehnutelnost(supisneCislo, null, null)));
        if(nehnutelnostSupisneCislo!=null) {
            int localIdKatastralnehoUzemia = nehnutelnostSupisneCislo.getDataReference().getListVlastnictva().getKatastralneUzemie().getIdKatastralneUzemie();
            if(localIdKatastralnehoUzemia==idKatastralnehoUzemia){
                // vymazavam nehnutelnost ktora je v zadanom katastranom uzemi
                String adresa =  nehnutelnostSupisneCislo.getDataReference().getAdresa();
                dataManager.removeNehnutelnost(supisneCislo, idListVlastnictva, adresa);
            } else {
                return "Zadana nehnutelnost sa nenachadza v zadanom katastralnom uzemi";
            }

        } else {
            return "Osoba sa nenasla";
        }
        return "uspesne odstranene";





    }


    public static void main(String[] args){
        new Operation20();
    }
}
