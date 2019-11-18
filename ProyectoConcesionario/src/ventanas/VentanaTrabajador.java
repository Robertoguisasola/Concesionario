package ventanas;

import javax.swing.JFrame;

import model.Trabajador;

public class VentanaTrabajador extends JFrame{

	public VentanaTrabajador(Trabajador t) {
		//El trabajador es para poner Hola y el nombre en un punto de la ventana
		this.setTitle("Bienvenido "+t.getNombre()+" "+t.getApellidos());
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(320, 240);
		this.setResizable(true);
	}
	

}
