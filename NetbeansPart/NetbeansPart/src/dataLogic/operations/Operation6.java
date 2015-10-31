package dataLogic.operations;

import data.DataManager;
import data.DataStateEntity;
import data.implementation.treap.Treap;
import structure.classes.KatastralneUzemie;
import structure.classes.ListVlastnictva;
import structure.searchIndex.KatastralneUzemieId;
import structure.searchIndex.KatastralneUzemieNazov;
import structure.searchIndex.ListVlastnictvaId;

/**
 * Created by Malbac on 23.10.2015.
 * Vyh¾adanie listu vlastníctva pod¾a jeho èísla a názvu katastrálneho územia. Po nájdení
 listu vlastníctva je potrebné zobrazi všetky evidované údaje vrátane všetkıch údajov
 o majite¾och nehnute¾ností zapísanıch na liste vlastníctva (mená, priezviská, majetkové
 podiely...).
 */
public class Operation6 {

    Treap katUzemieNazovTreap;
    DataManager dataManager;

    public Operation6(){

        dataManager =  DataStateEntity.getDataManager();

        katUzemieNazovTreap = dataManager.getListKatastralneUzemiePodlaNazov();
        //System.out.println(vypisNehnutelnostiPodlaKatUzemia("Zilina"));


    }




    public String vyhladanieListuVlastnictva(int listVlastnictva,String nazovKatastralnehoUzemia){
        String result = "*********************************************************************************************************\n";
        result += "****************************Vyh¾adanie listu vlastníctva pod¾a jeho èísla a èísla katastrálneho územia**********\n" +
                "         List Vlastnictva: " + listVlastnictva + ", id kat uzemia"+ nazovKatastralnehoUzemia + "\n\n";
        KatastralneUzemieNazov localKatastralneUzemieNazov;
        localKatastralneUzemieNazov = (KatastralneUzemieNazov) katUzemieNazovTreap.search(new KatastralneUzemieNazov(new KatastralneUzemie(-1, null, nazovKatastralnehoUzemia)));

        if(localKatastralneUzemieNazov!=null){//najdene katastralne uzemie
            //variables
            Treap listListovVlastnictva;
            ListVlastnictva localListVlastnictva;
            //search
            listListovVlastnictva = localKatastralneUzemieNazov.getDataReference().getListListovVlastnictva();
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



    public static void main(String[] args){
        new Operation6();
    }
}
