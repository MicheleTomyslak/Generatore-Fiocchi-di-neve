import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.*;



/**
 *
 * @author Michele Tomyslak
 */
public class MainFrame extends JFrame {
    /**
     * tp è il JPanel dove è contenuto il triangolo da tagliare per realizzare il fiocco.
     */
    private TrianglePanel tp;
    /**
     * fp è il JPanel dove è contenuto la rappresentazione del fiocco.
     */
    private FlakesPanel fp;
    
    public static void main(String[]args){
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
        //mf.setSize(500,500);
        mf.setMinimumSize(new Dimension(1024,768));
        mf.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * Costruttore vuoto
     */
    public MainFrame(){
       int relWidth = this.getWidth()/100;

       tp = new TrianglePanel();
       tp.setVisible(true);
       fp = new FlakesPanel(relWidth*50,relWidth*10,relWidth*50,relWidth*50);
       
       fp.setVisible(true);
    }
    
    @Override
    public void paint(Graphics g){
        g.setColor(Color.WHITE);
        
       tp.paint(g);
       
       fp.paint(g);
    }
}
