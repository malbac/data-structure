package data;

import dataLogic.OperationManager;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Malbac on 27.10.2015.
 */
public class GuiManager {
    final  String operation1 = "(Operacia 1) Vyhladanie nehnutelnosti";
    final  String operation2 = "(Operacia 2) Vyhladanie obyvatela podla rodneho";
    final  String operation3 = "(Operacia 3) Vypis vsetkych osob, ktoré maju trvaly pobyt v zadanej nehnutelnosti";
    final  String operation4 = "(Operacia 4) Vyhladanie listu vlastnictva podla jeho cisla a cisla kat. uzemia";
    final  String operation5 = "(Operacia 5) Vyhladanie listu vlastnictva podla jeho cisla a nazvu kat. uzemia";
    final  String operation6 = "(Operacia 6) Vyhladanie listu vlastnictva podla jeho cisla a nazvu kat. uzemia";
    final  String operation7 = "(Operacia 7) Vypis nehnutelnosti";
    final  String operation8 = "(Operacia 8) Vypis nehnutelnosti majitela";
    final  String operation9 = "(Operacia 9) Vypis nehnutelnosti majitela definovane rod. cislom";

    OperationManager operationManager;

    public GuiManager(){
    operationManager = new OperationManager();
    }

    public String getOperation(String inputItem){
        switch (inputItem){
            case operation1: return "operation1";
            case operation2: return "operation2";
            case operation3: return "operation3";
            case operation4: return "operation4";
            case operation5: return "operation5";
            case operation6: return "operation6";
            case operation7: return "operation7";
            case operation8: return "operation8";
            case operation9: return "operation9";
            default: return operation7.getClass().getName();
        }
    }

    public void initMainComboMenu(javax.swing.JComboBox mainComboMenu) {
        mainComboMenu.addItem(operation1);
        mainComboMenu.addItem(operation2);
        mainComboMenu.addItem(operation3);
        mainComboMenu.addItem(operation4);
        mainComboMenu.addItem(operation5);
        mainComboMenu.addItem(operation6);
        mainComboMenu.addItem(operation7);
        mainComboMenu.addItem(operation8);
        mainComboMenu.addItem(operation9);
    }

    public String performOperation(String currentOperation,String nazovKatastralnehoUzemia,int idKatastralnehoUzemia,String rodneCislo,int supisneCislo,int cisloListuVlastnicta) {
        switch (currentOperation){
            case "operation1" : return operationManager.getOperation1().vypisNehnutelnosti(supisneCislo,idKatastralnehoUzemia);
            case "operation2" : return operationManager.getOperation2().vyhladanieObyvatela(rodneCislo);
            case "operation3" : return operationManager.getOperation3().vypisVsetkychOsobKtByvajuV(idKatastralnehoUzemia, cisloListuVlastnicta, supisneCislo);
            case "operation4" : return operationManager.getOperation4().vyhladanieListuVlastnictva(cisloListuVlastnicta, idKatastralnehoUzemia);
            case "operation5" : return operationManager.getOperation5().vypisNehnutelnosti(supisneCislo, nazovKatastralnehoUzemia);
            case "operation6" : return operationManager.getOperation6().vyhladanieListuVlastnictva(cisloListuVlastnicta, nazovKatastralnehoUzemia);
            case "operation7" : return operationManager.getOperation7().vypisNehnutelnostiPodlaKatUzemia(nazovKatastralnehoUzemia);
            case "operation8"  : return operationManager.getOperation8().vypisNehnutelnostiMajitelaVKatUzemi(rodneCislo, idKatastralnehoUzemia);
            case "operation9"  : return operationManager.getOperation9().vypisNehnutelnostiMajitela(rodneCislo);

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
            case "operation1" : return operation1enableInputLayout(TFsupisneCislo,TFIdKatastralnehoUzemia);
            case "operation2" : return operation2enableInputLayout(TFRodneCislo);
            case "operation3" : return operation3enableInputLayout(TFIdKatastralnehoUzemia, TFCisloListuVlastnictva, TFsupisneCislo);
            case "operation4" : return operation4enableInputLayout(TFCisloListuVlastnictva, TFIdKatastralnehoUzemia);
            case "operation5" : return operation5enableInputLayout(TFsupisneCislo, TFNazovKatastralneUzemie);
            case "operation6" : return operation6enableInputLayout(TFCisloListuVlastnictva, TFNazovKatastralneUzemie);
            case "operation7" : return operation7enableInputLayout(TFNazovKatastralneUzemie);
            case "operation8"  : return operation8enableInputLayout(TFIdKatastralnehoUzemia, TFRodneCislo);
            case "operation9"  : return operation9enableInputLayout(TFRodneCislo);

            default: return "Wrong input operation updateInputLayout";
        }

    }

    private String operation9enableInputLayout(JTextField tfRodneCislo) {
        tfRodneCislo.setEnabled(true);
        return null;
    }


    public void setAlertDialog(JLabel alertDialog,String text){
        alertDialog.setForeground(Color.red);
        alertDialog.setText(text);
    }

    public void setStatusDialog(JLabel alertDialog,String text){
        alertDialog.setForeground(Color.black);
        alertDialog.setText(text);
    }



    //**********************OPERATIONS LAYOUT*************************
    private String operation6enableInputLayout(JTextField tfCisloListuVlastnictva, JTextField tfNazovKatastralneUzemie) {
        tfCisloListuVlastnictva.setEnabled(true);
        tfNazovKatastralneUzemie.setEnabled(true);
        return null;
    }

    private String operation5enableInputLayout(JTextField TFsupisneCislo, JTextField tfNazovKatastralnehoUzemia) {
        TFsupisneCislo.setEnabled(true);
        tfNazovKatastralnehoUzemia.setEnabled(true);
        return null;
    }

    private String operation4enableInputLayout(JTextField tfCisloListuVlastnictva, JTextField tfIdKatastralnehoUzemia) {
        tfCisloListuVlastnictva.setEnabled(true);
        tfIdKatastralnehoUzemia.setEnabled(true);
        return null;
    }

    private String operation1enableInputLayout(JTextField TFsupisneCislo, JTextField TFidKatastralnehoUzemia) {
        TFsupisneCislo.setEnabled(true);
        TFidKatastralnehoUzemia.setEnabled(true);
        return null;
    }

    private String operation2enableInputLayout(JTextField tfRodneCislo) {
        tfRodneCislo.setEnabled(true);
        return null;
    }

    private String operation3enableInputLayout(JTextField tfIdKatastralnehoUzemia, JTextField tfCisloListuVlastnictva, JTextField tFsupisneCislo) {
        tfIdKatastralnehoUzemia.setEnabled(true);
        tfCisloListuVlastnictva.setEnabled(true);
        tFsupisneCislo.setEnabled(true);
        return null;
    }




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
