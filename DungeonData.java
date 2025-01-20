import crawlergame.*;

public abstract class DungeonData
{
    public abstract char[][] gibLevel();
    public abstract int gibStartX();
    public abstract int gibStartY();
    public abstract char gibStartFacing();
    public abstract Gegenstand gibStandardgegenstand(char c);
    
    public void zeichneLevel() {
        ViewPrinter printer = new ViewPrinter();
        printer.zeigeBewegungDungeon(gibLevel(), gibStartX(), gibStartY(), gibStartFacing());
    }
}
