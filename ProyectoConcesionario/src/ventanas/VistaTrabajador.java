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

public class VistaTrabajador extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel opcionesPanel;
	private Box buttonsBox;
	private JButton anadirCocheButton;
	private JButton retirarCocheButton;
	private JButton cancelButton;
	
	public VistaTrabajador(Trabajador t) {
		//TODO titulo personalizado
		//this.setTitle("Bienvenido "+t.getNombre()+t.getApellidos());
		this.setTitle("Bienvenido");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(480,360);
		this.setResizable(true);
		
		opcionesPanel = new JPanel();
		opcionesPanel.setLayout(new GridBagLayout());
		
		anadirCocheButton = new JButton("Registrar coche");
		anadirCocheButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaAnadirCoche ventanaAnadirCoche = new VentanaAnadirCoche(t);
				ventanaAnadirCoche.setLocationRelativeTo(null);
				ventanaAnadirCoche.setVisible(true);
				dispose();
			}
		});
		
		retirarCocheButton = new JButton("Eliminar coche");
		retirarCocheButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaRetirarCoche ventanaRetirarCoche = new VentanaRetirarCoche(t);
				ventanaRetirarCoche.setLocationRelativeTo(null);
				ventanaRetirarCoche.setVisible(true);
				dispose();
			}
		});
		
		cancelButton = new JButton("Cancelar");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login ventanaLogin = new Login();
				ventanaLogin.setLocationRelativeTo(null);
				ventanaLogin.setVisible(true);
				dispose();
			}
		});
		
		buttonsBox = new Box(BoxLayout.Y_AXIS);
		buttonsBox.add(anadirCocheButton);
		buttonsBox.add(retirarCocheButton);
		buttonsBox.add(cancelButton);
				
		GridBagConstraints gbc_buttonsBox = new GridBagConstraints();
		gbc_buttonsBox.gridx = 0;
		opcionesPanel.add(buttonsBox, gbc_buttonsBox);
		
		getContentPane().add(opcionesPanel, BorderLayout.CENTER);
		
		this.setVisible(true);
	}
	

}
