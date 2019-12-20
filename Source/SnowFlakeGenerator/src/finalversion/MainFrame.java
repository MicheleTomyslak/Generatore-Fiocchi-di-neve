
package finalversion;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Michele Tomyslak
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Costruttore del frame
     * param
     */
    public MainFrame(boolean b,String handle) {
        initComponents();
    }
    
    public MainFrame(){
        initComponents();
        snowFlakePanel.tp = trianglePanel;
        
    }
    
        
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        trianglePanel = new finalversion.TrianglePanel();
        xScreen = new javax.swing.JLabel();
        yScreen = new javax.swing.JLabel();
        snowFlakePanel = new finalversion.SnowFlakePanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        newFlake = new javax.swing.JMenuItem();
        openFlake = new javax.swing.JMenuItem();
        SaveFlakeMenu = new javax.swing.JMenuItem();
        exportAsSVGMenu = new javax.swing.JMenuItem();
        exportAsPNGMenu = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        resetMenuItem = new javax.swing.JMenuItem();
        Genera = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1280, 614));
        setMinimumSize(new java.awt.Dimension(1280, 614));
        setPreferredSize(new java.awt.Dimension(1280, 614));
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        xScreen.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                xScreenMouseMoved(evt);
            }
        });

        javax.swing.GroupLayout trianglePanelLayout = new javax.swing.GroupLayout(trianglePanel);
        trianglePanel.setLayout(trianglePanelLayout);
        trianglePanelLayout.setHorizontalGroup(
            trianglePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(trianglePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(trianglePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xScreen, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yScreen, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(483, Short.MAX_VALUE))
        );
        trianglePanelLayout.setVerticalGroup(
            trianglePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(trianglePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(xScreen, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(yScreen, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(686, Short.MAX_VALUE))
        );

        getContentPane().add(trianglePanel);

        javax.swing.GroupLayout snowFlakePanelLayout = new javax.swing.GroupLayout(snowFlakePanel);
        snowFlakePanel.setLayout(snowFlakePanelLayout);
        snowFlakePanelLayout.setHorizontalGroup(
            snowFlakePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 592, Short.MAX_VALUE)
        );
        snowFlakePanelLayout.setVerticalGroup(
            snowFlakePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 742, Short.MAX_VALUE)
        );

        getContentPane().add(snowFlakePanel);

        jMenu1.setText("File");

        newFlake.setText("Nuovo Fiocco");
        newFlake.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newFlakeActionPerformed(evt);
            }
        });
        jMenu1.add(newFlake);

        openFlake.setText("Apri Fiocco");
        openFlake.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFlakeActionPerformed(evt);
            }
        });
        jMenu1.add(openFlake);

        SaveFlakeMenu.setText("Salva");
        SaveFlakeMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveFlakeMenuActionPerformed(evt);
            }
        });
        jMenu1.add(SaveFlakeMenu);

        exportAsSVGMenu.setText("Esporta come SVG");
        exportAsSVGMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportAsSVGMenuActionPerformed(evt);
            }
        });
        jMenu1.add(exportAsSVGMenu);

        exportAsPNGMenu.setText("Esporta come PNG");
        exportAsPNGMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportAsPNGMenuActionPerformed(evt);
            }
        });
        jMenu1.add(exportAsPNGMenu);

        jMenuBar1.add(jMenu1);

        editMenu.setText("Edit");

        resetMenuItem.setText("Reset");
        resetMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(resetMenuItem);

        jMenuBar1.add(editMenu);

        Genera.setText("jMenu2");
        Genera.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GeneraMouseClicked(evt);
            }
        });
        jMenuBar1.add(Genera);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void trianglePanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trianglePanelMouseDragged
        snowFlakePanel.repaint();
    }//GEN-LAST:event_trianglePanelMouseDragged

    private void trianglePanelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trianglePanelMouseReleased
        snowFlakePanel.repaint();
        
    }//GEN-LAST:event_trianglePanelMouseReleased

    private void newFlakeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newFlakeActionPerformed
        if (!trianglePanel.points.isEmpty()) {
            Object[] options = {"Ok", "Annulla"};
            int response = JOptionPane.showOptionDialog(null,
                    "Sei sicuro di voler uscire senza salvare?", "Warning",
                    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
                    null, options, options[0]);
            if (JOptionPane.YES_OPTION == response) {
                MainFrame on = new MainFrame(false, "");
                this.dispose();
                on.setVisible(true);
            }
        } else {
            MainFrame on = new MainFrame(false, "");
            this.dispose();
            on.setVisible(true);
        }
    }//GEN-LAST:event_newFlakeActionPerformed

    private void openFlakeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFlakeActionPerformed
        JFileChooser jfc = new JFileChooser();
        FileNameExtensionFilter fnf = new FileNameExtensionFilter("punti per il fiocco di neve (*.snowserial)", "snowserial");
        jfc.setFileFilter(fnf);
        jfc.showDialog(null, "Open");
        try{
            String handle = new String(jfc.getSelectedFile().toString());
            MainFrame sfp = new MainFrame(true, handle);
            this.dispose();
            sfp.setVisible(true);
        }catch(NullPointerException npe){
            System.out.println("Closed");
        }
    }//GEN-LAST:event_openFlakeActionPerformed

    private void resetMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetMenuItemActionPerformed
        
        
            trianglePanel.poly.reset();
            trianglePanel.points.clear();
            trianglePanel.repaint();
            snowFlakePanel.repaint();
            trianglePanel.riempimentoColor = new Color(22, 152, 175);
            trianglePanel.strokeColor = Color.BLACK;
            snowFlakePanel.riempimentoColor = new Color(22, 152, 175);
            snowFlakePanel.borderColor = Color.BLACK;
            snowFlakePanel.tp = trianglePanel;
            
        
        
        snowFlakePanel.repaint();
    }//GEN-LAST:event_resetMenuItemActionPerformed

    private void exportAsSVGMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportAsSVGMenuActionPerformed
        JFileChooser jfc = new JFileChooser();
        FileNameExtensionFilter fnf = new FileNameExtensionFilter("SVG File (*.svg)", "SVG");
        jfc.setFileFilter(fnf);
        jfc.showDialog(null, "Save");
        try {
            String handle = new String(jfc.getSelectedFile().toPath().toString());
            snowFlakePanel.generaVettoriale(handle);
        } catch (NullPointerException npe) {
        }
    }//GEN-LAST:event_exportAsSVGMenuActionPerformed

    private void SaveFlakeMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveFlakeMenuActionPerformed
JFileChooser jfc = new JFileChooser();
        FileNameExtensionFilter fnf = new FileNameExtensionFilter("punti per il fiocco di neve (*.snowserial)", "snowserial");
        jfc.setFileFilter(fnf);
        jfc.showDialog(this, "Save");
        try {
            String handle = new String(jfc.getSelectedFile().toPath().toString());
            File handleFile = new File(handle);
            trianglePanel.serialize(handleFile);
        } catch (NullPointerException npe) {
            System.out.println("Closed");
        }
    }//GEN-LAST:event_SaveFlakeMenuActionPerformed

    private void exportAsPNGMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportAsPNGMenuActionPerformed
        JFileChooser jfc = new JFileChooser();
        FileNameExtensionFilter fnf = new FileNameExtensionFilter("PNG File (*.png)", "PNG");
        jfc.setFileFilter(fnf);
        jfc.showDialog(null, "Save");
        try {
            String handle = new String(jfc.getSelectedFile().toPath().toString());
            snowFlakePanel.generaImmaginePNG(handle, 600);
        } catch (NullPointerException npe) {
        }    }//GEN-LAST:event_exportAsPNGMenuActionPerformed

    private void xScreenMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_xScreenMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_xScreenMouseMoved

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        this.xScreen.setText("X: "+this.getWidth());
        this.yScreen.setText("Y: "+this.getHeight());
    }//GEN-LAST:event_formComponentResized

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        snowFlakePanel.repaint();
        System.out.println("Negro");
    }//GEN-LAST:event_formMouseClicked

    private void GeneraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GeneraMouseClicked
        snowFlakePanel.repaint();
    }//GEN-LAST:event_GeneraMouseClicked

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Genera;
    private javax.swing.JMenuItem SaveFlakeMenu;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exportAsPNGMenu;
    private javax.swing.JMenuItem exportAsSVGMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem newFlake;
    private javax.swing.JMenuItem openFlake;
    private javax.swing.JMenuItem resetMenuItem;
    private finalversion.SnowFlakePanel snowFlakePanel;
    private finalversion.TrianglePanel trianglePanel;
    private javax.swing.JLabel xScreen;
    private javax.swing.JLabel yScreen;
    // End of variables declaration//GEN-END:variables
    
}
