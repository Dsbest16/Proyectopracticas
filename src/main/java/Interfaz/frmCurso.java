package Interfaz;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import Curso.*;
import com.google.gson.Gson;
import java.awt.BorderLayout;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class frmCurso extends JFrame {
    //------------------------------
    //  Referencias a componentes
    //------------------------------
    private JPanel panelPrincipal;
    private JPanel panelBotones;
    private JTable tabla;
    private JScrollPane scrollPane;
    private JButton btnIngresar;
    private JButton btnModificar;
    private JButton btnEliminar;
    private JButton btnSalir;

    //------------------------------
    //  Manejo de JTable
    //------------------------------
    private DefaultTableModel dtm;
    private JTableHeader tableHeader;

    //------------------------------
    //  Referencia al curso
    //------------------------------
    private Curso curso;
    
    /**---------------------------------------------
     * Constructor
     * @param titulo  titulo del JFrame
     * @param ancho   ancho del JFrame
     * @param alto    alto del JFrame
    *----------------------------------------------*/
    public frmCurso(String titulo, int ancho, int alto){
        iniciarComponentes();
        //-------
        this.setTitle(titulo);
        this.setSize(ancho, alto);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true); 
        //-------
        System.out.println("antes de leer el curso");
        this.curso = leerCurso();
        this.listarEstudiantes();
    }
    
    
    /**---------------------------------------------
    * Inicializa todos los componentes del JFrame
    *----------------------------------------------*/
    private void iniciarComponentes(){
        //---------------------------------------------- 
        // Creacion de nuevo JPanel
        //---------------------------------------------- 
        panelPrincipal = new JPanel();
        //panel.setLayout(null);
        panelPrincipal.setLayout(new BorderLayout(5,5));

        //---------------------------------------------- 
        // Creacion de nuevo DefaultTableModel
        //---------------------------------------------- 
        String[] columnNames = {"Numero Matricula", 
                                "Cedula",
                                "Apellidos", 
                                "Nombres"};
        //-----
        Object[][] data = new Object [][]{};  
        //---------------------------------------------- 
        dtm = new DefaultTableModel(data, columnNames) {
            @Override 
            public boolean isCellEditable(int row, int column) {
               return false;
            }
        };

        //---------------------------------------------- 
        // Creacion de nuevo JTable
        //---------------------------------------------- 
        tabla = new JTable();
        tabla.setModel(dtm);
        tabla.setFillsViewportHeight(true);        
        tabla.setShowGrid(true);
        tabla.setPreferredScrollableViewportSize(new Dimension(550, 350));
        tabla.setGridColor(Color.RED);
        //-----
        tableHeader = tabla.getTableHeader();
        tableHeader.setBackground(Color.yellow);
        tableHeader.setForeground(Color.blue);
        tableHeader.setFont(new Font("Cursiva", Font.BOLD, 14));
        //-----
        scrollPane = new JScrollPane(tabla);
        scrollPane.setBounds(10, 10, 550, 350);
        //-----
        panelPrincipal.add(scrollPane, BorderLayout.CENTER);
        
        //---------------------------------------------- 
        // Creacion de botones
        //---------------------------------------------- 
        btnIngresar = new JButton("Ingresar");
        btnIngresar.setBounds(10, 400, 80, 20);
        //-----
        btnModificar = new JButton("Modificar");
        btnModificar.setBounds(100, 400, 80, 20);
        //-----
        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(190, 400, 80, 20);
        //-----
        btnSalir = new JButton("Salir");
        btnSalir.setBounds(280, 400, 80, 20);
        //-----
        panelBotones = new JPanel();
        panelBotones.add(btnIngresar);        
        panelBotones.add(btnModificar);         
        panelBotones.add(btnEliminar);         
        panelBotones.add(btnSalir); 
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);
        
        //---------------------------------------------- 
        //         Adición de Listener
        //---------------------------------------------- 
        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnIngresarActionPerformed(e);
            }
        });
  
        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnModActionPerformed(e);
            }
        });
       
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnEliminarActionPerformed(e);
            }
        });

        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnSalirAcionPerformed(e);
            }
        });
        
        //---------------------------------------------- 
        //   Setea el nuevo panel al JFrame
        //---------------------------------------------- 
        this.setContentPane(panelPrincipal);
    }

    private void btnIngresarActionPerformed(ActionEvent e){
        new frmIngreso("Ingreso", 400, 200, this.curso, this);    
    }
    
    private void btnSalirAcionPerformed(ActionEvent e){
        grabarCurso(curso);
        System.exit(0);
    }
    
    private void btnModActionPerformed(ActionEvent e){
        int numRowSel;
        String cedula, nombres, apellidos, numMatricula;
        //-----------------------------
        numRowSel = tabla.getSelectedRow();
        if (numRowSel >= 0){
            dtm = (DefaultTableModel)tabla.getModel();
            numMatricula = (String)dtm.getValueAt(numRowSel, 0);
            cedula = (String)dtm.getValueAt(numRowSel, 1);
            apellidos = (String)dtm.getValueAt(numRowSel, 2);
            nombres = (String)dtm.getValueAt(numRowSel, 3);
            new frmModificacion("Modificacion", 400, 200, curso, 
                                new Estudiante(numMatricula, cedula,
                                                nombres, apellidos),
                                this);
        }
    }
    
    private void btnEliminarActionPerformed(ActionEvent e){
        int numRowSel;
        String cedula;
        //-----------------------------
        numRowSel = tabla.getSelectedRow();
        if (numRowSel >= 0){
            dtm = (DefaultTableModel)tabla.getModel();
            cedula = (String)dtm.getValueAt(numRowSel, 1);
            curso.eliminarEstudiante(cedula);
            listarEstudiantes();
        }
    }    
    
    public void adicionarEstudiante(Estudiante e){
        listarEstudiantes();
    }
 
    public void modificarEstudiante(Estudiante e){
        listarEstudiantes();
    }
    
    public void listarEstudiantes(){
        dtm = (DefaultTableModel)tabla.getModel();
        dtm.setRowCount(0);
        //-------------
        ArrayList<Estudiante> lis = curso.getListado();
        for(Estudiante e : lis){
            System.out.println(e.toString());     
            dtm.addRow(new Object[] 
                            {e.getNumMatricula(),
                             e.getCedula(),
                             e.getApellidos(),
                             e.getNombres()});
        }
    }

    public void grabarCurso(Curso cur){
        System.out.println("ejecutando grabarcurso");
        String ruta = new File (".").getAbsolutePath();
        System.out.println(ruta);
        String archivo = ruta + "\\curso.txt";
        //--------
        try (FileWriter fw = new FileWriter(archivo)) {
            Gson gson = new Gson();
            String json = gson.toJson(cur);
            fw.write(json);
        } catch (Exception e) {
            System.out.println("Problemas al grabar archivo ->" + e.getMessage());        
        }
    }

    private Curso leerCurso(){
        String ruta = new File ("").getAbsolutePath();
        String archivo = ruta + "\\curso.txt";
        System.out.println(archivo);
        Curso cur = null;
        //--------------------------------------------
        // Validamos si el archivo existe
        //--------------------------------------------
        //File f = new File(archivo);
        //System.out.println(f.exists());
        //if (f.exists())   //Si el archivo existe
        //{
            System.out.println(archivo);
            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                String json = br.readLine();
                System.out.println("***" + json + "***");
                if (json != null){
                    System.out.println(json);
                    Gson gson = new Gson();
                    cur = gson.fromJson(json, Curso.class);
                }
            }
            catch(FileNotFoundException ex){
                System.out.println("no encontre el archivo");
                cur = new Curso("POO");
            }
            catch(Exception ex){
                System.out.println("Problemas al leer archivo ->" +
                                   ex.getMessage());
            }
        //}
        //else
        //{
        //    cur = new Curso("POO");
        //}
        return cur;        
    }

    
}
