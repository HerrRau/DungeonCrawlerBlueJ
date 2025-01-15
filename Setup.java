public class Setup
{
    final static char EMPTY = '-';
    final static char BLOCK = '1';
    final static String imagePath = "images/";
    static boolean useTestMode = false;
    final static char FACING_N = 'A';
    final static char FACING_E = '>';
    final static char FACING_S = 'V';
    final static char FACING_W = '<';

    // //unused
    // static Gegenstand gibGegenstand(char c) {
        // if (c == 'c') return new Muenze();
        // else return null;
    // }

    static char gibKuerzel(Gegenstand g) {
        if (true) return g.gibKuerzel();
        
        if (g instanceof Muenze) return 'c';
        else if (g instanceof Waffe) return 'w';
        return ' ';
    }

    static String gibBildname(Gegenstand g) {
        if (true) return g.gibBildname();
        
        if (g.bildname != null) return g.bildname;
        return gibBildname(gibKuerzel(g));
    }

    //make private / View -> arbeitet nur mit char[][]
    static String gibBildname(char c) {
        switch (c) {
                case 'c': return "coin.png";
                case 'w': return "sword.png";
            // case 'c': return "figur.png";
        }
        return "nichts.png";
    }
    
    // makle printer einen eiegenen View
}
