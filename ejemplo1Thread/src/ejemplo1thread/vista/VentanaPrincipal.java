
package ejemplo1thread.vista;

import ejemplo1thread.JPanelBandera;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class VentanaPrincipal extends JFrame{
    public VentanaPrincipal(){
        super("Threads");
        ajustarConfiguracionInicial();
        agregarComponentes(this.getContentPane());
    }
    
    public void iniciar(){
        this.setVisible(true);
    }
    
    private void ajustarConfiguracionInicial(){
        this.setSize(500,350);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void agregarComponentes(Container c){
        panelPrincipal = new JPanelBandera();
        panelPrincipal.setLayout(new BorderLayout());
        
        c.add(panelPrincipal, BorderLayout.CENTER);
    }
    
    private JPanelBandera panelPrincipal;
    
}
