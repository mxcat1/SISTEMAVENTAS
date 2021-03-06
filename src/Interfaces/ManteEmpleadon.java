/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interfaces;

import Consultas.vccliente;
import Consultas.vcempleado;
import DATOS.Dempleados;
import DATOS.fotoclass;
import java.io.*;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.awt.Image;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Mxcatv
 */
public class ManteEmpleadon extends javax.swing.JInternalFrame {

    /**
     * Creates new form ManteEmpleadon
     */
    public Dempleados objemp=new Dempleados();
    public vcempleado objconsuemp=new vcempleado();
    public vccliente objdist=new vccliente();
    public DefaultComboBoxModel modelo=new DefaultComboBoxModel();
    public fotoclass empfoto=new fotoclass();
    public String links;
    public String usuario;
    public ManteEmpleadon(String usuario) {
        this.usuario=usuario;
        initComponents();
        modelo=objdist.dtdistritos();
        comboDistrito.setModel(modelo);
        datosemp();
        savedtemp();
        if(empfoto.fotoexistelo(objemp)){
            cargarimagen();
        }
        else{
            lblfoto.setIcon(new ImageIcon(getClass().getResource("/Imagenes/fotoblanco.jpg")));
        }
    }
    public void datosemp(){
        String datosempleado[]=objconsuemp.datosempleado(usuario);
        txtCodigo.setText(datosempleado[0]);
        txtNombres.setText(datosempleado[1]);
        txtApellidos.setText(datosempleado[2]);
        txtDireccion.setText(datosempleado[3]);
        comboDistrito.setSelectedIndex(Integer.valueOf(datosempleado[4])-1);
        txtDNI.setText(datosempleado[5]);
        txtfechanac.setDate(Date.valueOf(datosempleado[6]));
        txtfechacon.setDate(Date.valueOf(datosempleado[7]));
        txtUsuario.setText(datosempleado[8]);
        txtContraseña.setText(datosempleado[9]);
        switch(datosempleado[10]){
            case "S":
                rbsoltero.setSelected(true);
                break;
            case "D":
                rbdivor.setSelected(true);
                break;
            case "C":
                rbcasado.setSelected(true);
                break;
        }
        if(datosempleado[11].equals("H")){
            rbhombre.setSelected(true);
        }
        else{
            if(datosempleado[11].equals("M")){
                rbmujer.setSelected(true);
            }
        }
    }
    public void savedtemp(){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        objemp.setCodemp(txtCodigo.getText());
        objemp.setNombre(txtNombres.getText());
        objemp.setApellido(txtApellidos.getText());
        objemp.setDirecemp(txtDireccion.getText());
        objemp.setCoddist(comboDistrito.getSelectedIndex()+1);
        objemp.setDni(txtDNI.getText());
        objemp.setFenac(String.valueOf(sdf.format(txtfechanac.getDate())));
        objemp.setFecon(String.valueOf(sdf.format(txtfechacon.getDate())));
        objemp.setUsuario(txtUsuario.getText());
        objemp.setPass(txtContraseña.getText());
        if(rbcasado.isSelected()){
            objemp.setEstado("C");
        }
        else{
            if(rbdivor.isSelected()){
                objemp.setEstado("D");
            }
            else{
                objemp.setEstado("S");
            }
        }
        if(rbhombre.isSelected()){
            objemp.setSexo("H");
        }
        else{
            if(rbmujer.isSelected()){
                objemp.setSexo("M");
            }
        }
    }
    public void habilitar(){

        txtContraseña.setEnabled(true);
        txtUsuario.setEnabled(true);
        btnfoto.setEnabled(true);
    }
        public void desabilitar(){
        txtApellidos.setEnabled(false);
        txtNombres.setEnabled(false);
        txtDireccion.setEnabled(false);
        txtDNI.setEnabled(false);
        txtContraseña.setEnabled(false);
        txtUsuario.setEnabled(false);
        txtfechacon.setEnabled(false);
        txtfechanac.setEnabled(false);
        btnfoto.setEnabled(false);
        rbcasado.setEnabled(false);
        rbdivor.setEnabled(false);
        rbhombre.setEnabled(false);
        rbmujer.setEnabled(false);
        rbsoltero.setEnabled(false);
    }
        public void cargarimagen(){
            Image img=empfoto.recuperarfotoslo(objemp);
            ImageIcon ico=new ImageIcon(img);
            Image imgv2=ico.getImage();
            Image newimg=imgv2.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            ImageIcon newico=new ImageIcon(newimg);
            lblfoto.setIcon(newico);
        }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngrupsexo = new javax.swing.ButtonGroup();
        btngrupestado = new javax.swing.ButtonGroup();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtDNI = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        comboDistrito = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtfechacon = new com.toedter.calendar.JDateChooser();
        txtfechanac = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        rbhombre = new javax.swing.JRadioButton();
        rbmujer = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        rbcasado = new javax.swing.JRadioButton();
        rbsoltero = new javax.swing.JRadioButton();
        rbdivor = new javax.swing.JRadioButton();
        btnfoto = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblfoto = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnsalir = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btneditar = new javax.swing.JToggleButton();

        setBackground(new java.awt.Color(255, 255, 192));

        jLabel8.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jLabel8.setText("Distrito:");

        jLabel9.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jLabel9.setText("Fecha Nac:");

        jLabel10.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jLabel10.setText("Fecha Contratacion:");

        jLabel11.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jLabel11.setText("Usuario");

        jLabel12.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jLabel12.setText("Contraseña:");

        txtCodigo.setEnabled(false);
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        txtNombres.setEnabled(false);
        txtNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombresActionPerformed(evt);
            }
        });

        txtApellidos.setEnabled(false);
        txtApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidosActionPerformed(evt);
            }
        });

        txtDNI.setEnabled(false);
        txtDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDNIActionPerformed(evt);
            }
        });

        txtDireccion.setEnabled(false);
        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });

        txtUsuario.setEnabled(false);
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });

        txtContraseña.setEnabled(false);
        txtContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraseñaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jLabel2.setText("Codigo:");

        jLabel3.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jLabel3.setText("Nombres:");

        jLabel4.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jLabel4.setText("Apellidos:");

        comboDistrito.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jLabel5.setText("DNI:");

        jLabel6.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jLabel6.setText("Direccion");

        txtfechacon.setDateFormatString("yyyy-MM-dd");
        txtfechacon.setEnabled(false);

        txtfechanac.setDateFormatString("yyyy-MM-dd");
        txtfechanac.setEnabled(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 192));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 192));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Sexo"));

        rbhombre.setBackground(new java.awt.Color(255, 255, 192));
        btngrupsexo.add(rbhombre);
        rbhombre.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        rbhombre.setSelected(true);
        rbhombre.setText("Masculino");
        rbhombre.setEnabled(false);

        rbmujer.setBackground(new java.awt.Color(255, 255, 192));
        btngrupsexo.add(rbmujer);
        rbmujer.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        rbmujer.setText("Femenino");
        rbmujer.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbhombre)
                .addGap(18, 18, 18)
                .addComponent(rbmujer)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbhombre)
                    .addComponent(rbmujer))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 179, 210, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 192));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Estado"));

        rbcasado.setBackground(new java.awt.Color(255, 255, 192));
        btngrupestado.add(rbcasado);
        rbcasado.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        rbcasado.setText("Casado");
        rbcasado.setEnabled(false);

        rbsoltero.setBackground(new java.awt.Color(255, 255, 192));
        btngrupestado.add(rbsoltero);
        rbsoltero.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        rbsoltero.setSelected(true);
        rbsoltero.setText("Soltero");
        rbsoltero.setEnabled(false);

        rbdivor.setBackground(new java.awt.Color(255, 255, 192));
        btngrupestado.add(rbdivor);
        rbdivor.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        rbdivor.setText("Divorciado");
        rbdivor.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(rbsoltero)
                        .addGap(18, 18, 18)
                        .addComponent(rbcasado))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(rbdivor)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbsoltero)
                    .addComponent(rbcasado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(rbdivor))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 251, 210, 90));

        btnfoto.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        btnfoto.setText("Buscar Foto...");
        btnfoto.setEnabled(false);
        btnfoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfotoActionPerformed(evt);
            }
        });
        jPanel1.add(btnfoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 138, -1, -1));

        jLabel13.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel13.setText("FOTO");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 22, -1, -1));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblfoto, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblfoto, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 27, -1, -1));

        jLabel1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 36)); // NOI18N
        jLabel1.setText("Mantenimiento Empleado");

        jPanel5.setBackground(new java.awt.Color(255, 255, 192));

        btnsalir.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        btnsalir.setText("SALIR");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        btnguardar.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btneditar.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        btneditar.setText("EDITAR");
        btneditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnsalir)
                    .addComponent(btnguardar)
                    .addComponent(btneditar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(btneditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnsalir)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtfechacon, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtfechanac, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(comboDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtfechanac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtfechacon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))))))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void txtNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombresActionPerformed

    private void txtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidosActionPerformed

    private void txtDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDNIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDNIActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void txtContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraseñaActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtContraseñaActionPerformed

    private void btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarActionPerformed
        // TODO add your handling code here:
        if(btneditar.isSelected()){
            habilitar();
        }
        else{
            desabilitar();
        }
    }//GEN-LAST:event_btneditarActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:
        savedtemp();
        if(txtApellidos.getText().length()>0 && txtNombres.getText().length()>0
                && txtDireccion.getText().length()>0 && txtDNI.getText().length()>0
                && txtContraseña.getText().length()>0 && txtUsuario.getText().length()>0){
            
            if(objconsuemp.actualizardatos(objemp, links)){
                JOptionPane.showMessageDialog(null, "DATOS GUARDADOS");
                desabilitar();
                btneditar.setSelected(false);
            }
            else{
                JOptionPane.showMessageDialog(null, "Los datos no se han podido gurdaR");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "DATOS INCOMPLETOS VUALVA A REVISAR");
        }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnfotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfotoActionPerformed
        // TODO add your handling code here:
        JFileChooser busimage=new JFileChooser();
        busimage.setDialogTitle("SELECCIONE LA SU FOTO");
        int open=busimage.showOpenDialog(null);
        if(open==JFileChooser.APPROVE_OPTION){
            File Archivo=busimage.getSelectedFile();
            links=String.valueOf(Archivo);
            Image imagen=getToolkit().getImage(links);
            imagen=imagen.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            lblfoto.setIcon(new ImageIcon(imagen));
        }
    }//GEN-LAST:event_btnfotoActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // TODO add your handling code here:
        Principal.menuempleadon.setEnabled(true);
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btneditar;
    private javax.swing.JButton btnfoto;
    private javax.swing.ButtonGroup btngrupestado;
    private javax.swing.ButtonGroup btngrupsexo;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnsalir;
    private javax.swing.JComboBox<String> comboDistrito;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lblfoto;
    private javax.swing.JRadioButton rbcasado;
    private javax.swing.JRadioButton rbdivor;
    private javax.swing.JRadioButton rbhombre;
    private javax.swing.JRadioButton rbmujer;
    private javax.swing.JRadioButton rbsoltero;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtContraseña;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtUsuario;
    private com.toedter.calendar.JDateChooser txtfechacon;
    private com.toedter.calendar.JDateChooser txtfechanac;
    // End of variables declaration//GEN-END:variables
}
