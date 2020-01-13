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

public class TablaVentasMotos2 extends JFrame {

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

	public TablaVentasMotos2(Trabajador t) {
		this.setTitle("Tabla de ventas de motos de segunda mano");

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setData();
		tablaPanel = new JScrollPane(tabla);

		botonesPanel = new JPanel();
		botonesPanel.setLayout(new GridBagLayout());

		anadirButton = new JButton("Añadir venta");
		botonesPanel.add(anadirButton);

		eliminarButton = new JButton("Eliminar venta");
		botonesPanel.add(eliminarButton);

		atrasButton = new JButton("Atrás");
		botonesPanel.add(atrasButton);

		anadirButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				EscogerMoto2.abrirEscogerMoto2(null, t);
				dispose();
			}
		});

		eliminarButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] opciones = {"Sí", "No"};
				if(tabla.getSelectedRow() >= 0) {
					String nombre = (String) modelo.getValueAt(tabla.getSelectedRow(), modelo.findColumn("Matricula"));

					int respuesta = JOptionPane.showOptionDialog( null, "¿Está seguro de cancelar la venta de la "+ nombre + " ?", "Cancelar venta", JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

					switch (respuesta) {
					case 0:
						String dni = (String) modelo.getValueAt(tabla.getSelectedRow(), modelo.findColumn("DNI cliente"));
						int precio = Integer.parseInt( modelo.getValueAt(tabla.getSelectedRow(), modelo.findColumn("Precio")).toString());
						String matricula = (String) modelo.getValueAt(tabla.getSelectedRow(), modelo.findColumn("Matricula"));

						GestorBD bd = new GestorBD();
						bd.eliminarVenta("ventamoto2", dni, precio, matricula);
						bd.desconectar();

						TablaVentasMotos2.abrirTablaVentasMotos2(t);
						dispose();
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
				volver(t);
			}
		});

		add(tablaPanel, BorderLayout.CENTER);
		add(botonesPanel, BorderLayout.SOUTH);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);

		this.setVisible(true);
	}

	private void setData() {
		modelo = new DefaultTableModel();
		tabla = new JTable(modelo);

		// Creamos las columnas.
		modelo.addColumn("DNI cliente");
		modelo.addColumn("Moto");
		modelo.addColumn("Precio");
		modelo.addColumn("Matricula");
		modelo.addColumn("Kilometros");

		GestorBD bd = new GestorBD();
		ResultSet rs = bd.rellenarTablaVentasMotos2();

		// Bucle para cada resultado en la consulta
		try {
			while (rs.next()){
				// Se crea un array que será una de las filas de la tabla.
				Object [] fila = new Object[5]; // Hay cinco columnas en la tabla

				// Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
				for (int i = 0;i<fila.length;i++) {
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

	private void volver(Trabajador t) {
		if (t.isAdmin()) {
			VistaAdministrador.abrirVistaAdministrador(t);
			dispose();
		} else {
			VistaTrabajador.abrirVistaTrabajador(t);
			dispose();
		}
	}

	public static void abrirTablaVentasMotos2(Trabajador t) {
		TablaVentasMotos2 tablaVentasMotos2 = new TablaVentasMotos2(t);
		tablaVentasMotos2.setVisible(true);
		tablaVentasMotos2.setSize(480,360);
		tablaVentasMotos2.setLocationRelativeTo(null);
	}
}