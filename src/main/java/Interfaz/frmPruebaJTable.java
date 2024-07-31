package Interfaz;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class frmPruebaJTable extends JFrame {
    private JPanel panelPrincipal; 
    private JPanel panelDatos;
    private JPanel panelBotones;
    private JButton btnIngresar;
    private JButton btnSeleccionar;
    
    //------------------------------
    //  Manejo de JTable
    //------------------------------
    private JScrollPane scrollPane;
    private JTable tabla;
    private DefaultTableModel dtm;
    private JTableHeader tableHeader;

    public frmPruebaJTable(String titulo, int ancho, int alto){
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
        panelPrincipal = new JPanel();
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
        btnSeleccionar = new JButton("Seleccionar");
        btnSeleccionar.setBounds(100, 400, 80, 20);
        
        panelBotones = new JPanel();
        panelBotones.add(btnIngresar);        
        panelBotones.add(btnSeleccionar);        
        
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);
        
        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnIngresarActionPerformed(e);
            }
        });
        
        btnSeleccionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnSeleccionarActionPerformed(e);
            }
        });        
        
        this.setContentPane(panelPrincipal);
    }
    
    private void btnIngresarActionPerformed(ActionEvent e){
        dtm.addRow(new Object[]{"M1111","999999", "AAAAA", "BBBBB"});

    }  
    
    private void btnSeleccionarActionPerformed(ActionEvent e){
        int numRowSel;
        numRowSel = tabla.getSelectedRow();
        if (numRowSel >= 0){
            JOptionPane.showMessageDialog(this, numRowSel);
        }        

    }      
    public static void main(String[] args) {
        frmPruebaJTable x = new frmPruebaJTable("JTabla",500,400);
    }
    
}
