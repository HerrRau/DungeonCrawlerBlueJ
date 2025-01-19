package crawlergame;

public class ViewPrinter //implements DungeonViewBewegung
{
    public ViewPrinter()
    {
    }

    public void zeigeBewegungAusschnitt(char[][] dungeon, int xPosPlayer, int yPosPlayer) {
        char old = dungeon[dungeon.length-1][dungeon[0].length/2+1];
        dungeon[dungeon.length-1][dungeon[0].length/2+1] = 'A'; //Player

        for (int y=0; y<dungeon.length; y++) {
            for (int i=0; i<10-dungeon[y].length/2; i++) {
                System.out.print(" ");
            }

            for (int x=0; x<dungeon[y].length; x++) {
                char c = dungeon[y][x];
                System.out.print(c);
            }
            System.out.println();
        }
        System.out.println();

        dungeon[dungeon.length-1][dungeon[0].length/2+1] = old; // before Player
    }

    public void zeigeBewegungDungeon(char[][] dungeon, int xPosPlayer, int yPosPlayer, char facing) {
        char old = dungeon[yPosPlayer][xPosPlayer];
        dungeon[yPosPlayer][xPosPlayer] = getFacingChar(facing); //Player

        for (int y=0; y<dungeon.length; y++) {
            for (int i=0; i<10-dungeon[y].length/2; i++) {
                System.out.print(" ");
            }

            for (int x=0; x<dungeon[y].length; x++) {
                char c = dungeon[y][x];
                System.out.print(c);
            }
            System.out.println();
        }
        System.out.println();

        dungeon[yPosPlayer][xPosPlayer] = old; // before Player
    }

    public void zeigeBewegungDungeonWORKS(char[][] dungeon, int xPosPlayer, int yPosPlayer, char facing) {
        char old = dungeon[yPosPlayer][xPosPlayer];
        dungeon[yPosPlayer][xPosPlayer] = getFacingChar(facing); //Player

        for (int y=0; y<dungeon.length; y++) {
            for (int i=0; i<10-dungeon[y].length/2; i++) {
                System.out.print(" ");
            }

            for (int x=0; x<dungeon[y].length; x++) {
                char c = dungeon[y][x];
                System.out.print(c);
            }
            System.out.println();
        }
        System.out.println();

        dungeon[yPosPlayer][xPosPlayer] = old; // before Player

    }

    private char getFacingChar(char dir) {
        if (dir=='N') return Setup.FACING_N;
        else if (dir=='E') return Setup.FACING_E;
        else if (dir=='S') return Setup.FACING_S;
        else return Setup.FACING_W;

    }

}
