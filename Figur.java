import crawlergame.*;

public class Figur extends ModelSender
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

    public boolean nimmGegenstandAuf(Gegenstand g) {
        for (int i=0; i< rucksack.length; i++) {
            if (rucksack[i]==null) {
                rucksack[i] = g;                
                return true;
            }
        }
        return false;
    }
    
    public void setzeWaffe(Waffe w) {
        waffe = w;
        gibAnsicht().zeigeFigur(3, "sword.png");
        //gibAnsicht().zeigeFigur(3, w.gibBildname());
    }
    
    public Waffe gibWaffe() {
        return waffe;
    }
    
    public int angriffGeben() {
        return staerke;
    }
    public int verteidigungGeben() {
        return geschicklichkeit;
    }

    public void interagiereMitGegner(Figur gegner) {

    }

    public void interagiereMitFalle(Falle f) {

    }

    public void interagiereMitKiste(Kiste k) {

    }

}
