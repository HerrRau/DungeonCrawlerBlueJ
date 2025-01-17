package crawlergame;

import java.awt.event.WindowEvent;

public class ModelSender
{
    private DungeonFigurVorzimmer ansicht;
    private DungeonView view;


    public ModelSender()
    {
        if (Setup.useTestMode) ansicht = new DungeonFigurVorzimmer();
    }

    public void setzeView(DungeonView v) {
        if (Setup.useTestMode) return;
        view = v;
    }

    protected DungeonViewFigur gibAnsicht() {
        if (Setup.useTestMode) return ansicht;
        return view;
    }


}
