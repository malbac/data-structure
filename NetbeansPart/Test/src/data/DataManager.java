package data;

import data.implementation.treap.Treap;
import structure.classes.*;
import structure.searchIndex.*;

import java.util.LinkedList;

/**
 * Created by Malbac on 25.10.2015.
 */
public class DataManager {

    private Treap listKatastralnyUrad;
    private Treap listKatastralneUzemie;
    private Treap listListVlastnictva;
    private Treap listNehnutelnost;
    private Treap listPodiel;
    private Treap listOsoba;
    private Treap listPodielnikovListV;

    public DataManager(){
       listKatastralnyUrad = new Treap();
       listKatastralneUzemie = new Treap();
       listListVlastnictva = new Treap();
       listNehnutelnost = new Treap();
       listPodiel = new Treap();
       listOsoba = new Treap();
       listPodielnikovListV = new Treap();

        new InsertDataObject(this);
    }



    public Treap getListKatastralnyUrad() {
        return listKatastralnyUrad;
    }

    public Treap getListKatastralneUzemie() {
        return listKatastralneUzemie;
    }

    public Treap getListListVlastnictva() {
        return listListVlastnictva;
    }

    public Treap getListNehnutelnost() {
        return listNehnutelnost;
    }

    public Treap getListPodiel() {
        return listPodiel;
    }

    public Treap getListOsoba() {
        return listOsoba;
    }

    public Treap getListPodielnikovListV() {
        return listPodielnikovListV;
    }




    //=====INSERT PART==============

    public boolean insertKatastralnyUrad(int idUradu){
        return listKatastralnyUrad.insert(new KatastralnyUradId(new KatastralnyUrad(idUradu)));
    }

    public boolean insertKatastralneUzemie(int idUradu,int idKatastralneUzemie, String nazovKatastralnehoUzemia){
        KatastralnyUradId katastralnyUradId = (KatastralnyUradId)listKatastralnyUrad.search(new KatastralnyUradId(new KatastralnyUrad(idUradu)));
        KatastralnyUrad katastralnyUrad = katastralnyUradId.getDataReference();
        KatastralneUzemie insertedKatastralneUzemie = new KatastralneUzemie(idKatastralneUzemie,katastralnyUrad,nazovKatastralnehoUzemia);
        //====DIFFERENT LIST
        return listKatastralneUzemie.insert(new KatastralneUzemieNazov(insertedKatastralneUzemie));
    }

    public boolean insertListVlastnictva(String nazovKatastralnehoUzemie,int idListVlastnictva){
        KatastralneUzemieNazov katastralneUzemieNazov = (KatastralneUzemieNazov)listKatastralneUzemie.search(new KatastralneUzemieNazov(new KatastralneUzemie(0,null,nazovKatastralnehoUzemie)));
        KatastralneUzemie katastralneUzemie = katastralneUzemieNazov.getDataReference();
        ListVlastnictva inserteListVlastnictva = new ListVlastnictva(idListVlastnictva,katastralneUzemie);
        //====DIFFERENT LIST
        insertToMainListVlastnictva(inserteListVlastnictva);
        insertToListInKatastraneUzemie(katastralneUzemie, inserteListVlastnictva);
        return true;
    }



    public boolean insertPodielnikListuVlastnictva(){

        return true;
    }

    public boolean insertNehnutelnost(int idSupisneCislo,int idListVlastnictva, String adresa){

        ListVlastnictvaId ListVlastnictvaId = (ListVlastnictvaId)listListVlastnictva.search(new ListVlastnictvaId(new ListVlastnictva(idListVlastnictva,null)));
        ListVlastnictva listVlastnictva = ListVlastnictvaId.getDataReference();


        Nehnutelnost insertedNehnutelnost = new Nehnutelnost(idSupisneCislo,listVlastnictva,adresa);
        //====DIFFERENT LIST
        insertToMainListNehnutelnost(insertedNehnutelnost);
        insertNehnutelnostToListInListVlastnictva(ListVlastnictvaId, insertedNehnutelnost);
        insertNehnutelnostToListInListKatastralneUzemie(ListVlastnictvaId, insertedNehnutelnost);
        return true;
    }

    private void insertNehnutelnostToListInListKatastralneUzemie(ListVlastnictvaId listVlastnictvaId, Nehnutelnost insertedNehnutelnost) {
        listVlastnictvaId.getDataReference().getKatastralneUzemie().addNehnutelnost(new NehnutelnostSupisneCislo(insertedNehnutelnost));
    }


    public boolean insertOsoba(String rodneCislo,String menoPriezvisko,String trvalyPobyt){
        Osoba insetedOsoba = new Osoba(rodneCislo,menoPriezvisko,trvalyPobyt);
        //====DIFFERENT LIST
        return listOsoba.insert(new OsobaRodCislo(insetedOsoba));
    }

    public boolean insertPodiel(int idPodiel,String rodneCisloPodielnika,int supisneCisloNehnutelnosti, int velkostPodielu){
        OsobaRodCislo osobaRodCislo = (OsobaRodCislo)listOsoba.search(new OsobaRodCislo(new Osoba(rodneCisloPodielnika,null,null)));
        Osoba majitel = osobaRodCislo.getDataReference();

        NehnutelnostSupisneCislo nehnutelnostSupisneCislo = (NehnutelnostSupisneCislo) listNehnutelnost.search(new NehnutelnostSupisneCislo(new Nehnutelnost(supisneCisloNehnutelnosti,null,null)));
        Nehnutelnost nehnutelnost = nehnutelnostSupisneCislo.getDataReference();
        //====NOVY PODIEL====
        Podiel insertedPodiel = new Podiel(idPodiel,majitel,nehnutelnost,velkostPodielu);

        //====DIFFERENT LIST
        insertPodielToMainListPodiel(insertedPodiel); //not implemented
        insertPodielToListInOsoba(insertedPodiel, majitel);
        insertPodielToListInNehnutelnost(insertedPodiel, nehnutelnost);

        updatePodiely(nehnutelnost);

        return true;
    }




    //=====REMOVE PART==============
    public boolean removeKatastralnyUrad(){
        return true;
    }

    public boolean removeKatastralneUzemie(){
        return true;
    }

    public boolean removeListVlastnictva(){
        return true;
    }

    public boolean removePodielnikListuVlastnictva(){
        return true;
    }

    public boolean removeNehnutelnost(){
        return true;
    }

    public boolean removeOsoba(){
        return true;
    }

    public boolean removePodiel(){
        return true;
    }

    //=====IMPLEMENTATION METHODS PART==============
    //-----LIST VLASTNICTVA -----------------------------
    private boolean insertToMainListVlastnictva(ListVlastnictva listVlastnictva) {
       return listListVlastnictva.insert(new ListVlastnictvaId(listVlastnictva));
    }

    private void insertToListInKatastraneUzemie(KatastralneUzemie katastralneUzemie,ListVlastnictva listVlastnictva) {
        KatastralneUzemieNazov localKUN = (KatastralneUzemieNazov)listKatastralneUzemie.search(new KatastralneUzemieNazov(katastralneUzemie));
        localKUN.getDataReference().addListVlastnictva(new ListVlastnictvaId(listVlastnictva));
    }

    //-----NEHNUTELNOST -----------------------------
    private boolean insertToMainListNehnutelnost(Nehnutelnost insertedNehnutelnost) {
        return listNehnutelnost.insert(new NehnutelnostSupisneCislo(insertedNehnutelnost));
    }

    private void insertNehnutelnostToListInListVlastnictva(ListVlastnictvaId listVlastnictvaId, Nehnutelnost insertedNehnutelnost) {
        listVlastnictvaId.getDataReference().addNehnutelnostToListNehnutelnost(insertedNehnutelnost);
    }
    //-----PODIEL -----------------------------
    private void insertPodielToListInNehnutelnost(Podiel insertedPodiel, Nehnutelnost nehnutelnost) {
        nehnutelnost.addToListPodiely(insertedPodiel);
    }

    private void insertPodielToListInOsoba(Podiel insertedPodiel, Osoba majitel) {
        majitel.addToListPodiely(insertedPodiel);
    }

    private void insertPodielToMainListPodiel(Podiel insertedPodiel) {

    }

    private void updatePodiely(Nehnutelnost nehnutelnost) {
        LinkedList<Podiel> localPodiely = nehnutelnost.getListPodiely();
        int pocetPodielov = localPodiely.size();
        int podiel = 100/pocetPodielov;

        for(int i = 0;i< pocetPodielov;i++){
            localPodiely.get(i).setPodiel(podiel);
        }

    }


}
