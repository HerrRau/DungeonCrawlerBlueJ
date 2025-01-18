import crawlergame.*;
public class Gegenstand extends GEGENSTAND
{
    String name;
    String beschreibung;
    private String bildname;

    public Gegenstand(String name, String beschreibung)  {
        this.name = name;
        this.beschreibung = beschreibung;
    }

    public String gibBildname() {
        return bildname; //evtl auf null ueberpruefen
    }

    // muss verwendet werden
    public void setzeBildname(String s) {
        bildname = s;
    }

    //muss ueberschrieben werden
    @Override public char gibKuerzel() {
        return '?';
    }


}
