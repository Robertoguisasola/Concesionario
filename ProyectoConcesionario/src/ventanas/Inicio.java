package ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//NO TOCAR
public class Inicio extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel opcionesPanel;
	private Box buttonsBox;
	private JButton iniciarSesionButton;
	private JButton registrarCuentaButton;
	
	//NO TOCAR
	public Inicio(){
		
		//TODO no se que es el realizable
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setSize(480, 360);
		this.setResizable(true);
		
		opcionesPanel = new JPanel();
		opcionesPanel.setLayout(new GridBagLayout());
		
		buttonsBox = new Box(BoxLayout.Y_AXIS);
		iniciarSesionButton = new JButton("Iniciar sesión");
		iniciarSesionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login.abrirLogin();
				dispose();
			}
		});
		
		registrarCuentaButton = new JButton("Registrar cuenta");
		registrarCuentaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarCliente.abrirRegistrarCliente();
				dispose();
			}
		});
		
		buttonsBox.add(iniciarSesionButton);
		buttonsBox.add(Box.createRigidArea(new Dimension(0,40)));
		buttonsBox.add(registrarCuentaButton);
				
		GridBagConstraints gbc_buttonsBox = new GridBagConstraints();
		gbc_buttonsBox.gridx = 0;
		opcionesPanel.add(buttonsBox, gbc_buttonsBox);
		
		getContentPane().add(opcionesPanel, BorderLayout.CENTER);
		
		this.setVisible(true);
	}
	
	public static void abrirInicio() {
		Inicio inicio = new Inicio();
		inicio.setTitle("Inicio");
		inicio.setSize(480,360);
		inicio.setLocationRelativeTo(null);
		inicio.setVisible(true);
	}
}
