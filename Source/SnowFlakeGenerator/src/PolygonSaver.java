
import java.awt.Polygon;
import java.io.*;
import java.nio.file.*;
import javax.swing.JOptionPane;
import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2D;
import org.apache.batik.svggen.SVGGraphics2DIOException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;





/**
 * Questa classe permette di:
 * - Salvare un poligono in una stringa e salvarlo su un file di percorso path.
 * - Caricare un poligono da un file, riconvertendolo da stringa a Polygon.
 * - Convertire da Polygon a String e viceversa.
 * @author Michele Tomyslak
 */
public class PolygonSaver {
    
    
    /**
     * poly è il poligono che verrà convertito in stringa
     */
    private Polygon poly;
    /**
     * È il percorso dove andra salvato il poligono.
     */
    private Path path ;
    
    
    
    public static void main(String[] args) {
        PolygonSaver ps = new PolygonSaver(new Polygon());
        ps.poly.addPoint(0, 0);
        ps.poly.addPoint(234, -234);
        ps.poly.addPoint(34, 645);
        ps.poly.addPoint(0, 0);
        ps.path = Paths.get("PolygonData.csv");
        
        
        String s = polyToString(ps.getPolygon());
        System.out.println(s);
        Polygon p = stringToPoly(s);
        String sReformatted = polyToString(p);
        System.out.println(sReformatted);
        
        
        ps.SavePoly(s);
        System.out.println(ps.getPolygonData());
        
        
        
    }
    
    /**
     * Trasforma un oggetto Polygon in una stringa
     * @param p Il poligono da trasformare
     * @return La stringa già formattata per il salvataggio su file.
     */
    public static String polyToString(Polygon p){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < p.npoints; i++) {
            sb.append(p.xpoints[i]);
            sb.append(",");
            sb.append(p.ypoints[i]);
            sb.append(",");
        }
        
        return sb.toString();
    }
    
    /**
     * scrive suu un file il poligono.
     * @param s La stringa già modificata dal metodo PolygonSaver.polyToString()
     */
    public void SavePoly(String s ){
        
        try {
            Files.writeString(this.path, polyToString(this.poly));
        } catch (IOException ex) {
            System.out.println("Salvataggio fallito");
        }
    }
    
    /**
     * Converte la stringa s in un oggetto Polygon.
     * - La stringa deve essere formattata come un csv, con una virgola tra ogni valore.
     * @param s la stringa da convertire in poligono
     * @return Il poligono convertito.
     */
    public static Polygon stringToPoly(String s){
        Polygon p = new Polygon();
        
        String[] sArray = s.split(",");
        
        for (int i = 0; i < sArray.length; i+=2) {
            try{
                int x = Integer.parseInt(sArray[i]);
                int y = Integer.parseInt(sArray[i+1]);
                p.addPoint(x,y);
                
            }catch(NumberFormatException nfe){
                
            }
            
            
            
        }
        return p;
        
        
    }
    
    /**
     * Prende dal file situato nella variabile dell'oggeto path, il suo contenuto.
     * @return La stringa da poi essere ritrasformata in Polygon.
     */
    public String getPolygonData(){
        String s= new String();
        try {
            s = Files.readString(this.path);
        } catch (IOException ex) {
            System.out.println("Errore nella lettura del file");
        }
        return s;
    }
    
    public void generateSVG(String filename){
        DOMImplementation domImpl = GenericDOMImplementation.getDOMImplementation();
        String svgNS = "http://www.w3.org/2000/svg";
        Document document = domImpl.createDocument(svgNS, "svg", null);
        SVGGraphics2D svgGenerator = new SVGGraphics2D(document);
        
        boolean useCSS = true;
        Writer out;
        try {
            svgGenerator.stream(filename);
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
     *
     * @param poly Il poligono da salvare
     */
    public PolygonSaver(Polygon poly){
      setPolygon(poly);  
    }
    
    /**
     * Setter del poligono da salvare.s
     * @param poly Il poligono da salvare
     */
    public void setPolygon(Polygon poly){
        this.poly = poly;
    }
    
    /**
     * Ritorna il poligono.
     * @return Il poligono
     */
    public Polygon getPolygon(){
        return this.poly;
    }
}
