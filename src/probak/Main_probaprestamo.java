package probak;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

import modelo.Prestamo;
import modelo.PrestamoModelo;

public class Main_probaprestamo {

	public static void main(String[] args) {
		
		PrestamoModelo pm = new PrestamoModelo();
		
		ArrayList<Prestamo> prestamos = pm.select();
		Iterator<Prestamo> i = prestamos.iterator();
		SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
		Prestamo p;
		while(i.hasNext()){
			p = i.next();
			System.out.println(p.getId_libro() +" "+ p.getId_socio() +" "+ sdf.format(p.getFecha())+" "+ p.isDevuelto());
		}
		
		

	}

}
