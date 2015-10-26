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
public class Operation17 {

    DataManager dataManager;

    ////

    public Operation17(){
        dataManager =  DataStateEntity.getDataManager();
    }


    /**
     *
     * @param idSupisneCislo
     * @param idListVlastnictva
     * @param adresa
     * @return
     */
    public String insertNehnutelnost(int idSupisneCislo,int idListVlastnictva,String adresa){
        if(adresa.equals("")){
            return "Prazdne pole";
        }
        if(idSupisneCislo<0){
            return "Prazdne pole";
        }
        if(idListVlastnictva<0){
            return "Prazdne pole";
        }

        // tu mozez vyriesit integritu dat
        boolean vlozene = dataManager.insertNehnutelnost(idSupisneCislo,idListVlastnictva,adresa);

        if(vlozene){
            return  "uspesne vlozene";
        } else {
            return "chyba";
        }
    }



    public static void main(String[] args){
        Operation17 operation8 = new Operation17();
    }
}
