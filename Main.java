import crawlergame.*;
import java.net.URL;
import javax.swing.*;

public class Main
{
    DungeonModelSuS model;
    DungeonView view;
    DungeonController controller;

    public static void main(String[] args) {
        new Main();        
    }

    public Main()
    {
        Setup.useTestModeFigur = false; 
        Setup.setPathRelativeTo(this);

        model = new DungeonModelSuS();
        view = new DungeonViewConcrete();
        controller = new DungeonControllerConcrete();
        controller.setModel(model);
        controller.setView(view);
        view.setController(controller);     
        model.setzeLevel();
        model.setView(view);
        model.begin();
        //model.setzeGegenstand( 2,2,new Monster());
    }

}
