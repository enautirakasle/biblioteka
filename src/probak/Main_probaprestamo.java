package probak;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

import modelo.Prestamo;
import modelo.Prestamo_modelo;

public class Main_probaprestamo {

	public static void main(String[] args) {
		
		Prestamo_modelo pm = new Prestamo_modelo();
		
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
