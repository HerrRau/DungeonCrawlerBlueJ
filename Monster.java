
public class Monster extends Gegenstand
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
}
