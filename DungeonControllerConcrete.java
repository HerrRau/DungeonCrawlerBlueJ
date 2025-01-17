
public class DungeonControllerConcrete extends crawlergame.DungeonControllerAbstract
{
    
    DungeonModelSuS model;

    public DungeonControllerConcrete()
    {
    }

    // public void empfangeWunsch(int view, int nummer) {
        
    // }

    void setzeModel(DungeonModelSuS m)  {
        model = m;    
    }

    public void empfangeBewegungJa() {
        // Gegenstand g = model.gibGegenstandAnPosition();
        // if (g==null) return;
        // boolean geklappt = model.gibFigur().nimmGegenstandAuf(g);
        // if (geklappt) {
            // model.entferneGegenstandAnPosition();            
            // String bildname = crawlergame.Setup.gibBildname(g);
            // aktuellerGegenstand = 0; //hmmmmm
            // view.zeigeAusruestungGegenstandBild(bildname); //in Model?
        // }
        // //zB aufnehmen Gegenstand, oder Angreifen

    }

    public void empfangeBewegungNein() {
    }

    public void empfangeRucksackGegenstand() {
        Gegenstand g = null;
        g = model.gibFigur().gibAusRucksack(aktuellerGegenstand);
        if (g==null) return;
        view.zeigeAusruestungGegenstandBeschreibung(g.beschreibung);        
        //ausruesten?
        //anwenden?
        if (g instanceof Waffe) {
            entferneAusgewaehltesRucksack();
            empfangeRucksackDrop();
            model.gibFigur().setzeWaffe((Waffe)g);
        }
    }

    private void entferneAusgewaehltesRucksack() {
        Gegenstand g = model.gibFigur().gibAusRucksack(aktuellerGegenstand);
        if (g==null) return;    
        model.gibFigur().entferneAusRucksack(aktuellerGegenstand); //blaettern?
    }

    public void empfangeRucksackDrop() {
        Gegenstand g = model.gibFigur().gibAusRucksack(aktuellerGegenstand);
        if (g==null) return;    
        model.gibFigur().entferneAusRucksack(aktuellerGegenstand); //blaettern?
        model.setzeGegenstandAnPosition(g);

        aktuellerGegenstand = 0; //hmmmmmm

    }

    public void empfangeRucksackZurueck() {
        aktuellerGegenstand--;
        if (aktuellerGegenstand<0) aktuellerGegenstand = 0;
        Gegenstand g = null;
        g = model.gibFigur().gibAusRucksack(aktuellerGegenstand);
        if (g==null) {
            view.zeigeAusruestungGegenstandBild("images/nichts.png");        
            return;
        }
        view.zeigeAusruestungGegenstandBild(g.gibBildname());        
        view.zeigeAusruestungGegenstandName(g.name);        
    }

    public void empfangeRucksackVor() {
        aktuellerGegenstand++;
        int max = 9;
        if (aktuellerGegenstand>max) aktuellerGegenstand = max;
        Gegenstand g = null;
        g = model.gibFigur().gibAusRucksack(aktuellerGegenstand);
        if (g==null) {
            view.zeigeAusruestungGegenstandBild("images/nichts.png");        
            return;
        }
        view.zeigeAusruestungGegenstandBild(g.gibBildname());        
        view.zeigeAusruestungGegenstandName(g.name);        
    }

    public void empfangeFigurWaehleKoerperteil(int index) {
    }

    public void empfangeFigurButton(int index) {
    }

        public String gibBildname(char c) {
        switch (c) {
            case 'c': return "coin.png";
            case 'w': return "sword.png";
                // case 'c': return "figur.png";
        }
        return "nichts.png";
    }

}
