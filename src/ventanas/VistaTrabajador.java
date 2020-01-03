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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import model.Trabajador;

//NO TOCAR, SOLO A�ADIR COSAS
public class VistaTrabajador extends JFrame{

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
	private JMenu ventasEditarMenu;
	private JMenu cochesEditarMenu;
	private JMenuItem clientesVerItem;
	private JMenuItem clientesAddItem;
	private JMenuItem clientesEliminarItem;
	private JMenuItem clientesExportar;
	private JMenuItem ventasVerItem;
	private JMenuItem ventasAddItem;
	private JMenuItem ventasEliminarItem;
	private JMenuItem ventasExportar;
	private JMenuItem cochesVerItem;
	private JMenuItem cochesAddItem;
	private JMenuItem cochesEliminarItem;
	private JMenuItem cochesExportar;
	
	private JPanel panelSuperior;
	private JPanel opcionesPanel;
	private Box opcionesBox;
	private JButton cochesButton;
	private JButton cerrarButton;
	private Box clienteBox;
	private JLabel clienteLabel;
	private JButton clienteButton;
	private Box ventasBox;
	private JLabel ventasLabel;
	private JButton ventasButton;
	private Box cochesBox;
	private JLabel cochesLabel;

	public VistaTrabajador(Trabajador t) {
		this.setTitle("Bienvenido "+ t.getNombre()+ " " + t.getApellidos());

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(480,360);
		this.setResizable(true);

		barraMenu= new JMenuBar();

		clientesMenu = new JMenu("Clientes");
		ventasMenu = new JMenu("Ventas");
		cochesMenu = new JMenu("Coches");

		clientesVerItem = new JMenuItem("Ver");
		clientesVerItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TablaClientes.abrirTablaClientes(t);
				dispose();				
			}
		});
		clientesMenu.add(clientesVerItem);

		clientesEditarMenu = new JMenu("Editar");
		clientesMenu.add(clientesEditarMenu);

		clientesAddItem = new JMenuItem("A�adir cliente");
		clientesAddItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		clientesEditarMenu.add(clientesAddItem);

		clientesEliminarItem = new JMenuItem("Eliminar cliente");
		clientesEliminarItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TablaClientes.abrirTablaClientes(t);
				dispose();
			}
		});
		clientesEditarMenu.add(clientesEliminarItem);

		clientesExportar = new JMenuItem("Exportar");
		clientesExportar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		clientesMenu.add(clientesExportar);

		ventasVerItem = new JMenuItem("Ver");
		ventasVerItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TablaVentas.abrirTablaVentas(t);
				dispose();				
			}
		});
		ventasMenu.add(ventasVerItem);

		ventasEditarMenu = new JMenu("Editar");
		ventasMenu.add(ventasEditarMenu);

		ventasAddItem = new JMenuItem("A�adir venta");
		ventasAddItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		ventasEditarMenu.add(ventasAddItem);

		ventasEliminarItem = new JMenuItem("Eliminar venta");
		ventasEliminarItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TablaVentas.abrirTablaVentas(t);
				dispose();	
			}
		});
		ventasEditarMenu.add(ventasEliminarItem);

		ventasExportar = new JMenuItem("Exportar");
		ventasExportar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		ventasMenu.add(ventasExportar);

		cochesVerItem = new JMenuItem("Ver");
		cochesVerItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TablaCoches.abrirTablaCoches(t);
				dispose();			
			}
		});
		cochesMenu.add(cochesVerItem);

		cochesEditarMenu = new JMenu("Editar");
		cochesMenu.add(cochesEditarMenu);

		cochesAddItem = new JMenuItem("A�adir coche");
		cochesAddItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AnadirCoche.abrirAnadirCoche(t);
				dispose();
			}
		});
		cochesEditarMenu.add(cochesAddItem);

		cochesEliminarItem = new JMenuItem("Eliminar coche");
		cochesEliminarItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TablaCoches.abrirTablaCoches(t);
				dispose();
			}
		});
		cochesEditarMenu.add(cochesEliminarItem);

		cochesExportar = new JMenuItem("Exportar");
		cochesExportar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		cochesMenu.add(cochesExportar);

		barraMenu.add(clientesMenu);
		barraMenu.add(trabajadoresMenu);
		barraMenu.add(ventasMenu);
		barraMenu.add(cochesMenu);

		setJMenuBar(barraMenu);		


		panelSuperior  =new JPanel();

		cerrarButton = new JButton("Cerrar sesi�n");
		cerrarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login.abrirLogin();
				dispose();
			}
		});

		panelSuperior.add(Box.createRigidArea(new Dimension(300,0)));
		panelSuperior.add(cerrarButton);

		add(panelSuperior, BorderLayout.NORTH);

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
				TablaClientes.abrirTablaClientes(t);
				dispose();
			}
		});

		clienteBox = new Box(BoxLayout.Y_AXIS);
		clienteBox.add(clienteLabel);
		clienteBox.add(Box.createRigidArea(new Dimension(0, 10)));
		clienteBox.add(clienteButton);

		ventasLabel = new JLabel("Ventas");

		ventasButton = new JButton("Ver ventas");
		ventasButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TablaVentas.abrirTablaVentas(t);
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
				TablaCoches.abrirTablaCoches(t);
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
		opcionesBox.add(ventasBox);
		opcionesBox.add(Box.createRigidArea(new Dimension(0, 10)));
		opcionesBox.add(cochesBox);

		opcionesPanel.add(opcionesBox);

		getContentPane().add(opcionesPanel, BorderLayout.CENTER);

		this.setVisible(true);
	}

	public static void abrirVistaTrabajador(Trabajador t) {
		VistaTrabajador vistaTrabajador = new VistaTrabajador(t);
		vistaTrabajador.setVisible(true);
		vistaTrabajador.setSize(480,360);
		vistaTrabajador.setLocationRelativeTo(null);
		vistaTrabajador.setVisible(true);
	}
}