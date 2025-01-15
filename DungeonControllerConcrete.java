public class DungeonControllerConcrete implements DungeonController
{
    DungeonView view;
    DungeonModel model;
    int aktuellerGegenstand;

    public DungeonControllerConcrete()
    {
    }

    public void setzeModel(DungeonModel m) {
        model =m;
    }

    public void setzeView(DungeonView v) {
        view = v;
    }

    public void empfangeBewegungVorwaerts() {
        if (model.canGoForward()) model.goForward();
    }

    public void empfangeBewegungDreheLinks() {
        model.turnLeft();        
    }

    public void empfangeBewegungDreheRechts() {
        model.turnRight();
    }

    public void empfangeBewegungJa() {
        Gegenstand g = model.gibGegenstandAnPosition();
        if (g==null) return;
        boolean geklappt = model.nimmGegenstand(g);
        if (geklappt) {
            model.entferneGegenstandAnPosition();            
            String bildname = Setup.gibBildname(g);
            aktuellerGegenstand = 0; //hmmmmm
            view.zeigeAusruestungGegenstandBild(bildname); //in Model?
        }
        //zB aufnehmen Gegenstand, oder Angreifen

    }

    public void empfangeBewegungNein() {
    }

    public void empfangeRucksackGegenstand() {
        Gegenstand g = null;
        g = model.gibAusRucksack(aktuellerGegenstand);
        if (g==null) return;
        view.zeigeAusruestungGegenstandBeschreibung(g.beschreibung);        
        //ausruesten?
        //anwenden?
        if (g instanceof Waffe) {
            entferneAusgewaehltesRucksack();
            empfangeRucksackDrop();
            model.setzeWaffe((Waffe)g);
        }
    }
    
    private void entferneAusgewaehltesRucksack() {
        Gegenstand g = model.gibAusRucksack(aktuellerGegenstand);
        if (g==null) return;    
        model.entferneAusRucksack(aktuellerGegenstand); //blaettern?
    }

    public void empfangeRucksackDrop() {
        Gegenstand g = model.gibAusRucksack(aktuellerGegenstand);
        if (g==null) return;    
        model.entferneAusRucksack(aktuellerGegenstand); //blaettern?
        model.setzeGegenstandAnPosition(g);
        
        aktuellerGegenstand = 0; //hmmmmmm
        
    }

    public void empfangeRucksackZurueck() {
        aktuellerGegenstand--;
        if (aktuellerGegenstand<0) aktuellerGegenstand = 0;
        Gegenstand g = null;
        g = model.gibAusRucksack(aktuellerGegenstand);
        if (g==null) {
            view.zeigeAusruestungGegenstandBild("images/nichts.png");        
            return;
        }
        view.zeigeAusruestungGegenstandBild(Setup.gibBildname(g));        
        view.zeigeAusruestungGegenstandName(g.name);        
    }

    public void empfangeRucksackVor() {
        aktuellerGegenstand++;
        int max = 9;
        if (aktuellerGegenstand>max) aktuellerGegenstand = max;
        Gegenstand g = null;
        g = model.gibAusRucksack(aktuellerGegenstand);
        if (g==null) {
            view.zeigeAusruestungGegenstandBild("images/nichts.png");        
            return;
        }
        view.zeigeAusruestungGegenstandBild(Setup.gibBildname(g));        
        view.zeigeAusruestungGegenstandName(g.name);        
    }

    public void empfangeFigurWaehleKoerperteil(int index) {
    }

    public void empfangeFigurButton(int index) {
    }

}
