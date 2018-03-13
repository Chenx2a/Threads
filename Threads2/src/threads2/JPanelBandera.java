package threads2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import static java.lang.Math.abs;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelBandera extends JPanel
        implements Runnable {

    @Override
    public void run() {
        while (hiloCarro == Thread.currentThread()) {
            try {
                Random rand = new Random();
                if(x!= 1100 && x1!= 1100 && x2!= 1100){
                x += abs(rand.nextInt()%3);
                x1 += abs(rand.nextInt()%3);
                x2 += abs(rand.nextInt()%3);
                }
                repaint();
                Thread.sleep(5); //entre mayor el numero mas va a durar
            } catch (InterruptedException ex) {
                System.out.println("Ocurrio un error de interrupcion...");
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.WHITE);
        ImageIcon img = new ImageIcon(getClass().getResource(""));
        g.drawImage(img.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
        dibujar(g);
    }
    
    private void dibujar(Graphics g){
        int alto = this.getHeight()/3;
        int ancho = this.getWidth()/9;
        ImageIcon img = new ImageIcon(getClass().getResource("images.png"));
        g.drawImage(img.getImage(),x,0, ancho, alto, this);
        g.drawImage(img.getImage(),x1,alto, ancho, alto, this);
        g.drawImage(img.getImage(),x2,alto*2, ancho, alto, this);
        
    }

    public JPanelBandera() {
        iniciar();
    }

    private void iniciar() {
        hiloCarro = new Thread(this); //instanciamos el Thread y le mandamos el runnable por medio del this
        if (hiloCarro != null) { //que el Thread exista
            hiloCarro.start();
        }
    }

    private Thread hiloCarro;
    private int x = 0;
    private int x1 = 0;
    private int x2 = 0;
    

}
