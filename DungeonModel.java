import crawlergame.*;

public class DungeonModel extends DungeonModelAbstract
{
    DungeonData dungeonData;

    public DungeonModel(DungeonData d) {
        dungeonData = d;
        setzeLevel();
    }
    
    public void setzeLevel() {
        super.setzeLevel(dungeonData.gibLevel(), dungeonData.gibStartX(), dungeonData.gibStartY(), dungeonData.gibStartFacing());
        ergaenzeLevel();
    }

    // used by DungeonModelAbstract and JPanel
    @Override
    public Gegenstand gibStandardgegenstand(char c) {
        return dungeonData.gibStandardgegenstand(c);
    }
    
    public void ergaenzeLevel() {
        
    }

}
