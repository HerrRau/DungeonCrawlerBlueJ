package crawlergame;

public class AusschnittErzeuger
{
    DungeonModelAbstract model;
    boolean use7533 = false;
    boolean use33333 = false;
    boolean use7555 = false;
    boolean use7777 = false;
    boolean use9999999 = true;

    public AusschnittErzeuger(DungeonModelAbstract m)
    {
        model = m;
    }

    public  char[][] createMiniDungeon(int posx, int posy, char facing) {
        if (use7533) return createMiniDungeon7533(posx, posy, facing);
        if (use33333) return createMiniDungeon(5, 3, posx, posy, facing);
        if (use7555) return createMiniDungeon7555(posx, posy, facing);
        if (use7777) return createMiniDungeon7777(posx, posy, facing);
        if (use9999999) return createMiniDungeon9999999(posx, posy, facing);
        return createMiniDungeon5333(posx, posy, facing);
    }

    public  char[][] createMiniDungeon5333(int posx, int posy, char facing) {
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
            result[0][0] = model.get(posx-2*factorNorth, posy-3*factorNorth);
            result[0][1] = model.get(posx-1*factorNorth, posy-3*factorNorth); 
            result[0][2] = model.get(posx              , posy-3*factorNorth);
            result[0][3] = model.get(posx+1*factorNorth, posy-3*factorNorth);
            result[0][4] = model.get(posx+2*factorNorth, posy-3*factorNorth);
            result[1][0] = model.get(posx-1*factorNorth, posy-2*factorNorth);
            result[1][1] = model.get(posx,               posy-2*factorNorth);
            result[1][2] = model.get(posx+1*factorNorth, posy-2*factorNorth);
            result[2][0] = model.get(posx-1*factorNorth, posy-1*factorNorth);
            result[2][1] = model.get(posx,               posy-1*factorNorth);
            result[2][2] = model.get(posx+1*factorNorth, posy-1*factorNorth);
            result[3][0] = model.get(posx-1*factorNorth, posy);
            result[3][1] = model.get(posx,               posy);
            result[3][2] = model.get(posx+1*factorNorth, posy);
        }

        else if (facing=='E' || facing == 'W') {
            result[0][0] = model.get(posx+3*factorEast, posy-2*factorEast);
            result[0][1] = model.get(posx+3*factorEast, posy-1*factorEast);
            result[0][2] = model.get(posx+3*factorEast, posy);
            result[0][3] = model.get(posx+3*factorEast, posy+1*factorEast);
            result[0][4] = model.get(posx+3*factorEast, posy+2*factorEast);

            result[1][0] = model.get(posx+2*factorEast, posy-1*factorEast);
            result[1][1] = model.get(posx+2*factorEast, posy);
            result[1][2] = model.get(posx+2*factorEast, posy+1*factorEast);

            result[2][0] = model.get(posx+1*factorEast, posy-1*factorEast);
            result[2][1] = model.get(posx+1*factorEast, posy);
            result[2][2] = model.get(posx+1*factorEast, posy+1*factorEast);

            result[3][0] = model.get(posx,              posy-1*factorEast);
            result[3][1] = model.get(posx,              posy);
            result[3][2] = model.get(posx,              posy+1*factorEast);
        }

        //result[3][1] = 8; //player
        return result;
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
            result[0][0] = model.get(posx-3*factorNorth, posy-3*factorNorth);
            result[0][1] = model.get(posx-2*factorNorth, posy-3*factorNorth);
            result[0][2] = model.get(posx-1*factorNorth, posy-3*factorNorth); 
            result[0][3] = model.get(posx              , posy-3*factorNorth);
            result[0][4] = model.get(posx+1*factorNorth, posy-3*factorNorth);
            result[0][5] = model.get(posx+2*factorNorth, posy-3*factorNorth);
            result[0][6] = model.get(posx+3*factorNorth, posy-3*factorNorth);

            result[1][0] = model.get(posx-2*factorNorth, posy-2*factorNorth);
            result[1][1] = model.get(posx-1*factorNorth, posy-2*factorNorth);
            result[1][2] = model.get(posx,               posy-2*factorNorth);
            result[1][3] = model.get(posx+1*factorNorth, posy-2*factorNorth);
            result[1][2] = model.get(posx+2*factorNorth, posy-2*factorNorth);

            result[2][0] = model.get(posx-1*factorNorth, posy-1*factorNorth);
            result[2][1] = model.get(posx,               posy-1*factorNorth);
            result[2][2] = model.get(posx+1*factorNorth, posy-1*factorNorth);

            result[3][0] = model.get(posx-1*factorNorth, posy);
            result[3][1] = model.get(posx,               posy);
            result[3][2] = model.get(posx+1*factorNorth, posy);
        }

        else if (facing=='E' || facing == 'W') {
            result[0][0] = model.get(posx+3*factorEast, posy-3*factorEast);
            result[0][1] = model.get(posx+3*factorEast, posy-2*factorEast);
            result[0][2] = model.get(posx+3*factorEast, posy-1*factorEast);
            result[0][3] = model.get(posx+3*factorEast, posy);
            result[0][4] = model.get(posx+3*factorEast, posy+1*factorEast);
            result[0][5] = model.get(posx+3*factorEast, posy+2*factorEast);
            result[0][6] = model.get(posx+3*factorEast, posy+3*factorEast);

            result[1][0] = model.get(posx+2*factorEast, posy-2*factorEast);
            result[1][1] = model.get(posx+2*factorEast, posy-1*factorEast);
            result[1][2] = model.get(posx+2*factorEast, posy);
            result[1][3] = model.get(posx+2*factorEast, posy+1*factorEast);
            result[1][2] = model.get(posx+2*factorEast, posy+2*factorEast);

            result[2][0] = model.get(posx+1*factorEast, posy-1*factorEast);
            result[2][1] = model.get(posx+1*factorEast, posy);
            result[2][2] = model.get(posx+1*factorEast, posy+1*factorEast);

            result[3][0] = model.get(posx,              posy-1*factorEast);
            result[3][1] = model.get(posx,              posy);
            result[3][2] = model.get(posx,              posy+1*factorEast);
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
            result[0][0] = model.get(posx-3*factorNorth, posy-3*factorNorth);
            result[0][1] = model.get(posx-2*factorNorth, posy-3*factorNorth);
            result[0][2] = model.get(posx-1*factorNorth, posy-3*factorNorth); 
            result[0][3] = model.get(posx              , posy-3*factorNorth);
            result[0][4] = model.get(posx+1*factorNorth, posy-3*factorNorth);
            result[0][5] = model.get(posx+2*factorNorth, posy-3*factorNorth);
            result[0][6] = model.get(posx+3*factorNorth, posy-3*factorNorth);

            result[1][0] = model.get(posx-2*factorNorth, posy-2*factorNorth);
            result[1][1] = model.get(posx-1*factorNorth, posy-2*factorNorth);
            result[1][2] = model.get(posx,               posy-2*factorNorth);
            result[1][3] = model.get(posx+1*factorNorth, posy-2*factorNorth);
            result[1][4] = model.get(posx+2*factorNorth, posy-2*factorNorth);

            result[2][0] = model.get(posx-2*factorNorth, posy-1*factorNorth);
            result[2][1] = model.get(posx-1*factorNorth, posy-1*factorNorth);
            result[2][2] = model.get(posx,               posy-1*factorNorth);
            result[2][3] = model.get(posx+1*factorNorth, posy-1*factorNorth);
            result[2][4] = model.get(posx+2*factorNorth, posy-1*factorNorth);

            result[3][0] = model.get(posx-2*factorNorth, posy);
            result[3][1] = model.get(posx-1*factorNorth, posy);
            result[3][2] = model.get(posx,               posy);
            result[3][3] = model.get(posx+1*factorNorth, posy);
            result[3][4] = model.get(posx+2*factorNorth, posy);
        }

        else if (facing=='E' || facing == 'W') {
            result[0][0] = model.get(posx+3*factorEast, posy-3*factorEast);
            result[0][1] = model.get(posx+3*factorEast, posy-2*factorEast);
            result[0][2] = model.get(posx+3*factorEast, posy-1*factorEast);
            result[0][3] = model.get(posx+3*factorEast, posy);
            result[0][4] = model.get(posx+3*factorEast, posy+1*factorEast);
            result[0][5] = model.get(posx+3*factorEast, posy+2*factorEast);
            result[0][6] = model.get(posx+3*factorEast, posy+3*factorEast);

            result[1][0] = model.get(posx+2*factorEast, posy-2*factorEast);
            result[1][1] = model.get(posx+2*factorEast, posy-1*factorEast);
            result[1][2] = model.get(posx+2*factorEast, posy);
            result[1][3] = model.get(posx+2*factorEast, posy+1*factorEast);
            result[1][4] = model.get(posx+2*factorEast, posy+2*factorEast);

            result[2][0] = model.get(posx+1*factorEast, posy-2*factorEast);
            result[2][1] = model.get(posx+1*factorEast, posy-1*factorEast);
            result[2][2] = model.get(posx+1*factorEast, posy);
            result[2][3] = model.get(posx+1*factorEast, posy+1*factorEast);
            result[2][4] = model.get(posx+1*factorEast, posy+2*factorEast);

            result[3][0] = model.get(posx,              posy-2*factorEast);
            result[3][1] = model.get(posx,              posy-1*factorEast);
            result[3][2] = model.get(posx,              posy);
            result[3][3] = model.get(posx,              posy+1*factorEast);
            result[3][4] = model.get(posx,              posy+2*factorEast);
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
            result[0][0] = model.get(posx-3*factorNorth, posy-3*factorNorth);
            result[0][1] = model.get(posx-2*factorNorth, posy-3*factorNorth);
            result[0][2] = model.get(posx-1*factorNorth, posy-3*factorNorth); 
            result[0][3] = model.get(posx              , posy-3*factorNorth);
            result[0][4] = model.get(posx+1*factorNorth, posy-3*factorNorth);
            result[0][5] = model.get(posx+2*factorNorth, posy-3*factorNorth);
            result[0][6] = model.get(posx+3*factorNorth, posy-3*factorNorth);

            result[1][0] = model.get(posx-3*factorNorth, posy-2*factorNorth);
            result[1][1] = model.get(posx-2*factorNorth, posy-2*factorNorth);
            result[1][2] = model.get(posx-1*factorNorth, posy-2*factorNorth); 
            result[1][3] = model.get(posx              , posy-2*factorNorth);
            result[1][4] = model.get(posx+1*factorNorth, posy-2*factorNorth);
            result[1][5] = model.get(posx+2*factorNorth, posy-2*factorNorth);
            result[1][6] = model.get(posx+3*factorNorth, posy-2*factorNorth);

            result[2][0] = model.get(posx-3*factorNorth, posy-1*factorNorth);
            result[2][1] = model.get(posx-2*factorNorth, posy-1*factorNorth);
            result[2][2] = model.get(posx-1*factorNorth, posy-1*factorNorth); 
            result[2][3] = model.get(posx              , posy-1*factorNorth);
            result[2][4] = model.get(posx+1*factorNorth, posy-1*factorNorth);
            result[2][5] = model.get(posx+2*factorNorth, posy-1*factorNorth);
            result[2][6] = model.get(posx+3*factorNorth, posy-1*factorNorth);

            result[3][0] = model.get(posx-3*factorNorth, posy-0*factorNorth);
            result[3][1] = model.get(posx-2*factorNorth, posy-0*factorNorth);
            result[3][2] = model.get(posx-1*factorNorth, posy-0*factorNorth); 
            result[3][3] = model.get(posx              , posy-0*factorNorth);
            result[3][4] = model.get(posx+1*factorNorth, posy-0*factorNorth);
            result[3][5] = model.get(posx+2*factorNorth, posy-0*factorNorth);
            result[3][6] = model.get(posx+3*factorNorth, posy-0*factorNorth);

        }

        else if (facing=='E' || facing == 'W') {
            result[0][0] = model.get(posx+3*factorEast, posy-3*factorEast);
            result[0][1] = model.get(posx+3*factorEast, posy-2*factorEast);
            result[0][2] = model.get(posx+3*factorEast, posy-1*factorEast);
            result[0][3] = model.get(posx+3*factorEast, posy);
            result[0][4] = model.get(posx+3*factorEast, posy+1*factorEast);
            result[0][5] = model.get(posx+3*factorEast, posy+2*factorEast);
            result[0][6] = model.get(posx+3*factorEast, posy+3*factorEast);

            result[1][0] = model.get(posx+2*factorEast, posy-3*factorEast);
            result[1][1] = model.get(posx+2*factorEast, posy-2*factorEast);
            result[1][2] = model.get(posx+2*factorEast, posy-1*factorEast);
            result[1][3] = model.get(posx+2*factorEast, posy);
            result[1][4] = model.get(posx+2*factorEast, posy+1*factorEast);
            result[1][5] = model.get(posx+2*factorEast, posy+2*factorEast);
            result[1][6] = model.get(posx+2*factorEast, posy+3*factorEast);

            result[2][0] = model.get(posx+1*factorEast, posy-3*factorEast);
            result[2][1] = model.get(posx+1*factorEast, posy-2*factorEast);
            result[2][2] = model.get(posx+1*factorEast, posy-1*factorEast);
            result[2][3] = model.get(posx+1*factorEast, posy);
            result[2][4] = model.get(posx+1*factorEast, posy+1*factorEast);
            result[2][5] = model.get(posx+1*factorEast, posy+2*factorEast);
            result[2][6] = model.get(posx+1*factorEast, posy+3*factorEast);

            result[3][0] = model.get(posx+0*factorEast, posy-3*factorEast);
            result[3][1] = model.get(posx+0*factorEast, posy-2*factorEast);
            result[3][2] = model.get(posx+0*factorEast, posy-1*factorEast);
            result[3][3] = model.get(posx+0*factorEast, posy);
            result[3][4] = model.get(posx+0*factorEast, posy+1*factorEast);
            result[3][5] = model.get(posx+0*factorEast, posy+2*factorEast);
            result[3][6] = model.get(posx+0*factorEast, posy+3*factorEast);

        }

        //result[3][1] = 8; //player
        return result;
    }

    private char[][] createMiniDungeon9999999(int posx, int posy, char facing) {
        return createMiniDungeon(7, 9, posx, posy, facing);
    }

    private char[][] createMiniDungeon(int depth, int width, int posx, int posy, char facing) {
        char[][] result = new char[depth][];
        for (int i=0; i<depth; i++) {
            result[i] = new char[width];
        }

        int factorNorth = 1;
        int factorEast= 1;
        if (facing=='N') factorNorth = 1;
        if (facing=='S') factorNorth = -1;
        if (facing=='E') factorEast  = +1;
        if (facing=='W') factorEast  = -1;

        if (facing=='N' || facing == 'S') {           
            for (int i=0; i<depth; i++) {
                for (int j=0; j<result[i].length; j++) {
                    int f = width/2 - j;
                    int g = depth-1-i;
                    result[i][j] = model.get(posx - f * factorNorth, posy - g * factorNorth); 
                    // System.out.println("result["+i+"]["+j+"] = model.get(posx-"+f+"*factorNorth, posy-"+g+"*factorNorth);");
                }
            }
        }

        else if (facing=='E' || facing == 'W') {
            for (int i=0; i<result.length; i++) {
                for (int j=0; j<result[i].length; j++) {
                    int g = width/2 - j;
                    int f = depth-1-i;
                    result[i][j] = model.get(posx + f * factorEast, posy - g * factorEast); 
                }
            }
        }
        return result;
    }


}
