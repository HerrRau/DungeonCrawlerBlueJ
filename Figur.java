import crawlergame.*;

public class Figur extends ModelSender implements Kaempfend
{
    Gegenstand  [] rucksack;

    Waffe waffe;
    Schild schild;
    Ring ring1;
    Ring ring2;
    Kopfbedeckung kopf;
    Schuhe schuhe;
    Kleidung koerper;

    int staerke;
    int geschicklichkeit;

    public Figur() {
        rucksack = new Gegenstand[10];
        //hier kein setzeWaffe ( new Waffe() ); - weil View noch nicht aktiv
    }

    public Gegenstand gibAusRucksack(int i) {
        return rucksack[i];
    }

    public void entferneAusRucksack(int i) {
        rucksack[i] = null;
    }

    public int gibRucksackLaenge() {
        return rucksack.length;
    }

    public int nimmGegenstandAuf(Gegenstand g) {
        for (int i=0; i< rucksack.length; i++) {
            if (rucksack[i]==null) {
                rucksack[i] = g;                
                return i;
            }
        }
        return -1;
    }

    public void setzeWaffe(Waffe w) {
        waffe = w;
        gibAnsicht().zeigeFigur(3, "sword.png");
        //gibAnsicht().zeigeFigur(3, w.gibBildname());
    }

    public Waffe gibWaffe() {
        return waffe;
    }

    public void entferneWaffe() {
        waffe = null;
        gibAnsicht().zeigeFigur(3, "nichts.png");
    }

    public int berechneAngriff() {
        return staerke;
    }

    public int berechneVerteidigung() {
        return geschicklichkeit;
    }
    
    public String gibName() {
        return "Langweilige Figur";
    }
    
    public void nimmSchaden(int i) {
        
    }

    public int berechneSchaden() {
        return 5;        
    }


}
