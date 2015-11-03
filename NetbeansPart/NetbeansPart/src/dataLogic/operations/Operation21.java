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
public class Operation21 {

    DataManager dataManager;

    ////

    public Operation21(DataManager dataManager){
        this.dataManager =  dataManager;
    }

    /**
     *
     * @param idUradu
     * @param idKatastralnehoUzemia
     * @param nazovKatastralnehoUzemia
     * @return
     */
    public String insertKatastralneUzemie(int idUradu,int idKatastralnehoUzemia,String nazovKatastralnehoUzemia){
        if(nazovKatastralnehoUzemia.equals("")){
            return "Prazdne pole";
        }
        if(idUradu<0){
            return "Prazdne pole";
        }
        if(idKatastralnehoUzemia<0){
            return "Prazdne pole";
        }

        // tu mozez vyriesit integritu dat
        boolean vlozene = dataManager.insertKatastralneUzemie(idUradu,idKatastralnehoUzemia,nazovKatastralnehoUzemia);

        if(vlozene){
            return  "uspesne vlozene";
        } else {
            return "chyba";
        }
    }

}
