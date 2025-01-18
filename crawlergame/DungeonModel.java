package crawlergame;


public interface DungeonModel
{
    public void setView(DungeonView d);

    boolean canGoForward(); 

    public void goForward();

    public void goBack();

    public void turnLeft();

    public void turnRight();

    public void begin();
    
    public void setzeGegenstand(int posx, int posy, GEGENSTAND g);

    GEGENSTAND gibStandardgegenstand(char type);

    GEGENSTAND gibGegenstandAnAktuellerPosition();

    void entferneGegenstandAnAktuellerPosition();

    void setzeGegenstandAnAktuellerPosition(GEGENSTAND g);

}
