package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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

public class VentanaRegistrar extends JFrame {
	
	private JLabel bienvenidaLabel;
	private JPanel formPanel;
	private JPanel buttonsPanel;
	private JLabel usuarioLabel;
	private JTextField usuarioField;
	private Box usuarioBox;
	private JLabel passwordLabel;
	private JPasswordField passwordField;
	private Box passwordBox;
	private JLabel passwordRLabel;
	private JPasswordField passwordRField;
	private Box passwordRBox;
	private JLabel emailLabel;
	private JTextField emailField;
	private Box emailBox;
	private JLabel dniLabel;
	private JTextField dniField;
	private Box dniBox;
	private JLabel nombreLabel;
	private JTextField nombreField;
	private Box nombreBox;
	private JLabel apellidosLabel;
	private JTextField apellidosField;
	private Box apellidosBox;
	private JLabel fechaNacimientoLabel;
	private JTextField fechaNacimietoField;
	private Box fechaNacimientoBox;
	private JLabel numeroTarjetaLabel;
	private JTextField numeroTarjetaField;
	private Box numeroTarjetaBox;
	private JButton acceptButton;
	private JButton cancelButton;
	private Box buttonsBox;
	
	
	//TODO Terminar ventana, añadir las box al panel y los botones. Faltan las acciones también
	
	public VentanaRegistrar() {
		this.setTitle("Regístrate");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(320, 240);
		this.setResizable(true);
		
		bienvenidaLabel = new JLabel("BIENVENIDO AL CONCESIONARIO \nIntroduzca sus datos para registrarse");
		add(bienvenidaLabel, BorderLayout.NORTH);
		
		usuarioLabel = new JLabel("Nombre de usuario: ");
		usuarioField = new JTextField(12);
		
		usuarioBox = new Box(BoxLayout.X_AXIS);
		usuarioBox.add(usuarioLabel);
		usuarioBox.add(Box.createRigidArea(new Dimension(40,0)));
		usuarioBox.add(usuarioField);
		
		passwordLabel = new JLabel("Contraseña: ");
		passwordField = new JPasswordField(12);
		
		passwordBox = new Box(BoxLayout.X_AXIS);
		passwordBox.add(passwordLabel);
		passwordBox.add(Box.createRigidArea(new Dimension(40,0)));
		passwordBox.add(passwordField);
		
		passwordRLabel = new JLabel("Repita la contraseña: ");
		passwordRField = new JPasswordField(12);
		
		passwordRBox = new Box(BoxLayout.X_AXIS);
		passwordRBox.add(passwordRLabel);
		passwordRBox.add(Box.createRigidArea(new Dimension(40,0)));
		passwordRBox.add(passwordRField);
		
		emailLabel = new JLabel("Email: ");
		emailField = new JTextField();
		
		emailBox = new Box(BoxLayout.X_AXIS);
		emailBox.add(emailLabel);
		emailBox.add(Box.createRigidArea(new Dimension(40,0)));
		emailBox.add(emailField);
		
		dniLabel = new JLabel("DNI: ");
		dniField = new JTextField(9);
		
		dniBox = new Box(BoxLayout.X_AXIS);
		dniBox.add(dniLabel);
		dniBox.add(Box.createRigidArea(new Dimension(40,0)));
		dniBox.add(dniField);
		
		nombreLabel = new JLabel("Nombre: ");
		nombreField = new JTextField();
		
		nombreBox = new Box(BoxLayout.X_AXIS);
		nombreBox.add(nombreLabel);
		nombreBox.add(Box.createRigidArea(new Dimension(40,0)));
		nombreBox.add(nombreField);
		
		apellidosLabel = new JLabel("Apellidos: ");
		apellidosField = new JTextField();
		
	apellidosBox = new Box(BoxLayout.X_AXIS);
		apellidosBox.add(apellidosLabel);
		apellidosBox.add(Box.createRigidArea(new Dimension(40,0)));
		apellidosBox.add(apellidosField);
		
		//TODO cambiar a dia, mes año
		
		fechaNacimientoLabel= new JLabel("Fecha de nacimiento: ");
		fechaNacimietoField = new JTextField();
		
		fechaNacimientoBox = new Box(BoxLayout.X_AXIS);
		fechaNacimientoBox.add(fechaNacimientoLabel);
		fechaNacimientoBox.add(Box.createRigidArea(new Dimension(40,0)));
		fechaNacimientoBox.add(fechaNacimietoField);
		
		numeroTarjetaLabel = new JLabel("Número de tarjeta: ");
		numeroTarjetaField = new JTextField();
		
		numeroTarjetaBox = new Box(BoxLayout.X_AXIS);
		numeroTarjetaBox.add(numeroTarjetaLabel);
		numeroTarjetaBox.add(Box.createRigidArea(new Dimension(40,0)));
		numeroTarjetaBox.add(numeroTarjetaField);
		
	}
	
	private void limpiarCajas() {
		usuarioField.setText(null);
		passwordField.setText(null);
		passwordRField.setText(null);
		emailField.setText(null);
		dniField.setText(null);
		nombreField.setText(null);
		apellidosField.setText(null);
		fechaNacimietoField.setText(null);
		numeroTarjetaField.setText(null);
	}
}
