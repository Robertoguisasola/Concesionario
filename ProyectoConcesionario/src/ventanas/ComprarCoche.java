package ventanas;



import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import model.Coche;
import model.Trabajador;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;



public class ComprarCoche extends JFrame{
	
	private JPanel northPanel;
	private JPanel izquierdaPanel;
	private JPanel derechaPanel;
	private JPanel southPanel;
	private JLabel informacionLabel;
	
	private Box marcaBox;
	private JLabel marcaLabel;
	private JComboBox marcaCombo;
	private Box modeloBox;
	private JLabel modeloLabel;
	private JComboBox modeloCombo;
	private Box colorBox;
	private JLabel colorLabel;
	private JComboBox colorCombo;
	private Box caballoBox;
	private JLabel caballoLabel;
	private JComboBox caballoCombo;
	private Box aceptarBox;
	private JButton aceptarButton;
	private Box probarBox;
	private JButton probarButton;
	private JButton salirButton;
	
	
	public ComprarCoche(Coche c) {
		
		northPanel = new JPanel();
		
		informacionLabel = new JLabel("  Elige las características de tu coche: ");
		salirButton = new JButton("Salir");
		
		northPanel.setLayout(new BorderLayout());
		
		northPanel.add(informacionLabel, BorderLayout.WEST);
		northPanel.add(salirButton, BorderLayout.EAST);
		getContentPane().add(northPanel, BorderLayout.NORTH);
		
		
		izquierdaPanel = new JPanel();
		izquierdaPanel.setLayout(new GridLayout(4,2));
		
		marcaLabel = new JLabel("  Marca:");
		marcaCombo = new JComboBox();//TODO añadir marcas
		modeloLabel = new JLabel("  Modelo:");
		modeloCombo = new JComboBox();//TODO añadir marcas
		colorLabel = new JLabel("  Color:");
		colorCombo = new JComboBox();//TODO añadir marcas
		caballoLabel = new JLabel("  Caballos:");
		caballoCombo = new JComboBox();//TODO añadir marcas
		
		izquierdaPanel.add(marcaLabel);
		izquierdaPanel.add(marcaCombo);
		izquierdaPanel.add(modeloLabel);
		izquierdaPanel.add(modeloCombo);
		izquierdaPanel.add(colorLabel);
		izquierdaPanel.add(colorCombo);
		izquierdaPanel.add(caballoLabel);
		izquierdaPanel.add(caballoCombo);
		
		getContentPane().add(izquierdaPanel, BorderLayout.WEST);
		
		
		
	}
	
	
	public static void abrirComprarCoche(Coche c) {
		ComprarCoche comprarCoche = new ComprarCoche(c);
		comprarCoche.setTitle("Regístrate");
		comprarCoche.setVisible(true);
		comprarCoche.setSize(480,420);
		comprarCoche.setLocationRelativeTo(null);
	}
	

}
	
	


