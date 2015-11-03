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

/**9. V�pis v�etk�ch nehnute�nost� majite�a (definovan� rodn�m ��slom).
 * Created by Malbac on 23.10.2015.
 */
public class Operation9 {

    Treap osobaRodCisloTreap;
    DataManager dataManager;

    public Operation9(DataManager dataManager){

        this.dataManager =  dataManager;

        osobaRodCisloTreap = dataManager.getListOsobaPodlaRodneCislo();
        //System.out.println(vypisNehnutelnostiPodlaKatUzemia("Zilina"));


    }




    public String vypisNehnutelnostiMajitela(String rodneCislo){
        String result = "*********************************************************************************************************\n";
              result += "****************************V�pis v�etk�ch nehnute�nost� majite�a (definovan� rodn�m ��slom)**********\n" +
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


}
