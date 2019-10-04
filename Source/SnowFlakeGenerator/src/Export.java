
import java.awt.Point;
import java.awt.Polygon;
import java.nio.file.Path;
import java.util.ArrayList;

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
    private ArrayList<Polygon> dataToSave;
    private Path p ;
    private String fileName;
    
    
    public Export(ArrayList<Polygon> dataToSave,Path p,String fileName){
        setDataToSave(dataToSave);
        setPath(p);
        setFileName(fileName);
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
    
   
    
    public String formatPoints(){
        int size = dataToSave.size();
        for (int i = 0; i < size; i++) {
            
        }
        return "";
    }
}
