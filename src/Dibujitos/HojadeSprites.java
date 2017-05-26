/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dibujitos;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Grimma
 */
public class HojadeSprites {
    private int alto;
    private int lado;
    public int[] Pixeles;
    
    public HojadeSprites(final String ruta, int lado, int alto) throws IOException{
        this.alto = alto;
        this.lado = lado;
        Pixeles = new int[alto*lado];
        BufferedImage image = ImageIO.read(HojadeSprites.class.getResource(ruta));
        image.getRGB(0, 0, lado, alto, Pixeles, 0, lado);
    }

    public int getLado() {
        return lado;
    }    
}
