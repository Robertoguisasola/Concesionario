package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import model.Coche;
import model.Trabajador;

public class VentanaAnadirCoche extends JFrame {
	
	private JPanel opcionesPanel;
	private JPanel botonesPanel;
	private Box buttonsBox;
	private JButton anadirCocheButton;
	private JButton cancelButton;
	
	private JLabel labelMatricula;
	private JTextField fieldMatricula;
	
	private JLabel labelNRuedas;
	private JComboBox<Integer> comboNRuedas;
	
	private JLabel labelCaballos;
	private JComboBox<Integer> comboCaballos;
	
	private JLabel labelPlazas;
	private JComboBox<Integer> comboPlazas;
	
	private JLabel labelColor;
	private JComboBox<String> comboColor;
	
	private JLabel labelMarca;
	private JComboBox<String> comboMarca;
	
	private JLabel labelModelo;
	private JTextField fieldModelo;
	
	private JCheckBox checkAutomatico;
	private JCheckBox checkLucesLed;
	private JCheckBox checkTechoPanoramico;
	private JCheckBox checkTraccion;
	private JCheckBox checkModoDeportivo;
	
	public VentanaAnadirCoche(Trabajador t) {
		//TODO que muestre un titulo personalizado para el trabajador
		//this.setTitle(t.getNombre()+" "+t.getApellidos()+", a�ada un coche a la base de datos");
		this.setTitle("A�adir coche");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(480, 360);
		this.setResizable(true);
		
		opcionesPanel = new JPanel();
		opcionesPanel.setLayout(new GridLayout(13,2));
		opcionesPanel.setBorder(new LineBorder(Color.BLACK, 3));
		
		labelMatricula = new JLabel("Matricula: ");
		fieldMatricula = new JTextField();
		
		labelNRuedas = new JLabel("N� Ruedas: ");
		comboNRuedas = new JComboBox<Integer>();
		comboNRuedas.addItem(2);
		comboNRuedas.addItem(3);
		comboNRuedas.addItem(4);
		
		labelCaballos = new JLabel("Caballos: ");
		comboCaballos = new JComboBox<Integer>();
		comboCaballos.addItem(70);
		comboCaballos.addItem(100);
		comboCaballos.addItem(120);
		comboCaballos.addItem(150);
		comboCaballos.addItem(200);
		
		labelPlazas = new JLabel("Plazas: ");
		comboPlazas = new JComboBox<Integer>();
		comboPlazas.addItem(1);
		comboPlazas.addItem(2);
		comboPlazas.addItem(4);
		comboPlazas.addItem(5);
		comboPlazas.addItem(7);
		comboPlazas.addItem(9);
		
		labelColor = new JLabel("Color: ");
		comboColor = new JComboBox<String>();
		comboColor.addItem("Negro");
		comboColor.addItem("Blanco");
		comboColor.addItem("Azul");
		comboColor.addItem("Rojo");
		comboColor.addItem("Gris");
		
		labelMarca = new JLabel("Marca: ");
		comboMarca = new JComboBox<String>();
		comboMarca.addItem("Renault");
		comboMarca.addItem("BMW");
		comboMarca.addItem("Seat");
		comboMarca.addItem("Honda");
		comboMarca.addItem("Kia");
		
		labelModelo = new JLabel("Modelo: ");
		fieldModelo = new JTextField();
		
		checkAutomatico = new JCheckBox("Autom�tico");
		checkLucesLed = new JCheckBox("Luces led");
		checkTechoPanoramico = new JCheckBox("Techo panor�mico");
		checkTraccion = new JCheckBox("Tracci�n 4x4");
		checkModoDeportivo = new JCheckBox("Modo deportivo");

		opcionesPanel.add(labelMatricula);
		opcionesPanel.add(fieldMatricula);
		opcionesPanel.add(labelNRuedas);
		opcionesPanel.add(comboNRuedas);
		opcionesPanel.add(labelCaballos);
		opcionesPanel.add(comboCaballos);
		opcionesPanel.add(labelPlazas);
		opcionesPanel.add(comboPlazas);
		opcionesPanel.add(labelColor);
		opcionesPanel.add(comboColor);
		opcionesPanel.add(labelMarca);
		opcionesPanel.add(comboMarca);
		opcionesPanel.add(labelModelo);
		opcionesPanel.add(fieldModelo);
		opcionesPanel.add(checkAutomatico);
		opcionesPanel.add(checkLucesLed);
		opcionesPanel.add(checkTechoPanoramico);
		opcionesPanel.add(checkTraccion);
		opcionesPanel.add(checkModoDeportivo);
		
		botonesPanel = new JPanel();
		botonesPanel.setLayout(new GridLayout(1,8));
		botonesPanel.setBorder(new LineBorder(Color.BLACK, 3));
		buttonsBox = new Box(BoxLayout.Y_AXIS);
		
		anadirCocheButton = new JButton("Registrar coche");
		anadirCocheButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Coche c= new Coche();
				c.setMatricula(fieldMatricula.getText());
				c.setNumRuedas((int)comboNRuedas.getSelectedItem());
				c.setCaballos((int)comboCaballos.getSelectedItem());
				c.setnPlazas((int)comboPlazas.getSelectedItem());
				c.setColor(comboColor.getSelectedItem().toString());
				c.setMarca(comboMarca.getSelectedItem().toString());
				c.setModelo(fieldModelo.getText());
				c.setAutomatico(checkAutomatico.isSelected());
				c.setLucesLed(checkLucesLed.isSelected());
				c.setTechoPanoramico(checkTechoPanoramico.isSelected());
				c.setTraccion4x4(checkTraccion.isSelected());
				c.setModoDeportivo(checkModoDeportivo.isSelected());
				//TODO FALTA REGISTRAR EL COCHE EN LA BASE DE DATOS
			}
		});
		
		cancelButton = new JButton("Cancelar");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaTrabajador ventanaTrabajador = new VentanaTrabajador(t);
				ventanaTrabajador.setLocationRelativeTo(null);
				ventanaTrabajador.setVisible(true);
				dispose();
			}
		});
		
		buttonsBox.add(anadirCocheButton);
		buttonsBox.add(cancelButton);
				
		GridBagConstraints gbc_buttonsBox = new GridBagConstraints();
		gbc_buttonsBox.gridx = 0;
		botonesPanel.add(buttonsBox, gbc_buttonsBox);
		
		getContentPane().add(opcionesPanel, BorderLayout.CENTER);
		getContentPane().add(botonesPanel,BorderLayout.SOUTH);
		
		this.setVisible(true);

	}
}

