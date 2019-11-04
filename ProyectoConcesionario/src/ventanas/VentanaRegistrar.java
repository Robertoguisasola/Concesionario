package ventanas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

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

	public VentanaRegistrar() {
		getContentPane().setBackground(new Color(255, 255, 224));
		getContentPane().setForeground(new Color(255, 255, 224));
		getContentPane().setLayout(null);
		
		JLabel lblRegistrarCuenta = new JLabel("Registrar Cuenta");
		lblRegistrarCuenta.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRegistrarCuenta.setBounds(142, 21, 137, 14);
		getContentPane().add(lblRegistrarCuenta);
		
		JLabel lblNombreDeLogin = new JLabel("Nombre de login:");
		lblNombreDeLogin.setBounds(41, 76, 95, 14);
		getContentPane().add(lblNombreDeLogin);
		
		JLabel lblNewLabel = new JLabel("Contrase\u00F1a:");
		lblNewLabel.setBounds(41, 101, 79, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblRepetirContrasea = new JLabel("Repetir contrase\u00F1a:");
		lblRepetirContrasea.setBounds(40, 126, 106, 14);
		getContentPane().add(lblRepetirContrasea);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(41, 151, 46, 14);
		getContentPane().add(lblEmail);
		
		JLabel lblNewLabel_1 = new JLabel("Dni:");
		lblNewLabel_1.setBounds(41, 176, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		lblNewLabel_2.setBounds(41, 201, 46, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(41, 226, 60, 14);
		getContentPane().add(lblApellidos);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha nacimiento:");
		lblFechaNacimiento.setBounds(41, 250, 95, 14);
		getContentPane().add(lblFechaNacimiento);
		
		JLabel lblNmeroDeTarjeta = new JLabel("N\u00FAmero de tarjeta:");
		lblNmeroDeTarjeta.setBounds(41, 275, 95, 14);
		getContentPane().add(lblNmeroDeTarjeta);
		
		textNombreLogin = new JTextField();
		textNombreLogin.setBounds(170, 73, 154, 20);
		getContentPane().add(textNombreLogin);
		textNombreLogin.setColumns(10);
		
		textContrasenya = new JTextField();
		textContrasenya.setBounds(170, 98, 154, 20);
		getContentPane().add(textContrasenya);
		textContrasenya.setColumns(10);
		
		textRepetirContrasenya = new JTextField();
		textRepetirContrasenya.setBounds(170, 123, 154, 20);
		getContentPane().add(textRepetirContrasenya);
		textRepetirContrasenya.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setBounds(170, 148, 154, 20);
		getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		textDni = new JTextField();
		textDni.setBounds(170, 173, 154, 20);
		getContentPane().add(textDni);
		textDni.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setBounds(170, 198, 154, 20);
		getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		textApellidos = new JTextField();
		textApellidos.setBounds(170, 223, 154, 20);
		getContentPane().add(textApellidos);
		textApellidos.setColumns(10);
		
		textFechaNacimiento = new JTextField();
		textFechaNacimiento.setBounds(170, 247, 154, 20);
		getContentPane().add(textFechaNacimiento);
		textFechaNacimiento.setColumns(10);
		
		textNumeroTarjeta = new JTextField();
		textNumeroTarjeta.setBounds(170, 272, 154, 20);
		getContentPane().add(textNumeroTarjeta);
		textNumeroTarjeta.setColumns(10);
		
		JButton botonAceptar = new JButton("Aceptar");
		botonAceptar.setBounds(204, 303, 89, 23);
		getContentPane().add(botonAceptar);
	}
}
