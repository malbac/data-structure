package dataLogic.operations;

import data.DataManager;
import data.DataStateEntity;
import data.implementation.treap.Treap;
import structure.classes.KatastralneUzemie;
import structure.classes.ListVlastnictva;
import structure.classes.Nehnutelnost;
import structure.searchIndex.KatastralneUzemieId;
import structure.searchIndex.ListVlastnictvaId;
import structure.searchIndex.NehnutelnostSupisneCislo;

/**
 * Created by Malbac on 23.10.2015.
 * 4. Vyh¾adanie listu vlastníctva pod¾a jeho èísla a èísla katastrálneho územia. Po nájdení
 listu vlastníctva je potrebné zobrazi všetky evidované údaje vrátane všetkıch údajov
 o majite¾och nehnute¾ností zapísanıch na liste vlastníctva (mená, priezviská, majetkové
 podiely...).
 */
public class Operation4 {

    Treap katUzemieIdTreap;
    DataManager dataManager;

    public Operation4(DataManager dataManager){

        this.dataManager =  dataManager;

        katUzemieIdTreap = dataManager.getListKatastralneUzemiePodlaId();
        //System.out.println(vypisNehnutelnostiPodlaKatUzemia("Zilina"));


    }




    public String vyhladanieListuVlastnictva(int listVlastnictva,int idKatastralnehoUzemia){
        String result = "*********************************************************************************************************\n";
              result += "****************************Vyh¾adanie listu vlastníctva pod¾a jeho èísla a èísla katastrálneho územia**********\n" +
                        "         List Vlastnictva: " + listVlastnictva + ", id kat uzemia"+ idKatastralnehoUzemia + "\n\n";
        KatastralneUzemieId localKatastralneUzemie;
        localKatastralneUzemie = (KatastralneUzemieId) katUzemieIdTreap.search(new KatastralneUzemieId(new KatastralneUzemie(idKatastralnehoUzemia, null, null)));

        if(localKatastralneUzemie!=null){//najdene katastralne uzemie
            //variables
            Treap listListovVlastnictva;
            ListVlastnictva localListVlastnictva;
            //search
            listListovVlastnictva = localKatastralneUzemie.getDataReference().getListListovVlastnictva();
            ListVlastnictvaId listVlastnictvaId;
            listVlastnictvaId = (ListVlastnictvaId)listListovVlastnictva.search(new ListVlastnictvaId(new ListVlastnictva(listVlastnictva,null)));
            if(listVlastnictvaId!=null){
                result += listVlastnictvaId.getDataReference().toString();
            } else {
                result += "Zadany list vlastnictva neexistuje";
            }

            result += "\n*********************************************************************************************************\n";

        }

        return result;
    }


}
