
package ejemplo1thread;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;


public class JPanelBandera extends JPanel 
        implements Runnable{
    
    @Override
    public void run(){
        while(hiloEstrellas == Thread.currentThread()){
            try {
                p+= Math.PI / 16;
                repaint();
                Thread.sleep(50); //entre mayor el numero mas va a durar
            } catch (InterruptedException ex) {
                System.out.println("Ocurrio un error de interrupcion...");
            }
        }
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g); //obligatorio
        this.setBackground(Color.WHITE);
        dibujarBanderaHonduras(g);
    }
    
    private void dibujarBanderaHonduras(Graphics g){
        Color colorAzul = new Color(8, 123, 206);
        Color colorBlanco = new Color(255, 255, 255);
        
        int cantidadFranjas = 3;
        int ancho = this.getWidth();
        int alto = this.getHeight()/cantidadFranjas;
        
        g.setColor(colorAzul);
        g.fillRect(0, alto * 0, ancho, alto);
        
        g.setColor(colorBlanco);
        g.fillRect(0, alto * 1, ancho, alto);
        
        g.setColor(colorAzul);
        g.fillRect(0, alto * 2, ancho, alto);
        
        int tamano = alto/cantidadFranjas;
        int tamanoDiferencial = alto/20;
        int centrox = this.getWidth()/2;
        int centroy = this.getHeight()/2;
        
        //DIBUJAR LA ESTRELLA IZQUIERDA SUPERIOR
        drawStar(g,colorAzul,5,centrox - tamano - tamanoDiferencial * 4, 
                centroy - tamano + tamanoDiferencial, tamano, tamano, p);
        //DIBUJAR LA ESTRELLA IZQUIERDA INFERIOR
        drawStar(g,colorAzul,5,centrox - tamano - tamanoDiferencial * 4, 
                centroy + tamano - tamanoDiferencial, tamano, tamano, p);
        //DIBUJAR LA ESTRELLA CENTRAL
        drawStar(g,colorAzul,5,centrox, 
                centroy, tamano, tamano, p);
        //DIBUJAR LA ESTRELLA IZQUIERDA SUPERIOR
        drawStar(g,colorAzul,5,centrox + tamano + tamanoDiferencial * 4, 
                centroy - tamano + tamanoDiferencial, tamano, tamano, p);
        //DIBUJAR LA ESTRELLA IZQUIERDA SUPERIOR
        drawStar(g,colorAzul,5,centrox + tamano + tamanoDiferencial * 4, 
                centroy + tamano - tamanoDiferencial, tamano, tamano, p);
    }
    
    public void drawStar(Graphics g, Color c, int sides, 
                        int x, int y,int w, int h, double a0ffset){
        Color colorSave = g.getColor();
        g.setColor(c);
        int cx = x + w / 2;
        int cy = y + h / 2;
        int[] xPoints = new int[2 * sides];
        int[] yPoints = new int[2 * sides];
        double d = Math.PI / sides;
        double a = -Math.PI / 2.0 + a0ffset;
        for(int p=0;p<2*sides;p++){
            double r = ((p%2)==0) ? 1.0 : 0.4;
            int nx = (int) (cx + Math.cos(a) * w / 2 * r) - w / 2;
            int ny = (int) (cy + Math.sin(a) * h / 2 * r) - h / 2;
            xPoints[p] = nx;
            yPoints[p] = ny;
            a += d;
        }
        g.fillPolygon(xPoints,yPoints,2*sides);
        g.setColor(colorSave);
    }
    
    public JPanelBandera(){
        iniciar();
    }
    
    private void iniciar(){
        hiloEstrellas = new Thread(this); //instanciamos el Thread y le mandamos el runnable por medio del this
        if(hiloEstrellas != null){ //que el Thread exista
            hiloEstrellas.start();
        }
    }

    //ATRIBUTOS
    private Thread hiloEstrellas;
    private Double p = 0.0;
}
