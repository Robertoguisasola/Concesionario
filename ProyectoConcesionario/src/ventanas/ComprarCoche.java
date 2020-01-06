package ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

import dataBase.GestorBD;
import model.Persona;

public class ComprarCoche extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel northPanel;
	private JPanel leftPanel;
	private Box leftBox;
	private JPanel botonesPanel;
	
	private JLabel informacionLabel;
	private JButton salirButton;
	
	private JLabel marcaLabel;
	private JComboBox<String> marcaCombo;
	private Box marcaBox;
	private JLabel colorLabel;
	private JComboBox<model.Colores> colorCombo;
	private Box colorBox;
	private JLabel plazasLabel;
	private JSpinner plazasSpinnner;
	private Box plazasBox;
	private JButton buscarButton;

	private JScrollPane tablaPanel;
	private JTable tabla;
	private DefaultTableModel modelo;
	
	private JButton comprarButton;
	private JButton probarButton;
	private Box botonesBox;
		
	public ComprarCoche(Persona p) {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		northPanel = new JPanel();
		northPanel.setLayout(new BorderLayout());
		
		String frase = "<html><body><left>Busque el coche, seleccionelo en la tabla e indique si quiere probarlo o comprarlo</left></body></html>";
		
		informacionLabel = new JLabel(frase);
		northPanel.add(informacionLabel, BorderLayout.WEST);
		
		salirButton = new JButton("Salir");
		salirButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Login.abrirLogin();
				
			}
		});
		
		northPanel.add(salirButton, BorderLayout.EAST);
		
		leftPanel = new JPanel();
		leftPanel.setLayout(new BorderLayout());
		
		String frase2 = "<html><body><left>Elige las características del coche</left></body></html>";
		
		informacionLabel = new JLabel(frase2);
		leftPanel.add(informacionLabel, BorderLayout.NORTH);

		marcaLabel = new JLabel("Marca: ");
		marcaCombo = new JComboBox<String>();
		
		GestorBD bd = new GestorBD();
		List<String> marcas = bd.obtenerMarcas();
		bd.desconectar();

		for(String marca : marcas)
			marcaCombo.addItem(marca);
		
		marcaBox = new Box(BoxLayout.X_AXIS);
		marcaBox.add(marcaLabel);
		marcaBox.add(Box.createRigidArea(new Dimension(46, 12)));
		marcaBox.add(marcaCombo);
		
		colorLabel = new JLabel("Color: ");
		colorCombo = new JComboBox<model.Colores>();
		for(model.Colores color : model.Colores.values())
			colorCombo.addItem(color);
		
		colorBox = new Box(BoxLayout.X_AXIS);
		colorBox.add(colorLabel);
		colorBox.add(Box.createRigidArea(new Dimension(46, 12)));
		colorBox.add(colorCombo);
		
		plazasLabel = new JLabel("Plazas mínimas");
		plazasSpinnner = new JSpinner();
		SpinnerNumberModel plazas = new SpinnerNumberModel();
		plazas.setValue(1);
		plazas.setMaximum(9);
		plazas.setMinimum(1);
		plazasSpinnner.setModel(plazas);
		
		plazasBox = new Box(BoxLayout.X_AXIS);
		plazasBox.add(plazasLabel);
		plazasBox.add(Box.createRigidArea(new Dimension(46, 12)));
		plazasBox.add(plazasSpinnner);
		
		leftBox = new Box(BoxLayout.Y_AXIS);
		leftBox.add(Box.createRigidArea(new Dimension(0,20)));
		leftBox.add(marcaBox);
		leftBox.add(Box.createRigidArea(new Dimension(0,40)));
		leftBox.add(colorBox);
		leftBox.add(Box.createRigidArea(new Dimension(0,40)));
		leftBox.add(plazasBox);
		leftBox.add(Box.createRigidArea(new Dimension(0,100)));
		
		buscarButton = new JButton("Buscar");
		buscarButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO aaaa Buscar el coche
				setData();
				}
		});
				
		leftPanel.add(leftBox, BorderLayout.CENTER);
		leftPanel.add(buscarButton, BorderLayout.SOUTH);
		
		tablaPanel = new JScrollPane(tabla);
		
		comprarButton = new JButton("Comprar");
		comprarButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
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
		
		add(northPanel, BorderLayout.NORTH);
		add(leftPanel, BorderLayout.WEST);
		add(tablaPanel, BorderLayout.CENTER);
		add(botonesPanel, BorderLayout.SOUTH);
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
		
		String marca = marcaCombo.getSelectedItem().toString();
		String color = colorCombo.getSelectedItem().toString().toLowerCase();
		int plazas = Integer.parseInt(plazasSpinnner.getValue().toString());

		GestorBD bd = new GestorBD();
		ResultSet rs = bd.obtenerCochesComprar(marca, color, plazas);

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

	public static void abrirComprarCoche(Persona p) {
		ComprarCoche comprarCoche = new ComprarCoche(p);
		comprarCoche.setTitle("Bienvenido");
		comprarCoche.setVisible(true);
		comprarCoche.setSize(550,420);
		comprarCoche.setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		Persona p = new Persona();
		ComprarCoche.abrirComprarCoche(p);
	}
}