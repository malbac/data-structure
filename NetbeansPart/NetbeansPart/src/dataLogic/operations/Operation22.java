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
 */
public class Operation22 {

    Treap katUzemieIdTreap;
    DataManager dataManager;

    public Operation22(){

        dataManager =  DataStateEntity.getDataManager();

        katUzemieIdTreap = dataManager.getListKatastralneUzemiePodlaId();
        //System.out.println(vypisNehnutelnostiPodlaKatUzemia("Zilina"));


    }




    public String odstranenieKatastralnehoUzemia(int idKatastralnehoUzemia) {


        String nazovKatastralnehoUzemia;
        int idUradu;

        KatastralneUzemieId katastralneUzemieId = (KatastralneUzemieId)katUzemieIdTreap.search(new KatastralneUzemieId(new KatastralneUzemie(idKatastralnehoUzemia, null, null)));

        if(katastralneUzemieId!=null) {
            KatastralneUzemie katastralneUzemie;
            katastralneUzemie = katastralneUzemieId.getDataReference();

            nazovKatastralnehoUzemia = katastralneUzemie.getNazovKatastralnehoUzemia();
            idUradu = katastralneUzemie.getUrad().getId_uradu();

            dataManager.removeKatastralneUzemie(idUradu, idKatastralnehoUzemia, nazovKatastralnehoUzemia);
        } else {
            return "Osoba sa nenasla";
        }
        return "uspesne odstranene";
    }


    public static void main(String[] args){
        new Operation22();
    }
}
