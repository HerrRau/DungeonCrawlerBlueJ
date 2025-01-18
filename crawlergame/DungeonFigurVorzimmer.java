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
    }

    public void setzeController(DungeonController c) {
        controller = c;
    }

    void waehleKoerperteil(int i) {
        //controller.empfangeFigurWaehleKoerperteil(i);
        controller.empfangeWunsch(0,i);
    }

    public void zeigeFigurNachricht(String name) {
    }

    public void zeigeFigur(int i, String bildname) {
        System.out.println("DFV: "+i);
        ImageIcon icon = new ImageIcon(getClass().getResource(Setup.imagePath+bildname));       
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
        button.setIcon( resizeIcon(icon, button.getWidth(), button.getHeight()) );

    }
    void zeigeAusruestung (int koerperteil) {
    }

    void zeigeText(String s) {
    }

    public void jButton2_ActionPerformed(ActionEvent evt) {
        // controller.empfangeFigurWaehleKoerperteil(2);
        controller.empfangeWunsch(0,2);
    } // end of jButton2_ActionPerformed

    public void jButton1_ActionPerformed(ActionEvent evt) {
        // controller.empfangeFigurWaehleKoerperteil(1);
        controller.empfangeWunsch(0,1);
    } // end of jButton1_ActionPerformed

    public void jButton3_ActionPerformed(ActionEvent evt) {
        // controller.empfangeFigurWaehleKoerperteil(3);
        controller.empfangeWunsch(0,3);
    } // end of jButton3_ActionPerformed

    public void jButton4_ActionPerformed(ActionEvent evt) {
        // controller.empfangeFigurWaehleKoerperteil(4);
        controller.empfangeWunsch(0,4);
    } // end of jButton4_ActionPerformed

    public void jButton5_ActionPerformed(ActionEvent evt) {
        // controller.empfangeFigurWaehleKoerperteil(5);
        controller.empfangeWunsch(0,5);
    } // end of jButton5_ActionPerformed

    public void jButton6_ActionPerformed(ActionEvent evt) {
        // controller.empfangeFigurWaehleKoerperteil(6);
        controller.empfangeWunsch(0,6);
    } // end of jButton6_ActionPerformed

    public void jButton7_ActionPerformed(ActionEvent evt) {
        // controller.empfangeFigurWaehleKoerperteil(7);
        controller.empfangeWunsch(0,7);

    } // end of jButton7_ActionPerformed

    public void jButton8_ActionPerformed(ActionEvent evt) {
        // TODO add your code here

    } // end of jButton8_ActionPerformed

    private static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
        Image img = icon.getImage();  
        Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight,  java.awt.Image.SCALE_SMOOTH);  
        return new ImageIcon(resizedImage);
    }
}
