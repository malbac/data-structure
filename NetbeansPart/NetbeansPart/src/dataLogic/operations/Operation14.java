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
public class Operation14 {

    Treap katUzemieIdTreap;
    DataManager dataManager;

    public Operation14(){

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
            result += "\n\nList Vlastnictva, kde je nehnutelnost zapisana";
            result += localN.getListVlastnictva().toString();
            result += "\n*********************************************************************************************************\n";

        }

        return result;
    }


    public static void main(String[] args){
        new Operation14();
    }
}
