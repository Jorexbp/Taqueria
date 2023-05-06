package Select;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Image extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String ruta;
	int ancho, alto;
	public Image(String path, int anchura, int altura) {
	this.ruta=path;
	this.ancho=anchura;	
	this.alto=altura;
	}
	public void paintComponent(Graphics g) {
		ImageIcon fondo = new ImageIcon(getClass().getResource(ruta));
		g.drawImage(fondo.getImage(), 0, 0, ancho, alto,null );
		super.paintComponent(g);
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
