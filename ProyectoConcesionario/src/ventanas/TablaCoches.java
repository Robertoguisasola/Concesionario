package ventanas;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class TablaCoches extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TablaCoches() {
		this.setTitle("Tabla de coches");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(480,360);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		
		String[] columnas;
		
		this.setVisible(true);
	}
	
	//TODO borrar cuando funcione como queremos
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new TablaCoches();
			}
		});
	}
}
