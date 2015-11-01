package dataLogic.operations;

import data.DataManager;
import data.DataStateEntity;
import data.implementation.treap.Treap;
import structure.classes.*;
import structure.searchIndex.*;

import java.util.LinkedList;

/**
 * Created by Malbac on 23.10.2015.
 */
public class Operation12 {

    Treap osobaRodCisloTreap;
    Treap katUzemieIdTreap;
    DataManager dataManager;

    public Operation12(){

        dataManager =  DataStateEntity.getDataManager();

        osobaRodCisloTreap = dataManager.getListOsobaPodlaRodneCislo();
        katUzemieIdTreap = dataManager.getListKatastralneUzemiePodlaId();
        //System.out.println(vypisNehnutelnostiPodlaKatUzemia("Zilina"));


    }




    public String zapisanieMajetkovehoPodielu(String rodneCislo,int idKatastralnehoUzemia, int idListVlastnictva,int supisneCislo, int velkostPodielu){
        String result = "*********************************************************************************************************\n";
        result += "****************************Zmena majite¾a (definovaný rodným èíslom) nehnute¾nosti**********\n";



        OsobaRodCislo osobaRodCisloNovyMajitel;
        Osoba novyMajitel;
        ListVlastnictvaId listVlastnictvaId;
        NehnutelnostSupisneCislo nehnutelnostSupisneCislo;

        // najdenie osoby, kt budeme vkladat
        osobaRodCisloNovyMajitel = (OsobaRodCislo) osobaRodCisloTreap.search(new OsobaRodCislo(new Osoba(rodneCislo,null,null)));

        if(osobaRodCisloNovyMajitel==null){
            return "Rodne cislo noveho majitela nie je v databaze";
        }
        novyMajitel = osobaRodCisloNovyMajitel.getDataReference();

        // najdenie katastralneho uzemia
        KatastralneUzemieId katastralneUzemieId;
        katastralneUzemieId = (KatastralneUzemieId) katUzemieIdTreap.search(new KatastralneUzemieId(new KatastralneUzemie(idKatastralnehoUzemia,null,null)));
        if(katastralneUzemieId==null){
            return "Nebolo najdene zadane kat. uzemie";
        }
        Treap treapListListovVlastnictva = katastralneUzemieId.getDataReference().getListListovVlastnictva();
        // najdenie listu vlastnictva v ktorom je hladana nehnutelnost
        listVlastnictvaId = (ListVlastnictvaId) treapListListovVlastnictva.search(new ListVlastnictvaId(new ListVlastnictva(idListVlastnictva,null)));
        Treap listNehnutelnostiVListeV = listVlastnictvaId.getDataReference().getListNehnutelnost();
        // v najdenom liste vlastnictva hladame nehnutelnost

        nehnutelnostSupisneCislo = (NehnutelnostSupisneCislo) listNehnutelnostiVListeV.search(new NehnutelnostSupisneCislo(new Nehnutelnost(supisneCislo,null,null)));
        if(nehnutelnostSupisneCislo==null){
            return "zadane katastralne uzemie neobsahuje nehnutelnost";
        }


        // v nehnutelnosti najdem podiel, ktory patri hladanej osobe
        LinkedList listPodiely = nehnutelnostSupisneCislo.getDataReference().getListPodiely();


        //zapisanie podielu
        int idPodiel = dataManager.getListPodiel().size() + 1;
        //int supisneCisloVkladane = nehnutelnostSupisneCislo.getDataReference().getIdSupisneCislo();
        dataManager.insertPodiel(idPodiel,rodneCislo,supisneCislo,velkostPodielu);




        return "Uspesne vlozene";
    }


    public static void main(String[] args){
        new Operation12();
    }
}
