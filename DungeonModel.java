import crawlergame.*;

public class DungeonModel extends DungeonModelAbstract
{
    DungeonData dungeonData;

    public DungeonModel() {
        // dungeonData = new DungeonDataBeispiel();
        dungeonData = new DungeonDataMinimal();
    }
    
    public void setzeLevel() {
        super.setzeLevel(dungeonData.gibLevel(), dungeonData.gibStartX(), dungeonData.gibStartY(), dungeonData.gibStartFacing());
    }

    // used by DungeonModelAbstract and JPanel
    @Override
    public Gegenstand gibStandardgegenstand(char c) {
        return dungeonData.gibStandardgegenstand(c);
    }

}
