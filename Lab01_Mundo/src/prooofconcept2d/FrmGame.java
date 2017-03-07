/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prooofconcept2d;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import java.awt.event.KeyListener;

/**
 *
 * @author servkey
 */
public class FrmGame extends JFrame implements KeyListener{
//public abstract class FrmGame extends JFrame implements KeyListener{
    private Thread t,h;
    private CanvasDib c,d;
    private int lado,contador;
    public FrmGame(CanvasDib c){
      addKeyListener(this); 
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
    //    while (true){
     //       try {
     //           Thread.sleep(200);
        //     lado=lado+1;
                //mover las imagenes
        //        if (c.getX()>-585){
        //            c.setX(c.getX()-8);
                //c.setmarioX(c.getmarioX()+2);
                  /*  if (c.getbool() == 1){
                        //System.out.println("valor"+ c.getbool());
                    c.imagenIzq();
                    c.setbool(0);
                    }else{
                        c.imagenDer();
                    //    System.out.println("valor"+ c.getbool());
                        c.setbool(1);
                    }
                   */
       //             c.imagen();
       //         c.repaint();
      //          }
       //     } catch (InterruptedException ex) {
        //        Logger.getLogger(FrmGame.class.getName()).log(Level.SEVERE, null, ex); 
        //    }           
    //    }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("entro");
        if (e.getKeyCode() == KeyEvent.VK_UP){
            System.out.println("arriba");
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN){
            System.out.println("abajo");
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT){
            System.out.println("izquierda");
        }
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            System.out.println("derecha");
            c.imagen();
           // if (c.getX()>-585){
              if (c.getX()>-1000){
                   c.setX(c.getX()-8);
                   c.repaint();
            }
        }
        else if (e.getKeyCode() == KeyEvent.VK_SPACE){
            System.out.println("letra espacio");
            
            h = new Thread(){
            public void run(){
                try{
                 c.marioSalto();
                  System.out.println(c.getmarioY());
                  contador=0;
           while(c.getmarioY()>200){
                    c.setmarioY(c.getmarioY()-8);
                    contador=contador+1;
                    Thread.sleep(150);
                    c.repaint();
                   }
           while(contador>0){
               c.setmarioY(c.getmarioY()+8);
               contador=contador-1;
               Thread.sleep(150);
               c.repaint();
           }
           c.marioCae();
                }catch(Exception e){}
              }
        };//fin de run
        h.start();
            
        }
        else System.out.println("nada");
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
