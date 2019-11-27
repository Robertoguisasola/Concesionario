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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaDespedirTrabajador extends JFrame{

	private JPanel opcionesPanel;
	private Box trabajadorBox;
	private JLabel trabajadorLabel;
	private JTextField trabajadorField;
	private Box buttonsBox;
	private JButton despedirTrabajadorButton;
	private JButton cancelButton;
	
	public VentanaDespedirTrabajador(){
		this.setTitle("Despido trabajador");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(320, 240);
		this.setResizable(true);
		
		opcionesPanel = new JPanel();
		opcionesPanel.setLayout(new GridBagLayout());
		
		trabajadorBox = new Box(BoxLayout.Y_AXIS);
		trabajadorLabel= new JLabel("DNI del trabajador: ");
		trabajadorField= new JTextField();
		trabajadorBox.add(trabajadorLabel);
		trabajadorBox.add(trabajadorField);
		
		buttonsBox = new Box(BoxLayout.Y_AXIS);
		
		despedirTrabajadorButton = new JButton("Despedir trabajador");
		despedirTrabajadorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String dniTrabajador= trabajadorField.getText();
				//TODO eliminar el trabajador de la base de datos dado el DNI
			}
		});
		
		cancelButton = new JButton("Cancelar");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaAdministrador ventanaAdmin = new VentanaAdministrador();
				ventanaAdmin.setVisible(true);
				ventanaAdmin.setSize(450,260);
				ventanaAdmin.setLocationRelativeTo(null);
				ventanaAdmin.setVisible(true);
				dispose();
			}
		});
		
		buttonsBox.add(despedirTrabajadorButton);
		buttonsBox.add(cancelButton);
				
		GridBagConstraints gbc_trabajadorBox = new GridBagConstraints();
		gbc_trabajadorBox.gridx = 0;
		opcionesPanel.add(trabajadorBox, gbc_trabajadorBox);
		
		GridBagConstraints gbc_buttonsBox = new GridBagConstraints();
		gbc_buttonsBox.gridx = 0;
		opcionesPanel.add(buttonsBox, gbc_buttonsBox);
		
		getContentPane().add(opcionesPanel, BorderLayout.CENTER);
		
		this.setVisible(true);
	}
}
