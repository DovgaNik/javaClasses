import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.MessageFormat;
import java.util.Random;

public class GuessTheNumberFrame extends JFrame{
    JLabel instructions, afterInput, livesLeft;
    JButton restart;
    JTextField numberInput;
    private int MAX_VALUE = 20,
        lives = 5,
        generated_number;

    private class NumberInputListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            int userNum = Integer.parseInt(numberInput.getText());
            if (userNum == generated_number){

                instructions.setText("Congratulations! You guessed the number!");
                afterInput.setText("You are a winner!!");

            }else{

                lives--;
                if (lives > 0){
                    livesLeft.setText("You have " + lives + " lives");
                    if (userNum > generated_number){
                        afterInput.setText("Please try a lower number");
                    } else {
                        afterInput.setText("Please try a higher number");
                    }
                } else {
                    instructions.setText("You are really not good at this game");
                    afterInput.setText("LOOOOOSER");
                    livesLeft.setText("YOU LOST");
                }
            }
        }
    }

    private class RestartButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            generated_number = new Random().nextInt(20) + 1;
            lives = 5;

            instructions.setText(MessageFormat.format("Guess a number between 1 and {0}", MAX_VALUE));
            afterInput.setText("Hello, welcome to our wonderful game🎮🕹️");
            livesLeft.setText(MessageFormat.format("You have {0} lives left", lives));
            numberInput.setText("");
        }
    }

    public GuessTheNumberFrame(){
        super("Guess the Number");
        setSize(300, 300);
        setLayout(new GridLayout(5, 1));

        initElements();
        addComponents();

        changeElementsLook();

        generated_number = new Random().nextInt(20) + 1;

        numberInput.addActionListener(new NumberInputListener());
        restart.addActionListener(new RestartButtonListener());

        setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void changeElementsLook(){

        instructions.setForeground(Color.RED);
        instructions.setBackground(Color.YELLOW);
        instructions.setOpaque(true);

        numberInput.setForeground(Color.RED);
        numberInput.setBackground(Color.PINK);
        numberInput.setOpaque(true);

        afterInput.setForeground(Color.RED);
        afterInput.setBackground(Color.CYAN);
        afterInput.setOpaque(true);

        livesLeft.setForeground(Color.RED);
        livesLeft.setBackground(Color.YELLOW);
        livesLeft.setOpaque(true);

        Font f = new Font("Arial", Font.BOLD, 16);
        instructions.setFont(f);
        numberInput.setFont(f);
        afterInput.setFont(f);
        livesLeft.setFont(f);
        restart.setFont(f);

    }

    private void addComponents() {
        add(instructions);
        add(numberInput);
        add(afterInput);
        add(livesLeft);
        add(restart);
    }

    private void initElements() {
        instructions =  new JLabel(MessageFormat.format("Guess a number between 1 and {0}", MAX_VALUE));
        afterInput = new JLabel("Hello, welcome to our wonderful game🎮🕹️");
        livesLeft = new JLabel(MessageFormat.format("You have {0} lives left", lives));
        numberInput = new JTextField();
        restart = new JButton("Restart");
    }


}
