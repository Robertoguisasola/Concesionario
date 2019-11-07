package ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaInicial extends JFrame {
	//TODO enlazar ventana como principal
	
	private JPanel opcionesPanel;
	private Box buttonsBox;
	private JButton iniciarSesionButton;
	private JButton registrarCuentaButton;
	
	public VentanaInicial(){
		this.setTitle("Inicio");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(320, 240);
		this.setResizable(true);
		
		opcionesPanel = new JPanel();
		opcionesPanel.setLayout(new GridBagLayout());
		
		buttonsBox = new Box(BoxLayout.Y_AXIS);
		iniciarSesionButton = new JButton("Iniciar sesión");
		iniciarSesionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaLogin ventanaLogin = new VentanaLogin();
				ventanaLogin.setVisible(true);
				ventanaLogin.setSize(450,260);
				ventanaLogin.setLocationRelativeTo(null);
				ventanaLogin.setVisible(true);
				dispose(); // El dispose es para que cuando cliques un botón y vaya a otra ventana se cierre la anterior.
			}
		});
		registrarCuentaButton = new JButton("Registrar cuenta");
		
		buttonsBox.add(iniciarSesionButton);
		buttonsBox.add(Box.createRigidArea(new Dimension(0,40)));
		buttonsBox.add(registrarCuentaButton);
				
		GridBagConstraints gbc_buttonsBox = new GridBagConstraints();
		gbc_buttonsBox.gridx = 0;
		opcionesPanel.add(buttonsBox, gbc_buttonsBox);
		
		getContentPane().add(opcionesPanel, BorderLayout.CENTER);
		
		this.setVisible(true);
	}
}
