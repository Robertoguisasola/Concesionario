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

import dataBase.GestorBD;
import model.Trabajador;

public class VistaAdministrador extends JFrame{	
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
	private JMenu trabajadoresEditarMenu;
	private JMenu ventasEditarMenu;
	private JMenu cochesEditarMenu;
	private JMenuItem clientesVerItem;
	private JMenuItem clientesAddItem;
	private JMenuItem clientesEliminarItem;
	private JMenuItem clientesImportar;
	private JMenuItem clientesExportar;
	private JMenuItem trabajadoresVerItem;
	private JMenuItem trabajadoresAddItem;
	private JMenuItem trabajadoresEliminarItem;
	private JMenuItem trabajadoresImportar;
	private JMenuItem trabajadoresExportar;
	private JMenuItem ventasVerItem;
	private JMenuItem ventasAddItem;
	private JMenuItem ventasEliminarItem;
	private JMenuItem ventasImportar;
	private JMenuItem ventasExportar;
	private JMenuItem cochesVerItem;
	private JMenuItem cochesAddItem;
	private JMenuItem cochesEliminarItem;
	private JMenuItem cochesImportar;
	private JMenuItem cochesExportar;
	
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
		
		clientesAddItem = new JMenuItem("Añadir cliente");
		clientesAddItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				RegistrarCliente.abrirRegistrarCliente(t);
				dispose();
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
		
		clientesImportar = new JMenuItem("Importar");
		clientesImportar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GestorBD bd = new GestorBD();
				bd.importarFicheroABBDD("cliente");
				bd.desconectar();
			}
		});
		clientesMenu.add(clientesImportar);
		
		clientesExportar = new JMenuItem("Exportar");
		clientesExportar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GestorBD bd = new GestorBD();
				bd.exportarBBDDAFichero("cliente");
				bd.desconectar();	
			}
		});
		clientesMenu.add(clientesExportar);
		
		trabajadoresVerItem = new JMenuItem("Ver");
		trabajadoresVerItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TablaTrabajadores.abrirTablaTrabajadores(t);
				dispose();				
			}
		});
		trabajadoresMenu.add(trabajadoresVerItem);
		
		trabajadoresEditarMenu = new JMenu("Editar");
		trabajadoresMenu.add(trabajadoresEditarMenu);
		
		trabajadoresAddItem = new JMenuItem("Añadir trabajador");
		trabajadoresAddItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ContratarTrabajador.abrirContratarTrabajador(t);
				dispose();
			}
		});
		trabajadoresEditarMenu.add(trabajadoresAddItem);
		
		trabajadoresEliminarItem = new JMenuItem("Despedir trabajador");
		trabajadoresEliminarItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TablaTrabajadores.abrirTablaTrabajadores(t);
				dispose();	
			}
		});
		trabajadoresEditarMenu.add(trabajadoresEliminarItem);
		
		trabajadoresImportar = new JMenuItem("Importar");
		trabajadoresImportar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GestorBD bd = new GestorBD();
				bd.importarFicheroABBDD("trabajador");
				bd.desconectar();
			}
		});
		trabajadoresMenu.add(trabajadoresImportar);
		
		trabajadoresExportar = new JMenuItem("Exportar");
		trabajadoresExportar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GestorBD bd = new GestorBD();
				bd.exportarBBDDAFichero("trabajador");
				bd.desconectar();				
			}
		});
		trabajadoresMenu.add(trabajadoresExportar);
		
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
		
		ventasAddItem = new JMenuItem("Añadir venta");
		ventasAddItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				EscogerCoche.abrirEscogerCoche(null, t);
				dispose();
				
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
		
		ventasImportar = new JMenuItem("Importar");
		ventasImportar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GestorBD bd = new GestorBD();
				bd.importarFicheroABBDD("venta");
				bd.desconectar();
			}
		});
		ventasMenu.add(ventasImportar);
		
		ventasExportar = new JMenuItem("Exportar");
		ventasExportar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GestorBD bd = new GestorBD();
				bd.exportarBBDDAFichero("venta");
				bd.desconectar();				
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
		
		cochesAddItem = new JMenuItem("Añadir coche");
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
		
		cochesImportar = new JMenuItem("Importar");
		cochesImportar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GestorBD bd = new GestorBD();
				bd.importarFicheroABBDD("coche");
				bd.desconectar();
			}
		});
		cochesMenu.add(cochesImportar);
		
		cochesExportar = new JMenuItem("Exportar");
		cochesExportar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GestorBD bd = new GestorBD();
				bd.exportarBBDDAFichero("coche");
				bd.desconectar();	
			}
		});
		cochesMenu.add(cochesExportar);
		
		barraMenu.add(clientesMenu);
		barraMenu.add(trabajadoresMenu);
		barraMenu.add(ventasMenu);
		barraMenu.add(cochesMenu);
		
		setJMenuBar(barraMenu);		
		
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
		
		trabajadorLabel = new JLabel("Trabajadores");
		
		trabajadorButton = new JButton("Ver trabajadores");
		trabajadorButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TablaTrabajadores.abrirTablaTrabajadores(t);
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
		opcionesBox.add(trabajadorBox);
		opcionesBox.add(Box.createRigidArea(new Dimension(0, 10)));
		opcionesBox.add(ventasBox);
		opcionesBox.add(Box.createRigidArea(new Dimension(0, 10)));
		opcionesBox.add(cochesBox);
		
		opcionesPanel.add(opcionesBox);
					
		getContentPane().add(opcionesPanel, BorderLayout.CENTER);
		
		this.setVisible(true);
	}
	
	public static void abrirVistaAdministrador(Trabajador t) {
		VistaAdministrador vistaAdministrador= new VistaAdministrador(t);
		vistaAdministrador.setVisible(true);
		vistaAdministrador.setSize(480,360);
		vistaAdministrador.setLocationRelativeTo(null);
		vistaAdministrador.setVisible(true);
	}
	
	public static void main(String[] args) {
		Trabajador t = new Trabajador();
		t.setAdmin(true);
		
		VistaAdministrador.abrirVistaAdministrador(t);
	}
}