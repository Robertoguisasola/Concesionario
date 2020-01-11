package ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dataBase.GestorBD;
import model.Cliente;
import model.Coche;
import model.Colores;
import model.Trabajador;
import model.VentaCoche;

public class EscogerCoche extends JFrame{
	//TODO ffff borrar cuando funcione a la perfeccion
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel northPanel;
	private JPanel botonesPanel;

	private JScrollPane tablaPanel;
	private JTable tabla;
	private DefaultTableModel modelo;
	private Box tablaBox;

	private JLabel informacionLabel;
	private JButton volverButton;

	private JButton comprarButton;
	private JButton probarButton;
	private Box botonesBox;

	public EscogerCoche(Cliente c, Trabajador t) {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Bienvenido");

		northPanel = new JPanel();
		northPanel.setLayout(new BorderLayout());

		JPanel centroPanel = new JPanel();
		centroPanel.setLayout(new BorderLayout());

		String frase = "<html><body><left>Busque el coche, seleccionelo en la tabla e indique si quiere probarlo o comprarlo</left></body></html>";

		informacionLabel = new JLabel(frase);
		northPanel.add(informacionLabel, BorderLayout.WEST);	

		volverButton = new JButton("Volver");
		volverButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				volver(c, t);
			}
		});

		northPanel.add(volverButton, BorderLayout.EAST);

		setData();
		tablaPanel = new JScrollPane(tabla);

		tablaPanel = new JScrollPane(tabla);

		tablaBox = new Box(BoxLayout.Y_AXIS);
		tablaBox.add(Box.createRigidArea(new Dimension(0,10)));
		tablaBox.add(tablaPanel);

		comprarButton = new JButton("Comprar coche");
		comprarButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] opciones = {"Sí", "No"};

				if(tabla.getSelectedRow() >= 0) {
					String marca = (String) modelo.getValueAt(tabla.getSelectedRow(), modelo.findColumn("Marca"));
					String modeloc = (String) modelo.getValueAt(tabla.getSelectedRow(), modelo.findColumn("Modelo"));
					String color = (String) modelo.getValueAt(tabla.getSelectedRow(), modelo.findColumn("Color"));
					int caballos = Integer.parseInt( modelo.getValueAt(tabla.getSelectedRow(), modelo.findColumn("Caballos")).toString());
					int plazas = Integer.parseInt( modelo.getValueAt(tabla.getSelectedRow(), modelo.findColumn("Plazas")).toString());
					int precio = Integer.parseInt(modelo.getValueAt(tabla.getSelectedRow(), modelo.findColumn("Precio")).toString());
					boolean diesel;

					if ((boolean) modelo.getValueAt(tabla.getSelectedRow(), modelo.findColumn("Motor diesel")).equals("No")) {
						diesel = false;
					} else {
						diesel = true;
					}

					Coche ch = new Coche(marca, modeloc, Colores.valueOf(color.toUpperCase()), caballos, 4, plazas, precio, diesel);

					int respuesta = JOptionPane.showOptionDialog( null, "¿Desea añadir extras a su coche?", "Extras", JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);	

					switch (respuesta) {
					case 0:
						AnadirExtrasCoche.abriranadirExtrasCoche(c, t, ch);
						dispose();
						break;
					case 1:
						String[] opciones2 = {"Sí, comprar el coche", "No, cambiar"};

						String confirmacion ="<html><body><center>El precio total del coche es de: "  + ch.getPrecio() + "€"+ "</center></body></html>";
						int respuesta2 = JOptionPane.showOptionDialog( null, confirmacion, "Comprar", JOptionPane.YES_NO_CANCEL_OPTION,
								JOptionPane.QUESTION_MESSAGE, null, opciones2, opciones2[0]);
						switch (respuesta2) {
						case 0:
							crearVenta(c, t, ch);
							break;
						case 1:
							JOptionPane.showMessageDialog(null, "Seleccione el coche que desea comprar");
						default:
							break;
						}
						break;
					default:
						break;
					}				
				}
			}
		});	

		probarButton = new JButton("Probar");
		probarButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO llevar a probar coche

			}
		});

		botonesBox = new Box(BoxLayout.X_AXIS);
		botonesBox.add(comprarButton);
		botonesBox.add(Box.createRigidArea(new Dimension(46, 12)));
		botonesBox.add(probarButton);

		botonesPanel = new JPanel();
		botonesPanel.setLayout(new GridBagLayout());
		botonesPanel.add(botonesBox);

		centroPanel.add(tablaBox, BorderLayout.CENTER);

		getContentPane().add(northPanel, BorderLayout.NORTH);
		getContentPane().add(centroPanel, BorderLayout.CENTER);		
		getContentPane().add(botonesPanel, BorderLayout.SOUTH);
	}

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
		modelo.addColumn("Motor diesel");

		GestorBD bd = new GestorBD();
		ResultSet rs = bd.rellenarTablaCoches();

		// Bucle para cada resultado en la consulta
		try {
			while (rs.next()){
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

	private void crearVenta(Cliente c, Trabajador t, Coche ch) {
		VentaCoche vc = new VentaCoche(null, ch, ch.getPrecio(), false, false, false, false, false);
		GestorBD bd = new GestorBD();

		if (c == null) {
			vc.setComprador(t);
		} else {
			vc.setComprador(c);
		}

		bd.venderCoche(vc);

		bd.desconectar();		
	}

	private void volver(Cliente c, Trabajador t) {
		if (t == null) {
			VistaCliente.abrirVistaCliente(c);
		} else {
			if (t.isAdmin()) {
				VistaAdministrador.abrirVistaAdministrador(t);
				dispose();
			} else {
				VistaTrabajador.abrirVistaTrabajador(t);
				dispose();
			}
		}
	}

	public static void abrirEscogerCoche(Cliente c, Trabajador t) {
		EscogerCoche escogerCoche = new EscogerCoche(c, t);
		escogerCoche.setVisible(true);
		escogerCoche.setSize(550,420);
		escogerCoche.setLocationRelativeTo(null);
	}
}