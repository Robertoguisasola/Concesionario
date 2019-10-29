package ventanas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaLogin extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textoUsuario;
	private JPasswordField textoContrasenya;
	private JButton botonIniciar;
	private JButton botonRegistrar;
	
	public VentanaLogin() {
		getContentPane().setBackground(new Color(255, 255, 224));
		getContentPane().setLayout(null);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLogin.setBounds(200, 26, 46, 14);
		getContentPane().add(lblLogin);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsuario.setBounds(42, 78, 84, 14);
		getContentPane().add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblContrasea.setBounds(42, 124, 84, 14);
		getContentPane().add(lblContrasea);
		
		textoUsuario = new JTextField();
		textoUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		textoUsuario.setBounds(149, 75, 147, 20);
		getContentPane().add(textoUsuario);
		textoUsuario.setColumns(10);
		
		textoContrasenya = new JPasswordField();
		textoContrasenya.setHorizontalAlignment(SwingConstants.CENTER);
		textoContrasenya.setBounds(149, 121, 147, 20);
		getContentPane().add(textoContrasenya);
		
		botonIniciar = new JButton("Iniciar");
		botonIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		botonIniciar.setBounds(291, 177, 86, 23);
		getContentPane().add(botonIniciar);
		
		botonRegistrar = new JButton("Registrar nuevo usuario");
		botonRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		botonRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		botonRegistrar.setBounds(42, 177, 147, 23);
		getContentPane().add(botonRegistrar);
		
	}
}
