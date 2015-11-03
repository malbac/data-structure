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
 * Vyh�adanie nehnute�nosti pod�a s�pisn�ho ��sla a ��sla katastr�lneho �zemia.
 Po n�jden� nehnute�nosti je potrebn� zobrazi� v�etky evidovan� �daje vr�tane v�etk�ch
 �dajov z listu vlastn�ctva na ktorom je nehnute�nos� zap�san�.
 */
public class Operation1 {

    Treap katUzemieIdTreap;
    DataManager dataManager;

    public Operation1(DataManager dataManager){

        this.dataManager =  dataManager;

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


}
