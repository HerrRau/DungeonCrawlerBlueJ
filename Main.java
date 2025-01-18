import crawlergame.*;

public class Main
{
    DungeonModelSuS model;
    DungeonView view;
    DungeonController controller;


    public Main()
    {
        model = new DungeonModelSuS();

        view = new DungeonViewConcrete();
        controller = new DungeonControllerConcrete();
        controller.setModel(model);
        controller.setView(view);
        view.setController(controller);     

        Figur f = new Figur(); //Reihenfolge egal
        model.setzeFigur(f); // Reihenfolge egal
        f.setView(view); // Reihenfolge wichtig, muss vor model.setzeView - why?

        model.setView(view);

        f.setzeWaffe( new Waffe() );
        
        //model.setzeGegenstand( 2,2,new Muenze());
        start();
    }

    void start() 
    {
        model.begin();

    }

}
