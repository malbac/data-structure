package dataLogic.operations;

import data.DataManager;
import data.DataStateEntity;
import data.implementation.InOrderIterator;
import data.implementation.treap.TNode;
import data.implementation.treap.Treap;
import structure.classes.KatastralneUzemie;
import structure.classes.ListVlastnictva;
import structure.classes.Nehnutelnost;
import structure.classes.Osoba;
import structure.searchIndex.*;

/**
 * Created by Malbac on 23.10.2015.
 * 18. Odstránenie obèana (definovaný rodným èíslom).
 */
public class Operation19 {

    Treap katUzemieIdTreap;
    DataManager dataManager;

    public Operation19(DataManager dataManager){

        this.dataManager = dataManager;

        katUzemieIdTreap = dataManager.getListKatastralneUzemiePodlaId();
        //System.out.println(vypisNehnutelnostiPodlaKatUzemia("Zilina"));


    }




    public String odstranenieListuVlastnictva(int listVlastnictva,int idKatastralnehoUzemia){
        String nazovKatastralnehoUzemia;
        ListVlastnictvaId nahradnyListVlastnictva;
        ListVlastnictvaId mazanyListVlastnictva;

        KatastralneUzemieId katastralneUzemieId = (KatastralneUzemieId)katUzemieIdTreap.search(new KatastralneUzemieId(new KatastralneUzemie(idKatastralnehoUzemia, null, null)));

        if(katastralneUzemieId!=null) {
            nazovKatastralnehoUzemia = katastralneUzemieId.getDataReference().getNazovKatastralnehoUzemia();
            // presunutie nehnutelnosti na iny list vlastnictva
            mazanyListVlastnictva = (ListVlastnictvaId) dataManager.getListListVlastnictva().search(new ListVlastnictvaId(new ListVlastnictva(listVlastnictva,null)));

            InOrderIterator inOrderIterator = new InOrderIterator(dataManager.getListListVlastnictva().getRoot());
            while(inOrderIterator.hasNext()){
                nahradnyListVlastnictva = (ListVlastnictvaId) inOrderIterator.next();
                if(!nahradnyListVlastnictva.equals(mazanyListVlastnictva)){//
                    moveAllDataFromOldToNewListVlastnictva(mazanyListVlastnictva, nahradnyListVlastnictva);
                    dataManager.removeListVlastnictva(listVlastnictva,nazovKatastralnehoUzemia);
                    return "data sa presunuli na list v. cislo: " + nahradnyListVlastnictva.getDataReference().getIdListVlastnictva();
                }
            }
        } else {
            return "Osoba sa nenasla";
        }
        dataManager.removeListVlastnictva(listVlastnictva,nazovKatastralnehoUzemia);
        return "Zmazal sa posledny list vlastnictva";



    }

    private void moveAllDataFromOldToNewListVlastnictva(ListVlastnictvaId mazanyListVlastnictva, ListVlastnictvaId nahradnyListVlastnictva) {
        TNode root = mazanyListVlastnictva.getDataReference().getListNehnutelnost().getRoot();
        InOrderIterator inOrderIterator = new InOrderIterator(root);

        NehnutelnostSupisneCislo nehnutelnostSupisneCislo;
        ListVlastnictva listVlastnictva;
        listVlastnictva = nahradnyListVlastnictva.getDataReference();
        while (inOrderIterator.hasNext()){
            nehnutelnostSupisneCislo = (NehnutelnostSupisneCislo) inOrderIterator.next();

            //uprav back reference
            nehnutelnostSupisneCislo.getDataReference().setListVlastnictva(listVlastnictva);
            listVlastnictva.addNehnutelnostToListNehnutelnost(nehnutelnostSupisneCislo.getDataReference());
        }
    }


}
