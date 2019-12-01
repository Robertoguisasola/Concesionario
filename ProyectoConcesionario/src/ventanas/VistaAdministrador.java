package ventanas;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VistaAdministrador extends JFrame {
	
	//TODO poner menú para poder importar desde ficheros los trabajadores, clientes y vehículos
	//TODO pasar los botones a un menú y poner un texto de bienvenida al concesionario en la ventana con la info del cliente
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel opcionesPanel;
	private Box buttonsBox;
	private JButton contratarTrabajadorButton;
	private JButton despedirTrabajadorButton;
	private JButton cancelButton;
	
	public VistaAdministrador(){
		this.setTitle("Menu del administrador");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(480,360);
		this.setResizable(true);
		
		opcionesPanel = new JPanel();
		opcionesPanel.setLayout(new GridBagLayout());
		
		buttonsBox = new Box(BoxLayout.Y_AXIS);

		contratarTrabajadorButton = new JButton("Contratar trabajador");
		contratarTrabajadorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaContratarTrabajador ventanaContratar = new VentanaContratarTrabajador();
				ventanaContratar.setLocationRelativeTo(null);
				ventanaContratar.setVisible(true);
				dispose();
			}
		});
		
		despedirTrabajadorButton = new JButton("Despedir trabajador");
		despedirTrabajadorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaDespedirTrabajador ventanaDespedir = new VentanaDespedirTrabajador();
				ventanaDespedir.setLocationRelativeTo(null);
				ventanaDespedir.setVisible(true);
				dispose();
			}
		});
		
		cancelButton = new JButton("Cancelar");
		cancelButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				Login ventanaLogin = new Login();
				ventanaLogin.setLocationRelativeTo(null);
				ventanaLogin.setVisible(true);
				dispose();
			}
		});
		
		buttonsBox.add(contratarTrabajadorButton);
		buttonsBox.add(despedirTrabajadorButton);
		buttonsBox.add(cancelButton);
				
		GridBagConstraints gbc_buttonsBox = new GridBagConstraints();
		gbc_buttonsBox.gridx = 0;
		opcionesPanel.add(buttonsBox, gbc_buttonsBox);
		
		getContentPane().add(opcionesPanel, BorderLayout.CENTER);
		
		this.setVisible(true);
	}
}
