package crawlergame;

public abstract class DungeonModelAbstract implements DungeonModel
{
    char[][] dungeon;
    GEGENSTAND[][] gegenstaende;
    char facing;
    int xpos;
    int ypos;

    private DungeonView view;

    AusschnittErzeuger erzeugerAusschnitt;
    ExampleErzeuger erzeugerExample;

    public DungeonModelAbstract(char[][] dung, int startX, int startY, char facing)
    { 
        erzeugerAusschnitt = new AusschnittErzeuger(this);
        erzeugerExample = new ExampleErzeuger(this);
        setzeLevel(dung, startX, startY, facing);
    }

    public DungeonModelAbstract()
    {
        erzeugerAusschnitt = new AusschnittErzeuger(this);
        erzeugerExample = new ExampleErzeuger(this);
        setzeLevel(erzeugerExample.erzeugeDungeonLeer(10), 1, 1, 'N');
        erzeugerExample.fillExampleSimple();
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
        }
        else if (facing == 'E') {
            xpos = xpos+1;
        }
        else if (facing == 'S') {
            ypos = ypos+1;   
        }
        else if (facing == 'W') {
            xpos = xpos-1;   
        }
        //System.out.println(xpos+","+ypos+"\n");
        updateViewBewegung();
    }

    final public void goBack() {
        System.out.print("Going from "+xpos+","+ypos+" to ");

        if (facing == 'N') {
            if (isReachable(xpos, ypos+1)) ypos = ypos+1;  
        }
        else if (facing == 'E') {
            if (isReachable( xpos-1, ypos)) xpos = xpos-1;
        }
        else if (facing == 'S') {
            if (isReachable(xpos, ypos-1)) ypos = ypos-1;   
        }
        else if (facing == 'W') {
            if (isReachable(xpos+1,ypos)) xpos = xpos+1;   
        }

        //System.out.println(xpos+","+ypos+", facing "+facing+"\n");
        updateViewBewegung();
    }

    final public void turnLeft() {
        if (facing == 'N') facing = 'W';
        else if (facing == 'E') facing = 'N';
        else if (facing == 'S') facing = 'E';
        else if (facing == 'W') facing = 'S';
        updateViewBewegung();
    }

    final public void turnRight() {
        if (facing == 'N') facing = 'E';
        else if (facing == 'E') facing = 'S';
        else if (facing == 'S') facing = 'W';
        else if (facing == 'W') facing = 'N';
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

    protected boolean isReachable(int x, int y) {
        return get(x,y)!=Setup.BLOCK;
    }

    //################# Level-Sachen

    private GEGENSTAND [][] erzeugeGegenstaende(char[][] dung) {
        GEGENSTAND [][] temp = new GEGENSTAND[dung.length][];
        for (int i=0; i< dung.length; i++)  {
            temp[i] = new GEGENSTAND[dungeon[i].length];
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
                    GEGENSTAND g = gibStandardgegenstand(level[y][x]);
                    gegenstaende[y][x] = g;                    
                }
            }
        }
    }

    public abstract GEGENSTAND gibStandardgegenstand(char type);

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

    private void set(int x, int y, char c) {
        dungeon[y][x] = c;
    }    

    public char get(int x, int y) {
        if (x<0 || x> dungeon.length-1) return Setup.BLOCK; 
        if (y<0 || y> dungeon.length-1) return Setup.BLOCK;         
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


    // SuS    
    final public void setzeGegenstand(int x, int y, GEGENSTAND g) {
        gegenstaende[y][x] = g; // not yet implemented
        set(x,y, g.gibKuerzel());
    }

    public GEGENSTAND gibGegenstandAnAktuellerPosition() {
        GEGENSTAND g = gegenstaende[ypos][xpos]; 
        //System.out.println("DMA "+g+": "+xpos+","+ypos);
        return g;
        // char c = get(xpos, ypos);
        // if (c==Setup.EMPTY || c==Setup.BLOCK) return null;        
        //return Setup.gibGegenstand(c); // heisst: alle sind generisch
    }

    public void entferneGegenstandAnAktuellerPosition() {
        set(xpos, ypos, Setup.EMPTY);
        gegenstaende[ypos][xpos] = null;
        updateViewBewegung();
    }

    public void setzeGegenstandAnAktuellerPosition(GEGENSTAND g) {
        char c = g.gibKuerzel();
        set(xpos, ypos, c);
        gegenstaende[ypos][xpos] = g;
        updateViewBewegung();
    }

    public void sendeNachricht(String s) {
        view.zeigeBewegungNachricht(s);
    }

    // public Gegenstand gibAusRucksack(int i) {
    // return figur.gibAusRucksack(i);
    // }

    // public void entferneAusRucksack(int i) {
    // figur.entferneAusRucksack(i);
    // updateViewRucksack();
    // }

    // public boolean nimmGegenstand(Gegenstand g) {
    // boolean b = figur.nimmGegenstandAuf(g);
    // if (b) {
    // updateViewBewegung();            
    // }
    // return b;
    // }


}
