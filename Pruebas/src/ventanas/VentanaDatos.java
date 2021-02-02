package ventanas;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import datos.Barco;
import datos.Evento;
import gestionDatos.BaseDatos;
import principal.Examen;

public class VentanaDatos extends JFrame {
	private static final long serialVersionUID = 8186335640361343371L;
	DefaultTreeModel modelo;
	DefaultMutableTreeNode abuelo;
	
	public VentanaDatos() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		setTitle("Ventana de muestra de datos");
		setSize( 300, 500 );
		JPanel pCentral = new JPanel();
		pCentral.setLayout(new BorderLayout());
		pCentral.add(new JLabel("Gestión de Barcos y Mareas", SwingConstants.CENTER), BorderLayout.NORTH);
		
		abuelo = new DefaultMutableTreeNode("Gestion Barcos");
		modelo = new DefaultTreeModel(abuelo);
		JTree tree = new JTree(modelo);
		cargarJTree();
		
		//Listener de selección de barco
		tree.addTreeSelectionListener(new TreeSelectionListener() {
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) e
                        .getPath().getLastPathComponent();
                if(e.getPath().getPathCount() == 3) {	//Si es un barco, lanzamos el evento
                    ArrayList<Evento> eventos = new ArrayList<Evento>();
                    
                	BaseDatos.abrirConexion("gestionbarcos.db");
            		eventos = BaseDatos.getEventosBarco(node.toString());
            		BaseDatos.cerrarConexion();
            		
            		for (Evento evento : eventos) {
						System.out.println(evento.toString());
					}
            		
                    
                }
            }
        });
		pCentral.add(tree, BorderLayout.CENTER);

		add(pCentral);
		
		setVisible(true);
	}
	
	public void cargarJTree() {
		HashMap<String, DefaultMutableTreeNode> mapOceanos = new HashMap<>();
		for (String o : Examen.getOceanos()) {
			if(!mapOceanos.containsKey(o)) {
				DefaultMutableTreeNode nodo = new DefaultMutableTreeNode(o);
				mapOceanos.put(o, nodo);
				modelo.insertNodeInto(nodo,abuelo,0);
				
				for (Barco b : Examen.getBarcosOceano(o)) {
					DefaultMutableTreeNode nodoHijo = new DefaultMutableTreeNode(b.getNombre());
					
					modelo.insertNodeInto(nodoHijo,nodo,0);
					
				}
			}
		}
		
	}
}
