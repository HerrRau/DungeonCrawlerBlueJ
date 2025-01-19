package crawlergame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * Description                                                                                                                                    a
 *
 * @version 1.0 from 31.12.2024
 * @author 
 */

public class DungeonfensterRucksack extends JFrame {
    // start attributes
    protected JPanel jPanel1 = new JPanel(null, true);
    protected JLabel lNachricht1 = new JLabel();
    protected JButton bLinks1 = new JButton();
    protected JButton bItem1 = new JButton();
    protected JButton bRechts1 = new JButton();
    protected JButton bDrop1 = new JButton();
    protected JLabel lBeschreibung1 = new JLabel();
    // end attributes

    public DungeonfensterRucksack() {
        // Frame init
        super();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        int frameWidth = 607; 
        int frameHeight = 908;
        setSize(frameWidth, frameHeight);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (d.width - getSize().width) / 2;
        int y = (d.height - getSize().height) / 2;
        setLocation(x, y);

        setTitle("Rucksack");

        setResizable(false);
        Container cp = getContentPane();
        cp.setLayout(null);
        // start components

        jPanel1.setBounds(8, 0, 577, 848);
        jPanel1.setOpaque(false);
        cp.add(jPanel1);
        lNachricht1.setBounds(32, 736, 513, 97);
        lNachricht1.setText("Nachricht");
        lNachricht1.setBackground(Color.WHITE);
        lNachricht1.setVerticalAlignment(SwingConstants.TOP);
        jPanel1.add(lNachricht1);
        bLinks1.setBounds(8, 208, 64, 112);
        bLinks1.setText("Links");
        bLinks1.setMargin(new Insets(2, 2, 2, 2));
        bLinks1.addActionListener(new 
            ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    bLinks1_ActionPerformed(evt);
                }
            });
        jPanel1.add(bLinks1);
        bRechts1.setBounds(504, 200, 64, 112);
        bRechts1.setText("Rechts");
        bRechts1.setMargin(new Insets(2, 2, 2, 2));
        bRechts1.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    bRechts1_ActionPerformed(evt);
                }
            });
        jPanel1.add(bRechts1);
        bItem1.setBounds(88, 56, 400, 400);
        bItem1.setText("Item");
        bItem1.setMargin(new Insets(2, 2, 2, 2));
        bItem1.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    bItem1_ActionPerformed(evt);
                }
            });
        jPanel1.add(bItem1);
        bItem1.setBounds(88, 56, 400, 400);
        bLinks1.setBounds(16, 232, 48, 112);
        bDrop1.setBounds(240, 472, 80, 72);
        bDrop1.setText("Drop");
        bDrop1.setMargin(new Insets(2, 2, 2, 2));
        bDrop1.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    bDrop1_ActionPerformed(evt);
                }
            });
        jPanel1.add(bDrop1);
        lBeschreibung1.setBounds(32, 560, 505, 145);
        lBeschreibung1.setText("Beschreibung");
        lBeschreibung1.setBackground(Color.WHITE);
        jPanel1.add(lBeschreibung1);
        // end components

        setVisible(true);
    } // end of public DungeonfensterFigur

    // start methods

    public static void main(String[] args) {
        new DungeonfensterRucksack();
    } // end of main

    public void bLinks1_ActionPerformed(ActionEvent evt) {
        // TODO add your code here

    } // end of bLinks1_ActionPerformed

    public void bItem1_ActionPerformed(ActionEvent evt) {
        // TODO add your code here

    } // end of bItem1_ActionPerformed

    public void bRechts1_ActionPerformed(ActionEvent evt) {
        // TODO add your code here

    } // end of bRechts1_ActionPerformed

    public void bNein1_ActionPerformed(ActionEvent evt) {
        // TODO add your code here

    } // end of bNein1_ActionPerformed

    public void bDrop1_ActionPerformed(ActionEvent evt) {
        // TODO add your code here

    } // end of bDrop1_ActionPerformed

    // end methods
} // end of class Dungeonfenster
