package ioLogic.loadClasses;

import data.DataManager;

/**
 * Created by Malbac on 28.10.2015.
 */
public class LoadOsoba extends LoadInsertTemplate{


    @Override
    public void proceedLine(String[] line, DataManager dataManager) {
        if(line.length==3){//mnozstvo premennych pri katastralnom urade
            dataManager.insertOsoba(line[0],line[1],line[2]);
            System.out.println("Osoba LOADED");
        }
    }
}
