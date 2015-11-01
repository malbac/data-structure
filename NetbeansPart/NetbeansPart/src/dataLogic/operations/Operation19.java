package dataLogic.operations;

import data.DataManager;
import data.DataStateEntity;
import data.implementation.treap.Treap;
import structure.classes.KatastralneUzemie;
import structure.classes.Nehnutelnost;
import structure.classes.Osoba;
import structure.searchIndex.*;

/**
 * Created by Malbac on 23.10.2015.
 * 18. Odstránenie obèana (definovaný rodným èíslom).
 */
public class Operation19 {

    Treap katUzemieIdTreap;
    DataManager dataManager;

    public Operation19(){

        dataManager =  DataStateEntity.getDataManager();

        katUzemieIdTreap = dataManager.getListKatastralneUzemiePodlaId();
        //System.out.println(vypisNehnutelnostiPodlaKatUzemia("Zilina"));


    }




    public String odstranenieListuVlastnictva(int listVlastnictva,int idKatastralnehoUzemia){
        String nazovKatastralnehoUzemia;

        KatastralneUzemieId katastralneUzemieId = (KatastralneUzemieId)katUzemieIdTreap.search(new KatastralneUzemieId(new KatastralneUzemie(idKatastralnehoUzemia, null, null)));

        if(katastralneUzemieId!=null) {
            nazovKatastralnehoUzemia = katastralneUzemieId.getDataReference().getNazovKatastralnehoUzemia();

            dataManager.removeListVlastnictva(listVlastnictva,nazovKatastralnehoUzemia);
        } else {
            return "Osoba sa nenasla";
        }
        return "uspesne odstranene";



    }


    public static void main(String[] args){
        new Operation19();
    }
}
