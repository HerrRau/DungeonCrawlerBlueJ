package crawlergame;

public class ExampleErzeuger
{

    DungeonModelAbstract model;

    public ExampleErzeuger(DungeonModelAbstract model)
    {
        this.model = model;   
    }

    char[][] erzeugeDungeonLeer(int size) {
        char[][] dung = new char[size][];
        for (int i=0; i<dung.length; i++) {
            dung[i] = new char[size];
            for (int j=0; j<dung[i].length; j++) {
                dung[i][j] = Setup.EMPTY;
            }        
        }       
        return dung;
    }

    void fillBorder(char[][]dungeon) {
        for (int i=0; i<dungeon.length; i++) {
            dungeon[i][0] = Setup.BLOCK;
            dungeon[0][i] = Setup.BLOCK;
            dungeon[i][dungeon.length-1] = Setup.BLOCK;
            dungeon[dungeon.length-1][i] = Setup.BLOCK;
        }
    }

    void fillExample() {
        fillBorder(model.dungeon);
        model.setBlock(1,1);
        model.setBlock(1,3);
        model.setBlock(1,5);
        model.setBlock(2,5);
        model.setBlock(2,7);
        model.setBlock(3,1);
        model.setBlock(3,3);
        model.setBlock(4,1);
        model.setBlock(4,3);
        model.setBlock(4,5);
        model.setBlock(4,7);
        model.setBlock(6,1);
        model.setBlock(6,3);
        model.setBlock(6,5);
        model.setBlock(6,8);
        model.setBlock(7,1);
        model.setBlock(7,3);
        model.setBlock(7,5);
        model.setBlock(7,6);
        model.setBlock(7,8);
        model.setBlock(8,1);
        model.setCoin(5,4);
        // setWeapon(2,2);
    }

    void fillExampleSimple() {
        fillBorder(model.dungeon);
        model.setBlock(4,4);
        model.setBlock(6,4);
        model.setBlock(4,6);
        model.setBlock(6,6);
        model.setBlock(5,5);
        model.setBlock(5,4);
        model.setCoin(3,4);
        model.setCoin(7,7);
    }

    private void fillRandom() {
        for (int y=0; y<model.dungeon.length; y++) {
            for (int x=0; x<model.dungeon[y].length; x++) {
                if (Math.random()>0.7) {
                    model.setBlock(x,y);
                } else {
                    model.setEmpty(x,y);
                }
            }
        }
    }

}
