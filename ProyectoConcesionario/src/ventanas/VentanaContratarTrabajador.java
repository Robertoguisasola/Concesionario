package ventanas;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;


import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.Trabajador;

public class VentanaContratarTrabajador extends JFrame{

	private JPanel formPanel;
	private Box formBox;
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
	private JTextField fechaNacimientoField;
	private Box fechaNacimientoBox;
	private JLabel sueldoLabel;
	private JTextField sueldoField;
	private Box sueldoBox;
	private JButton acceptButton;
	private JButton cancelButton;
	private Box buttonsBox;
	
	public VentanaContratarTrabajador(){
		
	this.setTitle("Contratar Trabajador");
	
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setSize(450,420);
	this.setResizable(true);
	
	formPanel = new JPanel();
	formPanel.setLayout(new GridBagLayout());
	
	buttonsPanel = new JPanel();
	buttonsPanel.setLayout(new GridBagLayout());
	
	usuarioLabel = new JLabel("Nombre de usuario: ");
	usuarioField = new JTextField(12);
	
	//TODO mover cajas vacias con windowBuilder para alinear todos los cuadros
	
	usuarioBox = new Box(BoxLayout.X_AXIS);
	usuarioBox.add(usuarioLabel);
	usuarioBox.add(Box.createRigidArea(new Dimension(46, 12)));
	usuarioBox.add(usuarioField);
	
	passwordLabel = new JLabel("Contrase�a: ");
	passwordField = new JPasswordField(12);
	
	passwordBox = new Box(BoxLayout.X_AXIS);
	passwordBox.add(passwordLabel);
	passwordBox.add(Box.createRigidArea(new Dimension(93, 12)));
	passwordBox.add(passwordField);
	
	passwordRLabel = new JLabel("Repita la contrase�a: ");
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

	//TODO cambiar a dia, mes a�o
	
	fechaNacimientoLabel= new JLabel("Fecha de nacimiento: ");
	fechaNacimientoField = new JTextField();
	
	fechaNacimientoBox = new Box(BoxLayout.X_AXIS);
	fechaNacimientoBox.add(fechaNacimientoLabel);
	fechaNacimientoBox.add(Box.createRigidArea(new Dimension(40,0)));
	fechaNacimientoBox.add(fechaNacimientoField);
	
	sueldoLabel = new JLabel("Sueldo: ");
	sueldoField = new JTextField();
	
	sueldoBox = new Box(BoxLayout.X_AXIS);
	sueldoBox.add(sueldoLabel);
	sueldoBox.add(Box.createRigidArea(new Dimension(40,0)));
	sueldoBox.add(sueldoField);
	
	formPanel = new JPanel();
	
	formBox = new Box(BoxLayout.Y_AXIS);
	formBox.add(usuarioBox);
	formBox.add(Box.createRigidArea(new Dimension(0,10)));
	formBox.add(passwordBox);
	formBox.add(Box.createRigidArea(new Dimension(0,10)));
	formBox.add(passwordRBox);
	formBox.add(Box.createRigidArea(new Dimension(0,10)));
	formBox.add(emailBox);
	formBox.add(Box.createRigidArea(new Dimension(0,10)));
	formBox.add(dniBox);
	formBox.add(Box.createRigidArea(new Dimension(0,10)));
	formBox.add(nombreBox);
	formBox.add(Box.createRigidArea(new Dimension(0,10)));
	formBox.add(apellidosBox);
	formBox.add(Box.createRigidArea(new Dimension(0,10)));
	formBox.add(fechaNacimientoBox);
	formBox.add(Box.createRigidArea(new Dimension(0,10)));
	formBox.add(sueldoBox);
	formBox.add(Box.createRigidArea(new Dimension(0,10)));

	formPanel.add(formBox);
	
	acceptButton = new JButton("Contratar Trabajador");
	acceptButton.addActionListener(new ActionListener(){
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent arg0) {
			Trabajador t= new Trabajador();
			t.setLogin(usuarioField.getText());
			t.setPassword(passwordField.getText());
			t.setEmail(emailField.getText());
			t.setdNI(dniField.getText());
			t.setNombre(nombreField.getText());
			t.setApellidos(apellidosField.getText());
			try {
				t.setFechaNacimientoString(fechaNacimientoField.getText());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			t.setSueldo(0);
			//A�ADIR TRABAJADOR A BASE DE DATOS
			//HAY QUE OBTENER EL SUELDO DE LOS DATOS
		}
		
	});
	
	cancelButton = new JButton("Cancelar");
	cancelButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			VentanaInicial menu = new VentanaInicial();
			menu.setVisible(true);
			menu.setSize(450,260);
			menu.setLocationRelativeTo(null);
			menu.setVisible(true);
			dispose();
		}
	});
	
	buttonsBox = new Box(BoxLayout.X_AXIS);
	buttonsBox.add(acceptButton);
	buttonsBox.add(Box.createRigidArea(new Dimension(40, 0)));
	buttonsBox.add(cancelButton);
	
	buttonsPanel.add(buttonsBox);
	
	getContentPane().add(formPanel, BorderLayout.CENTER);
	getContentPane().add(buttonsPanel, BorderLayout.SOUTH);
}}
