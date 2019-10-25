
import java.awt.Point;
import java.awt.Polygon;
import java.nio.file.Path;
import java.util.ArrayList;
import java.io.*;
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
    
    
    
    
    
    
    
    /**
     * Esporta i dati ottenuti dall' array di poligoni per poi 
     * stamparli nella path p.
     * @param dataToSave Il dato da salvare
     * @param p Il percorso del file su cui si esporta il datoe.
     * @param fileName Il nome del file.
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
        e.writeFile();
        
        
    }
    
    
    
    
    public void setDataToSave(ArrayList<Polygon> dataToSave){
        this.dataToSave = dataToSave;
    }
    public void setPath(Path p){
        this.p = p;
    }
    public void setFileName(String fileName){
        this.fileName = fileName;
    }
    
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
     *
     * @return
     */
    public ArrayList<Integer>  getXFromPoints(){
        ArrayList<Integer> xList = new ArrayList<>();
        for (int i = 0; i < xList.size(); i++) {
            xList.add(this.PointsToSave.get(i).x);
        }
        
        return xList;
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Integer>  getYFromPoints(){
        ArrayList<Integer> yList = new ArrayList<>();
        for (int i = 0; i < yList.size(); i++) {
            yList.add(this.PointsToSave.get(i).y);
        }
        
        return yList;
    }
    
    
   
    
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
    
    public void writeFile(){
        System.out.println("GG scritto il file");
        
        
        try {
            File myObj = p.toFile();
            
            if (myObj.canWrite()) {
            
                FileWriter f = new FileWriter(myObj);
                System.out.println("Stonks");
                
                f.write("Ciao");
                
                
                System.out.println("File created: " + myObj.getName());
                System.out.println("File path: "+ myObj.getAbsolutePath());
                
            }else{
                
                System.out.println("File already exists.");
            }
    
        }
        catch (IOException e) {   
        System.out.println("An error occurred.");
        e.printStackTrace();
    }
    }
    
    
    
    
}
