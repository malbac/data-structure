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

    public Operation8(DataManager dataManager) {
        this.dataManager = dataManager;
        listOsoba = dataManager.getListOsobaPodlaRodneCislo();
    }


    /**
     * vypis vsetky nehnutelnosti majitela
     *
     * @param rodneCislo
     * @param idKatastralneUzemie
     */
    public String vypisNehnutelnostiMajitelaVKatUzemi(String rodneCislo, int idKatastralneUzemie) {
        String result = "*********************************************************************************************************\n";
        result += "*************************Vypis nehnutelnosti majitela v katastralnom uzemi*******************************\n";


        OsobaRodCislo localOsobaRodCislo = (OsobaRodCislo) listOsoba.search(new OsobaRodCislo(new Osoba(rodneCislo, null, null)));
        if (localOsobaRodCislo != null) {
            LinkedList<Podiel> listPodiely = localOsobaRodCislo.getDataReference().getListPodiely();
            //prehladavanie listu podielov a kontrola, ci sa podiel/majetok nachadza v idKatastalneUzemie
            int foundId;
            Nehnutelnost localNehnutelnost;


            result += localOsobaRodCislo.toString() + "\n";
            for (int i = 0; i < listPodiely.size(); i++) {
                localNehnutelnost = listPodiely.get(i).getNehnutelnost();
                foundId = localNehnutelnost.getListVlastnictva().getKatastralneUzemie().getIdKatastralneUzemie();
                if (foundId == idKatastralneUzemie) {
                    result += "\n";
                    result += localNehnutelnost.toString();
                }
            }
        } else {
            result += "\nZadana osoba neexistuje";
        }
        result += "\n*********************************************************************************************************\n";
        return result;
    }



}
