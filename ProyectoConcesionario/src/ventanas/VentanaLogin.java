package ventanas;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.sql.*;

import dataBase.GestorBD;


import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class VentanaLogin extends JFrame {

	private JTextField textoUsuario;
	private JPasswordField textoContrasenya;
	private JButton botonIniciar;
	private JButton botonRegistrar;
	
	public VentanaLogin() {
		
		getContentPane().setBackground(new Color(255, 255, 224));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{99, 0, 0, 0, 97, 0, 45, 86, 0, 0};
		gridBagLayout.rowHeights = new int[]{14, 0, 35, 20, 20, 36, 23, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblLogin = new GridBagConstraints();
		gbc_lblLogin.fill = GridBagConstraints.VERTICAL;
		gbc_lblLogin.insets = new Insets(0, 0, 5, 5);
		gbc_lblLogin.gridx = 4;
		gbc_lblLogin.gridy = 1;
		getContentPane().add(lblLogin, gbc_lblLogin);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 1;
		gbc_lblUsuario.gridy = 3;
		getContentPane().add(lblUsuario, gbc_lblUsuario);
		
		textoUsuario = new JTextField();
		textoUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_textoUsuario = new GridBagConstraints();
		gbc_textoUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_textoUsuario.anchor = GridBagConstraints.NORTH;
		gbc_textoUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_textoUsuario.gridwidth = 4;
		gbc_textoUsuario.gridx = 3;
		gbc_textoUsuario.gridy = 3;
		getContentPane().add(textoUsuario, gbc_textoUsuario);
		textoUsuario.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblContrasea = new GridBagConstraints();
		gbc_lblContrasea.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblContrasea.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasea.gridx = 1;
		gbc_lblContrasea.gridy = 5;
		getContentPane().add(lblContrasea, gbc_lblContrasea);
		
		textoContrasenya = new JPasswordField();
		textoContrasenya.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_textoContrasenya = new GridBagConstraints();
		gbc_textoContrasenya.anchor = GridBagConstraints.NORTH;
		gbc_textoContrasenya.fill = GridBagConstraints.HORIZONTAL;
		gbc_textoContrasenya.insets = new Insets(0, 0, 5, 5);
		gbc_textoContrasenya.gridwidth = 4;
		gbc_textoContrasenya.gridx = 3;
		gbc_textoContrasenya.gridy = 5;
		getContentPane().add(textoContrasenya, gbc_textoContrasenya);
		
		botonRegistrar = new JButton("Registrar nuevo usuario");
		botonRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*VentanaRegistrar ventanaRegistrar = new VentanaRegistrar();
				ventanaRegistrar.setVisible(true);
				ventanaRegistrar.setSize(450,560);
				ventanaRegistrar.setLocationRelativeTo(null);
				
				dispose();
				*/
				
			}
		});
		botonRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_botonRegistrar = new GridBagConstraints();
		gbc_botonRegistrar.anchor = GridBagConstraints.NORTH;
		gbc_botonRegistrar.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonRegistrar.insets = new Insets(0, 0, 5, 5);
		gbc_botonRegistrar.gridwidth = 3;
		gbc_botonRegistrar.gridx = 1;
		gbc_botonRegistrar.gridy = 7;
		getContentPane().add(botonRegistrar, gbc_botonRegistrar);
		
		botonIniciar = new JButton("Iniciar");
		botonIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO iniciar sesión con los métodos de la BBDD
				try {
					GestorBD bd = new GestorBD();
					String usuario = textoUsuario.getText();
					String contra = new String(textoContrasenya.getPassword());
					
					if (bd.iniciarSesionCliente(usuario, contra)) {
						//TODO lanza ventana de cliente
					}else if (bd.iniciarSesionTrabajador(usuario, contra)) {
						//TODO lanza ventana de trabajadores
					}else if (usuario.equals("admin")&& contra.equals("1234")) {
						//TODO lanza ventana de administrador
					}
					bd.desconectar();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		GridBagConstraints gbc_botonIniciar = new GridBagConstraints();
		gbc_botonIniciar.insets = new Insets(0, 0, 5, 5);
		gbc_botonIniciar.anchor = GridBagConstraints.NORTH;
		gbc_botonIniciar.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonIniciar.gridx = 5;
		gbc_botonIniciar.gridy = 7;
		getContentPane().add(botonIniciar, gbc_botonIniciar);
		
	}
}
