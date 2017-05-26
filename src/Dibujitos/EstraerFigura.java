/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dibujitos;

/**
 *
 * @author Grimma
 */
public class EstraerFigura {
    private final HojadeSprites Hoja;
    private final int lado;
    private final int x;
    private final int y;
    public int[] TotalPixeles;

    public EstraerFigura(int lado, int x, int y, HojadeSprites Hoja) {
        this.lado = lado;
        this.x = x;
        this.y = y;
        this.TotalPixeles = new int[this.lado*this.lado];
        this.Hoja = Hoja;
        
        for(int b = 0; b<lado; b++){
            for(int a = 0;a<lado; a++){
                TotalPixeles[(a+b)*lado] = Hoja.Pixeles[((a+this.x)+(b+this.y))*Hoja.getLado()];
            }
        }
    }
    
}
