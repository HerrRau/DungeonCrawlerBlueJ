package crawlergame;

public abstract class DungeonControllerAbstract implements DungeonController
{
    protected DungeonView view;
    public DungeonModel model;
    protected int aktuellerGegenstand;

    public DungeonControllerAbstract()
    {
    }

    public void setzeModel(DungeonModel m) {
        model =m;
    }

    public void setzeView(DungeonView v) {
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

    private void empfangeBewegungJa() {
        // Gegenstand g = model.gibGegenstandAnPosition();
        // if (g==null) return;
        // boolean geklappt = model.nimmGegenstand(g);
        // if (geklappt) {
        // model.entferneGegenstandAnPosition();            
        // String bildname = Setup.gibBildname(g);
        // aktuellerGegenstand = 0; //hmmmmm
        // view.zeigeAusruestungGegenstandBild(bildname); //in Model?
        // }
        // //zB aufnehmen Gegenstand, oder Angreifen

    }

    private void empfangeBewegungNein() {
    }

    private void empfangeRucksackGegenstand() {
        // Gegenstand g = null;
        // g = model.gibAusRucksack(aktuellerGegenstand);
        // if (g==null) return;
        // view.zeigeAusruestungGegenstandBeschreibung(g.beschreibung);        
        // //ausruesten?
        // //anwenden?
        // if (g instanceof Waffe) {
        // entferneAusgewaehltesRucksack();
        // empfangeRucksackDrop();
        // model.setzeWaffe((Waffe)g);
        // }
    }

    private void entferneAusgewaehltesRucksack() {
        // Gegenstand g = model.gibAusRucksack(aktuellerGegenstand);
        // if (g==null) return;    
        // model.entferneAusRucksack(aktuellerGegenstand); //blaettern?
    }

    private void empfangeRucksackDrop() {
        // Gegenstand g = model.gibAusRucksack(aktuellerGegenstand);
        // if (g==null) return;    
        // model.entferneAusRucksack(aktuellerGegenstand); //blaettern?
        // model.setzeGegenstandAnPosition(g);

        // aktuellerGegenstand = 0; //hmmmmmm

    }

    private void empfangeRucksackZurueck() {
        // aktuellerGegenstand--;
        // if (aktuellerGegenstand<0) aktuellerGegenstand = 0;
        // Gegenstand g = null;
        // g = model.gibAusRucksack(aktuellerGegenstand);
        // if (g==null) {
        // view.zeigeAusruestungGegenstandBild("images/nichts.png");        
        // return;
        // }
        // view.zeigeAusruestungGegenstandBild(Setup.gibBildname(g));        
        // view.zeigeAusruestungGegenstandName(g.name);        
    }

    private void empfangeRucksackVor() {
        // aktuellerGegenstand++;
        // int max = 9;
        // if (aktuellerGegenstand>max) aktuellerGegenstand = max;
        // Gegenstand g = null;
        // g = model.gibAusRucksack(aktuellerGegenstand);
        // if (g==null) {
        // view.zeigeAusruestungGegenstandBild("images/nichts.png");        
        // return;
        // }
        // view.zeigeAusruestungGegenstandBild(Setup.gibBildname(g));        
        // view.zeigeAusruestungGegenstandName(g.name);        
    }

    private void empfangeFigurWaehleKoerperteil(int index) {
    }

    private void empfangeFigurButton(int index) {
    }

    public abstract String gibBildname(char c);

    public void empfangeWunsch(int view, int nummer) {
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
            switch (nummer) {
                case 0: empfangeBewegungVorwaerts(); break;
                case 1: empfangeBewegungDreheLinks(); break;
                case 2: empfangeBewegungDreheRechts(); break;
                case 3: empfangeBewegungJa(); break;
                case 4: empfangeBewegungNein(); break;
            }
        }

    }

}
