package modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Prestamo {
	private int id_socio;
	private int id_libro;
	private Date fecha;
	private boolean devuelto;
	
	public Prestamo(int id_socio, int id_libro, Date fecha, boolean devuelto) {
		super();
		this.id_socio = id_socio;
		this.id_libro = id_libro;
		this.fecha = fecha;
		this.devuelto = devuelto;
	}

	public int getId_socio() {
		return id_socio;
	}

	public void setId_socio(int id_socio) {
		this.id_socio = id_socio;
	}

	public int getId_libro() {
		return id_libro;
	}

	public void setId_libro(int id_libro) {
		this.id_libro = id_libro;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public boolean isDevuelto() {
		return devuelto;
	}

	public void setDevuelto(boolean devuelto) {
		this.devuelto = devuelto;
	}
	
	public void mostrarInfo(){
		String bbdd = "biblioteka";
		SocioModelo sm = new SocioModelo();
		LibroModelo lm = new LibroModelo();
		
		String nombre_libro = lm.select(this.id_libro).getTitulo();
		
		String nombre_socio = sm.select(this.id_socio).getNombre();
		
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		
		System.out.println("Socio: " + nombre_socio + " - Libro: "+ nombre_libro + " - Fecha de prestamo: " + formato.format(this.fecha) + " - Devuelto: " + (this.devuelto?"si":"no"));
		
		System.out.println("socio: " + nombre_socio);
		System.out.println("Libro: " + nombre_libro);
		System.out.println("Fecha prest: " + formato.format(this.fecha));
		if(this.devuelto){
			System.out.println("Devuelto: si");
		}else{
			System.out.println("Devuelto: no");
		}
		
		
	}
	
}
