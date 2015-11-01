package dataLogic.operations;

import data.DataManager;
import data.DataStateEntity;
import data.implementation.treap.Treap;
import structure.classes.KatastralneUzemie;
import structure.classes.Nehnutelnost;
import structure.classes.Osoba;
import structure.searchIndex.KatastralneUzemieId;
import structure.searchIndex.NehnutelnostSupisneCislo;
import structure.searchIndex.OsobaRodCislo;

/**
 * Created by Malbac on 23.10.2015.
 */
public class Operation18 {

    Treap osobaRodCisloTreap;
    DataManager dataManager;

    public Operation18() {

        dataManager = DataStateEntity.getDataManager();

        osobaRodCisloTreap = dataManager.getListOsobaPodlaRodneCislo();
        //System.out.println(vypisNehnutelnostiPodlaKatUzemia("Zilina"));


    }


    public String odstranenieObcana(String rodCislo) {
        OsobaRodCislo osobaRodCislo;
        osobaRodCislo = (OsobaRodCislo) osobaRodCisloTreap.search(new OsobaRodCislo(new Osoba(rodCislo, null, null)));
        if(osobaRodCislo!=null) {
            Osoba osoba = osobaRodCislo.getDataReference();
            String meno;
            String trvaleBydlisko;
            meno = osoba.getMenoPriezvisko();
            trvaleBydlisko = osoba.getTrvalyPobyt();
            dataManager.removeOsoba(rodCislo, meno, trvaleBydlisko);
        } else {
            return "Osoba sa nenasla";
        }
        return "uspesne odstranene";
    }


    public static void main(String[] args) {
        new Operation18();
    }
}
