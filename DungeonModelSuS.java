import crawlergame.*;

public class DungeonModelSuS extends DungeonModelAbstract
{
    Figur figur;

    public DungeonModelSuS() {
        starteLevel();
    }

    public Figur gibFigur () {
        return figur;         
    }

    public void setzeFigur (Figur f) {
        figur = f;
    }    

    // unbenutzte Hilfsmethode
    public void zeigeLevel() {
        updateViewBewegung();
    }

    private void starteLevel()  {
        char [][] level;
        level = new char[4][4];
        level[0][0] = '-';
        level[0][1] = '-';
        level[0][2] = '-';
        level[0][3] = '-';
        level[1][0] = '-';
        level[1][1] = '-';
        level[1][2] = '-';
        level[1][3] = '-';
        level[2][0] = '-';
        level[2][1] = '-';
        level[2][2] = '-';
        level[2][3] = '-';
        level[3][0] = '-';
        level[3][1] = 'c';
        level[3][2] = '-';
        level[3][3] = 'w';
        level[1][0] = 'X';
        setzeLevel(level, 0, 1, 'N');
        
        setzeGegenstand(1,2,new Muenze());
    }  

    //##################################

    // used by DungeonModelAbstract and JPanel
    @Override public Gegenstand gibStandardgegenstand(char c) {
        if (c == 'c') return new Muenze();
        else if (c == 'w') return new Waffe();
        return null;        
    }

}
