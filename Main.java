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
        Setup.setPath(this);

        model = new DungeonModelSuS();
        view = new DungeonViewConcrete();
        controller = new DungeonControllerConcrete();
        controller.setModel(model);
        controller.setView(view);
        view.setController(controller);     

        Figur f = new Figur(); //Reihenfolge egal
        model.setzeFigur(f); // Reihenfolge egal
        f.setView(view); // Reihenfolge wichtig, muss vor model.setzeView - why?

        model.setzeLevel();

        model.setView(view);
        
        // f.setzeWaffe( new Waffe() );

        model.setzeGegenstand( 2,2,new Monster());
        start();
    }

    void start() 
    {
        model.begin();
    }

}
