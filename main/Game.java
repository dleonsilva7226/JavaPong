package main;

public class Game implements Runnable {
    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private Thread gameThread;

    private final int FPS_SET = 120;


    public Game () {
        this.gamePanel = new GamePanel();
        this.gameWindow = new GameWindow(gamePanel);
        gamePanel.setFocusable(true);
        gamePanel.requestFocus();
        startGameLoop();
    }

    private void startGameLoop() {
        this.gameThread = new Thread(this);
        gameThread.start();
    }



    @Override
    public void run() {
        double timePerFrame = 1000000000.0 / FPS_SET;

        long lastFrame = System.nanoTime();
        long currentFrame = System.nanoTime();
        int frames = 0;
        long lastCheck = System.currentTimeMillis();
        while (true) {
            currentFrame = System.nanoTime();
            if (currentFrame - lastFrame >= timePerFrame) {
                //Pauses the Game if the isPaused Variable is true
                if (!GamePanel.isPaused) {
                    gamePanel.updatePaddleYPos();
                    gamePanel.repaint();
                }
                lastFrame = currentFrame;
                frames++;
            }


            if (System.currentTimeMillis() - lastCheck >= 1000) {
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames);
                frames = 0;
            }
            
            
        
        }

    }
}
