/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Grimma
 */
public class ElTecla implements KeyListener{
    private final static int NumerodeTeclas = 120;
    private final boolean[] Teclas =  new boolean[NumerodeTeclas];
    
    public boolean arriba;
    public boolean abajo;
    public boolean izquierda;
    public boolean derecha;
    public boolean Saltar;
    public boolean Pegar;
    
    public void actualizar(){
        arriba = Teclas[KeyEvent.VK_UP];
        abajo = Teclas[KeyEvent.VK_DOWN];
        izquierda = Teclas[KeyEvent.VK_LEFT];
        derecha = Teclas[KeyEvent.VK_RIGHT];
        Saltar = Teclas[KeyEvent.VK_X];
        Pegar = Teclas[KeyEvent.VK_C];
        
    }
            

    @Override
    public void keyTyped(KeyEvent e) {
        Teclas[e.getKeyCode()] = true;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Teclas[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        Teclas[e.getKeyCode()] = false;
    }
    
}
