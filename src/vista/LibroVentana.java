package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.LibroControlador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LibroVentana extends JDialog {

	private final JPanel contentPanel = new JPanel();


	/**
	 * Create the dialog.
	 */
	public LibroVentana(Principal principal, boolean modal) {
		super(principal, modal);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton btnCrearLibro = new JButton("Libro nuevo");
			btnCrearLibro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					LibroControlador libroControlador = new LibroControlador();
					libroControlador.abrirFormularioLibro();
				}
			});
			btnCrearLibro.setBounds(10, 11, 120, 23);
			contentPanel.add(btnCrearLibro);
		}
	}



}
