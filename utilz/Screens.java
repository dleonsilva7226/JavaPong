package utilz;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Screens {
    public static final String PAUSE_IMG = "res/paused_screen.png";
    public static final String INSTRUCTIONS_IMG = "res/instructions_screen.png";
    public static final String START_IMG = "res/start_screen.png";
    public static final String P1_WIN_IMG = "res/lose_screen.png";
    public static final String P2_WIN_IMG = "res/win_screen.png";

    //Implement Images For Different Game States Here Below!
    public static final Image PAUSE_SCREEN = new ImageIcon(PAUSE_IMG).getImage();
    public static final Image START_SCREEN = new ImageIcon(START_IMG).getImage();
    public static final Image INSTRUCTIONS_SCREEN = new ImageIcon(INSTRUCTIONS_IMG).getImage();
    public static final Image P1_WIN_SCREEN = new ImageIcon(P1_WIN_IMG).getImage();
    public static final Image P2_WIN_SCREEN = new ImageIcon(P2_WIN_IMG).getImage();
}
