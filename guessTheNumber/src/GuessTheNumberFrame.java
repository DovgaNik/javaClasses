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
    JPanel components;
    JPanel canvas;
    private int MAX_VALUE = 20,
        lives = 5,
        generated_number;

    private Boolean isWon = false;

    private class drawingAreaPanel extends JPanel{
        @Override
        public void paintComponent(Graphics g){

            if(isWon){
                Font f = new Font("Comic Sans", Font.BOLD, 30);
                g.setFont(f);
                FontMetrics fm = g.getFontMetrics();
                String congrats = "Felicitari";
                g.drawString(congrats , getWidth() / 2 - fm.stringWidth(congrats) / 2, getHeight() / 2 - fm.getHeight());

            } else {

                super.paintComponent(g);

                switch (lives) {
                    case 0:
                        drawCross(g);
                    case 1:
                        drawLegs(g);
                    case 2:
                        drawArms(g);
                    case 3:
                        drawBody(g);
                    case 4:
                        drawHead(g);
                }

            }
        }

        private void drawBody(Graphics g) {
            g.drawLine(200, 120, 200, 220);
        }

        private void drawArms(Graphics g) {
            g.drawLine(200, 150, 150, 130);
            g.drawLine(200, 150, 250, 130);
        }

        private void drawLegs(Graphics g) {
            g.drawLine(120, 260, 200, 220);
            g.drawLine(280, 260, 200, 220);
        }

        private void drawCross(Graphics g) {
            g.drawLine(0, 0, getWidth(), getHeight());
            g.drawLine(getWidth(), 0, 0, getHeight());
        }

        private void drawHead(Graphics g) {
            g.drawOval(150, 20, 100, 100);

            g.drawLine(175, 40, 185, 40);
            g.drawLine(215, 40, 225, 40);

            g.drawLine(200, 50, 200, 80);

            g.drawArc(165, 90, 70, 70, 45, 90);
        }


    }

    private class NumberInputListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            int userNum = Integer.parseInt(numberInput.getText());
            if (userNum == generated_number){

                instructions.setText("Congratulations! You guessed the number!");
                afterInput.setText("You are a winner!!");
                isWon = true;
                canvas.repaint();

            }else{

                lives--;
                canvas.repaint();
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
            afterInput.setText("Hello, welcome to our wonderful game");
            livesLeft.setText(MessageFormat.format("You have {0} lives left", lives));
            numberInput.setText("");
            canvas.repaint();
            isWon = false;
        }
    }

    public GuessTheNumberFrame(){
        super("Guess the Number");
        setSize(400, 600);
        setLayout(new GridLayout(2, 1));
        setResizable(false);

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
        add(components);
        add(canvas);

        components.add(instructions);
        components.add(numberInput);
        components.add(afterInput);
        components.add(livesLeft);
        components.add(restart);
    }

    private void initElements() {
        instructions =  new JLabel(MessageFormat.format("Guess a number between 1 and {0}", MAX_VALUE));
        afterInput = new JLabel("Hello, welcome to our wonderful game🎮🕹️");
        livesLeft = new JLabel(MessageFormat.format("You have {0} lives left", lives));
        numberInput = new JTextField();
        restart = new JButton("Restart");
        components = new JPanel();
        components.setLayout(new GridLayout(5, 1));
        canvas = new drawingAreaPanel();
    }


}
