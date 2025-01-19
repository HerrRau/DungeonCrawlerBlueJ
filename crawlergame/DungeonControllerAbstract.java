package crawlergame;

public abstract class DungeonControllerAbstract implements DungeonController
{
    protected DungeonView view;
    public DungeonModel model;
    protected int aktuellerGegenstand;

    public DungeonControllerAbstract()
    {
    }

    @Override public void setModel(DungeonModel m) {
        model =m;
    }

    @Override public void setView(DungeonView v) {
        view = v;
    }

    private void empfangeBewegungVorwaerts() {
        if (model.canGoForward()) model.goForward();        
    }

    private void empfangeBewegungDreheLinks() {
        model.turnLeft();        
    }

    private void empfangeBewegungDreheRechts() {
        model.turnRight();
    }

    public Item gibStandardgegenstand(char c) {
        return model.gibStandardgegenstand(c); 
    }

    @Override public void receiveRequest(int view, int nummer) {        
        if (view == 0) // Figur
        {
            switch(nummer) {
                // case 0: empfangeFigurWaehleKoerperteil(nummer); break;
                // case 1: empfangeFigurWaehleKoerperteil(nummer); break;
                // case 2: empfangeFigurWaehleKoerperteil(nummer); break;
                // case 3: empfangeFigurWaehleKoerperteil(nummer); break;
                // case 4: empfangeFigurWaehleKoerperteil(nummer); break;
                // case 5: empfangeFigurWaehleKoerperteil(nummer); break;
                // case 6: empfangeFigurWaehleKoerperteil(nummer); break;
                // case 7: empfangeFigurButton(0); break;

            }

        }
        else if (view == 1) // Ausruestung
        {
            switch(nummer) {
                // case 0: empfangeRucksackZurueck(); break;
                // case 1: empfangeRucksackGegenstand(); break;
                // case 2: empfangeRucksackVor(); break;
                // case 3: empfangeRucksackDrop(); break;
            }
        }
        if (view == 2) // Bewegung
        {
            model.moveMoveables();
            switch (nummer) {
                case 0: empfangeBewegungVorwaerts(); break;
                case 1: empfangeBewegungDreheLinks(); break;
                case 2: empfangeBewegungDreheRechts(); break;
                // case 3: empfangeBewegungJa(); break;
                // case 4: empfangeBewegungNein(); break;
            }
        }

    }

}
