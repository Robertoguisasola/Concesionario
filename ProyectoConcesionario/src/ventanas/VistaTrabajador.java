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
import javax.swing.JPanel;

import model.Trabajador;

//NO TOCAR, SOLO AÑADIR COSAS
public class VistaTrabajador extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel panelSuperior;
	private JPanel opcionesPanel;
	private Box opcionesBox;
	private JButton cochesButton;
	private JButton cerrarButton;
	
	//TODO menú parte superior
	public VistaTrabajador(Trabajador t) {
		this.setTitle("Bienvenido "+ t.getNombre()+ " " + t.getApellidos());
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(480,360);
		this.setResizable(true);
		
		panelSuperior  =new JPanel();
		
		cerrarButton = new JButton("Cerrar sesión");
		cerrarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login.abrirLogin();
				dispose();
			}
		});
		
		panelSuperior.add(Box.createRigidArea(new Dimension(300,0)));
		panelSuperior.add(cerrarButton);
		
		add(panelSuperior, BorderLayout.NORTH);
		
		opcionesPanel = new JPanel();
		opcionesPanel.setLayout(new GridBagLayout());
		
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
		opcionesBox.add(cochesButton);
		
		
		opcionesPanel.add(opcionesBox);
					
		getContentPane().add(opcionesPanel, BorderLayout.CENTER);
		
		this.setVisible(true);
	}
}
