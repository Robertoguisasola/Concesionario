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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dataBase.GestorBD;
import model.Trabajador;

//NO TOCAR, SOLO AÑADIR COSAS
public class VistaTrabajador extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JMenuBar barraMenu;
	private JMenu clientesMenu;
	private JMenu ventasMenu;
	private JMenu cochesMenu;
	private JMenu cochesNMenu;
	private JMenu coches2Menu;
	private JMenu motosMenu;
	private JMenu motosNMenu;
	private JMenu motos2Menu;
	private JMenu clientesEditarMenu;
	private JMenu ventasCEditarMenu;
	private JMenu ventasMEditarMenu;
	private JMenu cochesEditarMenu;
	private JMenu coches2EditarMenu;
	private JMenu motosEditarMenu;
	private JMenu motos2EditarMenu;
	private JMenu ventasCochesMenu;
	private JMenu ventasMotosMenu;
	private JMenuItem clientesVerItem;
	private JMenuItem clientesAddItem;
	private JMenuItem clientesEliminarItem;
	private JMenuItem clientesExportar;
	private JMenuItem ventasCVerItem;
	private JMenuItem ventasCAddItem;
	private JMenuItem ventasCEliminarItem;
	private JMenuItem ventasCExportar;
	private JMenuItem ventasMVerItem;
	private JMenuItem ventasMAddItem;
	private JMenuItem ventasMEliminarItem;
	private JMenuItem ventasMExportar;
	private JMenuItem cochesVerItem;
	private JMenuItem cochesAddItem;
	private JMenuItem cochesEliminarItem;
	private JMenuItem cochesExportar;
	private JMenuItem coches2VerItem;
	private JMenuItem coches2AddItem;
	private JMenuItem coches2EliminarItem;
	private JMenuItem coches2Exportar;
	private JMenuItem motosVerItem;
	private JMenuItem motosAddItem;
	private JMenuItem motosEliminarItem;
	private JMenuItem motosExportar;
	private JMenuItem motos2VerItem;
	private JMenuItem motos2AddItem;
	private JMenuItem motos2EliminarItem;
	private JMenuItem motos2Exportar;

	private JPanel panelSuperior;
	private JButton cerrarButton;
	private JPanel opcionesPanel;
	private Box opcionesBox;
	private Box clienteBox;
	private JLabel clienteLabel;
	private JButton clienteButton;
	private Box ventasBox;
	private JLabel ventasLabel;
	private JButton ventasButton;
	private Box cochesBox;
	private JLabel cochesLabel;
	private JButton cochesButton;
	private Box motosBox;
	private JLabel motosLabel;
	private JButton motosButton;

	public VistaTrabajador(Trabajador t) {
		barraMenu= new JMenuBar();

		clientesMenu = new JMenu("Clientes");
		ventasMenu = new JMenu("Ventas");
		cochesMenu = new JMenu("Coches");
		motosMenu = new JMenu("Motos");

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

		ventasCochesMenu = new JMenu("Ventas de coches");
		ventasMenu.add(ventasCochesMenu);

		ventasCVerItem = new JMenuItem("Ver");
		ventasCVerItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] opciones = {"Nuevos", "Segunda mano"};

				int respuesta = JOptionPane.showOptionDialog( null, "¿Qué ventas de coches deseas ver?", "Borrar", JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
				switch (respuesta) {
				case 0:
					TablaVentasCoches.abrirTablaVentasCoches(t);
					dispose();
					break;
				case 1:
					TablaVentasCoches2.abrirTablaVentasCoches2(t);
					dispose();
				default:
					break;
				}
				TablaVentasCoches.abrirTablaVentasCoches(t);
				dispose();				
			}
		});
		ventasCochesMenu.add(ventasCVerItem);

		ventasCEditarMenu = new JMenu("Editar");
		ventasCochesMenu.add(ventasCEditarMenu);

		ventasCAddItem = new JMenuItem("Añadir venta");
		ventasCAddItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] opciones = {"Nuevo", "Segunda mano"};

				int respuesta = JOptionPane.showOptionDialog( null, "¿Qué coche deseas comprar?", "Borrar", JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
				switch (respuesta) {
				case 0:
					EscogerCoche.abrirEscogerCoche(null, t);
					dispose();
					break;
				case 1:
					EscogerCoche2.abrirEscogerCoche2(null, t);
				default:
					break;
				}
			}
		});
		ventasCEditarMenu.add(ventasCAddItem);

		ventasCEliminarItem = new JMenuItem("Eliminar venta");
		ventasCEliminarItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] opciones = {"Nuevos", "Segunda mano"};

				int respuesta = JOptionPane.showOptionDialog( null, "¿Qué venta de coches deseas eliminar?", "Borrar", JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
				switch (respuesta) {
				case 0:
					TablaVentasCoches.abrirTablaVentasCoches(t);
					dispose();
					break;
				case 1:
					TablaVentasCoches2.abrirTablaVentasCoches2(t);
					dispose();
				default:
					break;
				}
			}
		});
		ventasCEditarMenu.add(ventasCEliminarItem);

		ventasCExportar = new JMenuItem("Exportar");
		ventasCExportar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GestorBD bd = new GestorBD();
				bd.exportarBBDDAFichero("ventacoche");
				bd.desconectar();				
			}
		});
		ventasCochesMenu.add(ventasCExportar);

		ventasMotosMenu = new JMenu("Ventas de motos");
		ventasMenu.add(ventasMotosMenu);

		ventasMVerItem = new JMenuItem("Ver");
		ventasMVerItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] opciones = {"Nuevas", "Segunda mano"};

				int respuesta = JOptionPane.showOptionDialog( null, "¿Qué motos deseas ver?", "Borrar", JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
				switch (respuesta) {
				case 0:
					TablaVentasMotos.abrirTablaVentasMotos(t);
					dispose();
					break;
				case 1:
					TablaVentasMotos2.abrirTablaVentasMotos2(t);
					dispose();
				default:
					break;
				}
			}
		});
		ventasMotosMenu.add(ventasMVerItem);

		ventasMEditarMenu = new JMenu("Editar");
		ventasMotosMenu.add(ventasMEditarMenu);

		ventasMAddItem = new JMenuItem("Añadir venta");
		ventasMAddItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] opciones = {"Nueva", "Segunda mano"};

				int respuesta = JOptionPane.showOptionDialog( null, "¿Qué moto deseas comprar?", "Borrar", JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
				switch (respuesta) {
				case 0:
					EscogerMoto.abrirEscogerMoto(null, t);
					dispose();
					break;
				case 1:
					EscogerMoto2.abrirEscogerMoto2(null, t);
					dispose();
				default:
					break;
				}
			}
		});
		ventasMEditarMenu.add(ventasMAddItem);

		ventasMEliminarItem = new JMenuItem("Eliminar venta");
		ventasMEliminarItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] opciones = {"Nueva", "Segunda mano"};

				int respuesta = JOptionPane.showOptionDialog( null, "¿Qué venta de moto deseas eliminar?", "Borrar", JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
				switch (respuesta) {
				case 0:
					TablaVentasMotos.abrirTablaVentasMotos(t);
					dispose();
					break;
				case 1:
					TablaVentasMotos2.abrirTablaVentasMotos2(t);
					dispose();
				default:
					break;
				}
			}
		});
		ventasMEditarMenu.add(ventasMEliminarItem);

		ventasMExportar = new JMenuItem("Exportar");
		ventasMExportar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GestorBD bd = new GestorBD();
				bd.exportarBBDDAFichero("ventamoto");
				bd.desconectar();				
			}
		});
		ventasMotosMenu.add(ventasMExportar);

		cochesNMenu = new JMenu("Coches nuevos");
		cochesMenu.add(cochesNMenu);

		cochesVerItem = new JMenuItem("Ver");
		cochesVerItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TablaCoches.abrirTablaCoches(t);
				dispose();			
			}
		});
		cochesNMenu.add(cochesVerItem);

		cochesEditarMenu = new JMenu("Editar");
		cochesNMenu.add(cochesEditarMenu);

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

		cochesExportar = new JMenuItem("Exportar");
		cochesExportar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GestorBD bd = new GestorBD();
				bd.exportarBBDDAFichero("coche");
				bd.desconectar();	
			}
		});
		cochesNMenu.add(cochesExportar);

		coches2Menu = new JMenu("Coches de segunda mano");
		cochesMenu.add(coches2Menu);

		coches2VerItem = new JMenuItem("Ver");
		coches2VerItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TablaCoches2.abrirTablaCoches2(t);
				dispose();			
			}
		});
		coches2Menu.add(coches2VerItem);

		coches2EditarMenu = new JMenu("Editar");
		coches2Menu.add(coches2EditarMenu);

		coches2AddItem = new JMenuItem("Añadir coche");
		coches2AddItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AnadirCoche2.abrirAnadirCoche2(t);
				dispose();
			}
		});
		coches2EditarMenu.add(coches2AddItem);

		coches2EliminarItem = new JMenuItem("Eliminar coche");
		coches2EliminarItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TablaCoches2.abrirTablaCoches2(t);
				dispose();
			}
		});
		coches2EditarMenu.add(coches2EliminarItem);

		coches2Exportar = new JMenuItem("Exportar");
		coches2Exportar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GestorBD bd = new GestorBD();
				bd.exportarBBDDAFichero("coche2");
				bd.desconectar();	
			}
		});
		coches2Menu.add(coches2Exportar);

		motosNMenu = new JMenu("Motos nuevas");
		motosMenu.add(motosNMenu);

		motosVerItem = new JMenuItem("Ver");
		motosVerItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TablaMotos.abrirTablaMotos(t);
				dispose();
			}
		});
		motosNMenu.add(motosVerItem);

		motosEditarMenu = new JMenu("Editar");
		motosNMenu.add(motosEditarMenu);

		motosAddItem = new JMenuItem("Añadir moto");
		motosAddItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AnadirMoto.abrirAnadirMoto(t);
				dispose();
			}
		});
		motosEditarMenu.add(motosAddItem);

		motosEliminarItem = new JMenuItem("Eliminar moto");
		motosEliminarItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TablaMotos.abrirTablaMotos(t);
				dispose();
			}
		});
		motosEditarMenu.add(motosEliminarItem);

		motosExportar = new JMenuItem("Exportar");
		motosExportar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GestorBD bd = new GestorBD();
				bd.exportarBBDDAFichero("moto");
				bd.desconectar();	
			}
		});
		motosNMenu.add(motosExportar);

		motos2Menu = new JMenu("Motos de segunda mano");
		motosMenu.add(motos2Menu);

		motos2VerItem = new JMenuItem("Ver");
		motos2VerItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TablaMotos2.abrirTablaMotos2(t);	
			}
		});
		motos2Menu.add(motos2VerItem);

		motos2EditarMenu = new JMenu("Editar");
		motos2Menu.add(motos2EditarMenu);

		motos2AddItem = new JMenuItem("Añadir moto");
		motos2AddItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AnadirMoto2.abrirAnadirMoto2(t);
				dispose();
			}
		});
		motos2EditarMenu.add(motos2AddItem);

		motos2EliminarItem = new JMenuItem("Eliminar moto");
		motos2EliminarItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TablaMotos2.abrirTablaMotos2(t);
				dispose();
			}
		});
		motos2EditarMenu.add(motos2EliminarItem);

		motos2Exportar = new JMenuItem("Exportar");
		motos2Exportar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GestorBD bd = new GestorBD();
				bd.exportarBBDDAFichero("moto2");
				bd.desconectar();	
			}
		});
		motos2Menu.add(motos2Exportar);

		barraMenu.add(clientesMenu);
		barraMenu.add(ventasMenu);
		barraMenu.add(cochesMenu);
		barraMenu.add(motosMenu);

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

		ventasLabel = new JLabel("Ventas");

		ventasButton = new JButton("Ver ventas");
		ventasButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] opciones = {"Coches", "Motos"};

				int respuesta = JOptionPane.showOptionDialog( null, "¿Qué ventas deseas ver?", "Borrar", JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
				switch (respuesta) {
				case 0:
					//TODO preguntar nuevos o de segunda mano
					TablaVentasCoches.abrirTablaVentasCoches(t);
					dispose();
					break;
				case 1:
					TablaCoches2.abrirTablaCoches2(t);
					dispose();
				default:
					break;
				}				
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
				String[] opciones = {"Nuevos", "Segunda mano"};

				int respuesta = JOptionPane.showOptionDialog( null, "¿Qué coches deseas ver?", "Borrar", JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
				switch (respuesta) {
				case 0:
					TablaCoches.abrirTablaCoches(t);
					dispose();
					break;
				case 1:
					TablaCoches2.abrirTablaCoches2(t);
					dispose();
				default:
					break;
				}				
			}
		});

		cochesBox = new Box(BoxLayout.Y_AXIS);
		cochesBox.add(cochesLabel);
		cochesBox.add(Box.createRigidArea(new Dimension(0, 10)));
		cochesBox.add(cochesButton);

		motosLabel = new JLabel("Motos");

		motosButton = new JButton("Ver motos");
		motosButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] opciones = {"Nuevas", "Segunda mano"};

				int respuesta = JOptionPane.showOptionDialog( null, "¿Qué motos deseas ver?", "Borrar", JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
				switch (respuesta) {
				case 0:
					TablaMotos.abrirTablaMotos(t);
					dispose();
					break;
				case 1:
					TablaMotos2.abrirTablaMotos2(t);
					dispose();
				default:
					break;
				}
			}
		});

		motosBox = new Box(BoxLayout.Y_AXIS);
		motosBox.add(motosLabel);
		motosBox.add(Box.createRigidArea(new Dimension(0, 10)));
		motosBox.add(motosButton);

		opcionesBox = new Box(BoxLayout.Y_AXIS);
		opcionesBox.add(clienteBox);
		opcionesBox.add(Box.createRigidArea(new Dimension(0, 10)));
		opcionesBox.add(ventasBox);
		opcionesBox.add(Box.createRigidArea(new Dimension(0, 10)));
		opcionesBox.add(cochesBox);
		opcionesBox.add(Box.createRigidArea(new Dimension(0, 10)));
		opcionesBox.add(motosBox);

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

	public static void main(String[] args) {
		Trabajador t = new Trabajador();
		t.setAdmin(false);

		VistaTrabajador.abrirVistaTrabajador(t);
	}
}
