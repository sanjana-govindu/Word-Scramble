import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.io.*;
import java.util.ArrayList;

public class TestGUI 
{
    static int score=0;
    static JLabel title;
    private static int cnt1=0;
    private static int cnt2=0;
    private static int cnt3=0;
    private static int cnt4=0;
    private static int cnt5=0;
    private static int word2,word3,word4,word5,word6,word7;
    private static int w2=0,w3=0,w4=0,w5=0,w6=0,w7=0;

    public static void main(String[] args) throws Exception 
    {
        startGame();
    }
    
    public static void startGame() throws InterruptedException
    {
        JFrame f = new JFrame("Word Scramble");
        f.setBackground(new Color(244,185,66));
        title=new JLabel("WELCOME TO WORD SCRAMBLE");
        JPanel mpl=new JPanel();
        JPanel pl1=new JPanel();
        JPanel pl2=new JPanel();
        pl1.setBackground(new Color(244,185,66));
        pl2.setBackground(new Color(244,185,66));
        JButton sb=new JButton("Start Game");
        sb.setBackground(Color.GREEN);
        sb.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent a)
            {
                f.setVisible(false);
                level1();
            }
        });
        JButton ib=new JButton("Instructions");
        ib.setBackground(Color.YELLOW);
        
        ib.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent x)
          {
              f.setVisible(false);
              instructions();
              f.setVisible(true);
           }
        });
        JButton hb=new JButton("High Scores");
        hb.setBackground(Color.YELLOW);

        hb.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent d)
        {
            f.setVisible(false);
            try {
              highScore();
            } catch (Exception e) {
            e.printStackTrace();
            }
            f.setVisible(true);
            }
        });

        JButton eb=new JButton("Exit");
        eb.setBackground(Color.RED);
        eb.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent xe)
          {
              System.exit(0);
          }
        });
        mpl.setLayout(new BoxLayout(mpl,BoxLayout.Y_AXIS));
        pl1.add(title);
        pl2.add(ib);
        pl2.add(sb);
        pl2.add(hb);
        pl2.add(eb);
        mpl.add(pl1);
        mpl.add(pl2);
        f.setBounds(350, 25, 650, 400);
        f.add(mpl);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      }


    public static void instructions()
    {
        JFrame fi=new JFrame("Instructions-Word Scramble");
        JPanel p=new JPanel();
        JPanel p1=new JPanel();
        JPanel p2=new JPanel();
        JButton b=new JButton("Go Back");
        b.setBackground(Color.GREEN);
        b.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent t)
            {
            fi.dispose();
            }
        });
        p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
        p.add(p1);
        p.add(p2);
        p1.add(title);
        JLabel inst=new JLabel();
        inst.setText("<html>You'll be given a random word<br>You need to guess the words that can be formed from the letters of random word<br>You will be given  
        number letters of words to be guessed<br>Score will increased by 5 for correct guess and decreased by 1 for wrong guess<br>Total score is displayed after completion of
        levels<br></html>");
        p2.add(inst);
        p2.add(b);
        fi.add(p);
        fi.setBounds(350, 25, 650, 400);
        fi.setVisible(true);
        fi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void highScore() throws Exception
    {
          JFrame j2=new JFrame("High Scores-Word Scramble");
          JPanel pan=new JPanel();
          pan.setLayout(new BoxLayout(pan,BoxLayout.Y_AXIS));
          JPanel pan1=new JPanel();
          pan1.setPreferredSize(new Dimension(0,0));
          pan1.add(new JLabel("WORD SCRAMBLE"));
          JPanel pan2=new JPanel();
          JButton back=new JButton("Go Back");
          back.setBackground(Color.GREEN);
          back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent s)
            {
              j2.dispose();
             }
          });
          ArrayList<Integer> al=new ArrayList<Integer>();
          FileInputStream fis=new FileInputStream("Scores.txt");
          ObjectInputStream ois=new ObjectInputStream(fis);
          al=(ArrayList<Integer>)ois.readObject();
          if(al.isEmpty())
          {
              al.add(153);
              FileOutputStream fos=new FileOutputStream("Scores.txt");
              oos.writeObject(al);
              oos.close();
              fos.close();
          }
          Collections.sort(al,Collections.reverseOrder());
          int f=1;
          for(int i : al)
          {
            JLabel jl=new JLabel("<html> "+f+". "+i+"<br> </html>");
            f++;
            pan2.add(jl);
          }
          pan2.add(back);
          ois.close();
          fis.close();
          pan.add(pan1);
          pan.add(pan2);
          j2.add(pan);
          j2.setBounds(350, 25, 650, 400);
          j2.setVisible(true);
          j2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void level1()
    {
        JFrame jf=new JFrame("Word Scramble");
        w2=w3=w4=w5=w6=w7=0;
        word2=1;word3=5;word4=2;word5=word6=word7=0;
        Checking ch=new Checking();
        JLabel sc=new JLabel();
        JLabel fcntw=new JLabel();
        JLabel scntw=new JLabel();
        JTextField tf=new JTextField(20);
        JPanel panel=new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        JLabel title=new JLabel();
        JLabel warn=new JLabel();
        JButton b1=new JButton("Guess the word");
        b1.setBackground(Color.GREEN);
        11
        JPanel jp1=new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));
        JPanel jp2=new JPanel();
        JPanel jp3=new JPanel();
        jp3.setBounds(0, 0,0 , 100);
        JPanel jp4=new JPanel();
        JPanel jp31=new JPanel();
        JPanel jp32=new JPanel();
        jp3.setPreferredSize(new Dimension(0,0));
        jp31.setBackground(new Color(244,185,66));
        jp32.setBackground(new Color(244,185,66));
        jp4.setBackground(new Color(244,185,66));
        jp4.add(tf);
        jp4.add(b1);
        JPanel jp5=new JPanel();
        JLabel level=new JLabel();
        jp5.add(warn);
        JPanel jp6=new JPanel();
        jp6.setBackground(new Color(244,185,66));
        title.setText("WORD SCRAMBLE");
        JLabel rword=new JLabel();
        
        jp1.setPreferredSize(new Dimension(0,0));
        jp2.setPreferredSize(new Dimension(0,30));
        jp1.setBackground(new Color(244,185,66));
        jp5.setBackground(new Color(244,185,66));
        jp2.setLayout(new BoxLayout(jp2,BoxLayout.X_AXIS));
        jp3.setLayout(new BoxLayout(jp3,BoxLayout.Y_AXIS));
        JPanel jp21=new JPanel();
        JPanel jp22=new JPanel();
        fcntw.setText("<html>To find:- 2 letter words:"+word2+" 3 letter words:"+word3+" 4 letter words:"+word4+"<br> 5 letter words:"+word5+" 6 letter
        words:"+word6+" 7 Letter words:"+word7+"<br>Don't put any spaces in textfield.</html>");
        
        jp21.setBackground(new Color(244,185,66));
        jp22.setBackground(new Color(244,185,66));
        jp2.add(jp21);
        jp2.add(jp22);
        jp31.add(fcntw);
        jp32.add(scntw);
        jp32.setBounds(0, 0, 0, 100);
        jp3.add(jp31);
        jp3.add(jp32);
        jp1.add(title);
        jp21.add(rword);
        jp22.add(level);
        jp4.add(b1);
        jp6.add(sc);
        panel.add(jp1);
        panel.add(jp2);
        panel.add(jp3);
        panel.add(jp4);
        panel.add(jp5);
        panel.add(jp6);
        jf.setBackground(new Color(244,185,66));
        jf.add(panel);
        jf.setBounds(350, 25, 650, 400);
        jf.setResizable(false);
        jf.setVisible(true);
        jf.setAlwaysOnTop(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rword.setHorizontalAlignment(SwingConstants.LEFT);
        rword.setFont(new
        
        Font(rword.getFont().getName(),rword.getFont().getStyle(),21));
        level.setFont(new
        Font(rword.getFont().getName(),rword.getFont().getStyle(),24));
        title.setFont(new
        Font(title.getFont().getName(),title.getFont().getStyle(),32));
        scntw.setFont(new
        Font(rword.getFont().getName(),rword.getFont().getStyle(),9));
        fcntw.setFont(new
        Font(rword.getFont().getName(),rword.getFont().getStyle(),9));
        level.setText("Level 1");
        rword.setText("<html>A W<br>R E</html>");
        b1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e)
        {
            String str= tf.getText();
            if(ch.ifpresent(str))
            {
                warn.setText("This is already guessed");
                sc.setText("Score : "+score);
                tf.setText("");
            }
            else
            {
                if(ch.check("AWRE", str))
            {
            warn.setText("Your guess is correct");
            cnt1++;
            score+=5;
            switch(str.length())
            {
                case 2:
                {
                w2++;
                break;
                }
                case 3:
                {
                w3++;
                break;
                }
                case 4:
                {
                w4++;
                break;
                }
                case 5:
                {
                w5++;
                break;
                }
                case 6:
                {
                w6++;
                break;
                }
                case 7:
                {
                w7++;
                break;
                }
         }
          tf.setText("");
          scntw.setText("<html>Found :- 2 letter
          words:"+w2+" 3 letter words: "+w3+" 4 letter words:"+w4+"<br>5 letter words:"+w5+"
          6 letter words:"+w6+" 7 Letter words:"+w7+"</html>");
          sc.setText("Score : "+score);
          ch.addIt(str);
          }
          else
          {
            tf.setText("");
            warn.setText("Sorry try again");
            score--;
            sc.setText("Score : "+score);
         }
        }
          if(cnt1==8)
          {
            jf.dispose();
            level2();
           }
        }
        });
    }

    public static void level2()
    {
          w2=w3=w4=w5=w6=w7=0;
          word2=0;word3=6;word4=4;word5=1;word6=word7=0;
          JFrame jf=new JFrame("Word Scramble");
          Checking ch=new Checking();
          JTextField tf=new JTextField(20);
          JPanel panel=new JPanel();
          panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
          JLabel warn=new JLabel();
          JButton b1=new JButton("Guess the word");
          JPanel jp1=new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));
          JPanel jp2=new JPanel();
          JPanel jp3=new JPanel();
          JPanel jp4=new JPanel();
          b1.setBackground(Color.GREEN);
          JLabel fcntw=new JLabel();
          JLabel scntw=new JLabel();
          fcntw.setText("<html>To find:- 2 letter words:"+word2+" 3 letter words:"+word3+" 4 letter words:"+word4+"<br> 5 letter words:"+word5+" 6 letter
          words:"+word6+" 7 Letter words:"+word7+"<br>Don't put any spaces in textfield.</html>");
          jp4.setBackground(new Color(244,185,66));
          jp4.add(tf);
          jp4.add(b1);
          JPanel jp5=new JPanel();
          JLabel level=new JLabel();
          jp5.add(warn);
          JLabel sc=new JLabel();
          JLabel rword=new JLabel();
          
          jp1.setPreferredSize(new Dimension(0,0));
          jp2.setPreferredSize(new Dimension(0,30));
          jp3.setPreferredSize(new Dimension(0,0));
          jp1.setBackground(new Color(244,185,66));
          jp5.setBackground(new Color(244,185,66));
          jp2.setLayout(new BoxLayout(jp2,BoxLayout.X_AXIS));
          jp3.setLayout(new BoxLayout(jp3,BoxLayout.Y_AXIS));
          
          JPanel jp21=new JPanel();
          JPanel jp22=new JPanel();
          JPanel jp31=new JPanel();
          JPanel jp32=new JPanel();
          jp21.setBackground(new Color(244,185,66));
          jp22.setBackground(new Color(244,185,66));
          jp31.setBackground(new Color(244,185,66));
          jp32.setBackground(new Color(244,185,66));
          jp31.add(fcntw);
          jp32.add(scntw);
          jp2.add(jp21);
          jp2.add(jp22);
          jp3.add(jp31);
          jp3.add(jp32);
          jp1.add(title);
          jp21.add(rword);
          jp22.add(level);
          jp4.add(b1);
          jp5.add(sc);
          
          panel.add(jp1);
          panel.add(jp2);
          panel.add(jp3);
          panel.add(jp4);
          panel.add(jp5);
          scntw.setFont(new
          Font(rword.getFont().getName(),rword.getFont().getStyle(),9));
          fcntw.setFont(new
          Font(rword.getFont().getName(),rword.getFont().getStyle(),9));
          jf.setBackground(new Color(244,185,66));
          jf.add(panel);
          jf.setBounds(350, 25, 650, 400);
          jf.setResizable(false);
          jf.setVisible(true);
          jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          rword.setHorizontalAlignment(SwingConstants.LEFT);
          rword.setFont(new
          Font(rword.getFont().getName(),rword.getFont().getStyle(),24));
          level.setFont(new
          Font(rword.getFont().getName(),rword.getFont().getStyle(),24));
          title.setFont(new
          Font(title.getFont().getName(),title.getFont().getStyle(),32));
          level.setText("Level 2");
          rword.setText("<html>T M A<br> S R</html>");
          b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
              String str= tf.getText();
              if(ch.ifpresent(str))
              {
                tf.setText("");
                warn.setText("This is already guessed");
                sc.setText("Score : "+score);
              }
              else
              {
                 if(ch.check("TMASR", str))
                 {
                    warn.setText("Your guess is correct");
                    ch.addIt(str);
                    score+=5;
                    switch(str.length())
                    {
                      case 2:
                      {
                          w2++;
                          break;
                      }
                      case 3:
                      {
                          w3++;
                          break;
                      }
                      case 4:
                      {
                          w4++;
                          break;
                      }
                      case 5:
                      {
                          w5++;
                          break;
                      }
                      case 6:
                      {
                          w6++;
                          break;
                      }
                      case 7:
                      {
                          w7++;
                          break;
                      }
                 }
            scntw.setText("<html>Found :- 2 letter
            words:"+w2+" 3 letter words: "+w3+" 4 letter words:"+w4+"<br> 5 letter
            words:"+w5+" 6 letter words:"+w6+" 7 Letter words:"+w7+"</html>");
            sc.setText("Score : "+score);
            tf.setText("");
            cnt2++;
            }
            else
            {
              warn.setText("Sorry try again");
              score--;
              tf.setText("");
              sc.setText("Score : "+score);
            }
            }
            if(cnt2==10)
            {
                jf.dispose();
                try {
                level3();
                } catch (Exception e1) {
                e1.printStackTrace();
                }
                }
            }
          });
        }
        
      public static void level3()
      {
            w2=w3=w4=w5=w6=w7=0;
            word2=1;word3=3;word4=1;word5=1;word6=word7=0;
            JFrame jf=new JFrame("Word Scramble");
            Checking ch=new Checking();
            20
            JTextField tf=new JTextField(20);
            JPanel panel=new JPanel();
            panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
            JLabel warn=new JLabel();
            JButton b1=new JButton("Guess the word");
            JPanel jp1=new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));
            JPanel jp2=new JPanel();
            JPanel jp3=new JPanel();
            JPanel jp4=new JPanel();
            JLabel fcntw=new JLabel();
            JLabel scntw=new JLabel();
            b1.setBackground(Color.GREEN);
            fcntw.setText("<html>To find:- 2 letter words:"+word2+" 3 letter words:"+word3+" 4 letter words:"+word4+"<br> 5 letter words:"+word5+" 6 letter
            words:"+word6+" 7 Letter words:"+word7+"<br>Don't put any spaces in the textfield</html>");
            jp4.setBackground(new Color(244,185,66));
            jp4.add(tf);
            jp4.add(b1);
            JPanel jp5=new JPanel();
            JLabel level=new JLabel();
            jp5.add(warn);
            JLabel sc=new JLabel();
            JLabel rword=new JLabel();
            jp1.setPreferredSize(new Dimension(0,0));
            jp2.setPreferredSize(new Dimension(0,30));
            jp3.setPreferredSize(new Dimension(0,0));
            jp1.setBackground(new Color(244,185,66));
            jp5.setBackground(new Color(244,185,66));
            jp2.setLayout(new BoxLayout(jp2,BoxLayout.X_AXIS));
            jp3.setLayout(new BoxLayout(jp3,BoxLayout.Y_AXIS));
            JPanel jp21=new JPanel();
            JPanel jp22=new JPanel();
            JPanel jp31=new JPanel();
            JPanel jp32=new JPanel();
            jp21.setBackground(new Color(244,185,66));
            jp22.setBackground(new Color(244,185,66));
            jp31.setBackground(new Color(244,185,66));
            jp32.setBackground(new Color(244,185,66));
            jp31.add(fcntw);
            jp32.add(scntw);
            jp2.add(jp21);
            jp2.add(jp22);
            jp3.add(jp31);
            jp3.add(jp32);
            jp1.add(title);
            jp21.add(rword);
            jp22.add(level);
            jp4.add(b1);
            jp5.add(sc);
            
            panel.add(jp1);
            panel.add(jp2);
            panel.add(jp3);
            panel.add(jp4);
            panel.add(jp5);
            
            scntw.setFont(new
            Font(rword.getFont().getName(),rword.getFont().getStyle(),9));
            fcntw.setFont(new
            Font(rword.getFont().getName(),rword.getFont().getStyle(),9));
            jf.setBackground(new Color(244,185,66));
            jf.add(panel);
            jf.setBounds(350, 25, 650, 400);
            jf.setResizable(false);
            jf.setVisible(true);
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            rword.setHorizontalAlignment(SwingConstants.LEFT);
            rword.setFont(new
            Font(rword.getFont().getName(),rword.getFont().getStyle(),24));
            level.setFont(new
            Font(rword.getFont().getName(),rword.getFont().getStyle(),24));
            title.setFont(new
            Font(title.getFont().getName(),title.getFont().getStyle(),32));
            level.setText("Level 3");
            rword.setText("<html>K I F<br>N E</html>");
            b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
              String str= tf.getText();
              if(ch.ifpresent(str))
              {
                warn.setText("This is already guessed");
                sc.setText("Score : "+score);
                tf.setText("");
              }
              else
              {
                if(ch.check("KIFNE", str))
                {
                warn.setText("Your guess is correct");
                ch.addIt(str);
                score+=5;
                switch(str.length())
                {
                  case 2:
                  {
                      w2++;
                      break;
                  }
                  case 3:
                  {
                      w3++;
                      break;
                  }
                  case 4:
                  {
                      w4++;
                      break;
                  }
                  case 5:
                  {
                      w5++;
                      break;
                  }
                  case 6:
                  {
                      w6++;
                      break;
                  }
                  case 7:
                  {
                      w7++;
                      break;
                  }
                }
            tf.setText("");
            scntw.setText("<html>Found :- 2 letter
            words:"+w2+" 3 letter words: "+w3+" 4 letter words:"+w4+"<br> 5 letter
            words:"+w5+" 6 letter words:"+w6+" 7 Letter words:"+w7+"</html>");
            sc.setText("Score : "+score);
            cnt3++;
            }
            else
            {
                warn.setText("Sorry try again");
                score--;
                tf.setText("");
                sc.setText("Score : "+score);
            }
            }
            if(cnt3==6)
            {
                jf.dispose();
                try {
                level4();
                } catch (Exception e1) {
                e1.printStackTrace();
                 }
                }
            }
           });
      }
      
      public static void level4()
      {
            w2=w3=w4=w5=w6=w7=0;
            word2=0;word3=0;word4=5;word5=0;word6=1;word7=1;
            JFrame jf=new JFrame("Word Scramble");
            Checking ch=new Checking();
            JTextField tf=new JTextField(20);
            JPanel panel=new JPanel();
            panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
            JLabel warn=new JLabel();
            JButton b1=new JButton("Guess the word");
            JPanel jp1=new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));
            JPanel jp2=new JPanel();
            JPanel jp3=new JPanel();
            JPanel jp4=new JPanel();
            JLabel fcntw=new JLabel();
            JLabel scntw=new JLabel();
            b1.setBackground(Color.GREEN);
            fcntw.setText("<html>To find:- 2 letter words:"+word2+" 3 letter words:"+word3+" 4 letter words:"+word4+"<br> 5 letter words:"+word5+" 6 letter
            words:"+word6+" 7 Letter words:"+word7+"<br>Don't put any spaces in the textfield</html>");
            jp4.setBackground(new Color(244,185,66));
            jp4.add(tf);
            jp4.add(b1);
            JPanel jp5=new JPanel();
            JLabel level=new JLabel();
            jp5.add(warn);
            JLabel sc=new JLabel();
            JLabel rword=new JLabel();
            jp1.setPreferredSize(new Dimension(0,0));
            jp2.setPreferredSize(new Dimension(0,30));
            jp3.setPreferredSize(new Dimension(0,0));
            jp1.setBackground(new Color(244,185,66));
            jp5.setBackground(new Color(244,185,66));
            jp2.setLayout(new BoxLayout(jp2,BoxLayout.X_AXIS));
            jp3.setLayout(new BoxLayout(jp3,BoxLayout.Y_AXIS));
            JPanel jp21=new JPanel();
            JPanel jp22=new JPanel();
            JPanel jp31=new JPanel();
            JPanel jp32=new JPanel();
            jp21.setBackground(new Color(244,185,66));
            jp22.setBackground(new Color(244,185,66));
            jp31.setBackground(new Color(244,185,66));
            jp32.setBackground(new Color(244,185,66));
            jp31.add(fcntw);
            jp32.add(scntw);
            jp2.add(jp21);
            jp2.add(jp22);
            jp3.add(jp31);
            jp3.add(jp32);
            jp1.add(title);
            jp21.add(rword);
            jp22.add(level);
            jp4.add(b1);
            jp5.add(sc);
            panel.add(jp1);
            panel.add(jp2);
            panel.add(jp3);
            panel.add(jp4);
            panel.add(jp5);
            scntw.setFont(new
            Font(rword.getFont().getName(),rword.getFont().getStyle(),9));
            fcntw.setFont(new
            Font(rword.getFont().getName(),rword.getFont().getStyle(),9));
            jf.setBackground(new Color(244,185,66));
            jf.add(panel);
            jf.setBounds(350, 25, 650, 400);
            jf.setResizable(false);
            jf.setVisible(true);
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            rword.setHorizontalAlignment(SwingConstants.LEFT);
            rword.setFont(new
            Font(rword.getFont().getName(),rword.getFont().getStyle(),24));
            level.setFont(new
            Font(rword.getFont().getName(),rword.getFont().getStyle(),24));
            title.setFont(new
            Font(title.getFont().getName(),title.getFont().getStyle(),32));
            level.setText("Level 4");
            rword.setText("<html>T R E C<br>J O P</html>");
            b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                String str= tf.getText();
                if(ch.ifpresent(str))
                {
                    tf.setText("");
                    warn.setText("This is already guessed");
                    sc.setText("Score : "+score);
                }
                else
                {
                  if(ch.check("TRECJOP", str))
                  {
                  warn.setText("Your guess is correct");
                  ch.addIt(str);
                  score+=5;
                  switch(str.length())
                  {
                    case 2:
                    {
                        w2++;
                        break;
                    }
                    case 3:
                    {
                        w3++;
                        break;
                    }
                    case 4:
                    {
                        w4++;
                        break;
                    }
                    case 5:
                    {
                        w5++;
                        break;
                    }
                    case 6:
                    {
                        w6++;
                        break;
                    }
                    case 7:
                    {
                        w7++;
                        break;
                    }
                }
                tf.setText("");
                scntw.setText("<html>Found :- 2 letter
                words:"+w2+" 3 letter words: "+w3+" 4 letter words:"+w4+"<br> 5 letter
                words:"+w5+" 6 letter words:"+w6+" 7 Letter words:"+w7+"</html>");
                sc.setText("Score : "+score);
                cnt4++;
                }
                else
                {
                    warn.setText("Sorry try again");
                    score--;
                    sc.setText("Score : "+score);
                }
                }
                if(cnt4==7)
                {
                    jf.dispose();
                    try {
                    level5();
                    } catch (Exception e1) {
                    e1.printStackTrace();
                    }
                    }
                }
            });
      }

    public static void level4()
    {
        w2=w3=w4=w5=w6=w7=0;
        word2=0;word3=0;word4=5;word5=0;word6=1;word7=1;
        JFrame jf=new JFrame("Word Scramble");
        Checking ch=new Checking();
        JTextField tf=new JTextField(20);
        JPanel panel=new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        JLabel warn=new JLabel();
        JButton b1=new JButton("Guess the word");
        JPanel jp1=new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));
        JPanel jp2=new JPanel();
        JPanel jp3=new JPanel();
        JPanel jp4=new JPanel();
        JLabel fcntw=new JLabel();
        JLabel scntw=new JLabel();
        b1.setBackground(Color.GREEN);
        fcntw.setText("<html>To find:- 2 letter words:"+word2+" 3 letter words:"+word3+" 4 letter words:"+word4+"<br> 5 letter words:"+word5+" 6 letter
        words:"+word6+" 7 Letter words:"+word7+"<br>Don't put any spaces in the textfield</html>");
        jp4.setBackground(new Color(244,185,66));
        jp4.add(tf);
        jp4.add(b1);
        JPanel jp5=new JPanel();
        JLabel level=new JLabel();
        jp5.add(warn);
        JLabel sc=new JLabel();
        JLabel rword=new JLabel();
        jp1.setPreferredSize(new Dimension(0,0));
        jp2.setPreferredSize(new Dimension(0,30));
        jp3.setPreferredSize(new Dimension(0,0));
        jp1.setBackground(new Color(244,185,66));
        jp5.setBackground(new Color(244,185,66));
        jp2.setLayout(new BoxLayout(jp2,BoxLayout.X_AXIS));
        jp3.setLayout(new BoxLayout(jp3,BoxLayout.Y_AXIS));
        JPanel jp21=new JPanel();
        JPanel jp22=new JPanel();
        JPanel jp31=new JPanel();
        JPanel jp32=new JPanel();
        jp21.setBackground(new Color(244,185,66));
        jp22.setBackground(new Color(244,185,66));
        jp31.setBackground(new Color(244,185,66));
        jp32.setBackground(new Color(244,185,66));
        jp31.add(fcntw);
        jp32.add(scntw);
        jp2.add(jp21);
        jp2.add(jp22);
        jp3.add(jp31);
        jp3.add(jp32);
        jp1.add(title);
        jp21.add(rword);
        jp22.add(level);
        jp4.add(b1);
        jp5.add(sc);
        panel.add(jp1);
        panel.add(jp2);
        panel.add(jp3);
        panel.add(jp4);
        panel.add(jp5);
        scntw.setFont(new
        Font(rword.getFont().getName(),rword.getFont().getStyle(),9));
        fcntw.setFont(new
        Font(rword.getFont().getName(),rword.getFont().getStyle(),9));
        jf.setBackground(new Color(244,185,66));
        jf.add(panel);
        jf.setBounds(350, 25, 650, 400);
        jf.setResizable(false);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rword.setHorizontalAlignment(SwingConstants.LEFT);
        rword.setFont(new
        Font(rword.getFont().getName(),rword.getFont().getStyle(),24));
        level.setFont(new
        Font(rword.getFont().getName(),rword.getFont().getStyle(),24));
        title.setFont(new
        Font(title.getFont().getName(),title.getFont().getStyle(),32));
        level.setText("Level 4");
        rword.setText("<html>T R E C<br>J O P</html>");
        b1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e)
        {
            String str= tf.getText();
            if(ch.ifpresent(str))
            {
              tf.setText("");
              warn.setText("This is already guessed");
              sc.setText("Score : "+score);
            }
            else
            {
                if(ch.check("TRECJOP", str))
                {
                warn.setText("Your guess is correct");
                ch.addIt(str);
                score+=5;
                switch(str.length())
                {
                case 2:
                {
                    w2++;
                    break;
                }
                case 3:
                {
                    w3++;
                    break;
                }
                case 4:
                {
                    w4++;
                    break;
                }
                case 5:
                {
                    w5++;
                    break;
                }
                case 6:
                {
                    w6++;
                    break;
                }
                case 7:
                {
                    w7++;
                    break;
                }
            }
            tf.setText("");
            scntw.setText("<html>Found :- 2 letter
            words:"+w2+" 3 letter words: "+w3+" 4 letter words:"+w4+"<br> 5 letter
            words:"+w5+" 6 letter words:"+w6+" 7 Letter words:"+w7+"</html>");
            sc.setText("Score : "+score);
            cnt4++;
            }
            else
            {
                warn.setText("Sorry try again");
                score--;
                sc.setText("Score : "+score);
                }
                }
                if(cnt4==7)
                {
                  jf.dispose();
                  try {
                    level5();
                    } catch (Exception e1) {
                    e1.printStackTrace();
                    }
                  }
            }
        });
    }
    
    public class Checking
    {
        ArrayList<String> als =new ArrayList<String>();
        
        boolean ifpresent(String s1)
        {
          if(als.contains(s1))
          return true;
          else
          return false;
        }
        
        void addIt(String sf)
        {
          als.add(sf);
        }
        boolean check(String s,String g)
        {
          if(s.equalsIgnoreCase("AWRE"))
          {
            if(g.equalsIgnoreCase("wear"))
            {
              return true;
            }
            else if(g.equalsIgnoreCase("are"))
            {
              return true;
            }
            else if(g.equalsIgnoreCase("raw"))
            {
              return true;
            }
            else if(g.equalsIgnoreCase("we"))
            {
              return true;
            }
            else if(g.equalsIgnoreCase("ware"))
            {
              return true;
            }
            else if(g.equalsIgnoreCase("ear"))
            {
              return true;
            }
            else if(g.equalsIgnoreCase("war"))
            {
              return true;
            }
            else if(g.equalsIgnoreCase("awe"))
            {
              return true;
            }
            else
              return false;
            }
            if(s.equalsIgnoreCase("TMASR"))
            {
            if(g.equalsIgnoreCase("art"))
            {
              return true;
            }
            else if(g.equalsIgnoreCase("arm"))
            {
              return true;
            }
            else if(g.equalsIgnoreCase("mars"))
            {
              return true;
            }
            else if(g.equalsIgnoreCase("rat"))
            {
              return true;
            }
            else if(g.equalsIgnoreCase("sat"))
            {
              return true;
            }
            else if(g.equalsIgnoreCase("mart"))
            {
              return true;
            }
            else if(g.equalsIgnoreCase("tar"))
            {
              return true;
            }
            else if(g.equalsIgnoreCase("star"))
            {
              return true;
            }
            else if(g.equalsIgnoreCase("mat"))
            {
              return true;
            }
            else if(g.equalsIgnoreCase("tram"))
            {
              return true;
            }
            else if(g.equalsIgnoreCase("smart"))
            {
              return true;
            }
            else
              return false;
            }
            if(s.equalsIgnoreCase("KIFNE"))
            {
              if(g.equalsIgnoreCase("fin"))
              {
                return true;
              }
              else if(g.equalsIgnoreCase("knife"))
              {
                return true;
              }
              else if(g.equalsIgnoreCase("kin"))
              {
                return true;
              }
              else if(g.equalsIgnoreCase("ink"))
              {
                return true;
              }
              else if(g.equalsIgnoreCase("fine"))
              {
                return true;
              }
              else if(g.equalsIgnoreCase("if"))
              {
                return true;
              }
              else
                 return false;
            }
            if(s.equalsIgnoreCase("TRECJOP"))
            {
              if(g.equalsIgnoreCase("project"))
              {
                  return true;
              }
              else if(g.equalsIgnoreCase("copter"))
              {
                  return true;
              }
              else if(g.equalsIgnoreCase("cope"))
              {
                  return true;
              }
              else if(g.equalsIgnoreCase("poet"))
              {
                  return true;
              }
              else if(g.equalsIgnoreCase("port"))
              {
                  return true;
              }
              else if(g.equalsIgnoreCase("rope"))
              {
                 return true;
              }
              else if(g.equalsIgnoreCase("pore"))
              {
                return true;
              }
              else
                return false;
            }
            if(s.equalsIgnoreCase("LEMROBP"))
            {
              if(g.equalsIgnoreCase("problem"))
              {
                return true;
              }
              else if(g.equalsIgnoreCase("probe"))
              {
                return true;
              }
              else if(g.equalsIgnoreCase("moper"))
              {
                return true;
              }
              else if(g.equalsIgnoreCase("bore"))
              {
                return true;
              }
              else if(g.equalsIgnoreCase("more"))
              {
                return true;
              }
              else if(g.equalsIgnoreCase("pore"))
              {
                return true;
              }
              else if(g.equalsIgnoreCase("prom"))
              {
                return true;
              }
              else if(g.equalsIgnoreCase("rope"))
              {
                return true;
              }
              else if(g.equalsIgnoreCase("role"))
              {
                 return true;
              }
              else if(g.equalsIgnoreCase("mob"))
              {
                return true;
              }
              else if(g.equalsIgnoreCase("ore"))
              {
                return true;
              }
              else if(g.equalsIgnoreCase("rob"))
              {
                return true;
              }
              else if(g.equalsIgnoreCase("pro"))
              {
                return true;
              }
              else if(g.equalsIgnoreCase("per"))
              {
                return true;
              }
              else
                return false;
              }
            else return false;
      }
    }
    
    
