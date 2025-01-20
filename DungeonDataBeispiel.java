import crawlergame.*;

public class DungeonDataBeispiel extends DungeonData
{
    char [][] level;
    int startX;
    int startY;
    char startFacing;
    
    public DungeonDataBeispiel() {
        setzeLevel();
    }

    public char[][] gibLevel() {
        return level;
    }

    public int gibStartX() {
        return startX;        
    }

    public int gibStartY() {
        return startY;        
    }

    public char gibStartFacing() {
        return startFacing;        
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
    void setzeLevelSIMPEL()  {        
        int zeilen = 1;
        int spalten = 7;
        //Initialisieren der Variablen, insbesondere die Groesse
        level = new char[zeilen][spalten];
        //Fuellen des Levels
        level[0][0] = '-';
        level[0][1] = '-';
        level[0][2] = '-';
        level[0][3] = 'c';
        level[0][4] = '-';
        level[0][5] = '-';
        level[0][6] = '-';
        //Absenden des Levels
        startX = 0;
        startY = 0;
        startFacing = 'N';

        //####################### lässt sich natragelich noch etwas am level veraendern, direkt, ohne Methode?

    }  
    void setzeLevelXXX()  {        
        int zeilen = 6;
        int spalten = 7;
        //temporale Variable fuer den Level
        //Initialisieren der Variablen, insbesondere die Groesse
        level = new char[zeilen][spalten];
        //Absenden des Levels
        startX = 0;
        startY = 0;
        startFacing = 'N';
    }  

    void setzeLevel()  {                
        //Initialisieren der Variablen, insbesondere die Groesse
        level = new char[4][7];
        //Fuellen des Levels
        level[0][0] = '-';
        level[0][1] = '-';
        level[0][2] = '-';
        level[0][3] = '-';
        level[0][4] = '-';
        level[0][5] = 'm';
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
        startX = 0;
        startY = 1;
        startFacing = 'N';
    }


    //################################## diese Methode ist wichtig fuer das Spiel

    // used by DungeonModelAbstract and JPanel
    public Gegenstand gibStandardgegenstand(char c) {
        //fast alle characters ausser X und - sind erlaubt (im Prinzip: 16-bit Unicode)
        if (c == 'c') return new Muenze();
        else if (c == 'w') return new Waffe();
        else if (c == 'm') return new Monster();
        else return null;        
    }

}
