
public class Muenze extends Gegenstand
{

    public Muenze()
    {
        super("Muenze", "Eine Muenze.");        
        setzeBildname("coin.png");
    }
    
    public char gibKuerzel() {
        return 'c';
    }



}
