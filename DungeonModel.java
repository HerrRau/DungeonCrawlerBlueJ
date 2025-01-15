
public interface DungeonModel
{
    public void setzeView(DungeonView d);

    public void setzeFigur (Figur f);

    // public Figur gibFigur ();

    // weitere setzeLevel

    public void setzeWaffe(Waffe w);

    boolean canGoForward(); 

    int gibPosX();

    int gibPosY();

    public void goForward();

    public void goBack();

    public void turnLeft();

    public void turnRight();

    public void anfang();

    Gegenstand gibAusRucksack(int i);

    void entferneAusRucksack(int i);

    Gegenstand gibGegenstandAnPosition();

    boolean nimmGegenstand(Gegenstand g);

    void entferneGegenstandAnPosition();

    void setzeGegenstandAnPosition(Gegenstand g);

}
