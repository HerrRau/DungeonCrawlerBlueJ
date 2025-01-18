
public class DungeonControllerConcrete extends crawlergame.DungeonControllerAbstract
{

    //DungeonModelSuS model;

    public DungeonControllerConcrete()
    {
    }

    public void empfangeWunsch(int view, int nummer) {
        if (view == 2 && nummer<3) {
            super.empfangeWunsch(view, nummer);   
            return;   
        }

        if (view == 2) {
            if (nummer == 3) {
                empfangeBewegungJa();
            }
        }
        else if (view == 1) {
            if (nummer == 0) {
                empfangeRucksackZurueck();
            }
            if (nummer == 2) {
                empfangeRucksackVor();                               
            }
        }
    }

    // void setzeModel(DungeonModelSuS m)  {
    // model = m;     
    // }

    private void empfangeBewegungJa() {
        Gegenstand g = (Gegenstand) model.gibGegenstandAnAktuellerPosition();
        System.out.println("DCC "+g);
        if (g==null) return;
        boolean geklappt = ((DungeonModelSuS)model).gibFigur().nimmGegenstandAuf(g);
        if (geklappt) {
            model.entferneGegenstandAnAktuellerPosition();             
            aktuellerGegenstand = 0; //hmmmmm            
            view.zeigeAusruestungGegenstandBild(g.gibBildname()); //in Model?
        }
        // //zB aufnehmen Gegenstand, oder Angreifen

    }

    private void empfangeBewegungNein() {
    }

    // public void empfangeRucksackGegenstand() {
    // Gegenstand g = null;
    // g = model.gibFigur().gibAusRucksack(aktuellerGegenstand);
    // if (g==null) return;
    // view.zeigeAusruestungGegenstandBeschreibung(g.beschreibung);        
    // //ausruesten?
    // //anwenden?
    // if (g instanceof Waffe) {
    // entferneAusgewaehltesRucksack();
    // empfangeRucksackDrop();
    // model.gibFigur().setzeWaffe((Waffe)g);
    // }
    // }

    // private void entferneAusgewaehltesRucksack() {
    // Gegenstand g = model.gibFigur().gibAusRucksack(aktuellerGegenstand);
    // if (g==null) return;    
    // model.gibFigur().entferneAusRucksack(aktuellerGegenstand); //blaettern?
    // }

    // public void empfangeRucksackDrop() {
    // Gegenstand g = model.gibFigur().gibAusRucksack(aktuellerGegenstand);
    // if (g==null) return;    
    // model.gibFigur().entferneAusRucksack(aktuellerGegenstand); //blaettern?
    // model.setzeGegenstandAnPosition(g);

    // aktuellerGegenstand = 0; //hmmmmmm

    // }

    public void empfangeRucksackZurueck() {
        aktuellerGegenstand--;
        if (aktuellerGegenstand<0) aktuellerGegenstand = 0;
        Gegenstand g = null;
        g = ((DungeonModelSuS)model).gibFigur().gibAusRucksack(aktuellerGegenstand);
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
        g = ((DungeonModelSuS)model).gibFigur().gibAusRucksack(aktuellerGegenstand);
        if (g==null) {
            view.zeigeAusruestungGegenstandBild("images/nichts.png");        
            return;
        }
        view.zeigeAusruestungGegenstandBild(g.gibBildname());        
        view.zeigeAusruestungGegenstandName(g.name);        
    }

    // USED BY JPANEL und DungenModelAbstract
    @Override public Gegenstand  gibGegenstand(char c) {
        switch (c) {
            case 'c': return new Muenze();
            case 'w': return new Waffe();
                // case 'c': return "figur.png";
        }
        return null;
    }

}
