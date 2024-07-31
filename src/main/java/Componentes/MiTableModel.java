package Componentes;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MiTableModel extends DefaultTableModel {
    private String[] columnNames;
    private Object[][] data = null;
    
    public MiTableModel(String[] columnNames)
    {
        this.columnNames = columnNames;
    }
    
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
    
}


    