package juegos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class Juegos extends JFrame {

    public Juegos() {
        add(new NewPanel());
    }

    public static void main(String[] args) {
        Juegos a = new Juegos();
        a.setTitle("Ninjump!");
        a.setSize(720, 480);
        a.setLocationRelativeTo(null);
        a.setResizable(false);
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a.setVisible(true);
    }
}

class NewPanel extends JPanel implements ActionListener, MouseListener {

    private final Timer time;
    private boolean up, down, left, rigth, giroleft, girorigth; 
    public int x = 0, y = 0, z = 0, p = 0, count, score = 0;
    private int secuencia = 0,secuencia2=0, plataforma = 0;
    private ElTecla Tecla = new ElTecla();
  

    public NewPanel() {
        addKeyListener(Tecla);
        this.addMouseListener(this);
        setFocusable(true);
        this.time = new Timer(25, this);
        this.time.start();

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image Fondo = loadImage("panorama.png");
        for (int i = 0 + y; i > -500 - z; i -= 480) {
            g.drawImage(Fondo, 0, i, null);
        }
        Image StandR = loadImage("Stand2.png");
        Image StandL = loadImage("Stand1.png");
        Image Salto1 = loadImage("Saltar1.png");
        Image Salto2 = loadImage("Saltar2.png");
        Image Plataforma = loadImage("plataforma.png");
        g.drawImage(Plataforma, 0 + x + 366, 0 + 410, 45 + x + 366+ 45, 45 + 410, plataforma*45, 0, plataforma*45+45, 45, this);
        g.drawImage(Plataforma, 0 + x + 600, 0 + 330, 45 + x + 600+ 45, 45 + 330, plataforma*45, 0, plataforma*45+45, 45, this);
        g.drawImage(Plataforma, 0 + x + 480, 0 + 250, 45 + x + 480+ 45, 45 + 250, plataforma*45, 0, plataforma*45+45, 45, this);
        g.drawImage(Plataforma, 0 + x + 220, 0 + 130, 45 + x + 220+ 45, 45 + 130, plataforma*45, 0, plataforma*45+45, 45, this);
        
        if(left==true){
            g.drawImage(derecha(), 0 + z + 360, 0 + y + 370 + p, 63 + z + 360, 63 + y + 370 + p, secuencia*63, 0, secuencia*63+63, 63, this);
        }
        //Color BLACK = Color.BLACK;
        //g.drawRect(368, 430, 38, 5);
        //g.drawRect( 0 + z + 378, 0 + y + 370 + p, 24, 60);

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(0 + z + 378, 0 + y + 429 + p, 24, 2);
    }
    
    
    public void resetSalto(){
        Rectangle Grimmjow = getBounds();
        Rectangle Reset0 = new Rectangle( x + 368,  432, 38 + x + 45, 5);
        Rectangle Reset1 = new Rectangle( x + 602,  352, 38 + x + 45, 5);
        Rectangle Reset2 = new Rectangle( x + 482,  272, 38 + x + 45, 5);
        Rectangle Reset3 = new Rectangle( x + 222,  152, 38 + x + 45, 5);
        Rectangle Reset4 = new Rectangle( x + 368,  432, 38 + x + 45, 5);
        
        
        if ((Grimmjow.intersects(Reset0))||(Grimmjow.intersects(Reset1))||(Grimmjow.intersects(Reset2))||(Grimmjow.intersects(Reset3))) {
            y -= 3;
            count = 0;
            System.out.println(score);
        } else {
            score += 1;
        }   
        
    }
        public Image derecha(){
            Image a = loadImage("Caminar2.png");
        return a;
            
        }
   /* public void Gameover() {
        Rectangle Ninja = getBounds();
        Rectangle perder = new Rectangle(0, 440, 640, 10);

        /*for(int i =90;i<1000;i+=100){
                for(int j = 20+y;j>-500-z;j-=250)
                    
                    if((i%7==0)){
                        Rectangle reto = new Rectangle(i, j+y+27, 100, 20);
                    
            
         
        if ((Ninja.intersects(perder))) {

            System.out.println("GAME OVER");

            time.stop();

        }
    } */

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.plataforma == 7) {
            this.plataforma = 0;
        } else {
            this.plataforma++;
        }
        if (this.secuencia == 2) {
            this.secuencia = 0;
        } else {
            this.secuencia++;
        }
        if(this.secuencia2==5){
            this.secuencia2=0;
        } else {
            this.secuencia2++;
        }
        
        //z += 5;*/
        y += 3;
        repaint();
        resetSalto();
        //Gameover();

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point mp = e.getPoint();
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

    public Image loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }

    class ElTecla implements KeyListener {

        public ElTecla() {
        }

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            if ((key == KeyEvent.VK_UP && count < 1)) { 
                p -= 250;
                count = 1;
                up = true;
            } else{
                up= false;
            }
            if ((key == KeyEvent.VK_LEFT || z>300)){
                z -= 20; 
                left = true;
            }
            if ((key == KeyEvent.VK_DOWN )){
                p += 1; 
                down = true;
            }
            if (key == KeyEvent.VK_RIGHT || z<-380){
                z += 20; 
                rigth = true;
            }
            
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            if ((key == KeyEvent.VK_LEFT || z>300)){
                giroleft = true;
            }
            if (key == KeyEvent.VK_RIGHT || z<-380){ 
                girorigth = true;
            }
        }

    }

}
