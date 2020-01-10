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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dataBase.GestorBD;
import model.Trabajador;

public class TablaMotos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JScrollPane tablaPanel;
	private JPanel botonesPanel;
	private JButton anadirButton;
	private JButton eliminarButton;
	private JButton atrasButton;
	private JTable tabla;
	private DefaultTableModel modelo;	

	public TablaMotos(Trabajador t) {
		//TODO aaaa modificar las cosas para que saque motos y así
		this.setTitle("Tabla de motos");

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setData();
		tablaPanel = new JScrollPane(tabla);

		botonesPanel = new JPanel();
		botonesPanel.setLayout(new GridBagLayout());

		anadirButton = new JButton("Añadir moto");
		botonesPanel.add(anadirButton);

		eliminarButton = new JButton("Eliminar moto");
		botonesPanel.add(eliminarButton);
		
		atrasButton = new JButton("Atrás");
		botonesPanel.add(atrasButton);

		anadirButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AnadirMoto.abrirAnadirMoto(t);
				dispose();
			}
		});

		eliminarButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] opciones = {"Sí", "No"};
				if(tabla.getSelectedRow() >= 0) {
					String nombre = (String) modelo.getValueAt(tabla.getSelectedRow(), modelo.findColumn("Marca"));

					int respuesta = JOptionPane.showOptionDialog( null, "¿Está seguro de eliminar la "+ nombre + " ?", "Borrar", JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

					switch (respuesta) {
					case 0:
						GestorBD bd = new GestorBD();
						String marca = (String) modelo.getValueAt(tabla.getSelectedRow(), modelo.findColumn("Marca"));
						String modeloc = (String) modelo.getValueAt(tabla.getSelectedRow(), modelo.findColumn("Modelo"));
						String color = (String) modelo.getValueAt(tabla.getSelectedRow(), modelo.findColumn("Color"));
						int caballos = Integer.parseInt( modelo.getValueAt(tabla.getSelectedRow(), modelo.findColumn("Caballos")).toString());
						int plazas = Integer.parseInt( modelo.getValueAt(tabla.getSelectedRow(), modelo.findColumn("Plazas")).toString());
						int precio = Integer.parseInt(modelo.getValueAt(tabla.getSelectedRow(), modelo.findColumn("Precio")).toString());
						int estructura;
						
						if ((boolean) modelo.getValueAt(tabla.getSelectedRow(), modelo.findColumn("Estructura protectora")).equals("No")) {
							estructura = 0;
						} else {
							estructura = 1;
						}
						
						bd.eliminarMoto(marca, modeloc, color, caballos, plazas, precio, estructura);
						bd.desconectar();
						//TODO refrescar tabla
						break;
					default:
						break;
					}
				} else {
					JOptionPane.showMessageDialog(null, "Selecciona una fila de la tabla", null, 0);
				}
			}
		});
		
		atrasButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (t.isAdmin()) {
					VistaAdministrador.abrirVistaAdministrador(t);
					dispose();
				} else {
					VistaTrabajador.abrirVistaTrabajador(t);
					dispose();
				}
			}
		});

		add(tablaPanel, BorderLayout.CENTER);
		add(botonesPanel, BorderLayout.SOUTH);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);

		this.setVisible(true);
	}

	//Añadimos datos
	private void setData() {
		modelo = new DefaultTableModel();
		tabla = new JTable(modelo);

		// Creamos las columnas.
		modelo.addColumn("Marca");
		modelo.addColumn("Modelo");
		modelo.addColumn("Color");
		modelo.addColumn("Caballos");
		modelo.addColumn("Plazas");
		modelo.addColumn("Precio");
		modelo.addColumn("Estructura protectora");

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
				modelo.addRow(fila);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		bd.desconectar();
	}

	public static void abrirTablaMotos(Trabajador t) {
		TablaMotos tablaMotos = new TablaMotos(t);
		tablaMotos.setVisible(true);
		tablaMotos.setSize(480,360);
		tablaMotos.setLocationRelativeTo(null);
	}
}