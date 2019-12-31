package ventanas;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Cliente;

public class VistaCliente extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel opcionesPanel;
	private Box buttonsBox;
	private JButton catalogoCochesButton;
	
	//TODO completar con más componentes, NO DOY A BASTOOOOOOOOOOOOOO
	//Podriais pensar al menos algo que añadirle a este punto o algo así, porque no solo se querrán comprar coches....
	//OTRAS FUNCIONES POR DIOOOOS
	
	public VistaCliente(Cliente c) {
		//TODO no saca el nombre del cliente
		this.setTitle("Bienvenido "+c.getNombre()+" "+c.getApellidos());
		
		
		this.setResizable(true);
		
		opcionesPanel = new JPanel();
		opcionesPanel.setLayout(new GridBagLayout());
		
		buttonsBox = new Box(BoxLayout.Y_AXIS);
		catalogoCochesButton = new JButton("Mirar catalogo coches");
		catalogoCochesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaCatalogoCoche ventanaCoches = new VentanaCatalogoCoche(c);
				ventanaCoches.setLocationRelativeTo(null);
				ventanaCoches.setVisible(true);
				dispose();
			}
		});
		
		buttonsBox.add(catalogoCochesButton);
				
		GridBagConstraints gbc_buttonsBox = new GridBagConstraints();
		gbc_buttonsBox.gridx = 0;
		opcionesPanel.add(buttonsBox, gbc_buttonsBox);
		
		getContentPane().add(opcionesPanel, BorderLayout.CENTER);
		
		this.setVisible(true);
	}
	
<<<<<<< HEAD
	public static void abrirVistaCliente(Cliente c) {
		VistaCliente vistaCliente = new VistaCliente(c);
		vistaCliente.setVisible(true);
		vistaCliente.setSize(480,360);
		vistaCliente.setLocationRelativeTo(null);
		vistaCliente.setVisible(true);
	}
=======
	public static void abrirVistaCliente() {
		VistaCliente vistaCliente = new VistaCliente(null);
		vistaCliente.setSize(480,360);
		vistaCliente.setLocationRelativeTo(null);
		vistaCliente.setVisible(true);
	}

>>>>>>> branch 'master' of https://github.com/Robertoguisasola/Concesionario
}
