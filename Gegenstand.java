import crawlergame.*;

public class Gegenstand extends Item
{
    private String name;
    private String beschreibung;
    private String bildname;
    private char kuerzel;

    public Gegenstand()  {
        this.name = "Ein namenloses Ding.";
        this.beschreibung = "Unbeschreiblich";
        this.kuerzel = '?';
        // this.bildname = "nichts";
    }

    public Gegenstand(String name, String beschreibung, String bildname, char kuerzel)  {
        this.name = name;
        this.beschreibung = beschreibung;
        this.bildname = bildname;
        this.kuerzel = kuerzel;
    }

    public String gibBildname() {
        return bildname;
    }
    
    // muss verwendet werden
    public void setzeBildname(String s) {
        bildname = s;
    }

    public String gibBeschreibung() {
        return beschreibung;
    }
    
    // muss verwendet werden
    public void setzeBeschreibung(String s) {
        beschreibung = s;
    }

    public String gibName() {
        return name;
    }
    
    // muss verwendet werden
    public void setzeName(String s) {
        name = s;
    }
    
    public int gibBonus() {
        return 0;
    }
    
    public boolean kannBenutzern(Figur f) {
        return true;
    }

    //muss ueberschrieben werden
    @Override public char gibKuerzel() {
        return kuerzel;
    }

    public void setzeKuerzel(char c) {
        kuerzel = c;
    }


}
