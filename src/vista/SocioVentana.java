package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.SocioControlador;
import modelo.Socio;
import modelo.SocioModelo;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.BoxLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;

public class SocioVentana extends JDialog {
	private JList list;



	/**
	 * Create the dialog.
	 */
	public SocioVentana(JFrame padre, boolean modal) {
		super(padre, modal);
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		list = new JList();
		list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		getContentPane().add(list, BorderLayout.CENTER);
		
		JButton btnCrearSocio = new JButton("Crear Socio");
		getContentPane().add(btnCrearSocio, BorderLayout.SOUTH);
		btnCrearSocio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SocioControlador socio_controlador = new SocioControlador();
				socio_controlador.abrirFormCrearSocio();
			}
		});
//		{
//			JPanel buttonPane = new JPanel();
//			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
//			getContentPane().add(buttonPane, BorderLayout.SOUTH);
//			{
//				JButton okButton = new JButton("OK");
//				okButton.setActionCommand("OK");
//				buttonPane.add(okButton);
//				getRootPane().setDefaultButton(okButton);
//			}
//			{
//				JButton cancelButton = new JButton("Cancel");
//				cancelButton.setActionCommand("Cancel");
//				buttonPane.add(cancelButton);
//			}
//		}
	}

	//nire metdodoak
	public void addSocio(String nombre, String apellido, String direccion, String poblacion, String provincia, String dni) {
		//TODO errorea konpontzeko dago
		DefaultListModel dlm = (DefaultListModel) this.list.getModel();
		dlm.addElement(nombre + " "+apellido + " din: " +  dni);
		list.setModel(dlm);
	}

	public void rellenarLista(ArrayList<Socio> socios) {	
		//TODO para Borja, se rellena aqui la lista o se le pasa al controlador
		DefaultListModel defaultListModel = new DefaultListModel();
		Iterator<Socio> i = socios.iterator();
		while(i.hasNext()){
			Socio socio = i.next();
			defaultListModel.addElement(socio.getNombre() + " " + socio.getApellido() + " dni: " + socio.getDni());
		}
		list.setModel(defaultListModel);
		//-----------------para Borja
		
	}

}
