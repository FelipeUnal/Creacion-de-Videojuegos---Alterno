package juegos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import javax.swing.*;


public class Juegos extends JFrame{
    
    public Juegos(){
        add(new Panel());
    }
    
    public static void main(String[] args) {
        Juegos frame = new Juegos();
        
        frame.setTitle("TestPaintComponent");
        frame.setSize(1000, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class Panel extends JPanel implements ActionListener,MouseListener{
    
    private int x;
    private int y;
    private int secuencia;
    private Timer Timer;
    private Color color;
    private URL url = null;
    
    
    
    public Panel(){
        this.color = Color.CYAN;
        Timer = new Timer(25, this);
        this.addMouseListener(this);
        Timer.start();
    }
    
    public Image loadImage(String ImageName){
        ImageIcon icon = new ImageIcon(ImageName);
        Image image = icon.getImage();
        return image;
    }
    
   @Override
    protected void paintComponent(Graphics g){
        
        super.paintComponent(g);
        
        Image fondo = loadImage("fondo.png");
        //Image Animacion = loadImage("monkey-guybrush.png");
        
        g.drawImage(fondo, 0, 0, null);
        
        //g.drawImage(Animacion, x*104, y, x, y, x, y, x, y, this);
        
        g.setColor(Color.cyan);
        g.fillRect(x, 350, 70, 50);
        g.setColor(Color.black);
        g.drawRect(x, 350, 70, 50);
        g.setColor(Color.cyan);
        g.fillRect(x+50, 360, 50, 10);
        g.fillOval(x+10, 400, 12, 12);
        g.fillOval(x+40, 400, 12, 12);
        g.setColor(Color.black);
        g.drawRect(x+50, 360, 50, 10);
        g.drawOval(x+10, 400, 12, 12);
        g.drawOval(x+40, 400, 12, 12);
        g.drawRect(x-5, 345, 110, 70);
        
        int move = 400;
        g.setColor(Color.cyan);
        g.fillRect(x+move, 350, 70, 50);
        g.setColor(Color.black);
        g.drawRect(x+move, 350, 70, 50);
        g.setColor(Color.cyan);
        g.fillRect(x+50+move, 360, 50, 10);
        g.fillOval(x+10+move, 400, 12, 12);
        g.fillOval(x+40+move, 400, 12, 12);
        g.setColor(Color.black);
        g.drawRect(x+50+move, 360, 50, 10);
        g.drawOval(x+10+move, 400, 12, 12);
        g.drawOval(x+40+move, 400, 12, 12);
        g.drawRect(x-5+move, 345, 110, 70);
        
        g.drawRect(260, y, 20, 40);
        g.drawRect(300, y, 20, 40);
        g.drawOval(600, y, 30, 30);
        g.fillRect(705, 395, 22, 22);
        
    }
    
    @Override
    public Rectangle getBounds(){
        return new Rectangle(x-5+400, 345, 110, 70);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        x += 1;
        y += 1;
        
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point mp = e.getPoint();
        if(getBounds().contains(mp)){
            this.Timer.stop();
        }
        
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    

}
