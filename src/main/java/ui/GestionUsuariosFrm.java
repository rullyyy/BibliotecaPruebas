/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import domain.UsuarioEntity;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author xfs85
 */
public class GestionUsuariosFrm extends javax.swing.JFrame {

    UsuarioEntity usuario = new UsuarioEntity();
    private List<UsuarioEntity> listaTabla;
    
    /**
     * Creates new form GestionUsuariosFrm
     */
    public GestionUsuariosFrm() {
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
        btnVolver = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();
        btnAgregarUsuario = new javax.swing.JButton();
        btnEditarUsuario = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Gestión de Usuarios");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnVolver.setContentAreaFilled(false);
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 13, 40, 30));

        tablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tablaUsuarios);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 390, 340));

        btnAgregarUsuario.setBorder(null);
        btnAgregarUsuario.setContentAreaFilled(false);
        btnAgregarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 220, 110, 40));

        btnEditarUsuario.setBorder(null);
        btnEditarUsuario.setContentAreaFilled(false);
        btnEditarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 300, 110, 40));

        btnRegresar.setBorder(null);
        btnRegresar.setContentAreaFilled(false);
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 40, 20));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Matricula del Usuario:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 200, 20));

        txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyReleased(evt);
            }
        });
        jPanel1.add(txtBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 190, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GestionUsuarios.png"))); // NOI18N
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

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.dispose();
        new MainPageFrm().setVisible(true);
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnAgregarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarUsuarioActionPerformed
        this.dispose();
        new AgregarUsuarioFrm().setVisible(true);
    }//GEN-LAST:event_btnAgregarUsuarioActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        cargarTabla();
    }//GEN-LAST:event_formWindowOpened

    private void btnEditarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarUsuarioActionPerformed
        if(tablaUsuarios.getRowCount() > 0){
            if(tablaUsuarios.getSelectedRow() !=-1){
                int id = Integer.parseInt(String.valueOf(tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 0)));
                EditarUsuarioFrm pantallaEditar = new EditarUsuarioFrm(id);
                pantallaEditar.setVisible(true);
                pantallaEditar.setLocationRelativeTo(null);
                
                this.dispose();
            }else{
                mostrarMensaje("No seleccionó ningun Usuario", "Error", "Error al Editar");
            }
        }else{
            mostrarMensaje("No usuarios para Editar", "Error", "Error al Editar");
        }
    }//GEN-LAST:event_btnEditarUsuarioActionPerformed

    private void txtBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyReleased
        cargarTablaMatricula();
    }//GEN-LAST:event_txtBusquedaKeyReleased

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarUsuario;
    private javax.swing.JButton btnEditarUsuario;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaUsuarios;
    private javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables


    private void cargarTabla(){
        DefaultTableModel tabla = new DefaultTableModel(){
        
            @Override
            public boolean isCellEditable (int row, int column){
                return false;
            }
        };
        
        String titulos[] = {"Matricula","Nombre","Apellidos","F.Nacimiento","Curp"};
        tabla.setColumnIdentifiers(titulos);
        List<UsuarioEntity> listaUsuarios = usuario.findUsuarioEntityEntities();
        
        if(listaUsuarios != null){
            for(UsuarioEntity usu : listaUsuarios){
                Object[] objeto = {usu.getMatricula(), usu.getNombre(),usu.getApellidos(),usu.getFechaNacimiento(),usu.getCurp()};
                tabla.addRow(objeto);
            }
            tablaUsuarios.setModel(tabla);
        }  
    }
    
    private void cargarTablaMatricula(){
        DefaultTableModel tabla = (DefaultTableModel) tablaUsuarios.getModel();
        
        String titulos[] = {"Matricula","Nombre","Apellidos","F.Nacimiento","Curp"};
        tabla.setColumnIdentifiers(titulos);
        
        listaTabla = usuario.findUsuarioEntityEntities();
        List<UsuarioEntity> aux = new ArrayList<>();
        if (listaTabla != null) {
            if (!txtBusqueda.getText().equalsIgnoreCase("")) {
                for(UsuarioEntity usu : listaTabla){
                    String matricula = usu.getMatricula();
                    
                    if(matricula.contains(txtBusqueda.getText())){
                        aux.add(usu);
                    }
                }
                listaTabla = aux;
            }
            tabla.setRowCount(0);
            for(UsuarioEntity usu : listaTabla){
                Object[] objeto = {usu.getMatricula(), usu.getNombre(),usu.getApellidos(),usu.getFechaNacimiento(),usu.getCurp()};
                tabla.addRow(objeto);
            }
            tablaUsuarios.setModel(tabla);
        }
    }
    
    
    public void mostrarMensaje (String mensaje, String tipo, String titulo){
        JOptionPane optionPane = new JOptionPane(mensaje);
        if(tipo.equals("Info")){
            optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        }
        else if(tipo.equals("Error")){
            optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
        }
        JDialog dialog = optionPane.createDialog(titulo);
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);      
    }




}
