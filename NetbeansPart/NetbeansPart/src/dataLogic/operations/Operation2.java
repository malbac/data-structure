package dataLogic.operations;

import data.DataManager;
import data.DataStateEntity;
import data.implementation.treap.Treap;
import structure.classes.Nehnutelnost;
import structure.classes.Osoba;
import structure.searchIndex.NehnutelnostAdresa;
import structure.searchIndex.OsobaRodCislo;

/**
 * Vyh�adanie obyvate�a pod�a rodn�ho ��sla a v�pis jeho trval�ho pobytu (vyp�u sa
 * v�etky inform�cie o nehnute�nosti, ktor� ob�va)
 */
public class Operation2 {

    Treap osobaRodCTreap;
    Treap listNehnutelnostiPodlaAdresa;

    DataManager dataManager;

    public Operation2(DataManager dataManager){

        this.dataManager = dataManager;

        osobaRodCTreap = dataManager.getListOsobaPodlaRodneCislo();
        listNehnutelnostiPodlaAdresa = dataManager.getListNehnutelnostPodlaAdresa();
        //System.out.println(vypisNehnutelnostiPodlaKatUzemia("Zilina"));


    }




    public String vyhladanieObyvatela(String rodneCislo){
        String result = "*********************************************************************************************************\n";
              result += "****************************Vyh�adanie obyvate�a pod�a rodn�ho ��sla*************************************\n" +
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


}
