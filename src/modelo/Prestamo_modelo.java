package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class Prestamo_modelo extends Conector{

	public Prestamo_modelo() {
		super();
	}
	
	public ArrayList <Prestamo> select(){
		ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>(); 
		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from prestamos");
			while(rs.next()){
				prestamos.add(new Prestamo(rs.getInt("id_socio"),rs.getInt("id_libro"), new java.util.Date(rs.getDate("fecha").getTime()), rs.getBoolean("devuelto")));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prestamos;
	}
	
	public Prestamo select(int id_libro, int id_socio, Date fecha){
		PreparedStatement pst;
		try {
			pst = this.conexion.prepareStatement("select * from prestamos where id_libro =? and id_socio = ? and fecha=?");
			pst.setInt(1, id_libro);
			pst.setInt(2, id_socio);
			
			//TODO kontuz sql eta util datekin
			pst.setDate(3, (java.sql.Date)fecha);
			ResultSet rs = pst.executeQuery();
			rs.next();
			return new Prestamo(rs.getInt("id_socio"),rs.getInt("id_libro"), new java.util.Date(rs.getDate("fecha").getTime()), rs.getBoolean("devuelto"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Prestamo> prestamosNoDevueltos(int idLibro){
		ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
		PreparedStatement pst;
		try {
			pst  = this.conexion.prepareStatement("select * from prestamos where id_libro = ? and devuelto = ?");
			pst.setInt(1, idLibro);
			pst.setBoolean(2, false);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()){
				prestamos.add(new Prestamo(rs.getInt("id_socio"),rs.getInt("id_libro"), new java.util.Date(rs.getDate("fecha").getTime()), rs.getBoolean("devuelto")));
			}
			return prestamos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Prestamo> prestamosDeSocio(int idSocio){
		ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
		PreparedStatement pst;
		try {
			pst  = this.conexion.prepareStatement("select * from prestamos where id_socio = ?");
			pst.setInt(1, idSocio);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()){
				prestamos.add(new Prestamo(rs.getInt("id_socio"),rs.getInt("id_libro"), new java.util.Date(rs.getDate("fecha").getTime()), rs.getBoolean("devuelto")));
			}
			return prestamos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * SELECT libros.titulo, socios.nombre, prestamos.fecha, prestamos.devuelto FROM libros RIGHT JOIN `prestamos` 
	 * on libros.id = prestamos.id_libro LEFT JOIN socios on prestamos.id_socio = socios.id 
	 */
	
	
	
	public void insert(Prestamo prestamo){
		try {
			PreparedStatement ps = this.conexion.prepareStatement("insert into prestamos (id_libro, id_socio, fecha, devuelto) values(?,?,?,?)");
			
			ps.setInt(1, prestamo.getId_libro()); //lehen galdera ikurra bete
			
			ps.setInt(2, prestamo.getId_socio()); //bigarren galdera ikurra bete
			
			long utilDateLong = prestamo.getFecha().getTime();
			java.sql.Date sqlFecha = new java.sql.Date(utilDateLong);
			ps.setDate(3,  sqlFecha); //hirugarren galdera ikurra
			
			ps.setBoolean(4, prestamo.isDevuelto());
			
			ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int devolver(Prestamo prestamo){
		//TODO pentsatu behar da hau nola planteatu
		return 0;
		
	}


}
