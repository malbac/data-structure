package data;

import data.implementation.InOrderIterator;
import data.implementation.treap.TNode;
import data.implementation.treap.Treap;
import structure.classes.*;
import structure.searchIndex.*;

import java.util.LinkedList;

/**
 * Created by Malbac on 25.10.2015.
 */
public class DataManager {

    private Treap listKatastralnyUrad;
    private Treap listKatastralneUzemiePodlaNazov;


    private Treap listKatastralneUzemiePodlaId;
    private Treap listListVlastnictva;
    private Treap listNehnutelnostPodlaSupC;


    private Treap listNehnutelnostPodlaAdresa;
    private Treap listPodiel;
    private Treap listOsobaPodlaRodneCislo;


    private Treap listOsobaPodlaTrvalyPobyt;

    public DataManager() {
        listKatastralnyUrad = new Treap();
        listKatastralneUzemiePodlaNazov = new Treap();
        listKatastralneUzemiePodlaId = new Treap();
        listListVlastnictva = new Treap();
        listNehnutelnostPodlaSupC = new Treap();
        listNehnutelnostPodlaAdresa = new Treap();
        listPodiel = new Treap();
        listOsobaPodlaRodneCislo = new Treap();
        listOsobaPodlaTrvalyPobyt = new Treap();

        //new InsertDataObject(this);
    }


    public Treap getListKatastralnyUrad() {
        return listKatastralnyUrad;
    }

    public Treap getListKatastralneUzemiePodlaNazov() {
        return listKatastralneUzemiePodlaNazov;
    }

    public Treap getListListVlastnictva() {
        return listListVlastnictva;
    }

    public Treap getListNehnutelnostPodlaSupC() {
        return listNehnutelnostPodlaSupC;
    }

    public Treap getListPodiel() {
        return listPodiel;
    }

    public Treap getListOsobaPodlaRodneCislo() {
        return listOsobaPodlaRodneCislo;
    }


    public Treap getListKatastralneUzemiePodlaId() {
        return listKatastralneUzemiePodlaId;
    }

    public Treap getListNehnutelnostPodlaAdresa() {
        return listNehnutelnostPodlaAdresa;
    }

    public Treap getListOsobaPodlaTrvalyPobyt() {
        return listOsobaPodlaTrvalyPobyt;
    }

    //=====INSERT PART==============

    public boolean insertKatastralnyUrad(int idUradu) {
        return listKatastralnyUrad.insert(new KatastralnyUradId(new KatastralnyUrad(idUradu)));
    }

    public boolean insertKatastralneUzemie(int idUradu, int idKatastralneUzemie, String nazovKatastralnehoUzemia) {
        KatastralnyUradId katastralnyUradId = (KatastralnyUradId) listKatastralnyUrad.search(new KatastralnyUradId(new KatastralnyUrad(idUradu)));
        KatastralnyUrad katastralnyUrad = katastralnyUradId.getDataReference();
        KatastralneUzemie insertedKatastralneUzemie = new KatastralneUzemie(idKatastralneUzemie, katastralnyUrad, nazovKatastralnehoUzemia);
        //====DIFFERENT LIST
        listKatastralneUzemiePodlaId.insert(new KatastralneUzemieId(insertedKatastralneUzemie));
        return listKatastralneUzemiePodlaNazov.insert(new KatastralneUzemieNazov(insertedKatastralneUzemie));
    }

    public boolean insertListVlastnictva(int idListVlastnictva, String nazovKatastralnehoUzemie) {
        KatastralneUzemieNazov katastralneUzemieNazov = (KatastralneUzemieNazov) listKatastralneUzemiePodlaNazov.search(new KatastralneUzemieNazov(new KatastralneUzemie(0, null, nazovKatastralnehoUzemie)));
        KatastralneUzemie katastralneUzemie = katastralneUzemieNazov.getDataReference();
        ListVlastnictva inserteListVlastnictva = new ListVlastnictva(idListVlastnictva, katastralneUzemie);
        //====DIFFERENT LIST
        insertToMainListVlastnictva(inserteListVlastnictva);
        insertToListInKatastraneUzemie(katastralneUzemie, inserteListVlastnictva);
        return true;
    }

    public boolean insertListVlastnictva(int idListVlastnictva, int idKatastralnehoUzemie) {
        KatastralneUzemieId katastralneUzemieId = (KatastralneUzemieId) listKatastralneUzemiePodlaId.search(new KatastralneUzemieId(new KatastralneUzemie(idKatastralnehoUzemie,null,null)));
        if(katastralneUzemieId!=null) {
            KatastralneUzemie katastralneUzemie = katastralneUzemieId.getDataReference();
            ListVlastnictva inserteListVlastnictva = new ListVlastnictva(idListVlastnictva, katastralneUzemie);
            //====DIFFERENT LIST
            insertToMainListVlastnictva(inserteListVlastnictva);
            insertToListInKatastraneUzemie(katastralneUzemie, inserteListVlastnictva);
            return true;
        } else {
            return false;
        }
    }


    public boolean insertNehnutelnost(int idSupisneCislo, int idListVlastnictva, String adresa) {

        ListVlastnictvaId ListVlastnictvaId = (ListVlastnictvaId) listListVlastnictva.search(new ListVlastnictvaId(new ListVlastnictva(idListVlastnictva, null)));
        if(ListVlastnictvaId!=null) {
            ListVlastnictva listVlastnictva = ListVlastnictvaId.getDataReference();


            Nehnutelnost insertedNehnutelnost = new Nehnutelnost(idSupisneCislo, listVlastnictva, adresa);
            //====DIFFERENT LIST
            insertToMainListNehnutelnostPodlaSupisnehoCisla(insertedNehnutelnost);
            insertToMainListNehnutelnostPodlaAdresa(insertedNehnutelnost);
            insertNehnutelnostToListInListVlastnictva(ListVlastnictvaId, insertedNehnutelnost);
            insertNehnutelnostToListInListKatastralneUzemie(ListVlastnictvaId, insertedNehnutelnost);
            return true;
        } else {
            return false;
        }
    }


    public boolean insertOsoba(String rodneCislo, String menoPriezvisko, String trvalyPobyt) {
        Osoba insetedOsoba = new Osoba(rodneCislo, menoPriezvisko, trvalyPobyt);
        //====DIFFERENT LIST
        insertOsobaToMainListOsobaPodlaAdresa(insetedOsoba);
        return insertOsobaToMainListOsobaPodlaRodneCislo(insetedOsoba);
    }


    public boolean insertPodiel(int idPodiel, String rodneCisloPodielnika, int supisneCisloNehnutelnosti, int velkostPodielu) {
        OsobaRodCislo osobaRodCislo = (OsobaRodCislo) listOsobaPodlaRodneCislo.search(new OsobaRodCislo(new Osoba(rodneCisloPodielnika, null, null)));
        Osoba majitel = osobaRodCislo.getDataReference();

        NehnutelnostSupisneCislo nehnutelnostSupisneCislo = (NehnutelnostSupisneCislo) listNehnutelnostPodlaSupC.search(new NehnutelnostSupisneCislo(new Nehnutelnost(supisneCisloNehnutelnosti, null, null)));
        Nehnutelnost nehnutelnost = nehnutelnostSupisneCislo.getDataReference();
        //====NOVY PODIEL====
        Podiel insertedPodiel = new Podiel(idPodiel, majitel, nehnutelnost, velkostPodielu);

        //====DIFFERENT LIST
        insertPodielToMainListPodiel(insertedPodiel);
        insertPodielToListInOsoba(insertedPodiel, majitel);
        insertPodielToListInNehnutelnost(insertedPodiel, nehnutelnost);

        updatePodiely(nehnutelnost);

        return true;
    }


    //=====REMOVE PART==============
    public boolean removeKatastralnyUrad(int idUradu) {
        listKatastralnyUrad.remove(new KatastralnyUradId(new KatastralnyUrad(idUradu)));
        return true;
    }

    public boolean removeKatastralneUzemie(int idUradu, int idKatastralneUzemie, String nazovKatastralnehoUzemia) {
        KatastralnyUradId katastralnyUradId = (KatastralnyUradId) listKatastralnyUrad.search(new KatastralnyUradId(new KatastralnyUrad(idUradu)));
        KatastralnyUrad katastralnyUrad = katastralnyUradId.getDataReference();
        KatastralneUzemie deletedKatastralneUzemie = new KatastralneUzemie(idKatastralneUzemie, katastralnyUrad, nazovKatastralnehoUzemia);
        //====REMOVE BACK REFERENCE FROM LIST VLASTNICTVA
        removeBackReferenceKatUzFromListVlastnictva(deletedKatastralneUzemie);
        //====DIFFERENT LIST
        listKatastralneUzemiePodlaId.remove(new KatastralneUzemieId(deletedKatastralneUzemie));
        return listKatastralneUzemiePodlaNazov.remove(new KatastralneUzemieNazov(deletedKatastralneUzemie));


    }

    private void removeBackReferenceKatUzFromListVlastnictva(KatastralneUzemie deletedKatastralneUzemie) {
        KatastralneUzemieId katastralneUzemieId = (KatastralneUzemieId) listKatastralneUzemiePodlaId.search(new KatastralneUzemieId(deletedKatastralneUzemie));
        Treap listListovVlastnictva = katastralneUzemieId.getDataReference().getListListovVlastnictva();
        TNode rootListListovTreap = listListovVlastnictva.getRoot();
        InOrderIterator inOrderIterator = new InOrderIterator(rootListListovTreap);
        // while
        ListVlastnictvaId listVlastnictvaId;
        ListVlastnictva listVlastnictva;
        while (inOrderIterator.hasNext()) {
            listVlastnictvaId = (ListVlastnictvaId) inOrderIterator.next();
            listVlastnictva = listVlastnictvaId.getDataReference();
            if (listVlastnictva.getKatastralneUzemie().equals(deletedKatastralneUzemie)) {//ak je to rovnaky objekt, nasiel som platny backreference
                listVlastnictva.setKatastralneUzemie(null);
            }
        }
    }

    public boolean removeListVlastnictva(int idListVlastnictva, String nazovKatastralnehoUzemie) {
        KatastralneUzemieNazov katastralneUzemieNazov = (KatastralneUzemieNazov) listKatastralneUzemiePodlaNazov.search(new KatastralneUzemieNazov(new KatastralneUzemie(0, null, nazovKatastralnehoUzemie)));
        KatastralneUzemie katastralneUzemie = katastralneUzemieNazov.getDataReference();
        ListVlastnictva deletedListVlastnictva = new ListVlastnictva(idListVlastnictva, katastralneUzemie);
        //====DIFFERENT LIST
        deleteFromMainListVlastnictva(deletedListVlastnictva);
        deleteFromListInKatastraneUzemie(katastralneUzemie, deletedListVlastnictva);
        return true;
    }


    public boolean removeNehnutelnost(int idSupisneCislo, int idListVlastnictva, String adresa) {

        ListVlastnictvaId ListVlastnictvaId = (ListVlastnictvaId) listListVlastnictva.search(new ListVlastnictvaId(new ListVlastnictva(idListVlastnictva, null)));
        ListVlastnictva listVlastnictva = ListVlastnictvaId.getDataReference();


        Nehnutelnost insertedNehnutelnost = new Nehnutelnost(idSupisneCislo, listVlastnictva, adresa);
        //====DIFFERENT LIST
        removeFromMainListNehnutelnostPodlaSupisnehoCisla(insertedNehnutelnost);
        removeFromMainListNehnutelnostPodlaAdresa(insertedNehnutelnost);
        removeFromNehnutelnostToListInListVlastnictva(ListVlastnictvaId, insertedNehnutelnost);
        removeFromNehnutelnostToListInListKatastralneUzemie(ListVlastnictvaId, insertedNehnutelnost);
        return true;
    }

    public boolean removeOsoba(String rodneCislo, String menoPriezvisko, String trvalyPobyt) {
        Osoba insetedOsoba = new Osoba(rodneCislo, menoPriezvisko, trvalyPobyt);
        //====DIFFERENT LIST
        removeOsobaFromMainListOsobaPodlaAdresa(insetedOsoba);
        return removeOsobaFromMainListOsobaPodlaRodneCislo(insetedOsoba);
    }

    public boolean removePodiel(int idPodiel, String rodneCisloPodielnika, int supisneCisloNehnutelnosti, int velkostPodielu) {
        OsobaRodCislo osobaRodCislo = (OsobaRodCislo) listOsobaPodlaRodneCislo.search(new OsobaRodCislo(new Osoba(rodneCisloPodielnika, null, null)));
        Osoba majitel = osobaRodCislo.getDataReference();

        NehnutelnostSupisneCislo nehnutelnostSupisneCislo = (NehnutelnostSupisneCislo) listNehnutelnostPodlaSupC.search(new NehnutelnostSupisneCislo(new Nehnutelnost(supisneCisloNehnutelnosti, null, null)));
        Nehnutelnost nehnutelnost = nehnutelnostSupisneCislo.getDataReference();
        //====PODIEL  NA VYMAZANIE====
        Podiel insertedPodiel = new Podiel(idPodiel, majitel, nehnutelnost, velkostPodielu);

        //====DIFFERENT LIST
        removePodielFromMainListPodiel(insertedPodiel);
        removePodielFromListInOsoba(insertedPodiel, majitel);
        removePodielFromListInNehnutelnost(insertedPodiel, nehnutelnost);

        updatePodiely(nehnutelnost);

        return true;
    }


    //=====IMPLEMENTATION METHODS PART==============
    //-----LIST VLASTNICTVA -----------------------------
    private boolean insertToMainListVlastnictva(ListVlastnictva listVlastnictva) {
        return listListVlastnictva.insert(new ListVlastnictvaId(listVlastnictva));
    }

    private void insertToListInKatastraneUzemie(KatastralneUzemie katastralneUzemie, ListVlastnictva listVlastnictva) {
        KatastralneUzemieNazov localKUN = (KatastralneUzemieNazov) listKatastralneUzemiePodlaNazov.search(new KatastralneUzemieNazov(katastralneUzemie));
        localKUN.getDataReference().addListVlastnictva(listVlastnictva);
    }

    //---------------------REMOVE-PART------------------------------
    private void deleteFromListInKatastraneUzemie(KatastralneUzemie katastralneUzemie, ListVlastnictva listVlastnictva) {
        KatastralneUzemieNazov localKUN = (KatastralneUzemieNazov) listKatastralneUzemiePodlaNazov.search(new KatastralneUzemieNazov(katastralneUzemie));
        localKUN.getDataReference().removeListVlastnictva(new ListVlastnictvaId(listVlastnictva));
    }

    private boolean deleteFromMainListVlastnictva(ListVlastnictva listVlastnictva) {
        return listListVlastnictva.remove(new ListVlastnictvaId(listVlastnictva));
    }

    //-----NEHNUTELNOST -----------------------------
    private boolean insertToMainListNehnutelnostPodlaSupisnehoCisla(Nehnutelnost insertedNehnutelnost) {
        return listNehnutelnostPodlaSupC.insert(new NehnutelnostSupisneCislo(insertedNehnutelnost));
    }

    private boolean insertToMainListNehnutelnostPodlaAdresa(Nehnutelnost insertedNehnutelnost) {
        return listNehnutelnostPodlaAdresa.insert(new NehnutelnostAdresa(insertedNehnutelnost));
    }

    private void insertNehnutelnostToListInListVlastnictva(ListVlastnictvaId listVlastnictvaId, Nehnutelnost insertedNehnutelnost) {
        listVlastnictvaId.getDataReference().addNehnutelnostToListNehnutelnost(insertedNehnutelnost);
    }

    private void insertNehnutelnostToListInListKatastralneUzemie(ListVlastnictvaId listVlastnictvaId, Nehnutelnost insertedNehnutelnost) {
        listVlastnictvaId.getDataReference().getKatastralneUzemie().addNehnutelnost(insertedNehnutelnost);
    }

    //---------------------REMOVE-PART------------------------------
    private boolean removeFromMainListNehnutelnostPodlaSupisnehoCisla(Nehnutelnost insertedNehnutelnost) {
        return listNehnutelnostPodlaSupC.remove(new NehnutelnostSupisneCislo(insertedNehnutelnost));
    }

    private boolean removeFromMainListNehnutelnostPodlaAdresa(Nehnutelnost insertedNehnutelnost) {
        return listNehnutelnostPodlaAdresa.remove(new NehnutelnostAdresa(insertedNehnutelnost));
    }

    private void removeFromNehnutelnostToListInListVlastnictva(ListVlastnictvaId listVlastnictvaId, Nehnutelnost insertedNehnutelnost) {
        listVlastnictvaId.getDataReference().removeNehnutelnostFromListNehnutelnost(insertedNehnutelnost);
    }

    private void removeFromNehnutelnostToListInListKatastralneUzemie(ListVlastnictvaId listVlastnictvaId, Nehnutelnost insertedNehnutelnost) {
        listVlastnictvaId.getDataReference().getKatastralneUzemie().removeNehnutelnost(new NehnutelnostSupisneCislo(insertedNehnutelnost));
    }

    //-----OSOBA -----------------------------
    private boolean insertOsobaToMainListOsobaPodlaAdresa(Osoba insetedOsoba) {
        return listOsobaPodlaTrvalyPobyt.insert(new OsobaTrvalyPobyt(insetedOsoba));
    }

    private boolean insertOsobaToMainListOsobaPodlaRodneCislo(Osoba insetedOsoba) {
        return listOsobaPodlaRodneCislo.insert(new OsobaRodCislo(insetedOsoba));
    }

    //---------------------REMOVE-PART------------------------------
    private boolean removeOsobaFromMainListOsobaPodlaAdresa(Osoba insetedOsoba) {
        return listOsobaPodlaTrvalyPobyt.remove(new OsobaTrvalyPobyt(insetedOsoba));
    }

    private boolean removeOsobaFromMainListOsobaPodlaRodneCislo(Osoba insetedOsoba) {
        return listOsobaPodlaRodneCislo.remove(new OsobaRodCislo(insetedOsoba));
    }


    //-----PODIEL -----------------------------
    private void insertPodielToListInNehnutelnost(Podiel insertedPodiel, Nehnutelnost nehnutelnost) {
        nehnutelnost.addToListPodiely(insertedPodiel);
    }

    private void insertPodielToListInOsoba(Podiel insertedPodiel, Osoba majitel) {
        majitel.addToListPodiely(insertedPodiel);
    }

    private boolean insertPodielToMainListPodiel(Podiel insertedPodiel) {
        return listPodiel.insert(new PodielId(insertedPodiel));
    }

    //---------------------REMOVE-PART------------------------------
    private void removePodielFromListInNehnutelnost(Podiel insertedPodiel, Nehnutelnost nehnutelnost) {
        nehnutelnost.removeToListPodiely(insertedPodiel);
    }

    private void removePodielFromListInOsoba(Podiel insertedPodiel, Osoba majitel) {
        majitel.removeFromListPodiely(insertedPodiel);
    }

    private boolean removePodielFromMainListPodiel(Podiel insertedPodiel) {
        return listPodiel.remove(new PodielId(insertedPodiel));
    }


    private void updatePodiely(Nehnutelnost nehnutelnost) {
        LinkedList<Podiel> localPodiely = nehnutelnost.getListPodiely();
        int pocetPodielov = localPodiely.size();
        int podiel = 100 / pocetPodielov;

        for (int i = 0; i < pocetPodielov; i++) {
            localPodiely.get(i).setPodiel(podiel);
        }

    }

    //**********Vypisy*//***////////////////

    public String vypisListVlastnictva() {
        String result = "*******************************************************\n";
        result += "Vypis Listov Vlastnictva\n\nIdList , IdKatUzemie\n\n";
        LinkedList<TNode> list = getListListVlastnictva().inorderTraversal();
        ListVlastnictva local;
        for (int i = 0; i < list.size(); i++) {
            local = ((ListVlastnictvaId) list.get(i)).getDataReference();
            result += local.getIdListVlastnictva() + "  ," + local.getKatastralneUzemie().getIdKatastralneUzemie() + "\n";
        }
        return result;
    }

    public String vypisKatastralnychUzemi() {
        String result = "*******************************************************\n";
        result += "Vypis KatUzemi\n" +
                "nazov , idKatUzemia\n";
        LinkedList<TNode> list = getListKatastralneUzemiePodlaNazov().inorderTraversal();
        KatastralneUzemie local;
        for (int i = 0; i < list.size(); i++) {
            local = ((KatastralneUzemieNazov) list.get(i)).getDataReference();
            result += local.getNazovKatastralnehoUzemia() + ", " + local.getIdKatastralneUzemie() + "\n";
        }
        return result;
    }

    public String vypisOsob() {
        String result = "String result = \"*******************************************************\n";
        result += "Vypis \nOsob, rodne cislo, trvaly pobyt, sup cislo trv. pobytu\n\n";
        LinkedList<TNode> list = getListOsobaPodlaRodneCislo().inorderTraversal();
        Osoba local;
        for (int i = 0; i < list.size(); i++) {
            local = ((OsobaRodCislo) list.get(i)).getDataReference();
            result += local.getMenoPriezvisko() + ",  " + local.getRodneCislo() + ", " + local.getTrvalyPobyt() + "\n";
        }
        return result;
    }

    public String vypisNehnutelnosti() {
        String result = "*******************************************************\n";
        result += "Vypis nehnutelnosti\nSupcislo, get adresa, list vlastnictva, kat uzemie\n";
        LinkedList<TNode> list = getListNehnutelnostPodlaSupC().inorderTraversal();
        Nehnutelnost local;
        for (int i = 0; i < list.size(); i++) {
            local = ((NehnutelnostSupisneCislo) list.get(i)).getDataReference();
            result += local.getIdSupisneCislo() + ", " + local.getAdresa() + ", " + local.getListVlastnictva().getIdListVlastnictva() + ", " + local.getListVlastnictva().getKatastralneUzemie().getNazovKatastralnehoUzemia() + "\n";
        }
        return result;
    }

    public String vypisKatastralnychUradov() {
        String result = "*******************************************************\n";
        result += "Vypis Katastralne urady\n\n";
        LinkedList<TNode> list = getListKatastralnyUrad().inorderTraversal();
        KatastralnyUrad local;
        for (int i = 0; i < list.size(); i++) {
            local = ((KatastralnyUradId) list.get(i)).getDataReference();
            result += local.getId_uradu() + "\n";
        }
        return result;
    }

    public String vypisPodielov() {
        String result = "*******************************************************\n";
        result += "Vypis podiely\n" +
                "idPodiel, majitel, supisCislo,velkost Podielu\n";
        LinkedList<TNode> list = getListPodiel().inorderTraversal();
        Podiel local;
        for (int i = 0; i < list.size(); i++) {
            local = ((PodielId) list.get(i)).getDataReference();
            result += local.getId_podiel() + ", " + local.getMajitel().getMenoPriezvisko() + ", " + local.getNehnutelnost().getIdSupisneCislo() + ", " + local.getPodiel() + "\n";
        }
        return result;
    }


}
