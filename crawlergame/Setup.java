package crawlergame;
import java.awt.*;

public class Setup
{
    public static boolean useTestModeFigur = false;
    public static Color backgroundColor = Color.WHITE;
    public static String imagePath = "images/";
    public final static char EMPTY = '-';
    public final static char BLOCK = 'X';
    public final static char FACING_N = 'A';
    public final static char FACING_E = '>';
    public final static char FACING_S = 'V';
    public final static char FACING_W = '<';

    static Class cls;

    public static void setPath(Object o) {
        cls = o.getClass();
    }

    public static java.net.URL getResource(String filename) {
        return cls.getResource(imagePath+filename);
    }

}
