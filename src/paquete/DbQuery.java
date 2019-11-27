package paquete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbQuery {

	/*
	 * Datos para conectar con un SQLITE
	 */
	public static final String PATH = "c:/miTienda/"; // Donde esta el fichero de la base de datos
	public static final String PATH_DB = PATH + "db/"; // Idem anterior
	public static final String DBNAME = "database.db"; // Fichero de base de datos

	/*
	 * Datos para conectar con un MYSQL
	 */
	public static final String DBMYSQL_HOST = "127.0.0.1"; // localhost // IP del servidor
	public static final String DBMYSQL_PORT = "3307"; // Puerto de la base de datos
	public static final String DBMYSQL_DBNAME = "mitienda"; // Nombre de la base de datos
	public static final String DBMYSQL_USER = "root"; // Usuario de la base de datos
	public static final String DBMYSQL_PASS = "test1234"; // Contraseña de la base de datos

	/*
	 * Rutas de conectores de base de datos
	 */
	public static final String DBSQLITE = "jdbc:sqlite:" + PATH_DB + DBNAME;
	public static final String DBMYSQL = "jdbc:mysql://" + DBMYSQL_HOST + ":" + DBMYSQL_PORT + "/" + DBMYSQL_DBNAME;

	private Connection conn;

	private static DbQuery instance;

	private DbQuery() {

		// create a connection to the database
		try {
			conn = DriverManager.getConnection(DBMYSQL); // CON MYSQL
			// conn = DriverManager.getConnection(DBSQLITE); // CON SQLITE
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static DbQuery getInstance() {
		if (instance == null) {
			instance = new DbQuery();
		}
		return instance;
	}

	/**
	 * Esta función para las consultas que tienen que devolver cosas; ya sea un
	 * elemento o varios. <strong>SELECT</strong>
	 * 
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public ResultSet ejecutarYDevolver(String sql) throws SQLException {

		Statement statemnt = this.conn.createStatement();
		
		ResultSet res = statemnt.executeQuery(sql);

		return res;
	}

	/**
	 * Esta función para las consultas que no tienen que devolver los datos o no nos
	 * importa que devuelve. <strong>INSERT, DELETE</strong>
	 * 
	 * @param sql
	 * @throws SQLException
	 */
	public void ejecutar(String sql) throws SQLException {
		Statement statemnt = this.conn.createStatement();
		statemnt.execute(sql);
	}

}
