package GUI.deleteDialog;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import GUI.insertDialog.*;
import dataLogic.OperationManager;

/**
 *
 * @author Malbac
 */
public class DeleteObcan extends javax.swing.JPanel {

    /**
     * Creates new form VlozVlastnika
     */
    OperationManager operationManager;
    public DeleteObcan() {
        operationManager = new OperationManager();
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

        labelState = new javax.swing.JLabel();
        labelRemve = new javax.swing.JLabel();
        LabelRodneCislo = new javax.swing.JLabel();
        TFRodneCislo = new javax.swing.JTextField();
        buttonVymaz = new javax.swing.JButton();

        labelState.setText("XXXX");

        labelRemve.setText("Odstranenie obcana");

        LabelRodneCislo.setText("rodne cislo");

        TFRodneCislo.setText("rodne cislo");
        TFRodneCislo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFRodneCisloActionPerformed(evt);
            }
        });

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
                    .addComponent(labelState, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelRemve)
                        .addGap(0, 215, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LabelRodneCislo, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(TFRodneCislo))
                    .addComponent(buttonVymaz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(labelRemve)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TFRodneCislo)
                    .addComponent(LabelRodneCislo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(buttonVymaz)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(labelState)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TFRodneCisloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFRodneCisloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFRodneCisloActionPerformed

    private void buttonVymazActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVymazActionPerformed
        String rodneCislo = TFRodneCislo.getText();

       String result ="";
        result = operationManager.getOperation18().odstranenieObcana(rodneCislo);
        labelState.setText(result);
    }//GEN-LAST:event_buttonVymazActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelRodneCislo;
    private javax.swing.JTextField TFRodneCislo;
    private javax.swing.JButton buttonVymaz;
    private javax.swing.JLabel labelRemve;
    private javax.swing.JLabel labelState;
    // End of variables declaration//GEN-END:variables
}
