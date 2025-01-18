package crawlergame;


public interface DungeonModel
{
    public void setzeView(DungeonView d);
    // weitere setzeLevel
    boolean canGoForward(); 

    int gibPosX();

    int gibPosY();

    public void goForward();

    public void goBack();

    public void turnLeft();

    public void turnRight();

    public void anfang();
    
    public void setzeGegenstand(int posx, int posy, GEGENSTAND g);

    // Gegenstand gibAusRucksack(int i);

    // void entferneAusRucksack(int i);

    GEGENSTAND gibGegenstandAnAktuellerPosition();

    // boolean nimmGegenstand(Gegenstand g);

    void entferneGegenstandAnAktuellerPosition();

    // void setzeGegenstandAnPosition(Gegenstand g);

}
