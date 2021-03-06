/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Consultas.vcproducto;
import DATOS.dproducto;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author HDE
 */
public class ManteProdu extends javax.swing.JInternalFrame {

    /**
     * Creates new form ManteProdu
     */
    public vcproducto objproconsu=new vcproducto();
    public dproducto objpro=new dproducto();
    public DefaultComboBoxModel modelo=objproconsu.categoriapro();
    
    public ManteProdu() {
        initComponents();
        cbcategoria.setModel(modelo);
        
    }
    public void habilitar(){
        txtDescri.setEnabled(true);
        txtPU.setEnabled(true);
        txtStock.setEnabled(true);
        chekEstado.setEnabled(true);
        cbcategoria.setEnabled(true);
        
    }
    public void desabiitar(){
        txtDescri.setEnabled(false);
        txtPU.setEnabled(false);
        txtStock.setEnabled(false);
        chekEstado.setEnabled(false);
        cbcategoria.setEnabled(false);
    }
    public void nuevoproducto(){
        txtCod.setText("P"+objproconsu.paracodigonuevo());
        txtDescri.setText("");
        txtStock.setValue(1);
        txtPU.setValue(1);
        cbcategoria.setSelectedIndex(0);
        chekEstado.setSelected(false);
        
        
    }
    public void datospros(String cod,String nompro){
        String[] datospro=objproconsu.regrosdatospro(cod,nompro);
        txtCod.setText(datospro[0]);
        txtDescri.setText(datospro[1]);
        txtPU.setValue(Double.valueOf(datospro[2]));
        txtStock.setValue(Integer.valueOf(datospro[3]));
        if(datospro[4].equals("A")){
            chekEstado.setSelected(true);
        }
        else if(datospro[4].equals("I")){
            chekEstado.setSelected(false);
        }
        else{
            chekEstado.setSelected(false);
        }
        cbcategoria.setSelectedItem(datospro[5]);
        
    }
    public void verificacionynuevopro(){
        prodatossave();
        if(txtDescri.getText().length()>0){
            if(btnnuevo.isSelected()){
                if(objproconsu.nuevopro(objpro)){
                    JOptionPane.showMessageDialog(null, "PRODUCTO NUEVO AGREGADO CON EXITO");
                    desabiitar();
                    btneditar.setEnabled(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "No se ha podido agregar un nuevo producto");
                }
            }
            else if(btneditar.isSelected()){
                if(objproconsu.actualizarpro(objpro)){
                    JOptionPane.showMessageDialog(null, "DATOS DEL PRODUCTO ACTUALIZADOS");
                    desabiitar();
                    btnnuevo.setEnabled(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "LOS DATOS NO SE HAN PODIDO ACTUALIZAR");
                }
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "FALTA AÑADIR UNA DESCRIPCION AL PRODUCTO");
        }
    }
    public void prodatossave(){
        objpro.setCodpro(txtCod.getText());
        objpro.setNompro(txtDescri.getText());
        objpro.setPreupro((double)txtPU.getValue());
        objpro.setStock((int)txtStock.getValue());
        if(chekEstado.isSelected()){
            objpro.setEstado("A");
        }
        else{
            objpro.setEstado("I");
        }
        switch(cbcategoria.getSelectedIndex()){
            case 0:
                objpro.setCodcategoria("CA001");
                break;
            case 1:
                objpro.setCodcategoria("CA002");
                break;
            case 2:
                objpro.setCodcategoria("CA003");
                break;
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDescri = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        chekEstado = new javax.swing.JCheckBox();
        cbcategoria = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        butGuardar = new javax.swing.JButton();
        btnnuevo = new javax.swing.JToggleButton();
        btneditar = new javax.swing.JToggleButton();
        bustSalir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        butBuscar = new javax.swing.JButton();
        txtprobuscar = new javax.swing.JTextField();
        txtStock = new javax.swing.JSpinner();
        txtPU = new javax.swing.JSpinner();

        setBackground(new java.awt.Color(255, 255, 192));

        jLabel1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 36)); // NOI18N
        jLabel1.setText("Mantenimiento Producto");

        jLabel2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jLabel2.setText("Codigo:");

        txtCod.setEnabled(false);
        txtCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jLabel3.setText("Descripciòn:");

        txtDescri.setEnabled(false);
        txtDescri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescriActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jLabel4.setText("Precio Unitario:");

        jLabel5.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jLabel5.setText("Stock:");

        jLabel6.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jLabel6.setText("Estado:");

        jLabel7.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jLabel7.setText("Categorìa:");

        chekEstado.setBackground(new java.awt.Color(255, 255, 192));
        chekEstado.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        chekEstado.setText("Activo");
        chekEstado.setEnabled(false);

        cbcategoria.setEnabled(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 192));

        butGuardar.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        butGuardar.setText("Guardar");
        butGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butGuardarActionPerformed(evt);
            }
        });

        btnnuevo.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        btnnuevo.setText("NUEVO");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        btneditar.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        btneditar.setText("EDITAR");
        btneditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarActionPerformed(evt);
            }
        });

        bustSalir.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        bustSalir.setText("Salir");
        bustSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bustSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(butGuardar)
                            .addComponent(btnnuevo)
                            .addComponent(btneditar))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(bustSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(22, 22, 22))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(btnnuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btneditar)
                .addGap(16, 16, 16)
                .addComponent(butGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bustSalir)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 192));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Narrow", 0, 14))); // NOI18N
        jPanel2.setToolTipText("");

        butBuscar.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        butBuscar.setText("Buscar");
        butBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butBuscarActionPerformed(evt);
            }
        });

        txtprobuscar.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(txtprobuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(butBuscar)
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butBuscar)
                    .addComponent(txtprobuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        txtStock.setModel(new javax.swing.SpinnerNumberModel(1, null, null, 1));
        txtStock.setEnabled(false);

        txtPU.setModel(new javax.swing.SpinnerNumberModel(1.0d, null, null, 1.0d));
        txtPU.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtDescri)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 226, Short.MAX_VALUE)))
                                    .addComponent(cbcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtStock, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(chekEstado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(txtPU, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel1)))
                        .addGap(18, 18, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 87, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)))
                .addGap(16, 16, 16)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDescri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(chekEstado))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cbcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodActionPerformed

    private void txtDescriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescriActionPerformed

    private void bustSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bustSalirActionPerformed
        // TODO add your handling code here:
        Principal.menuitempro.setEnabled(true);
        this.dispose();
    }//GEN-LAST:event_bustSalirActionPerformed

    private void butBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butBuscarActionPerformed
        // TODO add your handling code here:
        
        BusquedadProducto frmbuscarpro=new BusquedadProducto();
        Principal.dkprincipal.add(frmbuscarpro);
        frmbuscarpro.setVisible(true);
    }//GEN-LAST:event_butBuscarActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        // TODO add your handling code here:
        if(btnnuevo.isSelected()){
            btneditar.setEnabled(false);
            habilitar();
            nuevoproducto();
        }
        else{
            desabiitar();
            btneditar.setEnabled(true);
            datospros(null, txtprobuscar.getText());
            
        }
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarActionPerformed
        // TODO add your handling code here:
        if(btneditar.isSelected()){
            btnnuevo.setEnabled(false);
            habilitar();
        }
        else{
            desabiitar();
            btnnuevo.setEnabled(true);
            datospros(null, txtprobuscar.getText());
        }
    }//GEN-LAST:event_btneditarActionPerformed

    private void butGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butGuardarActionPerformed
        // TODO add your handling code here:
        verificacionynuevopro();
    }//GEN-LAST:event_butGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btneditar;
    private javax.swing.JToggleButton btnnuevo;
    private javax.swing.JButton bustSalir;
    private javax.swing.JButton butBuscar;
    private javax.swing.JButton butGuardar;
    public static javax.swing.JComboBox<String> cbcategoria;
    public static javax.swing.JCheckBox chekEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JTextField txtCod;
    public static javax.swing.JTextField txtDescri;
    public static javax.swing.JSpinner txtPU;
    public static javax.swing.JSpinner txtStock;
    public static javax.swing.JTextField txtprobuscar;
    // End of variables declaration//GEN-END:variables
}
