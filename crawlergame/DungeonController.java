package crawlergame;

public interface DungeonController
{

    void setzeModel(DungeonModel m);
    void setzeView(DungeonView v);
    void empfangeWunsch(int view, int nummer);
    
}
