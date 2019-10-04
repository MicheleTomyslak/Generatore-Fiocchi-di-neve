import java.awt.*;
import javax.swing.*;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tmich
 */
public class FlakesPanel extends JFrame {
    /**
     * Elemento x del punto di origine del pannello.
     */
    private int x=0;
    /**
     * Elemento y del punto di origine del pannello.
     */
    private int y=0;
    /**
     * La larghezza del pannello.
     */
    private int width=0;
    /**
     * L'altezza del pannello.
     */
    private int height=0;
    public FlakesPanel(int x,int y,int width,int height){
        this.setSize(400,400);
        setWidth(width);
        setHeight(height);
        setX(x);
        setY(y);
        
    }
    
    public int getWidth(){
        return width;
    } 
    public int getHeight(){
        return height;
    } 
    public int getX(){
        return x;
    } 
    public int getY(){
        return y;
    } 
    
    
    
    
    /**
     * Setter dell'attributo width , cioè la larghezza del pannello nella schermata.
     * @param width la lunghezza del pannello nella finestra.
     */
    public void setWidth(int width ){
        if(width>0){
            this.width=width;
        }
        
    }
    /**
     * Setter dell'attributo x , per posizionare il pannello nella schermata.
     * @param x l'elemento x del punto di origine.
     */
    public void setX(int x ){
        if(x>0){
            this.x=x;
        }
        
    }
    
    /**
     * Setter di height, cioè l'altezza del pannello sulla finestra.
     * @param height l'altezza del pannello nella finestra.
     */
    public void setHeight(int height ){
        if(height>0){
            this.height=height;
        }
        
    }
    
    /**
     * Setter dell'attributo y , per posizionare il pannello nella schermata.
     * @param y l'elemento y del punto di origine.
     */
    public void setY(int y ){
        if(y>0){
            this.y=y;
        }
        
    }
    
    
    @Override
    public void paint(Graphics g){
        int sizeRel = this.getWidth()/100;
        System.out.println(sizeRel);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, this.getWidth(),this.getHeight());
        g.setColor(Color.BLACK);
        
        Polygon triangle = new Polygon();
        triangle.addPoint(x+sizeRel*20,y+ sizeRel*20);
        triangle.addPoint(x +sizeRel*80,y+sizeRel*20);
        triangle.addPoint(x+20*sizeRel,y+ 80*sizeRel);
        
        
        g.setColor(Color.LIGHT_GRAY);
        g.fillPolygon(triangle);
    }
}
