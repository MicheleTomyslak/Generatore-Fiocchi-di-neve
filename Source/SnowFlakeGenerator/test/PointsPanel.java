
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
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
public class PointsPanel extends JPanel implements MouseListener, MouseMotionListener {

    private Point lastPoint;

    private final int DIAMETER = 20;

    private boolean isClicked = false;

    private boolean isPressedInsideCircle = false;

    private Point rewritePoint;

    private boolean isReleasedOutsideCircle = false;

    private ArrayList<Point> pointList = new ArrayList<>();
    
    private int indexListPointSelected;

    /**
     *
     */
    public PointsPanel() {
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(Color.BLACK);
        for (int i = 0; i < pointList.size(); i++) {
            System.out.println(pointList.size());
            
            
            if (isClicked) {
                Point currentPoint = pointList.get(i);
                g.fillOval(currentPoint.x - DIAMETER / 2, currentPoint.y - DIAMETER / 2, DIAMETER, DIAMETER);
                //pointList.add(currentPoint);
                isClicked=false;
            } else if (isReleasedOutsideCircle) {

                
                isReleasedOutsideCircle = false;
                isPressedInsideCircle = false;
                
            }else{
                Point currentPoint = pointList.get(i);
                g.fillOval(currentPoint.x - DIAMETER / 2, currentPoint.y - DIAMETER / 2, DIAMETER, DIAMETER);

            }
        }
        g.setColor(Color.RED);
        if (isClicked) {
            g.fillOval(lastPoint.x - DIAMETER / 2, lastPoint.y - DIAMETER / 2, DIAMETER, DIAMETER);
            pointList.add(lastPoint);
            isClicked = false;
            System.out.println(pointList.size());
        }
        
        g.setColor(Color.BLACK);
        for (int i = 0; i < pointList.size(); i++) {
            
            String p = pointToString(pointList.get(i));
            g.drawString(p,20,20*i);
        }

    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
        isClicked = true;
        lastPoint = arg0.getPoint();
        pointList.add(arg0.getPoint());
        repaint();
        //isClicked=false;
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        if (lastPoint != null) {
            if (lastPoint.distance(arg0.getPoint()) > DIAMETER / 2) {
                System.out.println("rilasciato fuori");
                rewritePoint = arg0.getPoint();
                if(!pointList.isEmpty()){
                    pointList.remove(indexListPointSelected);
                }
                
                pointList.add(indexListPointSelected,rewritePoint);
                
                isReleasedOutsideCircle = true;
                this.printPoint(rewritePoint);
                repaint();
            }
        }

    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
    }

    @Override
    public void mouseExited(MouseEvent arg0) {

    }

    private static void printPoint(Point p) {
        System.out.println("X:" + p.x + "        Y:" + p.y);
    }
    
    private static String pointToString(Point p){
        return "X:" + p.x + "\tY:" + p.y;
    }

    @Override
    public void mouseDragged(MouseEvent arg0) {
        if (pointList != null) {
            for (int x = 0; x < pointList.size(); x++) {
                if (pointList.get(x) != null) {
                    if (pointList.get(x).distance(arg0.getPoint()) < DIAMETER / 2) {
                        isPressedInsideCircle = true;
                        indexListPointSelected = x;
                        System.out.println("Punto " + x);
                        repaint();
                        break;

                    }
                }
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent arg0) {
    }
    
    
    public void resetPointList(){
        pointList.clear();
    }

}
