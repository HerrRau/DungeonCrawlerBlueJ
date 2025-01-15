import java.awt.*;
import java.awt.event.*;

public class DungeonBewegungVorzimmer extends DungeonfensterBewegung implements DungeonViewBewegung
{
    DungeonController controller;
    JPanelBewegung jPanel;
    Color background = Color.BLACK;

    public DungeonBewegungVorzimmer()
    {
        super();
        jPanel = new JPanelBewegung();
        jPanel.setBounds(0, 0, 577+30, 848-250);
        jPanel.setOpaque(false);
        getContentPane().add(jPanel);

        jPanel.canvasSizeX = jPanel.getWidth();
        jPanel.canvasSizeY = jPanel.getHeight();
        // jPanel.canvasSizeX = 500+80-80;
        // jPanel.canvasSizeY = 500+80-80;

        super.getContentPane().setBackground(background);

    }

    void show(char[][] miniDungeonTemp, int xPosPlayer, int yPosPlayer) {
        jPanel.show(miniDungeonTemp, xPosPlayer, yPosPlayer);
    }

    void setzeController(DungeonController c) {
        controller = c;
        jPanel.setzeController(c);
    }

    public void bLinksdrehen1_ActionPerformed(ActionEvent evt) {
        // TODO add your code here
        controller.empfangeBewegungDreheLinks();

    } // end of bLinksdrehen1_ActionPerformed

    public void bVor1_ActionPerformed(ActionEvent evt) {
        // TODO add your code here
        controller.empfangeBewegungVorwaerts();

    } // end of bVor1_ActionPerformed

    public void bRechtsdrehen1_ActionPerformed(ActionEvent evt) {
        // TODO add your code here
        controller.empfangeBewegungDreheRechts();

    } // end of bRechtsdrehen1_ActionPerformed

    public void bJa1_ActionPerformed(ActionEvent evt) {
        controller.empfangeBewegungJa();
        // TODO add your code here

    } // end of bJa1_ActionPerformed

    public void bNein1_ActionPerformed(ActionEvent evt) {
        // TODO add your code here

    } // end of bNein1_ActionPerformed

        public void zeigeBewegungGegenstand(String bildname) {
    }

    public void zeigeBewegungNachricht(String text) {
    }

    public void zeigeBewegungDungeon(char[][] miniDungeonTemp, int xPosPlayer, int yPosPlayer) {
        this.show(miniDungeonTemp,xPosPlayer,yPosPlayer);
    }

}
