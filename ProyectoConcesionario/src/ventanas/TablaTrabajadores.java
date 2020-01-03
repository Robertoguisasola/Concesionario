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

public class TablaTrabajadores extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JScrollPane tablaPanel;
	private JPanel botonesPanel;
	private JButton anadirButton;
	private JButton despedirButton;
	private JButton atrasButton;
	private JTable tabla;
	private DefaultTableModel modelo;
	
	public TablaTrabajadores(Trabajador t) {
		this.setTitle("Tabla de Trabajadores");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(480,360);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		
		setData();
		tablaPanel = new JScrollPane(tabla);
		
		botonesPanel = new JPanel();
		botonesPanel.setLayout(new GridBagLayout());

		anadirButton = new JButton("Contratar trabajador");
		botonesPanel.add(anadirButton);
		
		despedirButton = new JButton("Despedir trabajador");
		botonesPanel.add(despedirButton);
		
		atrasButton = new JButton("Atrás");
		botonesPanel.add(atrasButton);
		
		anadirButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ContratarTrabajador.abrirContratarTrabajador(t);
				dispose();
			}
		});
		
		despedirButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Hacer que borre el seleccionado
				String[] opciones = {"Sí", "No"};
				if(tabla.getSelectedRow() >= 0) {
					String nombre = (String) modelo.getValueAt(tabla.getSelectedRow(), modelo.findColumn("nombre"));
					
					int respuesta = JOptionPane.showOptionDialog( null, "¿Está seguro de despedir a "+ nombre + " ?", "Borrar", JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
					
					switch (respuesta) {
					case 0:
						GestorBD bd = new GestorBD();
						String dni = (String) modelo.getValueAt(tabla.getSelectedRow(), modelo.findColumn("dni"));
						bd.borrarA("trabajador", dni);
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
				//TODO zzzz como hacer que identifique si eres el admin o el trabajador
				
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
		modelo.addColumn("nombre");
		modelo.addColumn("apellidos");
		
		GestorBD bd = new GestorBD();
		ResultSet rs = bd.rellenarTablaTrabajadores();
		
		// Bucle para cada resultado en la consulta
		try {
			while (rs.next())
			{
			   // Se crea un array que será una de las filas de la tabla.
			   Object [] fila = new Object[2]; // Hay tres columnas en la tabla

			   // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
			   for (int i=0;i<fila.length;i++)
			      fila[i] = rs.getObject(i+1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.

			   // Se añade al modelo la fila completa.
			   modelo.addRow(fila);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bd.desconectar();
	}
	
	public static void abrirTablaTrabajadores(Trabajador t) {
		TablaTrabajadores tablaTrabajadores = new TablaTrabajadores(t);
		tablaTrabajadores.setVisible(true);
		tablaTrabajadores.setSize(480,360);
		tablaTrabajadores.setLocationRelativeTo(null);
		tablaTrabajadores.setVisible(true);
	}
	
	//TODO borrar cuando funcione como queremos
	public static void main(String[] args) {
		Trabajador t = new Trabajador();

		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new TablaTrabajadores(t);
			}
		});
	}
}
