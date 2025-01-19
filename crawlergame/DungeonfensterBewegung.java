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
    protected JButton bLinksdrehen1 = new JButton();
    protected JButton bRechtsdrehen1 = new JButton();
    protected JButton bVor1 = new JButton();
    protected JButton bJa1 = new JButton();
    protected JButton bNein1 = new JButton();
    protected JTextArea jTextArea1 = new JTextArea();
    protected JScrollPane jTextArea1ScrollPane = new JScrollPane(jTextArea1);
    // end attributes

    public DungeonfensterBewegung() { 
        // Frame init
        super();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        int frameWidth = 607; 
        int frameHeight = 903;
        setSize(frameWidth, frameHeight);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (d.width - getSize().width) / 2;
        int y = (d.height - getSize().height) / 2;
        setLocation(x, y);
        setTitle("DungeonfensterBewegung");
        setResizable(false);
        Container cp = getContentPane();
        cp.setLayout(null);
        // start components

        
        jPanel1.setBounds(24, 0, 550, 848);
        jPanel1.setOpaque(false);
        cp.add(jPanel1);
        bLinksdrehen1.setBounds(72, 552, 113, 49);
        bLinksdrehen1.setText("Linksdrehen");
        bLinksdrehen1.setMargin(new Insets(2, 2, 2, 2));
        bLinksdrehen1.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    bLinksdrehen1_ActionPerformed(evt);
                }
            });
        jPanel1.add(bLinksdrehen1);
        bRechtsdrehen1.setBounds(392, 544, 121, 49);
        bRechtsdrehen1.setText("Rechtsdrehen");
        bRechtsdrehen1.setMargin(new Insets(2, 2, 2, 2));
        bRechtsdrehen1.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    bRechtsdrehen1_ActionPerformed(evt);
                }
            });
        jPanel1.add(bRechtsdrehen1);
        bVor1.setBounds(224, 528, 129, 57);
        bVor1.setText("Vor");
        bVor1.setMargin(new Insets(2, 2, 2, 2));
        bVor1.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    bVor1_ActionPerformed(evt);
                }
            });
        jPanel1.add(bVor1);
        bJa1.setBounds(208, 600, 65, 49);
        bJa1.setText("Ja");
        bJa1.setMargin(new Insets(2, 2, 2, 2));
        bJa1.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    bJa1_ActionPerformed(evt);
                }
            });
        jPanel1.add(bJa1);
        bNein1.setBounds(296, 600, 72, 49);
        bNein1.setText("Nein");
        bNein1.setMargin(new Insets(2, 2, 2, 2));
        bNein1.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    bNein1_ActionPerformed(evt);
                }
            });
        jPanel1.add(bNein1);
        jTextArea1ScrollPane.setBounds(16, 664, 512, 176);
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setEditable(false);
        jTextArea1.setLineWrap(true);
        jPanel1.add(jTextArea1ScrollPane);
        // end components

        setVisible(true);
    } // end of public DungeonfensterBewegung

    // start methods

    public static void main(String[] args) {
        new DungeonfensterBewegung();
    } // end of main

    public void bLinksdrehen1_ActionPerformed(ActionEvent evt) {
        // TODO add your code here

    } // end of bLinksdrehen1_ActionPerformed

    public void bRechtsdrehen1_ActionPerformed(ActionEvent evt) {
        // TODO add your code here

    } // end of bRechtsdrehen1_ActionPerformed

    public void bVor1_ActionPerformed(ActionEvent evt) {
        // TODO add your code here

    } // end of bVor1_ActionPerformed

    public void bJa1_ActionPerformed(ActionEvent evt) {
        // TODO add your code here

    } // end of bJa1_ActionPerformed

    public void bNein1_ActionPerformed(ActionEvent evt) {
        // TODO add your code here

    } // end of bNein1_ActionPerformed

    // end methods
} // end of class DungeonfensterFigur
