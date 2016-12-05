/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Consultas.vccliente;
import Consultas.vcempleado;
import DATOS.Dempleados;
import DATOS.dpersona;
import DATOS.fotoclass;
import java.awt.Image;
import java.sql.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import jdk.nashorn.internal.ir.BreakNode;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author SOFTWARE
 */
public class ManteEmpleado extends javax.swing.JInternalFrame {

    /**
     * Creates new form ManteEmpleado
     */
    public vcempleado objemp=new vcempleado();
    public vccliente objdist=new vccliente();
    public Dempleados dtsemp=new Dempleados();
    public String codemp[]=objemp.codigoemp();
    public int n;
    String codeemps;
    public String links;
    public String cod_emp1;
    public fotoclass objfoto=new fotoclass();
    
    public String comparar(){
        codeemps="";
        n=0;
        
        while(codeemps.equals("")){
            if(comboemp.getSelectedIndex()==n){
                codeemps=codemp[n];
            }
            else{
                codeemps="";
                n++;
            }  
        }
        return codeemps;
    }
    public boolean verificacion(){
        if(txtApellidos.getText().trim().length()>0 && txtNombres.getText().trim().length()>0 && txtDireccion.getText().trim().length()>0 && 
                txtDNI.getText().trim().length()>0 && txtUsuario.getText().trim().length()>0 && txtContraseña.getText().trim().length()>0 && 
                txtfechacon.getDate()!=null && txtfechanac.getDate()!=null) {
            
            btnguardar.setEnabled(true);
            return true;
        }
        else{
            btnguardar.setEnabled(false);
            return false;
        }
    }
    public ManteEmpleado() {
        initComponents();
        AutoCompleteDecorator.decorate(comboemp);
        DefaultComboBoxModel modelemp=new DefaultComboBoxModel();
        DefaultComboBoxModel modeldist=new DefaultComboBoxModel();
        modelemp=objemp.buscaremp();
        modeldist=objdist.dtdistritos();
        comboDistrito.setModel(modeldist);
        comboemp.setModel(modelemp);
        comboemp.setSelectedIndex(0);
        dtsemp.setCodemp(comparar());
        cod_emp1=objemp.codigoempunico();
        datosdemp();
        if(objfoto.fotoexiste(dtsemp)){
            cargarimagen();
        }
        else{
            lblfoto.setIcon(new ImageIcon(getClass().getResource("/Imagenes/fotoblanco.jpg")));
        }
    }
    public void datosdemp(){
        String datosemp[]=objemp.datosemp(dtsemp);
        try{
            txtCodigo.setText(datosemp[0]);
            txtNombres.setText(datosemp[1]);
            txtApellidos.setText(datosemp[2]);
            txtDireccion.setText(datosemp[3]);
            switch(Integer.valueOf(datosemp[4])){
                case 1:
                    comboDistrito.setSelectedIndex(0);
                    break;
                case 2:
                    comboDistrito.setSelectedIndex(1);
                    break;
                case 3:
                    comboDistrito.setSelectedIndex(2);
                    break;
                case 4:
                    comboDistrito.setSelectedIndex(3);
                    break;
                default:
                    comboDistrito.setSelectedIndex(0);
                    JOptionPane.showMessageDialog(null, "DISTRITO NO ENCONTRADO");
                    break;
            }
            txtDNI.setText(datosemp[5]);
            txtfechanac.setDate(Date.valueOf(datosemp[6]));
            txtfechacon.setDate(Date.valueOf(datosemp[7]));
            txtUsuario.setText(datosemp[8]);
            txtContraseña.setText(datosemp[9]);
            switch(datosemp[10]){
                case "S":
                    rbsoltero.setSelected(true);
                    break;
                case "C":
                    rbcasado.setSelected(true);
                    break;
                case "D":
                    rbdivor.setSelected(true);
                    break;
                default:
                    break;
            }
            if(datosemp[11].equals("H")){
                rbhombre.setSelected(true);
            }
            else{
                if(datosemp[11].equals("M")){
                    rbmujer.setSelected(true);
                }
            }
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR "+e);
        }
    }
    public void capdatosemp(){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        dtsemp.setCodemp(txtCodigo.getText());
        dtsemp.setNombre(txtNombres.getText());
        dtsemp.setApellido(txtApellidos.getText());
        dtsemp.setDirecemp(txtDireccion.getText());
        dtsemp.setCoddist(comboDistrito.getSelectedIndex()+1);
        dtsemp.setDni(txtDNI.getText());
        if(txtfechanac.getDate()!=null && txtfechacon!=null){
            dtsemp.setFenac(String.valueOf(sdf.format(txtfechanac.getDate())));
            dtsemp.setFecon(String.valueOf(sdf.format(txtfechacon.getDate())));
        }
        else{
            dtsemp.setFecon(null);
            dtsemp.setFenac(null);
        }

        dtsemp.setUsuario(txtUsuario.getText());
        dtsemp.setPass(txtContraseña.getText());
        if(rbcasado.isSelected()){
            dtsemp.setEstado("C");
        }
        else{
            if(rbdivor.isSelected()){
                dtsemp.setEstado("D");
            }
            else{
                if(rbsoltero.isSelected()){
                    dtsemp.setEstado("S");
                }
            }
        }
        if(rbhombre.isSelected()){
            dtsemp.setSexo("H");
        }
        else{
            if(rbmujer.isSelected()){
                dtsemp.setSexo("M");
            }
        }
    }
    public void habilitar(){
        txtNombres.setEnabled(true);
        txtApellidos.setEnabled(true);
        txtContraseña.setEnabled(true);
        txtDNI.setEnabled(true);
        txtDireccion.setEnabled(true);
        txtUsuario.setEnabled(true);
        txtfechacon.setEnabled(true);
        txtfechanac.setEnabled(true);
        comboDistrito.setEnabled(true);
        btnfoto.setEnabled(true);
        rbsoltero.setEnabled(true);
        rbcasado.setEnabled(true);
        rbdivor.setEnabled(true);
        rbhombre.setEnabled(true);
        rbmujer.setEnabled(true);
        
    }
    public  void desabilitar(){
        txtNombres.setEnabled(false);
        txtApellidos.setEnabled(false);
        txtContraseña.setEnabled(false);
        txtDNI.setEnabled(false);
        txtDireccion.setEnabled(false);
        txtUsuario.setEnabled(false);
        txtfechacon.setEnabled(false);
        txtfechanac.setEnabled(false);
        comboDistrito.setEnabled(false);
        btnfoto.setEnabled(false);
        rbsoltero.setEnabled(false);
        rbcasado.setEnabled(false);
        rbdivor.setEnabled(false);
        rbhombre.setEnabled(false);
        rbmujer.setEnabled(false);
    }
    public void nuevoemp(){
        txtNombres.setText("");
        txtApellidos.setText("");
        txtDireccion.setText("");
        txtDNI.setText("");
        txtContraseña.setText("");
        txtUsuario.setText("");
        txtfechacon.setDate(null);
        txtfechanac.setDate(null);
        
    }
    public void nuevocodemp(){
        String codigo="EMP",caracter="";
        int n2=cod_emp1.length(),n1=3;
        while(n1<=n2-1){
            caracter+=String.valueOf(cod_emp1.charAt(n1));

            n1++;
            
        }
        codigo=codigo+(String.valueOf(Integer.valueOf(caracter)+1));
        txtCodigo.setText(codigo);
        
        
    }
    public void cargarimagen(){
        Image tmg=objfoto.recuperarfotosme(dtsemp);
        ImageIcon ico=new ImageIcon(tmg);
        Image img=ico.getImage();
        Image newimg=img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon icono=new ImageIcon(newimg);
        lblfoto.setIcon(icono);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngrpsexo = new javax.swing.ButtonGroup();
        btngrpestado = new javax.swing.ButtonGroup();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        comboemp = new javax.swing.JComboBox<>();
        txtfechacon = new com.toedter.calendar.JDateChooser();
        txtfechanac = new com.toedter.calendar.JDateChooser();
        jPanel6 = new javax.swing.JPanel();
        btnnuevo = new javax.swing.JToggleButton();
        btneditar = new javax.swing.JToggleButton();
        btnguardar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 192));
        setForeground(java.awt.Color.white);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(680, 580));

        jPanel1.setBackground(new java.awt.Color(255, 255, 192));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 192));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Sexo"));

        rbhombre.setBackground(new java.awt.Color(255, 255, 192));
        btngrpsexo.add(rbhombre);
        rbhombre.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        rbhombre.setSelected(true);
        rbhombre.setText("Masculino");
        rbhombre.setEnabled(false);

        rbmujer.setBackground(new java.awt.Color(255, 255, 192));
        btngrpsexo.add(rbmujer);
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
        btngrpestado.add(rbcasado);
        rbcasado.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        rbcasado.setText("Casado");
        rbcasado.setEnabled(false);

        rbsoltero.setBackground(new java.awt.Color(255, 255, 192));
        btngrpestado.add(rbsoltero);
        rbsoltero.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        rbsoltero.setSelected(true);
        rbsoltero.setText("Soltero");
        rbsoltero.setEnabled(false);

        rbdivor.setBackground(new java.awt.Color(255, 255, 192));
        btngrpestado.add(rbdivor);
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
        jPanel2.getAccessibleContext().setAccessibleName("Estado Civil");

        btnfoto.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        btnfoto.setText("Buscar Foto...");
        btnfoto.setEnabled(false);
        btnfoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfotoActionPerformed(evt);
            }
        });
        jPanel1.add(btnfoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, -1, -1));

        jLabel13.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
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
        txtNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombresKeyTyped(evt);
            }
        });

        txtApellidos.setEnabled(false);
        txtApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidosActionPerformed(evt);
            }
        });
        txtApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidosKeyTyped(evt);
            }
        });

        txtDNI.setEnabled(false);
        txtDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDNIActionPerformed(evt);
            }
        });
        txtDNI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDNIKeyTyped(evt);
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
        txtContraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtContraseñaKeyPressed(evt);
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

        jLabel1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 36)); // NOI18N
        jLabel1.setText("Mantenimiento Empleados");

        jLabel6.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jLabel6.setText("Direccion");

        jPanel5.setBackground(new java.awt.Color(255, 255, 192));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Narrow", 0, 14))); // NOI18N
        jPanel5.setToolTipText("");
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        comboemp.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboempItemStateChanged(evt);
            }
        });
        comboemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboempActionPerformed(evt);
            }
        });
        jPanel5.add(comboemp, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 160, -1));

        txtfechacon.setDateFormatString("yyyy-MM-dd");
        txtfechacon.setEnabled(false);

        txtfechanac.setDateFormatString("yyyy-MM-dd");
        txtfechanac.setEnabled(false);

        jPanel6.setBackground(new java.awt.Color(255, 255, 192));

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

        btnguardar.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btnsalir.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnnuevo)
                            .addComponent(btneditar)
                            .addComponent(btnguardar)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btnsalir)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnnuevo)
                .addGap(18, 18, 18)
                .addComponent(btneditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnguardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 311, Short.MAX_VALUE)
                .addComponent(btnsalir)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(10, 10, 10))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfechacon, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfechanac, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addGap(41, 41, 41)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtfechanac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtfechacon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // TODO add your handling code here:
        Principal.menuEmpleado.setEnabled(true);
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void comboempItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboempItemStateChanged
        // TODO add your handling code here:
        dtsemp.setCodemp(comparar());
        datosdemp();
        if(objfoto.fotoexiste(dtsemp)){
            cargarimagen();
        }
        else{
            lblfoto.setIcon(new ImageIcon(getClass().getResource("/Imagenes/fotoblanco.jpg")));
        }
        //lblfoto.setIcon(new ImageIcon(objfoto.recuperarfotosme(dtsemp).getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        //lblfoto.setIcon(new ImageIcon(getClass().getResource("/Imagenes/fotoblanco.jpg")));
        
    }//GEN-LAST:event_comboempItemStateChanged

    private void btnfotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfotoActionPerformed
        // TODO add your handling code here:
        JFileChooser busimage=new JFileChooser();
        busimage.setDialogTitle("SELECCIONE SU FOTO");
        
        int open=busimage.showOpenDialog(null);
        if(open==JFileChooser.APPROVE_OPTION){
            File Archivo=busimage.getSelectedFile();
            links=String.valueOf(Archivo);
            Image imagen=getToolkit().getImage(links);
            imagen=imagen.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            lblfoto.setIcon(new ImageIcon(imagen));
        }
        
        
    }//GEN-LAST:event_btnfotoActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        // TODO add your handling code here:
        if(btnnuevo.isSelected()){
            habilitar();
            nuevocodemp();
            nuevoemp();
            btneditar.setEnabled(false);
        }
        else{
            btneditar.setEnabled(true);
            desabilitar();
            dtsemp.setCodemp(comparar());
            datosdemp();
        }
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:
        capdatosemp();
        if(verificacion()){
            if(btnnuevo.isSelected() && !btneditar.isSelected()){
                //NUEVOS DATOS
                if(objemp.ingredata(dtsemp,links)){
                    JOptionPane.showMessageDialog(null, "DATOS GUARDADOs");
                    this.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(null, "DATOS NO SE HAN PODIDO GUARDAR");
                }
                
                
            }
            else{
                if(btneditar.isSelected() && !btnnuevo.isSelected()){
                //ACTUALIZACION DE DATOS
                    if(objemp.actualizardatos(dtsemp,links)){
                        
                        JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS");
                        desabilitar();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "LOS DATOS NO SEAN PODIDO ACTUALIZAR");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "NO SE PUEDE LOGRAR NINGUNA ACCION SELECONE SOLO UN BOTON");
                }
                
            }

        }
        else{
            JOptionPane.showMessageDialog(null, "FALTAN DATOS");
        }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarActionPerformed
        // TODO add your handling code here:
        if(btneditar.isSelected()){
            btnnuevo.setEnabled(false);
            habilitar();
            
        }
        else{
            btnnuevo.setEnabled(true);
            desabilitar();
            dtsemp.setCodemp(comparar());
            datosdemp();
        }
    }//GEN-LAST:event_btneditarActionPerformed

    private void txtNombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombresKeyTyped
        // TODO add your handling code here:
        verificacion();
    }//GEN-LAST:event_txtNombresKeyTyped

    private void txtContraseñaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraseñaKeyPressed
        // TODO add your handling code here:
        verificacion();
    }//GEN-LAST:event_txtContraseñaKeyPressed

    private void txtApellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosKeyTyped
        // TODO add your handling code here:
        verificacion();
    }//GEN-LAST:event_txtApellidosKeyTyped

    private void txtDNIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDNIKeyTyped
        // TODO add your handling code here:
        verificacion();
    }//GEN-LAST:event_txtDNIKeyTyped

    private void comboempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboempActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboempActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btneditar;
    private javax.swing.JButton btnfoto;
    private javax.swing.ButtonGroup btngrpestado;
    private javax.swing.ButtonGroup btngrpsexo;
    private javax.swing.JButton btnguardar;
    private javax.swing.JToggleButton btnnuevo;
    private javax.swing.JButton btnsalir;
    private javax.swing.JComboBox<String> comboDistrito;
    private javax.swing.JComboBox<String> comboemp;
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
    private javax.swing.JPanel jPanel6;
    public javax.swing.JLabel lblfoto;
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
