package ventanas;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Coche;

public class VentanaRetirarCoche extends JFrame {
	
	private JPanel opcionesPanel;
	private Box buttonsBox;
	private JLabel labelMatricula;
	private JTextField fieldMatricula;
	private JButton retirarCocheButton;
	
	public VentanaRetirarCoche() {
		//El trabajador es para poner Hola y el nombre en un punto de la ventana
		this.setTitle("Retirar coche");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(320, 240);
		this.setResizable(true);
		
		opcionesPanel = new JPanel();
		opcionesPanel.setLayout(new GridBagLayout());
		
		labelMatricula = new JLabel("Matricula: ");
		fieldMatricula = new JTextField();
		
		opcionesPanel.add(labelMatricula);
		opcionesPanel.add(fieldMatricula);
		
		buttonsBox = new Box(BoxLayout.Y_AXIS);
		retirarCocheButton = new JButton("Eliminar coche");
		retirarCocheButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String matriculaCoche=fieldMatricula.getText();
				//FALTA ELIMINAR EL COCHE DE LA BASE DE DATOS
			}
		});
		
		buttonsBox.add(retirarCocheButton);
				
		GridBagConstraints gbc_buttonsBox = new GridBagConstraints();
		gbc_buttonsBox.gridx = 0;
		opcionesPanel.add(buttonsBox, gbc_buttonsBox);
		
		getContentPane().add(opcionesPanel, BorderLayout.CENTER);
		
		this.setVisible(true);

	}
}
