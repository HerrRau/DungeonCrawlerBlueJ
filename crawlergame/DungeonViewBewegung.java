package crawlergame;

public interface DungeonViewBewegung
{
    void setController(DungeonController c);

    void zeigeBewegungAusschnitt(char[][] miniDungeonTemp, int xPosPlayer, int yPosPlayer);

    void zeigeBewegungDungeon(char[][] dungeon, int xPosPlayer, int yPosPlayer, char facing);

    void zeigeBewegungGegenstand(String bildname);

    void zeigeBewegungNachricht(String text);


}
