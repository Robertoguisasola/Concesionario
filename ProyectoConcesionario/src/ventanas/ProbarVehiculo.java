package ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JSpinnerDateEditor;

import dataBase.GestorBD;
import model.Cliente;
import model.Coche;
import model.Coche2;
import model.Moto;
import model.Moto2;
import model.Prueba;
import model.Trabajador;
import model.Vehiculo;

public class ProbarVehiculo extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel infoLabel;
	private JPanel infoPanel;

	private JPanel formPanel;
	private Box formBox;
	private Box calendarioBox;
	private JLabel calendarioLabel;
	private JDateChooser calendario;
	private JLabel concesionarioLabel;
	private Box concesionarioBox;
	private JComboBox<String> concesionarioCombo;
	private JButton probarButton;
	private JButton cancelarButton;
	private Box buttonsBox;
	private JPanel buttonsPanel;

	public ProbarVehiculo(Cliente c, Trabajador t, Vehiculo v) {

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Probar vehículo");

		String probar = "<html><body><center>Solicitar prueba del vehículo</center></body></html>";

		infoPanel = new JPanel();

		infoLabel = new JLabel(probar);
		infoPanel.add(infoLabel);		

		add(infoPanel, BorderLayout.NORTH);

		formPanel = new JPanel();
		formPanel.setLayout(new GridBagLayout());

		calendarioLabel = new JLabel("Fecha de recogida del vehículo");

		calendario = new JDateChooser(null, null, null, new JSpinnerDateEditor());
		calendario.setDateFormatString("dd/MM/yyyy");

		calendarioBox = new Box(BoxLayout.X_AXIS);
		calendarioBox.add(calendarioLabel);
		calendarioBox.add(Box.createRigidArea(new Dimension(10,0)));
		calendarioBox.add(calendario);

		concesionarioLabel = new JLabel("Concesionario de recogida:");
		concesionarioCombo = new JComboBox<String>();

		ArrayList<String> concesionarios = concesionarios();
		for(String concesionario: concesionarios)
			concesionarioCombo.addItem(concesionario);

		concesionarioBox = new Box(BoxLayout.X_AXIS);
		concesionarioBox.add(concesionarioLabel);
		concesionarioBox.add(Box.createRigidArea(new Dimension(44, 12)));
		concesionarioBox.add(concesionarioCombo);

		formBox = new Box(BoxLayout.Y_AXIS);
		formBox.add(Box.createRigidArea(new Dimension(300,0)));
		formBox.add(calendarioBox);
		formBox.add(Box.createRigidArea(new Dimension(0,10)));
		formBox.add(concesionarioBox);

		formPanel.add(formBox);

		buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new GridBagLayout());

		probarButton = new JButton("Probar");
		probarButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				Date fecha = calendario.getDate();
				if (fecha != null) {
					String concesionario = concesionarioCombo.getSelectedItem().toString();
					confirmarPrueba(c, t, v, fecha, concesionario);
				} else {
					JOptionPane.showMessageDialog(null, "Por favor, seleccione una fecha para recoger el vehículo");
				}
			}
		});    

		cancelarButton = new JButton("Cancelar");
		cancelarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				volver(c, t, v);
			}
		});

		buttonsBox = new Box(BoxLayout.X_AXIS);
		buttonsBox.add(probarButton);
		buttonsBox.add(Box.createRigidArea(new Dimension(40, 0)));
		buttonsBox.add(cancelarButton);

		buttonsPanel.add(buttonsBox);

		getContentPane().add(infoPanel, BorderLayout.NORTH);
		getContentPane().add(formPanel, BorderLayout.CENTER);
		getContentPane().add(buttonsPanel, BorderLayout.SOUTH);
	}

	private void confirmarPrueba(Cliente c, Trabajador t, Vehiculo v, Date fecha, String concesionario) {
		Date devolucion = calculateDevolucion(fecha);

		Prueba p = new Prueba(null, v, fecha, devolucion, concesionario);
		
		if (c == null) {
			p.setProbador(t);
		} else {
			p.setProbador(c);
		}

		String[] opciones = {"Aceptar", "Cancelar"};

		String confirmacion = confirmacion(p);
		int respuesta = JOptionPane.showOptionDialog( null, confirmacion, "Probar", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
		switch (respuesta) {
		case 0:
			GestorBD bd = new GestorBD();
			
			bd.probar(p);

			bd.desconectar();

			volver(c, t);
			break;
		case 1:
			JOptionPane.showMessageDialog(null, "Seleccione el día y el lugar en el que desea recoger el vehículo");
			break;
		default:
			break;
		}	
	}

	private Date calculateDevolucion(Date fecha) {
		Calendar c = Calendar.getInstance();
		c.setTime(fecha);
		//En el segundo campo indicamos los días que queremos sumar
		c.add(Calendar.DAY_OF_MONTH, 7);
		
		Date devolucion = c.getTime();
		
		return devolucion;
	}

	private String confirmacion(Prueba p) {
		String confirmacion = "<html><body><center>Ha solicitado la prueba de " + p.getVehiculo().toString()
				+ ". Podrá recoger el vehículo en el concesionario de " + p.getCiudad() + " el día " + 
				p.getFechaInicioString() + " desde las 8:30 horas hasta las 15:00 horas</center></body></html>";

		return confirmacion;
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

	private void volver(Cliente c, Trabajador t, Vehiculo v) {
		if (v instanceof Coche) {
			EscogerCoche.abrirEscogerCoche(c, t);
			dispose();
		} else if (v instanceof Coche2)	{
			EscogerCoche2.abrirEscogerCoche2(c, t);
			dispose();
		} else if (v instanceof Moto) {
			EscogerMoto.abrirEscogerMoto(c, t);
			dispose();
		} else if (v instanceof Moto2)	{
			EscogerMoto2.abrirEscogerMoto2(c, t);
			dispose();
		}
	}
	
	private ArrayList<String> concesionarios(){
		ArrayList<String> concesionarios = new ArrayList<String>();
		
		File f = null;
		Scanner sc = null;

		try {
			f = new File("ficheros/concesionarios.csv");
			sc = new Scanner(f);

			while(sc.hasNextLine()) {
				String linea = sc.nextLine();

				//Cada campo está partido por ;
				
				String[] campos = linea.split(";");// recibe un argumento y devuleve un array de Strings 
				
				String c = campos[0];

				concesionarios.add(c);	
			}
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}		
		return concesionarios;
	}

	public static void abrirProbarVehiculo(Cliente c, Trabajador t, Vehiculo v) {
		ProbarVehiculo probarVehiculo = new ProbarVehiculo(c, t, v);
		probarVehiculo.setVisible(true);
		probarVehiculo.setSize(480,360);
		probarVehiculo.setLocationRelativeTo(null);
	}
}