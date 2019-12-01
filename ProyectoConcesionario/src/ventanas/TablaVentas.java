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
	
	//TODO R terminar ventana
	public TablaVentas(Trabajador t) {
		this.setTitle("Tabla de coches");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(480,360);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		
		//TODO rellenar columnas
		String[] columNames = {"Column1", "Column2"};
		String[][] data = {
				{"Nombre1", "Dato1"},
				{"Nombre2", "Dato2"},
		};
		
		tabla = new JTable(data, columNames);
		
		tablaPanel = new JScrollPane(tabla);
		
		
		botonesPanel = new JPanel();
		botonesPanel.setLayout(new GridBagLayout());

		anadirButton = new JButton("A�adir");
		botonesPanel.add(anadirButton);
		
		cancelarButton = new JButton("Eliminar");
		botonesPanel.add(cancelarButton);
		
		anadirButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaAnadirCoche ventanaAnadirCoche = new VentanaAnadirCoche(t);
				ventanaAnadirCoche.setLocationRelativeTo(null);
				ventanaAnadirCoche.setVisible(true);
				dispose();
			}
		});
		
		cancelarButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Hacer que borre el seleccionado
				String[] opciones = {"S�", "No"};
				JOptionPane.showOptionDialog( null, "�Est� seguro de cancelar el pedido?", "Borrar", JOptionPane.YES_NO_CANCEL_OPTION,
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
