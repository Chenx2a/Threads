
package threads2.vista;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;
import threads2.JPanelBandera;


public class VentanaPrincipal extends JFrame {
    public VentanaPrincipal(){
        super("Carreritas");
        ajustarConfiguracionInicial();
        agregarComponentes(this.getContentPane());
    }
    
    public void iniciar(){
        this.setVisible(true);
    }
    
    private void ajustarConfiguracionInicial(){
        this.setSize(1200,500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void agregarComponentes(Container c){
        panelPrincipal = new JPanelBandera();
        panelPrincipal.setLayout(new BorderLayout());
        
        c.add(panelPrincipal, BorderLayout.CENTER);
    }
    
    JPanelBandera  panelPrincipal;
}
