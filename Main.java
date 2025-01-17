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
        controller.setzeModel(model);
        controller.setzeView(view);
        view.setzeController(controller);     

        Figur f = new Figur(); //Reihenfolge egal
        model.setzeFigur(f); // Reihenfolge egal
        f.setzeView(view); // Reihenfolge wichtig, muss vor model.setzeView - why?

        model.setzeView(view);

        f.setzeWaffe( new Waffe() );
        
        model.setzeGegenstand( 2,2,new Muenze());
        start();
    }

    void start() 
    {
        model.anfang();

    }

}
