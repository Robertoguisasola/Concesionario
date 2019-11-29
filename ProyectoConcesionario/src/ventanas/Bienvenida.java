package ventanas;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Bienvenida extends JFrame {
	//TODO ventana de bienvenida, poner de fondo la foto y un mensaje de bienvenida

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Bienvenida() {
		this.setTitle("Bienvenida");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(480,360);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		
		try {
            Fondo fondo = new Fondo(ImageIO.read(new File("img/VolvoXC90.jpg")));
            JPanel panel = (JPanel) this.getContentPane();
            panel.setBorder(fondo);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
		
		this.setVisible(true);
	}

	
	//TODO eliminar main cuando funcione bien	
	public static void main(String[] args) {
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					new Bienvenida();				
				}
			});
	}
}
