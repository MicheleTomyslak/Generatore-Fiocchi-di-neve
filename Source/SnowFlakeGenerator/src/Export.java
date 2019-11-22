
import java.awt.Point;
import java.awt.Polygon;
import java.nio.file.Path;
import java.util.ArrayList;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Michele Tomyslak
 */
public class Export {
    /**
     * L'array di poligoni da esportare:
     * - array di Point 
     * - contenenti x e y in int
     */
    private ArrayList<Polygon> dataToSave = new ArrayList<>();
    
    /**
     * L'array di points da esportare:
     * - contenenti x e y in int
     */
    private ArrayList<Point> PointsToSave = new ArrayList<>();
    /**
     * L'array di points da esportare:
     * - contenenti x e y in int
     */
    private ArrayList<Point> xToSave=new ArrayList<>();
    /**
     * L'array di points da esportare:
     * - contenenti x e y in int
     */
    private ArrayList<Point> yToSave=new ArrayList<>();
    
    /**
     * Il percorso dove esportare il file.
     */
    private Path p;
    
    /**
     * il nome del file da scrivere.
     */
    private String fileName = "";
    
    private String formattedContent = "";
    
    
    
    
    
    
    
    /**
     * Esporta i dati ottenuti dall' array di poligoni per poi 
     * stamparli nella path p.
     * @param dataToSave Il dato da salvare
     * @param p Il percorso del file su cui si esporta il dato.
     */
     
    public Export(ArrayList<Polygon> dataToSave,Path p){
        setDataToSave(dataToSave);
        setPath(p);
        setFileName(fileName);
    }
    
    public static void main(String[]args){
        ArrayList<Polygon> poly = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            poly.add(new Polygon ());
        }
        
        Path p = Paths.get("C:\\Users\\tmich\\Documents\\Modulo 306\\file.elif");
        Export e = new Export(poly,p);
        
        e.writeFile(e.formattedContent);
        
        
    }
    
    
    
    /**
     * Setter del dato da salvare nel file
     * @param dataToSave Il dato da salvare
     */
    public void setDataToSave(ArrayList<Polygon> dataToSave){
        this.dataToSave = dataToSave;
    }
    /**
     * Setter del percorso dove salvare il file.
     * @param p Il percorso del file.
     */
    public void setPath(Path p){
        this.p = p;
    }
    
    
    
    
    /**
     * Setter del nome del file.
     * @param fileName Il nome del file.
     */
    public void setFileName(String fileName){
        this.fileName = fileName;
    }
    /**
     * Getter di una lista di point dalla  lista di poligoni all'indice index
     * @param index l'indice da dove prendere la lista
     * @return 
     */
    public ArrayList<Point> getPointsFromPolygon(int index){
        Polygon poly = dataToSave.get(index);
        ArrayList<Point> points= new ArrayList<>();
        int[] xpoints = poly.xpoints;
        int[] ypoints = poly.ypoints;
        for (int i = 0; i < xpoints.length; i++) {
            Point pointFP = new Point(xpoints[i],ypoints[i]);
            points.add(pointFP);
        }
        return points;
    }
    
    /**
     * Getter di tutte le x dalla lista di punti;
     * @return Tutte le X in una lista.
     */
    public ArrayList<Integer>  getXFromPoints(){
        ArrayList<Integer> xList = new ArrayList<>();
        for (int i = 0; i < xList.size(); i++) {
            xList.add(this.PointsToSave.get(i).x);
        }
        return xList;
    }
    
    /**
     * Getter di tutte le y dalla lista di punti;
     * @return Tutte le Y in una lista
     */
    public ArrayList<Integer>  getYFromPoints(){
        ArrayList<Integer> yList = new ArrayList<>();
        for (int i = 0; i < yList.size(); i++) {
            yList.add(this.PointsToSave.get(i).y);
        }
        return yList;
    }
    
    
    
    
    
    public String setContentString(){
       return "";       
    }
    
    
   
    /**
     * Metodo che formatta tutti i dati grezzi in strighe da salvare nel formato appropriato per l'esportazione
     * @param string 
     * @return 
     */
    public String formatString(String string){
        //Grandezza dell'array
        int size = string.length();
        char[] c = new char[size];
       
        String content = "";
              
        
        
        for (int i = 0; i < size; i++) {
            c[i]=(char)string.charAt(i);
            System.out.println("Stonks : "+c[i]);
        }
        
        
        
        
        
        
        
        
        
        return "";
    }
    
    public void writeFile(String content){
        try {
            System.out.println("Im gonna do it");
            System.out.println("Path: "+p.getFileName());
            System.out.println("Content to save: "+content );
            Files.writeString(p, content);
        } catch (IOException ex) {
            System.out.println("An Error Occured");
        }
    }  
    
    
    
    
}
