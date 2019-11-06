package ventanas;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class VentanaMenu extends JFrame {
	//TODO enlazar ventana como principal
	
	public VentanaMenu() {
		getContentPane().setBackground(new Color(255, 255, 224));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{127, 160, 0};
		gridBagLayout.rowHeights = new int[]{14, 23, 30, 23, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JButton btnIniciarSesin = new JButton("Iniciar sesi\u00F3n");
		btnIniciarSesin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaLogin login = new VentanaLogin();
				login.setVisible(true);
				login.setSize(450,260);
				login.setLocationRelativeTo(null);
				
				dispose();
			}
		});
		
		JLabel lblMenu = new JLabel("MENU");
		
		
		lblMenu.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMenu.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblMenu = new GridBagConstraints();
		gbc_lblMenu.fill = GridBagConstraints.VERTICAL;
		gbc_lblMenu.insets = new Insets(0, 0, 5, 0);
		gbc_lblMenu.gridx = 1;
		gbc_lblMenu.gridy = 1;
		getContentPane().add(lblMenu, gbc_lblMenu);
		GridBagConstraints gbc_btnIniciarSesin = new GridBagConstraints();
		gbc_btnIniciarSesin.anchor = GridBagConstraints.NORTH;
		gbc_btnIniciarSesin.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnIniciarSesin.insets = new Insets(0, 0, 5, 0);
		gbc_btnIniciarSesin.gridx = 1;
		gbc_btnIniciarSesin.gridy = 3;
		getContentPane().add(btnIniciarSesin, gbc_btnIniciarSesin);
		
		JButton btnRegistrarCuenta = new JButton("Registrar cuenta");
		btnRegistrarCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaRegistrar ventanaRegistrarDelMenu = new VentanaRegistrar();
				ventanaRegistrarDelMenu.setVisible(true);
				ventanaRegistrarDelMenu.setSize(450,560);
				ventanaRegistrarDelMenu.setLocationRelativeTo(null);
				
				dispose();
			}
		});
		GridBagConstraints gbc_btnRegistrarCuenta = new GridBagConstraints();
		gbc_btnRegistrarCuenta.insets = new Insets(0, 0, 5, 0);
		gbc_btnRegistrarCuenta.anchor = GridBagConstraints.NORTH;
		gbc_btnRegistrarCuenta.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnRegistrarCuenta.gridx = 1;
		gbc_btnRegistrarCuenta.gridy = 5;
		getContentPane().add(btnRegistrarCuenta, gbc_btnRegistrarCuenta);
	}
}
