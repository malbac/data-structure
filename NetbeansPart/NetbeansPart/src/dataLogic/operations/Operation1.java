package dataLogic.operations;

import data.DataManager;
import data.DataStateEntity;
import data.implementation.treap.TNode;
import data.implementation.treap.Treap;
import structure.classes.KatastralneUzemie;
import structure.classes.Nehnutelnost;
import structure.searchIndex.KatastralneUzemieId;
import structure.searchIndex.NehnutelnostSupisneCislo;

import java.util.LinkedList;

/**
 * Vyh¾adanie nehnute¾nosti pod¾a súpisného èísla a èísla katastrálneho územia.
 Po nájdení nehnute¾nosti je potrebné zobrazi všetky evidované údaje vrátane všetkıch
 údajov z listu vlastníctva na ktorom je nehnute¾nos zapísaná.
 */
public class Operation1 {

    Treap katUzemieIdTreap;
    DataManager dataManager;

    public Operation1(){

        dataManager =  DataStateEntity.getDataManager();

        katUzemieIdTreap = dataManager.getListKatastralneUzemiePodlaId();
        //System.out.println(vypisNehnutelnostiPodlaKatUzemia("Zilina"));


    }




    public String vypisNehnutelnosti(int supisneCislo,int idKatastralnehoUzemia){
        String result = "*********************************************************************************************************\n";
              result += "****************************Vypis nehnutelnosti podla supisneho cisla a id katastralneho uzemia**********\n" +
                        "         Katastralne uzemie: " + supisneCislo + ", id kat uzemia"+ idKatastralnehoUzemia + "\n\n";
        KatastralneUzemieId localKatastralneUzemie;
        localKatastralneUzemie = (KatastralneUzemieId) katUzemieIdTreap.search(new KatastralneUzemieId(new KatastralneUzemie(idKatastralnehoUzemia, null, null)));

        if(localKatastralneUzemie!=null){//najdene katastralne uzemie
            //variables
            Treap listNehnutelnosti;
            Nehnutelnost localN;
            //search
            listNehnutelnosti = localKatastralneUzemie.getDataReference().getListNehnutelnost();
            localN = ((NehnutelnostSupisneCislo)listNehnutelnosti.search(new NehnutelnostSupisneCislo(new Nehnutelnost(supisneCislo,null,null)))).getDataReference();
            //output
            result += localN.toString();
            result += "\n----------------------------------------------" +
                    "\nList Vlastnictva, kde je nehnutelnost zapisana\n";
            result += localN.getListVlastnictva().toString();
            result += "\n*********************************************************************************************************\n";

        }

        return result;
    }


    public static void main(String[] args){
        new Operation1();
    }
}
