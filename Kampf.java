import crawlergame.*;

public class Kampf
{
    Kaempfend k1;
    Kaempfend k2;

    public Kampf(Kaempfend k1, Kaempfend k2)
    {
        this.k1 = k1;
        this.k2 = k2;
    }

    private String greifeAn(Kaempfend k1, Kaempfend k2) {
        int bonusAngriff = 3 * zufallszahl(1,6);
        int bonusVerteidigung = 3 * zufallszahl(1,6);
        if (k1.berechneAngriff() + bonusAngriff > k2.berechneVerteidigung() + bonusVerteidigung) {
            int schaden = k1.berechneSchaden();
            k2.nimmSchaden(schaden);
            return k1.gibName() + " greift "+k2.gibName()+" erfolgreich an und verursacht "+schaden+" Schaden.";
        } else {
            return "Der Angriff von "+k1.gibName() + " scheitert an der Verteidigung von "+k2.gibName()+".";
        }
    }

    private int zufallszahl(int von, int bis) {
        return (int) (Math.random()*(bis-von+1)) + von;
    }

    public String fuehreDurch()
    {
        if (Math.random()<0.5) {
            String s1 = greifeAn(k1, k2);
            String s2 = greifeAn(k2, k1);
            return s1+"/n"+s2;
        } else {
            String s2 = greifeAn(k2, k1);
            String s1 = greifeAn(k1, k2);
            return s2+"/n"+s1;
        }
    }
}
