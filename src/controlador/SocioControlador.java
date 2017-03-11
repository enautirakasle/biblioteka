package controlador;

import modelo.Socio;
import modelo.Socio_modelo;
import vista.FormularioSocio;
import vista.Principal;
import vista.SocioVentana;

public class SocioControlador {

	private Socio_modelo socio_modelo;
	private SocioVentana socioVentana;
	private Principal principal;
	private FormularioSocio crearSocio_ventana;

	public SocioControlador() {
		socio_modelo = new Socio_modelo();
		this.principal = new Principal();
		this.socioVentana = new SocioVentana(principal, true);
		this.crearSocio_ventana = new FormularioSocio(socioVentana, true);
	}

	public void abrirSocioVentana() {
		this.socioVentana.rellenarLista(this.socio_modelo.select());
		
		this.socioVentana.setVisible(true);
	}
	
	public void abrirFormCrearSocio(){
		this.crearSocio_ventana.setVisible(true);
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

		this.socio_modelo.insert(socio);

		this.crearSocio_ventana.dispose();
	}

	public void deleteSocio(int id) {
		this.socio_modelo.delete(id);
	}

}
