package Componentes;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

public class JTextFieldInteger extends JTextField {
    private int numMaxDigitos;
    
    public JTextFieldInteger(int numMaxDigitos){
        this.numMaxDigitos = numMaxDigitos;
    }

    @Override
    protected void processKeyEvent(KeyEvent e) {
        char c = e.getKeyChar();
        if (Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE) {
            // Permitir solo dígitos y la tecla de retroceso
            if (Character.isDigit(c))
                if (this.getText().length() < this.numMaxDigitos)
                    super.processKeyEvent(e);
                else
                    e.consume();
            else
                super.processKeyEvent(e);
        } 
        else {
            // Ignorar otros caracteres
            e.consume();
        }            

    }
}
