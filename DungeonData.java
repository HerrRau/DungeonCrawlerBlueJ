import crawlergame.*;

public abstract class DungeonData
{
    DungeonModel model;

    public void setzeModel(DungeonModel m) { 
        model =m; 
    }

    public void zeichneLevel() {
        ViewPrinter printer = new ViewPrinter();
        if (model != null) {
            model.begin();
        } else {
             printer.zeigeBewegungDungeon(gibLevel(), gibStartX(), gibStartY(), gibStartFacing());
        }
    }

    public void ergaenzeLevel()  {

    }

    public abstract char[][] gibLevel();

    public abstract int gibStartX();

    public abstract int gibStartY();

    public abstract char gibStartFacing();

    public abstract Gegenstand gibStandardgegenstand(char c);

}
