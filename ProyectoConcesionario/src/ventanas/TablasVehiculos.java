package ventanas;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dataBase.GestorBD;
import model.Trabajador;

public class TablasVehiculos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTabbedPane pestanas;
	private JPanel panelCoches;
	private JPanel panelCoches2;
	private JPanel panelMotos;
	private JPanel panelMotos2;
	private JPanel northPanel;
	private JButton volverButton;

	private JScrollPane tablaCPanel;
	private JPanel botonesCPanel;
	private JButton anadirCButton;
	private JButton eliminarCButton;
	private JButton atrasCButton;
	private JTable tablaC;
	private DefaultTableModel modeloC;
	private JScrollPane tablaC2Panel;
	private JPanel botonesC2Panel;
	private JButton anadirC2Button;
	private JButton eliminarC2Button;
	private JButton atrasC2Button;
	private JTable tablaC2;
	private DefaultTableModel modeloC2;
	private JScrollPane tablaMPanel;
	private JPanel botonesMPanel;
	private JButton anadirMButton;
	private JButton eliminarMButton;
	private JButton atrasMButton;
	private JTable tablaM;
	private DefaultTableModel modeloM;
	private JScrollPane tablaM2Panel;
	private JPanel botonesM2Panel;
	private JButton anadirM2Button;
	private JButton eliminarM2Button;
	private JButton atrasM2Button;
	private JTable tablaM2;
	private DefaultTableModel modeloM2;	

	public TablasVehiculos(Trabajador t) {
		this.setTitle("Tabla de coches");

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		northPanel = new JPanel();
		northPanel.setLayout(new BorderLayout());

		volverButton = new JButton("Volver");
		volverButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				volver(t);
			}
		});

		northPanel.add(volverButton, BorderLayout.EAST);

		pestanas = new JTabbedPane(JTabbedPane.TOP);

		panelCoches = new JPanel();

		setDataC();
		tablaCPanel = new JScrollPane(tablaC);

		botonesCPanel = new JPanel();
		botonesCPanel.setLayout(new GridBagLayout());

		anadirCButton = new JButton("Añadir coche");
		botonesCPanel.add(anadirCButton);

		eliminarCButton = new JButton("Eliminar coche");
		botonesCPanel.add(eliminarCButton);

		atrasCButton = new JButton("Atrás");
		botonesCPanel.add(atrasCButton);

		anadirCButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AnadirCoche.abrirAnadirCoche(t);
				dispose();
			}
		});

		eliminarCButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] opciones = {"Sí", "No"};
				if(tablaC.getSelectedRow() >= 0) {
					String nombre = (String) modeloC.getValueAt(tablaC.getSelectedRow(), modeloC.findColumn("Marca"));

					int respuesta = JOptionPane.showOptionDialog( null, "¿Está seguro de eliminar el "+ nombre + " ?", "Borrar", JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

					switch (respuesta) {
					case 0:
						GestorBD bd = new GestorBD();
						String marca = (String) modeloC.getValueAt(tablaC.getSelectedRow(), modeloC.findColumn("Marca"));
						String modeloc = (String) modeloC.getValueAt(tablaC.getSelectedRow(), modeloC.findColumn("Modelo"));
						String color = (String) modeloC.getValueAt(tablaC.getSelectedRow(), modeloC.findColumn("Color"));
						int caballos = Integer.parseInt( modeloC.getValueAt(tablaC.getSelectedRow(), modeloC.findColumn("Caballos")).toString());
						int plazas = Integer.parseInt( modeloC.getValueAt(tablaC.getSelectedRow(), modeloC.findColumn("Plazas")).toString());
						int precio = Integer.parseInt(modeloC.getValueAt(tablaC.getSelectedRow(), modeloC.findColumn("Precio")).toString());
						int diesel;

						if ((boolean) modeloC.getValueAt(tablaC.getSelectedRow(), modeloC.findColumn("Motor diesel")).equals("No")) {
							diesel = 0;
						} else {
							diesel = 1;
						}

						bd.eliminarVehiculo("coche", marca, modeloc, color, caballos, plazas, precio, diesel, 0);
						bd.desconectar();
						break;
					default:
						break;
					}
				} else {
					JOptionPane.showMessageDialog(null, "Selecciona una fila de la tabla", null, 0);
				}
			}
		});

		atrasCButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				volver(t);
			}
		});

		panelCoches.add(tablaCPanel, BorderLayout.CENTER);
		panelCoches.add(botonesCPanel, BorderLayout.SOUTH);

		panelCoches2 = new JPanel();

		setDataC2();
		tablaC2Panel = new JScrollPane(tablaC2);

		botonesC2Panel = new JPanel();
		botonesC2Panel.setLayout(new GridBagLayout());

		anadirC2Button = new JButton("Añadir coche de segunda mano");
		botonesC2Panel.add(anadirC2Button);

		eliminarC2Button = new JButton("Eliminar coche");
		botonesC2Panel.add(eliminarC2Button);

		atrasC2Button = new JButton("Atrás");
		botonesC2Panel.add(atrasC2Button);

		anadirC2Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AnadirCoche2.abrirAnadirCoche2(t);
				dispose();
			}
		});

		eliminarC2Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] opciones = {"Sí", "No"};
				if(tablaC2.getSelectedRow() >= 0) {
					String nombre = (String) modeloC2.getValueAt(tablaC2.getSelectedRow(), modeloC2.findColumn("Marca"));

					int respuesta = JOptionPane.showOptionDialog( null, "¿Está seguro de eliminar el "+ nombre + " ?", "Borrar", JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

					switch (respuesta) {
					case 0:
						GestorBD bd = new GestorBD();
						String marca = (String) modeloC2.getValueAt(tablaC2.getSelectedRow(), modeloC2.findColumn("Marca"));
						String modeloc = (String) modeloC2.getValueAt(tablaC2.getSelectedRow(), modeloC2.findColumn("Modelo"));
						String color = (String) modeloC2.getValueAt(tablaC2.getSelectedRow(), modeloC2.findColumn("Color"));
						int caballos = Integer.parseInt( modeloC2.getValueAt(tablaC2.getSelectedRow(), modeloC2.findColumn("Caballos")).toString());
						int plazas = Integer.parseInt( modeloC2.getValueAt(tablaC2.getSelectedRow(), modeloC2.findColumn("Plazas")).toString());
						int precio = Integer.parseInt(modeloC2.getValueAt(tablaC2.getSelectedRow(), modeloC2.findColumn("Precio")).toString());
						int diesel;
						int kilometros = Integer.parseInt(modeloC2.getValueAt(tablaC2.getSelectedRow(), modeloC2.findColumn("Kilómetros")).toString());

						if ((boolean) modeloC2.getValueAt(tablaC2.getSelectedRow(), modeloC2.findColumn("Motor diesel")).equals("No")) {
							diesel = 0;
						} else {
							diesel = 1;
						}

						bd.eliminarVehiculo("coche2", marca, modeloc, color, caballos, plazas, precio, diesel, kilometros);
						bd.desconectar();
						break;
					default:
						break;
					}
				} else {
					JOptionPane.showMessageDialog(null, "Selecciona una fila de la tabla", null, 0);
				}
			}
		});

		atrasC2Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				volver(t);
			}
		});

		panelCoches2.add(tablaC2Panel, BorderLayout.CENTER);
		panelCoches2.add(botonesC2Panel, BorderLayout.SOUTH);

		panelMotos = new JPanel();

		setDataM();
		tablaMPanel = new JScrollPane(tablaM);

		botonesMPanel = new JPanel();
		botonesMPanel.setLayout(new GridBagLayout());

		anadirMButton = new JButton("Añadir moto");
		botonesMPanel.add(anadirMButton);

		eliminarMButton = new JButton("Eliminar moto");
		botonesMPanel.add(eliminarMButton);

		atrasMButton = new JButton("Atrás");
		botonesMPanel.add(atrasMButton);

		anadirMButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AnadirMoto.abrirAnadirMoto(t);
				dispose();
			}
		});

		eliminarMButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] opciones = {"Sí", "No"};
				if(tablaM.getSelectedRow() >= 0) {
					String nombre = (String) modeloM.getValueAt(tablaM.getSelectedRow(), modeloM.findColumn("Marca"));

					int respuesta = JOptionPane.showOptionDialog( null, "¿Está seguro de eliminar la "+ nombre + " ?", "Borrar", JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

					switch (respuesta) {
					case 0:
						GestorBD bd = new GestorBD();
						String marca = (String) modeloM.getValueAt(tablaM.getSelectedRow(), modeloM.findColumn("Marca"));
						String modeloc = (String) modeloM.getValueAt(tablaM.getSelectedRow(), modeloM.findColumn("Modelo"));
						String color = (String) modeloM.getValueAt(tablaM.getSelectedRow(), modeloM.findColumn("Color"));
						int caballos = Integer.parseInt( modeloM.getValueAt(tablaM.getSelectedRow(), modeloM.findColumn("Caballos")).toString());
						int plazas = Integer.parseInt( modeloM.getValueAt(tablaM.getSelectedRow(), modeloM.findColumn("Plazas")).toString());
						int precio = Integer.parseInt(modeloM.getValueAt(tablaM.getSelectedRow(), modeloM.findColumn("Precio")).toString());
						int estructura;

						if ((boolean) modeloM.getValueAt(tablaM.getSelectedRow(), modeloM.findColumn("Estructura protectora")).equals("No")) {
							estructura = 0;
						} else {
							estructura = 1;
						}

						bd.eliminarVehiculo("moto", marca, modeloc, color, caballos, plazas, precio, estructura, 0);
						bd.desconectar();
						break;
					default:
						break;
					}
				} else {
					JOptionPane.showMessageDialog(null, "Selecciona una fila de la tabla", null, 0);
				}
			}
		});

		atrasMButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				volver(t);
			}
		});

		panelMotos.add(tablaMPanel, BorderLayout.CENTER);
		panelMotos.add(botonesMPanel, BorderLayout.SOUTH);

		panelMotos2  =new JPanel();

		setDataM2();
		tablaM2Panel = new JScrollPane(tablaM2);

		botonesM2Panel = new JPanel();
		botonesM2Panel.setLayout(new GridBagLayout());

		anadirM2Button = new JButton("Añadir moto de segunda mano");
		botonesM2Panel.add(anadirM2Button);

		eliminarM2Button = new JButton("Eliminar moto");
		botonesM2Panel.add(eliminarM2Button);

		atrasM2Button = new JButton("Atrás");
		botonesM2Panel.add(atrasM2Button);

		anadirM2Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AnadirMoto2.abrirAnadirMoto2(t);
				dispose();
			}
		});

		eliminarM2Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] opciones = {"Sí", "No"};
				if(tablaM2.getSelectedRow() >= 0) {
					String nombre = (String) modeloM2.getValueAt(tablaM2.getSelectedRow(), modeloM2.findColumn("Marca"));

					int respuesta = JOptionPane.showOptionDialog( null, "¿Está seguro de eliminar la "+ nombre + " ?", "Borrar", JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

					switch (respuesta) {
					case 0:
						GestorBD bd = new GestorBD();
						String marca = (String) modeloM2.getValueAt(tablaM2.getSelectedRow(), modeloM2.findColumn("Marca"));
						String modeloc = (String) modeloM2.getValueAt(tablaM2.getSelectedRow(), modeloM2.findColumn("Modelo"));
						String color = (String) modeloM2.getValueAt(tablaM2.getSelectedRow(), modeloM2.findColumn("Color"));
						int caballos = Integer.parseInt( modeloM2.getValueAt(tablaM2.getSelectedRow(), modeloM2.findColumn("Caballos")).toString());
						int plazas = Integer.parseInt( modeloM2.getValueAt(tablaM2.getSelectedRow(), modeloM2.findColumn("Plazas")).toString());
						int precio = Integer.parseInt(modeloM2.getValueAt(tablaM2.getSelectedRow(), modeloM2.findColumn("Precio")).toString());
						int estructura;
						int kilometros = Integer.parseInt(modeloM2.getValueAt(tablaM2.getSelectedRow(), modeloM2.findColumn("Kilómetros")).toString());

						if ((boolean) modeloM2.getValueAt(tablaM2.getSelectedRow(), modeloM2.findColumn("Estructura protectora")).equals("No")) {
							estructura = 0;
						} else {
							estructura = 1;
						}

						bd.eliminarVehiculo("moto2", marca, modeloc, color, caballos, plazas, precio, estructura, kilometros);
						bd.desconectar();
						break;
					default:
						break;
					}
				} else {
					JOptionPane.showMessageDialog(null, "Selecciona una fila de la tabla", null, 0);
				}
			}
		});

		atrasM2Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				volver(t);
			}
		});

		panelMotos2.add(tablaM2Panel, BorderLayout.CENTER);
		panelMotos2.add(botonesM2Panel, BorderLayout.SOUTH);


		pestanas.addTab("Coches", panelCoches);
		pestanas.addTab("Coches segunda mano", panelCoches2);
		pestanas.addTab("Motos", panelMotos);
		pestanas.addTab("Motos segunda mano", panelMotos2);

		add(northPanel, BorderLayout.NORTH);
		add(pestanas);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);

		this.setVisible(true);
	}

	//Añadimos datos

	private void setDataC() {
		modeloC = new DefaultTableModel();
		tablaC = new JTable(modeloC);

		// Creamos las columnas.
		modeloC.addColumn("Marca");
		modeloC.addColumn("Modelo");
		modeloC.addColumn("Color");
		modeloC.addColumn("Caballos");
		modeloC.addColumn("Plazas");
		modeloC.addColumn("Precio");
		modeloC.addColumn("Motor diesel");

		GestorBD bd = new GestorBD();
		ResultSet rs = bd.rellenarTablaCoches();

		// Bucle para cada resultado en la consulta
		try {
			while (rs.next())
			{
				// Se crea un array que será una de las filas de la tabla.
				Object [] fila = new Object[7]; // Hay siete columnas en la tabla

				// Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
				for (int i=0;i<fila.length;i++)
					if (i == 6) {
						if (rs.getObject(i+1).equals(0)) {
							fila[i] = "No";
						} else {
							fila[i] = "Si";
						}
					} else {
						fila[i] = rs.getObject(i+1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.
					}
				// Se añade al modelo la fila completa.
				modeloC.addRow(fila);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		bd.desconectar();
	}

	private void setDataC2() {
		modeloC2 = new DefaultTableModel();
		tablaC2 = new JTable(modeloC2);

		// Creamos las columnas.
		modeloC2.addColumn("Marca");
		modeloC2.addColumn("Modelo");
		modeloC2.addColumn("Color");
		modeloC2.addColumn("Caballos");
		modeloC2.addColumn("Plazas");
		modeloC2.addColumn("Precio");
		modeloC2.addColumn("Motor diesel");
		modeloC2.addColumn("Kilómetros");

		GestorBD bd = new GestorBD();
		ResultSet rs = bd.rellenarTablaCoches2();

		// Bucle para cada resultado en la consulta
		try {
			while (rs.next())
			{
				// Se crea un array que será una de las filas de la tabla.
				Object [] fila = new Object[8]; // Hay ocho columnas en la tabla

				// Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
				for (int i=0;i<fila.length;i++)
					if (i == 6) {
						if (rs.getObject(i+1).equals(0)) {
							fila[i] = "No";
						} else {
							fila[i] = "Si";
						}
					} else {
						fila[i] = rs.getObject(i+1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.
					}
				// Se añade al modelo la fila completa.
				modeloC2.addRow(fila);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		bd.desconectar();
	}

	private void setDataM() {
		modeloM = new DefaultTableModel();
		tablaM = new JTable(modeloM);

		// Creamos las columnas.
		modeloM.addColumn("Marca");
		modeloM.addColumn("Modelo");
		modeloM.addColumn("Color");
		modeloM.addColumn("Caballos");
		modeloM.addColumn("Plazas");
		modeloM.addColumn("Precio");
		modeloM.addColumn("Estructura protectora");

		GestorBD bd = new GestorBD();
		ResultSet rs = bd.rellenarTablaMotos();

		// Bucle para cada resultado en la consulta
		try {
			while (rs.next())
			{
				// Se crea un array que será una de las filas de la tabla.
				Object [] fila = new Object[7]; // Hay siete columnas en la tabla

				// Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
				for (int i=0;i<fila.length;i++)
					if (i == 6) {
						if (rs.getObject(i+1).equals(0)) {
							fila[i] = "No";
						} else {
							fila[i] = "Si";
						}
					} else {
						fila[i] = rs.getObject(i+1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.
					}
				// Se añade al modelo la fila completa.
				modeloM.addRow(fila);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		bd.desconectar();
	}

	private void setDataM2() {
		modeloM2 = new DefaultTableModel();
		tablaM2 = new JTable(modeloM2);

		// Creamos las columnas.
		modeloM2.addColumn("Marca");
		modeloM2.addColumn("Modelo");
		modeloM2.addColumn("Color");
		modeloM2.addColumn("Caballos");
		modeloM2.addColumn("Plazas");
		modeloM2.addColumn("Precio");
		modeloM2.addColumn("Estructura protectora");
		modeloM2.addColumn("Kilómetros");

		GestorBD bd = new GestorBD();
		ResultSet rs = bd.rellenarTablaMotos2();

		// Bucle para cada resultado en la consulta
		try {
			while (rs.next())
			{
				// Se crea un array que será una de las filas de la tabla.
				Object [] fila = new Object[8]; // Hay ocho columnas en la tabla

				// Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
				for (int i=0;i<fila.length;i++)
					if (i == 6) {
						if (rs.getObject(i+1).equals(0)) {
							fila[i] = "No";
						} else {
							fila[i] = "Si";
						}
					} else {
						fila[i] = rs.getObject(i+1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.
					}
				// Se añade al modelo la fila completa.
				modeloM2.addRow(fila);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		bd.desconectar();
	}

	private void volver(Trabajador t) {
		if (t.isAdmin()) {
			VistaAdministrador.abrirVistaAdministrador(t);
			dispose();
		} else {
			VistaTrabajador.abrirVistaTrabajador(t);
			dispose();
		}
	}

	public static void abrirTablasVehiculos(Trabajador t) {
		TablasVehiculos tablasVehiculos = new TablasVehiculos(t);
		tablasVehiculos.setVisible(true);
		tablasVehiculos.setSize(600,550);
		tablasVehiculos.setLocationRelativeTo(null);
	}
}