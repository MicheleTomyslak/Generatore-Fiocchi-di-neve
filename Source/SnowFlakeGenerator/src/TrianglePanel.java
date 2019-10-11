
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tmich
 */
public class TrianglePanel extends JPanel implements MouseListener {
    private int xRel=0;
    private int yRel=0;
    private int relWidth=0;
    private int relHeight=0;
    private int lastXClicked=0;
    private int lastYClicked=0;
    public TrianglePanel(){
        this.addMouseListener(this);
        setRelativeWidth(relWidth);
        setRelativeHeight(relHeight);
        setRelativeX(xRel);
        setRelativeY(yRel);
        
    }
    
    
    @Override
    public void paint(Graphics g){
        int sizeRel ;
        double dSizeRel = this.getWidth()/100;
        dSizeRel*=20;
        sizeRel=(int) dSizeRel;
        //System.out.println("2"+sizeRel);
        
        
        //System.out.println(sizeRel+":    Relative size");
        //System.out.println(dSizeRel+":    Relative size double");
        Polygon triangle = new Polygon();
        triangle.addPoint(200,100);
        
        triangle.addPoint(200,400);
               
        triangle.addPoint(400,100);
        //System.out.println(triangle.npoints);
        
        g.setColor(Color.BLUE);
        g.fillPolygon(triangle);
        g.setColor(Color.WHITE);
        g.drawString("Last mouse X: "+lastXClicked, 100,160);
        
        g.drawString("Last mouse Y: "+lastYClicked, 100,180);
    }
    public int getRelativeWidth(){
        return relWidth;
    } 
    public int getRelativeHeight(){
        return relHeight;
    } 
    public int getRelativeX(){
        return xRel;
    } 
    public int getRelativeY(){
        return yRel;
    } 
    
    
    
    
    
    public void setRelativeWidth(int relWidth ){
        if(relWidth>0){
            this.relWidth=relWidth;
        }
        
    }
    
    public void setRelativeX(int xRel ){
        if(xRel>0){
            this.xRel=xRel;
        }
        
    }
    
    public void setRelativeHeight(int relHeight ){
        if(relHeight>0){
            this.relHeight=relHeight;
        }
        
    }
    
    public void setRelativeY(int yRel ){
        if(yRel>0){
            this.yRel=yRel;
        }
        
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        lastXClicked = me.getX();
        lastYClicked = me.getY();
        System.out.println("X: "+lastXClicked);
        System.out.println("Y: "+lastYClicked);
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
