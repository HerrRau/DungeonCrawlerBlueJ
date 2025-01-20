package crawlergame;

public class DungeonViewConcrete implements DungeonView
{
    DungeonBewegungVorzimmer view1;
    DungeonFigurVorzimmer view2;
    DungeonRucksackVorzimmer view3;
    ViewPrinter printer;

    public DungeonViewConcrete()
    {
        printer = new ViewPrinter();
        view3 = new DungeonRucksackVorzimmer();
        view2 = new DungeonFigurVorzimmer();
        view1 = new DungeonBewegungVorzimmer();
    }

    public void setController(DungeonController c) {
        view1.setController(c);
        view2.setController(c);
        view3.setController(c);
    }

    public void zeigeBewegungAusschnitt(char[][] miniDungeon, int xPosPlayer, int yPosPlayer) {
        view1.zeigeBewegungAusschnitt(miniDungeon,xPosPlayer,yPosPlayer);
        printer.zeigeBewegungAusschnitt(miniDungeon, xPosPlayer, yPosPlayer);
    }

    public void zeigeBewegungDungeon(char[][] dungeon, int xPosPlayer, int yPosPlayer, char facing) {
        printer.zeigeBewegungDungeon(dungeon, xPosPlayer, yPosPlayer, facing);
        view1.zeigeBewegungDungeon(dungeon, xPosPlayer, yPosPlayer, facing);
    }

    public void zeigeBewegungGegenstand(String bildname) {
    }

    public void zeigeBewegungNachricht(String text) {
    }

    public void zeigeAusruestungGegenstandBild(String bildname) {
        view3.zeigeAusruestungGegenstandBild(bildname);
    }

    public void zeigeAusruestungGegenstandName(String name) {
        view3.zeigeAusruestungGegenstandName(name);
    }

    public void zeigeAusruestungGegenstandBeschreibung(String text) {
        view3.zeigeAusruestungGegenstandBeschreibung(text);
    }

    public void zeigeAusruestungNachricht(String name) {

    }

    public void zeigeFigurNachricht(String name) {
    }

    public void zeigeFigur(int koerperteil, String bildname) {
        view2.zeigeFigur(koerperteil, bildname);
    }

    public void zeigeFigurStats(String [] strings) {
        view2.zeigeFigurStats(strings);
    }

}
