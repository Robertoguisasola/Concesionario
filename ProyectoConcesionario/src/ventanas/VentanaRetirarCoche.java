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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Trabajador;

public class VentanaRetirarCoche extends JFrame {
	//TODO eliminar y convertir en tabla
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel opcionesPanel;
	private Box buttonsBox;
	private JLabel labelMatricula;
	private JTextField fieldMatricula;
	private JButton retirarCocheButton;
	private JButton cancelButton;
	
	public VentanaRetirarCoche(Trabajador t) {
		//TODO que muestre un titulo personalizado para el trabajador
		//this.setTitle(t.getNombre()+" "+t.getApellidos()+", retire un coche a la base de datos");
		this.setTitle("Retirar coche");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(320, 240);
		this.setResizable(true);
		
		opcionesPanel = new JPanel();
		opcionesPanel.setLayout(new GridBagLayout());
		
		labelMatricula = new JLabel("Matricula: ");
		fieldMatricula = new JTextField(12);
		
		opcionesPanel.add(labelMatricula);
		opcionesPanel.add(fieldMatricula);
		
		buttonsBox = new Box(BoxLayout.Y_AXIS);
		retirarCocheButton = new JButton("Eliminar coche");
		retirarCocheButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String matriculaCoche=fieldMatricula.getText();
				//TODO FALTA ELIMINAR EL COCHE DE LA BASE DE DATOS
			}
		});
		
		cancelButton= new JButton("Cancelar");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaTrabajador ventanaTrabajador= new VistaTrabajador(t);
				ventanaTrabajador.setLocationRelativeTo(null);
				ventanaTrabajador.setVisible(true);
				dispose();
			}

		});
		
		
		buttonsBox.add(retirarCocheButton);
		buttonsBox.add(cancelButton);
		
		GridBagConstraints gbc_buttonsBox = new GridBagConstraints();
		gbc_buttonsBox.gridx = 0;
		opcionesPanel.add(buttonsBox, gbc_buttonsBox);
		
		getContentPane().add(opcionesPanel, BorderLayout.CENTER);
		
		this.setVisible(true);

	}
}
