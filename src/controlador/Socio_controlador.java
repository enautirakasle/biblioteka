package controlador;

import modelo.Socio;
import modelo.Socio_modelo;

public class Socio_controlador {

	private Socio_modelo socio_modelo;
	
	public Socio_controlador(){
		socio_modelo = new Socio_modelo("biblioteka");
	}
	
	public void insertarSocio(String nombre, String apellido, String direccion, String poblacion, String provincia, String dni){
		
		Socio socio = new Socio();
		socio.setNombre(nombre);
		socio.setApellido(apellido);
		socio.setDireccion(direccion);
		socio.setPoblacion(poblacion);
		socio.setProvincia(provincia);
		socio.setDni(dni);
		
		this.socio_modelo.insert(socio);
	}
	
	public void deleteSocio(int id){
		this.socio_modelo.delete(id);
	}
}
