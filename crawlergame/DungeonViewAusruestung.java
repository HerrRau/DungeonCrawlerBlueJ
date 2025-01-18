package crawlergame;

public interface DungeonViewAusruestung
{
    void setController(DungeonController c);

    void zeigeAusruestungGegenstandBild(String bildname);

    void zeigeAusruestungGegenstandName(String name);

    void zeigeAusruestungGegenstandBeschreibung(String text);

    void zeigeAusruestungNachricht(String name);


}
