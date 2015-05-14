package Modelo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionDB {
	// lo ponemos private para que no se puedan utilizar desde otra clase ya que
	// son datos tipo: ususario, contraseña, etc..
	private static String url = "jdbc:mysql://localhost/Juegos";
	private static String user = "root";
	private static String pw = "password";
	private static String Driver = "com.mysql.jdbc.Driver";
	private static Connection conexion = null;
	public static Statement instruccion = null;
	public static ResultSet conjuntoResultados = null;
	
	/*
	 * creamos un metodo conexion y desconexion para podernos conectar y
	 * desconectar cuando sea necesario, en el caso de que se implemente la
	 * clase no este conectado todo el tiempo de la ejecucion si no es necesario
	 */
	public static void conexion() throws SQLException {

		try { // poner el driver
			Class.forName(Driver);
		} catch (ClassNotFoundException e) {
			System.err.println("No se encuentra el controlador");
		}

		// obtenemos la conexión con el DriverManager y hacer consultas
		try {
			conexion = DriverManager.getConnection(url, user, pw);
			instruccion = conexion.createStatement();
			System.out.println("Conexión realizada ");

		} catch (SQLException e) {
			if (e.getSQLState().equals("28000"))
				System.out.println("Error de autentificación");
			if (e.getSQLState().equals("08S01"))
				System.out.println("Error de conexion, revisar si la conexion es correcta y que el SGBD esta operativo");
			else
				throw e;
			e.printStackTrace();
		}

	}
	
	public static void cerrarConexion() {
		try {

		} finally {
			try {
				if (conjuntoResultados != null
						&& !conjuntoResultados.isClosed())
					conjuntoResultados.close();
			} catch (SQLException e) {
				Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null,
						e);
			}
			try {
				if (instruccion != null && !instruccion.isClosed())
					instruccion.close();
			} catch (SQLException e) {

			}
			try {
				if (conexion != null && !conexion.isClosed())
					conexion.close();
			} catch (SQLException e) {

			}
			System.out.println("Conexiónes cerradas ");
		}
	}
	



}
