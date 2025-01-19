import crawlergame.*;

public class DungeonControllerMinimal extends DungeonControllerAbstract
{
    private Figur figur;

    public DungeonControllerMinimal() {
        figur = new Figur();
        figur.setView(view);
    }


}
