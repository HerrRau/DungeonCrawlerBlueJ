package crawlergame;

public interface DungeonViewFigur
{
    void setController(DungeonController c);

    void zeigeFigurNachricht(String name);

    void zeigeFigur(int koerperteil, String bildname);

    void zeigeFigurStats(String [] strings);

}
