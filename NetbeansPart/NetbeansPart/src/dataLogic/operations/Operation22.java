package dataLogic.operations;

import data.DataManager;
import data.DataStateEntity;
import data.implementation.InOrderIterator;
import data.implementation.treap.TNode;
import data.implementation.treap.Treap;
import structure.classes.KatastralneUzemie;
import structure.classes.ListVlastnictva;
import structure.classes.Nehnutelnost;
import structure.searchIndex.KatastralneUzemieId;
import structure.searchIndex.ListVlastnictvaId;
import structure.searchIndex.NehnutelnostSupisneCislo;

/**
 * Created by Malbac on 23.10.2015.
 */
public class Operation22 {

    Treap katUzemieIdTreap;
    DataManager dataManager;

    public Operation22(DataManager dataManager){

        this.dataManager =  dataManager;

        katUzemieIdTreap = dataManager.getListKatastralneUzemiePodlaId();
        //System.out.println(vypisNehnutelnostiPodlaKatUzemia("Zilina"));


    }




    public String odstranenieKatastralnehoUzemia(int idKatastralnehoUzemia) {


        String nazovKatastralnehoUzemia;
        int idUradu;
        KatastralneUzemieId nahradneKatastralneUzemie;

        KatastralneUzemieId mazaneKatastralneUzemieId = (KatastralneUzemieId)katUzemieIdTreap.search(new KatastralneUzemieId(new KatastralneUzemie(idKatastralnehoUzemia, null, null)));

        if(mazaneKatastralneUzemieId!=null) {
            KatastralneUzemie katastralneUzemie;
            katastralneUzemie = mazaneKatastralneUzemieId.getDataReference();

            nazovKatastralnehoUzemia = katastralneUzemie.getNazovKatastralnehoUzemia();
            idUradu = katastralneUzemie.getUrad().getId_uradu();
            //


            InOrderIterator inOrderIterator = new InOrderIterator(dataManager.getListKatastralneUzemiePodlaId().getRoot());
            while(inOrderIterator.hasNext()){
                nahradneKatastralneUzemie = (KatastralneUzemieId) inOrderIterator.next();
                if(!nahradneKatastralneUzemie.equals(mazaneKatastralneUzemieId)){//
                    moveAllDataFromOldToNewKatastralneUzemie(mazaneKatastralneUzemieId, nahradneKatastralneUzemie);
                    dataManager.removeKatastralneUzemie(idUradu, idKatastralnehoUzemia, nazovKatastralnehoUzemia);
                    return "data sa presunuli na list v. cislo: " + nahradneKatastralneUzemie.getDataReference().getNazovKatastralnehoUzemia();
                }
            }
            //
            dataManager.removeKatastralneUzemie(idUradu, idKatastralnehoUzemia, nazovKatastralnehoUzemia);
        } else {
            return "katastralne uzemie sa nenaslo";
        }
        return "uspesne odstranene";
    }

    private void moveAllDataFromOldToNewKatastralneUzemie(KatastralneUzemieId mazaneKatastralneUzemieId, KatastralneUzemieId nahradneKatastralneUzemie) {
        //pridanie vsetkych listov vlastnictva do noveho katastralneho uzemia
        TNode root = mazaneKatastralneUzemieId.getDataReference().getListListovVlastnictva().getRoot();
        InOrderIterator inOrderIterator = new InOrderIterator(root);
        ListVlastnictvaId presuvaneListVlastnictvaId;
        ListVlastnictva presuvanyListVlastnictva = new ListVlastnictva(-1,null);


        while (inOrderIterator.hasNext()){
            presuvaneListVlastnictvaId = (ListVlastnictvaId) inOrderIterator.next();
            presuvanyListVlastnictva = presuvaneListVlastnictvaId.getDataReference();

            //uprav back reference
            presuvanyListVlastnictva.setKatastralneUzemie(nahradneKatastralneUzemie.getDataReference());
            nahradneKatastralneUzemie.getDataReference().addListVlastnictva(presuvanyListVlastnictva);
        }


        root = mazaneKatastralneUzemieId.getDataReference().getListNehnutelnost().getRoot();
        inOrderIterator = new InOrderIterator(root);

        NehnutelnostSupisneCislo nehnutelnostSupisneCislo;
        Nehnutelnost presuvanaNehnutelnost;
        //pridanie vsetkych nehnutelnosti do noveho katastralneho uzemia
        while (inOrderIterator.hasNext()){
            nehnutelnostSupisneCislo = (NehnutelnostSupisneCislo) inOrderIterator.next();
            presuvanaNehnutelnost = nehnutelnostSupisneCislo.getDataReference();

            //uprav back reference
            if(presuvanyListVlastnictva.getIdListVlastnictva()==-1){
                System.out.println("Chyba pri presune nehnutelnosti, mazanie Operacia 22");
                return;
            }
            presuvanaNehnutelnost.setListVlastnictva(presuvanyListVlastnictva);
            nahradneKatastralneUzemie.getDataReference().addNehnutelnost(nehnutelnostSupisneCislo.getDataReference());
        }


    }


}
