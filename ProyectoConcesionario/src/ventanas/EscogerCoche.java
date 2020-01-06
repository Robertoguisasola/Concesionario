package ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dataBase.GestorBD;
import model.Persona;
import javax.swing.SwingConstants;

public class EscogerCoche extends JFrame{
	
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
	private JButton salirButton;
		
	private JButton comprarButton;
	private JButton probarButton;
	private Box botonesBox;
	
	private JCheckBox techoPanoramicoCheck;
	private Box techoPanoramicoBox;
	private JCheckBox traccionCheck;
	private Box traccionBox;
	private JCheckBox modoDeportivoCheck;
	private Box modoDeportivoBox;
	private JLabel infoCheck;
	
	public EscogerCoche(Persona p) {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		northPanel = new JPanel();
		northPanel.setLayout(new BorderLayout());
		
		JPanel centroPanel = new JPanel();
		centroPanel.setLayout(new BorderLayout());
		
		
		String frase = "<html><body><left>Busque el coche, seleccionelo en la tabla e indique si quiere probarlo o comprarlo</left></body></html>";
		
		informacionLabel = new JLabel(frase);
		northPanel.add(informacionLabel, BorderLayout.WEST);	
		
		
		
		salirButton = new JButton("Salir");
		salirButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Login.abrirLogin();
				dispose();
				
			}
		});
		
		northPanel.add(salirButton, BorderLayout.EAST);
		
		setData();
		tablaPanel = new JScrollPane(tabla);
		
		tablaPanel = new JScrollPane(tabla);
		
		
				
		tablaBox = new Box(BoxLayout.Y_AXIS);
		tablaBox.add(Box.createRigidArea(new Dimension(0,10)));
		tablaBox.add(tablaPanel);
		
		 
		
		
		comprarButton = new JButton("Comprar");
		comprarButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//TODO aaaa o zzzzz hacer un metodo que dependiendo la marca y los extras te saque un mensaje del precio y otro metodo que lo añada a ventas.
				
			}
		});	
		
		probarButton = new JButton("Probar");
		probarButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		botonesBox = new Box(BoxLayout.X_AXIS);
		botonesBox.add(comprarButton);
		botonesBox.add(Box.createRigidArea(new Dimension(46, 12)));
		botonesBox.add(probarButton);
		
		botonesPanel = new JPanel();
		botonesPanel.setLayout(new GridBagLayout());
		botonesPanel.add(botonesBox);
		
		JPanel panelCheck = new JPanel();
		panelCheck.setLayout(new BorderLayout());
		
		infoCheck = new JLabel("¿Quieres añadir algo a tu coche? ");
		techoPanoramicoCheck = new JCheckBox("Techo panorámico ");
		traccionCheck = new JCheckBox("Tracción 4x4 ");
		traccionCheck.setHorizontalAlignment(SwingConstants.CENTER);
		modoDeportivoCheck = new JCheckBox("Modo deportivo ");
		
		panelCheck.add(infoCheck, BorderLayout.NORTH);
		panelCheck.add(techoPanoramicoCheck, BorderLayout.WEST);
		panelCheck.add(traccionCheck, BorderLayout.CENTER);
		panelCheck.add(modoDeportivoCheck, BorderLayout.EAST);
		
		centroPanel.add(panelCheck, BorderLayout.SOUTH);
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
		modelo.addColumn("Motor diesel");
		
		GestorBD bd = new GestorBD();
		ResultSet rs = bd.rellenarTablaCoches();

		// Bucle para cada resultado en la consulta
		try {
			while (rs.next())
			{
				// Se crea un array que será una de las filas de la tabla.
				Object [] fila = new Object[6]; // Hay tres columnas en la tabla

				// Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
				for (int i=0;i<fila.length;i++)
					if (i == 5) {
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

	public static void abrirEscogerCoche(Persona p) {
		EscogerCoche escogerCoche = new EscogerCoche(p);
		escogerCoche.setTitle("Bienvenido");
		escogerCoche.setVisible(true);
		escogerCoche.setSize(550,420);
		escogerCoche.setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		Persona p = new Persona();
		EscogerCoche.abrirEscogerCoche(p);
	}
}