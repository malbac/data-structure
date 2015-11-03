package GUI.deleteDialog;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import GUI.insertDialog.*;
import data.DataManager;
import dataLogic.OperationManager;

/**
 *
 * @author Malbac
 */
public class DeleteKatastralneUzemie extends javax.swing.JPanel {

    /**
     * Creates new form VlozVlastnika
     */
    OperationManager operationManager;
    public DeleteKatastralneUzemie(DataManager dataManager) {
        operationManager = new OperationManager(dataManager);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TFKatastralneUzemie = new javax.swing.JTextField();
        LabelKatastralneUzemie = new javax.swing.JLabel();
        labelState = new javax.swing.JLabel();
        labelRemve = new javax.swing.JLabel();
        buttonVymaz = new javax.swing.JButton();

        TFKatastralneUzemie.setText("katastralne uzemie");
        TFKatastralneUzemie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFKatastralneUzemieActionPerformed(evt);
            }
        });

        LabelKatastralneUzemie.setLabelFor(TFKatastralneUzemie);
        LabelKatastralneUzemie.setText("id katastralne uzemie");

        labelState.setText("XXXX");

        labelRemve.setText("Odstranenie katastralneho uzemia");

        buttonVymaz.setText("Vymaz");
        buttonVymaz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVymazActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LabelKatastralneUzemie, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                        .addGap(10, 10, 10)
                        .addComponent(TFKatastralneUzemie, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelState, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelRemve)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(buttonVymaz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(labelRemve)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TFKatastralneUzemie)
                    .addComponent(LabelKatastralneUzemie, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(buttonVymaz)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(labelState)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TFKatastralneUzemieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFKatastralneUzemieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFKatastralneUzemieActionPerformed

    private void buttonVymazActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVymazActionPerformed
        int idKatastralnehoUzemia = Integer.parseInt(TFKatastralneUzemie.getText());

        String result ="";
        result = operationManager.getOperation22().odstranenieKatastralnehoUzemia(idKatastralnehoUzemia);
        labelState.setText(result);
    }//GEN-LAST:event_buttonVymazActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelKatastralneUzemie;
    private javax.swing.JTextField TFKatastralneUzemie;
    private javax.swing.JButton buttonVymaz;
    private javax.swing.JLabel labelRemve;
    private javax.swing.JLabel labelState;
    // End of variables declaration//GEN-END:variables
}
