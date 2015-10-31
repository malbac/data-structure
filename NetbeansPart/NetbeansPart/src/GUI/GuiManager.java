package GUI;

import dataLogic.OperationManager;

import java.awt.*;

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
            case operation7: return "operation7";
            case operation8: return "operation8";
            default: return operation7.getClass().getName();
        }
    }

    public void initMainComboMenu(javax.swing.JComboBox mainComboMenu) {
        mainComboMenu.addItem(operation7);
        mainComboMenu.addItem(operation8);
    }

    public String performOperation(String currentOperation,String nazovKatastralnehoUzemia,int idKatastralnehoUzemia,String rodneCislo,int supisneCislo,int cisloListuVlastnicta) {
        switch (currentOperation){
            case "operation7" : return operationManager.getOperation7().vypisNehnutelnostiPodlaKatUzemia(nazovKatastralnehoUzemia);
            case "operation8"  : return operationManager.getOperation8().vypisNehnutelnostiMajitelaVKatUzemi(rodneCislo, idKatastralnehoUzemia);

            default: return "No input";
        }
    }

    public String updateInputLayout(String currentOperation,
                                  javax.swing.JTextField  TFNazovKatastralneUzemie,
                                  javax.swing.JTextField  TFIdKatastralnehoUzemia,
                                  javax.swing.JTextField  TFRodneCislo,
                                  javax.swing.JTextField  TFsupisneCislo,
                                  javax.swing.JTextField  TFCisloListuVlastnictva){
        //********************disable all
        TFNazovKatastralneUzemie.setEnabled(false);
        TFNazovKatastralneUzemie.setText("");
        TFIdKatastralnehoUzemia.setEnabled(false);
        TFIdKatastralnehoUzemia.setText("");
        TFRodneCislo.setEnabled(false);
        TFRodneCislo.setText("");
        TFsupisneCislo.setEnabled(false);
        TFsupisneCislo.setText("");
        TFCisloListuVlastnictva.setEnabled(false);
        TFCisloListuVlastnictva.setText("");
        //********************enable just the needed text fields
        switch (currentOperation){
            case "operation7" : return operation7enableInputLayout(TFNazovKatastralneUzemie);
            case "operation8"  : return operation8enableInputLayout(TFIdKatastralnehoUzemia, TFRodneCislo);

            default: return "Wrong input operation updateInputLayout";
        }

    }

    //**********************OPERATIONS LAYOUT*************************

    private String operation7enableInputLayout(javax.swing.JTextField  TFNazovKatastralneUzemie){
        TFNazovKatastralneUzemie.setEnabled(true);
        return "";
    }

    private String operation8enableInputLayout(javax.swing.JTextField  TFIdKatastralnehoUzemia,
                                               javax.swing.JTextField  TFRodneCislo){
        TFIdKatastralnehoUzemia.setEnabled(true);
        TFRodneCislo.setEnabled(true);
        return "";
    }

    public static void main (String[] args){
    }
}
