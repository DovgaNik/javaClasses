import javax.swing.*;
import java.awt.*;
import java.text.MessageFormat;

public class GuessTheNumberFrame extends JFrame{
    JLabel instructions, afterInput, livesLeft;
    JButton restart;
    JTextField numberInput;
    private int MAX_VALUE = 20,
        lives = 5;
    public GuessTheNumberFrame(){
        super("Guess the Number");
        setSize(300, 300);
        setLayout(new GridLayout(5, 1));

        instructions =  new JLabel(MessageFormat.format("Guess a number between 1 and {0}", MAX_VALUE));
        afterInput = new JLabel("Hello, welcome to our wonderful game🎮🕹️");
        livesLeft = new JLabel(MessageFormat.format("You have {0} lives left", lives));
        numberInput = new JTextField();
        restart = new JButton("Restart");

        add(instructions);
        add(numberInput);
        add(afterInput);
        add(livesLeft);
        add(restart);

        setVisible(true);
    }
}
