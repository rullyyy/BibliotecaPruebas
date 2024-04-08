/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

/**
 *
 * @author xfs85
 */
public class MainPageFrm extends javax.swing.JFrame {

    /**
     * Creates new form MainPageFrm
     */
    public MainPageFrm() {
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
        logOutBtn = new javax.swing.JButton();
        gestionarLibrosBtn = new javax.swing.JButton();
        gestionarUsuariosBtn = new javax.swing.JButton();
        gestionarPrestamosBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Página Principal");
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logOutBtn.setContentAreaFilled(false);
        logOutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutBtnActionPerformed(evt);
            }
        });
        jPanel1.add(logOutBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 15, 100, 25));

        gestionarLibrosBtn.setContentAreaFilled(false);
        gestionarLibrosBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestionarLibrosBtnActionPerformed(evt);
            }
        });
        jPanel1.add(gestionarLibrosBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 151, 154, 45));

        gestionarUsuariosBtn.setContentAreaFilled(false);
        gestionarUsuariosBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestionarUsuariosBtnActionPerformed(evt);
            }
        });
        jPanel1.add(gestionarUsuariosBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 243, 154, 46));

        gestionarPrestamosBtn.setContentAreaFilled(false);
        gestionarPrestamosBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestionarPrestamosBtnActionPerformed(evt);
            }
        });
        jPanel1.add(gestionarPrestamosBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 336, 154, 45));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainPage.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void logOutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutBtnActionPerformed
       this.dispose();
       new LoginFrm().setVisible(true);
    }//GEN-LAST:event_logOutBtnActionPerformed

    private void gestionarLibrosBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestionarLibrosBtnActionPerformed
       this.dispose();
       new GestionLibrosFrm().setVisible(true);
    }//GEN-LAST:event_gestionarLibrosBtnActionPerformed

    private void gestionarUsuariosBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestionarUsuariosBtnActionPerformed
      this.dispose();
      new GestionUsuariosFrm().setVisible(true);
    }//GEN-LAST:event_gestionarUsuariosBtnActionPerformed

    private void gestionarPrestamosBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestionarPrestamosBtnActionPerformed
      this.dispose();
      new GestionPrestamosFrm().setVisible(true);
    }//GEN-LAST:event_gestionarPrestamosBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton gestionarLibrosBtn;
    private javax.swing.JButton gestionarPrestamosBtn;
    private javax.swing.JButton gestionarUsuariosBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton logOutBtn;
    // End of variables declaration//GEN-END:variables
}
