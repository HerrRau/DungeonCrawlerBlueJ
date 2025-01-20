import crawlergame.*;
import java.net.URL;
import javax.swing.*;

public class Main
{
    DungeonModel model;
    DungeonView view;
    DungeonController controller;

    public static void main(String[] args) {
        new Main();        
    }

    public Main()
    {
        Setup.useTestModeFigur = false; 
        Setup.setPathRelativeTo(this);

        model = new DungeonModel();
        view = new DungeonViewConcrete();
        controller = new DungeonController();
        controller.setModel(model);
        controller.setView(view);
        view.setController(controller);     
        model.setzeLevel();
        model.setView(view);
        model.begin(); // -> macht nur updateView
        //model.setzeGegenstand( 2,2,new Monster());
    }

}
