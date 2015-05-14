package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class UsuariosModel {
	static ConexionDB ConDB = new ConexionDB();
	private ArrayList<String> usuarios = null;
	public  UsuariosModel() {
		usuarios = new ArrayList<String>();
	}
 
	

	public  ArrayList getUsuarios() throws SQLException {
		ConDB.conexion();
		try {
			String sql9 = "SELECT *  FROM Usuarios;";
	ConDB.conjuntoResultados = ConDB.instruccion.executeQuery(sql9);

			while (ConDB.conjuntoResultados.next())
				usuarios.add(ConDB.conjuntoResultados.getString("Usuario"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConDB.cerrarConexion();
		return usuarios;
		
		
	}


	
}
