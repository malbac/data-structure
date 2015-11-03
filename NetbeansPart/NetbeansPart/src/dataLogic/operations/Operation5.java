package dataLogic.operations;

import data.DataManager;
import data.DataStateEntity;
import data.implementation.treap.Treap;
import structure.classes.KatastralneUzemie;
import structure.classes.Nehnutelnost;
import structure.searchIndex.KatastralneUzemieId;
import structure.searchIndex.KatastralneUzemieNazov;
import structure.searchIndex.NehnutelnostSupisneCislo;

/**
 * Created by Malbac on 23.10.2015.
 *
 * 5. Vyh�adanie nehnute�nosti pod�a s�pisn�ho ��sla a n�zvu katastr�lneho �zemia.
 Po n�jden� nehnute�nosti je potrebn� zobrazi� v�etky evidovan� �daje vr�tane v�etk�ch
 �dajov z listu vlastn�ctva na ktorom je nehnute�nos� zap�san�.
 */
public class Operation5 {

    Treap katUzemieNazovTreap;
    DataManager dataManager;

    public Operation5(DataManager dataManager){

        this.dataManager =  dataManager;

        katUzemieNazovTreap = dataManager.getListKatastralneUzemiePodlaNazov();
        //System.out.println(vypisNehnutelnostiPodlaKatUzemia("Zilina"));


    }




    public String vypisNehnutelnosti(int supisneCislo,String nazovKatastralnehoUzemia){
        String result = "*********************************************************************************************************\n";
        result += "****************************Vypis nehnutelnosti podla supisneho cisla a nazov katastralneho uzemia**********\n" +
                "         Katastralne uzemie: " + supisneCislo + ", id kat uzemia"+ nazovKatastralnehoUzemia + "\n\n";
        KatastralneUzemieNazov localKatastralneUzemieNazov;
        localKatastralneUzemieNazov = (KatastralneUzemieNazov) katUzemieNazovTreap.search(new KatastralneUzemieNazov(new KatastralneUzemie(-1 , null, nazovKatastralnehoUzemia)));

        if(localKatastralneUzemieNazov!=null){//najdene katastralne uzemie
            //variables
            Treap listNehnutelnosti;
            Nehnutelnost localN;
            //search
            listNehnutelnosti = localKatastralneUzemieNazov.getDataReference().getListNehnutelnost();
            NehnutelnostSupisneCislo nehnutelnostSupisneCislo = (NehnutelnostSupisneCislo)listNehnutelnosti.search(new NehnutelnostSupisneCislo(new Nehnutelnost(supisneCislo,null,null)));

            if(nehnutelnostSupisneCislo!=null) {
                localN = nehnutelnostSupisneCislo.getDataReference();
                //output
                result += localN.toString();

                result += "\n----------------------------------------------" +
                        "\nList Vlastnictva, kde je nehnutelnost zapisana\n";
                result += localN.getListVlastnictva().toString();

            } else {
                result += "nehnutelnost s danym supisnym cislom nie je v katastri zapisana";
            }
                result += "\n*********************************************************************************************************\n";

        }

        return result;
    }


}
