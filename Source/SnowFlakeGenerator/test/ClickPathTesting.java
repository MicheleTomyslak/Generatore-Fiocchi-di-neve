
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Serve a testare il sistema di generazione dei tagli
 * @author tmich
 */
public class ClickPathTesting extends JFrame implements MouseListener {
    /**
     * Ultimo click del mouse sotto forma di Point
     */
    private Point lastClickPoint;
    Polygon p = new Polygon();
    /**
     * Lista dei poligoni.
     */
    private ArrayList<Polygon> listPolygon = new ArrayList<>();
    /**
     * Lista dei punti di un poligono.
     */
    private ArrayList<Point> listPoints = new ArrayList<>();
    /**
     * Valore booleano che controlla se sto chiudendo un poligono (Premendo su un punto già precedentemente cliccato)
     */
    private boolean closePoly=false;
    
    /**
     * 
     */
    public ClickPathTesting(){
        this.addMouseListener(this);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    
    public static void main(String[]args){
        ClickPathTesting cpt = new ClickPathTesting();
        cpt.setSize(500,500);
        cpt.setVisible(true);
    }
    
    
    @Override
    public void paint(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(Color.BLACK);
        //System.out.println(listListPoint.size());
        if(lastClickPoint!=null){
            
            listPolygon.get(listPolygon.size()-1).addPoint(lastClickPoint.x, lastClickPoint.y);
        }else{
            listPolygon.add(new Polygon());
        }
        for (int x = 0;x < listPolygon.size(); x++) {
            for (int i = 0; i < listPolygon.get(x).npoints; i++) {
                g.fillOval(listPolygon.get(x).xpoints[i]-5, listPolygon.get(x).ypoints[i]-5, 10, 10);
            }
        }
        
        
        
        
        
        g.drawString(""+listPolygon.size(), 50, 50);
        
        
            System.out.println(listPolygon.size());
            for (int i = 0; i < listPolygon.size(); i++) {
                p = listPolygon.get(i);
                g.fillPolygon(p);
            }
        
        
        
        
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        if(lastClickPoint!=null){
            listPoints.add(lastClickPoint);
        }
        
        p = new Polygon();
        for (int i = 0; i < listPoints.size(); i++) {
            if(me.getPoint().distance(listPoints.get(i))<=5){
                closePoly=true;
                break;
                
            }else{
                closePoly=false;
            }
        }
        if(closePoly){
            for (int i = 0; i < listPoints.size(); i++) {
                p.addPoint(listPoints.get(i).x,listPoints.get(i).y);
            }
            listPolygon.add(p);
            listPoints.clear();
        }else{
            lastClickPoint = me.getPoint();
        }
        
        
        
        
        /*for (int x = 0; x < listPolygon.size(); x++) {
            for (int i = 0; i < listPoints.size(); i++) {
                //System.out.println(listPolygon.size());
                Point newpoint = new Point(listPolygon.get(x).xpoints[i],listPolygon.get(x).ypoints[i]);
            
                if(listPolygon.size()==0){
                    System.out.println(listPolygon.size());
                    listPoints.add(lastClickPoint);
                }
                else if(lastClickPoint.distance(newpoint)<=15){
                    System.out.println("Stonks");
                    Polygon p2=new Polygon();
                    for (int j = 0; j < listPoints.size(); j++) {
                        p2 = new Polygon();
                        p2.addPoint(listPoints.get(j).x, listPoints.get(j).y);
                        
                    }
                    listPolygon.add(p2);
                //
                }else{
                    System.out.println("not stonks");
                    listPolygon.get(x).addPoint(lastClickPoint.x,lastClickPoint.y);
                }
            }
        }
        
        */
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
