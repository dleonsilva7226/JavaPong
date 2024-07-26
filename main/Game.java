package main;

public class Game implements Runnable {
    public static GameWindow gameWindow;
    private GamePanel gamePanel;
    private Thread gameThread;

    private final int FPS_SET = 120;
    private final int UPS_SET = 200;


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
        double timePerUpdate = 1000000000.0 / UPS_SET;

        long previousTime = System.nanoTime();
        // long currentTime = System.nanoTime();
        int frames = 0;
        int updates = 0;

        double deltaU = 0;
        double deltaF = 0;
        long lastCheck = System.currentTimeMillis();
        while (true) {
            long currentTime = System.nanoTime();
            deltaF += (currentTime - previousTime) / timePerFrame;
            deltaU += (currentTime - previousTime) / timePerUpdate;

            previousTime = currentTime;

            if (deltaU >= 1) {
                update();
                updates++;
                deltaU--;
            }
            
            if (deltaF >= 1) {
                gamePanel.repaint();
                frames++;
                deltaF--;
            }

            // if (currentFrame - lastFrame >= timePerFrame) {
            //     //Pauses the Game if the isPaused Variable is true
            //     // startGame();
            //     gamePanel.pauseGame();
            //     // endGame();
            //     if (!GamePanel.isPaused) {
            //         gameWindow.setUnpauseTitle();
            //         gamePanel.updatePaddleYPos();
            //         gamePanel.repaint();
            //     } else {
            //         // gameWindow.setPauseScreen(GamePanel.isPaused);
            //         gameWindow.setPauseTitle();
            //     }
                
            //     lastFrame = currentFrame;
            //     frames++;
            // }

            if (System.currentTimeMillis() - lastCheck >= 1000) {
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames + "| UPS: " + updates);
                frames = 0;
                updates = 0;
            }
        }

    }

    private void update() {
        gamePanel.updateGame();
    }
}
