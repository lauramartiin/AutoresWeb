package autores;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GestionBD {
	private static final String URL_BD = "jdbc:mysql://iescristobaldemonroy.duckdns.org:33306/BD19";
	private static final String CONTRASENNA = "b1u766ta";
	private static final String USUARIO = "USER_BD19";

	private static Connection conexion;

	public static void abrirConexion() throws SQLException {

		conexion = DriverManager.getConnection(URL_BD, USUARIO, CONTRASENNA);

	}

	public static void cerrarConexion() throws SQLException {
		conexion.close();
	}
	
	// La función executeUpdate() se usa porque la operación no devuelve resultados, 
	//sino que modifica los datos. Devuelve el número de filas afectadas.
	public static int insertarAutor(String nombre, String nacionalidad, String FNacimiento) throws SQLException {
		int filasAfectadas;
		Statement sentencia = conexion.createStatement();
		filasAfectadas = sentencia.executeUpdate("INSERT INTO Autor (nombre, nacionalidad, FNacimiento) VALUES ('"
				+ nombre + "','" + nacionalidad + "','" + FNacimiento + "')");
		return filasAfectadas;

	}

	public static int insertarLibro(int isbn, String editorial, String titulo, String idioma, String tipo)
			throws SQLException {
		int filasAfectadas;
		Statement sentencia = conexion.createStatement();
		filasAfectadas = sentencia.executeUpdate("INSERT INTO Libro (isbn, Editorial, titulo, idioma, tipo) VALUES ('"
				+ isbn + "','" + editorial + "','" + titulo + "','" + idioma + "','" + tipo + "')");
		return filasAfectadas;

	}

//	Este método ejecuta una consulta SQL para obtener todos los autores de la tabla Autor. 
//	Usa executeQuery() porque la consulta devuelve un conjunto de resultados (ResultSet), 
//	que es devuelto al llamante. La consulta SQL selecciona todas las filas de la tabla Autor.
	public static ResultSet consultarAutores() throws SQLException {
		ResultSet resultadoQuery;
		Statement sentencia = conexion.createStatement();
		resultadoQuery = sentencia.executeQuery("SELECT * FROM Autor");
		return resultadoQuery;

	}

	public static ResultSet consultarLibros() throws SQLException {
		ResultSet resultadoQuery;
		Statement sentencia = conexion.createStatement();
		resultadoQuery = sentencia.executeQuery("SELECT * FROM Libro");

		return resultadoQuery;

	}
//	Este método busca autores cuyo nombre contenga el término proporcionado en el parámetro nombreBuscar. 
//	La consulta SQL utiliza LIKE y los signos de porcentaje (%) para hacer una búsqueda parcial 
//	(es decir, encontrar coincidencias que contengan el texto buscado en cualquier parte del campo Nombre). 
//	El resultado es un conjunto de resultados que se devuelve.
	public static ResultSet consultarLibrosAutor(String nombreBuscar) throws SQLException {
		ResultSet resultadoQuery;
		Statement sentencia = conexion.createStatement();
		resultadoQuery = sentencia.executeQuery("SELECT * FROM Autor WHERE Nombre LIKE '%" + nombreBuscar + "%'");
		return resultadoQuery;

	}
}
