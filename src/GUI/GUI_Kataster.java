package GUI;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.swing.JFrame;

/**
 *
 * @author Malbac
 */
public class GUI_Kataster extends javax.swing.JFrame {

    /**
     * Creates new form GUI_Kataster
     */
    public GUI_Kataster() {
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
        TFKatastralneUzemie2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        ButtonVypis7 = new javax.swing.JButton();
        TFRodneCislo = new javax.swing.JTextField();
        labelRodneCislo = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        TFKatastralneUzemie1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        ButtonVypis8 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        buttonRemoveMajetkovyPodiel = new javax.swing.JButton();
        buttonRemoveNehnutelnost = new javax.swing.JButton();
        buttonRemoveObcan = new javax.swing.JButton();
        buttonRemoveListVlastnictva = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        buttonRemoveKatastralneUzemie = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButtonVlozOsoba.setText("Obcan");
        jButtonVlozOsoba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVlozOsobaActionPerformed(evt);
            }
        });

        jButtonVlozKatastralneUzemie.setText("Katastralne Uzemie");
        jButtonVlozKatastralneUzemie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVlozKatastralneUzemieActionPerformed(evt);
            }
        });

        jButtonVlozListVlastnictva.setText("List Vlastnictva");
        jButtonVlozListVlastnictva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVlozListVlastnictvaActionPerformed(evt);
            }
        });

        jButtonVlozNehnutelnost.setText("Nehnutelnost");
        jButtonVlozNehnutelnost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVlozNehnutelnostActionPerformed(evt);
            }
        });

        jLabel1.setText("Vloz:");

        buttonVlozPodielnik.setText("Podielnik");
        buttonVlozPodielnik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVlozPodielnikActionPerformed(evt);
            }
        });

        buttonVlozPodiel.setText("Podiel");
        buttonVlozPodiel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVlozPodielActionPerformed(evt);
            }
        });

        buttonKatastralnyUrad.setText("Katastralny Urad");
        buttonKatastralnyUrad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
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
                .addContainerGap(98, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelVyhladavanie.setText("Vyhladavanie:");

        TFKatastralneUzemie2.setText("katastralne uzemie");

        jLabel2.setLabelFor(TFKatastralneUzemie2);
        jLabel2.setText("Nazov Katastralneho Uzemia:");

        ButtonVypis7.setText("Hladaj");
        ButtonVypis7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonVypis7ActionPerformed(evt);
            }
        });

        TFRodneCislo.setText("rodne Cislo");

        labelRodneCislo.setLabelFor(TFKatastralneUzemie2);
        labelRodneCislo.setText("Rodne Cislo");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TFKatastralneUzemie2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelRodneCislo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TFRodneCislo, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ButtonVypis7)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TFKatastralneUzemie2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(ButtonVypis7)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TFRodneCislo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelRodneCislo)))
                .addContainerGap())
        );

        TFKatastralneUzemie1.setText("katastralne uzemie");

        jLabel3.setLabelFor(TFKatastralneUzemie2);
        jLabel3.setText("Nazov Katastralneho Uzemia:");

        ButtonVypis8.setText("Hladaj");
        ButtonVypis8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonVypis8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TFKatastralneUzemie1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ButtonVypis8)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TFKatastralneUzemie1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(ButtonVypis8))
                .addGap(3, 3, 3))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelVyhladavanie)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabelVyhladavanie)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jTextArea.setColumns(20);
        jTextArea.setRows(5);
        jScrollPane1.setViewportView(jTextArea);

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        buttonRemoveMajetkovyPodiel.setText("Majetkovy podiel");
        buttonRemoveMajetkovyPodiel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRemoveMajetkovyPodielActionPerformed(evt);
            }
        });

        buttonRemoveNehnutelnost.setText("Nehnutelnost");
        buttonRemoveNehnutelnost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRemoveNehnutelnostActionPerformed(evt);
            }
        });

        buttonRemoveObcan.setText("Obcana");
        buttonRemoveObcan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRemoveObcanActionPerformed(evt);
            }
        });

        buttonRemoveListVlastnictva.setText("List vlastnictva");
        buttonRemoveListVlastnictva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRemoveListVlastnictvaActionPerformed(evt);
            }
        });

        jLabel4.setText("Odstránenie:");

        buttonRemoveKatastralneUzemie.setText("Katastralne Uzemie");
        buttonRemoveKatastralneUzemie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
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
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVlozOsobaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVlozOsobaActionPerformed
        // TODO add your handling code here:
        JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.getContentPane().add(new VlozVlastnika());
            frame.pack();
            frame.setVisible(true);
    }//GEN-LAST:event_jButtonVlozOsobaActionPerformed

    private void jButtonVlozKatastralneUzemieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVlozKatastralneUzemieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonVlozKatastralneUzemieActionPerformed

    private void jButtonVlozListVlastnictvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVlozListVlastnictvaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonVlozListVlastnictvaActionPerformed

    private void jButtonVlozNehnutelnostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVlozNehnutelnostActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonVlozNehnutelnostActionPerformed

    private void buttonVlozPodielnikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVlozPodielnikActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonVlozPodielnikActionPerformed

    private void buttonVlozPodielActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVlozPodielActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonVlozPodielActionPerformed

    private void buttonKatastralnyUradActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonKatastralnyUradActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonKatastralnyUradActionPerformed

    private void buttonRemoveMajetkovyPodielActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRemoveMajetkovyPodielActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonRemoveMajetkovyPodielActionPerformed

    private void buttonRemoveNehnutelnostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRemoveNehnutelnostActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonRemoveNehnutelnostActionPerformed

    private void buttonRemoveObcanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRemoveObcanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonRemoveObcanActionPerformed

    private void buttonRemoveListVlastnictvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRemoveListVlastnictvaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonRemoveListVlastnictvaActionPerformed

    private void buttonRemoveKatastralneUzemieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRemoveKatastralneUzemieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonRemoveKatastralneUzemieActionPerformed

    private void ButtonVypis8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonVypis8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonVypis8ActionPerformed

    private void ButtonVypis7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonVypis7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonVypis7ActionPerformed

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
    private javax.swing.JButton ButtonVypis7;
    private javax.swing.JButton ButtonVypis8;
    private javax.swing.JTextField TFKatastralneUzemie1;
    private javax.swing.JTextField TFKatastralneUzemie2;
    private javax.swing.JTextField TFRodneCislo;
    private javax.swing.JButton buttonKatastralnyUrad;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelVyhladavanie;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea;
    private javax.swing.JLabel labelRodneCislo;
    // End of variables declaration//GEN-END:variables
}