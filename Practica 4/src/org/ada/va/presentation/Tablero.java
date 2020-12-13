package org.ada.va.presentation;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Tablero extends JPanel implements ComponentListener , ActionListener {
	
	private static final long serialVersionUID = 2175262538976356263L;

	private JButton[][] mCasillas = null ;
    private int mNumeroDeFilas = 8 ;
    private int mNumeroDeColumnas = 8 ;
    private int mSeparacion = 2 ; 
    
    public void acomodar() {        
        int ancho = this.getWidth();       
        int alto = this.getHeight();        
        int dimensionMenor = Math.min( ancho , alto ); 
        int anchoDeCasilla = dimensionMenor / mNumeroDeColumnas ; 
        int altoDeCasilla = dimensionMenor / mNumeroDeFilas ;
        int xOffset = (ancho - dimensionMenor) / 2 ; 
        int yOffset = (alto - dimensionMenor) / 2 ; 
        
        for( int fila = 0 ; fila < mNumeroDeFilas ; fila ++ ) {
            for( int columna = 0 ; columna < mNumeroDeColumnas ; columna ++ ) {
                JButton temp = mCasillas[fila][columna] ;                            
                temp.setBounds(xOffset + columna * anchoDeCasilla, yOffset + fila * altoDeCasilla, anchoDeCasilla - mSeparacion, altoDeCasilla - mSeparacion );
            }
        }
    }
    
    public Tablero() {
        this.setBackground(Color.WHITE);
        this.addComponentListener(this);
        this.setLayout(null);                
        
    }

    public void setimage(int fila, int columna,ImageIcon a){
    	mCasillas[fila][columna].setIcon(a); 	
    }

    public void inicializar() {
        mCasillas = new JButton[mNumeroDeFilas][mNumeroDeColumnas];
        for( int fila = 0 ; fila < mNumeroDeFilas ; fila ++ ) {
            for( int columna = 0 ; columna < mNumeroDeColumnas ; columna ++ ) {
                JButton temp = new JButton();
                temp.addActionListener(this);                            
                mCasillas[fila][columna] = temp;                        
                this.add(temp);
            }
        }
    }

    public void componentResized(ComponentEvent e) {
        this.acomodar();
    }

    public void componentMoved(ComponentEvent e) {
    }

    public void componentShown(ComponentEvent e) {
    }

    public void componentHidden(ComponentEvent e) {
    }

    public void setNumeroDeFilas(int mNumeroDeFilas) {
        this.mNumeroDeFilas = mNumeroDeFilas;
    }

    public int getNumeroDeFilas() {
        return mNumeroDeFilas;
    }

    public void setNumeroDeColumnas(int mNumeroDeColumnas) {
        this.mNumeroDeColumnas = mNumeroDeColumnas;
    }

    public int getNumeroDeColumnas() {
        return mNumeroDeColumnas;
    }


    public void actionPerformed(ActionEvent e) {        
    }
}
