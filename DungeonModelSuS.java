import crawlergame.*;

public class DungeonModelSuS extends DungeonModelAbstract
{
    Figur figur;

    public DungeonModelSuS()
    {
        //startbr machen ähnlich wie Figur startbar ist
        
        
        //setupLevel();
    }
    
    public void zeigeLevel() {
        updateViewBewegung();
    }
    
    public void setzeFigur (Figur f) {
        figur = f;
    }
    
    
    public Figur gibFigur () {
         return figur;         
    }
     
     // public void setzeWaffe(Waffe w) {
         // figur.setzeWaffe(w);
     // }


    void setupLevel()  {
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
        level[3][1] = '-';
        level[3][2] = '-';
        level[3][3] = '-';
        level[1][0] = '1';

        //setzeLevel(level, 0, 1, 'N');

    }    

    
}
