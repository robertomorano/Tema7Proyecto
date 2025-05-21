package crud.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import crud.entidades.Profesores;
import utils.Constantes;

public class ProfesoresDao {
	private Connection conexion;

	/**
	 * 
	 */
	public ProfesoresDao() {

		try {
			conexion = DriverManager.getConnection(Constantes.URL, Constantes.USUARIO, Constantes.CONTRASEÑA);
		} catch (SQLException e) {
			System.out.println("Error al crear la conexión con la base de datos: " + e.getMessage());
		}

	}

	/**
	 * Comprobar si la conexio fue exitosa
	 * 
	 * @return objeto conexion
	 */
	public Connection getConexion() {
		return conexion;
	}
	
	/**
	 * 
	 * @param profesor
	 */
	public void create(Profesores profesor) {
		String sql = "INSERT INTO profesores (nombre, apellido, especialidad, email)"
				+ "VALUES (?, ?, ?, ?)";

		PreparedStatement ps;
		try {
			ps = conexion.prepareStatement(sql);
			ps.setString(1, profesor.getNombre());
			ps.setString(2, profesor.getApellido());
			ps.setString(3, profesor.getEspecialidad());
			ps.setString(4, profesor.getEmail());

			ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al insertar el profesor: " + e.getMessage());
		}

	}
	
	/**
	 * 
	 * @param id
	 */
	public void delete(int id) {
		UpdateNullOthers(id);
		String sql = "DELETE FROM profesores WHERE id_profesor = ?";
		PreparedStatement ps;
		try {
			ps = conexion.prepareStatement(sql);
			ps.setInt(1,id);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al eliminar el profesor: " + e.getMessage());
		}
	}
	
	public void UpdateNullOthers(int id) {
		String sql = "UPDATE  ? SET id_profesor = NULL WHERE id_profesor = ?";
		PreparedStatement ps;
		try {
			ps = conexion.prepareStatement(sql);
			ps.setString(1, "calificaciones");
			ps.setInt(2,id);
			ps.addBatch();
			
			ps.setString(1, "cursoprofesor");
			ps.setInt(2,id);
			ps.addBatch();
			
			ps.executeBatch();
		} catch (SQLException e) {
			System.out.println("Error al eliminar el profesor: " + e.getMessage());
		}
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Profesores selectProfesor(int id) {
		String sql = "Select * FROM profesores WHERE id_profesor = ?";
		PreparedStatement ps;
		ResultSet rs = null;
		Profesores encontrado = null;
		try {
			ps = conexion.prepareStatement(sql);
			ps.setInt(1,id);
			rs = ps.executeQuery();
			while(rs.next()) {
				encontrado = new Profesores(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5));
			}
			
			
		} catch (SQLException e) {
			System.out.println("Error al eliminar el profesor: " + e.getMessage());
		}
		return encontrado;
	}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<Profesores> listProfesores() {
		ArrayList<Profesores> profesores = new ArrayList<>();
		String sql = "Select * FROM profesores";
		PreparedStatement ps;
		ResultSet rs = null;
		Profesores profesor = null;
		try {
			ps = conexion.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				profesor = new Profesores(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5));
				profesores.add(profesor);
			}
			
			
		} catch (SQLException e) {
			System.out.println("Error al eliminar el profesor: " + e.getMessage());
		}
		return profesores;
	}
	
	
	public void updateEmail(int id, String nuevoEmail) {
		String sql = "UPDATE profesores SET email = ? WHERE id_profesor = ?";
		PreparedStatement ps;
		try {
			ps = conexion.prepareStatement(sql);
			ps.setString(1, nuevoEmail);
			ps.setInt(2,id);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al eliminar el profesor: " + e.getMessage());
		}
	}
	
	public void updateEspecialidad(int id, String nuevoEspecialidad) {
		String sql = "UPDATE profesores SET especialidad = ? WHERE id_profesor = ?";
		PreparedStatement ps;
		try {
			ps = conexion.prepareStatement(sql);
			ps.setString(1, nuevoEspecialidad);
			ps.setInt(2,id);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al eliminar el profesor: " + e.getMessage());
		}
	}
}
