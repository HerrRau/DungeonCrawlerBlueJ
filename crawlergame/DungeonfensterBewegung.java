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

public class DungeonfensterBewegung extends JFrame {
    // start attributes
    protected JPanel jPanel1 = new JPanel(null, true);
    //protected JPanelBewegung jPanel1 = new JPanelBewegung();

    protected JLabel ltext1 = new JLabel();
    protected JButton bLinksdrehen1 = new JButton();
    protected JButton bVor1 = new JButton();
    protected JButton bRechtsdrehen1 = new JButton();
    protected JButton bJa1 = new JButton();
    protected JButton bNein1 = new JButton();
    // protected JButton jButton1 = new JButton();
    // end attributes

    public DungeonfensterBewegung() {
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

        setTitle("Dungeonfenster");

        setResizable(false);
        Container cp = getContentPane();
        cp.setLayout(null);
        // start components

        jPanel1.setBounds(8, 0, 577, 848);
        jPanel1.setOpaque(false);
        cp.add(jPanel1);

        // jButton1.addActionListener(new ActionListener() { 
                // public void actionPerformed(ActionEvent evt) { 
                    // jButton1_ActionPerformed(evt);
                // }
            // });

        // jPanel1.add(jButton1);

        ltext1.setBounds(32, 728, 513, 105);
        ltext1.setText("");
        ltext1.setBackground(Color.WHITE);
        ltext1.setVerticalAlignment(SwingConstants.TOP);
        jPanel1.add(ltext1);
        bLinksdrehen1.setBounds(80, 584, 104, 65);
        bLinksdrehen1.setText("Links drehen");
        bLinksdrehen1.setMargin(new Insets(2, 2, 2, 2));
        bLinksdrehen1.addActionListener(new 
            ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    bLinksdrehen1_ActionPerformed(evt);
                }
            });
        jPanel1.add(bLinksdrehen1);
        bVor1.setBounds(200, 544, 169, 64);
        bVor1.setText("Vor");
        bVor1.setMargin(new Insets(2, 2, 2, 2));
        bVor1.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    bVor1_ActionPerformed(evt);
                }
            });
        jPanel1.add(bVor1);
        bRechtsdrehen1.setBounds(384, 584, 112, 64);
        bRechtsdrehen1.setText("Rechts drehen");
        bRechtsdrehen1.setMargin(new Insets(2, 2, 2, 2));
        bRechtsdrehen1.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    bRechtsdrehen1_ActionPerformed(evt);
                }
            });
        jPanel1.add(bRechtsdrehen1);
        bJa1.setBounds(200, 656, 81, 57);
        bJa1.setText("Ja");
        bJa1.setMargin(new Insets(2, 2, 2, 2));
        bJa1.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    bJa1_ActionPerformed(evt);
                }
            });
        jPanel1.add(bJa1);
        bNein1.setBounds(288, 656, 81, 57);
        bNein1.setText("Nein");
        bNein1.setMargin(new Insets(2, 2, 2, 2));
        bNein1.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    bNein1_ActionPerformed(evt);
                }
            });
        jPanel1.add(bNein1);
        // end components

        setVisible(true);
    } // end of public DungeonfensterFigur

    // start methods

    public static void main(String[] args) {
        new DungeonfensterBewegung();
    } // end of main

    public void bLinksdrehen1_ActionPerformed(ActionEvent evt) {
        // TODO add your code here

    } // end of bLinksdrehen1_ActionPerformed

    public void bVor1_ActionPerformed(ActionEvent evt) {
        // TODO add your code here

    } // end of bVor1_ActionPerformed

    public void bRechtsdrehen1_ActionPerformed(ActionEvent evt) {
        // TODO add your code here

    } // end of bRechtsdrehen1_ActionPerformed

    public void bJa1_ActionPerformed(ActionEvent evt) {
        // TODO add your code here

    } // end of bJa1_ActionPerformed

    public void bNein1_ActionPerformed(ActionEvent evt) {
        // TODO add your code here

    } // end of bNein1_ActionPerformed

    // public void jButton1_ActionPerformed(ActionEvent evt) {
        // // TODO add your code here

    // } // end of jButton1_ActionPerformed

    // end methods
} // end of class Dungeonfenster
