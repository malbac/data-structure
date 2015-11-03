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
public class DeleteMajetkovyPodiel extends javax.swing.JPanel {

    /**
     * Creates new form VlozVlastnika
     */
    OperationManager operationManager;
    public DeleteMajetkovyPodiel(DataManager dataManager) {
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

        buttonVymaz = new javax.swing.JButton();
        labelState = new javax.swing.JLabel();
        labelRemve = new javax.swing.JLabel();
        TFRodneCislo = new javax.swing.JTextField();
        labelRodneCislo = new javax.swing.JLabel();
        LabelCisloListuVlastnictva = new javax.swing.JLabel();
        TFCisloListuVlastnictva = new javax.swing.JTextField();
        labelSupisneCislo = new javax.swing.JLabel();
        LabelKatastralneUzemie = new javax.swing.JLabel();
        TFsupisneCislo = new javax.swing.JTextField();
        TFKatastralneUzemie = new javax.swing.JTextField();

        buttonVymaz.setText("Vymaz");
        buttonVymaz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVymazActionPerformed(evt);
            }
        });

        labelState.setText("XXXX");

        labelRemve.setText("Odstranenie Majetkoveho podielu");

        TFRodneCislo.setText("rodneCislo");
        TFRodneCislo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFRodneCisloActionPerformed(evt);
            }
        });

        labelRodneCislo.setText("rodne_cislo");

        LabelCisloListuVlastnictva.setText("Cislo Listu Vlastnictva");

        TFCisloListuVlastnictva.setText("Cislo Listu Vlastnictva");
        TFCisloListuVlastnictva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFCisloListuVlastnictvaActionPerformed(evt);
            }
        });

        labelSupisneCislo.setText("supisne cislo");

        LabelKatastralneUzemie.setText("id katastralne uzemie");

        TFsupisneCislo.setText("supisne cislo");
        TFsupisneCislo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFsupisneCisloActionPerformed(evt);
            }
        });

        TFKatastralneUzemie.setText("katastralne uzemie");
        TFKatastralneUzemie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFKatastralneUzemieActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonVymaz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelState, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelRemve)
                        .addGap(0, 151, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(LabelCisloListuVlastnictva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(10, 10, 10))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(labelRodneCislo, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(26, 26, 26))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(LabelKatastralneUzemie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelSupisneCislo, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TFsupisneCislo)
                            .addComponent(TFKatastralneUzemie)
                            .addComponent(TFRodneCislo)
                            .addComponent(TFCisloListuVlastnictva, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(labelRemve)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TFRodneCislo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelRodneCislo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TFKatastralneUzemie)
                    .addComponent(LabelKatastralneUzemie, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TFCisloListuVlastnictva)
                    .addComponent(LabelCisloListuVlastnictva, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TFsupisneCislo)
                    .addComponent(labelSupisneCislo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(buttonVymaz)
                .addGap(18, 18, 18)
                .addComponent(labelState)
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonVymazActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVymazActionPerformed
        String rodneCislo = TFRodneCislo.getText();
        int idListVlastnictva = Integer.parseInt(TFCisloListuVlastnictva.getText());
        int idKatastralnehoUzemia = Integer.parseInt(TFKatastralneUzemie.getText());
        int idSupisneCislo = Integer.parseInt(TFsupisneCislo.getText());

        String result = operationManager.getOperation13().odstranenieMajetkovehoPodielu(rodneCislo, idKatastralnehoUzemia, idListVlastnictva, idSupisneCislo);
        labelState.setText(result);
    }//GEN-LAST:event_buttonVymazActionPerformed

    private void TFRodneCisloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFRodneCisloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFRodneCisloActionPerformed

    private void TFCisloListuVlastnictvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFCisloListuVlastnictvaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFCisloListuVlastnictvaActionPerformed

    private void TFsupisneCisloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFsupisneCisloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFsupisneCisloActionPerformed

    private void TFKatastralneUzemieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFKatastralneUzemieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFKatastralneUzemieActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelCisloListuVlastnictva;
    private javax.swing.JLabel LabelKatastralneUzemie;
    private javax.swing.JTextField TFCisloListuVlastnictva;
    private javax.swing.JTextField TFKatastralneUzemie;
    private javax.swing.JTextField TFRodneCislo;
    private javax.swing.JTextField TFsupisneCislo;
    private javax.swing.JButton buttonVymaz;
    private javax.swing.JLabel labelRemve;
    private javax.swing.JLabel labelRodneCislo;
    private javax.swing.JLabel labelState;
    private javax.swing.JLabel labelSupisneCislo;
    // End of variables declaration//GEN-END:variables
}
