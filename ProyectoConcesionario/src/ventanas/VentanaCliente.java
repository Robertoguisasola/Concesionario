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

public class VentanaCliente extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel opcionesPanel;
	private Box buttonsBox;
	private JButton catalogoCochesButton;
	
	public VentanaCliente(Cliente c) {
		this.setTitle("Bienvenido "+c.getNombre()+" "+c.getApellidos());
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(320, 240);
		this.setResizable(true);
		
		opcionesPanel = new JPanel();
		opcionesPanel.setLayout(new GridBagLayout());
		
		buttonsBox = new Box(BoxLayout.Y_AXIS);
		catalogoCochesButton = new JButton("Mirar catalogo coches");
		catalogoCochesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaCatalogoCoche ventanaCoches = new VentanaCatalogoCoche();
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

}
