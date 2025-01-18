package crawlergame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class JPanelBewegung extends JPanel
{

    char[][] miniDungeon;
    int canvasSizeX = 500;
    int canvasSizeY = 500;
    private int xPos, yPos; // nur fuer einfaerbung
    JButton jButton1;

    boolean drawLines = true;
    boolean drawBorders = true;

    boolean initialisiert = false;

    DungeonController controller;

    Color background = Setup.backgroundColor;

    double [] blockSizeX;
    double [] blockSizeY;
    int [] maxAnzahlInEbene;

    int frameThicknessX = 80;
    int frameThicknessY = 80;

    public JPanelBewegung()
    {
        super(null, true);
        jButton1 = new JButton();
        jButton1.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    jButton1_ActionPerformed(evt);
                }
            });

        this.add(jButton1);
    }

    void setzeController(DungeonController c) {
        controller = c;
    }

    public void jButton1_ActionPerformed(ActionEvent evt) {
        // controller.empfangeBewegungJa();
        controller.empfangeWunsch(2,3);
    } // end of jButton1_ActionPerformed

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    void show(char[][] miniDungeonTemp, int xPosPlayer, int yPosPlayer) {
        xPos = xPosPlayer;
        yPos = yPosPlayer;
        miniDungeon = miniDungeonTemp;
        if (!initialisiert) {
            initialisiert = true;
            setValues();
        }
        repaint();
    }

    protected void drawTrapeze(double x0, double y0, double x1, double y1, double x2, double y2, double x3, double y3, int depth, Graphics g) {
        Polygon polygon = new Polygon();
        polygon.addPoint((int)x0, (int)y0);
        polygon.addPoint((int)x1, (int)y1);
        polygon.addPoint((int)x2, (int)y2);
        polygon.addPoint((int)x3, (int)y3);
        if ((xPos+yPos)%2 == depth%2) g.setColor(Color.LIGHT_GRAY);
        else g.setColor(Color.GRAY);
        g.fillPolygon(polygon);
        if (!drawBorders) return;
        g.setColor(Color.BLACK);
        g.drawPolygon(polygon);        
    }

    protected void drawRectangle(Polygon p, Graphics g) {
        g.setColor(Color.GRAY);
        g.fillPolygon(p);            
        if (!drawBorders) return;
        g.setColor(Color.BLACK);
        g.drawPolygon(p);            
    }

    protected void drawRectangle(double x, double y, double width, double height, Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect( (int)x, (int)y, (int) width, (int) height);            
        if (!drawBorders) return;
        g.setColor(Color.BLACK);
        g.drawRect( (int)x, (int)y, (int) width, (int) height);            
    }

    protected Image scaleImage(ImageIcon icon, int width, int height, int OLD) {
        OLD = icon.getIconWidth();
        Image image = icon.getImage().getScaledInstance(
                icon.getIconWidth() * width / OLD,
                icon.getIconHeight() * height / OLD,
                Image.SCALE_SMOOTH);
        icon = new ImageIcon(image, icon.getDescription());
        return icon.getImage();
    }

    protected Image scaleImage2(ImageIcon icon, int width, int height) {
        Image image = icon.getImage().getScaledInstance(
                icon.getIconWidth() * width / icon.getIconWidth(),
                icon.getIconHeight() * height / icon.getIconHeight(),
                Image.SCALE_SMOOTH);
        icon = new ImageIcon(image, icon.getDescription());
        return icon.getImage();
    }

    void eraseAll(Graphics g) {
        jButton1.setVisible(false);
        g.setColor(background);
        //g.clearRect(0,0,canvasSizeX,canvasSizeY);
        g.fillRect(0,0,canvasSizeX,canvasSizeY);
    }

    void drawLines(Graphics g) {                

        if (miniDungeon==null) return;
        Color c = Color.MAGENTA;
        int x = canvasSizeX/2;
        int y = canvasSizeY/2;
        g.setColor(c);
        g.drawLine( x,  0, x, canvasSizeY); //vert
        g.drawLine( 0, y, 0, canvasSizeX);// horiz
        g.drawLine( 0,  0, canvasSizeX, canvasSizeY);
        g.drawLine( canvasSizeX,  0, 0, canvasSizeY);
        for(int i=0; i<miniDungeon.length; i++) {
            if      (i%5==0) c = Color.BLUE;
            else if (i%5==1) c = Color.RED;
            else if (i%5==2) c = Color.GREEN;
            else if (i%5==3)c = Color.BLACK;
            else c = Color.YELLOW;
            g.setColor(c);

            //vertical
            int deltaX = (int) (blockSizeX[i]/2);
            int deltaY = (int) (blockSizeY[i]/2);
            g.drawLine( x + deltaX,  0, x + deltaX, canvasSizeY);
            g.drawLine( x - deltaX,  0, x - deltaX, canvasSizeY);

            //horizontal
            g.drawLine( 0, y + deltaY,  canvasSizeX, y + deltaY);
            g.drawLine( 0, y - deltaY,  canvasSizeX, y - deltaY);

            //diagonal
            // g.drawLine( 0 + deltaX,  0, canvasSizeX, canvasSizeY - deltaY);
            // g.drawLine( 0, 0 + deltaY, canvasSizeX - deltaX, canvasSizeY);

            // g.drawLine( 0,  canvasSizeY - deltaY, canvasSizeX - deltaX, 0);
            // g.drawLine( 0 + deltaX, canvasSizeY, canvasSizeX, 0 + deltaY);
        }
    }

    void drawBlockFront(int depth, int x, Graphics g) {
        double width = blockSizeX[depth];
        double height = blockSizeY[depth];
        double ypos = canvasSizeY/2 - blockSizeY[depth]/2; // gilt fuer alle, vom zentrum aus gemessen
        double xpos = -width/2;  //offset fuer das halbe
        int temp = (int) ((maxAnzahlInEbene[depth]-miniDungeon[depth].length)/2);
        xpos = xpos + temp * width; //offset wegen evtl fehlener
        xpos = xpos + x * width; //abhaengigkeit vom x        

        if (depth == miniDungeon.length-1)  {
            xpos -= width/2;
        }

        ///////////////

        boolean showPartOnly = false;

        if (depth == miniDungeon.length-2)  {
            showPartOnly = true;
        }

        if (x>miniDungeon[depth].length/2) {
            if (showPartOnly) {
                width = width/2;
            }
        }

        if (depth<miniDungeon.length-1) {
            drawRectangle( xpos, ypos, width, height, g); //letztes auslassen
        }
    }

    void drawBlockSides(int depth, int x, Graphics g) {
        double width = blockSizeX[depth];
        double height = blockSizeY[depth];
        double ypos = canvasSizeY/2 - blockSizeY[depth]/2; // gilt fuer alle, vom zentrum aus gemessen
        double xpos = -width/2;  //offset fuer das halbe
        int temp = (int) ((maxAnzahlInEbene[depth]-miniDungeon[depth].length)/2);
        xpos = xpos + temp * width; //offset wegen evtl fehlener
        xpos = xpos + x * width; //abhaengigkeit vom x        

        if (depth == miniDungeon.length-1)  {
            xpos -= width/2;
        }

        ///////////////

        double deltaX = width/2/2;
        double deltaY = height/2/2;

        if (x<miniDungeon[depth].length/2) {
            drawTrapeze(
                xpos+width, ypos,
                xpos+width+deltaX, ypos+deltaY,
                xpos+width+deltaX, ypos+height-deltaY,
                xpos+width, ypos+height,
                depth, g);
        } else if (x>miniDungeon[depth].length/2) {
            drawTrapeze(
                xpos, ypos,
                xpos, ypos+height,
                xpos-deltaX, ypos+height-deltaY,
                xpos-deltaX, ypos+deltaY,
                depth, g);
        }

    }

    void setValues() {
        blockSizeX = new double[miniDungeon.length];
        blockSizeY = new double[miniDungeon.length];
        maxAnzahlInEbene = new int[miniDungeon.length];
        // double fractions [] = new double[miniDungeon.length];
        for (int i=0; i<miniDungeon.length; i++) {
            blockSizeX[i] = canvasSizeX * 1/(Math.pow(2, miniDungeon.length-i-1)); 
            blockSizeY[i] = canvasSizeY * 1/(Math.pow(2, miniDungeon.length-i-1));
            maxAnzahlInEbene[i] = (int) Math.pow(2,miniDungeon.length-i-1)+1;
        }
        // 0 > 9 blue       2^3+1
        // 1 > 5 red        2^2+1
        // 2 > 3 green      2^1+1
        // 3 > 1            2^0+1 -> 2

        //was passiert, wenn miniDungeoLength > mximaleAnzahl???

        drawLines = false;
    }

    //#################################

    void draw(Graphics g) {
        eraseAll(g);
        if (drawLines) drawLines(g);

        //go through all levels
        for (int depth = 0; depth < miniDungeon.length; depth++) {
            // first, draw all the sides for the level
            for (int x = 0; x<miniDungeon[depth].length; x++) {
                char item = miniDungeon[depth][x]; 
                if (item == Setup.BLOCK) {
                    drawBlockSides(depth, x, g);
                }
            }
            // then, draw all the fronts (to cover any sides)
            for (int x = 0; x<miniDungeon[depth].length; x++) {
                char item = miniDungeon[depth][x]; 
                if (item == Setup.BLOCK) {
                    drawBlockFront(depth, x, g);
                }
                //and the items, which could go elsewhere, too, I guess
                else if (item!=Setup.EMPTY) {
                    drawItem(depth, x, item, g);
                }
            }
        }

        putAFrameOnIt(g, frameThicknessX, frameThicknessY);
    }

    void putAFrameOnIt(Graphics g, int thicknessX, int thicknessY) {
        g.setColor(background);
        g.fillRect(0,0, canvasSizeX,thicknessY); // oben
        g.fillRect(0,canvasSizeY-thicknessX,canvasSizeX,thicknessY); //unten
        g.fillRect(0,0, thicknessX,canvasSizeY); //links
        g.fillRect(canvasSizeX-thicknessX, 0, thicknessX, canvasSizeY); //rechts
    }

    void drawItem(int depth, int x, char type, Graphics g) {
        String bilddatei = ((DungeonControllerAbstract)controller).gibBildname(type);
        ImageIcon icon = null;
        icon = new ImageIcon(getClass().getResource(Setup.imagePath+bilddatei));            
        int orgWidth = icon.getIconWidth();
        int orgHeight = icon.getIconHeight();
        int newWidth = (int) (blockSizeX[depth]/2);
        int newHeight = (int) (orgHeight*1.0*orgWidth/newWidth); //unused ...zB auf Breite der Ebene, und dann nachganz unten?
        newWidth = (int)(newWidth * 0.8);
        newHeight = (int)(newHeight * 0.8);
        Image newImage = scaleImage2(icon, newWidth, newWidth*1);

        int xpos = canvasSizeX/2 - newWidth/2; //i.e. mitte
        int ypos = canvasSizeY - newImage.getHeight(null) - frameThicknessY; //wg border, ist jetzt: ganz unten
        ypos = canvasSizeY/2; //eher:Mitte

        if (x<miniDungeon[depth].length/2) { //links der figur
            xpos = xpos - (int)blockSizeX [depth]/2;
            newWidth = (int) (newWidth * 0.7);
        }
        else if (x>miniDungeon[depth].length/2) { //rechts der figur
            xpos = xpos + (int)blockSizeX [depth]/2;
            newWidth = (int) (newWidth * 0.7);
        }        
        if (x==miniDungeon[depth].length/2 && depth == miniDungeon.length-1) {
            jButton1.setVisible(true);
            jButton1.setBounds((int) xpos, (int) ypos, newWidth, newWidth*1);
            jButton1.setIcon( new ImageIcon (newImage));
        } else {
            g.drawImage(newImage, (int) xpos, (int) ypos, null);               
        }

    }
}
