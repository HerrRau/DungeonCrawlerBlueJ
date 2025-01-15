public class DungeonModelConcrete implements DungeonModel
{
    char[][] dungeon;
    Gegenstand[][] gegenstaende;
    char facing;
    int xpos;
    int ypos;
    final static char FACING_N = 'A';
    final static char FACING_E = '>';
    final static char FACING_S = 'V';
    final static char FACING_W = '<';

    DungeonView view;
    // EingabeKonsole eingabe;

    Figur figur;

    boolean use7533 = false;
    boolean use3333 = false;
    boolean use33333 = true;
    boolean use7555 = false;
    boolean use7777 = false;

    public DungeonModelConcrete(char[][] dung, int startX, int startY, char facing)
    { 
        setzeFigur( new Figur() );
        setzeLevel(dung, startX, startY, facing);
    }

    public DungeonModelConcrete()
    {
        setzeFigur( new Figur() );
        setzeLevel(erzeugeDungeonLeer(10), 1, 1, 'N');
        //fillExampleSimple();
        fillExample();

    }
    
    private Gegenstand [][] erzeugeGegenstaende(char[][] dungeon) {
        Gegenstand [][] temp = new Gegenstand[dungeon.length][];
        for (int i=0; i< dungeon.length; i++)  {
            temp[i] = new Gegenstand[dungeon[i].length];
        }
        return temp;
    }

    public void setzeFigur (Figur f) {
        figur = f;
    }
    
     public Figur gibFigur () {
         return figur;         
     }
     
     public void setzeWaffe(Waffe w) {
         figur.setzeWaffe(w);
     }


    private char[][] erzeugeDungeonLeer(int size) {
        char[][] dung = new char[size][];
        for (int i=0; i<dung.length; i++) {
            dung[i] = new char[size];
            for (int j=0; j<dung[i].length; j++) {
                dung[i][j] = Setup.EMPTY;
            }        
        }       
        return dung;
    }

    public void setzeLevel(char[][] level, int posx, int posy, char facing) {
        dungeon = level;
        setStartPos(posx, posy, facing);        
        gegenstaende = erzeugeGegenstaende(level);
    }

    private void fillBorder() {
        for (int i=0; i<dungeon.length; i++) {
            dungeon[i][0] = Setup.BLOCK;
            dungeon[0][i] = Setup.BLOCK;
            dungeon[i][dungeon.length-1] = Setup.BLOCK;
            dungeon[dungeon.length-1][i] = Setup.BLOCK;
        }
    }

    private void fillExample() {
        fillBorder();
        setBlock(1,1);
        setBlock(1,3);
        setBlock(1,5);
        setBlock(2,5);
        setBlock(2,7);
        setBlock(3,1);
        setBlock(3,3);
        setBlock(4,1);
        setBlock(4,3);
        setBlock(4,5);
        setBlock(4,7);
        setBlock(6,1);
        setBlock(6,3);
        setBlock(6,5);
        setBlock(6,8);
        setBlock(7,1);
        setBlock(7,3);
        setBlock(7,5);
        setBlock(7,6);
        setBlock(7,8);
        setBlock(8,1);
        setCoin(5,4);
        // setWeapon(2,2);
    }

    private void fillExampleSimple() {
        fillBorder();
        setBlock(4,4);
        setBlock(6,4);
        setBlock(4,6);
        setBlock(6,6);
        setBlock(5,5);
        setBlock(5,4);
        setCoin(3,4);
        setCoin(7,7);
    }

    private void fillRandom() {
        for (int y=0; y<dungeon.length; y++) {
            for (int x=0; x<dungeon[y].length; x++) {
                if (Math.random()>0.7) {
                    setBlock(x,y);
                } else {
                    setEmpty(x,y);
                }
            }
        }

    }

    private void printPosition() {
        System.out.println(xpos+","+ypos+", facing "+facing+"\n");        
    }

    private char getFacingChar(char dir) {
        if (dir=='N') return FACING_N;
        else if (dir=='E') return FACING_E;
        else if (dir=='S') return FACING_S;
        else return FACING_W;

    }

    private void printDungeon() {
        char[][] dungeonCopy = copy(dungeon);
        dungeonCopy[ypos][xpos] = getFacingChar(facing); //Player
        print(dungeonCopy);
    }

    private void print(char [][] dungeonTemp) {
        for (int y=0; y<dungeonTemp.length; y++) {
            for (int i=0; i<10-dungeonTemp[y].length/2; i++) {
                System.out.print(" ");
            }

            for (int x=0; x<dungeonTemp[y].length; x++) {
                char c = dungeonTemp[y][x];
                System.out.print(c);
            }
            System.out.println();
        }
            System.out.println();
    }

    private  char[][] copy(char[][] org) {
        char[][] temp = new char [org.length][];
        for (int i=0; i< temp.length; i++) {
            temp[i] = new char [org[i].length];
            for (int j=0; j<temp[i].length; j++) {
                temp[i][j] = org[i][j];
            }
        }
        return temp;
    }

    private  char[][] convert(char[][] org) {
        // 5333 to 3333
        char[][] temp = new char [org.length][];
        for (int i=0; i< temp.length; i++) {
            if (i==0) {
                temp[i] = new char [3];
                temp[i][0] = org[i][1];
                temp[i][1] = org[i][2];
                temp[i][2] = org[i][3];
            } else {
                temp[i] = new char [org[i].length];
                for (int j=0; j<temp[i].length; j++) {
                    temp[i][j] = org[i][j];
                }
            }
        }
        return temp;
    }

    private char[][] createMiniDungeon7533(int posx, int posy, char facing) {
        char[][] result = new char[4][];
        result[0] = new char[7];
        result[1] = new char[5];
        result[2] = new char[3];
        result[3] = new char[3];

        int factorNorth = 1;
        int factorEast= 1;
        if (facing=='N') factorNorth = 1;
        if (facing=='S') factorNorth = -1;
        if (facing=='E') factorEast  = +1;
        if (facing=='W') factorEast  = -1;

        if (facing=='N' || facing == 'S') {
            result[0][0] = get(posx-3*factorNorth, posy-3*factorNorth);
            result[0][1] = get(posx-2*factorNorth, posy-3*factorNorth);
            result[0][2] = get(posx-1*factorNorth, posy-3*factorNorth); 
            result[0][3] = get(posx              , posy-3*factorNorth);
            result[0][4] = get(posx+1*factorNorth, posy-3*factorNorth);
            result[0][5] = get(posx+2*factorNorth, posy-3*factorNorth);
            result[0][6] = get(posx+3*factorNorth, posy-3*factorNorth);

            result[1][0] = get(posx-2*factorNorth, posy-2*factorNorth);
            result[1][1] = get(posx-1*factorNorth, posy-2*factorNorth);
            result[1][2] = get(posx,               posy-2*factorNorth);
            result[1][3] = get(posx+1*factorNorth, posy-2*factorNorth);
            result[1][2] = get(posx+2*factorNorth, posy-2*factorNorth);

            result[2][0] = get(posx-1*factorNorth, posy-1*factorNorth);
            result[2][1] = get(posx,               posy-1*factorNorth);
            result[2][2] = get(posx+1*factorNorth, posy-1*factorNorth);

            result[3][0] = get(posx-1*factorNorth, posy);
            result[3][1] = get(posx,               posy);
            result[3][2] = get(posx+1*factorNorth, posy);
        }

        else if (facing=='E' || facing == 'W') {
            result[0][0] = get(posx+3*factorEast, posy-3*factorEast);
            result[0][1] = get(posx+3*factorEast, posy-2*factorEast);
            result[0][2] = get(posx+3*factorEast, posy-1*factorEast);
            result[0][3] = get(posx+3*factorEast, posy);
            result[0][4] = get(posx+3*factorEast, posy+1*factorEast);
            result[0][5] = get(posx+3*factorEast, posy+2*factorEast);
            result[0][6] = get(posx+3*factorEast, posy+3*factorEast);

            result[1][0] = get(posx+2*factorEast, posy-2*factorEast);
            result[1][1] = get(posx+2*factorEast, posy-1*factorEast);
            result[1][2] = get(posx+2*factorEast, posy);
            result[1][3] = get(posx+2*factorEast, posy+1*factorEast);
            result[1][2] = get(posx+2*factorEast, posy+2*factorEast);

            result[2][0] = get(posx+1*factorEast, posy-1*factorEast);
            result[2][1] = get(posx+1*factorEast, posy);
            result[2][2] = get(posx+1*factorEast, posy+1*factorEast);

            result[3][0] = get(posx,              posy-1*factorEast);
            result[3][1] = get(posx,              posy);
            result[3][2] = get(posx,              posy+1*factorEast);
        }

        //result[3][1] = 8; //player
        return result;
    }
    private char[][] createMiniDungeon7555(int posx, int posy, char facing) {
        char[][] result = new char[4][];
        result[0] = new char[7];
        result[1] = new char[5];
        result[2] = new char[5];
        result[3] = new char[5];

        int factorNorth = 1;
        int factorEast= 1;
        if (facing=='N') factorNorth = 1;
        if (facing=='S') factorNorth = -1;
        if (facing=='E') factorEast  = +1;
        if (facing=='W') factorEast  = -1;

        if (facing=='N' || facing == 'S') {
            result[0][0] = get(posx-3*factorNorth, posy-3*factorNorth);
            result[0][1] = get(posx-2*factorNorth, posy-3*factorNorth);
            result[0][2] = get(posx-1*factorNorth, posy-3*factorNorth); 
            result[0][3] = get(posx              , posy-3*factorNorth);
            result[0][4] = get(posx+1*factorNorth, posy-3*factorNorth);
            result[0][5] = get(posx+2*factorNorth, posy-3*factorNorth);
            result[0][6] = get(posx+3*factorNorth, posy-3*factorNorth);

            result[1][0] = get(posx-2*factorNorth, posy-2*factorNorth);
            result[1][1] = get(posx-1*factorNorth, posy-2*factorNorth);
            result[1][2] = get(posx,               posy-2*factorNorth);
            result[1][3] = get(posx+1*factorNorth, posy-2*factorNorth);
            result[1][4] = get(posx+2*factorNorth, posy-2*factorNorth);

            result[2][0] = get(posx-2*factorNorth, posy-1*factorNorth);
            result[2][1] = get(posx-1*factorNorth, posy-1*factorNorth);
            result[2][2] = get(posx,               posy-1*factorNorth);
            result[2][3] = get(posx+1*factorNorth, posy-1*factorNorth);
            result[2][4] = get(posx+2*factorNorth, posy-1*factorNorth);

            result[3][0] = get(posx-2*factorNorth, posy);
            result[3][1] = get(posx-1*factorNorth, posy);
            result[3][2] = get(posx,               posy);
            result[3][3] = get(posx+1*factorNorth, posy);
            result[3][4] = get(posx+2*factorNorth, posy);
        }

        else if (facing=='E' || facing == 'W') {
            result[0][0] = get(posx+3*factorEast, posy-3*factorEast);
            result[0][1] = get(posx+3*factorEast, posy-2*factorEast);
            result[0][2] = get(posx+3*factorEast, posy-1*factorEast);
            result[0][3] = get(posx+3*factorEast, posy);
            result[0][4] = get(posx+3*factorEast, posy+1*factorEast);
            result[0][5] = get(posx+3*factorEast, posy+2*factorEast);
            result[0][6] = get(posx+3*factorEast, posy+3*factorEast);

            result[1][0] = get(posx+2*factorEast, posy-2*factorEast);
            result[1][1] = get(posx+2*factorEast, posy-1*factorEast);
            result[1][2] = get(posx+2*factorEast, posy);
            result[1][3] = get(posx+2*factorEast, posy+1*factorEast);
            result[1][4] = get(posx+2*factorEast, posy+2*factorEast);

            result[2][0] = get(posx+1*factorEast, posy-2*factorEast);
            result[2][1] = get(posx+1*factorEast, posy-1*factorEast);
            result[2][2] = get(posx+1*factorEast, posy);
            result[2][3] = get(posx+1*factorEast, posy+1*factorEast);
            result[2][4] = get(posx+1*factorEast, posy+2*factorEast);

            result[3][0] = get(posx,              posy-2*factorEast);
            result[3][1] = get(posx,              posy-1*factorEast);
            result[3][2] = get(posx,              posy);
            result[3][3] = get(posx,              posy+1*factorEast);
            result[3][4] = get(posx,              posy+2*factorEast);
        }

        //result[3][1] = 8; //player
        return result;
    }

    
    private char[][] createMiniDungeon7777(int posx, int posy, char facing) {
        char[][] result = new char[4][];
        result[0] = new char[7];
        result[1] = new char[7];
        result[2] = new char[7];
        result[3] = new char[7];

        int factorNorth = 1;
        int factorEast= 1;
        if (facing=='N') factorNorth = 1;
        if (facing=='S') factorNorth = -1;
        if (facing=='E') factorEast  = +1;
        if (facing=='W') factorEast  = -1;

        if (facing=='N' || facing == 'S') {
            result[0][0] = get(posx-3*factorNorth, posy-3*factorNorth);
            result[0][1] = get(posx-2*factorNorth, posy-3*factorNorth);
            result[0][2] = get(posx-1*factorNorth, posy-3*factorNorth); 
            result[0][3] = get(posx              , posy-3*factorNorth);
            result[0][4] = get(posx+1*factorNorth, posy-3*factorNorth);
            result[0][5] = get(posx+2*factorNorth, posy-3*factorNorth);
            result[0][6] = get(posx+3*factorNorth, posy-3*factorNorth);

            result[1][0] = get(posx-3*factorNorth, posy-2*factorNorth);
            result[1][1] = get(posx-2*factorNorth, posy-2*factorNorth);
            result[1][2] = get(posx-1*factorNorth, posy-2*factorNorth); 
            result[1][3] = get(posx              , posy-2*factorNorth);
            result[1][4] = get(posx+1*factorNorth, posy-2*factorNorth);
            result[1][5] = get(posx+2*factorNorth, posy-2*factorNorth);
            result[1][6] = get(posx+3*factorNorth, posy-2*factorNorth);

            result[2][0] = get(posx-3*factorNorth, posy-1*factorNorth);
            result[2][1] = get(posx-2*factorNorth, posy-1*factorNorth);
            result[2][2] = get(posx-1*factorNorth, posy-1*factorNorth); 
            result[2][3] = get(posx              , posy-1*factorNorth);
            result[2][4] = get(posx+1*factorNorth, posy-1*factorNorth);
            result[2][5] = get(posx+2*factorNorth, posy-1*factorNorth);
            result[2][6] = get(posx+3*factorNorth, posy-1*factorNorth);

            result[3][0] = get(posx-3*factorNorth, posy-0*factorNorth);
            result[3][1] = get(posx-2*factorNorth, posy-0*factorNorth);
            result[3][2] = get(posx-1*factorNorth, posy-0*factorNorth); 
            result[3][3] = get(posx              , posy-0*factorNorth);
            result[3][4] = get(posx+1*factorNorth, posy-0*factorNorth);
            result[3][5] = get(posx+2*factorNorth, posy-0*factorNorth);
            result[3][6] = get(posx+3*factorNorth, posy-0*factorNorth);

        }

        else if (facing=='E' || facing == 'W') {
            result[0][0] = get(posx+3*factorEast, posy-3*factorEast);
            result[0][1] = get(posx+3*factorEast, posy-2*factorEast);
            result[0][2] = get(posx+3*factorEast, posy-1*factorEast);
            result[0][3] = get(posx+3*factorEast, posy);
            result[0][4] = get(posx+3*factorEast, posy+1*factorEast);
            result[0][5] = get(posx+3*factorEast, posy+2*factorEast);
            result[0][6] = get(posx+3*factorEast, posy+3*factorEast);

            result[1][0] = get(posx+2*factorEast, posy-3*factorEast);
            result[1][1] = get(posx+2*factorEast, posy-2*factorEast);
            result[1][2] = get(posx+2*factorEast, posy-1*factorEast);
            result[1][3] = get(posx+2*factorEast, posy);
            result[1][4] = get(posx+2*factorEast, posy+1*factorEast);
            result[1][5] = get(posx+2*factorEast, posy+2*factorEast);
            result[1][6] = get(posx+2*factorEast, posy+3*factorEast);

            result[2][0] = get(posx+1*factorEast, posy-3*factorEast);
            result[2][1] = get(posx+1*factorEast, posy-2*factorEast);
            result[2][2] = get(posx+1*factorEast, posy-1*factorEast);
            result[2][3] = get(posx+1*factorEast, posy);
            result[2][4] = get(posx+1*factorEast, posy+1*factorEast);
            result[2][5] = get(posx+1*factorEast, posy+2*factorEast);
            result[2][6] = get(posx+1*factorEast, posy+3*factorEast);

            result[3][0] = get(posx+0*factorEast, posy-3*factorEast);
            result[3][1] = get(posx+0*factorEast, posy-2*factorEast);
            result[3][2] = get(posx+0*factorEast, posy-1*factorEast);
            result[3][3] = get(posx+0*factorEast, posy);
            result[3][4] = get(posx+0*factorEast, posy+1*factorEast);
            result[3][5] = get(posx+0*factorEast, posy+2*factorEast);
            result[3][6] = get(posx+0*factorEast, posy+3*factorEast);

        }

        //result[3][1] = 8; //player
        return result;
    }

    private char[][] createMiniDungeon(int posx, int posy, char facing) {
        if (use7533) return createMiniDungeon7533(posx, posy, facing);
        if (use33333) return createMiniDungeon33333(posx, posy, facing);
        if (use7555) return createMiniDungeon7555(posx, posy, facing);
        if (use7777) return createMiniDungeon7777(posx, posy, facing);
        char[][] result = new char[4][];
        result[0] = new char[5];
        result[1] = new char[3];
        result[2] = new char[3];
        result[3] = new char[3];

        int factorNorth = 1;
        int factorEast= 1;
        if (facing=='N') factorNorth = 1;
        if (facing=='S') factorNorth = -1;
        if (facing=='E') factorEast  = +1;
        if (facing=='W') factorEast  = -1;

        if (facing=='N' || facing == 'S') {
            result[0][0] = get(posx-2*factorNorth, posy-3*factorNorth);
            result[0][1] = get(posx-1*factorNorth, posy-3*factorNorth); 
            result[0][2] = get(posx              , posy-3*factorNorth);
            result[0][3] = get(posx+1*factorNorth, posy-3*factorNorth);
            result[0][4] = get(posx+2*factorNorth, posy-3*factorNorth);
            result[1][0] = get(posx-1*factorNorth, posy-2*factorNorth);
            result[1][1] = get(posx,               posy-2*factorNorth);
            result[1][2] = get(posx+1*factorNorth, posy-2*factorNorth);
            result[2][0] = get(posx-1*factorNorth, posy-1*factorNorth);
            result[2][1] = get(posx,               posy-1*factorNorth);
            result[2][2] = get(posx+1*factorNorth, posy-1*factorNorth);
            result[3][0] = get(posx-1*factorNorth, posy);
            result[3][1] = get(posx,               posy);
            result[3][2] = get(posx+1*factorNorth, posy);
        }

        else if (facing=='E' || facing == 'W') {
            result[0][0] = get(posx+3*factorEast, posy-2*factorEast);
            result[0][1] = get(posx+3*factorEast, posy-1*factorEast);
            result[0][2] = get(posx+3*factorEast, posy);
            result[0][3] = get(posx+3*factorEast, posy+1*factorEast);
            result[0][4] = get(posx+3*factorEast, posy+2*factorEast);

            result[1][0] = get(posx+2*factorEast, posy-1*factorEast);
            result[1][1] = get(posx+2*factorEast, posy);
            result[1][2] = get(posx+2*factorEast, posy+1*factorEast);

            result[2][0] = get(posx+1*factorEast, posy-1*factorEast);
            result[2][1] = get(posx+1*factorEast, posy);
            result[2][2] = get(posx+1*factorEast, posy+1*factorEast);

            result[3][0] = get(posx,              posy-1*factorEast);
            result[3][1] = get(posx,              posy);
            result[3][2] = get(posx,              posy+1*factorEast);
        }

        //result[3][1] = 8; //player
        return result;
    }

    private char[][] createMiniDungeon33333(int posx, int posy, char facing) {
        char[][] result = new char[5][];
        result[0] = new char[3];
        result[1] = new char[3];
        result[2] = new char[3];
        result[3] = new char[3];
        result[4] = new char[3];

        int factorNorth = 1;
        int factorEast= 1;
        if (facing=='N') factorNorth = 1;
        if (facing=='S') factorNorth = -1;
        if (facing=='E') factorEast  = +1;
        if (facing=='W') factorEast  = -1;

        if (facing=='N' || facing == 'S') {
            result[0][0] = get(posx-1*factorNorth, posy-4*factorNorth); 
            result[0][1] = get(posx              , posy-4*factorNorth);
            result[0][2] = get(posx+1*factorNorth, posy-4*factorNorth);
            result[1][0] = get(posx-1*factorNorth, posy-3*factorNorth); 
            result[1][1] = get(posx              , posy-3*factorNorth);
            result[1][2] = get(posx+1*factorNorth, posy-3*factorNorth);
            result[2][0] = get(posx-1*factorNorth, posy-2*factorNorth);
            result[2][1] = get(posx,               posy-2*factorNorth);
            result[2][2] = get(posx+1*factorNorth, posy-2*factorNorth);
            result[3][0] = get(posx-1*factorNorth, posy-1*factorNorth);
            result[3][1] = get(posx,               posy-1*factorNorth);
            result[3][2] = get(posx+1*factorNorth, posy-1*factorNorth);
            result[4][0] = get(posx-1*factorNorth, posy);
            result[4][1] = get(posx,               posy);
            result[4][2] = get(posx+1*factorNorth, posy);
        }

        else if (facing=='E' || facing == 'W') {
            result[0][0] = get(posx+4*factorEast, posy-1*factorEast);
            result[0][1] = get(posx+4*factorEast, posy);
            result[0][2] = get(posx+4*factorEast, posy+1*factorEast);

            result[1][0] = get(posx+3*factorEast, posy-1*factorEast);
            result[1][1] = get(posx+3*factorEast, posy);
            result[1][2] = get(posx+3*factorEast, posy+1*factorEast);

            result[2][0] = get(posx+2*factorEast, posy-1*factorEast);
            result[2][1] = get(posx+2*factorEast, posy);
            result[2][2] = get(posx+2*factorEast, posy+1*factorEast);

            result[3][0] = get(posx+1*factorEast, posy-1*factorEast);
            result[3][1] = get(posx+1*factorEast, posy);
            result[3][2] = get(posx+1*factorEast, posy+1*factorEast);

            result[4][0] = get(posx,              posy-1*factorEast);
            result[4][1] = get(posx,              posy);
            result[4][2] = get(posx,              posy+1*factorEast);
        }

        //result[3][1] = 8; //player
        return result;
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

    private void setCoin(int x, int y) {
        setzeGegenstand(x,y, new Muenze());
        //dungeon[y][x] = Setup.COIN;        
    }

    private void setWeapon(int x, int y) {
        setzeGegenstand(x,y, new Waffe());
    }

    private void set(int x, int y, char c) {
        dungeon[y][x] = c;
    }    

    private char get(int x, int y) {
        if (x<0 || x> dungeon.length-1) return Setup.BLOCK; 
        if (y<0 || y> dungeon.length-1) return Setup.BLOCK;         
        return dungeon[y][x];
    }

    protected void setBlock(int x, int y) {
        dungeon[y][x] = Setup.BLOCK;        
    }

    private void setEmpty(int x, int y) {
        dungeon[y][x] = Setup.EMPTY;        
    }

    //
    //
    //

    final public void setStartPos(int startX, int startY) {
        setStartPos(startX, startY, 'N');
    }

    final public void setStartPos(int startX, int startY, char facing) {
        xpos = startX;
        ypos = startY;
        this.facing = facing;
    }

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
        System.out.println(xpos+","+ypos+"\n");
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

    final public void setzeView(DungeonView d) {
        view = d;
        figur.setzeView(d);
    }

    final public void anfang() {
        updateViewBewegung();
    }

    final protected void updateViewRucksack() {
        // char c = Setup.gibKuerzel(figur.gibAusRucksack(0));
        // view.zeigeAusruestungGegenstandBild(Setup.gibBildname(c));
        Gegenstand g = figur.gibAusRucksack(0);
        String s =  "images/nichts.png";
        if (g!=null) s = Setup.gibBildname(g);
        view.zeigeAusruestungGegenstandBild(s);
    }

    final protected void updateViewBewegung() {
        char[][] mini = null;
        if (use3333) {
            mini = convert(createMiniDungeon(xpos, ypos, facing)); 
        } else {
            mini = createMiniDungeon(xpos, ypos, facing); 
        }
        view.zeigeBewegungDungeon(mini, xpos, ypos );
        print (mini);
        printDungeon();
        //printPosition();
    }

    public int gibPosX() {
        return xpos;
    }

    public int gibPosY() {
        return ypos;
    }

    // SuS    
    final protected void setzeGegenstand(int x, int y, Gegenstand g) {
        gegenstaende[y][x] = g; // not yet implemented
        set(x,y, Setup.gibKuerzel(g));
    }

    public Gegenstand gibGegenstandAnPosition() {
        return gegenstaende[ypos][xpos];
        // char c = get(xpos, ypos);
        // if (c==Setup.EMPTY || c==Setup.BLOCK) return null;        
        //return Setup.gibGegenstand(c); // heisst: alle sind generisch
    }

    public Gegenstand gibAusRucksack(int i) {
        return figur.gibAusRucksack(i);
    }

    public void entferneAusRucksack(int i) {
        figur.entferneAusRucksack(i);
        updateViewRucksack();
    }

    public boolean nimmGegenstand(Gegenstand g) {
        boolean b = figur.nimmGegenstandAuf(g);
        if (b) {
            updateViewBewegung();            
        }
        return b;
    }

    public void entferneGegenstandAnPosition() {
        set(xpos, ypos, Setup.EMPTY);
        gegenstaende[ypos][xpos] = null;
        updateViewBewegung();
    }

    public void setzeGegenstandAnPosition(Gegenstand g) {
        char c = Setup.gibKuerzel(g);
        set(xpos, ypos, c);
        gegenstaende[ypos][xpos] = g;
        updateViewBewegung();
        //updateViewRucksack();
    }

    public void sendeNachricht(String s) {
        view.zeigeBewegungNachricht(s);
    }

}
