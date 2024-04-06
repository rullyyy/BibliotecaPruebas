/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import domain.BibliotecarioEntity;
import domain.LibroEntity;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author luisp
 */
public class AgregaLibroFrm extends javax.swing.JFrame {

    /**
     * Creates new form AgregaLibroFrm
     */
    public AgregaLibroFrm() {
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

        jPanel2 = new javax.swing.JPanel();
        txtTitulo = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        txtAutor = new javax.swing.JTextField();
        btnVolver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTitulo.setBorder(null);
        jPanel2.add(txtTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 160, 20));

        btnAgregar.setContentAreaFilled(false);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel2.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 420, 105, 34));

        txtAutor.setBorder(null);
        txtAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAutorActionPerformed(evt);
            }
        });
        jPanel2.add(txtAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 305, 160, 20));

        btnVolver.setBorder(null);
        btnVolver.setContentAreaFilled(false);
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel2.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 13, 40, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AgregarLibro.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
      if(validaCamposVacios() == true){
        BibliotecarioEntity libroAccess = new BibliotecarioEntity();
        DTOAgregarLibro agregarLibroDTO = new  DTOAgregarLibro(this.txtTitulo.getText(), this.txtAutor.getText());
          try {
              libroAccess.registraLibro(agregarLibroDTO);
          } catch (IllegalAccessException ex) {
              Logger.getLogger(AgregaLibroFrm.class.getName()).log(Level.SEVERE, null, ex);
          } catch (InstantiationException ex) {
              Logger.getLogger(AgregaLibroFrm.class.getName()).log(Level.SEVERE, null, ex);
          }
        
        this.dispose();
        new GestionLibrosFrm().setVisible(true);
      }else{
          JOptionPane.showMessageDialog(null, "Campos vacíos o invalidos, ingrese nuevamente");
      }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAutorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAutorActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
       
        this.dispose();
       new MainPageFrm().setVisible(true);
    }//GEN-LAST:event_btnVolverActionPerformed
    
    private boolean validaCamposVacios(){
        if(txtTitulo.getText().isBlank() || txtAutor.getText().isBlank()){
            return false;
        }
        return true;
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
