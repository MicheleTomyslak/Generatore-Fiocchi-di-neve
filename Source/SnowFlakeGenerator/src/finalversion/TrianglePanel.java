package finalversion;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Michele Tomyslak
 * @since 1.0
 */
public class TrianglePanel extends javax.swing.JPanel{
    ArrayList<TrianglePanelListener> listeners;
    /**
     *
     */
    Point mousePosition;

    /**
     *
     */
    Polygon poly;

    /**
     *
     */
    List<Point> points;

    List<Polygon> polygonList;

    /**
     *
     */
    private Triangle t1;

    /**
     *
     */
    Point center;

    /**
     *
     */
    Color riempimentoColor = new Color(175, 0, 175);
    Color strokeColor = Color.BLACK;

    /**
     *
     */
    int RAD = 5;

    /**
     *
     */
    public Area triangolo = new Area();

    /**
     *
     */
    boolean fill = true;

    /**
     *
     */
    boolean stroke = false;

    /**
     *
     */
    public TrianglePanel() {
        this.poly = new Polygon();
        this.points = new ArrayList<>();
        this.mousePosition = new Point(0, 0);
        initComponents();
    }
    
    public void addTrianglePanelListener(TrianglePanelListener listener){
        this.listeners.add(listener);
    }
    public void removeTrianglePanelListener(TrianglePanelListener listener){
        this.listeners.remove(listener);
    }

    /**
     *
     * @param contestoGrafico2D
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.cyan);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        
        Graphics2D contestoGrafico2D = (Graphics2D) g;
        contestoGrafico2D.addRenderingHints(
                new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON));
        contestoGrafico2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        this.t1 = new Triangle(this.getHeight(), this.getWidth(), false);
        this.triangolo = new Area(this.t1.triangolo);
        Area areaDiTaglio = new Area(this.poly);
        contestoGrafico2D.setColor(this.riempimentoColor);
        if (this.poly.npoints > 2) {
            triangolo.subtract(areaDiTaglio);
        }
        if (this.fill) {
            contestoGrafico2D.fill(this.triangolo);
        }
        if (this.stroke) {

            contestoGrafico2D.setColor(this.strokeColor);

            contestoGrafico2D.draw(this.triangolo);
        }
        this.center = new Point(this.t1.xEs[1], this.t1.yS[1]);
        contestoGrafico2D.setColor(new Color(120, 30, 30, 255));
        contestoGrafico2D.draw(areaDiTaglio);

        for (Point point : this.points) {
            contestoGrafico2D.setColor(new Color(100, 100, 100, 100));
            contestoGrafico2D.fillOval(
                    point.x - this.RAD,
                    point.y - this.RAD,
                    this.RAD * 2,
                    this.RAD * 2);
            contestoGrafico2D.setColor(new Color(0, 0, 0, 255));
            contestoGrafico2D.drawOval(point.x - this.RAD,
                    point.y - this.RAD,
                    this.RAD * 2,
                    this.RAD * 2);
        }
    }

    /**
     *
     * @param handle
     */
    public void serialize(File handle) {
        String path = handle.toString();
        try {
            FileOutputStream outputStream = new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(outputStream);
            out.writeObject(this.poly);
            out.close();
            outputStream.close();
        } catch (IOException i) {
            JOptionPane jop = new JOptionPane();
            jop.showOptionDialog(
                    null,
                    "Cannot write file " + handle + ". Code: tp158",
                    "Error opening file",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.ERROR_MESSAGE,
                    null, null, null);
        }
    }

    /**
     *
     * @param handle
     */
    public void deSerialize(File handle) {
        String path = handle.toString();
        try {
            FileInputStream inputStream = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(inputStream);
            this.poly = (Polygon) in.readObject();
            if (!this.points.isEmpty()) {
                this.points.clear();
            }
            for (int i = 0; i < this.poly.npoints; i++) {
                this.points.add(
                        new Point(this.poly.xpoints[i], this.poly.ypoints[i]));
            }
            repaint();
            in.close();
            inputStream.close();
        } catch (IOException | ClassNotFoundException i) {
            JOptionPane jop = new JOptionPane();
            jop.showOptionDialog(
                    null,
                    "Cannot open file " + handle + ". Code: tp190",
                    "Error opening file",
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

        setMinimumSize(new java.awt.Dimension(300, 0));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

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

    /**
     *
     * @param evt
     */
    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        for (Point point : points) {
            if (evt.getPoint().distance(point) <= this.RAD) {
                if (evt.getX() > this.RAD && evt.getY() > this.RAD) {
                    if (evt.getX() < this.getWidth() - this.RAD
                            && evt.getY() < this.getHeight() - this.RAD) {
                        int index = this.points.indexOf(point);
                        this.points.add(index, evt.getPoint());
                        this.points.remove(point);
                        break;
                    }
                }
            }
        }
        this.poly.reset();
        int[] x = new int[points.size()];
        int[] y = new int[points.size()];
        for (int i = 0; i < this.points.size(); i++) {
            x[i] = this.points.get(i).x;
            y[i] = this.points.get(i).y;
            this.poly = new Polygon(x, y, this.points.size());
        }
        repaint();
    }//GEN-LAST:event_formMouseDragged

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        /*if(evt.getButton() == evt.BUTTON1){
            this.poly.addPoint(evt.getX(), evt.getY());
            this.points.add(evt.getPoint());
        }else if(evt.getButton() == evt.BUTTON3){
            for (Point point : points) {
                if(evt.getPoint().distance(point) <= this.RAD){
                    this.points.remove(point);
                    break;
                }
            }
            this.poly.reset();
            int[] x = new int[points.size()];
            int[] y = new int[points.size()];
            for (int i = 0; i < this.points.size(); i++) {
                x[i] = this.points.get(i).x;
                y[i] = this.points.get(i).y;
                this.poly = new Polygon(x, y, this.points.size());
            }
        }
         */
        repaint();    }//GEN-LAST:event_formMouseReleased

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        if (evt.getButton() == evt.BUTTON1) {
            this.poly.addPoint(evt.getX(), evt.getY());
            this.points.add(evt.getPoint());
        } else if (evt.getButton() == evt.BUTTON3) {
            for (Point point : points) {
                if (evt.getPoint().distance(point) <= this.RAD) {
                    this.points.remove(point);
                    break;
                }
            }
            this.poly.reset();
            int[] x = new int[points.size()];
            int[] y = new int[points.size()];
            for (int i = 0; i < this.points.size(); i++) {
                x[i] = this.points.get(i).x;
                y[i] = this.points.get(i).y;
                this.poly = new Polygon(x, y, this.points.size());
            }
        }

        repaint();
        
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
