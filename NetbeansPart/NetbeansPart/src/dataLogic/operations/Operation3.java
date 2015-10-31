package dataLogic.operations;

import data.DataManager;
import data.DataStateEntity;
import data.implementation.InOrderIterator;
import data.implementation.treap.Treap;
import structure.classes.KatastralneUzemie;
import structure.classes.Nehnutelnost;
import structure.classes.Osoba;
import structure.searchIndex.KatastralneUzemieId;
import structure.searchIndex.NehnutelnostSupisneCislo;
import structure.searchIndex.OsobaTrvalyPobyt;

/**
 * Created by Malbac on 23.10.2015.
 * 3. Výpis všetkých osôb, ktoré majú trvalý pobyt v zadanej nehnute¾nosti (zadá sa èíslo
 katastrálneho územia, èíslo listu vlastníctva a súpisné èíslo)
 */
public class Operation3 {

    Treap katUzemieIdTreap;
    Treap OsobyTrvalePobytTreap;
    DataManager dataManager;

    public Operation3(){

        dataManager =  DataStateEntity.getDataManager();

        katUzemieIdTreap = dataManager.getListKatastralneUzemiePodlaId();
        OsobyTrvalePobytTreap = dataManager.getListOsobaPodlaTrvalyPobyt();
        //System.out.println(vypisNehnutelnostiPodlaKatUzemia("Zilina"));


    }




    public String vypisVsetkychOsobKtByvajuV(int idKatastralnehoUzemia, int idListVlastnictva, int supisneCislo){
        String result = "*********************************************************************************************************\n";
              result += "****************************Vypis vsetkych osob, ktoré maju trvaly pobyt v nehnutelnosti**********\n" +
                        "         Katastralne uzemie: " + supisneCislo + ", id kat uzemia"+ idKatastralnehoUzemia + ", list vlastnictva:" + idListVlastnictva + "\n\n";
        KatastralneUzemieId localKatastralneUzemie;
        localKatastralneUzemie = (KatastralneUzemieId) katUzemieIdTreap.search(new KatastralneUzemieId(new KatastralneUzemie(idKatastralnehoUzemia, null, null)));

        if(localKatastralneUzemie!=null){//najdene katastralne uzemie
            //variables
            Treap listNehnutelnosti;
            Nehnutelnost localN;
            //search nehnutelnost
            listNehnutelnosti = localKatastralneUzemie.getDataReference().getListNehnutelnost();
            localN = ((NehnutelnostSupisneCislo)listNehnutelnosti.search(new NehnutelnostSupisneCislo(new Nehnutelnost(supisneCislo,null,null)))).getDataReference();
            //search vsekych obcanov kt maju trvaly pobyt v danej nehnutelnosti
            String adresaNehnutelnosti = localN.getAdresa();
            OsobaTrvalyPobyt osobaTrvalyPobyt = (OsobaTrvalyPobyt) OsobyTrvalePobytTreap.search(new OsobaTrvalyPobyt(new Osoba(null, null, adresaNehnutelnosti)));
            // inorder vypis vsetkych osob s touto adresou
            result += "Osoby ktore maju trvaly pobyt v nehnutelnosti s adresou: " + adresaNehnutelnosti + "\n\n";
            InOrderIterator inOrderIterator = new InOrderIterator(osobaTrvalyPobyt);
            OsobaTrvalyPobyt localOsoba;
            while (inOrderIterator.hasNext()){
                localOsoba = (OsobaTrvalyPobyt) inOrderIterator.next();
                if(localOsoba.getDataReference().getTrvalyPobyt().compareToIgnoreCase(adresaNehnutelnosti)==0){
                    result += localOsoba.toString() + "\n";
                }

            }
            result += "\n*********************************************************************************************************\n";

        }

        return result;
    }


    public static void main(String[] args){
        new Operation3();
    }
}
