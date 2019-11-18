package ventanas;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Trabajador;

public class VentanaTrabajador extends JFrame{

	private JPanel opcionesPanel;
	private Box buttonsBox;
	private JButton anadirCocheButton;
	
	public VentanaTrabajador(Trabajador t) {
		//El trabajador es para poner Hola y el nombre en un punto de la ventana
		this.setTitle("Bienvenido "+t.getNombre()+" "+t.getApellidos());
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(320, 240);
		this.setResizable(true);
		
		opcionesPanel = new JPanel();
		opcionesPanel.setLayout(new GridBagLayout());
		
		buttonsBox = new Box(BoxLayout.Y_AXIS);
		anadirCocheButton = new JButton("Registrar coche");
		anadirCocheButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaAnadirCoche ventanaAnadirCoche = new VentanaAnadirCoche();
				ventanaAnadirCoche.setLocationRelativeTo(null);
				ventanaAnadirCoche.setVisible(true);
				dispose();
			}
		});
		
		buttonsBox.add(anadirCocheButton);
				
		GridBagConstraints gbc_buttonsBox = new GridBagConstraints();
		gbc_buttonsBox.gridx = 0;
		opcionesPanel.add(buttonsBox, gbc_buttonsBox);
		
		getContentPane().add(opcionesPanel, BorderLayout.CENTER);
		
		this.setVisible(true);
	}
	

}
