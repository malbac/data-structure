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
public class Operation7 {

    Treap katUzemieNTreap;
    DataManager dataManager;

    public Operation7(DataManager dataManager){

        this.dataManager =  dataManager;

        katUzemieNTreap = dataManager.getListKatastralneUzemiePodlaNazov();
        //System.out.println(vypisNehnutelnostiPodlaKatUzemia("Zilina"));


    }




    public String vypisNehnutelnostiPodlaKatUzemia(String nazovKatastralnehoUzemia){
        String result = "*********************************************************************************************************\n";
              result += "****************************Vypis nehnutelnosti podla katastralneho uzemia*******************************\n" +
                        "         Katastralne uzemie: " + nazovKatastralnehoUzemia + "\n\n";
        KatastralneUzemieNazov localKatastralneUzemie;
        LinkedList<TNode> listNehnut = new LinkedList<TNode>();
        localKatastralneUzemie = (KatastralneUzemieNazov) katUzemieNTreap.search(new KatastralneUzemieNazov(new KatastralneUzemie(0, null, nazovKatastralnehoUzemia)));
        if(localKatastralneUzemie!=null){//najdene katastralne uzemie
            listNehnut= localKatastralneUzemie.getDataReference().getListNehnutelnost().inorderTraversal();
        }


        Nehnutelnost localV;
        for (int i = 0;i<listNehnut.size();i++){
            localV = ((NehnutelnostSupisneCislo)listNehnut.get(i)).getDataReference();
            result += localV.toString() +"\n";
            result += "\n*********************************************************************************************************\n";
        }
        return result;
    }


}
