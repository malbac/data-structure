package dataLogic.operations;

import data.DataManager;
import data.DataStateEntity;
import data.implementation.treap.Treap;
import structure.classes.*;
import structure.searchIndex.KatastralneUzemieId;
import structure.searchIndex.ListVlastnictvaId;
import structure.searchIndex.NehnutelnostSupisneCislo;
import structure.searchIndex.OsobaRodCislo;

import java.util.LinkedList;

/**
 * Created by Malbac on 23.10.2015.
 */
public class Operation13 {

    Treap osobaRodCisloTreap;
    Treap katUzemieIdTreap;
    DataManager dataManager;

    public Operation13(DataManager dataManager) {

        this.dataManager = dataManager;

        osobaRodCisloTreap = dataManager.getListOsobaPodlaRodneCislo();
        katUzemieIdTreap = dataManager.getListKatastralneUzemiePodlaId();
        //System.out.println(vypisNehnutelnostiPodlaKatUzemia("Zilina"));


    }


    public String odstranenieMajetkovehoPodielu(String rodneCislo, int idKatastralnehoUzemia, int idListVlastnictva, int supisneCislo) {
        String result = "*********************************************************************************************************\n";
        result += "****************************Zmena majite¾a (definovaný rodným èíslom) nehnute¾nosti**********\n";


        OsobaRodCislo osobaRodCisloNovyMajitel;
        Osoba novyMajitel;
        ListVlastnictvaId listVlastnictvaId;
        NehnutelnostSupisneCislo nehnutelnostSupisneCislo;

        // najdenie osoby, kt budeme vkladat
        osobaRodCisloNovyMajitel = (OsobaRodCislo) osobaRodCisloTreap.search(new OsobaRodCislo(new Osoba(rodneCislo, null, null)));

        if (osobaRodCisloNovyMajitel == null) {
            return "Rodne cislo noveho majitela nie je v databaze";
        }
        novyMajitel = osobaRodCisloNovyMajitel.getDataReference();

        // najdenie katastralneho uzemia
        KatastralneUzemieId katastralneUzemieId;
        katastralneUzemieId = (KatastralneUzemieId) katUzemieIdTreap.search(new KatastralneUzemieId(new KatastralneUzemie(idKatastralnehoUzemia, null, null)));
        if (katastralneUzemieId == null) {
            return "Nebolo najdene zadane kat. uzemie";
        }
        Treap treapListListovVlastnictva = katastralneUzemieId.getDataReference().getListListovVlastnictva();
        // najdenie listu vlastnictva v ktorom je hladana nehnutelnost
        listVlastnictvaId = (ListVlastnictvaId) treapListListovVlastnictva.search(new ListVlastnictvaId(new ListVlastnictva(idListVlastnictva, null)));
        Treap listNehnutelnostiVListeV = listVlastnictvaId.getDataReference().getListNehnutelnost();
        // v najdenom liste vlastnictva hladame nehnutelnost

        nehnutelnostSupisneCislo = (NehnutelnostSupisneCislo) listNehnutelnostiVListeV.search(new NehnutelnostSupisneCislo(new Nehnutelnost(supisneCislo, null, null)));
        if (nehnutelnostSupisneCislo == null) {
            return "zadane katastralne uzemie neobsahuje nehnutelnost";
        }


        // v nehnutelnosti najdem podiel, ktory patri hladanej osobe
        LinkedList listPodiely = nehnutelnostSupisneCislo.getDataReference().getListPodiely();
        Podiel podielToDelete;
        // key data o podiely
        int idPodiel = -1;
        int velkostPodieluDelete = -1;

        for(int i = 0;i<listPodiely.size();i++){
            podielToDelete = (Podiel) listPodiely.get(i);
            if(podielToDelete.getMajitel().getRodneCislo().equalsIgnoreCase(rodneCislo) &&
                    podielToDelete.getNehnutelnost().getIdSupisneCislo()==supisneCislo){
                //nasli sme podiel, ktory treba odstranit
                idPodiel = podielToDelete.getId_podiel();
                velkostPodieluDelete = podielToDelete.getPodiel();
            }
        }

        if(idPodiel!=-1 && velkostPodieluDelete!=-1){
            //hodnoty kluca sa nasli
            dataManager.removePodiel(idPodiel, rodneCislo, supisneCislo, velkostPodieluDelete);
        }



        return "Uspesne vymazane";
    }

}
