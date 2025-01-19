import crawlergame.*;

public class DungeonControllerConcrete extends DungeonControllerAbstract
{
    Figur figur;
    
    public DungeonControllerConcrete()
    {
        figur = new Figur();
        figur.setView(view);
    }

    @Override
    public void receiveRequest(int view, int nummer) {
        // System.out.println("DCC empfaengt: "+view+", "+nummer+"\n");
        if (view == 2) {
            switch(nummer) {
                case 0: super.receiveRequest(view, nummer); break; //moveables sollen moven
                case 1: super.receiveRequest(view, nummer); break;
                case 2:  super.receiveRequest(view, nummer); break;
                case 3: nimmGegenstand(); break;
            }
        }
        else if (view == 1) {
            switch(nummer) {
                case 0: empfangeRucksackZurueck(); break;
                case 1: empfangeRucksackGegenstand(); break; 
                case 2: empfangeRucksackVor(); break;                               
                case 3: empfangeRucksackDrop(); break;
            }
        }
        else if (view == 0) {
            if (nummer<7) empfangeFigurKoerperteil(nummer); 
        }
    }

    public Gegenstand gibGegenstandAnAktuellerPosition() {
        return (Gegenstand) model.gibGegenstandAnAktuellerPosition();
    }

    public Figur gibFigur() {
        return figur;
        // return ((DungeonModelSuS)model).gibFigur();
    }

    //##################

    private void nimmGegenstand() {
        Gegenstand g = gibGegenstandAnAktuellerPosition();

        if (g==null) return;
        int geklappt = gibFigur().nimmGegenstandAuf(g);
        if (geklappt!=-1) {
            model.entferneGegenstandAnAktuellerPosition();             
            aktuellerGegenstand = geklappt; //hmmmmm            
            view.zeigeAusruestungGegenstandBild(g.gibBildname()); //in Model?
        }
        // //zB aufnehmen Gegenstand, oder Angreifen

    }

    private void empfangeRucksackGegenstand() {
        Gegenstand g = gibFigur().gibAusRucksack(aktuellerGegenstand);
        if (g==null) return;
        if (g instanceof Waffe) {
            entferneAusgewaehltesRucksack();
            //empfangeRucksackDrop();
            gibFigur().setzeWaffe((Waffe)g);
        }
    }

    private void entferneAusgewaehltesRucksack() {
        Gegenstand g = gibFigur().gibAusRucksack(aktuellerGegenstand);
        if (g==null) return;    
        gibFigur().entferneAusRucksack(aktuellerGegenstand); //blaettern?
        aktuellerGegenstand = 0; //hmmmmmm
        view.zeigeAusruestungGegenstandBild("nichts.png");        //hmmm // blättern?
    }

    private void empfangeRucksackDrop() {
        Gegenstand g = gibFigur().gibAusRucksack(aktuellerGegenstand);
        if (g==null) return;    
        gibFigur().entferneAusRucksack(aktuellerGegenstand); //blaettern?
        model.setzeGegenstandAnAktuellerPosition(g);

        aktuellerGegenstand = 0; //hmmmmmm
        view.zeigeAusruestungGegenstandBild("nichts.png");        //hmmm // blättern?

    }

    private void empfangeRucksackZurueck() {
        aktuellerGegenstand--;
        if (aktuellerGegenstand<0) aktuellerGegenstand = 0;
        Gegenstand g = gibFigur().gibAusRucksack(aktuellerGegenstand);
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
        Gegenstand g = gibFigur().gibAusRucksack(aktuellerGegenstand);
        if (g==null) {
            view.zeigeAusruestungGegenstandBild("nichts.png");        
            return;
        }
        view.zeigeAusruestungGegenstandBild(g.gibBildname());        
        view.zeigeAusruestungGegenstandName(g.gibName());        
    }

    private void empfangeFigurKoerperteil(int i) {
        if (i==3) {
            if (gibFigur().gibWaffe()!=null){
                Waffe w = gibFigur().gibWaffe();
                gibFigur().entferneWaffe();
                view.zeigeAusruestungGegenstandBild(w.gibBildname());        
                int pos = gibFigur().nimmGegenstandAuf(w);
                aktuellerGegenstand = pos;
            } else {
                
            }
        }
    }
    }
