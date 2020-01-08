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

public class TablaVentas extends JFrame {
	
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
	
	public TablaVentas(Trabajador t) {
		this.setTitle("Tabla de ventas");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(480,360);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		
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
				EscogerCoche.abrirEscogerCoche(null, t);
				dispose();
			}
		});
		
		eliminarButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] opciones = {"Sí", "No"};
				if(tabla.getSelectedRow() >= 0) {
					String nombre = (String) modelo.getValueAt(tabla.getSelectedRow(), modelo.findColumn("Matricula"));

					int respuesta = JOptionPane.showOptionDialog( null, "¿Está seguro de despedir a "+ nombre + " ?", "Borrar", JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
					//TODO qqqq actualizar tabla al borrar
					switch (respuesta) {
					case 0:
						GestorBD bd = new GestorBD();
						String dni = (String) modelo.getValueAt(tabla.getSelectedRow(), modelo.findColumn("DNI"));
						bd.eliminarPersona("trabajador", dni);
						bd.desconectar();
						break;
					default:
						break;
					}
				}else {
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
	

	private void setData() {
		modelo = new DefaultTableModel();
		tabla = new JTable(modelo);

		// Creamos las columnas.
		modelo.addColumn("DNI cliente");
		modelo.addColumn("Coche");
		modelo.addColumn("Precio");
		modelo.addColumn("Matricula");
		modelo.addColumn("Automatico");
		modelo.addColumn("Luces led");
		modelo.addColumn("Techo panoramico");
		modelo.addColumn("Traccion 4X4");
		modelo.addColumn("Modo deportivo");

		GestorBD bd = new GestorBD();
		ResultSet rs = bd.rellenarTablaVentasCoches();

		// Bucle para cada resultado en la consulta
		try {
			while (rs.next()){
				// Se crea un array que será una de las filas de la tabla.
				Object [] fila = new Object[9]; // Hay nueve columnas en la tabla

				// Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
				for (int i = 0;i<fila.length;i++) {
					//TODO qqqq xq saca 0 y 1???
					
					if (i == 4) {
						if (rs.getObject(i+1).equals(0)) {
							fila[i] = "NO";
						} else {
							fila[i] = "SI";
						}
					} else {
						fila[i] = rs.getObject(i+1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.
					}
					
					if (i == 5) {
						if (rs.getObject(i+1).equals(0)) {
							fila[i] = "NO";
						} else {
							fila[i] = "SI";
						}
					} else {
						fila[i] = rs.getObject(i+1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.
					}
					
					if (i == 6) {
						if (rs.getObject(i+1).equals(0)) {
							fila[i] = "NO";
						} else {
							fila[i] = "SI";
						}
					} else {
						fila[i] = rs.getObject(i+1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.
					}
					
					if (i == 7) {
						if (rs.getObject(i+1).equals(0)) {
							fila[i] = "NO";
						} else {
							fila[i] = "SI";
						}
					} else {
						fila[i] = rs.getObject(i+1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.
					}
					
					if (i == 8) {
						if (rs.getObject(i+1).equals(0)) {
							fila[i] = "NO";
						} else {
							fila[i] = "SI";
						}
					} else {
						fila[i] = rs.getObject(i+1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.
					}
				}

				// Se añade al modelo la fila completa.
				modelo.addRow(fila);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		bd.desconectar();
	}

	
	public static void abrirTablaVentas(Trabajador t) {
		TablaVentas tablaVentas = new TablaVentas(t);
		tablaVentas.setVisible(true);
		tablaVentas.setSize(480,360);
		tablaVentas.setLocationRelativeTo(null);
		tablaVentas.setVisible(true);
	}
}