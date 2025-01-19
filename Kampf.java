import crawlergame.*;

public class Kampf
{
    DungeonView view;

    public Kampf(Kaempfend k1, Kaempfend k2, DungeonView view)
    {
        this.view = view;
        view.zeigeBewegungNachricht( fuehreDurch(k1,k2) );
    }

    private String greifeAn(Kaempfend k1, Kaempfend k2) {
        int bonusAngriff = 3 * zufallszahl(1,6);
        int bonusVerteidigung = 3 * zufallszahl(1,6);
        if (k1.gibAngriff() + bonusAngriff > k2.gibVerteidigung() + bonusVerteidigung) {
            int schaden = k1.gibSchaden();
            k2.nimmSchaden(schaden);
            return k1.gibName() + " greift "+k2.gibName()+" erfolgreich an und verursacht "+schaden+" Schaden.";
        } else {
            return k2.gibName() + " verteidigt sich erfolgreich gegen "+k1.gibName()+".";
        }
    }
    
    static int zufallszahl(int von, int bis) {
        return (int) (Math.random()*(bis-von+1)) + von;
    }

    public String fuehreDurch(Kaempfend k1, Kaempfend k2)
    {
        //initiaitve?
        String s1 = greifeAn(k1, k2);
        String s2 = greifeAn(k2, k1);
        return s1+"/n"+s2;
    }
}
