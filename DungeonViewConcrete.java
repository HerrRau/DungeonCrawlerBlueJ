public class DungeonViewConcrete implements DungeonView
{
    DungeonBewegungVorzimmer view1;
    DungeonFigurVorzimmer view2;
    DungeonRucksackVorzimmer view3;
    // DungeonController controller;
    ViewPrinter printer;

    public DungeonViewConcrete()
    {
        printer = new ViewPrinter();
        view3 = new DungeonRucksackVorzimmer();
        view2 = new DungeonFigurVorzimmer();
        view1 = new DungeonBewegungVorzimmer();
    }

    public void setzeController(DungeonController c) {
        // controller = c;
        view1.setzeController(c);
        view2.setzeController(c);
        view3.setzeController(c);
    }

    public void zeigeBewegungAusschnitt(char[][] miniDungeon, int xPosPlayer, int yPosPlayer) {
        view1.zeigeBewegungAusschnitt(miniDungeon,xPosPlayer,yPosPlayer);
        printer.zeigeBewegungAusschnitt(miniDungeon, xPosPlayer, yPosPlayer);
    }

    public void zeigeBewegungDungeon(char[][] dungeon, int xPosPlayer, int yPosPlayer, char facing) {
        printer.zeigeBewegungDungeon(dungeon, xPosPlayer, yPosPlayer, facing);
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

    public void zeigeFigurKoerperteil(int u, String bildname) {
    }

    public void zeigeFigurWaffe(String bildname) {
        view2.zeigeFigurWaffe(bildname);        
    }
}
