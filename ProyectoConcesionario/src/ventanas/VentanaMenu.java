package ventanas;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaMenu extends JFrame {
	//TODO enlazar ventana como principal
	
	public VentanaMenu() {
		getContentPane().setBackground(new Color(255, 255, 224));
		getContentPane().setLayout(null);
		
		JLabel lblMenu = new JLabel("MENU");
		
		
		lblMenu.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenu.setBounds(182, 23, 46, 14);
		getContentPane().add(lblMenu);
		
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
		btnIniciarSesin.setBounds(159, 63, 102, 23);
		getContentPane().add(btnIniciarSesin);
		
		JButton btnRegistrarCuenta = new JButton("Registrar cuenta");
		btnRegistrarCuenta.setBounds(159, 118, 102, 23);
		getContentPane().add(btnRegistrarCuenta);
	}
}
