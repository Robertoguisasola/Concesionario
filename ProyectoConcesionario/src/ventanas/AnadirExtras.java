package ventanas;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.Persona;
import java.awt.FlowLayout;

public class AnadirExtras extends JFrame{
	
	private JCheckBox techoPanoramicoCheck;
	private Box techoPanoramicoBox;
	private JCheckBox traccionCheck;
	private Box traccionBox;
	private JCheckBox modoDeportivoCheck;
	private Box modoDeportivoBox;
	private JCheckBox lucesLedCheck;
	private Box lucesLedBox;
	private JLabel infoCheck;
	private JPanel vacioPanel;
	private JPanel grupoPanel;
	
	public AnadirExtras(Persona p) {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		grupoPanel = new JPanel();
		grupoPanel.setLayout(new BoxLayout(grupoPanel, BoxLayout.Y_AXIS));
		vacioPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) vacioPanel.getLayout();
		
		flowLayout.setHgap(90);
		
		
		
		infoCheck = new JLabel("Escoge los extras que desee.  ");
		
		
		techoPanoramicoCheck = new JCheckBox("Techo panorámico ");
		traccionCheck = new JCheckBox("Tracción 4x4 ");		
		modoDeportivoCheck = new JCheckBox("Modo deportivo ");
		lucesLedCheck = new JCheckBox("Luces led ");
		
		grupoPanel.add(techoPanoramicoCheck);
		grupoPanel.add(traccionCheck);
		grupoPanel.add(modoDeportivoCheck);
		
		
		getContentPane().add(infoCheck, BorderLayout.NORTH);
		getContentPane().add(vacioPanel, BorderLayout.WEST);
		getContentPane().add(grupoPanel, BorderLayout.CENTER);
	}
	
	public static void abriranadirExtras(Persona p) {
		AnadirExtras anadirExtras = new AnadirExtras(p);
		anadirExtras.setTitle("Extras");
		anadirExtras.setVisible(true);
		anadirExtras.setSize(550,420);
		anadirExtras.setLocationRelativeTo(null);
	}
	
}
