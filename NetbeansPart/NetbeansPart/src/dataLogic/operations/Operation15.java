package dataLogic.operations;

import data.DataManager;
import data.DataStateEntity;
import data.InsertDataObject;
import data.implementation.treap.Treap;
import structure.classes.Nehnutelnost;
import structure.classes.Osoba;
import structure.classes.Podiel;
import structure.searchIndex.OsobaRodCislo;

import java.util.LinkedList;

/**
 * Pridanie obcana
 * Created by Malbac on 24.10.2015.
 */
public class Operation15 {

    DataManager dataManager;

    ////

    public Operation15(DataManager dataManager){
        this.dataManager =  dataManager;
        //new InsertDataObject(dataManager);
    }


    /**
     *
     * @param rodneCislo
     * @param menoPriezvisko
     * @param trvalyPobyt
     * @return
     */
    public String insertOsoba(String rodneCislo,String menoPriezvisko,String trvalyPobyt){
        if(rodneCislo.equals("")){
            return "Prazdne pole";
        }
        if(menoPriezvisko.equals("")){
            return "Prazdne pole";
        }
        if(trvalyPobyt.equals("")){
            return "Prazdne pole";
        }


        boolean vlozene = dataManager.insertOsoba(rodneCislo,menoPriezvisko,trvalyPobyt);

        if(vlozene){
            return  "uspesne vlozene";
        } else {
            return "chyba";
        }
    }



}
