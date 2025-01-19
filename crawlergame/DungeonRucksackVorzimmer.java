package crawlergame;

import java.awt.event.*;
import javax.swing.*;

public class DungeonRucksackVorzimmer extends DungeonfensterRucksack implements DungeonViewAusruestung
{
    DungeonController controller;

    public DungeonRucksackVorzimmer()
    {
    }

    public void setController(DungeonController c) {
        controller = c;
    }

    public void bLinks1_ActionPerformed(ActionEvent evt) {
        controller.receiveRequest(1,0);
    } // end of bLinks1_ActionPerformed

    public void bItem1_ActionPerformed(ActionEvent evt) {
        controller.receiveRequest(1,1);
    } // end of bItem1_ActionPerformed

    public void bRechts1_ActionPerformed(ActionEvent evt) {
        controller.receiveRequest(1,2);
    } // end of bRechts1_ActionPerformed

    public void bNein1_ActionPerformed(ActionEvent evt) {
    } // end of bNein1_ActionPerformed

    public void bDrop1_ActionPerformed(ActionEvent evt) {
        controller.receiveRequest(1, 3);
    } // end of bDrop1_ActionPerformed

    private void drawImage(String bildname) {
        ImageIcon icon = new ImageIcon(Setup.getResource(bildname));            
        bItem1.setIcon( Setup.resizeIcon(icon, bItem1.getWidth(), bItem1.getHeight()) );
    }

    public void  showDescription(String s) {
        lBeschreibung1.setText(s);      
    }

    public void zeigeAusruestungGegenstandBild(String bildname) {
        this.drawImage(bildname);
    }

    public void zeigeAusruestungGegenstandName(String name) {
        this.showDescription(name);
    }

    public void zeigeAusruestungGegenstandBeschreibung(String text) {
        this.showDescription(text);
    }

    public void zeigeAusruestungNachricht(String name) {

    }

}
