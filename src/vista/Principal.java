package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 287);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnGestionSocios = new JButton("Gestion socios");
		btnGestionSocios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirSocioVentana();
			}

			
		});
		contentPane.add(btnGestionSocios);
		
		JButton btnGestionLibros = new JButton("Gestion Libros");
		btnGestionLibros.setVerticalAlignment(SwingConstants.TOP);
		contentPane.add(btnGestionLibros);
		
		JButton btnGestionPrestamos = new JButton("Gestion prestamos");
		contentPane.add(btnGestionPrestamos);
	}
	
	
	private void abrirSocioVentana() {
		Socio_ventana sv = new Socio_ventana(this, true);
		sv.setVisible(true);
	}

}
