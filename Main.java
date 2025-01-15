    
public class Main
{
    DungeonModel model;
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
        model.setzeView(view);
        start();
    }

    void start() {
        Figur f = new Figur();
        f.setzeView(view);
        model.setzeFigur(f);
        model.anfang();
        f.setzeWaffe( new Waffe() );
        
    }

}
