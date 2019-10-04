
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
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
public class TrianglePanel extends JPanel {
    private int xRel=0;
    private int yRel=0;
    private int relWidth=0;
    private int relHeight=0;
    public TrianglePanel(){
        
        setRelativeWidth(relWidth);
        setRelativeHeight(relHeight);
        setRelativeX(xRel);
        setRelativeY(yRel);
        
    }
    
    
    @Override
    public void paint(Graphics g){
        int sizeRel = super.getWidth()/100;
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, super.getWidth(),super.getHeight());
        g.setColor(Color.BLACK);
        
        Polygon triangle = new Polygon();
        triangle.addPoint(sizeRel*20, sizeRel*20);
        triangle.addPoint(sizeRel*50,sizeRel*20);
        triangle.addPoint(20*sizeRel, 80*sizeRel);
        
        
        g.setColor(Color.LIGHT_GRAY);
        g.fillPolygon(triangle);
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
}
