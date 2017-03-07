/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prooofconcept2d;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.event.KeyListener;
/**
 *
 * @author servkey
 */

public abstract class ProoOfConcept2D implements KeyListener{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CanvasDib canvas = new CanvasDib();
       // CanvasDib canvas2 = new CanvasDib("./images/mario.png");
        FrmGame fr = new FrmGame(canvas);
        fr.setSize(800, 600);
       
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        try {
            Clip sonido = AudioSystem.getClip();
           // File a = new File("./images/music.wav");
            File a =new File("C:\\Users\\Manuel\\Documents\\GitHub\\videogames\\Labs\\Lab01_Mundo\\src\\prooofconcept2d\\images\\mario.wav");
            sonido.open(AudioSystem.getAudioInputStream(a));
            sonido.start();
           // System.out.println("Reproduciendo 80s. de sonido...");
            Thread.sleep(80000); // 1000 milisegundos (10 segundos)
            sonido.close();
            }
            catch (Exception tipoerror) {
            System.out.println("" + tipoerror);
        
     }
    }
}
