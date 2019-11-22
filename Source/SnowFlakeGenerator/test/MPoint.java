
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JComponent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tmich
 */
public class MPoint extends JButton {
    
    private int width=10;
    
    
    @Override
    public void paintComponent(Graphics g){
        g.fillOval(0, 0, width, width);
    }
    
    public MPoint(int width){
        if(width>1){
            this.width = width;
        }
        this.setVisible(true);
    }
    
}
