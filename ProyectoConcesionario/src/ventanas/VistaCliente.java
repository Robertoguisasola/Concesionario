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
import javax.swing.JOptionPane;
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
	private JLabel motosLabel;
	private JButton motosButton;
	private Box motosBox;
	
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

		cochesButton = new JButton("Comprar coche");
		cochesButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] opciones = {"Nuevos", "Segunda mano"};

				int respuesta = JOptionPane.showOptionDialog( null, "¿Qué coche desea comprar?", "Borrar", JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
				switch (respuesta) {
				case 0:
					EscogerCoche.abrirEscogerCoche(c, null);
					dispose();
					break;
				case 1:
					EscogerCoche2.abrirEscogerCoche2(c, null);
					dispose();
				default:
					break;
				}			
			}
		});

		cochesBox = new Box(BoxLayout.Y_AXIS);
		cochesBox.add(cochesLabel);
		cochesBox.add(Box.createRigidArea(new Dimension(0, 10)));
		cochesBox.add(cochesButton);

		motosLabel = new JLabel("Motos");

		motosButton = new JButton("Comprar moto");
		motosButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] opciones = {"Nuevas", "Segunda mano"};

				int respuesta = JOptionPane.showOptionDialog( null, "¿Qué moto desea comprar?", "Borrar", JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
				switch (respuesta) {
				case 0:
					EscogerMoto.abrirEscogerMoto(c, null);
					dispose();
					break;
				case 1:
					EscogerMoto2.abrirEscogerMoto2(c, null);
					dispose();
				default:
					break;
				}			
			}
		});

		motosBox = new Box(BoxLayout.Y_AXIS);
		motosBox.add(motosLabel);
		motosBox.add(Box.createRigidArea(new Dimension(0, 10)));
		motosBox.add(motosButton);
		
		opcionesBox = new Box(BoxLayout.Y_AXIS);
		opcionesBox.add(cochesBox);
		opcionesBox.add(Box.createRigidArea(new Dimension(0, 10)));
		opcionesBox.add(motosBox);

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

	public static void main(String[] args) {
		Cliente c = new Cliente();
		
		VistaCliente.abrirVistaCliente(c);
	}
}
