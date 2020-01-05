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
import javax.swing.JComboBox;
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
import model.Trabajador;

public class AnadirCoche extends JFrame {
	//TODO Poner los campos requeridos
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel camposPanel;
	private JLabel camposLabel;
	
	private JPanel formPanel;
	private Box formBox;
	private JPanel buttonsPanel;
	private JLabel marcaLabel;
	private JTextField marcaField;
	private Box marcaBox;
	private JLabel modeloLabel;
	private JTextField modeloField;
	private Box modeloBox;
	private JLabel colorLabel;
	private JComboBox<model.Colores> colorCombo;
	private Box colorBox;
	

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
	private JLabel numeroTarjetaLabel;
	private JTextField numeroTarjetaField;
	private Box numeroTarjetaBox;
	private JButton agregarButton;
	private JButton cancelarButton;
	private Box buttonsBox;
	
	public AnadirCoche(Trabajador t) {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(t.getNombre() + " " + t.getApellidos() + " añadiendo coche");
		
		camposPanel = new JPanel();
		
		String rellenar = "<html><body><center>Rellene todos los campos</center></body></html>";
		
		camposLabel = new JLabel(rellenar);
		camposPanel.add(camposLabel);
		
		getContentPane().add(camposPanel, BorderLayout.NORTH);
		
		formPanel = new JPanel();
		formPanel.setLayout(new GridBagLayout());
		
		buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new GridBagLayout());
		
		marcaLabel = new JLabel("Marca: ");
		marcaField = new JTextField();
			
		marcaBox = new Box(BoxLayout.X_AXIS);
		marcaBox.add(marcaLabel);
		marcaBox.add(Box.createRigidArea(new Dimension(46, 12)));
		marcaBox.add(marcaField);
		
		modeloLabel = new JLabel("Modelo: ");
		modeloField = new JPasswordField();
		
		modeloBox = new Box(BoxLayout.X_AXIS);
		modeloBox.add(modeloLabel);
		modeloBox.add(Box.createRigidArea(new Dimension(90, 12)));
		modeloBox.add(modeloField);
		
		colorLabel = new JLabel("Color: ");
		colorCombo = new JComboBox<model.Colores>();
		for(model.Colores color : model.Colores.values())
			colorCombo.addItem(color);
		
		colorBox = new Box(BoxLayout.X_AXIS);
		colorBox.add(colorLabel);
		colorBox.add(Box.createRigidArea(new Dimension(46, 12)));
		colorBox.add(colorCombo);
		
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
		fechaNacimientoBox.add(Box.createRigidArea(new Dimension(39,0)));
		fechaNacimientoBox.add(fechaNacimientoField);
		
		numeroTarjetaLabel = new JLabel("Número de tarjeta: ");
		numeroTarjetaField = new JTextField();
		
		numeroTarjetaBox = new Box(BoxLayout.X_AXIS);
		numeroTarjetaBox.add(numeroTarjetaLabel);
		numeroTarjetaBox.add(Box.createRigidArea(new Dimension(51, 12)));
		numeroTarjetaBox.add(numeroTarjetaField);
		
		formPanel = new JPanel();
		
		formBox = new Box(BoxLayout.Y_AXIS);
		formBox.add(marcaBox);
		formBox.add(Box.createRigidArea(new Dimension(0,10)));
		formBox.add(modeloBox);
		formBox.add(Box.createRigidArea(new Dimension(0,10)));
		formBox.add(colorBox);
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
		
		agregarButton = new JButton("Registrarme");
		agregarButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				registrar(t);
			}
		});
		
		cancelarButton = new JButton("Cancelar");
		cancelarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				volver(t);
			}
		});
		
		buttonsBox = new Box(BoxLayout.X_AXIS);
		buttonsBox.add(agregarButton);
		buttonsBox.add(Box.createRigidArea(new Dimension(40, 0)));
		buttonsBox.add(cancelarButton);
		
		buttonsPanel.add(buttonsBox);
		
		getContentPane().add(formPanel, BorderLayout.CENTER);
		getContentPane().add(buttonsPanel, BorderLayout.SOUTH);
	}
	
	private void volver(Trabajador t) {
		if (t == null) {
			Inicio.abrirInicio();
			dispose();
		} else {
			if (t.isAdmin()) {
				VistaAdministrador.abrirVistaAdministrador(t);
				dispose();
			} else {
				VistaTrabajador.abrirVistaTrabajador(t);
				dispose();
			}
		}
	}

	//TODO test
	private void limpiarCajas(Trabajador t) {
		marcaField.setText(null);
		modeloField.setText(null);
		emailField.setText(null);
		dniField.setText(null);
		nombreField.setText(null);
		apellidosField.setText(null);
		fechaNacimientoField.setText(null);
		numeroTarjetaField.setText(null);
	}
	
	//TODO test
	private void registrar(Trabajador t) {
		try {
			
			if (comprobarVacios()) {
				return;
			}
			
			//TODO zzzz comprobar vacíos y defaults.... ya sabes
			
			String fechaNacimientoString = fechaNacimientoField.getText();
			Date fechaNacimiento = Persona.df.parse(fechaNacimientoString);
			String marca = marcaField.getText();
			String modelo = new String(modeloField.getText());;
			String email = emailField.getText();
			String dNI = dniField.getText();
			String nombre = nombreField.getText();
			String apellidos = apellidosField.getText();
			long numTarjeta = Long.parseLong(numeroTarjetaField.getText());

			Cliente c = new Cliente(marca, modelo, email, dNI, nombre, apellidos, fechaNacimiento, numTarjeta);
			
			GestorBD bd = new GestorBD();
			bd.anadirNuevoCliente(c);
			bd.desconectar();
						
			String[] opciones = {"Sí", "No"};
			int respuesta = JOptionPane.showOptionDialog( null, "¿Desea registrar un nuevo cliente ?", "Borrar", JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);	
			
			switch (respuesta) {
			case 0:
				limpiarCajas(t);
				break;
			case 1:
				volver(t);
				dispose();
				break;
			default:
				break;
			}
		} 
		catch (ParseException ex) {
			JOptionPane.showMessageDialog(this, "Formato de fecha erroneo");
		} catch (NumberFormatException en) {
			JOptionPane.showMessageDialog(this, "Por favor, introduzca un número de tarjeta");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private boolean comprobarVacios() {
		if (marcaField.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Por favor, introduzca una marca para el coche");
			return true;
		}
		
		if (modeloField.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Por favor, introduzca una contraseña");
			return true;
		}
		
		if (fechaNacimientoField.getText().equals("") || fechaNacimientoField.getText().equals("dd/MM/yyyy")) {
			JOptionPane.showMessageDialog(this, "Por favor, introduzca su fecha de nacimiento");
			return true;	
		}
		
		return false;
	}
	
	public static void abrirAnadirCoche(Trabajador t) {
		AnadirCoche anadirCoche = new AnadirCoche(t);
		anadirCoche.setVisible(true);
		anadirCoche.setSize(480,360);
		anadirCoche.setLocationRelativeTo(null);
		anadirCoche.setVisible(true);
	}
	
	public static void main(String[] args) {
		Trabajador t = new Trabajador();
		
		AnadirCoche.abrirAnadirCoche(t);
	}
}