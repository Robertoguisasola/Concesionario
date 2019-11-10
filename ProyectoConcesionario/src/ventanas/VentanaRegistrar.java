package ventanas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import model.Cliente;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class VentanaRegistrar extends JFrame {
	private JTextField textNombreLogin;
	private JTextField textContrasenya;
	private JTextField textRepetirContrasenya;
	private JTextField textEmail;
	private JTextField textDni;
	private JTextField textNombre;
	private JTextField textApellidos;
	private JTextField textFechaNacimiento;
	private JTextField textNumeroTarjeta;
	private static Connection conn;
	
	
	//TODO hacer un boton que tenga este metodo en el action listeners
	private void limpiarCajas() {
		textNombreLogin.setText(null);
		textContrasenya.setText(null);
		textEmail.setText(null);
		textDni.setText(null);
		textNombre.setText(null);
		textApellidos.setText(null);
		textFechaNacimiento.setText(null);
		textNumeroTarjeta.setText(null);
	}
	
	public VentanaRegistrar() {
		getContentPane().setBackground(new Color(255, 255, 224));
		getContentPane().setForeground(new Color(255, 255, 224));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{40, 96, 4, 154, 0};
		gridBagLayout.rowHeights = new int[]{14, 38, 20, 20, 20, 20, 20, 20, 20, 20, 20, 23, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblRegistrarCuenta = new JLabel("Registrar Cuenta");
		lblRegistrarCuenta.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblRegistrarCuenta = new GridBagConstraints();
		gbc_lblRegistrarCuenta.anchor = GridBagConstraints.WEST;
		gbc_lblRegistrarCuenta.fill = GridBagConstraints.VERTICAL;
		gbc_lblRegistrarCuenta.insets = new Insets(0, 0, 5, 0);
		gbc_lblRegistrarCuenta.gridwidth = 2;
		gbc_lblRegistrarCuenta.gridx = 2;
		gbc_lblRegistrarCuenta.gridy = 0;
		getContentPane().add(lblRegistrarCuenta, gbc_lblRegistrarCuenta);
		
		JLabel lblNombreDeLogin = new JLabel("Nombre de login:");
		GridBagConstraints gbc_lblNombreDeLogin = new GridBagConstraints();
		gbc_lblNombreDeLogin.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNombreDeLogin.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreDeLogin.gridx = 1;
		gbc_lblNombreDeLogin.gridy = 2;
		getContentPane().add(lblNombreDeLogin, gbc_lblNombreDeLogin);
		
		textNombreLogin = new JTextField();
		GridBagConstraints gbc_textNombreLogin = new GridBagConstraints();
		gbc_textNombreLogin.anchor = GridBagConstraints.NORTH;
		gbc_textNombreLogin.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNombreLogin.insets = new Insets(0, 0, 5, 0);
		gbc_textNombreLogin.gridx = 3;
		gbc_textNombreLogin.gridy = 2;
		getContentPane().add(textNombreLogin, gbc_textNombreLogin);
		textNombreLogin.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Contrase\u00F1a:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 3;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		textContrasenya = new JTextField();
		GridBagConstraints gbc_textContrasenya = new GridBagConstraints();
		gbc_textContrasenya.anchor = GridBagConstraints.NORTH;
		gbc_textContrasenya.fill = GridBagConstraints.HORIZONTAL;
		gbc_textContrasenya.insets = new Insets(0, 0, 5, 0);
		gbc_textContrasenya.gridx = 3;
		gbc_textContrasenya.gridy = 3;
		getContentPane().add(textContrasenya, gbc_textContrasenya);
		textContrasenya.setColumns(10);
		
		JLabel lblRepetirContrasea = new JLabel("Repetir contrase\u00F1a:");
		GridBagConstraints gbc_lblRepetirContrasea = new GridBagConstraints();
		gbc_lblRepetirContrasea.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblRepetirContrasea.insets = new Insets(0, 0, 5, 5);
		gbc_lblRepetirContrasea.gridwidth = 2;
		gbc_lblRepetirContrasea.gridx = 1;
		gbc_lblRepetirContrasea.gridy = 4;
		getContentPane().add(lblRepetirContrasea, gbc_lblRepetirContrasea);
		
		textRepetirContrasenya = new JTextField();
		GridBagConstraints gbc_textRepetirContrasenya = new GridBagConstraints();
		gbc_textRepetirContrasenya.anchor = GridBagConstraints.NORTH;
		gbc_textRepetirContrasenya.fill = GridBagConstraints.HORIZONTAL;
		gbc_textRepetirContrasenya.insets = new Insets(0, 0, 5, 0);
		gbc_textRepetirContrasenya.gridx = 3;
		gbc_textRepetirContrasenya.gridy = 4;
		getContentPane().add(textRepetirContrasenya, gbc_textRepetirContrasenya);
		textRepetirContrasenya.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.WEST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 5;
		getContentPane().add(lblEmail, gbc_lblEmail);
		
		textEmail = new JTextField();
		GridBagConstraints gbc_textEmail = new GridBagConstraints();
		gbc_textEmail.anchor = GridBagConstraints.NORTH;
		gbc_textEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textEmail.insets = new Insets(0, 0, 5, 0);
		gbc_textEmail.gridx = 3;
		gbc_textEmail.gridy = 5;
		getContentPane().add(textEmail, gbc_textEmail);
		textEmail.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Dni:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 6;
		getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textDni = new JTextField();
		GridBagConstraints gbc_textDni = new GridBagConstraints();
		gbc_textDni.anchor = GridBagConstraints.NORTH;
		gbc_textDni.fill = GridBagConstraints.HORIZONTAL;
		gbc_textDni.insets = new Insets(0, 0, 5, 0);
		gbc_textDni.gridx = 3;
		gbc_textDni.gridy = 6;
		getContentPane().add(textDni, gbc_textDni);
		textDni.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 7;
		getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textNombre = new JTextField();
		GridBagConstraints gbc_textNombre = new GridBagConstraints();
		gbc_textNombre.anchor = GridBagConstraints.NORTH;
		gbc_textNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNombre.insets = new Insets(0, 0, 5, 0);
		gbc_textNombre.gridx = 3;
		gbc_textNombre.gridy = 7;
		getContentPane().add(textNombre, gbc_textNombre);
		textNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		GridBagConstraints gbc_lblApellidos = new GridBagConstraints();
		gbc_lblApellidos.anchor = GridBagConstraints.WEST;
		gbc_lblApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellidos.gridx = 1;
		gbc_lblApellidos.gridy = 8;
		getContentPane().add(lblApellidos, gbc_lblApellidos);
		
		textApellidos = new JTextField();
		GridBagConstraints gbc_textApellidos = new GridBagConstraints();
		gbc_textApellidos.anchor = GridBagConstraints.NORTH;
		gbc_textApellidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_textApellidos.insets = new Insets(0, 0, 5, 0);
		gbc_textApellidos.gridx = 3;
		gbc_textApellidos.gridy = 8;
		getContentPane().add(textApellidos, gbc_textApellidos);
		textApellidos.setColumns(10);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha nacimiento:");
		GridBagConstraints gbc_lblFechaNacimiento = new GridBagConstraints();
		gbc_lblFechaNacimiento.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblFechaNacimiento.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaNacimiento.gridx = 1;
		gbc_lblFechaNacimiento.gridy = 9;
		getContentPane().add(lblFechaNacimiento, gbc_lblFechaNacimiento);
		
		textFechaNacimiento = new JTextField();
		GridBagConstraints gbc_textFechaNacimiento = new GridBagConstraints();
		gbc_textFechaNacimiento.anchor = GridBagConstraints.NORTH;
		gbc_textFechaNacimiento.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFechaNacimiento.insets = new Insets(0, 0, 5, 0);
		gbc_textFechaNacimiento.gridx = 3;
		gbc_textFechaNacimiento.gridy = 9;
		getContentPane().add(textFechaNacimiento, gbc_textFechaNacimiento);
		textFechaNacimiento.setColumns(10);
		
		JLabel lblNmeroDeTarjeta = new JLabel("N\u00FAmero de tarjeta:");
		GridBagConstraints gbc_lblNmeroDeTarjeta = new GridBagConstraints();
		gbc_lblNmeroDeTarjeta.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNmeroDeTarjeta.insets = new Insets(0, 0, 5, 5);
		gbc_lblNmeroDeTarjeta.gridx = 1;
		gbc_lblNmeroDeTarjeta.gridy = 10;
		getContentPane().add(lblNmeroDeTarjeta, gbc_lblNmeroDeTarjeta);
		
		textNumeroTarjeta = new JTextField();
		GridBagConstraints gbc_textNumeroTarjeta = new GridBagConstraints();
		gbc_textNumeroTarjeta.anchor = GridBagConstraints.NORTH;
		gbc_textNumeroTarjeta.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNumeroTarjeta.insets = new Insets(0, 0, 5, 0);
		gbc_textNumeroTarjeta.gridx = 3;
		gbc_textNumeroTarjeta.gridy = 10;
		getContentPane().add(textNumeroTarjeta, gbc_textNumeroTarjeta);
		textNumeroTarjeta.setColumns(10);
		
		JButton botonAceptar = new JButton("Aceptar");
		botonAceptar.addActionListener(new ActionListener() {
			
			
			
			public void actionPerformed(ActionEvent arg0) {
			}
		
		});
		GridBagConstraints gbc_botonAceptar = new GridBagConstraints();
		gbc_botonAceptar.anchor = GridBagConstraints.NORTH;
		gbc_botonAceptar.gridx = 3;
		gbc_botonAceptar.gridy = 11;
		getContentPane().add(botonAceptar, gbc_botonAceptar);
	}
}
