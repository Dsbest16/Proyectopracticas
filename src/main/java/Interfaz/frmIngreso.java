package Interfaz;

import Componentes.JTextFieldLetters;
import Componentes.JTextFieldInteger;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Curso.*;
import java.awt.BorderLayout;

public class frmIngreso extends JFrame{
    //------------------------------
    //  Referencias a componentes
    //------------------------------
    private JLabel lblNumMatricula;
    private JLabel lblCedula;
    private JLabel lblNombres;
    private JLabel lblApellidos;
    private JTextFieldInteger txtNumMatricula;
    private JTextFieldInteger txtCedula;
    private JTextFieldLetters txtNombres;
    private JTextFieldLetters txtApellidos; 
    private JButton btnGrabar;
    private JButton btnSalir;
    //------------------------------
    //  Variables de trabajo
    //------------------------------
    private JPanel panelPrincipal; 
    private JPanel panelDatos;
    private JPanel panelBotones;
    private frmCurso ventanaPadre;
    private Curso curso;
    private Estudiante estudiante;
  
    //Constructor formulario modoTrabajo "I"
    public frmIngreso(String titulo,int ancho, int alto, Curso curso,
                      frmCurso ventanaPadre){
        this.curso = curso;
        this.ventanaPadre = ventanaPadre;
        //-----------
        iniciarComponentes();
        //-----------
        this.setTitle(titulo);
        this.setSize(ancho,alto);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true); 
    }
    
    private void iniciarComponentes(){
        //---------------------------------------------- 
        // Adición de componentes al panelDatos
        //---------------------------------------------- 
        lblCedula = new JLabel("Cedula");        
        lblCedula.setBounds(10, 10, 100, 20);
        txtCedula = new JTextFieldInteger(10);
        txtCedula.setBounds(120, 10, 100, 20);
        lblNumMatricula = new JLabel("Num Matricula:");
        lblNumMatricula.setBounds(10, 30, 100, 20);
        txtNumMatricula = new JTextFieldInteger(3);
        txtNumMatricula.setBounds(120, 30, 100, 20);
        lblApellidos = new JLabel("Apellidos");
        lblApellidos.setBounds(10, 50, 100, 20);       
        txtApellidos = new JTextFieldLetters(25);
        txtApellidos.setBounds(120, 50, 250, 20);
        lblNombres = new JLabel("Nombres");
        lblNombres.setBounds(10, 70, 100, 20);
        txtNombres = new JTextFieldLetters(25);
        txtNombres.setBounds(120, 70, 250, 20);
        //-----
        panelDatos = new JPanel();
        panelDatos.setLayout(null);
        panelDatos.add(lblCedula);
        panelDatos.add(txtCedula);        
        panelDatos.add(lblNumMatricula);
        panelDatos.add(txtNumMatricula);
        panelDatos.add(lblApellidos);
        panelDatos.add(txtApellidos);
        panelDatos.add(lblNombres);        
        panelDatos.add(txtNombres);

        //---------------------------------------------- 
        // Adición de componentes al panelBotones
        //---------------------------------------------- 
        btnGrabar = new JButton("Grabar");
        //btnGrabar.setBounds(10, 100, 150, 20);
        btnSalir = new JButton("Salir");
        //btnSalir.setBounds(130, 100, 150, 20);
        //-----
        panelBotones = new JPanel();
        panelBotones.add(btnGrabar);
        panelBotones.add(btnSalir);        

        //---------------------------------------------- 
        // Adición de componentes al JPanel
        //---------------------------------------------- 
        btnGrabar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnGrabarActionPerformed(e);
            }
        }); 
        
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnSalirActionPerformed(e);
            }
        });         

        //---------------------------------------------- 
        // Setea el nuevo panelPrincipal al JFrame
        //---------------------------------------------- 
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout(5,5));
        panelPrincipal.add(panelDatos,BorderLayout.CENTER);
        panelPrincipal.add(panelBotones,BorderLayout.SOUTH);
        this.setContentPane(panelPrincipal);        
    }
    
    public void btnGrabarActionPerformed(ActionEvent e){
        String numMatricula, cedula, nombres, apellidos;
        Estudiante nuevoEstudiante;
        //--------
        numMatricula = txtNumMatricula.getText();
        cedula = txtCedula.getText();
        nombres = txtNombres.getText();
        apellidos = txtApellidos.getText();
        nuevoEstudiante = new Estudiante(numMatricula,cedula,nombres,apellidos);
        this.curso.adicionarEstudiante(nuevoEstudiante);
        this.ventanaPadre.listarEstudiantes();
        this.dispose();
    }    
    
    public void btnSalirActionPerformed(ActionEvent e){
        this.dispose();
    }    
}