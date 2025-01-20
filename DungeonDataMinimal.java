import crawlergame.*;

public class DungeonDataMinimal extends DungeonData
{
    private char [][] level;
    private int startX;
    private int startY;
    private char startFacing;

    //# Konstruktor
    
    public DungeonDataMinimal() {
        initialisiereLevel();
    }

    //# Getter (von Oberklasse verlangt)

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

    //# Private Hilfsmethode, muesste nicht sein

    private void initialisiereLevel()  {                
        int zeilen = 3;
        int spalten = 4;
        //Initialisieren der Variablen, insbesondere die Groesse
        level = new char[zeilen][spalten];
        //Fuellen des Levels
        level[0][0] = '-';
        level[0][1] = '-';
        level[0][2] = '-';
        level[0][3] = '-';
        level[1][0] = 'X';
        level[1][1] = '-';
        level[1][2] = 'X';
        level[1][3] = 'X';
        level[2][0] = '-';
        level[2][1] = '-';
        level[2][2] = '-';
        level[2][3] = '-';
        
        startX = 0;
        startY = 0;
        startFacing = 'N';
    }

    public Gegenstand gibStandardgegenstand(char c) {
        return null;
    }

}
