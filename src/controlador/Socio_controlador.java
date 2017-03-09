package controlador;

import modelo.Socio;
import modelo.Socio_modelo;
import vista.CrearSocio_ventana;
import vista.Principal;
import vista.Socio_ventana;

public class Socio_controlador {

	private Socio_modelo socio_modelo;
	private Socio_ventana socio_ventana;
	private Principal principal;
	private CrearSocio_ventana crearSocio_ventana;

	public Socio_controlador() {
		socio_modelo = new Socio_modelo();
		this.principal = new Principal();
		this.socio_ventana = new Socio_ventana(principal, true);
		this.crearSocio_ventana = new CrearSocio_ventana(socio_ventana, true);
	}

	public void abrirSocioVentana() {
		this.socio_ventana.rellenarLista(this.socio_modelo.select());
		
		this.socio_ventana.setVisible(true);
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
