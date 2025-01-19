import crawlergame.*;

public class DungeonModelSuS extends DungeonModelAbstract
{
    private Figur figur;

    public DungeonModelSuS() {
        starteLevel();
    }

    public Figur gibFigur () {
        return figur;         
    }

    public void setzeFigur (Figur f) {
        figur = f;
    }    

    // Hilfsmethode zum Anschauen
    public void zeichneLevel() {
        updateViewBewegung();
    }

    //################################## ab hier darfst du arbeiten

    /**
     * Am Ende muss die Methode setzeLevel(char [][] spielfeld, int startx, int starty, char blickrichtung) aufgerufen werden
     * Moegliche Blickrichtungen sind nur: 'N', 'E', 'S', 'W'
     * Die Startposition muss innerhalb des Spielfelds liegen
     * Das Spielfeld muss nicht quadratisch sein, aber rechteckig
     * Anders als ueblich gibt bei diesem Array die erste Zahl die Hoehe, die zweite die Breite an, das hat technische Gruende
     * Typisches Vorgehen: Ein leeres char[][] von ebstimmter Groesse in einer Variable speichern und nach und nach fuellen
     * Moegle Inhalte: '-' fuer leer, 'X' fuer Block, und ansonsten nur das, was du in gibStandardgegenstand angegeben hast
     */
    void starteLevel()  {                
        //temporale Variable fuer den Level
        char [][] level;
        //Initialisieren der Variablen, insbesondere die Groesse
        level = new char[4][7];
        //Fuellen des Levels
        level[0][0] = '-';
        level[0][1] = '-';
        level[0][2] = '-';
        level[0][3] = '-';
        level[0][4] = '-';
        level[0][5] = '-';
        level[0][6] = '-';
        level[1][0] = '-';
        level[1][1] = 'X';
        level[1][2] = 'X';
        level[1][3] = 'X';
        level[1][4] = '-';
        level[1][5] = '-';
        level[1][6] = '-';
        level[2][0] = '-';
        level[2][1] = '-';
        level[2][2] = '-';
        level[2][3] = '-';
        level[2][4] = '-';
        level[2][5] = '-';
        level[2][6] = '-';
        level[3][0] = '-';
        level[3][1] = 'c';
        level[3][2] = '-';
        level[3][3] = 'w';
        level[3][4] = '-';
        level[3][5] = '-';
        level[3][6] = '-';
        //Absenden des Levels
        setzeLevel(level, 0, 1, 'N');
        //nachtraeglich
        setzeGegenstand(0,2, new Muenze());
        zeichneLevel();
    }  


    void starteLevelSIMPEL()  {                
        //temporale Variable fuer den Level
        char [][] level;
        //Initialisieren der Variablen, insbesondere die Groesse
        level = new char[1][7];
        //Fuellen des Levels
        level[0][0] = '-';
        level[0][1] = '-';
        level[0][2] = '-';
        level[0][3] = 'c';
        level[0][4] = '-';
        level[0][5] = '-';
        level[0][6] = '-';
        //Absenden des Levels
        setzeLevel(level, 0, 0, 'N');
        zeichneLevel();
    }  

    //################################## diese Methode ist wichtig fuer das Spiel

    // used by DungeonModelAbstract and JPanel
    @Override
    public Gegenstand gibStandardgegenstand(char c) {
        //fast alle characters ausser X und - sind erlaubt (im Prinzip: 16-bit Unicode)
        if (c == 'c') return new Muenze();
        else if (c == 'w') return new Waffe();
        else return null;        
    }

}
