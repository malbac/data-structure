package ioLogic.loadClasses;

import data.DataManager;

/**
 * Created by Malbac on 28.10.2015.
 */
public class LoadKatastralnyUrad extends LoadInsertTemplate {




    @Override
    public void proceedLine(String[] line, DataManager dataManager) {
        if(line.length==1){//mnozstvo premennych pri katastralnom urade
            dataManager.insertKatastralnyUrad(Integer.parseInt(line[0]));
            System.out.println("KatastralnyUrad LOADED");
        }
    }
}
