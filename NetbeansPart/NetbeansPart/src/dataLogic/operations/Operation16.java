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
 * Created by Malbac on 24.10.2015.
 */
public class Operation16 {


    DataManager dataManager;

    ////

    public Operation16(DataManager dataManager){
        this.dataManager =  dataManager;
    }


    /**
     *
     * @param nazovKatastralnehoUzemia
     * @param idListVlastnictva
     * @return
     */
    public String insertListVlastnictva(String nazovKatastralnehoUzemia,int idListVlastnictva){
        if(nazovKatastralnehoUzemia.equals("")){
            return "Prazdne pole";
        }
        if(idListVlastnictva<0){
            return "Prazdne pole";
        }

        // tu mozez vyriesit integritu dat
        boolean vlozene = dataManager.insertListVlastnictva(idListVlastnictva,nazovKatastralnehoUzemia);

        if(vlozene){
            return  "uspesne vlozene";
        } else {
            return "chyba";
        }
    }





}
