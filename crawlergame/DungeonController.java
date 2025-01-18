package crawlergame;

public interface DungeonController
{

    void setModel(DungeonModel m);
    void setView(DungeonView v);
    void receiveRequest(int view, int nummer);
    
}
