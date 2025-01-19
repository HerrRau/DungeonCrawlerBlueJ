package crawlergame;

import java.awt.event.WindowEvent;

public class ModelSender
{
    private DungeonFigurVorzimmer ansichtFigur;
    private DungeonRucksackVorzimmer ansichtAusruestung;
    private DungeonView view;

    public ModelSender()
    {
        Setup.setPathRelativeTo(this);
        if (Setup.useTestModeFigur) {
            ansichtFigur = new DungeonFigurVorzimmer();   
        }
    }

    public void setView(DungeonView v) {
        if (Setup.useTestModeFigur) return;
        view = v;
    }

    protected DungeonViewFigur gibAnsicht() {
        if (Setup.useTestModeFigur) return ansichtFigur;
        return view;
    }

    protected DungeonViewFigur gibAnsichtFigur() {
        return ansichtFigur;
    }

    protected DungeonViewAusruestung gibAnsichtAusruestung() {
        return ansichtAusruestung;
    }

}
