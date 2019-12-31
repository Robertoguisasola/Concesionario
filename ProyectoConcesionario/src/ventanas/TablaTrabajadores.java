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

public class TablaTrabajadores extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JScrollPane tablaPanel;
	private JPanel botonesPanel;
	private JButton anadirButton;
	private JButton despedirButton;
	private JTable tabla;
	
	//TODO terminar ventana
	public TablaTrabajadores(Trabajador t) {
		this.setTitle("Tabla de Trabajadores");
		
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

		anadirButton = new JButton("Contratar trabajador");
		botonesPanel.add(anadirButton);
		
		despedirButton = new JButton("Despedir trabajador");
		botonesPanel.add(despedirButton);
		
		anadirButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
<<<<<<< HEAD
				ContratarTrabajador.abrirContratarTrabajador(t);
=======
				VentanaAnadirCoche.abrirVentanaAnadirCoche();
>>>>>>> branch 'master' of https://github.com/Robertoguisasola/Concesionario
				dispose();
			}
		});
		
		despedirButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Hacer que borre el seleccionado
				//TODO hacer que saque el nombre del trabajador
				String[] opciones = {"Sí", "No"};
				JOptionPane.showOptionDialog( null, "¿Está seguro de despedir a ... ?", "Borrar", JOptionPane.YES_NO_CANCEL_OPTION,
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
