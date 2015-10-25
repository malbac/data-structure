package dataLogic.operations;

import data.DataManager;
import data.InsertDataObject;
import data.implementation.treap.Treap;
import structure.classes.*;
import structure.searchIndex.*;

import java.util.LinkedList;

/**
 * Created by Malbac on 24.10.2015.
 */
public class Operation8 {

    Treap listOsoba;
    DataManager dataManager;

    ////

    public Operation8(){
        dataManager = new DataManager();
        new InsertDataObject(dataManager);
        listOsoba = dataManager.getListOsoba();
        System.out.println(vypisNehnutelnostiMajitelaVKatUzemi("1111",1));

    }








    /**
     * vypis vsetky nehnutelnosti majitela
     * @param rodneCislo
     * @param idKatastralneUzemie
     */
    public String vypisNehnutelnostiMajitelaVKatUzemi(String rodneCislo,int idKatastralneUzemie){
    String result = "";


        OsobaRodCislo localOsobaRodCislo = (OsobaRodCislo)listOsoba.search(new OsobaRodCislo(new Osoba(rodneCislo,null,null)));
        LinkedList<Podiel> listPodiely = localOsobaRodCislo.getDataReference().getListPodiely();
        //prehladavanie listu podielov a kontrola, ci sa podiel/majetok nachadza v idKatastalneUzemie
        int foundId;
        Nehnutelnost localNehnutelnost;


        result = localOsobaRodCislo.toString() + "\n";
        for(int i = 0;i<listPodiely.size();i++){
            localNehnutelnost = listPodiely.get(i).getNehnutelnost();
            foundId = localNehnutelnost.getListVlastnictva().getKatastralneUzemie().getIdKatastralneUzemie();
            if(foundId==idKatastralneUzemie){
                result += "\n";
                result +=localNehnutelnost.toString();
            }
        }

        return result;
    }



    public static void main(String[] args){
        new Operation8();
    }
}
