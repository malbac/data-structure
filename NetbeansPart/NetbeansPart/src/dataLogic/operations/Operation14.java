package dataLogic.operations;

import data.DataManager;
import data.DataStateEntity;
import data.implementation.treap.Treap;
import structure.classes.KatastralneUzemie;
import structure.classes.Nehnutelnost;
import structure.searchIndex.KatastralneUzemieId;
import structure.searchIndex.KatastralneUzemieNazov;
import structure.searchIndex.NehnutelnostSupisneCislo;

import java.util.LinkedList;

/**
 * Created by Malbac on 23.10.2015.
 * 14. Výpis všetkých katastrálnych území utriedených pod¾a ich názvov.
 */
public class Operation14 {

    Treap katUzemieNazovTreap;
    DataManager dataManager;

    public Operation14(DataManager dataManager){

        this.dataManager =  dataManager;

        katUzemieNazovTreap = dataManager.getListKatastralneUzemiePodlaNazov();
        //System.out.println(vypisNehnutelnostiPodlaKatUzemia("Zilina"));


    }




    public String vypisVsetkychKatastralnychUzemi(){
        String result = "*********************************************************************************************************\n";
              result += "**************************Výpis všetkých katastrálnych území utriedených pod¾a ich názvov*******************\n\n";
        LinkedList listKatuzemi = katUzemieNazovTreap.inorderTraversal();

        if(listKatuzemi!=null){
            for(int i = 0;i<listKatuzemi.size();i++){
                result += ((KatastralneUzemieNazov)listKatuzemi.get(i)).getDataReference().getNazovKatastralnehoUzemia() + "\n";
            }
        }
        result += "\n*********************************************************************************************************\n";

        return result;
    }


}
