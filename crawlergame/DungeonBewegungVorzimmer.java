package crawlergame;

import java.awt.*;
import java.awt.event.*;

public class DungeonBewegungVorzimmer extends DungeonfensterBewegung implements DungeonViewBewegung
{
    DungeonController controller;
    JPanelBewegung jPanel;

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

        super.getContentPane().setBackground(Setup.backgroundColor);
        
        //Font font = new Font("Verdana", Font.BOLD, 12);
        Font font = new Font(Font.MONOSPACED, Font.PLAIN, 20);
        jTextArea1.setFont(font);


    }

    @Override public void setController(DungeonController c) {
        controller = c;
        jPanel.setzeController(c);
    }

    void show(char[][] miniDungeonTemp, int xPosPlayer, int yPosPlayer) {
        jPanel.show(miniDungeonTemp, xPosPlayer, yPosPlayer);
    }

    public void bLinksdrehen1_ActionPerformed(ActionEvent evt) {
        //controller.empfangeBewegungDreheLinks();
        controller.receiveRequest(2,1);

    } // end of bLinksdrehen1_ActionPerformed

    public void bVor1_ActionPerformed(ActionEvent evt) {
        //controller.empfangeBewegungVorwaerts();
        controller.receiveRequest(2,0);
    } // end of bVor1_ActionPerformed

    public void bRechtsdrehen1_ActionPerformed(ActionEvent evt) {
        // controller.empfangeBewegungDreheRechts();
        controller.receiveRequest(2,2);

    } // end of bRechtsdrehen1_ActionPerformed

    public void bJa1_ActionPerformed(ActionEvent evt) {
        // controller.empfangeBewegungJa();
        controller.receiveRequest(2,3);

    } // end of bJa1_ActionPerformed

    public void bNein1_ActionPerformed(ActionEvent evt) {
        controller.receiveRequest(2,4);
    } // end of bNein1_ActionPerformed

    public void zeigeBewegungGegenstand(String bildname) {
    }

    public void zeigeBewegungNachricht(String text) {
        jTextArea1.setText(text);
        jTextArea1.setCaretPosition(jTextArea1.getDocument().getLength());
        //################## 

    }

    public void zeigeBewegungAusschnitt(char[][] miniDungeonTemp, int xPosPlayer, int yPosPlayer) {
        this.show(miniDungeonTemp,xPosPlayer,yPosPlayer);
    }

    private char getFacingChar(char dir) {
        if (dir=='N') return Setup.FACING_N;
        else if (dir=='E') return Setup.FACING_E;
        else if (dir=='S') return Setup.FACING_S;
        else return Setup.FACING_W;

    }

    public void zeigeBewegungDungeon(char[][] dungeon, int xPosPlayer, int yPosPlayer, char facing) {
        String result = "";

        char old = dungeon[yPosPlayer][xPosPlayer];
        dungeon[yPosPlayer][xPosPlayer] = getFacingChar(facing); //Player

        for (int y=0; y<dungeon.length; y++) {
            for (int x=0; x<dungeon[y].length; x++) {
                char c = dungeon[y][x];
                result += c;
            }
            result += "\n";
        }
        result += "\n";

        dungeon[yPosPlayer][xPosPlayer] = old; // before Player
        zeigeBewegungNachricht(result);
    }
}
