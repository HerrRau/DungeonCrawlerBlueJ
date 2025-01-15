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

public class DungeonfensterFigur extends JFrame {
  // start attributes
  protected JPanel jPanel1 = new JPanel(null, true);
    protected JLabel ltext1 = new JLabel();
    protected JButton bLinksdrehen1 = new JButton();
    protected JButton bVor1 = new JButton();
    protected JButton bRechtsdrehen1 = new JButton();
    protected JButton bJa1 = new JButton();
    protected JButton bNein1 = new JButton();
    protected JButton jButton1 = new JButton();
    protected JButton jButton2 = new JButton();
    protected JButton jButton3 = new JButton();
    protected JButton jButton4 = new JButton();
    protected JButton jButton5 = new JButton();
    protected JButton jButton6 = new JButton();
    protected JButton jButton7 = new JButton();
    private JLabel jLabel2 = new JLabel();
    private ImageIcon jLabel2Icon = new ImageIcon(getClass().getResource("images/figur_hintergrund.png"));
    private JButton jButton8 = new JButton();
  // end attributes
  
  public DungeonfensterFigur() { 
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
    setTitle("DungeonfensterFigur");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // start components
    
    jPanel1.setBounds(24, 0, 550, 848);
    jPanel1.setOpaque(false);
    cp.add(jPanel1);
    ltext1.setBounds(24, 704, 500, 105);
    ltext1.setText("");
    ltext1.setBackground(Color.WHITE);
    ltext1.setVerticalAlignment(SwingConstants.TOP);
    jPanel1.add(ltext1);
    jButton2.setBounds(184, 176, 200, 200);
    jButton2.setText("Button");
    jButton2.setMargin(new Insets(2, 2, 2, 2));
    jButton2.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton2_ActionPerformed(evt);
      }
    });
    jPanel1.add(jButton2);
    jButton1.setBounds(240, 8, 80, 80);
    jButton1.setText("Button");
    jButton1.setMargin(new Insets(2, 2, 2, 2));
    jButton1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton1_ActionPerformed(evt);
      }
    });
    jPanel1.add(jButton1);
    jPanel1.add(jButton2);
    jButton3.setBounds(224, 440, 100, 100);
    jButton3.setText("Button");
    jButton3.setMargin(new Insets(2, 2, 2, 2));
    jButton3.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton3_ActionPerformed(evt);
      }
    });
    jPanel1.add(jButton3);
    jButton4.setBounds(32, 88, 130, 130);
    jButton4.setText("Button");
    jButton4.setMargin(new Insets(2, 2, 2, 2));
    jButton4.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton4_ActionPerformed(evt);
      }
    });
    jPanel1.add(jButton4);
    jButton5.setBounds(384, 80, 130, 130);
    jButton5.setText("Button");
    jButton5.setMargin(new Insets(2, 2, 2, 2));
    jButton5.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton5_ActionPerformed(evt);
      }
    });
    jPanel1.add(jButton5);
    jButton6.setBounds(64, 272, 70, 70);
    jButton6.setText("Button");
    jButton6.setMargin(new Insets(2, 2, 2, 2));
    jButton6.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton6_ActionPerformed(evt);
      }
    });
    jPanel1.add(jButton6);
    jButton7.setBounds(416, 232, 70, 70);
    jButton7.setText("Button");
    jButton7.setMargin(new Insets(2, 2, 2, 2));
    jButton7.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton7_ActionPerformed(evt);
      }
    });
    jPanel1.add(jButton7);
    jLabel2.setBounds(24, 0, 500, 560);
    jLabel2.setText("Text");
    jLabel2.setBackground(Color.WHITE);
    jLabel2.setIcon(jLabel2Icon);
    jLabel2.setVerticalAlignment(SwingConstants.TOP);
    jPanel1.add(jLabel2);
    jButton8.setBounds(184, 592, 177, 73);
    jButton8.setText("Button");
    jButton8.setMargin(new Insets(2, 2, 2, 2));
    jButton8.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton8_ActionPerformed(evt);
      }
    });
    jPanel1.add(jButton8);
    // end components
    
    setVisible(true);
  } // end of public DungeonfensterFigur
  
  // start methods
  
  public static void main(String[] args) {
    new DungeonfensterFigur();
  } // end of main
  
  public void jButton2_ActionPerformed(ActionEvent evt) {
    // TODO add your code here
    
  } // end of jButton2_ActionPerformed

  public void jButton1_ActionPerformed(ActionEvent evt) {
    // TODO add your code here
    
  } // end of jButton1_ActionPerformed

  public void jButton3_ActionPerformed(ActionEvent evt) {
    // TODO add your code here
    
  } // end of jButton3_ActionPerformed

  public void jButton4_ActionPerformed(ActionEvent evt) {
    // TODO add your code here
    
  } // end of jButton4_ActionPerformed

  public void jButton5_ActionPerformed(ActionEvent evt) {
    // TODO add your code here
    
  } // end of jButton5_ActionPerformed

  public void jButton6_ActionPerformed(ActionEvent evt) {
    // TODO add your code here
    
  } // end of jButton6_ActionPerformed

  public void jButton7_ActionPerformed(ActionEvent evt) {
    // TODO add your code here
    
  } // end of jButton7_ActionPerformed

  public void jButton8_ActionPerformed(ActionEvent evt) {
    // TODO add your code here
    
  } // end of jButton8_ActionPerformed

  // end methods
} // end of class DungeonfensterFigur
