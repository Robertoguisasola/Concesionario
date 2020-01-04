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
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import dataBase.GestorBD;
import model.Trabajador;

public class TablaClientes extends JFrame {

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

	public TablaClientes(Trabajador t) {
		this.setTitle("Tabla de clientes");

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(480,360);
		this.setResizable(true);
		this.setLocationRelativeTo(null);

		setData();
		tablaPanel = new JScrollPane(tabla);

		botonesPanel = new JPanel();
		botonesPanel.setLayout(new GridBagLayout());

		anadirButton = new JButton("Añadir cliente");
		botonesPanel.add(anadirButton);

		eliminarButton = new JButton("Eliminar cliente");
		botonesPanel.add(eliminarButton);
		
		atrasButton = new JButton("Atrás");
		botonesPanel.add(atrasButton);

		anadirButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO va a registrar un nuevo cliente
			}
		});

		eliminarButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] opciones = {"Sí", "No"};
				if(tabla.getSelectedRow() >= 0) {
					String nombre = (String) modelo.getValueAt(tabla.getSelectedRow(), modelo.findColumn("nombre"));

					int respuesta = JOptionPane.showOptionDialog( null, "¿Está seguro de eliminar a "+ nombre + " ?", "Borrar", JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

					switch (respuesta) {
					case 0:
						GestorBD bd = new GestorBD();
						String dni = (String) modelo.getValueAt(tabla.getSelectedRow(), modelo.findColumn("dNI"));
						bd.eliminarPersona("cliente", dni);
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
		
		atrasButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (t.isAdmin()) {
					VistaAdministrador.abrirVistaAdministrador(t);
				} else {
					VistaTrabajador.abrirVistaTrabajador(t);
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

		//TODO aaaa poner las demás columnas y tal...
		// Creamos las columnas.
		modelo.addColumn("nombre");
		modelo.addColumn("apellidos");
		modelo.addColumn("DNI");
		modelo.addColumn("email");
		modelo.addColumn("fechaNacimiento");

		GestorBD bd = new GestorBD();
		ResultSet rs = bd.rellenarTablaClientes();

		// Bucle para cada resultado en la consulta
		try {
			while (rs.next())
			{
				// Se crea un array que será una de las filas de la tabla.
				Object [] fila = new Object[3]; // Hay tres columnas en la tabla

				// Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
				for (int i=0;i<fila.length;i++)
					fila[i] = rs.getObject(i+1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.

				// Se añade al modelo la fila completa.
				modelo.addRow(fila);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		bd.desconectar();
	}



	public static void abrirTablaClientes(Trabajador t) {
		TablaClientes tablaClientes = new TablaClientes(t);
		tablaClientes.setVisible(true);
		tablaClientes.setSize(480,360);
		tablaClientes.setLocationRelativeTo(null);
		tablaClientes.setVisible(true);
	}

	//TODO borrar cuando funcione como queremos
	public static void main(String[] args) {
		Trabajador t = new Trabajador();

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new TablaClientes(t);
			}
		});
	}
}
