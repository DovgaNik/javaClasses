import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class SnakeGame {
    private JFrame frame;
    private JPanel panel;

    int snakeX = 1, snakeY = 1, snakeD = 20, dirX, dirY,
        appleX, appleY, appleD = 6,
        score;

    Boolean gameOver = false;

    private static double distanceBetweenPoints(int p1X, int p1Y, int p2X, int p2Y) {
        return Math.sqrt((p1X - p2X) * (p1X - p2X)  + (p1Y - p2Y) * (p1Y - p2Y));
    }

    private boolean checkSnakeCollisionWithApple() {
        int appleCenterX = appleX + appleD / 2;
        int appleCenterY = appleY + appleD / 2;
        int snakeCenterX = snakeX + snakeD / 2;
        int snakeCenterY = snakeY + snakeD / 2;

        return (distanceBetweenPoints(appleCenterX, appleCenterY, snakeCenterX, snakeCenterY) <= (snakeD / 2) + (appleD / 2));
    }

    private class SnakeKeyListener implements KeyListener {
        @Override
        public void keyTyped (KeyEvent e) {

        }

        @Override
        public void keyPressed (KeyEvent e) {
            if (gameOver)
                return;
            int code = e.getKeyCode();
            switch (code) {
                case KeyEvent.VK_H -> {dirX = -1; dirY = 0;}
                case KeyEvent.VK_L -> {dirX = 1; dirY = 0;}
                case KeyEvent.VK_K -> {dirX = 0; dirY = -1;}
                case KeyEvent.VK_J -> {dirX = 0; dirY = 1;}
            }

            if (isGameOver())
                gameOver = true;
            else
                moveSnake();

            if (checkSnakeCollisionWithApple()) {
                score++;
                snakeD += 2;
                generateNewApple();
            }

            panel.repaint();
        }

        @Override
        public void keyReleased (KeyEvent e) {

        }

    }

    private boolean isGameOver() {
        return snakeX <= 0 || snakeX + snakeD >= panel.getWidth() ||
                snakeY <= 0 || snakeY + snakeD >= panel.getHeight();
    }

    private void moveSnake() {
        snakeX += dirX;
        snakeY += dirY;
    }

    public SnakeGame () {
        frame = new JFrame("Snake game");
        panel = new JPanel(){
            @Override
            public void paintComponent (Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLACK);
                g.fillOval(snakeX, snakeY, snakeD, snakeD);
                g.setColor(Color.RED);
                g.fillOval(appleX, appleY, appleD, appleD);
                g.setColor(Color.BLACK);
                g.drawString("Score " + score, getWidth() - 50, getHeight() - 10);
                if (gameOver){
                    g.setColor(Color.RED);
                    g.drawString("GAME OVER", getWidth() - 250, getHeight() - 200);
                }
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(400, 400);
            }
        };
        initFrame();
    }

    private void initFrame() {
        frame.setLayout(new GridLayout(1, 1));
        frame.add(panel);
        frame.pack();
        generateNewApple();
        frame.addKeyListener(new SnakeKeyListener());
        frame.setVisible(true);
    }

    private void generateNewApple() {
        Random rand = new Random();
        appleX = rand.nextInt(panel.getWidth() - appleD);
        appleY = rand.nextInt(panel.getHeight() - appleD);
    }


}
