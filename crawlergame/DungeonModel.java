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
    
    public void setzeGegenstand(GEGENSTAND g, int posx, int posy);

    // Gegenstand gibAusRucksack(int i);

    // void entferneAusRucksack(int i);

    // Gegenstand gibGegenstandAnPosition();

    // boolean nimmGegenstand(Gegenstand g);

    // void entferneGegenstandAnPosition();

    // void setzeGegenstandAnPosition(Gegenstand g);

}
