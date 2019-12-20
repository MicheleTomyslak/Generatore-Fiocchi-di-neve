package finalversion;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.Writer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import org.apache.batik.svggen.SVGGraphics2D;
import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2DIOException;

import org.w3c.dom.Document;
import org.w3c.dom.DOMImplementation;



/**
 * 
 * 
 * @author Michele Tomyslak
 * 
 */
public class SnowFlakePanel extends javax.swing.JPanel  {
    
    /**
     * Posizione del mouse nel JPanel
     */
    Point posMouse;
    
    /**
     * TrianglePanel instance, used to import the cut triangolo.
     */
    TrianglePanel tp;
    

    /**
     * Center point of the generated hexagon.
     */
    private Point center;
    
    /**
     * Il colore di riempimento del fiocco di neve
     */
    Color riempimentoColor = new Color(0, 0, 0);
    
    /**
     * Il colore del bordo nel fiocco di neve
     */
    Color borderColor = Color.BLACK;
    
    boolean fill = true;
    
    boolean stroke = false;

    /**
     * Creates new form TrianglePanel
     */
    public SnowFlakePanel() {
        this.posMouse = new Point(0, 0);
        initComponents();
        
    }
    
    /**
     * Disegna il fiocco di neve partendo dal triangolo in TrianglePanel
     * 
     * @param g2d
     */
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.addRenderingHints(
                new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                                   RenderingHints.VALUE_ANTIALIAS_ON));
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                             RenderingHints.VALUE_TEXT_ANTIALIAS_ON );
        try{       
            g.setColor(new Color(200,200,255));
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            Area triangolo = this.tp.triangolo;
            this.center = new Point(this.tp.center.x, this.tp.center.y);
            for (int i = 6; i <= 36; i += 6) {
                
                if(this.fill){
                    g2d.setColor(this.riempimentoColor);
                    g2d.fill(translateToCenter(rotateArea(flipArea(triangolo), i*10)));
                    g2d.fill(translateToCenter(rotateArea(triangolo, i*10)));
                }
                if(this.stroke){
                    g2d.setColor(this.borderColor);
                    g2d.draw(translateToCenter(rotateArea(flipArea(triangolo), i*10)));
                    g2d.draw(translateToCenter(rotateArea(triangolo, i*10)));
                }
            }
        }catch(Exception ex){
//            JOptionPane jop = new JOptionPane();
//            jop.showOptionDialog(
//                    null,
//                    "Triangle object error. Code: sfp120",
//                    "Error triangolo class",
//                    JOptionPane.DEFAULT_OPTION,
//                    JOptionPane.ERROR_MESSAGE,
//                    null, null, null);
        }
        
    }

    /**
     * 
     * Flips an <code>Area</code> using <code>AffineTransform</code>, moving it
     * to the border, scaling it by -1 and retranslating it in the center.
     *
     * @param origArea original <code>Area</code> to flip.
     * @return flipped origArea (<code>Shape</code>)
     */
    public Shape flipArea(Area origArea) {
        AffineTransform mirror = new AffineTransform();
        mirror.scale(-1, 1);
        AffineTransform toBorder = new AffineTransform();
        toBorder.translate(-center.x * 2, 0);
        AffineTransform concat = new AffineTransform();
        concat.concatenate(mirror);
        concat.concatenate(toBorder);
        return concat.createTransformedShape(origArea);
    }

    /**
     * Translates to the center of the panel a <code>Shape</code>, moving it to
     * the border and retranslating it in the panel's center.
     * 
     * @param origShape original <code>Shape</code> to move to the center
     * @return moved origShape (<code>Shape</code>)
     */
    public Shape translateToCenter(Shape origShape){
        AffineTransform concat = new AffineTransform();
        AffineTransform toBorder = new AffineTransform();
        AffineTransform toCenter = new AffineTransform();
        
        toBorder.translate(-this.center.x, -this.center.y);
        toCenter.translate(this.getWidth()/2, this.getHeight()/2);
        
        concat.concatenate(toBorder);
        concat.concatenate(toCenter);
        return concat.createTransformedShape(origShape);
    }

    /**
     * 
     * @param origPoints
     * @return 
     */
    public Shape translateToSide(Shape origPoints){
        AffineTransform toBorder = new AffineTransform();
        toBorder.translate(-this.center.x, -this.center.y);
        AffineTransform toCenter = new AffineTransform();
        toCenter.translate(300, 300);
        AffineTransform concat = new AffineTransform();
        concat.concatenate(toBorder);
        concat.concatenate(toCenter);
        return concat.createTransformedShape(origPoints);
    }

    /**
     * 
     * 
     * @param origPoints original non-rotated Shape
     * @param angle rotation angle
     * @return rotated <code>Shape</code>
     */
    public Shape rotateArea(Shape origPoints, double angle) {
        AffineTransform tx = new AffineTransform();
        tx.rotate(Math.toRadians(angle), this.center.x, this.center.y);
        return tx.createTransformedShape(origPoints);
    }

    /**
     * Generates an SVG file based on the <code>Graphics2D</code> object in the 
     * paintComponent method.
     * 
     * @param filename path of the destination file
     */
    public void generaVettoriale(String filename){
        DOMImplementation domImpl =
        GenericDOMImplementation.getDOMImplementation();
        String svgNS = "http://www.w3.org/2000/svg";
        Document document = domImpl.createDocument(svgNS, "svg", null);
        SVGGraphics2D svgGenerator = new SVGGraphics2D(document);
        this.paintComponent(svgGenerator);
        boolean useCSS = true;
        Writer out;
        try {
            svgGenerator.stream(filename+".svg");
        } catch (SVGGraphics2DIOException ex) {
            JOptionPane jop = new JOptionPane();
            jop.showOptionDialog(
                    null,
                    "Graphic error. Code: sf206",
                    "Graphic error",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.ERROR_MESSAGE,
                    null, null, null);
        }
    }

    /**
     * Generates a PNG image, using a <code>Graphics2D</code> object 
     * to paint the snowflake.
     * 
     * @param filename path of the destination file
     * @param width width (and height) of the image in pixels
     */
    public void generaImmaginePNG(String filename, int width){
        try {
            BufferedImage buffImg = new BufferedImage
                (width, width, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = buffImg.createGraphics();
            try{        
                Area triangolo = this.tp.triangolo;
                this.center = new Point(this.tp.center.x, this.tp.center.y);
                int supportVar = 6;
                for (int i = 1; i <= 6; i ++) {
                    if(this.fill){
                        g2d.setColor(this.riempimentoColor);
                        g2d.fill(
                                translateToSide(
                                        rotateArea(
                                                flipArea(triangolo), supportVar*i*10)
                                )
                        );
                        g2d.fill(
                                translateToSide(
                                        rotateArea(triangolo, supportVar*i*10)
                                )
                        );
                    }
                    if(this.stroke){
                        g2d.setColor(this.borderColor);
                        g2d.draw(
                                translateToSide(
                                        rotateArea(
                                                flipArea(triangolo), supportVar*i*10)
                                )
                        );
                        g2d.draw(
                                translateToSide(
                                        rotateArea(triangolo, supportVar*i*10)
                                )
                        );
                    }
                }
            }catch(Exception ex){
            }
            ImageIO.write(buffImg, "PNG", new File(filename+".PNG"));
        } catch (IOException ie) {
            JOptionPane jop = new JOptionPane();
            jop.showOptionDialog(
                    null,
                    "Cannot create file",
                    "Error creating file",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.ERROR_MESSAGE,
                    null, null, null);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
