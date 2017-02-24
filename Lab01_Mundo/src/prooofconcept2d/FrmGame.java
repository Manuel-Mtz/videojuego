/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prooofconcept2d;
import java.awt.Canvas;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author servkey
 */
public class FrmGame extends JFrame{
    private Thread t;
    private CanvasDib c,d;
    private int lado;
    public FrmGame(CanvasDib c){
       
        this.c = c;
        d = new CanvasDib("./images/mario.png");
        lado=0;
        
        add(c);
        //add(d);
        //Iniciar hilo
        t = new Thread(){
              public void run(){
                  updating();
              }
        };
        t.start();
     
        this.getContentPane().setBackground(Color.WHITE);
    }
    
    public void updating(){
        while (true){
            try {
                Thread.sleep(200);
                lado=lado+1;
                //mover las imagenes
                if (c.getX()>-585){
                    c.setX(c.getX()-8);
                //c.setmarioX(c.getmarioX()+2);
                    if (c.getbool() == 1){
                        //System.out.println("valor"+ c.getbool());
                    c.imagenIzq();
                    c.setbool(0);
                    }else{
                        c.imagenDer();
                    //    System.out.println("valor"+ c.getbool());
                        c.setbool(1);
                    }
                                          
                c.repaint();
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(FrmGame.class.getName()).log(Level.SEVERE, null, ex);
            }           
        }
    }
}
