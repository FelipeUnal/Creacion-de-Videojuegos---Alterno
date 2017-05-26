package juegos;

import Controles.ElTecla;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import javax.swing.*;


public class Juegos extends JFrame{
    private boolean a;
    
    public static void main(String[] args) {
        ElTecla ElTecla = new ElTecla();
        Juegos frame = new Juegos();
        frame.addKeyListener(ElTecla);
        frame.setTitle("Ninjump!");
        frame.setSize(720, 480);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        frame.add(new Panel(),BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }
    
    public void actualizar(){
    }
    public void mostrar(){
        
    }
}
   

class Panel extends JPanel implements ActionListener, KeyListener{
    
    private int x;
    private int y;
    private int secuencia;
    private Timer Timer;
    private URL url = null;
    
    
    
    public Panel(){
        Timer = new Timer(30,this);
        Timer.start();
    }
    
   @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawOval(y+15, x+15, 20, 30);
        
        
    }
    
    @Override
    public Rectangle getBounds(){
        return new Rectangle(x-5+400, 345, 110, 70);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

}
