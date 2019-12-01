package ventanas;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import java.awt.BorderLayout;

public class Bienvenida extends JFrame {
	//TODO ventana de bienvenida, poner de fondo la foto y un mensaje de bienvenida

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel panel;
	private Fondo fondo;
	private JLabel bienvenida;
	
	public Bienvenida() {
		this.setTitle("Bienvenida");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(480,360);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		
		try {
            fondo = new Fondo(ImageIO.read(new File("img/VolvoXC90.jpg")));
            panel = (JPanel) this.getContentPane();
            
            //TODO cambiar tamaño, color etc....
            bienvenida = new JLabel("Bienvenido a ");
            getContentPane().add(bienvenida, BorderLayout.CENTER);
            panel.setBorder(fondo);
        } catch (IOException ex) {
        	//TODO cambiar el JOptionPane por método Logger
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
