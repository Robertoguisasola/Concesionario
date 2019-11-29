package ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.Date;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dataBase.GestorBD;
import model.Cliente;
import model.Persona;

public class RegistrarCuenta extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel bienvenidaPanel;
	private JLabel bienvenidaLabel;
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
	private JTextField fechaNacimietoField;
	private Box fechaNacimientoBox;
	private JLabel numeroTarjetaLabel;
	private JTextField numeroTarjetaField;
	private Box numeroTarjetaBox;
	private JButton acceptButton;
	private JButton cancelButton;
	private Box buttonsBox;
	
	
	//TODO Como poner que la ventan se ajuste al tamaño
	
	public RegistrarCuenta() {
		this.setTitle("Regístrate");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(450,420);
		this.setResizable(true);
		
		bienvenidaPanel = new JPanel();
		
		String bienvenida = "<html><body><center>BIENVENIDO AL CONCESIONARIO <br>Introduzca sus datos para registrarse</center></body></html>";
		
		bienvenidaLabel = new JLabel(bienvenida);
		bienvenidaPanel.add(bienvenidaLabel);
		
		getContentPane().add(bienvenidaPanel, BorderLayout.NORTH);
		
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
		
		passwordLabel = new JLabel("Contraseña: ");
		passwordField = new JPasswordField(12);
		
		passwordBox = new Box(BoxLayout.X_AXIS);
		passwordBox.add(passwordLabel);
		passwordBox.add(Box.createRigidArea(new Dimension(90, 12)));
		passwordBox.add(passwordField);
		
		passwordRLabel = new JLabel("Repita la contraseña: ");
		passwordRField = new JPasswordField(12);
		
		passwordRBox = new Box(BoxLayout.X_AXIS);
		passwordRBox.add(passwordRLabel);
		passwordRBox.add(Box.createRigidArea(new Dimension(38,0)));
		passwordRBox.add(passwordRField);
		
		emailLabel = new JLabel("Email: ");
		emailField = new JTextField();
		
		emailBox = new Box(BoxLayout.X_AXIS);
		emailBox.add(emailLabel);
		emailBox.add(Box.createRigidArea(new Dimension(124, 12)));
		emailBox.add(emailField);
		
		dniLabel = new JLabel("DNI: ");
		dniField = new JTextField(9);
		
		dniBox = new Box(BoxLayout.X_AXIS);
		dniBox.add(dniLabel);
		dniBox.add(Box.createRigidArea(new Dimension(135, 12)));
		dniBox.add(dniField);
		
		nombreLabel = new JLabel("Nombre: ");
		nombreField = new JTextField();
		
		nombreBox = new Box(BoxLayout.X_AXIS);
		nombreBox.add(nombreLabel);
		nombreBox.add(Box.createRigidArea(new Dimension(110, 12)));
		nombreBox.add(nombreField);

		apellidosLabel = new JLabel("Apellidos: ");
		apellidosField = new JTextField();

		apellidosBox = new Box(BoxLayout.X_AXIS);
		apellidosBox.add(apellidosLabel);
		apellidosBox.add(Box.createRigidArea(new Dimension(104, 12)));
		apellidosBox.add(apellidosField);
		
		fechaNacimientoLabel= new JLabel("Fecha de nacimiento: ");
		fechaNacimietoField = new JTextField();
		fechaNacimietoField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fechaNacimietoField.setText("");
			}
		});
		fechaNacimietoField.setHorizontalAlignment(SwingConstants.CENTER);
		fechaNacimietoField.setText("dd-MM-yyyy");
		
		fechaNacimientoBox = new Box(BoxLayout.X_AXIS);
		fechaNacimientoBox.add(fechaNacimientoLabel);
		fechaNacimientoBox.add(Box.createRigidArea(new Dimension(39,0)));
		fechaNacimientoBox.add(fechaNacimietoField);
		
		numeroTarjetaLabel = new JLabel("Número de tarjeta: ");
		numeroTarjetaField = new JTextField();
		
		numeroTarjetaBox = new Box(BoxLayout.X_AXIS);
		numeroTarjetaBox.add(numeroTarjetaLabel);
		numeroTarjetaBox.add(Box.createRigidArea(new Dimension(51, 12)));
		numeroTarjetaBox.add(numeroTarjetaField);
		
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
		formBox.add(numeroTarjetaBox);
		formBox.add(Box.createRigidArea(new Dimension(0,10)));

		formPanel.add(formBox);
		
		acceptButton = new JButton("Registrarme");
		acceptButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				registrar();
			}
			
		});
		
		cancelButton = new JButton("Cancelar");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Inicio menu = new Inicio();
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
	
	private void registrar() {
		try {
			String fechaNacimientoString = fechaNacimietoField.getText();
			Date fechaNacimiento = Persona.df.parse(fechaNacimientoString);
			GestorBD bd = new GestorBD();
			String usuario = usuarioField.getText();
			String contra = new String(passwordField.getPassword());
			String email = emailField.getText();
			String dNI = dniField.getText();
			String nombre = nombreField.getText();
			String apellidos = apellidosField.getText();
			long numTarjeta = 0;
			
			Cliente c = new Cliente(usuario, contra, email, dNI, nombre, apellidos, fechaNacimiento, numTarjeta);
			
			bd.anadirNuevoCliente(c);
			bd.desconectar();
			limpiarCajas();
			
		} 
		catch (ParseException ex) {
			JOptionPane.showMessageDialog(this, "Formato de fecha erroneo");
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("No conecta a la base de datos");
		}
	}
}
