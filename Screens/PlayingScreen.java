package Screens;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.*;

public class PlayingScreen extends JFrame {
    protected final static int screenHeight = 1100;
    protected final static int screenWidth = 800;
    public PlayingScreen () {

        this.setTitle("PlayerOne Score <INSERT-NUM>, PlayerTwo Score<INSERT-NUM>");
        this.setSize(screenHeight, screenWidth);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(createPanel());
        this.setVisible(true);
    }

    private JPanel createPanel() {
        JPanel newPanel = new JPanel();
        newPanel.setBackground(Color.BLACK);
        newPanel.setVisible(true);
        return newPanel;
    }

    // private JComponent createCenterLine(Graphics g) {
        
    // }

}
