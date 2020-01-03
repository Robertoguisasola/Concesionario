package ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Cliente;

public class VistaCliente extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelSuperior;
	private JButton cerrarButton;
	private JPanel opcionesPanel;
	private Box opcionesBox;
	private JLabel cochesLabel;
	private JButton cochesButton;
	private Box cochesBox;
	
	//TODO completar con más componentes, NO DOY A BASTOOOOOOOOOOOOOO
	//Podriais pensar al menos algo que añadirle a este punto o algo así, porque no solo se querrán comprar coches....
	//OTRAS FUNCIONES POR DIOOOOS
	
	public VistaCliente(Cliente c) {
		this.setTitle("Bienvenido "+c.getNombre()+" "+c.getApellidos());		
		this.setResizable(true);
		
panelSuperior  =new JPanel();
		
		cerrarButton = new JButton("Cerrar sesión");
		cerrarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login.abrirLogin();
				dispose();
			}
		});
		
		panelSuperior.add(Box.createRigidArea(new Dimension(300,0)));
		panelSuperior.add(cerrarButton);
			
		opcionesPanel = new JPanel();
		opcionesPanel.setLayout(new GridBagLayout());
		
		cochesLabel = new JLabel("Coches");
		
		cochesButton = new JButton("Ver coches");
		cochesButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaCatalogoCoche.abrirVentanaCatalogoCoche(c);
			}
		});
		
		cochesBox = new Box(BoxLayout.Y_AXIS);
		cochesBox.add(cochesLabel);
		cochesBox.add(Box.createRigidArea(new Dimension(0, 10)));
		cochesBox.add(cochesButton);
		
		opcionesBox = new Box(BoxLayout.Y_AXIS);
		opcionesBox.add(cochesBox);
		
		opcionesPanel.add(opcionesBox);
		
		add(panelSuperior, BorderLayout.NORTH);
		add(opcionesPanel, BorderLayout.CENTER);
		
		this.setVisible(true);
	}

	public static void abrirVistaCliente(Cliente c) {
		VistaCliente vistaCliente = new VistaCliente(c);
		vistaCliente.setSize(480,360);
		vistaCliente.setLocationRelativeTo(null);
		vistaCliente.setVisible(true);
	}

}
