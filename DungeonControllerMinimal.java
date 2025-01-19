import crawlergame.*;

public class DungeonControllerMinimal extends DungeonControllerAbstract
{
    private Figur figur;

    public DungeonControllerMinimal() {
        figur = new Figur();
    }

    @Override public void setView(DungeonView view) {
        super.setView(view);
        figur.setView(view);
    }

}
