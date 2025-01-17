package crawlergame;

public interface DungeonController
{

    void setzeModel(DungeonModel m);
    void setzeView(DungeonView v);
    
    // void empfangeBewegungVorwaerts();
    // void empfangeBewegungDreheLinks();
    // void empfangeBewegungDreheRechts();
    // void empfangeBewegungJa();
    // void empfangeBewegungNein();
    // void empfangeRucksackGegenstand();
    // void empfangeRucksackDrop();
    // void empfangeRucksackZurueck();
    // void empfangeRucksackVor();
    // void empfangeFigurWaehleKoerperteil(int index);
    // void empfangeFigurButton(int index);
    void empfangeWunsch(int view, int nummer);

    
}
