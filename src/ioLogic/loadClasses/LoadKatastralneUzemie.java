package ioLogic.loadClasses;

import data.DataManager;
import structure.classes.KatastralneUzemie;

/**
 * Created by Malbac on 28.10.2015.
 */
public class LoadKatastralneUzemie extends LoadInsertTemplate {




    @Override
    public void proceedLine(String[] line, DataManager dataManager) {
        if(line.length==3){//mnozstvo premennych pri katastralnom urade
            dataManager.insertKatastralneUzemie(Integer.parseInt(line[0]), Integer.parseInt(line[1]),line[2]);
            System.out.println("KatastralneUzemie LOADED");
        }
    }
}
