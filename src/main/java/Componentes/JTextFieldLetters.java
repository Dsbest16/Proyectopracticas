package Componentes;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

public class JTextFieldLetters extends JTextField {
    private int numMaxCaracteres;
    
    public JTextFieldLetters(int tamanio){
        this.numMaxCaracteres = tamanio;
    }

    @Override
    protected void processKeyEvent(KeyEvent e) {
        char c = e.getKeyChar();   
        if (Character.isLetter(c) || c == KeyEvent.VK_BACK_SPACE)
        {
            if (Character.isLetter(c)){
                if (this.getText().length() < this.numMaxCaracteres){
                    e.setKeyChar(Character.toUpperCase(c));
                    super.processKeyEvent(e); 
                }
                else
                    e.consume();
            }
            else
                super.processKeyEvent(e);
        }
        else{
            // Ignorar otros caracteres
            e.consume();            
        }
    }
}
