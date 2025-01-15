public class Gegenstand
{
    String name;
    String beschreibung;
    String bildname;

    public Gegenstand(String name, String beschreibung)  {
        this.name = name;
        this.beschreibung = beschreibung;
    }
    
    String gibBildname() {
        return bildname;
    }
    
    // muss verwendet werden
    void setzeBildname(String s) {
        bildname = s;
    }
    
    //muss ueberschrieben werden
    char gibKuerzel() {
        return '?';
    }

    
    
}
