import crawlergame.*;

public class DungeonModel extends DungeonModelAbstract
{
    private DungeonData dungeonData;

    public DungeonModel(DungeonData d) {
        dungeonData = d;
        dungeonData.setzeModel(this);
        aktualisiereLevel();
    }
    
    private void aktualisiereLevel() {
        super.setzeLevel(dungeonData.gibLevel(), dungeonData.gibStartX(), dungeonData.gibStartY(), dungeonData.gibStartFacing());
        dungeonData.ergaenzeLevel();
    }

    // used by DungeonModelAbstract and JPanel
    @Override
    public Gegenstand gibStandardgegenstand(char c) {
        return dungeonData.gibStandardgegenstand(c);
    }
    

}
