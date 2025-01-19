package crawlergame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;   

import java.awt.event.*;

public class DungeonFigurVorzimmer extends DungeonfensterFigur implements DungeonViewFigur
{
    DungeonController controller;

    public DungeonFigurVorzimmer()
    {
        jButton1.setContentAreaFilled(false);
        jButton2.setContentAreaFilled(false);
        jButton3.setContentAreaFilled(false);
        jButton4.setContentAreaFilled(false);
        jButton5.setContentAreaFilled(false);
        jButton6.setContentAreaFilled(false);
        jButton7.setContentAreaFilled(false);
        
        ImageIcon icon = new ImageIcon( Setup.getResource("figur_hintergrund.png") );
        jLabel2.setIcon(icon);
    }

    @Override public void setController(DungeonController c) {
        controller = c;
    }

    void waehleKoerperteil(int i) {
        controller.receiveRequest(0,i);
    }

    public void zeigeFigurNachricht(String name) {
    }

    public void zeigeFigur(int i, String bildname) {        
        ImageIcon icon = null;
        icon = new ImageIcon(Setup.getResource(bildname));            
        JButton button = null;
        switch(i) {
            case 0: button = jButton1; break;
            case 1: button = jButton2; break;
            case 2: button = jButton3; break;
            case 3: button = jButton4; break;
            case 4: button = jButton5; break;
            case 5: button = jButton6; break;
            case 6: button = jButton7; break;
        }
        button.setIcon( Setup.resizeIcon(icon, button.getWidth(), button.getHeight()) );

    }

    void zeigeAusruestung (int koerperteil) {
    }

    void zeigeText(String s) {
    }

    public void jButton2_ActionPerformed(ActionEvent evt) {
        if (controller!=null) controller.receiveRequest(0,1);
    } // end of jButton2_ActionPerformed

    public void jButton1_ActionPerformed(ActionEvent evt) {
        if (controller!=null) controller.receiveRequest(0,0);
    } // end of jButton1_ActionPerformed

    public void jButton3_ActionPerformed(ActionEvent evt) {
        if (controller!=null) controller.receiveRequest(0,2);
    } // end of jButton3_ActionPerformed

    public void jButton4_ActionPerformed(ActionEvent evt) {
        if (controller!=null) controller.receiveRequest(0,3);
    } // end of jButton4_ActionPerformed

    public void jButton5_ActionPerformed(ActionEvent evt) {
        if (controller!=null) controller.receiveRequest(0,4);
    } // end of jButton5_ActionPerformed

    public void jButton6_ActionPerformed(ActionEvent evt) {
        if (controller!=null) controller.receiveRequest(0,5);
    } // end of jButton6_ActionPerformed

    public void jButton7_ActionPerformed(ActionEvent evt) {
        if (controller!=null) controller.receiveRequest(0,6);
    } // end of jButton7_ActionPerformed

    public void jButton8_ActionPerformed(ActionEvent evt) {
        if (controller!=null) controller.receiveRequest(0,7);
    } // end of jButton8_ActionPerformed

    public void zeigeFigurStats(String [] strings) {
        for (int i=0; i<strings.length; i++) {
            System.out.println(strings[i]);
        }
    }

}
