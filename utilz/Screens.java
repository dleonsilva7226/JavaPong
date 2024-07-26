package utilz;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Screens {
    public static final String PAUSE_IMG = "res/paused_screen.png";
    public static final String INSTRUCTIONS_IMG = "res/instructions_screen.png";
    public static final String START_IMG = "res/start_screen.png";
    public static final String LOSE_IMG = "res/lose_screen.png";
    public static final String WIN_IMG = "res/win_screen.png";

    //Implement Images For Different Game States Here Below!
    public static final Image PAUSE_SCREEN = new ImageIcon(PAUSE_IMG).getImage();
    public static final Image START_SCREEN = new ImageIcon(START_IMG).getImage();
    public static final Image INSTRUCTIONS_SCREEN = new ImageIcon(INSTRUCTIONS_IMG).getImage();
    public static final Image WIN_SCREEN = new ImageIcon(WIN_IMG).getImage();
    public static final Image LOSE_SCREEN = new ImageIcon(LOSE_IMG).getImage();
}
