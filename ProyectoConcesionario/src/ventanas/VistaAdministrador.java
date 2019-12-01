package ventanas;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import model.Trabajador;


public class VistaAdministrador extends JFrame {
	
	//TODO poner menú para poder importar desde ficheros los trabajadores, clientes y vehículos
	//TODO pasar los botones a un menú
	//TODO completar el menú
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JMenuBar barraMenu;
	private JMenu clientesMenu;
	private JMenu trabajadoresMenu;
	private JMenu ventasMenu;
	private JMenu cochesMenu;
	private JMenu clientesEditarMenu;
	private JMenuItem clientesVerItem;
	private JMenuItem clientesAñadirItem;
	private JMenuItem clientesEliminarItem;
	private JMenuItem datosItem;
	private JMenuItem cerrarSesionItem;
	
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
		
		barraMenu= new JMenuBar();
		
		clientesMenu = new JMenu("Clientes");
		trabajadoresMenu = new JMenu("Trabajadores");
		ventasMenu = new JMenu("Ventas");
		cochesMenu = new JMenu("Coches");
		
		clientesVerItem = new JMenuItem("Ver");
		clientesMenu.add(clientesVerItem);
		
		clientesEditarMenu = new JMenu("Editar");
		clientesMenu.add(clientesEditarMenu);
		
		
		
		
		barraMenu.add(clientesMenu);
		barraMenu.add(trabajadoresMenu);
		barraMenu.add(ventasMenu);
		barraMenu.add(cochesMenu);
		
		setJMenuBar(barraMenu);		
		
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
		clienteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TablaClientes tablaClientes = new TablaClientes(t);
				tablaClientes.setLocationRelativeTo(null);
				tablaClientes.setVisible(true);
				dispose();					
			}
		});
		
		clienteBox = new Box(BoxLayout.Y_AXIS);
		clienteBox.add(clienteLabel);
		clienteBox.add(Box.createRigidArea(new Dimension(0, 10)));
		clienteBox.add(clienteButton);
		
		trabajadorLabel = new JLabel("Trabajadores");
		
		trabajadorButton = new JButton("Ver trabajadores");
		trabajadorButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TablaTrabajadores tablaTrabajadores = new TablaTrabajadores(t);
				tablaTrabajadores.setLocationRelativeTo(null);
				tablaTrabajadores.setVisible(true);
				dispose();				
			}
		});
		
		trabajadorBox = new Box(BoxLayout.Y_AXIS);
		trabajadorBox.add(trabajadorLabel);
		trabajadorBox.add(Box.createRigidArea(new Dimension(0, 10)));
		trabajadorBox.add(trabajadorButton);
		
		ventasLabel = new JLabel("Ventas");
		
		ventasButton = new JButton("Ver ventas");
		ventasButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TablaVentas tablaVentas = new TablaVentas(t);
				tablaVentas.setLocationRelativeTo(null);
				tablaVentas.setVisible(true);
				dispose();
				
			}
		});
		
		ventasBox = new Box(BoxLayout.Y_AXIS);
		ventasBox.add(ventasLabel);
		ventasBox.add(Box.createRigidArea(new Dimension(0, 10)));
		ventasBox.add(ventasButton);
		
		cochesLabel = new JLabel("Coches");
		
		cochesButton = new JButton("Ver coches");
		cochesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TablaCoches tablaCoches = new TablaCoches(t);
				tablaCoches.setLocationRelativeTo(null);
				tablaCoches.setVisible(true);
				dispose();
			}
		});
		
		cochesBox = new Box(BoxLayout.Y_AXIS);
		cochesBox.add(cochesLabel);
		cochesBox.add(Box.createRigidArea(new Dimension(0, 10)));
		cochesBox.add(cochesButton);
		
		opcionesBox = new Box(BoxLayout.Y_AXIS);
		opcionesBox.add(clienteBox);
		opcionesBox.add(Box.createRigidArea(new Dimension(0, 10)));
		opcionesBox.add(trabajadorBox);
		opcionesBox.add(Box.createRigidArea(new Dimension(0, 10)));
		opcionesBox.add(ventasBox);
		opcionesBox.add(Box.createRigidArea(new Dimension(0, 10)));
		opcionesBox.add(cochesBox);
		
		opcionesPanel.add(opcionesBox);
					
		getContentPane().add(opcionesPanel, BorderLayout.CENTER);
		
		this.setVisible(true);
	}
	
	//TODO borrar cuando funciones como queremos
	public static void main(String[] args) {
		Trabajador t = new Trabajador();
		t.setNombre("admin");

		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new VistaAdministrador(t);
			}
		});
	}
}
