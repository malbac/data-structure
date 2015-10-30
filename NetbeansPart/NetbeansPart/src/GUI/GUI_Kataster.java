package GUI;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import GUI.insertDialog.VlozKatastralneUzemie;
import GUI.insertDialog.VlozListVlastnictva;
import GUI.insertDialog.VlozNehnutelnostNaListVlastnictva;
import GUI.insertDialog.VlozVlastnika;
import data.DataManager;
import data.DataStateEntity;
import data.implementation.treap.TNode;
import dataLogic.OperationManager;
import ioLogic.IOHandler;

import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.LinkedList;

/**
 *
 * @author Malbac
 */
public class GUI_Kataster extends JFrame {


    String currentOperation = "operation7";
    DataManager dataManager;
    OperationManager operationManager;
    GuiManager guiManager;
    IOHandler ioHandler;
    public GUI_Kataster() {
        dataManager = DataStateEntity.getDataManager();
        operationManager = new OperationManager();
        guiManager = new GuiManager();
        ioHandler = new IOHandler(dataManager);

        ioHandler.load();

        initComponents();
        guiManager.initMainComboMenu(mainComboMenu);
    }



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonVlozOsoba = new javax.swing.JButton();
        jButtonVlozKatastralneUzemie = new javax.swing.JButton();
        jButtonVlozListVlastnictva = new javax.swing.JButton();
        jButtonVlozNehnutelnost = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        buttonVlozPodielnik = new javax.swing.JButton();
        buttonVlozPodiel = new javax.swing.JButton();
        buttonKatastralnyUrad = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabelVyhladavanie = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        TFNazovKatastralneUzemie = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        buttonMainSearch = new javax.swing.JButton();
        TFRodneCislo = new javax.swing.JTextField();
        labelRodneCislo = new javax.swing.JLabel();
        mainComboMenu = new javax.swing.JComboBox();
        labelIdKatastralnehoUzemia = new javax.swing.JLabel();
        TFIdKatastralnehoUzemia = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        buttonRemoveMajetkovyPodiel = new javax.swing.JButton();
        buttonRemoveNehnutelnost = new javax.swing.JButton();
        buttonRemoveObcan = new javax.swing.JButton();
        buttonRemoveListVlastnictva = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        buttonRemoveKatastralneUzemie = new javax.swing.JButton();
        buttonClearTextArea = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        buttonKatastralneUzemiaVypis = new javax.swing.JButton();
        buttonListyVlastnictvaVypis = new javax.swing.JButton();
        buttonNehnutelnostVypis = new javax.swing.JButton();
        buttonOsobaVypis = new javax.swing.JButton();
        buttonPodielVypis = new javax.swing.JButton();
        buttonKatastralnyUradVypis = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButtonVlozOsoba.setText("Obcan");
        jButtonVlozOsoba.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonVlozOsobaActionPerformed(evt);
            }
        });

        jButtonVlozKatastralneUzemie.setText("Katastralne Uzemie");
        jButtonVlozKatastralneUzemie.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonVlozKatastralneUzemieActionPerformed(evt);
            }
        });

        jButtonVlozListVlastnictva.setText("List Vlastnictva");
        jButtonVlozListVlastnictva.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonVlozListVlastnictvaActionPerformed(evt);
            }
        });

        jButtonVlozNehnutelnost.setText("Nehnutelnost");
        jButtonVlozNehnutelnost.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonVlozNehnutelnostActionPerformed(evt);
            }
        });

        jLabel1.setText("Vloz:");

        buttonVlozPodielnik.setText("Podielnik");
        buttonVlozPodielnik.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonVlozPodielnikActionPerformed(evt);
            }
        });

        buttonVlozPodiel.setText("Podiel");
        buttonVlozPodiel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonVlozPodielActionPerformed(evt);
            }
        });

        buttonKatastralnyUrad.setText("Katastralny Urad");
        buttonKatastralnyUrad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonKatastralnyUradActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButtonVlozOsoba, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonVlozKatastralneUzemie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonVlozListVlastnictva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonVlozNehnutelnost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(buttonKatastralnyUrad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(buttonVlozPodiel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(buttonVlozPodielnik, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jSeparator1))
                                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonVlozOsoba)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonVlozListVlastnictva)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonVlozNehnutelnost)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonVlozKatastralneUzemie)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonKatastralnyUrad)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonVlozPodiel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonVlozPodielnik)
                                .addContainerGap(69, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelVyhladavanie.setText("Vyhladavanie:");

        TFNazovKatastralneUzemie.setText("Zilina");

        jLabel2.setLabelFor(TFNazovKatastralneUzemie);
        jLabel2.setText("Nazov Katastralneho Uzemia:");

        buttonMainSearch.setText("Hladaj");
        buttonMainSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonMainSearch(evt);
            }
        });

        TFRodneCislo.setText("1111");

        labelRodneCislo.setLabelFor(TFNazovKatastralneUzemie);
        labelRodneCislo.setText("Rodne Cislo");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TFNazovKatastralneUzemie, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(labelRodneCislo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TFRodneCislo, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonMainSearch)
                                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(TFRodneCislo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(labelRodneCislo))
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(TFNazovKatastralneUzemie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel2)
                                                .addComponent(buttonMainSearch)))
                                .addContainerGap())
        );

        //mainComboMenu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));


        mainComboMenu.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainComboMenuItemStateChanged();
                System.out.println("State Changed");
            }
        });

        labelIdKatastralnehoUzemia.setText("id katastralneho uzemia");

        TFIdKatastralnehoUzemia.setText("1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(jLabelVyhladavanie)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(mainComboMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(labelIdKatastralnehoUzemia)
                                                                .addGap(39, 39, 39)
                                                                .addComponent(TFIdKatastralnehoUzemia, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelVyhladavanie)
                                        .addComponent(mainComboMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(TFIdKatastralnehoUzemia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelIdKatastralnehoUzemia))
                                .addContainerGap(53, Short.MAX_VALUE))
        );

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        buttonRemoveMajetkovyPodiel.setText("Majetkovy podiel");
        buttonRemoveMajetkovyPodiel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonRemoveMajetkovyPodielActionPerformed(evt);
            }
        });

        buttonRemoveNehnutelnost.setText("Nehnutelnost");
        buttonRemoveNehnutelnost.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonRemoveNehnutelnostActionPerformed(evt);
            }
        });

        buttonRemoveObcan.setText("Obcana");
        buttonRemoveObcan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonRemoveObcanActionPerformed(evt);
            }
        });

        buttonRemoveListVlastnictva.setText("List vlastnictva");
        buttonRemoveListVlastnictva.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonRemoveListVlastnictvaActionPerformed(evt);
            }
        });

        jLabel4.setText("Odstránenie:");

        buttonRemoveKatastralneUzemie.setText("Katastralne Uzemie");
        buttonRemoveKatastralneUzemie.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonRemoveKatastralneUzemieActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(buttonRemoveMajetkovyPodiel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(buttonRemoveNehnutelnost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(buttonRemoveObcan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(buttonRemoveListVlastnictva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(buttonRemoveKatastralneUzemie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonRemoveMajetkovyPodiel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonRemoveObcan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonRemoveListVlastnictva)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonRemoveNehnutelnost)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonRemoveKatastralneUzemie)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        buttonClearTextArea.setText("Vymaz plochu");
        buttonClearTextArea.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonClearTextAreaActionPerformed(evt);
            }
        });

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        buttonListyVlastnictvaVypis.setText("ListyVlastnictva");
        buttonListyVlastnictvaVypis.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonListyVlastnictvaVypisActionPerformed(evt);
            }
        });

        buttonNehnutelnostVypis.setText("Nehnutelnost");
        buttonNehnutelnostVypis.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonNehnutelnostVypisActionPerformed(evt);
            }
        });

        buttonOsobaVypis.setText("Osoba");
        buttonOsobaVypis.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonOsobaVypisActionPerformed(evt);
            }
        });

        buttonPodielVypis.setText("Podiel");
        buttonPodielVypis.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonPodielVypisActionPerformed(evt);
            }
        });

        buttonKatastralnyUradVypis.setText("KatastalnyUrad");
        buttonKatastralnyUradVypis.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonKatastralnyUradVypisActionPerformed(evt);
            }
        });


        buttonKatastralneUzemiaVypis.setText("KatastralneUzemia");
        buttonKatastralneUzemiaVypis.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonKatastralneUzemiaVypisActionPerformed(evt);
            }
        });

        buttonListyVlastnictvaVypis.setText("ListyVlastnictva");

        buttonNehnutelnostVypis.setText("Nehnutelnost");

        buttonOsobaVypis.setText("Osoba");

        buttonPodielVypis.setText("Podiel");

        buttonKatastralnyUradVypis.setText("KatastalnyUrad");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 654, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonClearTextArea)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonKatastralneUzemiaVypis)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonListyVlastnictvaVypis)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonNehnutelnostVypis)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonOsobaVypis)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonPodielVypis)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonKatastralnyUradVypis)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(buttonClearTextArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator2))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonKatastralneUzemiaVypis)
                        .addComponent(buttonListyVlastnictvaVypis)
                        .addComponent(buttonNehnutelnostVypis)
                        .addComponent(buttonOsobaVypis)
                        .addComponent(buttonPodielVypis)
                        .addComponent(buttonKatastralnyUradVypis)))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents



    private void mainComboMenuItemStateChanged() {
        currentOperation = guiManager.getOperation((String)mainComboMenu.getSelectedItem());
        setRightLabelToOperation(currentOperation);
    }

    private void setRightLabelToOperation(String currentOperation) {

    }

    private void jButtonVlozOsobaActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonVlozOsobaActionPerformed
        // TODO add your handling code here:
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.getContentPane().add(new VlozVlastnika());
            frame.pack();
            frame.setVisible(true);
    }//GEN-LAST:event_jButtonVlozOsobaActionPerformed

    private void jButtonVlozKatastralneUzemieActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonVlozKatastralneUzemieActionPerformed
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(new VlozKatastralneUzemie());
        frame.pack();
        frame.setVisible(true);
    }//GEN-LAST:event_jButtonVlozKatastralneUzemieActionPerformed

    private void jButtonVlozListVlastnictvaActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonVlozListVlastnictvaActionPerformed
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(new VlozListVlastnictva());
        frame.pack();
        frame.setVisible(true);
    }//GEN-LAST:event_jButtonVlozListVlastnictvaActionPerformed

    private void jButtonVlozNehnutelnostActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonVlozNehnutelnostActionPerformed
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(new VlozNehnutelnostNaListVlastnictva());
        frame.pack();
        frame.setVisible(true);
    }//GEN-LAST:event_jButtonVlozNehnutelnostActionPerformed

    private void buttonVlozPodielnikActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buttonVlozPodielnikActionPerformed

    }//GEN-LAST:event_buttonVlozPodielnikActionPerformed

    private void buttonVlozPodielActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buttonVlozPodielActionPerformed

    }//GEN-LAST:event_buttonVlozPodielActionPerformed

    private void buttonKatastralnyUradActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buttonKatastralnyUradActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonKatastralnyUradActionPerformed

    private void buttonRemoveMajetkovyPodielActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buttonRemoveMajetkovyPodielActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonRemoveMajetkovyPodielActionPerformed

    private void buttonRemoveNehnutelnostActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buttonRemoveNehnutelnostActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonRemoveNehnutelnostActionPerformed

    private void buttonRemoveObcanActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buttonRemoveObcanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonRemoveObcanActionPerformed

    private void buttonRemoveListVlastnictvaActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buttonRemoveListVlastnictvaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonRemoveListVlastnictvaActionPerformed

    private void buttonRemoveKatastralneUzemieActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buttonRemoveKatastralneUzemieActionPerformed

    }//GEN-LAST:event_buttonRemoveKatastralneUzemieActionPerformed
    private void buttonListyVlastnictvaVypisActionPerformed(ActionEvent evt) {
        textArea.append("*****************Listy vlastnictva \n");
        textArea.append(dataManager.vypisListVlastnictva());
    }

    private void buttonNehnutelnostVypisActionPerformed(ActionEvent evt) {
        textArea.append(dataManager.vypisNehnutelnosti());
    }

    private void buttonOsobaVypisActionPerformed(ActionEvent evt) {
        textArea.append(dataManager.vypisOsob());
    }

    private void buttonPodielVypisActionPerformed(ActionEvent evt) {
        //not implemented
    }

    private void buttonKatastralnyUradVypisActionPerformed(ActionEvent evt) {
        textArea.append(dataManager.vypisKatastralnychUradov());
    }

    private void buttonKatastralneUzemiaVypisActionPerformed(ActionEvent evt) {
        textArea.append(dataManager.vypisKatastralnychUzemi());
    }

    private void buttonMainSearch(ActionEvent evt) {//GEN-FIRST:event_ButtonOperation7ActionPerformed
        //docasne kym nefunguje state changed
        //String currentOperation = guiManager.getOperation((String)mainComboMenu.getSelectedItem());
        //setRightLabelToOperation(currentOperation);
        //implementation
        String nazovKatastralnehoUzemia = TFNazovKatastralneUzemie.getText();
        int idKatastralnehoUzemia = Integer.parseInt(TFIdKatastralnehoUzemia.getText());
        String rodneCislo = TFRodneCislo.getText();
        textArea.append(guiManager.performOperation(currentOperation,nazovKatastralnehoUzemia,idKatastralnehoUzemia,rodneCislo));
    }//GEN-LAST:event_ButtonOperation7ActionPerformed



    private void buttonClearTextAreaActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buttonClearTextAreaActionPerformed
        textArea.setText("Was saved");
        ioHandler.save();
    }//GEN-LAST:event_buttonClearTextAreaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI_Kataster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Kataster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Kataster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Kataster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Kataster().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonMainSearch;
    private javax.swing.JTextField TFIdKatastralnehoUzemia;
    private javax.swing.JTextField TFNazovKatastralneUzemie;
    private javax.swing.JTextField TFRodneCislo;
    private javax.swing.JButton buttonClearTextArea;
    private javax.swing.JButton buttonKatastralneUzemiaVypis;
    private javax.swing.JButton buttonKatastralnyUrad;
    private javax.swing.JButton buttonKatastralnyUradVypis;
    private javax.swing.JButton buttonListyVlastnictvaVypis;
    private javax.swing.JButton buttonNehnutelnostVypis;
    private javax.swing.JButton buttonOsobaVypis;
    private javax.swing.JButton buttonPodielVypis;
    private javax.swing.JButton buttonRemoveKatastralneUzemie;
    private javax.swing.JButton buttonRemoveListVlastnictva;
    private javax.swing.JButton buttonRemoveMajetkovyPodiel;
    private javax.swing.JButton buttonRemoveNehnutelnost;
    private javax.swing.JButton buttonRemoveObcan;
    private javax.swing.JButton buttonVlozPodiel;
    private javax.swing.JButton buttonVlozPodielnik;
    private javax.swing.JButton jButtonVlozKatastralneUzemie;
    private javax.swing.JButton jButtonVlozListVlastnictva;
    private javax.swing.JButton jButtonVlozNehnutelnost;
    private javax.swing.JButton jButtonVlozOsoba;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelVyhladavanie;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelIdKatastralnehoUzemia;
    private javax.swing.JLabel labelRodneCislo;
    private javax.swing.JComboBox mainComboMenu;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables
}
