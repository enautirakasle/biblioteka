package principal;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

import modelo.*;

public class Main {
	
	public final static int INSERTAR_LIBRO = 1;
	public final static int INSERTAR_SOCIO = 2;
	public final static int VER_LIBROS = 3;
	public final static int VER_SOCIOS = 4;
	public final static int VER_LIBRO = 5;
	public final static int VER_SOCIO = 6;
	public final static int DELETE_LIBRO = 7;
	public final static int DELETE_SOCIO = 8;
	public final static int LIBROS_DE_AUTOR = 9;
	public final static int REALIZAR_PRESTAMO = 10;
	public final static int VER_PRESTAMOS_DE_SOCIO = 11;
	
	public final static int SALIR = 0;
	

	public static void main(String[] args) {
		// MAIN DE PRUEBA PARA LIBRO
		int id;//para ver libro y socio, delete libro y socio
		ArrayList<Libro> libros;
		Iterator<Libro> il;
		Socio socio;

		// Instanciar

		Libro_modelo lm = new Libro_modelo("biblioteka");
		Socio_modelo sm = new Socio_modelo("biblioteka");
		Prestamo_modelo pm = new Prestamo_modelo("biblioteka");
		
		Scanner scan = new Scanner(System.in);

		int opcion;
		do {
			System.out.println("\n~~~~~ MENÚ PRINCIPAL ~~~~~");
			System.out.println("1. Insertar libro");
			System.out.println("2. Insertar socio");
			System.out.println("3. Ver libros");
			System.out.println("4. Ver socios");
			System.out.println("5. Ver libro");
			System.out.println("6. Ver socio");
			System.out.println("7. Eliminar libro");
			System.out.println("8. Eliminar socios");
			System.out.println("9. Ver libros de autor");
			System.out.println("10. Realizar prestamo");
			System.out.println("11. Ver prestamos de socio");
			
			System.out.println("0. Salir del menú\n");
			
			opcion = Integer.parseInt(scan.nextLine());
			switch (opcion) {

			case INSERTAR_LIBRO: // INSERT LIBRO
				System.out.println("Introduce el titulo del libro:");
				String titulo = scan.nextLine();
				
				System.out.println("Introduce el autor del libro:");
				String autor = scan.nextLine();
				System.out.println("Introduce el numero de paginas del libro:");
				int num_pag = Integer.parseInt(scan.nextLine());
				
				lm.insert(new Libro(0, titulo, autor, num_pag));
				break;

			case INSERTAR_SOCIO: // INSERT SOCIO
				
				System.out.println("Mete los siguientes datos requeridos.");
				System.out.print("Nombre:");
				String nombre = scan.nextLine();
				System.out.print("Apellido:");
				String apellido = scan.nextLine();
				System.out.print("Direccion:");
				String direccion = scan.nextLine();
				System.out.print("Poblacion:");
				String poblacion = scan.nextLine();
				System.out.print("Provincia:");
				String provincia = scan.nextLine();
				System.out.print("DNI:");
				String dni = scan.nextLine();

				socio = new Socio(0,nombre,apellido,direccion,poblacion,provincia,dni);
				sm.insert(socio);
				break;

			case VER_LIBROS: // VER LIBROS
				libros = lm.select();
				il = libros.iterator();
				
				while(il.hasNext()){
					il.next().mostrarInfo();
				}
				break;
				
			case VER_SOCIOS: // VER SOCIOS
				ArrayList<Socio> socios = sm.select();
				Iterator<Socio> is = socios.iterator();
				
				while(is.hasNext()){
					is.next().mostrarInfo();
				}
				break;
				
			case VER_LIBRO:
				System.out.println("Introduce un id para ver libro:");
				id = Integer.parseInt(scan.nextLine());
				
				lm.select(id).mostrarInfo();
				break;
			case VER_SOCIO:
				System.out.println("Introduce un id para ver socio:");
				id = Integer.parseInt(scan.nextLine());
				
				sm.select(id).mostrarInfo();
				break;
			case DELETE_LIBRO:
				System.out.println("Introduce un id para eliminar libro:");
				id = Integer.parseInt(scan.nextLine());
				
				lm.delete(id);
				break;
			case DELETE_SOCIO:
				System.out.println("Introduce un id para eliminar socio:");
				id = Integer.parseInt(scan.nextLine());
				
				lm.delete(id);
				break;
			case LIBROS_DE_AUTOR:
				
				System.out.println("Introduce un autor: ");
				autor = scan.nextLine();
				libros = lm.selectLibrosDeAutor(autor);
				il = libros.iterator();
				while(il.hasNext()){
					il.next().mostrarInfo();
				}
				
				break;
			case REALIZAR_PRESTAMO:
				System.out.println("Introduce un id de socio:");
				int id_socio = Integer.parseInt(scan.nextLine());
				System.out.println("Introduce un id de libro:");
				int id_libro = Integer.parseInt(scan.nextLine());
				
				pm.insert(new Prestamo(id_socio, id_libro, new Date(), false));
				System.out.println("Prestamo realizado! socio: " + sm.select(id_socio).getNombre()+ ", libro: " + lm.select(id_libro).getTitulo());
				break;
			case VER_PRESTAMOS_DE_SOCIO:
				System.out.println("Introduce un nombre de socio:");
				String nombre_socio = scan.nextLine();
				
				socio = sm.selectSocioPorNombre(nombre_socio);
				ArrayList<Prestamo> prestamos = pm.prestamosDeSocio(socio.getId());
				
				Iterator<Prestamo> i = prestamos.iterator();
				while(i.hasNext()){
					i.next().mostrarInfo();
				}
				break;
			case SALIR:
				System.out.println("Saliendo....");
				break;

			default:
				System.out.println("Elige una de las opciones del menú.");
			}
		} while (opcion != 0);

	}

}
