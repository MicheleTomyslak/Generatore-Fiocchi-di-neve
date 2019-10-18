import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;



/**
 *
 * @author Michele Tomyslak
 */
public class MainFrame extends JFrame implements MouseListener {
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
        mf.setMaximumSize(new Dimension(1024,768));
        mf.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * Costruttore vuoto
     */
    public MainFrame(){
       double rel = getHeight();
        System.out.println(rel);
       tp = new TrianglePanel();
       this.addMouseListener(tp);
       tp.setVisible(true);
       double relWidthFlakesPanel = rel * 10; 
       int relWidth = (int) relWidthFlakesPanel;
       fp = new FlakesPanel(100,100,100,100);
       
       fp.setVisible(true);
    }
    
    @Override
    public void paint(Graphics g){
        //System.out.println(this.getWidth());
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
         
        g.setColor(Color.WHITE);
        g.drawString("Width: "+this.getWidth(), 100, 100);
        g.drawString("Height:"+this.getHeight(),100,120);
        fp.paint(g); 
        tp.paint(g);
        
        
       
       
       
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
    }
}
