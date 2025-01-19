package crawlergame;

public abstract class Item
{
    public int posX, posY;
    public char facing = 'N';
    char comesFrom;

    public abstract char gibKuerzel();

    public abstract String gibBildname();

    java.net.URL getImageURL() {
        return Setup.getResource(gibBildname());
    }    

    public boolean isBig() {
        return false;
    }

    public void registerAsMoveable() {
        getModel().registerAsMoveable(this);
    }

    public DungeonModel getModel() {
        return Setup.model;
    }

    public void makeMove() { }

    public boolean canGoForward() {
        return getModel().canGoForward(posX,posY,facing);
    }

    final public void goForward() {
        //if (true) return;
        
        //does not check if possible in itself
        //can go forward does that
        //facing checked doubly, in canGoForward and here - not elegant, but allows for controller
        //System.out.print("Going from "+posX+","+posY+" to ");

        int xalt = posX;
        int yalt = posY;
        
        if (facing == 'N') {
            posY = posY-1;  
            comesFrom = 'S';
        }
        else if (facing == 'E') {
            posX = posX+1;
            comesFrom = 'W';
        }
        else if (facing == 'S') {
            posY = posY+1;   
            comesFrom = 'N';
        }
        else if (facing == 'W') {
            posX = posX-1;   
            comesFrom = 'E';
        }
        
        getModel().bewegeGegenstandVonNach(xalt, yalt, posX, posY);


    }

    final public void turnLeft() {
        System.out.println(this+ " turnsLeft");
        if (facing == 'N') facing = 'W';
        else if (facing == 'E') facing = 'N';
        else if (facing == 'S') facing = 'E';
        else if (facing == 'W') facing = 'S';
        comesFrom = 'X';
    }

    final public void turnRight() {
        System.out.println(this+ " turnsRight");
        if (facing == 'N') facing = 'E';
        else if (facing == 'E') facing = 'S';
        else if (facing == 'S') facing = 'W';
        else if (facing == 'W') facing = 'N';
        comesFrom = 'X';
    }

}
