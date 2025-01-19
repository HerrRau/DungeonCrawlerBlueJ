package crawlergame;
import java.awt.*;
import javax.swing.*;

public class Setup
{
    public static boolean useTestModeFigur = true;
    public static Color backgroundColor = Color.WHITE;
    public static String imagePath = "images/";
    public final static char EMPTY = '-';
    public final static char BLOCK = 'X';
    public final static char BLOCK_BORDER = '×';
    public final static char FACING_N = 'A';
    public final static char FACING_E = '>';
    public final static char FACING_S = 'V';
    public final static char FACING_W = '<';
    public static DungeonModel model;

    static Class cls;
    
    static {
        setPathRelativeTo (new Setup () ); //standardmaessig alles relytiv zum Speicherort dieser Klasse
    }

    public static void setPathRelativeTo(Object o) {
        cls = o.getClass(); // alle URl-Anfragen relativ zum Speicherot der Klasse des uebergebenen Objekts
    }

    public static java.net.URL getResource(String filename) {
        return cls.getResource(imagePath+filename); 
    }
    
    static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
        Image img = icon.getImage();  
        Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight,  java.awt.Image.SCALE_SMOOTH);  
        return new ImageIcon(resizedImage);
    }


}
