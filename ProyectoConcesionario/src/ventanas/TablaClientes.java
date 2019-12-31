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
	
	//TODO terminar ventana
	public TablaClientes(Trabajador t) {
		this.setTitle("Tabla de clientes");
		
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
		
		eliminarButton = new JButton("Eliminar");
		botonesPanel.add(eliminarButton);
		
		atrasButton = new JButton("Atrás");
		botonesPanel.add(atrasButton);
		
		anadirButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO llamar a añadir cliente
				dispose();
			}
		});
		
		eliminarButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO hacer que saque el nombre del cliente
				//TODO Hacer que borre el seleccionado
				String[] opciones = {"Sí", "No"};
				JOptionPane.showOptionDialog( null, "¿Está seguro de borrar los datos del cliente .... ?", "Borrar", JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);	
				System.out.println();
			}
		});
		
		atrasButton.addActionListener(new ActionListener() {
			//TODO hacer que vuelva al admin o al trabajador
			@Override
			public void actionPerformed(ActionEvent e) {
				VistaAdministrador.abrirVistaAdministrador();
				dispose();
			}
		});
		
		add(tablaPanel, BorderLayout.CENTER);
		add(botonesPanel, BorderLayout.SOUTH);

		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);

		
		
		
		this.setVisible(true);
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
