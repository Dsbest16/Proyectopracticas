package Interfaz;

import Componentes.JTextFieldLetters;
import Componentes.JTextFieldInteger;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Curso.*;

public class frmModificacion extends JFrame{
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
    private JPanel panel; 
    //------------------------------
    //  Variables de trabajo
    //------------------------------
    private frmCurso ventanaPadre;
    private Curso curso;
    private Estudiante estudiante;
      
    public frmModificacion(String titulo,int ancho, int alto,
                           Curso curso, Estudiante estudiante,
                           frmCurso ventanaPadre){
        this.curso = curso;
        this.estudiante = estudiante;
        this.ventanaPadre = ventanaPadre;
        //-----------
        iniciarComponentes();
        //-----------
        iniciarValores();
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
        // Creacion de nuevo JPanel
        //---------------------------------------------- 
        panel = new JPanel();
        panel.setLayout(null);

        //---------------------------------------------- 
        // Adición de componentes al JPanel
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
        panel.add(lblCedula);
        panel.add(txtCedula);        
        panel.add(lblNumMatricula);
        panel.add(txtNumMatricula);
        panel.add(lblApellidos);
        panel.add(txtApellidos);
        panel.add(lblNombres);        
        panel.add(txtNombres);

        //---------------------------------------------- 
        // Adición de componentes al JPanel
        //---------------------------------------------- 
        btnGrabar = new JButton("Grabar");
        btnGrabar.setBounds(10, 100, 100, 20);
        btnSalir = new JButton("Salir");
        btnSalir.setBounds(130, 100, 100, 20);
        //-----
        panel.add(btnGrabar);
        panel.add(btnSalir);        

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
        // Setea el nuevo panel al JFrame
        //---------------------------------------------- 
        this.setContentPane(panel);        
    }
    
    private void iniciarValores(){
        this.txtCedula.setText(this.estudiante.getCedula());
        this.txtCedula.setEditable(false);
        this.txtNumMatricula.setText(this.estudiante.getNumMatricula());
        this.txtNombres.setText(this.estudiante.getNombres());
        this.txtApellidos.setText(this.estudiante.getApellidos());
    }

    public void btnGrabarActionPerformed(ActionEvent e){
        String numMatricula, cedula, nombres, apellidos;
        Estudiante nuevoEstudiante;
        //--------
        numMatricula = txtNumMatricula.getText();
        cedula = txtCedula.getText();
        nombres = txtNombres.getText();
        apellidos = txtApellidos.getText();
        //--------
        nuevoEstudiante = new Estudiante(numMatricula,cedula,nombres,apellidos);
        this.curso.actualizarEstudiante(nuevoEstudiante);
        this.ventanaPadre.listarEstudiantes();
        this.dispose();
    }    
    
    public void btnSalirActionPerformed(ActionEvent e){
        this.dispose();
    }    
}