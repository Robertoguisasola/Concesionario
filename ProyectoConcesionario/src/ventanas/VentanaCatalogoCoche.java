package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class VentanaCatalogoCoche extends JFrame implements ActionListener{
	
	JMenuBar barraCatalogo;
	JMenu vehiculosCatalogo;
	JMenu ofertasCatalogo;
	JMenu cuentaCatalogo;
	JMenuItem cochesItem;
	JMenuItem motosItem;
	JMenuItem datosItem;
	JMenuItem cerrarSesionItem;
	Container mainContainer;
	JPanel topPanel;
	JPanel middlePanel;
	JPanel gridPanel;
	JPanel centerPanel;
	JLabel labelCaballos;
	JLabel labelPlazas;
	JLabel labelColor;
	JLabel labelMarca;
	JComboBox comboCaballos;
	JComboBox comboPlazas;
	JComboBox comboColor;
	JComboBox comboMarca;
	JCheckBox checkAutomatico;
	JCheckBox checkLucesLed;
	JCheckBox checkTechoPanoramico;
	JCheckBox checkTraccion;
	JCheckBox checkModoDeportivo;
	
	public VentanaCatalogoCoche() {
		this.setSize(700, 800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		barraCatalogo = new JMenuBar();
		
		vehiculosCatalogo = new JMenu("VEHICULOS");
		ofertasCatalogo = new JMenu("SUPER OFERTAS");
		cuentaCatalogo = new JMenu("MI CUENTA");
	
		cochesItem = new JMenuItem("COCHES");
		motosItem = new JMenuItem("MOTOS");
		datosItem = new JMenuItem("VER MIS DATOS");
		cerrarSesionItem = new JMenuItem("CERRAR SESION");
		
		cochesItem.addActionListener(this);
		motosItem.addActionListener(this);
		datosItem.addActionListener(this);
		cerrarSesionItem.addActionListener(this);
		
		vehiculosCatalogo.add(cochesItem);
		vehiculosCatalogo.add(motosItem);
		cuentaCatalogo.add(datosItem);
		cuentaCatalogo.addSeparator();
		cuentaCatalogo.add(cerrarSesionItem);
		
		
		barraCatalogo.add(vehiculosCatalogo);
		barraCatalogo.add(ofertasCatalogo);
		barraCatalogo.add(cuentaCatalogo);
		
		
		mainContainer = this.getContentPane();
		mainContainer.setLayout(new BorderLayout(8,6));
		
		//PanelTop
		topPanel = new JPanel();
		topPanel.setBorder(new LineBorder(Color.BLACK, 3));//TODO esto solo es para ver bien los paneles, luego borrar.
		topPanel.setLayout(new FlowLayout(5));
		mainContainer.add(topPanel, BorderLayout.NORTH);
		topPanel.add(barraCatalogo);
		

		middlePanel = new JPanel();
		middlePanel.setBorder(new LineBorder(Color.black, 3));
		middlePanel.setLayout(new FlowLayout(4,4,4));		
		
		gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(13,2));
		gridPanel.setBorder(new LineBorder(Color.BLACK, 3));
		
		//meter los componentes del girdPanel.
		//TODO hay que meter los items en los JComoBoxes
		labelCaballos = new JLabel("Caballos: ");
		comboCaballos = new JComboBox();
		labelPlazas = new JLabel("Plazas: ");
		comboPlazas = new JComboBox();
		labelColor = new JLabel("Color: ");
		comboColor = new JComboBox();
		labelMarca = new JLabel("Marca: ");
		comboMarca = new JComboBox();
		checkAutomatico = new JCheckBox("Automático");
		checkLucesLed = new JCheckBox("Luces led");
		checkTechoPanoramico = new JCheckBox("Techo panorámico");
		checkTraccion = new JCheckBox("Tracción 4x4");
		checkModoDeportivo = new JCheckBox("Modo deportivo");

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
		
		centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout());
		centerPanel.setBorder(new LineBorder(Color.BLACK, 3));
	
		middlePanel.add(gridPanel);
		mainContainer.add(centerPanel);
		mainContainer.add(middlePanel, BorderLayout.WEST);
		
		
		
		
 	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		if(evento.getSource()==cerrarSesionItem) {
			VentanaInicial.abirVentanaInicial();
			dispose();
			JOptionPane.showMessageDialog(null, "Se ha cerrado la sesion correctamente...");
		} else if(evento.getSource()==cochesItem){
			visualizarPanelesCoche();
		}
		
		
		
	}
	
	public void visualizarPanelesCoche() {
		//MiddlePanel
		
				
				
	}
	
}