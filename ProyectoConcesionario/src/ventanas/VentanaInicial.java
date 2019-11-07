package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dataBase.GestorBD;

public class VentanaInicial extends JFrame {
	//TODO enlazar ventana como principal
	
	private JPanel opcionesPanel;
	private Box buttonsBox;
	private JButton iniciarSesionButton;
	private JButton registrarCuentaButton;
	
	public VentanaInicial(){
		this.setTitle("Inicio");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(320, 240);
		this.setResizable(true);
		
		opcionesPanel = new JPanel();
		opcionesPanel.setLayout(new GridBagLayout());
		
		buttonsBox = new Box(BoxLayout.Y_AXIS);
		iniciarSesionButton = new JButton("Iniciar sesión");
		registrarCuentaButton = new JButton("Registrar cuenta");
		
		buttonsBox.add(iniciarSesionButton);
		buttonsBox.add(Box.createRigidArea(new Dimension(0,40)));
		buttonsBox.add(registrarCuentaButton);
				
		opcionesPanel.add(buttonsBox);
		
		getContentPane().add(opcionesPanel, BorderLayout.CENTER);
		
		this.setVisible(true);
	}
}
