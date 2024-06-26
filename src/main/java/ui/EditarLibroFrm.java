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
 * @author xfs85
 */
public class EditarLibroFrm extends javax.swing.JFrame {

    LibroEntity libroEntity;
    /**
     * Creates new form EditarLibroFrm
     * @param libro
     */
    public EditarLibroFrm(LibroEntity libro) {
        initComponents();
        this.libroEntity = libro;
        txtID.setText(String.valueOf(libro.getId()));
        txtTitulo.setText(libro.getTitulo());
        txtAutor.setText(libro.getAutor());
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
        btnVolver = new javax.swing.JButton();
        txtTitulo = new javax.swing.JTextField();
        txtAutor = new javax.swing.JTextField();
        btnEditar = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnVolver.setBorder(null);
        btnVolver.setContentAreaFilled(false);
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 13, 40, 30));

        txtTitulo.setBorder(null);
        jPanel1.add(txtTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 160, 20));

        txtAutor.setBorder(null);
        jPanel1.add(txtAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, 160, 20));

        btnEditar.setBorder(null);
        btnEditar.setContentAreaFilled(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 420, 100, 40));

        txtID.setBorder(null);
        txtID.setEnabled(false);
        jPanel1.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 175, 50, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/EditarLibro.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
    if(validaCamposVacios() == true){
        BibliotecarioEntity libroAccess = new BibliotecarioEntity();
        DTOAgregarLibro agregarLibroDTO = new DTOAgregarLibro(Long.valueOf(this.txtID.getText()), this.txtTitulo.getText(), this.txtAutor.getText());
        try {
            libroAccess.editaLibro(agregarLibroDTO);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(EditarLibroFrm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(EditarLibroFrm.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        this.dispose();
        new GestionLibrosFrm().setVisible(true);
      }else{
          JOptionPane.showMessageDialog(null, "Campos vacíos o invalidos, ingrese nuevamente");
      }
    
    }//GEN-LAST:event_btnEditarActionPerformed

     private boolean validaCamposVacios(){
        if(txtTitulo.getText().isBlank() || txtAutor.getText().isBlank()){
            return false;
        }
        return true;
    }
    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.dispose();
        new GestionLibrosFrm().setVisible(true);
    }//GEN-LAST:event_btnVolverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
