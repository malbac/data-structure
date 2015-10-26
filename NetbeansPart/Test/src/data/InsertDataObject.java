package data;

import structure.classes.*;
import structure.searchIndex.*;

/**
 * Created by Malbac on 25.10.2015.
 */
public class InsertDataObject {
    DataManager dataManager;

    public InsertDataObject(DataManager dataManager){
        this.dataManager = dataManager;
        naplnData();
    }

    public void naplnData(){

        naplnKatastralnyUrad();
        naplnKatastralneUzemie();
        naplnListVlastnictva();
        naplnNehnutelnost();
        naplnOsoba();
        naplnPodiel();
    }
    private void naplnKatastralnyUrad() {
        dataManager.insertKatastralnyUrad(1);
    }

    private void naplnKatastralneUzemie() {
        dataManager.insertKatastralneUzemie(1,1,"Bytca");
        dataManager.insertKatastralneUzemie(1,2,"Zilina");
    }

    private void naplnListVlastnictva() {
        dataManager.insertListVlastnictva("Bytca",1);
        dataManager.insertListVlastnictva("Zilina",2);
    }

    private void naplnNehnutelnost() {
        dataManager.insertNehnutelnost(1,1,"Mala Bytca 100");
        dataManager.insertNehnutelnost(2,1,"Mala Bytca 175");
        dataManager.insertNehnutelnost(3,1,"Mala Bytca 60");

        dataManager.insertNehnutelnost(4,2,"Vrutky 1");
    }

    private void naplnOsoba() {
        dataManager.insertOsoba("1111","Martin Malobicky","Mala Bytca");
        dataManager.insertOsoba("1112","Erik Malobicky","Mala Bytca");
    }


    private void naplnPodiel() {
        dataManager.insertPodiel(1,"1111",1,100);// vyries podiel, aby sa vypocitaval automaticky
        dataManager.insertPodiel(1,"1111",2,100);// vyries podiel, aby sa vypocitaval automaticky
        dataManager.insertPodiel(1,"1111",3,100);// vyries podiel, aby sa vypocitaval automaticky
        dataManager.insertPodiel(2,"1112",1,100);// vyries podiel, aby sa vypocitaval automaticky
    }














}
