package dataLogic.operations;

import data.DataManager;
import data.DataStateEntity;
import data.implementation.treap.Treap;
import structure.classes.KatastralneUzemie;
import structure.classes.Nehnutelnost;
import structure.classes.Osoba;
import structure.classes.Podiel;
import structure.searchIndex.KatastralneUzemieId;
import structure.searchIndex.KatastralneUzemieNazov;
import structure.searchIndex.NehnutelnostSupisneCislo;
import structure.searchIndex.OsobaRodCislo;

import java.util.LinkedList;

/**
 * Created by Malbac on 23.10.2015.
 * 11. Zmena majite�a (definovan� rodn�m ��slom) nehnute�nosti (definovan� s�pisn�m
 ��slom) v zadanom katastr�lnom �zem� (definovan� jeho ��slom). Nov� majite� je
 definovan� rodn�m ��slom.
 */
public class Operation11 {

    Treap osobaRodCisloTreap;
    Treap katUzemieNazovTreap;
    DataManager dataManager;

    public Operation11(){

        dataManager =  DataStateEntity.getDataManager();

        osobaRodCisloTreap = dataManager.getListOsobaPodlaRodneCislo();
        katUzemieNazovTreap = dataManager.getListKatastralneUzemiePodlaNazov();
        //System.out.println(vypisNehnutelnostiPodlaKatUzemia("Zilina"));


    }




    public String zmenaMajitelaNehnutelnosti(String stareRodneCislo,String noveRodneCislo, int supisneCislo,String nazovKatastralnehoUzemia){
        String result = "*********************************************************************************************************\n";
        result += "****************************Zmena majite�a (definovan� rodn�m ��slom) nehnute�nosti**********\n" +
                "         Supisne cislo: " + supisneCislo + ", nazov kat uzemia"+ nazovKatastralnehoUzemia + ", rodne cislo stareho majitela: " + stareRodneCislo + "\n\n";

        OsobaRodCislo osobaRodCisloNovyMajitel;
        Osoba novyMajitel;
        NehnutelnostSupisneCislo nehnutelnostSupisneCislo;

        // najdenie osoby, kt budeme vkladat
        osobaRodCisloNovyMajitel = (OsobaRodCislo) osobaRodCisloTreap.search(new OsobaRodCislo(new Osoba(noveRodneCislo,null,null)));

        if(osobaRodCisloNovyMajitel==null){
            return "Rodne cislo noveho majitela nie je v databaze";
        }
        novyMajitel = osobaRodCisloNovyMajitel.getDataReference();

        // najdenie nehnutelnosti ktorej zmenime majitela
        KatastralneUzemieNazov katastralneUzemieNazov;
        katastralneUzemieNazov = (KatastralneUzemieNazov) katUzemieNazovTreap.search(new KatastralneUzemieNazov(new KatastralneUzemie(-1,null,nazovKatastralnehoUzemia)));
        if(katastralneUzemieNazov==null){
            return "Nebolo najdene zadane kat. uzemie";
        }
        Treap treapNehnutelnost = katastralneUzemieNazov.getDataReference().getListNehnutelnost();

        // mame nehnutelnost z ktorej zoberieme adresu a tu priradime najdenej osobe
        nehnutelnostSupisneCislo = (NehnutelnostSupisneCislo) treapNehnutelnost.search(new NehnutelnostSupisneCislo(new Nehnutelnost(supisneCislo,null,null)));
        if(nehnutelnostSupisneCislo==null){
            return "zadane katastralne uzemie neobsahuje nehnutelnost";
        }
        // v nehnutelnosti najdem podiel, ktory patri hladanej osobe
        LinkedList listPodiely = nehnutelnostSupisneCislo.getDataReference().getListPodiely();
        Podiel localPodiel;
        String potencionalnyHladanyMajitelRodC;
        for(int i = 0;i<listPodiely.size();i++){
            localPodiel = (Podiel) listPodiely.get(i);
            potencionalnyHladanyMajitelRodC = localPodiel.getMajitel().getRodneCislo();
            if(potencionalnyHladanyMajitelRodC.equalsIgnoreCase(stareRodneCislo)){
                //nasli sme podiel hladanej osoby
                //pripiseme tento podiel novemu majitelovi
                localPodiel.setMajitel(novyMajitel);
            }
        }




        return "Uspesne vlozene";
    }



    public static void main(String[] args){
        new Operation11();
    }
}
