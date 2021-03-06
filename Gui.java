import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.*;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

class Gui{
  private JFrame frame; // Everything contained here
  private Painter p;
  private JPanel top;
  private JPanel bottom;
  public static Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
  public static final int SCALE = screenDimension.height; // This for me is 2610
  public JLabel speed;

  // Constructor
  public Gui(){
    p = new Painter();
    bottom = new JPanel();
    frame = makeBasicInterface();
    frame.setVisible(true);
  }

  // Makes the basic interface
  public JFrame makeBasicInterface(){
    JFrame frame = new JFrame();
    //*********************RESCALING******************************
    GuiFix fixer = new GuiFix();
    fixer.fix(frame);
    //************************************************************
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new GridLayout(2,1));

    speed = new JLabel("Speed: 0 mph");
    bottom.add(speed);

    frame.add(p);
    frame.add(bottom);
    return frame;
  }

  public void setPosition(int x, int y){
    Painter.x = x;
    Painter.y = y;
    p.repaint();
  }

  public void setX(int x){
    Painter.x = x;
    p.repaint();

  }

  public void setY(int y){
    Painter.y = y;
    p.repaint();
  }

  public void right(int x){
    if(Painter.x > screenDimension.width*130/300){
      speed.setText("You win! Time = " + Controller.INDEX);
      Controller.STOP = true;
    }else{
      Painter.x += x;
      p.repaint();
    }
  }

  public void down(int y){
    Painter.y += y;
    p.repaint();
  }

  public void setSpeedText(int x){
    speed.setText("Speed: " + x + " mph");
  }
}

class Painter extends JPanel{
  public static int x = 0;
  public static int y = 0;

  @Override
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    try{
      File f = new File("car.ico");
      BufferedImage img = ImageIO.read(f);
      g2.drawImage(img,x,y,null); // x,y,width,height
    }catch(IOException e){

    }

    g2.setFont(new Font("Calibri", Font.PLAIN, 30));
    //g2.drawString("Test",100,100);

    //g2.fillRect(x,y,Gui.SCALE/18,Gui.SCALE/36); // x,y,width,height


    }
  }
