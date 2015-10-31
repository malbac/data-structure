package dataLogic.operations;

import data.DataManager;
import data.DataStateEntity;
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
        dataManager = DataStateEntity.getDataManager();
        listOsoba = dataManager.getListOsobaPodlaRodneCislo();
    }








    /**
     * vypis vsetky nehnutelnosti majitela
     * @param rodneCislo
     * @param idKatastralneUzemie
     */
    public String vypisNehnutelnostiMajitelaVKatUzemi(String rodneCislo,int idKatastralneUzemie){
    String result = "*********************************************************************************************************\n";
          result += "*************************Vypis nehnutelnosti majitela v katastralnom uzemi*******************************\n";


        OsobaRodCislo localOsobaRodCislo = (OsobaRodCislo)listOsoba.search(new OsobaRodCislo(new Osoba(rodneCislo,null,null)));
        LinkedList<Podiel> listPodiely = localOsobaRodCislo.getDataReference().getListPodiely();
        //prehladavanie listu podielov a kontrola, ci sa podiel/majetok nachadza v idKatastalneUzemie
        int foundId;
        Nehnutelnost localNehnutelnost;


        result += localOsobaRodCislo.toString() + "\n";
        for(int i = 0;i<listPodiely.size();i++){
            localNehnutelnost = listPodiely.get(i).getNehnutelnost();
            foundId = localNehnutelnost.getListVlastnictva().getKatastralneUzemie().getIdKatastralneUzemie();
            if(foundId==idKatastralneUzemie){
                result += "\n";
                result +=localNehnutelnost.toString();
            }
        }
        result+="\n*********************************************************************************************************\n";
        return result;
    }



    public static void main(String[] args){
        Operation8 operation8 = new Operation8();
        System.out.println(operation8.vypisNehnutelnostiMajitelaVKatUzemi("1111", 1));
    }
}
