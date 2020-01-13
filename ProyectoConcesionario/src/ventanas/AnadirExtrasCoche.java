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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dataBase.GestorBD;
import model.Cliente;
import model.Coche;
import model.Trabajador;
import model.VentaCoche;

public class AnadirExtrasCoche extends JFrame{

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
	private JPanel buttonsPanel;

	public AnadirExtrasCoche(Cliente c, Trabajador t, Coche ch) {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Extras del coche");

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
				confirmarVenta(c,t,ch);
			}
		});    

		cancelButton = new JButton("Cancelar");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EscogerCoche.abrirEscogerCoche(c, t);
				dispose();
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

	private void confirmarVenta(Cliente c, Trabajador t, Coche ch) {
		int precio = calculatePrecio(ch);

		String[] opciones = {"Sí, comprar el coche", "No, cambiar"};

		String confirmacion = confirmacion(ch) + "El precio total del coche es de: "  + precio + "€"+ "</center></body></html>";
		int respuesta = JOptionPane.showOptionDialog( null, confirmacion, "Comprar", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
		switch (respuesta) {
		case 0:
			crearVenta(c, t, ch, precio);
			break;
		case 1:
			JOptionPane.showMessageDialog(null, "Modifique los extras. En caso de querer cambiar el coche pulse cancelar");
			break;
		default:
			break;
		}	
	}

	private void crearVenta(Cliente c, Trabajador t, Coche ch, int precio) {
		VentaCoche vc = new VentaCoche(null, ch, precio, false, false, false, false, false);
		GestorBD bd = new GestorBD();

		if (c == null) {
			vc.setComprador(t);
		} else {
			vc.setComprador(c);
		}

		if (automaticoCheck.isSelected()) {
			vc.setAutomatico(true);
		}

		if (lucesLedCheck.isSelected()) {
			vc.setLucesLed(true);
		}

		if (techoPanoramicoCheck.isSelected()) {
			vc.setTechoPanoramico(true);
		}

		if (traccionCheck.isSelected()) {
			vc.setTraccion4x4(true);
		}

		if (modoDeportivoCheck.isSelected()) {
			vc.setModoDeportivo(true);
		}

		bd.venderCoche(vc);

		bd.desconectar();

		volver(c, t);
	}

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

	private String confirmacion(Coche ch) {
		String confirmacion = "<html><body><center>";
		if (oneSelected()) {
			confirmacion += "Va a comprar un " + ch.venderCoche() + " con las siguientes características: <ul>";
		} else {
			String[] opciones = {"No añadir extras", "Añadir extras"};

			int respuesta = JOptionPane.showOptionDialog( null, "¿Está seguro de que no quiere añadir ningún extra?", "Extras", JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
			switch (respuesta) {
			case 0:
				confirmacion += "Va a comprar un " + ch.venderCoche() + " manual, con falos halógenos y sin traccion 4X4 ni modo deportivo ni techo panorámico</center></body></html>";
				return confirmacion;
			case 1:
				JOptionPane.showMessageDialog(null, "Por favor, seleccione los extras que desea añadir al coche");
				break;
			default:
				break;
			}
		}

		if (automaticoCheck.isSelected()) {
			confirmacion += "<li>Automático</li>";
		} else {
			confirmacion += "<li>Manual</li>";
		}

		if (lucesLedCheck.isSelected()) {
			confirmacion += "<li>Faros led</li>";
		} else {
			confirmacion += "<li>Faros halógenos</li>";
		}

		if (techoPanoramicoCheck.isSelected()) {
			confirmacion += "<li>Techo panorámico</li>";
		} else {
			confirmacion += "<li>Techo normal</li>";
		}

		if (traccionCheck.isSelected()) {
			confirmacion += "<li>Tracción 4X4</li>";
		} else {
			confirmacion += "<li>Tracción 4X2</li>";
		}

		if (modoDeportivoCheck.isSelected()) {
			confirmacion += "<li>Modo deportivo</li>";
		} else {
			confirmacion += "<li>Sin modo deportivo</li>";
		}

		confirmacion += "</ul>";

		return confirmacion;
	}

	private boolean oneSelected() {

		if (automaticoCheck.isSelected() || lucesLedCheck.isSelected() || techoPanoramicoCheck.isSelected() || traccionCheck.isSelected() || modoDeportivoCheck.isSelected()) {
			return true;
		} else {
			return false;
		}
	}

	private void volver(Cliente c, Trabajador t) {
		if (t == null) {
			VistaCliente.abrirVistaCliente(c);
			dispose();
		} else {
			if (t.isAdmin()) {
				VistaAdministrador.abrirVistaAdministrador(t);
				dispose();
			} else {
				VistaTrabajador.abrirVistaTrabajador(t);
				dispose();
			}
		}
	}

	public static void abriranadirExtrasCoche(Cliente c, Trabajador t, Coche ch) {
		AnadirExtrasCoche anadirExtras = new AnadirExtrasCoche(c, t, ch);
		anadirExtras.setVisible(true);
		anadirExtras.setSize(480,360);
		anadirExtras.setLocationRelativeTo(null);
	}
}