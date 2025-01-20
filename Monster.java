
public class Monster extends Gegenstand implements Kaempfend
{
    public Monster()
    {
        registerAsMoveable();
        setzeBildname("figur.png");
    }

    public char gibKuerzel() {
        return 'm';
    }

    public boolean isBig() {
        return true;
    }

    @Override
    public void makeMove() {
        System.out.println("Monster: "+posX+", "+posY);
        if (getModel().canGoForward(posX, posY, facing)) {
            goForward();            
        }
        else {
            turnLeft();
        }
    }

    public int berechneAngriff() {
        return 10;
    }

    public int berechneVerteidigung() {
        return 10;
    }
    
    public String gibName() {
        return "Monster";
    }
    
    public void nimmSchaden(int i) {
        
    }

    public int berechneSchaden() {
        return 5;        
    }
}
