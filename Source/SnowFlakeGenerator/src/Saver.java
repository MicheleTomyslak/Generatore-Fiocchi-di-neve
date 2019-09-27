
import java.nio.file.Path;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tmich
 */
public class Saver {
    private Path p;
    private String formato;
    private String nomeFiocco;
    public Saver(Path p){
        
    }
    public Saver(Path p,String formato){
        
    }
    public Saver(Path p,String formato,String nome){
        
    }
    
    
    
    public void setNomeFiocco(String nomeFiocco){
        this.nomeFiocco = nomeFiocco;
    }
    public String getNomeFiocco(){
        return this.nomeFiocco;
    }
    
    
    public void setFormato(String formato){
        this.formato = formato;
    }
    public String getFormato(){
        return this.formato;
    }
    
    
    
    
    
}
