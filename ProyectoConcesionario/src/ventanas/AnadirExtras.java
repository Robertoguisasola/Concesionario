package ventanas;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Cliente;
import model.Coche;
import model.Trabajador;
import model.VentaCoche;

public class AnadirExtras extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JCheckBox techoPanoramicoCheck;
	private JCheckBox traccionCheck;
	private JCheckBox modoDeportivoCheck;
	private JCheckBox lucesLedCheck;
	private JCheckBox automaticoCheck;
	private JLabel infoCheck;
	private JPanel informacionPanel;
	private JPanel grupoPanel;
	private JButton acceptButton;
	private JButton cancelButton;
	private Box buttonsBox;
	JPanel buttonsPanel;
	
	public AnadirExtras(Cliente c, Trabajador t, Coche ch) {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		String anadirExtra = "<html><body><center>Extras para el coche<br>Escoja los extras que desee para su coche</center></body></html>";
		
		informacionPanel = new JPanel();
		
		infoCheck = new JLabel(anadirExtra);
		informacionPanel.add(infoCheck);		
		
		getContentPane().add(informacionPanel, BorderLayout.NORTH);
		
		grupoPanel = new JPanel();
		grupoPanel.setLayout(new BoxLayout(grupoPanel, BoxLayout.Y_AXIS));	
		
		buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new GridBagLayout());
		
		techoPanoramicoCheck = new JCheckBox("Techo panorámico ");
		traccionCheck = new JCheckBox("Tracción 4x4 ");		
		modoDeportivoCheck = new JCheckBox("Modo deportivo ");
		lucesLedCheck = new JCheckBox("Luces led ");
		automaticoCheck = new JCheckBox("Automático ");
		
		
		grupoPanel.add(Box.createRigidArea(new Dimension(180,30)));
		grupoPanel.add(techoPanoramicoCheck);
		grupoPanel.add(Box.createRigidArea(new Dimension(0,10)));
		grupoPanel.add(traccionCheck);
		grupoPanel.add(Box.createRigidArea(new Dimension(0,10)));
		grupoPanel.add(modoDeportivoCheck);
		grupoPanel.add(Box.createRigidArea(new Dimension(0,10)));
		grupoPanel.add(lucesLedCheck);
		grupoPanel.add(Box.createRigidArea(new Dimension(0,10)));
		grupoPanel.add(automaticoCheck);
		
		acceptButton = new JButton("Aceptar");
		acceptButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				crearVenta(c,t,ch);
			}
		});    
		
		cancelButton = new JButton("Cancelar");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EscogerCoche.abrirEscogerCoche(c, t);
			}
		});
		
		buttonsBox = new Box(BoxLayout.X_AXIS);
		buttonsBox.add(acceptButton);
		buttonsBox.add(Box.createRigidArea(new Dimension(40, 0)));
		buttonsBox.add(cancelButton);
		
		buttonsPanel.add(buttonsBox);
		
		getContentPane().add(informacionPanel, BorderLayout.NORTH);
		getContentPane().add(grupoPanel, BorderLayout.CENTER);
		getContentPane().add(buttonsPanel, BorderLayout.SOUTH);
	}
	
	private void crearVenta(Cliente c, Trabajador t, Coche ch) {
		int precio = calculatePrecio(ch);
		

	private int calculatePrecio(Coche ch) {
		int precio = ch.getPrecio();
		
		if (automaticoCheck.isSelected()) {
			precio += 1500; 
		}
		
		if (lucesLedCheck.isSelected()) {
			precio += 1000;
		}
		
		if (techoPanoramicoCheck.isSelected()) {
			precio += 1700;
		}
		
		if (traccionCheck.isSelected()) {
			precio += 3500;
		}
		
		if (modoDeportivoCheck.isSelected()) {
			precio += 1500;
		}
		
		return precio;
	}

	public static void abriranadirExtras(Cliente c, Trabajador t, Coche ch) {
		AnadirExtras anadirExtras = new AnadirExtras(c, t, ch);
		anadirExtras.setTitle("Extras del coche");
		anadirExtras.setVisible(true);
		anadirExtras.setSize(480,360);
		anadirExtras.setLocationRelativeTo(null);
	}	
}