package ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dataBase.GestorBD;
import model.Colores;
import model.Moto2;
import model.Trabajador;

public class AnadirMoto2 extends JFrame {

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
	private JLabel caballosLabel;
	private JTextField caballosField;
	private Box caballosBox;
	private JLabel nRuedasLabel;
	private JTextField nRuedasField;
	private Box nRuedasBox;
	private JLabel nPlazasLabel;
	private JTextField nPlazasField;
	private Box nPlazasBox;
	private JLabel precioLabel;
	private JTextField precioField;
	private Box precioBox;
	private JCheckBox estructuraProtectoraCheck;
	private JLabel kilometrosLabel;
	private JTextField kilometrosField;
	private Box kilometrosBox;

	private JButton agregarButton;
	private JButton cancelarButton;
	private Box buttonsBox;

	public AnadirMoto2(Trabajador t) {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(t.getNombre() + " " + t.getApellidos() + " añadiendo moto de segunda mano");

		camposPanel = new JPanel();

		String rellenar = "<html><body><center>Rellene todos los campos</center></body></html>";

		camposLabel = new JLabel(rellenar);
		camposPanel.add(camposLabel);

		getContentPane().add(camposPanel, BorderLayout.NORTH);

		formPanel = new JPanel();
		formPanel.setLayout(new GridBagLayout());

		buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new GridBagLayout());

		marcaLabel = new JLabel("Marca:");
		marcaField = new JTextField();

		marcaBox = new Box(BoxLayout.X_AXIS);
		marcaBox.add(marcaLabel);
		marcaBox.add(Box.createRigidArea(new Dimension(38, 12)));
		marcaBox.add(marcaField);

		modeloLabel = new JLabel("Modelo:");
		modeloField = new JTextField();

		modeloBox = new Box(BoxLayout.X_AXIS);
		modeloBox.add(modeloLabel);
		modeloBox.add(Box.createRigidArea(new Dimension(33, 12)));
		modeloBox.add(modeloField);

		colorLabel = new JLabel("Color:");
		colorCombo = new JComboBox<model.Colores>();
		for(model.Colores color : model.Colores.values())
			colorCombo.addItem(color);

		colorBox = new Box(BoxLayout.X_AXIS);
		colorBox.add(colorLabel);
		colorBox.add(Box.createRigidArea(new Dimension(44, 12)));
		colorBox.add(colorCombo);

		caballosLabel = new JLabel("Caballos:");
		caballosField = new JTextField();

		caballosBox = new Box(BoxLayout.X_AXIS);
		caballosBox.add(caballosLabel);
		caballosBox.add(Box.createRigidArea(new Dimension(25, 12)));
		caballosBox.add(caballosField);

		nRuedasLabel = new JLabel("Número de ruedas:");
		nRuedasField = new JTextField();
		nRuedasField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nRuedasField.setText("");
			}
		});
		nRuedasField.setHorizontalAlignment(SwingConstants.CENTER);
		nRuedasField.setText("4");

		nRuedasBox = new Box(BoxLayout.X_AXIS);
		nRuedasBox.add(nRuedasLabel);
		nRuedasBox.add(Box.createRigidArea(new Dimension(28, 12)));
		nRuedasBox.add(nRuedasField);

		nPlazasLabel = new JLabel("Número de plazas:");
		nPlazasField = new JTextField();

		nPlazasBox = new Box(BoxLayout.X_AXIS);
		nPlazasBox.add(nPlazasLabel);
		nPlazasBox.add(Box.createRigidArea(new Dimension(31, 12)));
		nPlazasBox.add(nPlazasField);

		precioLabel = new JLabel("Precio:");
		precioField = new JTextField();

		precioBox = new Box(BoxLayout.X_AXIS);
		precioBox.add(precioLabel);
		precioBox.add(Box.createRigidArea(new Dimension(38, 12)));
		precioBox.add(precioField);

		estructuraProtectoraCheck = new JCheckBox("Estructura protectora");

		kilometrosLabel = new JLabel("Kilómetros:");
		kilometrosField = new JTextField();

		kilometrosBox = new Box(BoxLayout.X_AXIS);
		kilometrosBox.add(kilometrosLabel);
		kilometrosBox.add(Box.createRigidArea(new Dimension(14, 12)));
		kilometrosBox.add(kilometrosField);

		formPanel = new JPanel();

		formBox = new Box(BoxLayout.Y_AXIS);
		formBox.add(marcaBox);
		formBox.add(Box.createRigidArea(new Dimension(0,10)));
		formBox.add(modeloBox);
		formBox.add(Box.createRigidArea(new Dimension(0,10)));
		formBox.add(colorBox);
		formBox.add(Box.createRigidArea(new Dimension(0,10)));
		formBox.add(caballosBox);
		formBox.add(Box.createRigidArea(new Dimension(0,10)));
		formBox.add(nRuedasBox);
		formBox.add(Box.createRigidArea(new Dimension(0,10)));
		formBox.add(nPlazasBox);
		formBox.add(Box.createRigidArea(new Dimension(0,10)));
		formBox.add(precioBox);
		formBox.add(Box.createRigidArea(new Dimension(0,10)));
		formBox.add(estructuraProtectoraCheck);
		formBox.add(Box.createRigidArea(new Dimension(0,10)));
		formBox.add(kilometrosBox);

		formPanel.add(formBox);

		agregarButton = new JButton("Añadir moto de segunda mano");
		agregarButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				anadirMoto2(t);
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
		if (t.isAdmin()) {
			VistaAdministrador.abrirVistaAdministrador(t);
			dispose();
		} else {
			VistaTrabajador.abrirVistaTrabajador(t);
			dispose();
		}
	}

	private void limpiarCajas(Trabajador t) {
		marcaField.setText(null);
		modeloField.setText(null);
		caballosField.setText(null);
		nRuedasField.setText(null);
		nPlazasField.setText("4");
		precioField.setText(null);
		kilometrosField.setText(null);
	}

	private void anadirMoto2(Trabajador t) {

		if (comprobarVacios()) {
			return;
		}

		String marca = marcaField.getText();
		String modelo = new String(modeloField.getText());
		Colores color = Colores.valueOf(colorCombo.getSelectedItem().toString());
		int caballos = Integer.parseInt(caballosField.getText());
		int nRuedas = Integer.parseInt(nRuedasField.getText());
		int nPlazas = Integer.parseInt(nPlazasField.getText());
		int precio = Integer.parseInt(precioField.getText());
		boolean estructuraProtectora = estructuraProtectoraCheck.isSelected();
		int kilometros = Integer.parseInt(kilometrosField.getText());

		Moto2 m = new Moto2(marca, modelo, color, caballos, nRuedas, nPlazas, precio, estructuraProtectora, kilometros);

		GestorBD bd = new GestorBD();
		bd.anadirNuevaMoto2(m);
		bd.desconectar();

		String[] opciones = {"Sí", "No"};
		int respuesta = JOptionPane.showOptionDialog( null, "¿Desea añadir otra nueva moto de segunda mano?", "Añadir otra moto", JOptionPane.YES_NO_CANCEL_OPTION,
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

	private boolean comprobarVacios() {
		if (marcaField.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Por favor, introduzca la marca de la moto");
			return true;
		}

		if (modeloField.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Por favor, introduzca el modelo de la moto");
			return true;
		}

		if (caballosField.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Por favor, introduzca los caballos de la moto");
			return true;
		}

		if (nRuedasField.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Por favor, introduzca las ruedas de la moto");
			return true;
		}

		if (nPlazasField.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Por favor, introduzca las plazas de la moto");
			return true;
		}


		if (precioField.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Por favor, introduzca el precio de la moto");
			return true;
		}

		if (kilometrosField.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Por favor, introduzca los kilometros de la moto");
			return true;
		}

		return false;
	}

	public static void abrirAnadirMoto2(Trabajador t) {
		AnadirMoto2 anadirMoto2= new AnadirMoto2(t);
		anadirMoto2.setSize(480, 400);
		anadirMoto2.setLocationRelativeTo(null);
		anadirMoto2.setVisible(true);
	}
}