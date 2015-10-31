package dataLogic.operations;

import data.DataManager;
import data.DataStateEntity;
import data.implementation.treap.Treap;
import structure.classes.KatastralneUzemie;
import structure.classes.Nehnutelnost;
import structure.classes.Osoba;
import structure.classes.Podiel;
import structure.searchIndex.KatastralneUzemieId;
import structure.searchIndex.NehnutelnostSupisneCislo;
import structure.searchIndex.OsobaRodCislo;

import java.util.LinkedList;

/**9. Výpis všetkých nehnute¾ností majite¾a (definovaný rodným èíslom).
 * Created by Malbac on 23.10.2015.
 */
public class Operation9 {

    Treap osobaRodCisloTreap;
    DataManager dataManager;

    public Operation9(){

        dataManager =  DataStateEntity.getDataManager();

        osobaRodCisloTreap = dataManager.getListOsobaPodlaRodneCislo();
        //System.out.println(vypisNehnutelnostiPodlaKatUzemia("Zilina"));


    }




    public String vypisNehnutelnostiMajitela(String rodneCislo){
        String result = "*********************************************************************************************************\n";
              result += "****************************Výpis všetkých nehnute¾ností majite¾a (definovaný rodným èíslom)**********\n" +
                        "         Rodne cislo: " + rodneCislo +  "\n\n";

        OsobaRodCislo osobaRodCislo = new OsobaRodCislo(new Osoba(rodneCislo,null,null));

        OsobaRodCislo localOsobaRodCislo = (OsobaRodCislo)osobaRodCisloTreap.search(osobaRodCislo);
        if(localOsobaRodCislo!=null) {
            LinkedList listPodiely = localOsobaRodCislo.getDataReference().getListPodiely();

            Podiel localPodiel;
            result += localOsobaRodCislo.toString() + "\n";
            for (int i = 0; i < listPodiely.size(); i++) {
                localPodiel = (Podiel) listPodiely.get(i);
                result += localPodiel.getNehnutelnost().toString() + "\n";
            }
        }
            result += "\n*********************************************************************************************************\n";



        return result;
    }


    public static void main(String[] args){
        new Operation9();
    }
}
