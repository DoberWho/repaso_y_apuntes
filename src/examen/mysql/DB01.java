package examen.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

import paquete.DbQuery; 

public class DB01 {

	private DbQuery db = DbQuery.getInstance();
	
	
	/*
	 CREATE TABLE `categorias` (
		`id` INT(11) NOT NULL AUTO_INCREMENT,
		`created` DATETIME NULL DEFAULT NULL,
		`nombre` VARCHAR(255) NULL DEFAULT NULL COLLATE 'latin1_spanish_ci',
		PRIMARY KEY (`id`)
	)
	
	CREATE TABLE `producto` (
		`id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
		`created` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
		`nombre` VARCHAR(100) NULL DEFAULT NULL COLLATE 'latin1_spanish_ci',
		`precio` SMALLINT(5) UNSIGNED NULL DEFAULT NULL,
		`stock` SMALLINT(5) UNSIGNED NULL DEFAULT '0',
		`id_categoria` INT(10) UNSIGNED NULL DEFAULT NULL,
		PRIMARY KEY (`id`)
	) 
	 */
	
	public static void main(String[] args) throws SQLException {
		
		String sql01 = "SELECT * FROM producto";
		String sql02 = "SELECT * FROM categorias";
		String sql03 = "SELECT * FROM producto where id_categoria = {id}";
		String sql04 = "SELECT * FROM categorias c JOIN producto p on (p.id_categoria == c.id ) where p.id = {id}";
		
		DB01 db01 = new DB01();
		
		// Consultas A
		db01.db.ejecutar(sql01); // CONSULTA A1
		db01.db.ejecutar(sql02); // CONSULTA A2
		db01.db.ejecutar(sql03); // CONSULTA A3
		db01.db.ejecutar(sql04); // CONSULTA A4
		
		// Consultas B
		db01.db.ejecutarYDevolver(sql01); // CONSULTA B1
		db01.db.ejecutarYDevolver(sql02); // CONSULTA B2
		db01.db.ejecutarYDevolver(sql03); // CONSULTA B3
		db01.db.ejecutarYDevolver(sql04); // CONSULTA B4
		
	}
	
	/**
	 * Preguntas Teoricas:
	 */
	
	/**
	 * 1.- Sabiendo que ejecutar no devuelve nada y ejecutarYDevolver 
	 * devuelve un resultSet. ¿Cual es la combinación correcta? (Consultas A, Consultas B)
	 * .- Si; es cierto.
	 * .- Consultas B; por que nos devuelve el ResultSet de los datos
	 */
	
	/**
	 * 2.- Si añadimos la consulta: "INSERT INTO `categorias` (`nombre`) VALUES ('{nombre}');" como sql05.
	 * ¿Que funcion deberiamos usar?
	 * .- ejecutar <= TRUE
	 * .- ejecutarYDevolver
	 */
	
	/**
	 * 3.- ¿Para que se usan las transacciones?
	 * .- Para intercambio de divisas entre paises y cuentas bancarias
	 * .- Para preparar un entorno seguro en el que ejecutar consultas y volver al estado inicial de la
	 * transacción si algo falla <= TRUE
	 * .- Para tener un metodo de recuperación de los datos que hemos borrado por error al olvidarnos el
	 * where en el "delete from"
	 * .- Para volver para atrás las consultas hechas, y no preocuparnos de haber metido la pata en una 
	 * SQl mal formada.
	 */
	
	/**
	 * Teniendo en cuenta: 
	 	ResultSet res = statemnt.executeQuery(sql);
			
		while(res.next()) { 
			Object nObj = obj.getDbObject(res);
		} 
	 * 
	 * 
	 * 4.- ¿Como podemos recoger los datos de una clase determinada (Por Ejemplo; Categorias)?
	 * .- Casteando el Resulset en un Categoria
	 * .- Necesitamos recoger cada uno de los campos da la base de datos con getInt, getString, etc. 
	 * y generar la instancia del objeto Categoria
	 */
	
	/**
	 * 5.- En esta consulta; que es lo falla:
	 * - 
	 */
}
