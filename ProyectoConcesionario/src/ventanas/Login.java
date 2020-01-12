package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dataBase.GestorBD;
import model.Cliente;
import model.Trabajador;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//NO TOCAR
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

	public Login(){
		this.setTitle("Login");

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(480,360);
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
		passwordField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				int tecla = e.getKeyCode();
				if(tecla == 10 ) {
					iniciarSesion();
				}
			}
		});

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
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				volver();
			}
		});

		acceptButton = new JButton("Aceptar");
		buttonsPanel.add(acceptButton);

		acceptButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				iniciarSesion();
			}
		});
		buttonsBox.add(Box.createRigidArea(new Dimension(10,0)));
		buttonsBox.add(cancelButton);

		buttonsPanel.add(buttonsBox);

		getContentPane().add(formPanel, BorderLayout.CENTER);
		getContentPane().add(buttonsPanel,BorderLayout.SOUTH);

		this.setVisible(true);
	}

	private void iniciarSesion() {
		try {
			GestorBD bd = new GestorBD();
			String usuario = loginField.getText();
			String contra = new String(passwordField.getPassword());

			Cliente c =  bd.iniciarSesionCliente(usuario, contra);
			Trabajador t = bd.iniciarSesionTrabajador(usuario, contra);

			bd.desconectar();
			if (c!= null) {
				VistaCliente.abrirVistaCliente(c);
				dispose();
			}else if (t != null) {
				if (t.isAdmin()) {
					VistaAdministrador.abrirVistaAdministrador(t);
				}else{
					VistaTrabajador.abrirVistaTrabajador(t);
				}
				dispose();
			}else {
				falloInicio.setVisible(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("No conecta a la base de datos");
		}
	}

	public static void abrirLogin() {
		Login login = new Login();
		login.setVisible(true);
		login.setSize(480,360);
		login.setLocationRelativeTo(null);
		login.setVisible(true);
	}
	
	private void volver() {
		Inicio.abrirInicio();
		dispose();
	}
}