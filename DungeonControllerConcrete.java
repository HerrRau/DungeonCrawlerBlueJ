import crawlergame.Setup;
public class DungeonControllerConcrete extends crawlergame.DungeonControllerAbstract
{
    public DungeonControllerConcrete()
    {
    }

    @Override public void receiveRequest(int view, int nummer) {
        // System.out.println("DCC empfaengt: "+view+", "+nummer+"\n");
        if (view == 2 && nummer<3) {
            super.receiveRequest(view, nummer);   
            return;   
        }

        if (view == 2) {
            if (nummer == 3) {
                nimmGegenstand();
            }
        }
        else if (view == 1) {
            if (nummer == 0) {
                empfangeRucksackZurueck();
            }
            else if (nummer == 2) {
                empfangeRucksackVor();                               
            }
            else if (nummer == 3) {
                empfangeRucksackDrop();
            }

        }
    }

    private void nimmGegenstand() {
        Gegenstand g = (Gegenstand) model.gibGegenstandAnAktuellerPosition();
        
        if (g==null) return;
        boolean geklappt = ((DungeonModelSuS)model).gibFigur().nimmGegenstandAuf(g);
        if (geklappt) {
            model.entferneGegenstandAnAktuellerPosition();             
            aktuellerGegenstand = 0; //hmmmmm            
            view.zeigeAusruestungGegenstandBild(g.gibBildname()); //in Model?
        }
        // //zB aufnehmen Gegenstand, oder Angreifen

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
        // Gegenstand g = ((DungeonModelSuS)model).gibFigur().gibAusRucksack(aktuellerGegenstand);
        // if (g==null) return;    
        // ((DungeonModelSuS)model).gibFigur().entferneAusRucksack(aktuellerGegenstand); //blaettern?
    // }

    private void empfangeRucksackDrop() {
        Gegenstand g = ((DungeonModelSuS)model).gibFigur().gibAusRucksack(aktuellerGegenstand);
        if (g==null) return;    
        ((DungeonModelSuS)model).gibFigur().entferneAusRucksack(aktuellerGegenstand); //blaettern?
        model.setzeGegenstandAnAktuellerPosition(g);

        aktuellerGegenstand = 0; //hmmmmmm
        view.zeigeAusruestungGegenstandBild("nichts.png");        //hmmm

    }

    private void empfangeRucksackZurueck() {
        aktuellerGegenstand--;
        if (aktuellerGegenstand<0) aktuellerGegenstand = 0;
        Gegenstand g = null;
        g = ((DungeonModelSuS)model).gibFigur().gibAusRucksack(aktuellerGegenstand);
        if (g==null) {
            view.zeigeAusruestungGegenstandBild("nichts.png");        
            return;
        }
        view.zeigeAusruestungGegenstandBild(g.gibBildname());        
        view.zeigeAusruestungGegenstandName(g.gibName());        
    }

    private void empfangeRucksackVor() {
        aktuellerGegenstand++;
        int max = 9;
        if (aktuellerGegenstand>max) aktuellerGegenstand = max;
        Gegenstand g = null;
        g = ((DungeonModelSuS)model).gibFigur().gibAusRucksack(aktuellerGegenstand);
        if (g==null) {
            view.zeigeAusruestungGegenstandBild("nichts.png");        
            return;
        }
        view.zeigeAusruestungGegenstandBild(g.gibBildname());        
        view.zeigeAusruestungGegenstandName(g.gibName());        
    }


}
