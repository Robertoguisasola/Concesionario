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
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Trabajador;

public class VistaAdministrador extends JFrame {
	
	//TODO poner menú para poder importar desde ficheros los trabajadores, clientes y vehículos
	//TODO pasar los botones a un menú
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel panelSuperior;
	private JButton cerrarButton;
	private JPanel opcionesPanel;
	private Box opcionesBox;
	private Box clienteBox;
	private JLabel clienteLabel;
	private JButton clienteButton;
	private Box trabajadorBox;
	private JLabel trabajadorLabel;
	private JButton trabajadorButton;
	private Box ventasBox;
	private JLabel ventasLabel;
	private JButton ventasButton;
	private Box cochesBox;
	private JLabel cochesLabel;
	private JButton cochesButton;

	
	public VistaAdministrador(Trabajador t){
		this.setTitle("Bienvenido "+ t.getNombre()+ " " + t.getApellidos());
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(480,360);
		this.setResizable(true);
		
		panelSuperior  =new JPanel();
		
		cerrarButton = new JButton("Cerrar sesión");
		cerrarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login ventanaLogin = new Login();
				ventanaLogin.setLocationRelativeTo(null);
				ventanaLogin.setVisible(true);
				dispose();
			}
		});
		
		panelSuperior.add(Box.createRigidArea(new Dimension(300,0)));
		panelSuperior.add(cerrarButton);
		
		add(panelSuperior, BorderLayout.NORTH);
		
		opcionesPanel = new JPanel();
		opcionesPanel.setLayout(new GridBagLayout());
		
		clienteLabel = new JLabel("Clientes");
		
		clienteButton = new JButton("Ver clientes");
		
		clienteBox = new Box(BoxLayout.Y_AXIS);
		clienteBox.add(clienteLabel);
		clienteBox.add(Box.createRigidArea(new Dimension(0, 10)));
		clienteBox.add(clienteButton);
		
		cochesButton = new JButton("Ver coches");
		cochesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TablaCoches tablaCoches = new TablaCoches(t);
				tablaCoches.setLocationRelativeTo(null);
				tablaCoches.setVisible(true);
				dispose();
			}
		});
		
		opcionesBox = new Box(BoxLayout.Y_AXIS);
		opcionesBox.add(clienteBox);
		opcionesBox.add(Box.createRigidArea(new Dimension(0, 10)));
		opcionesBox.add(trabajadorBox);
		opcionesBox.add(Box.createRigidArea(new Dimension(0, 10)));
		opcionesBox.add(ventasBox);
		opcionesBox.add(Box.createRigidArea(new Dimension(0, 10)));
		opcionesBox.add(cochesButton);
		
		
		opcionesPanel.add(opcionesBox);
					
		getContentPane().add(opcionesPanel, BorderLayout.CENTER);
		
		this.setVisible(true);
	}
}
