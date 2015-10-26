package dataLogic.operations;

import data.DataManager;
import data.DataStateEntity;
import data.implementation.treap.TNode;
import data.implementation.treap.Treap;
import structure.classes.KatastralneUzemie;
import structure.classes.Nehnutelnost;
import structure.searchIndex.KatastralneUzemieNazov;
import structure.searchIndex.NehnutelnostSupisneCislo;

import java.util.LinkedList;

/**
 * Created by Malbac on 23.10.2015.
 */
public class OperationKatastralnyUrad {

    DataManager dataManager;

    public OperationKatastralnyUrad(){dataManager =  DataStateEntity.getDataManager();    }




    public String vlozKatastralnyUrad(int idUradu){
        if(idUradu<0){
            return "Prazdne pole";
        }

        // tu mozez vyriesit integritu dat
        boolean vlozene = dataManager.insertKatastralnyUrad(idUradu);

        if(vlozene){
            return  "uspesne vlozene";
        } else {
            return "chyba";
        }
    }


    public static void main(String[] args){
        new OperationKatastralnyUrad();
    }
}
