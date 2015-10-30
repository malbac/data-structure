package ioLogic.loadClasses;

import data.DataManager;

/**
 * Created by Malbac on 28.10.2015.
 */
public class LoadListVlastnictva extends LoadInsertTemplate {




    @Override
    public void proceedLine(String[] line, DataManager dataManager) {
        if(line.length==2){//mnozstvo premennych pri katastralnom urade
            dataManager.insertListVlastnictva(Integer.parseInt(line[0]),line[1]);
            System.out.println("ListVlastnictva LOADED");
        }
    }
}
