/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Consultas.vcproducto;
import DATOS.dproducto;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;

/**
 *
 * @author MXCATTV12
 */
public class BusquedadProducto extends javax.swing.JInternalFrame {

    /**
     * Creates new form BusquedadProducto
     */
    public dproducto objpro = new dproducto();
    public vcproducto objproconsu=new vcproducto();
    
    
    public BusquedadProducto() {
        initComponents();
        combobuscar.setModel(objproconsu.nombrepro(null));
        combobuscar.getEditor().setItem(null);
        combobusquedad();
        if(rbpornom.isSelected()){
            combobuscar.setVisible(true);
            jspcodigo.setVisible(false);
        }
        else if(rbporcod.isSelected()){
            jspcodigo.setVisible(true);
            combobuscar.setVisible(false);
        }
        tablaproupd(null);
    }
    public void tablaproupd(String letritas){
        DefaultTableModel tablapro=objproconsu.mostrar_productos(letritas);
        tablaproducto.setModel(tablapro);
    }
    public void combobusquedad(){
        combobuscar.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt){
                String textoescrito=combobuscar.getEditor().getItem().toString();
                if(evt.getKeyCode()==KeyEvent.VK_ENTER){
                    regresodatospro(null, textoescrito);
                }
                if(evt.getKeyCode()>=65 && evt.getKeyCode()<=90 || evt.getKeyCode()>=96 && evt.getKeyCode()<=105 || evt.getKeyCode()==8){
                        combobuscar.setModel(objproconsu.nombrepro(textoescrito));
                        tablaproupd(textoescrito);
                        if(combobuscar.getItemCount()>0){
                            combobuscar.showPopup();
                            if(evt.getKeyCode()!=8){
                                ((JTextComponent)combobuscar.getEditor().getEditorComponent()).select(textoescrito.length(), 
                                        combobuscar.getEditor().getItem().toString().length());

                            }
                            else{
                                combobuscar.getEditor().setItem(textoescrito);
                            }
                        }
                        else{
                            combobuscar.addItem(textoescrito);

                        }
                    
                }
                else if(evt.getKeyCode()==32){
                    getToolkit().beep();
                    evt.consume();
                    jLabel3.setText("NO SE PERMITEN ESPACIOS");
                    combobuscar.getEditor().setItem(combobuscar.getEditor().getItem().toString().trim());
                    combobuscar.setCursor(null);
                }
            }

        });
    }
    public void regresodatospro(String cod,String nompro){
        String[] datosprore=objproconsu.regrosdatospro(cod, nompro);
        ManteProdu.txtCod.setText(datosprore[0]);
        ManteProdu.txtDescri.setText(datosprore[1]);
        ManteProdu.txtPU.setText(datosprore[2]);
        ManteProdu.txtStock.setText(datosprore[3]);
        if(datosprore[4].equals("A")){
            ManteProdu.chekEstado.setSelected(true);
        }
        else{
            ManteProdu.chekEstado.setSelected(false);
            
        }
        ManteProdu.cbcategoria.setSelectedItem(datosprore[5]);
        
    }
    public void busquedadocd(){
        String cod;
        cod="P"+String.valueOf(jspcodigo.getValue());
        DefaultTableModel tablaprod=objproconsu.mostrarproductoscod(cod);
        tablaproducto.setModel(tablaprod);
        regresodatospro(cod, null);
        
    }
    public void busquedadnom(){
        String nompro;
        nompro=String.valueOf(combobuscar.getSelectedItem());
        DefaultTableModel modelonompro=objproconsu.mostrar_productos(nompro);
        tablaproducto.setModel(modelonompro);
        regresodatospro(null, nompro);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngrupeleccion = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaproducto = new javax.swing.JTable();
        rbporcod = new javax.swing.JRadioButton();
        rbpornom = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        combobuscar = new javax.swing.JComboBox<String>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jspcodigo = new javax.swing.JSpinner();

        setClosable(true);

        jLabel1.setText("ELIJA EL TIPO DE BUSQUEDAD");

        tablaproducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "null", "null"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaproducto);

        btngrupeleccion.add(rbporcod);
        rbporcod.setText("POR CODIGO");
        rbporcod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbporcodActionPerformed(evt);
            }
        });

        btngrupeleccion.add(rbpornom);
        rbpornom.setSelected(true);
        rbpornom.setText("POR NOMBRE");
        rbpornom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbpornomActionPerformed(evt);
            }
        });

        jLabel2.setText("ESCRIBA EL NOMBRE O CODIGO A BUSCAR");

        combobuscar.setEditable(true);
        combobuscar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combobuscarItemStateChanged(evt);
            }
        });

        jLabel3.setText("Mensaje");

        jLabel4.setText("P ");

        jspcodigo.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
        jspcodigo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jspcodigoStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(263, 263, 263)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rbporcod)
                                        .addGap(18, 18, 18)
                                        .addComponent(rbpornom)))
                                .addGap(58, 58, 58)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(combobuscar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(279, 279, 279)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jspcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 47, Short.MAX_VALUE)))
                .addContainerGap(32, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbporcod)
                    .addComponent(rbpornom)
                    .addComponent(combobuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jspcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbporcodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbporcodActionPerformed
        // TODO add your handling code here:
        if(rbpornom.isSelected()){
            combobuscar.setVisible(true);
            jspcodigo.setVisible(false);
        }
        else if(rbporcod.isSelected()){
            jspcodigo.setVisible(true);
            combobuscar.setVisible(false);
        }
    }//GEN-LAST:event_rbporcodActionPerformed

    private void rbpornomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbpornomActionPerformed
        // TODO add your handling code here:
        if(rbpornom.isSelected()){
            combobuscar.setVisible(true);
            jspcodigo.setVisible(false);
        }
        else if(rbporcod.isSelected()){
            jspcodigo.setVisible(true);
            combobuscar.setVisible(false);
        }
    }//GEN-LAST:event_rbpornomActionPerformed

    private void jspcodigoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jspcodigoStateChanged
        // TODO add your handling code here:
        busquedadocd();
    }//GEN-LAST:event_jspcodigoStateChanged

    private void combobuscarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combobuscarItemStateChanged
        // TODO add your handling code here:
        busquedadnom();
    }//GEN-LAST:event_combobuscarItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btngrupeleccion;
    private javax.swing.JComboBox<String> combobuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jspcodigo;
    private javax.swing.JRadioButton rbporcod;
    private javax.swing.JRadioButton rbpornom;
    private javax.swing.JTable tablaproducto;
    // End of variables declaration//GEN-END:variables
}
