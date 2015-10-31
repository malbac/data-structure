package dataLogic.operations;

import data.DataManager;
import data.DataStateEntity;
import data.implementation.treap.Treap;
import structure.classes.Nehnutelnost;
import structure.classes.Osoba;
import structure.searchIndex.NehnutelnostAdresa;
import structure.searchIndex.OsobaRodCislo;

/**
 * Vyh¾adanie obyvate¾a pod¾a rodného èísla a výpis jeho trvalého pobytu (vypíšu sa
 * všetky informácie o nehnute¾nosti, ktorú obýva)
 */
public class Operation2 {

    Treap osobaRodCTreap;
    Treap listNehnutelnostiPodlaAdresa;

    DataManager dataManager;

    public Operation2(){

        dataManager =  DataStateEntity.getDataManager();

        osobaRodCTreap = dataManager.getListOsobaPodlaRodneCislo();
        listNehnutelnostiPodlaAdresa = dataManager.getListNehnutelnostPodlaAdresa();
        //System.out.println(vypisNehnutelnostiPodlaKatUzemia("Zilina"));


    }




    public String vyhladanieObyvatela(String rodneCislo){
        String result = "*********************************************************************************************************\n";
              result += "****************************Vyh¾adanie obyvate¾a pod¾a rodného èísla*************************************\n" +
                        "         Rodne cislo: " + rodneCislo + "\n\n";
        OsobaRodCislo  osobaRodCislo;
        osobaRodCislo = (OsobaRodCislo) osobaRodCTreap.search(new OsobaRodCislo(new Osoba(rodneCislo, null, null)));


        if(osobaRodCislo!=null){//najdena osoba
            Osoba localOsoba = osobaRodCislo.getDataReference();
            result += localOsoba.toString();
            result += "\n\nInformacie o trvalom pobyte:\n";
            //variables

            Nehnutelnost localN;
            //search
            String hladanaAdresa;
            hladanaAdresa = localOsoba.getTrvalyPobyt();
            NehnutelnostAdresa helpLocalNehnutelnostAdresa;
            helpLocalNehnutelnostAdresa = (NehnutelnostAdresa)listNehnutelnostiPodlaAdresa.search(new NehnutelnostAdresa(new Nehnutelnost(-1,null,hladanaAdresa)));

            if(helpLocalNehnutelnostAdresa==null){
                result+="\nNehnutelnost v ktorej byva obyvatel " + localOsoba.getMenoPriezvisko() + " nie je registrovana";
            } else {
                localN = helpLocalNehnutelnostAdresa.getDataReference();
                result+= "\nInformacie o obyvanej nehnutelnosti:\n"+ localN.toString();
            }
            //output

            result += "\n*********************************************************************************************************\n";

        }

        return result;
    }


    public static void main(String[] args){
        new Operation2();
    }
}
