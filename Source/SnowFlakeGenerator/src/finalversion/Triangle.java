package finalversion;

import java.awt.Point;
import java.awt.Polygon;
import java.util.List;

/**
 * 
 * 
 * @author Michele Tomyslak
 * 
 */
public class Triangle {

    /**
     * 
     */
    Polygon triangolo = new Polygon();

    /**
     * 
     */
    int altezza;

    /**
     * 
     */
    int cath;

    /**
     * 
     */
    int altezzaPannello;

    /**
     * 
     */
    int larghezzaPannello;
    
    /**
     * 
     */
    boolean generated;

    /**
     * 
     */
    int[] xEs = new int[3];

    /**
     * 
     */
    int[] yS = new int[3];

    /**
     * 
     */
    Polygon poligono;

    /**
     * 
     */
    List<Point> listaPunti;

    /**
     * 
     */
    public static final int WIDTH = 200;

    /**
     * 
     */
    public static final double HEIGHT = 200 * Math.sqrt(3);

    /**
     *
     * @param altezzaPannello
     * @param larghezzaPannello
     * @param generated
     */
    public Triangle(int altezzaPannello, int larghezzaPannello, boolean generated) {
        this.altezzaPannello = altezzaPannello;
        this.larghezzaPannello = larghezzaPannello;
        this.generated = generated;
        this.calcolaDimensioni();
    }
    
    /**
     *
     * @param p
     */
    public void aggiungiPuntoAlPoligono(Point p){
        Point p2 = new Point(
                (p.x * WIDTH/this.cath),
                (int)(p.y * HEIGHT/this.cath));
        this.poligono.addPoint(p2.x, p2.y);
        this.listaPunti.add(p2);
    }

    /**
     *
     */
    public void calcolaDimensioni(){
        this.cath = 
                (int)(
                    WIDTH * (this.altezzaPannello/2)/HEIGHT) /
                    (this.generated?2:1);
        this.altezza = (int)(this.cath * Math.sqrt(3));
        
        this.xEs[0] = 
                (int)(
                    this.larghezzaPannello /
                    ((this.generated?2.5:4) /
                    (this.generated?1.25:1)));
        
        this.xEs[1] = this.xEs[0];
        this.xEs[2] = this.xEs[0] + this.cath;
        this.yS[0] = this.altezzaPannello / 4;
        this.yS[1] = this.yS[0] + this.altezza;
        this.yS[2] = this.yS[0];
        this.triangolo = new Polygon(this.xEs, this.yS, 3);
        
    }
}
