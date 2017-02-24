/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prooofconcept2d;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 *
 * @author servkey
 */
public class CanvasDib extends Canvas{
    
    private int x = 10;
    private int y = 10;
    private int mariox = 10;
    private int marioy = 285;
    private int bool=1;
    private BufferedImage sample;
    private BufferedImage mario;
    private String imagenmario="./images/mario.png";
    
    
    public CanvasDib(String ruta){
        
        sample=cargarImagen(ruta);
    }
    public CanvasDib(){
        sample=null;
    }
    
    private BufferedImage cargarImagen(String file){
        BufferedImage img = null;
        try{
            URL image = getClass().getResource(file);
            img = ImageIO.read(image);
        }catch(Exception e){
        }
         return img;
    }
    
    @Override
    public void paint(Graphics g)
    {       
         g.setColor(Color.YELLOW);     //Activa el color azul
         g.fillOval(getX(), getY(), 60, 60); //Dibuja un óvalo
       //  if (sample == null) sample = cargarImagen("./images/sample.png");
           //if (sample == null) {
               sample = cargarImagen("./images/fondo2.png");
               mario = cargarImagen(imagenmario);
          // }
           
         //g.drawImage(sample, x, 110, this);
           g.drawImage(sample, x-20, 160, this);
           g.drawImage(mario, mariox, marioy, this);

    }   

    @Override
    public void update(Graphics g)
    {
        super.update(g);
        paint(g);
    }
    
    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }
    
    public void imagen(){
        if(bool ==1){
        this.imagenmario="./images/marioizq.png";
        bool=0;
        }
        else{
        this.imagenmario="./images/marioder.png";
        bool=1;
        }
            
        
    }

    public void imagenIzq(){
        this.imagenmario="./images/marioizq.png";
    }
    
    public void imagenDer(){
        this.imagenmario="./images/marioder.png";
    }
    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }
    
     public int getbool() {
        return bool;
    }

    /**
     * @param y the y to set
     */
    public void setbool(int y) {
        this.bool = y;
    }
    
    

    /**
     * @return the y
     */
    public int getmarioY() {
        return marioy;
    }

    /**
     * @param y the y to set
     */
    public void setmarioY(int y) {
        this.marioy = y;
    }    
    
    
    
}
