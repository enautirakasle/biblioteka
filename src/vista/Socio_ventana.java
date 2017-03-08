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

public class Socio_ventana extends JDialog {

	private final JPanel contentPanel = new JPanel();



	/**
	 * Create the dialog.
	 */
	public Socio_ventana(JFrame padre, boolean modal) {
		super(padre, modal);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JButton btnCrearSocio = new JButton("Crear Socio");
		btnCrearSocio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirCrearSocioVentana();
			}
		});
		
		JList list = new JList();
		contentPanel.add(list);
		contentPanel.add(btnCrearSocio);
		DefaultListModel defaultListModel = new DefaultListModel();
		
		Socio_modelo sm = new Socio_modelo("biblioteka");
		ArrayList<Socio> socios = sm.select();
		Iterator<Socio> i = socios.iterator();
		while(i.hasNext()){
			defaultListModel.addElement(i.next().getInfo());
		}
		
		list.setModel(defaultListModel);
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

}
