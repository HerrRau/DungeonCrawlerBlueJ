
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
    }

    Gegenstand gibAusRucksack(int i) {
        return rucksack[i];
    }

    void entferneAusRucksack(int i) {
        rucksack[i] = null;
    }

    boolean nimmGegenstandAuf(Gegenstand g) {
        for (int i=0; i< rucksack.length; i++) {
            if (rucksack[i]==null) {
                rucksack[i] = g;                
                return true;
            }
        }
        return false;
    }
    
    void setzeWaffe(Waffe w) {
        waffe = w;
        gibAnsicht().zeigeFigurWaffe("sword.png");
    }
    
    Waffe gibWaffe() {
        return waffe;
    }
    
    int angriffGeben() {
        return staerke;
    }
    int verteidigungGeben() {
        return geschicklichkeit;
    }

    void interagiereMitGegner(Figur gegner) {

    }

    void interagiereMitFalle(Falle f) {

    }

    void interagiereMitKiste(Kiste k) {

    }

}
