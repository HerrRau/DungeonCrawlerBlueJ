package crawlergame;

public interface DungeonViewFigur
{
    void setzeController(DungeonController c);

    void zeigeFigurNachricht(String name);

    void zeigeFigurKoerperteil(int u, String bildname);

    void zeigeFigurWaffe(String bildname);

}
