package ventanas;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

import model.Trabajador;

public class TablaVentas extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JScrollPane tablaPanel;
	private JPanel botonesPanel;
	private JButton anadirButton;
	private JButton cancelarButton;
	private JTable tabla;
	
	//TODO terminar ventana
	public TablaVentas(Trabajador t) {
		this.setTitle("Tabla de coches");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(480,360);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		
		//TODO rellenar columnas y sacar datos
		String[] columNames = {"Column1", "Column2"};
		String[][] data = {
				{"Nombre1", "Dato1"},
				{"Nombre2", "Dato2"},
		};
		
		tabla = new JTable(data, columNames);
		
		tablaPanel = new JScrollPane(tabla);
		
		
		botonesPanel = new JPanel();
		botonesPanel.setLayout(new GridBagLayout());

		anadirButton = new JButton("Añadir");
		botonesPanel.add(anadirButton);
		
		cancelarButton = new JButton("Eliminar");
		botonesPanel.add(cancelarButton);
		
		anadirButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
<<<<<<< HEAD
				//TODO ir a crear venta o algo así
=======
				VentanaAnadirCoche.abrirVentanaAnadirCoche();
>>>>>>> branch 'master' of https://github.com/Robertoguisasola/Concesionario
				dispose();
			}
		});
		
		cancelarButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Hacer que borre el seleccionado
				String[] opciones = {"Sí", "No"};
				JOptionPane.showOptionDialog( null, "¿Está seguro de cancelar el pedido?", "Borrar", JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);	
				System.out.println();
			}
		});
		
		add(tablaPanel, BorderLayout.CENTER);
		add(botonesPanel, BorderLayout.SOUTH);

		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);

		
		
		
		this.setVisible(true);
	}
	
	public static void abrirTablaVentas(Trabajador t) {
		TablaVentas tablaVentas = new TablaVentas(t);
		tablaVentas.setVisible(true);
		tablaVentas.setSize(480,360);
		tablaVentas.setLocationRelativeTo(null);
		tablaVentas.setVisible(true);
	}
	
	//TODO borrar cuando funcione como queremos
	public static void main(String[] args) {
		Trabajador t = new Trabajador();

		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new TablaVentas(t);
			}
		});
	}
}
