package controlador;

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
}
