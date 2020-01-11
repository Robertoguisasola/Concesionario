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
import model.Moto;
import model.Trabajador;
import model.VentaMoto;

public class AnadirExtrasMoto extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JCheckBox escapeCheck;
	private JCheckBox paramanosCheck;
	private JCheckBox guardabarrosGrandeCheck;
	private JCheckBox lucesLedCheck;
	private JCheckBox automaticoCheck;
	private JLabel infoCheck;
	private JPanel informacionPanel;
	private JPanel grupoPanel;
	private JButton acceptButton;
	private JButton cancelButton;
	private Box buttonsBox;
	JPanel buttonsPanel;

	public AnadirExtrasMoto(Cliente c, Trabajador t, Moto m) {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Extras de la moto");

		String anadirExtra = "<html><body><center>Extras para la moto<br>Escoja los extras que desee para su moto</center></body></html>";

		informacionPanel = new JPanel();

		infoCheck = new JLabel(anadirExtra);
		informacionPanel.add(infoCheck);		

		getContentPane().add(informacionPanel, BorderLayout.NORTH);

		grupoPanel = new JPanel();
		grupoPanel.setLayout(new BoxLayout(grupoPanel, BoxLayout.Y_AXIS));	

		buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new GridBagLayout());

		escapeCheck = new JCheckBox("Escape modificado");
		paramanosCheck = new JCheckBox("Paramanos");		
		guardabarrosGrandeCheck= new JCheckBox("Guardabarros grande");
		lucesLedCheck = new JCheckBox("Luces led");
		automaticoCheck = new JCheckBox("Automático");

		grupoPanel.add(Box.createRigidArea(new Dimension(180,30)));
		grupoPanel.add(escapeCheck);
		grupoPanel.add(Box.createRigidArea(new Dimension(0,10)));
		grupoPanel.add(paramanosCheck);
		grupoPanel.add(Box.createRigidArea(new Dimension(0,10)));
		grupoPanel.add(guardabarrosGrandeCheck);
		grupoPanel.add(Box.createRigidArea(new Dimension(0,10)));
		grupoPanel.add(lucesLedCheck);
		grupoPanel.add(Box.createRigidArea(new Dimension(0,10)));
		grupoPanel.add(automaticoCheck);

		acceptButton = new JButton("Aceptar");
		acceptButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				confirmarVenta(c,t,m);
				volver(c, t);
			}
		});    

		cancelButton = new JButton("Cancelar");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EscogerMoto.abrirEscogerMoto(c, t);
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

	private void confirmarVenta(Cliente c, Trabajador t, Moto m) {
		int precio = calculatePrecio(m);

		String[] opciones = {"Sí, comprar la moto", "No, cambiar"};

		String confirmacion = confirmacion(m) + "El precio total de la moto es de: "  + precio + "€"+ "</center></body></html>";
		int respuesta = JOptionPane.showOptionDialog( null, confirmacion, "Comprar", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
		switch (respuesta) {
		case 0:
			crearVenta(c, t, m, precio);
			break;
		case 1:
			JOptionPane.showMessageDialog(null, "Modifique los extras. En caso de querer cambiar la moto pulse cancelar");
		default:
			break;
		}	
	}

	private void crearVenta(Cliente c, Trabajador t, Moto m, int precio) {
		VentaMoto vm = new VentaMoto(null, m, precio, false, false, false, false, false);
		GestorBD bd = new GestorBD();

		if (c == null) {
			vm.setComprador(t);
		} else {
			vm.setComprador(c);
		}

		if (automaticoCheck.isSelected()) {
			vm.setAutomatico(true);
		}

		if (lucesLedCheck.isSelected()) {
			vm.setLucesLed(true);
		}

		if (escapeCheck.isSelected()) {
			vm.setEscape(true);
		}

		if (paramanosCheck.isSelected()) {
			vm.setParamanos(true);
		}

		if (guardabarrosGrandeCheck.isSelected()) {
			vm.setGuardabarrosGrande(true);
		}

		bd.venderMoto(vm);

		bd.desconectar();
	}

	private int calculatePrecio(Moto m) {
		int precio = m.getPrecio();

		if (automaticoCheck.isSelected()) {
			precio += 1500; 
		}

		if (lucesLedCheck.isSelected()) {
			precio += 1000;
		}

		if (escapeCheck.isSelected()) {
			precio += 2000;
		}

		if (paramanosCheck.isSelected()) {
			precio += 500;
		}

		if (guardabarrosGrandeCheck.isSelected()) {
			precio += 1500;
		}

		return precio;
	}

	private String confirmacion(Moto m) {
		String confirmacion = "<html><body><center>";
		if (oneSelected()) {
			confirmacion += "Va a comprar una " + m.venderMoto() + " con las siguientes características: <ul>";
		} else {
			String[] opciones = {"No añadir extras", "Añadir extras"};

			int respuesta = JOptionPane.showOptionDialog( null, "¿Está seguro de que no quiere añadir ningún extra?", "Extras", JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
			switch (respuesta) {
			case 0:
				confirmacion += "Va a comprar una " + m.venderMoto() + " manual, con falos halógenos y sin modificar el escape ni paramanos ni guardabarros grande</center></body></html>";
				return confirmacion;
			case 1:
				JOptionPane.showMessageDialog(null, "Por favor, seleccione los extras que desea añadir a la moto");
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

		if (escapeCheck.isSelected()) {
			confirmacion += "<li>Escape modificado</li>";
		} else {
			confirmacion += "<li>Escape normal</li>";
		}

		if (paramanosCheck.isSelected()) {
			confirmacion += "<li>Con paramanos</li>";
		} else {
			confirmacion += "<li>Sin paramanos</li>";
		}

		if (guardabarrosGrandeCheck.isSelected()) {
			confirmacion += "<li>Guardabarros grande</li>";
		} else {
			confirmacion += "<li>Guardabarros normal</li>";
		}

		confirmacion += "</ul>";

		return confirmacion;
	}

	private boolean oneSelected() {

		if (automaticoCheck.isSelected() || lucesLedCheck.isSelected() || escapeCheck.isSelected() || guardabarrosGrandeCheck.isSelected() || paramanosCheck.isSelected()) {
			return true;
		} else {
			return false;
		}
	}

	private void volver(Cliente c, Trabajador t) {
		if (t == null) {
			VistaCliente.abrirVistaCliente(c);
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

	public static void abriranadirExtrasMoto(Cliente c, Trabajador t, Moto m) {
		AnadirExtrasMoto anadirExtras = new AnadirExtrasMoto(c, t, m);
		anadirExtras.setVisible(true);
		anadirExtras.setSize(480,360);
		anadirExtras.setLocationRelativeTo(null);
	}	
}