package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Socio;
import modelo.Socio_modelo;

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

public class Socio_ventana extends JDialog {
	private JList list;



	/**
	 * Create the dialog.
	 */
	public Socio_ventana(JFrame padre, boolean modal) {
		super(padre, modal);
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {
				System.out.println("focus gained");
			}
			public void windowLostFocus(WindowEvent arg0) {
			}
		});
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				System.out.println("shown");
			}
		});
		setBounds(100, 100, 450, 300);
		DefaultListModel defaultListModel = new DefaultListModel();
		
		Socio_modelo sm = new Socio_modelo("biblioteka");
		ArrayList<Socio> socios = sm.select();
		Iterator<Socio> i = socios.iterator();
		while(i.hasNext()){
			defaultListModel.addElement(i.next().getInfo());
		}
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		list = new JList();
		list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		getContentPane().add(list, BorderLayout.CENTER);
		
		list.setModel(defaultListModel);
		
		JButton btnCrearSocio = new JButton("Crear Socio");
		getContentPane().add(btnCrearSocio, BorderLayout.SOUTH);
		btnCrearSocio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirCrearSocioVentana();
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



	protected void abrirCrearSocioVentana() {
		CrearSocio_ventana cs_v = new CrearSocio_ventana(this, true);
		cs_v.setVisible(true);
		
	}

	public void addSocio(String nombre, String apellido, String direccion, String poblacion, String provincia, String dni) {
		DefaultListModel dlm = (DefaultListModel) this.list.getModel();
		dlm.addElement(nombre + " "+apellido + " din: " +  dni);
		list.setModel(dlm);
	}

}
