package org.ada.va.presentation;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MainFrame extends JFrame {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Tablero mTablero = new Tablero();
	private int fil,colu;
	
	private static final String ICON_NAME = "Reina.gif"; 
    
    public MainFrame(int n, int p, String title) {
    	setTitle(title);
    	fil=n;
    	colu=p;
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        
        this.setLayout(new BorderLayout());
        this.setSize( new Dimension(400, 300) );
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.add(mTablero, BorderLayout.CENTER );
                    
        mTablero.setNumeroDeColumnas(colu);
        mTablero.setNumeroDeFilas(fil);
        
        mTablero.inicializar();
                
    }
    
    public void loadData(Integer[] data) {
    	for (int i = 0; i < data.length; i++) {
    		setImage(i, data[i], new ImageIcon(getClass().getClassLoader().getResource(ICON_NAME)));
    	}
    }
    
    
    public void setImage(int x, int y, ImageIcon a){
    	mTablero.setimage(x, y, a);
    }
}
