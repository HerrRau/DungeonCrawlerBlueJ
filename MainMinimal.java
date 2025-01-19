import crawlergame.*;
import java.net.URL;
import javax.swing.*;

public class MainMinimal
{
    DungeonModelMinimal model;
    DungeonView view;
    DungeonControllerMinimal controller;

    public MainMinimal()
    {
        Setup.useTestModeFigur = false; 
        Setup.setPathRelativeTo(this);

        model = new DungeonModelMinimal();
        view = new DungeonViewConcrete();
        controller = new DungeonControllerMinimal();
        controller.setModel(model);
        controller.setView(view);
        view.setController(controller);     
        model.setView(view);
        model.begin();    
    }

}
