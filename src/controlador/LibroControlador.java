package controlador;

import modelo.Libro;
import modelo.LibroModelo;
import vista.FormularioLibro;
import vista.LibroVentana;
import vista.Principal;

public class LibroControlador {
	private LibroModelo libroModelo;
	private LibroVentana libroVentana;
	private FormularioLibro formularioLibro;
	private Principal principal;
	

	
	public LibroControlador() {
		this.libroModelo = new LibroModelo();
		this.libroVentana = new LibroVentana(this.principal, true);
		this.formularioLibro = new FormularioLibro(this.libroVentana,true);
		this.principal = new Principal();
	}

	public void abrirLibroVentana() {
		this.libroVentana.setVisible(true);
	}

	public void abrirFormularioLibro() {
		this.formularioLibro.setVisible(true);
		
	}

	public void insertar(String titulo, String autor, String num_pag) {
		Libro libro = new Libro(0, titulo, autor, Integer.parseInt(num_pag));
		this.libroModelo.insert(libro);
//		this.formularioLibro.dispose();
	}
}
