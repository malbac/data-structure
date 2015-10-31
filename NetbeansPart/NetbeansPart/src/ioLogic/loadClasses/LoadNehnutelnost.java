package ioLogic.loadClasses;

import data.DataManager;

/**
 * Created by Malbac on 28.10.2015.
 */
public class LoadNehnutelnost extends LoadInsertTemplate {




    @Override
    public void proceedLine(String[] line, DataManager dataManager) {

        if(line.length==3){//mnozstvo premennych pri katastralnom urade
            dataManager.insertNehnutelnost(Integer.parseInt(line[0]), Integer.parseInt(line[1]),line[2]);
            System.out.println("Nehnutelnost LOADED");
        }
    }
}
