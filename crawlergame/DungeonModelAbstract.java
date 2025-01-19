package crawlergame;

public abstract class DungeonModelAbstract implements DungeonModel
{
    char[][] dungeon;
    Item[][] gegenstaende;
    char facing;
    int xpos;
    int ypos;
    char comesFrom;

    protected DungeonView view;
    private java.util.ArrayList<Item> moveables = new java.util.ArrayList();

    AusschnittErzeuger erzeugerAusschnitt;
    ExampleErzeuger erzeugerExample;

    public DungeonModelAbstract(char[][] dung, int startX, int startY, char facing)
    { 
        Setup.model = this;
        erzeugerAusschnitt = new AusschnittErzeuger(this);
        erzeugerExample = new ExampleErzeuger(this);
        setzeLevel(dung, startX, startY, facing);
    }

    public DungeonModelAbstract()
    {
        Setup.model = this;
        erzeugerAusschnitt = new AusschnittErzeuger(this);
        erzeugerExample = new ExampleErzeuger(this);
        setzeLevel(erzeugerExample.erzeugeDungeonLeer(3,4), 0, 0, 'S');
        setItem(1,1,'X');
        //erzeugerExample.fillExampleSimple();
        // erzeugerExample.fillExample();
    }

    //################# View

    @Override public void setView(DungeonView d) {
        if (Setup.useTestModeFigur) return;
        view = d;
        // if (figur!=null)figur.setzeView(d);
    }

    final protected void updateViewBewegung() {
        if (view==null) // fuer testUse
        {
            ViewPrinter p = new ViewPrinter();
            p.zeigeBewegungDungeon(dungeon, xpos, ypos, facing);
            return;
        }

        char [][] mini = erzeugerAusschnitt.createMiniDungeon(xpos,ypos,facing);
        view.zeigeBewegungAusschnitt(mini, xpos, ypos );
        view.zeigeBewegungDungeon(dungeon, xpos, ypos, facing);
    }

    //################# Bewegung
    final public void goForward() {
        //does not check if possible in itself
        //can go forward does that
        //facing checked doubly, in canGoForward and here - not elegant, but allows for controller
        //System.out.print("Going from "+xpos+","+ypos+" to ");

        if (facing == 'N') {
            ypos = ypos-1;  
            comesFrom = 'S';
        }
        else if (facing == 'E') {
            xpos = xpos+1;
            comesFrom = 'W';
        }
        else if (facing == 'S') {
            ypos = ypos+1;   
            comesFrom = 'N';
        }
        else if (facing == 'W') {
            xpos = xpos-1;   
            comesFrom = 'E';
        }
        //System.out.println(xpos+","+ypos+"\n");
        updateViewBewegung();
    }

    final public void turnLeft() {
        if (facing == 'N') facing = 'W';
        else if (facing == 'E') facing = 'N';
        else if (facing == 'S') facing = 'E';
        else if (facing == 'W') facing = 'S';
        comesFrom = 'X';
        updateViewBewegung();
    }

    final public void turnRight() {
        if (facing == 'N') facing = 'E';
        else if (facing == 'E') facing = 'S';
        else if (facing == 'S') facing = 'W';
        else if (facing == 'W') facing = 'N';
        comesFrom = 'X';
        updateViewBewegung();
    }

    public boolean canGoForward() {
        if (facing == 'N') {
            if (isReachable(xpos, ypos-1)) return true;  
        }
        else if (facing == 'E') {
            if (isReachable( xpos+1, ypos)) return true;
        }
        else if (facing == 'S') {
            if (isReachable(xpos, ypos+1)) return true;   
        }
        else if (facing == 'W') {
            if (isReachable(xpos-1,ypos)) return true;   
        }
        return false;
    }

    public boolean canGoForward(int xpos, int ypos, char facing) { // fuer monster  
        if (facing == 'N') {
            if (isEmpty(xpos, ypos-1)) return true;  
        }
        else if (facing == 'E') {
            if (isEmpty( xpos+1, ypos)) return true;
        }
        else if (facing == 'S') {
            if (isEmpty(xpos, ypos+1)) return true;   
        }
        else if (facing == 'W') {
            if (isEmpty(xpos-1,ypos)) return true;   
        }
        return false;
    }

    protected boolean isReachable(int x, int y) {
        if (x<0 || y<0 || y>=dungeon.length || x>=dungeon[y].length) return false;  // order of conditions important, e.e. dungeon[y] must come last
        char[] c = new char[1];
        if (get(x,y) == c[0]) return false; // spielfeld darf keinen Standardwerte fuer char verwenden, das waere zu leicht!        
        return get(x,y)!=Setup.BLOCK;
    }

    protected boolean isEmpty(int x, int y) { //##### for monsters
        if (x<0 || y<0 || y>=dungeon.length || x>=dungeon[y].length) return false;  // order of conditions important, e.e. dungeon[y] must come last
        return get(x,y)==Setup.EMPTY;
    }

    public void registerAsMoveable(Item i) {
        // if (true) return;
        if (moveables.contains(i)) return;
        moveables.add(i);    
        //System.out.println("DMA moveables: "+moveables.size()); //##########################################
    }

    public void moveMoveables() {
        //System.out.println("DMA moveable "+moveables.size());

        for (Item i : moveables) {
            i.makeMove();
        }
    }

    public void bewegeGegenstandVonNach(int xalt, int yalt, int xneu, int yneu) {
        System.out.println("bewege von "+xalt+","+yalt+" nach "+xneu+", "+yneu);
        char c = dungeon[yalt][xalt];
        dungeon[yalt][xalt] = Setup.EMPTY;
        dungeon[yneu][xneu] = c;

        Item i = gegenstaende[yalt][xalt];
        gegenstaende[yalt][xalt] = null;
        gegenstaende[yneu][xneu] = i;
        
    }

    //################# Level-Sachen

    private Item [][] erzeugeGegenstaende(char[][] dung) {
        Item [][] temp = new Item[dung.length][];
        for (int i=0; i< dung.length; i++)  {
            temp[i] = new Item[dungeon[i].length];
        }
        return temp;
    }

    public void setzeLevel(char[][] level, int posx, int posy, char facing) {
        dungeon = level;
        setStartPos(posx, posy, facing);        
        gegenstaende = erzeugeGegenstaende(level);

        //wenn im level ein Kuerzel steht, ein Objekt erzeugen
        for (int y=0; y<level.length; y++) {
            for (int x=0; x<level[y].length; x++) {
                if (level[y][x] != Setup.BLOCK && level[y][x]!=Setup.EMPTY) {
                    Item g = gibStandardgegenstand(level[y][x]);
                    gegenstaende[y][x] = g;
                    g.posX = x;
                    g.posY = y;
                }
            }
        }
    }

    //##################################
    
    public Item gibStandardgegenstand(char type) {
        return null;
    }

    //################# Setter

    final public void setStartPos(int startX, int startY) {
        setStartPos(startX, startY, 'N');
    }

    final public void setStartPos(int startX, int startY, char facing) {
        xpos = startX;
        ypos = startY;
        this.facing = facing;
    }

    //################# Setter 

    public char get(int x, int y) {
        if (y<0 || y> dungeon.length-1) return Setup.BLOCK_BORDER;         // order important
        if (x<0 || x> dungeon[y].length-1) return Setup.BLOCK_BORDER;      // order important
        return dungeon[y][x];
    }

    protected void setBlock(int x, int y) {
        dungeon[y][x] = Setup.BLOCK;        
    }

    void setEmpty(int x, int y) {
        dungeon[y][x] = Setup.EMPTY;        
    }

    //
    //
    //

    final public void begin() {
        updateViewBewegung();
    }

    // protected void updateViewRucksack() {
    // // char c = Setup.gibKuerzel(figur.gibAusRucksack(0));
    // // view.zeigeAusruestungGegenstandBild(Setup.gibBildname(c));
    // Gegenstand g = figur.gibAusRucksack(0);
    // String s =  "images/nichts.png";
    // if (g!=null) s = Setup.gibBildname(g);
    // view.zeigeAusruestungGegenstandBild(s);
    // }

    private void setItem(int x, int y, char c) {
        dungeon[y][x] = c;
    }    

    // SuS    
    final public void setzeGegenstand(int x, int y, Item g) {
        gegenstaende[y][x] = g;
        setItem(x,y, g.gibKuerzel());
        g.posX = x;
        g.posY = x;
    }

    public Item gibGegenstandAnAktuellerPosition() {
        Item g = gegenstaende[ypos][xpos]; 
        return g;
    }

    public void entferneGegenstandAnAktuellerPosition() {
        entferneGegenstandAn(xpos, ypos);
    }

    public void entferneGegenstandAn(int xpos, int ypos) {
        setItem(xpos, ypos, Setup.EMPTY);
        Item i = gegenstaende[ypos][xpos];
        if (moveables.contains(i)) moveables.remove(i);
        gegenstaende[ypos][xpos] = null;
        updateViewBewegung();
    }

    public void setzeGegenstandAnAktuellerPosition(Item g) {
        char c = g.gibKuerzel();
        setItem(xpos, ypos, c);
        gegenstaende[ypos][xpos] = g;
        updateViewBewegung();
    }

    public void sendeNachricht(String s) {
        view.zeigeBewegungNachricht(s);
    }

}
