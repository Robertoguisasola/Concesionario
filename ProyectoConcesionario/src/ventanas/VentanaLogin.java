package ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
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

import dataBase.GestorBD;
import java.awt.Color;

public class VentanaLogin extends JFrame {
	
	private JPanel formPanel;
	private JLabel loginLabel;
	private JTextField loginField;
	private Box loginBox;
	private JLabel passwordLabel;
	private JPasswordField passwordField;
	private Box passwordBox;
	private Box formBox;
	private JPanel buttonsPanel;
	private Box buttonsBox;
	private JButton acceptButton;
	private JButton cancelButton;
	private JLabel falloInicio;
	
	public VentanaLogin(){
		this.setTitle("Login");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(320, 240);
		this.setResizable(true);
		
		formPanel = new JPanel();
		formPanel.setLayout(new GridBagLayout());
		
		loginLabel = new JLabel("Login");
		loginField = new JTextField(12);
		
		loginBox = new Box(BoxLayout.X_AXIS);
		loginBox.add(loginLabel);
		loginBox.add(Box.createRigidArea(new Dimension(40,0)));
		loginBox.add(loginField);
		
		passwordLabel = new JLabel("Password");
		passwordField = new JPasswordField(12);
		
		passwordBox = new Box(BoxLayout.X_AXIS);
		passwordBox.add(passwordLabel);
		passwordBox.add(Box.createRigidArea(new Dimension(10,0)));
		passwordBox.add(passwordField);
		
		falloInicio = new JLabel("Usuario o contraseña incorrecta");
		falloInicio.setForeground(Color.RED);
		falloInicio.setVisible(false);
		
		formBox = new Box(BoxLayout.Y_AXIS);
		formBox.add(loginBox);
		formBox.add(Box.createRigidArea(new Dimension(0,20)));
		formBox.add(passwordBox);
		formBox.add(falloInicio);
		
		formPanel.add(formBox);
		
		buttonsPanel = new JPanel();
		
		buttonsBox = new Box(BoxLayout.X_AXIS);
		cancelButton = new JButton("Cancelar");
		acceptButton = new JButton("Aceptar");
		buttonsPanel.add(acceptButton);
		
		acceptButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO que deje intentar de nuevo en caso de fallo en el inicio de sesión
				try {
					GestorBD bd = new GestorBD();
					String usuario = loginLabel.getText();
					String contra = new String(passwordField.getPassword());
					
					if (bd.iniciarSesionCliente(usuario, contra)) {
						//TODO lanza ventana de cliente
					}else if (bd.iniciarSesionTrabajador(usuario, contra)) {
						//TODO lanza ventana de trabajadores
					}else if (usuario.equals("admin")&& contra.equals("1234")) {
						//TODO lanza ventana de administrador
					}else {
						falloInicio.setVisible(true);
					}
					bd.desconectar();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		buttonsBox.add(Box.createRigidArea(new Dimension(10,0)));
		buttonsBox.add(cancelButton);
				
		buttonsPanel.add(buttonsBox);
		
		getContentPane().add(formPanel, BorderLayout.CENTER);
		getContentPane().add(buttonsPanel,BorderLayout.SOUTH);
		
		this.setVisible(true);
	}
}
