package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import model.Cliente;
import model.Concesionario;

public class VentanaCatalogoCoche extends JFrame {
	//TODO eliminar y convertir en tabla
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuBar barraCatalogo;
	private JMenu vehiculosCatalogo;
	private JMenu ofertasCatalogo;
	private JMenu cuentaCatalogo;
	private JMenuItem cochesItem;
	private JMenuItem motosItem;
	private JMenuItem iniciarSesionItem;
	private JMenuItem datosItem;
	private JMenuItem cerrarSesionItem;
	private Container mainContainer;
	private JPanel topPanel;
	private JPanel middlePanel;
	private JPanel gridPanel;
	private JPanel buscarPanel;
	private JPanel centerPanel;
	private JLabel labelCaballos;
	private JLabel labelPlazas;
	private JLabel labelColor;
	private JLabel labelMarca;
	private JComboBox comboCaballos;
	private JComboBox comboPlazas;
	private JComboBox comboColor;
	private JComboBox comboMarca;
	private JCheckBox checkAutomatico;
	private JCheckBox checkLucesLed;
	private JCheckBox checkTechoPanoramico;
	private JCheckBox checkTraccion;
	private JCheckBox checkModoDeportivo;
	private JButton buscarButton;
	private Box buttonBox;
	
	public VentanaCatalogoCoche(Cliente c, Concesionario cn) {
		this.setSize(480,360);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
				
		barraCatalogo = new JMenuBar();
		
		vehiculosCatalogo = new JMenu("VEHICULOS");
		ofertasCatalogo = new JMenu("SUPER OFERTAS");
		cuentaCatalogo = new JMenu("MI CUENTA");
	
		cochesItem = new JMenuItem("COCHES");
		motosItem = new JMenuItem("MOTOS");
		iniciarSesionItem= new JMenuItem("INICIAR SESION");
		datosItem = new JMenuItem("VER MIS DATOS");
		cerrarSesionItem = new JMenuItem("CERRAR SESION");
		
		cochesItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		motosItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		iniciarSesionItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login ventanaLogin = new Login(cn);
				ventanaLogin.setVisible(true);
				ventanaLogin.setSize(450,260);
				ventanaLogin.setLocationRelativeTo(null);
				ventanaLogin.setVisible(true);
				dispose();
			}
		});
		datosItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Inicio.abrirInicio(cn);
				dispose();				
			}
		});
		cerrarSesionItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				visualizarPanelesCoche();				
			}
		});
		
		vehiculosCatalogo.add(cochesItem);
		vehiculosCatalogo.add(motosItem);
		cuentaCatalogo.add(iniciarSesionItem);
		cuentaCatalogo.addSeparator();
		cuentaCatalogo.add(datosItem);
		cuentaCatalogo.addSeparator();
		cuentaCatalogo.add(cerrarSesionItem);
		
		barraCatalogo.add(vehiculosCatalogo);
		barraCatalogo.add(ofertasCatalogo);
		barraCatalogo.add(cuentaCatalogo);
		
		mainContainer = this.getContentPane();
		mainContainer.setLayout(new BorderLayout(8,6));
		
		setJMenuBar(barraCatalogo);	
		
		//TODO esto solo es para ver bien los paneles, luego borrar.
	
		middlePanel = new JPanel();
		middlePanel.setBorder(new LineBorder(Color.black, 3));
		middlePanel.setLayout(new FlowLayout(4,4,4));		
		
		gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(13,2));
		gridPanel.setBorder(new LineBorder(Color.BLACK, 3));
		
		buscarPanel = new JPanel();
		buscarPanel.setLayout(new GridLayout(1,2));
		buscarPanel.setBorder(new LineBorder(Color.BLACK, 3));
		
		//TODO meter los componentes del girdPanel.
		//TODO hay que meter los items en los JComoBoxes
		labelCaballos = new JLabel("Caballos: ");
		comboCaballos = new JComboBox();
		comboCaballos.addItem("70");
		comboCaballos.addItem("100");
		comboCaballos.addItem("120");
		comboCaballos.addItem("150");
		comboCaballos.addItem("200");
		labelPlazas = new JLabel("Plazas: ");
		comboPlazas = new JComboBox();
		comboPlazas.addItem("1");
		comboPlazas.addItem("2");
		comboPlazas.addItem("4");
		comboPlazas.addItem("5");
		comboPlazas.addItem("7");
		comboPlazas.addItem("9");
		
		labelColor = new JLabel("Color: ");
		comboColor = new JComboBox();
		comboColor.addItem("Negro");
		comboColor.addItem("Blanco");
		comboColor.addItem("Azul");
		comboColor.addItem("Rojo");
		comboColor.addItem("Gris");
		
		labelMarca = new JLabel("Marca: ");
		comboMarca = new JComboBox();
		comboMarca.addItem("Renault");
		comboMarca.addItem("BMW");
		comboMarca.addItem("Seat");
		comboMarca.addItem("Honda");
		comboMarca.addItem("Kia");
		checkAutomatico = new JCheckBox("Automático");
		checkLucesLed = new JCheckBox("Luces led");
		checkTechoPanoramico = new JCheckBox("Techo panorámico");
		checkTraccion = new JCheckBox("Tracción 4x4");
		checkModoDeportivo = new JCheckBox("Modo deportivo");
		buscarButton= new JButton("Buscar");
		buscarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO Crear venta
			}
		});

		gridPanel.add(labelCaballos);
		gridPanel.add(comboCaballos);
		gridPanel.add(labelPlazas);
		gridPanel.add(comboPlazas);
		gridPanel.add(labelColor);
		gridPanel.add(comboColor);
		gridPanel.add(labelMarca);
		gridPanel.add(comboMarca);
		gridPanel.add(checkAutomatico);
		gridPanel.add(checkLucesLed);
		gridPanel.add(checkTechoPanoramico);
		gridPanel.add(checkTraccion);
		gridPanel.add(checkModoDeportivo);
		buscarPanel.add(buscarButton);
		
		centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout());
		centerPanel.setBorder(new LineBorder(Color.BLACK, 3));
	
		middlePanel.add(gridPanel);
		middlePanel.add(buscarPanel);
		//TODO poner el panel del boton buscar debajo del panel con los datos del coche
		mainContainer.add(centerPanel);
		mainContainer.add(middlePanel, BorderLayout.WEST);
 	}
	
	public void visualizarPanelesCoche() {
		//MiddlePanel				
	}
	
}