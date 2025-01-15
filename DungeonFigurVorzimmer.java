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
        controller.empfangeFigurWaehleKoerperteil(i);
    }

    public void zeigeFigurNachricht(String name) {
    }

    public void zeigeFigurKoerperteil(int u, String bildname) {
    }

    void zeigeAusruestung (int koerperteil) {
    }
    void zeigeText(String s) {
    }
    public void jButton2_ActionPerformed(ActionEvent evt) {
        controller.empfangeFigurWaehleKoerperteil(2);
    } // end of jButton2_ActionPerformed

    public void jButton1_ActionPerformed(ActionEvent evt) {
        controller.empfangeFigurWaehleKoerperteil(1);
    } // end of jButton1_ActionPerformed

    public void jButton3_ActionPerformed(ActionEvent evt) {
        controller.empfangeFigurWaehleKoerperteil(3);
    } // end of jButton3_ActionPerformed

    public void jButton4_ActionPerformed(ActionEvent evt) {
        controller.empfangeFigurWaehleKoerperteil(4);
    } // end of jButton4_ActionPerformed

    public void jButton5_ActionPerformed(ActionEvent evt) {
        controller.empfangeFigurWaehleKoerperteil(5);
    } // end of jButton5_ActionPerformed

    public void jButton6_ActionPerformed(ActionEvent evt) {
        controller.empfangeFigurWaehleKoerperteil(6);
    } // end of jButton6_ActionPerformed

    public void jButton7_ActionPerformed(ActionEvent evt) {
        controller.empfangeFigurWaehleKoerperteil(7);
    } // end of jButton7_ActionPerformed

    public void jButton8_ActionPerformed(ActionEvent evt) {
        // TODO add your code here

    } // end of jButton8_ActionPerformed

    public void zeigeFigurWaffe(String bildname) {
        ImageIcon icon = new ImageIcon(getClass().getResource(Setup.imagePath+bildname));       
        jButton4.setIcon( resizeIcon(icon, jButton4.getWidth(), jButton4.getHeight()) );
    }

    private static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
        Image img = icon.getImage();  
        Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight,  java.awt.Image.SCALE_SMOOTH);  
        return new ImageIcon(resizedImage);
    }
}