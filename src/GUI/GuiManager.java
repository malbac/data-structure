package GUI;

import dataLogic.OperationManager;

/**
 * Created by Malbac on 27.10.2015.
 */
public class GuiManager {
    final  String operation7 = "(Operacia 7) Výpis nehnutelnosti";
    final  String operation8 = "(Operacia 8) Výpis nehnutelnosti majite¾a";

    OperationManager operationManager;

    public GuiManager(){
    operationManager = new OperationManager();
    }

    public String getOperation(String inputItem){
        switch (inputItem){
            case operation7: return operation7.getClass().getName();
            case operation8: return operation8.getClass().getName();
            default: return operation7.getClass().getName();
        }
    }

    public void initMainComboMenu(javax.swing.JComboBox mainComboMenu) {
        mainComboMenu.addItem(operation7);
        mainComboMenu.addItem(operation8);
    }

    public String performOperation(String currentOperation,String nazovKatastralnehoUzemia,int idKatastralnehoUzemia,String rodneCislo) {
        switch (currentOperation){
            case operation7  : return operationManager.getOperation7().vypisNehnutelnostiPodlaKatUzemia(nazovKatastralnehoUzemia);
            case operation8  : return operationManager.getOperation8().vypisNehnutelnostiMajitelaVKatUzemi(rodneCislo, idKatastralnehoUzemia);

            default: return "No input";
        }
    }

    public static void main (String[] args){
    }
}
