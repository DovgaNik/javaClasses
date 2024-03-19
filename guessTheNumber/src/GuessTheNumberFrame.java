import javax.swing.*;
import java.awt.*;

public class GuessTheNumberFrame extends JFrame{
    JLabel instruction, afterInput, livesLeft;
    JButton restart;
    JTextField numberInput;
    public GuessTheNumberFrame(){
        super("Guess the Number");
        setSize(300, 500);
        setLayout(new GridLayout(5, 1));
        setVisible(true);
    }
}
