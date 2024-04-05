/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import domain.UsuarioEntity;
import javax.swing.JOptionPane;

/**
 *
 * @author luisp
 */
public class AgregarUsuarioFrm extends javax.swing.JFrame {

    /**
     * Creates new form AgregarUsuarioFRM
     */
    public AgregarUsuarioFrm() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCurp = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        txtFecha = new com.github.lgooddatepicker.components.DatePicker();
        btnAgregarUsuario = new javax.swing.JToggleButton();
        btnCancelar = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();
        txtMatricula = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCurp.setBorder(null);
        txtCurp.setToolTipText("e.g. COPL030607HSRNRSA9");
        getContentPane().add(txtCurp, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, 220, -1));

        txtNombre.setBorder(null);
        txtNombre.setToolTipText("e.g. Elon Musk");
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 220, -1));

        txtApellido.setBorder(null);
        txtApellido.setToolTipText("e.g. Bezos");
        getContentPane().add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 220, -1));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, 230, 10));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 230, 10));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 230, 10));
        getContentPane().add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, -1, -1));

        btnAgregarUsuario.setBorder(null);
        btnAgregarUsuario.setContentAreaFilled(false);
        btnAgregarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 186, 170, 40));

        btnCancelar.setBorder(null);
        btnCancelar.setContentAreaFilled(false);
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(481, 272, 170, 30));

        jLabel2.setText("Matricula:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 400, -1, -1));

        txtMatricula.setBorder(null);
        txtMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMatriculaActionPerformed(evt);
            }
        });
        getContentPane().add(txtMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, 180, -1));

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 420, 230, 10));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AgregarUsuarioFrm.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarUsuarioActionPerformed
        if(validaCamposVacios() == true){
            UsuarioEntity usuarioAccess = new UsuarioEntity();
            
            DTOAgregarUsuario agregarUsuarioDTO = new DTOAgregarUsuario(txtNombre.getText(), txtApellido.getText(),
                    txtFecha.getDate(), txtMatricula.getText(), txtCurp.getText());
            
            usuarioAccess.create(agregarUsuarioDTO);
            JOptionPane.showMessageDialog(null, "Se ha guardado el usuario correctamente");
            
            this.dispose();
            new GestionUsuariosFrm().setVisible(true);
            
        }else{
            JOptionPane.showMessageDialog(null, "Campos vacíos o invalidos, ingrese nuevamente");
        }
    }//GEN-LAST:event_btnAgregarUsuarioActionPerformed

    private void txtMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMatriculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMatriculaActionPerformed
    
    
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
            java.util.logging.Logger.getLogger(AgregarUsuarioFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarUsuarioFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarUsuarioFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarUsuarioFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarUsuarioFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnAgregarUsuario;
    private javax.swing.JToggleButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCurp;
    private com.github.lgooddatepicker.components.DatePicker txtFecha;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    private boolean validaCamposVacios(){
        if(txtNombre.getText().isBlank() || txtApellido.getText().isBlank() ||
                txtCurp.getText().isBlank() || txtFecha.getDate() == null){
                return false;
        }
        return true;
    }

}
