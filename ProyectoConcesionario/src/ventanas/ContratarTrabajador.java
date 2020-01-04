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
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dataBase.GestorBD;
import model.Persona;
import model.Trabajador;

public class ContratarTrabajador extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	private JLabel adminLabel;
	private JCheckBox adminCheckBox;
	private Box adminBox;
	private JButton acceptButton;
	private JButton cancelButton;
	private Box buttonsBox;

	public ContratarTrabajador(Trabajador t){

		this.setTitle("Contratar trabajador");

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(480,360);
		this.setResizable(true);

		formPanel = new JPanel();
		formPanel.setLayout(new GridBagLayout());

		buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new GridBagLayout());

		usuarioLabel = new JLabel("Nombre de usuario: ");
		usuarioField = new JTextField(12);

		usuarioBox = new Box(BoxLayout.X_AXIS);
		usuarioBox.add(usuarioLabel);
		usuarioBox.add(Box.createRigidArea(new Dimension(46, 12)));
		usuarioBox.add(usuarioField);

		passwordLabel = new JLabel("Contrase�a: ");
		passwordField = new JPasswordField(12);

		passwordBox = new Box(BoxLayout.X_AXIS);
		passwordBox.add(passwordLabel);
		passwordBox.add(Box.createRigidArea(new Dimension(90, 12)));
		passwordBox.add(passwordField);

		passwordRLabel = new JLabel("Repita la contrase�a: ");
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
		fechaNacimientoField = new JTextField();
		fechaNacimientoField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fechaNacimientoField.setText("");
			}
		});
		fechaNacimientoField.setHorizontalAlignment(SwingConstants.CENTER);
		fechaNacimientoField.setText("dd/MM/yyyy");

		fechaNacimientoBox = new Box(BoxLayout.X_AXIS);
		fechaNacimientoBox.add(fechaNacimientoLabel);
		fechaNacimientoBox.add(Box.createRigidArea(new Dimension(37, 12)));
		fechaNacimientoBox.add(fechaNacimientoField);

		sueldoLabel = new JLabel("Sueldo: ");
		sueldoField = new JTextField();

		sueldoBox = new Box(BoxLayout.X_AXIS);
		sueldoBox.add(sueldoLabel);
		sueldoBox.add(Box.createRigidArea(new Dimension(116, 12)));
		sueldoBox.add(sueldoField);

		adminLabel = new JLabel("�Es administrador del concesionario?");
		adminCheckBox = new JCheckBox();

		adminBox = new Box(BoxLayout.X_AXIS);
		adminBox.add(adminLabel);
		adminBox.add(Box.createRigidArea(new Dimension(116, 12)));
		adminBox.add(adminCheckBox);

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
		formBox.add(adminBox);
		formBox.add(Box.createRigidArea(new Dimension(0,10)));

		formPanel.add(formBox);

		acceptButton = new JButton("Contratar");
		acceptButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				contratar();
			}

		});

		cancelButton = new JButton("Cancelar");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VistaAdministrador.abrirVistaAdministrador(t);
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


	//TODO test
	private void limpiarCajas() {
		usuarioField.setText(null);
		passwordField.setText(null);
		passwordRField.setText(null);
		emailField.setText(null);
		dniField.setText(null);
		nombreField.setText(null);
		apellidosField.setText(null);
		fechaNacimientoField.setText(null);
		sueldoField.setText(null);
		adminCheckBox.setEnabled(false);
	}
	
	//TODO test
	private void contratar() {
		try {
			
			if (comprobarVacios()) {
				return;
			}
			
			if (comprobarContrase�as()) {
				return;
			}
			
			//TODO zzzz comprobar vac�os y defaults.... ya sabes
			
			String fechaNacimientoString = fechaNacimientoField.getText();
			Date fechaNacimiento = Persona.df.parse(fechaNacimientoString);
			String usuario = usuarioField.getText();
			String contra = new String(passwordField.getPassword());;
			String email = emailField.getText();
			String dNI = dniField.getText();
			String nombre = nombreField.getText();
			String apellidos = apellidosField.getText();
			int sueldo = Integer.parseInt(sueldoField.getText());
			boolean isAdmin = adminBox.isEnabled();

			Trabajador t = new Trabajador(usuario, contra, email, dNI, nombre, apellidos, fechaNacimiento, sueldo, isAdmin);

			GestorBD bd = new GestorBD();
			bd.anadirNuevoTrabajador(t);
			bd.desconectar();
						
			String[] opciones = {"S�", "No"};
			int respuesta = JOptionPane.showOptionDialog( null, "�Desea contratar a un nuevo trabajador?", "Borrar", JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);	
			
			switch (respuesta) {
			case 0:
				limpiarCajas();
				break;
			case 1:
				VistaAdministrador.abrirVistaAdministrador(t);
				dispose();
				break;
			default:
				break;
			}
		} 
		catch (ParseException ex) {
			JOptionPane.showMessageDialog(this, "Formato de fecha erroneo");
		} catch (NumberFormatException en) {
			JOptionPane.showMessageDialog(this, "Por favor, introduzca el sueldo del trabajador correctamente");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private boolean comprobarVacios() {
		if (usuarioField.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Por favor, introduzca un nombre de usuario");
			return true;
		}
		
		if (new String(passwordField.getPassword()).equals("")) {
			JOptionPane.showMessageDialog(this, "Por favor, introduzca una contrase�a");
			return true;
		}
		
		if (emailField.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Por favor, introduzca el email de contacto del trabajador");
			return true;
		}
		
		if (dniField.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Por favor, introduzca el DNI del trabajador");
			return true;
		}
		
		if (nombreField.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Por favor, introduzca el nombre del trabajador");
			return true;
		}
		
		if (apellidosField.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Por favor, introduzca los apellidos");
			return true;	
		}
		
		if (fechaNacimientoField.getText().equals("") || fechaNacimientoField.getText().equals("dd/MM/yyyy")) {
			JOptionPane.showMessageDialog(this, "Por favor, introduzca la fecha de nacimiento");
			return true;	
		}
		
		if (sueldoField.getText().equals("") || sueldoField.getText().equals("0")) {
			JOptionPane.showMessageDialog(this, "Por favor, introduzca el sueldo del trabajador");
			return true;	
		}
		
		return false;
	}
	
	private boolean comprobarContrase�as() {
		String contra1 = new String(passwordField.getPassword());
		String contra2 = new String(passwordRField.getPassword());
		if (contra1.equals(contra2)) {
			return false;
		} else {
			JOptionPane.showMessageDialog(this, "Las contrase�as tienen que coincidir");
			return true;
		}
	}
	public static void abrirContratarTrabajador(Trabajador t) {
		ContratarTrabajador contratarTrabajador= new ContratarTrabajador(t);
		contratarTrabajador.setVisible(true);
		contratarTrabajador.setSize(480,400);
		contratarTrabajador.setLocationRelativeTo(null);
		contratarTrabajador.setVisible(true);
	}
	
	public static void main(String[] args) {
		Trabajador t = new Trabajador();
		t.setAdmin(true);
	
		ContratarTrabajador.abrirContratarTrabajador(t);
	}
}

