package controlador;

import modelo.Socio;
import modelo.SocioModelo;
import vista.FormularioSocio;
import vista.Principal;
import vista.SocioVentana;

public class SocioControlador {

	private SocioModelo socioModelo;
	private SocioVentana socioVentana;
	private Principal principal;
	private FormularioSocio formularioSocio;

	public SocioControlador() {
		socioModelo = new SocioModelo();
		this.principal = new Principal();
		this.socioVentana = new SocioVentana(principal, true);
		this.formularioSocio = new FormularioSocio(socioVentana, true);
	}

	public void abrirSocioVentana() {
		this.socioVentana.rellenarLista(this.socioModelo.select());
		
		this.socioVentana.setVisible(true);
	}
	
	public void abrirFormCrearSocio(){
		this.formularioSocio.setVisible(true);
	}

	public void insertarSocio(String nombre, String apellido, String direccion, String poblacion, String provincia,
			String dni) {

		// TODO para Borja Porque crear socio aqui y no en Vista
		Socio socio = new Socio();
		socio.setNombre(nombre);
		socio.setApellido(apellido);
		socio.setDireccion(direccion);
		socio.setPoblacion(poblacion);
		socio.setProvincia(provincia);
		socio.setDni(dni);

		this.socioModelo.insert(socio);

		this.formularioSocio.dispose();
	}

	public void deleteSocio(int id) {
		this.socioModelo.delete(id);
	}

}
