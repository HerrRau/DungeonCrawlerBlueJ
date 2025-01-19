package crawlergame;


public interface DungeonModel
{
    public void setView(DungeonView d);

    void registerAsMoveable(Item i);    

    boolean canGoForward(); 

    boolean canGoForward(int x, int y, char facing); 

    public void goForward();

    public void turnLeft();

    public void turnRight();

    public void begin();
    
    public void setzeGegenstand(int posx, int posy, Item i);

    Item gibStandardgegenstand(char type);

    Item gibGegenstandAnAktuellerPosition();

    void entferneGegenstandAnAktuellerPosition();

    void entferneGegenstandAn(int x, int y);

    void setzeGegenstandAnAktuellerPosition(Item i);
    
    void bewegeGegenstandVonNach(int xalt, int yalt, int xneu, int yneu);

    public void moveMoveables();

    

}
