package ioLogic.loadClasses;

import data.DataManager;

/**
 * Created by Malbac on 28.10.2015.
 */
public class LoadPodiel extends LoadInsertTemplate{

    @Override
    public void proceedLine(String[] line, DataManager dataManager) {
        if(line.length==4){//mnozstvo premennych pri katastralnom urade
            //dataManager.insertPodiel(1,"1111",1,100);// vyries podiel, aby sa vypocitaval automaticky
            dataManager.insertPodiel(Integer.parseInt(line[0]), line[1], Integer.parseInt(line[2]),Integer.parseInt(line[3]));
            System.out.println("Podie LOADED");
        }
    }
}
