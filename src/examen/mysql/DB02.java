package examen.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mitienda.spring.models.Categoria;

import paquete.DbQuery; 

public class DB02 {

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
	
	/*
	 * @Repository
		public interface CategoriasRepository extends CrudRepository<Categoria, Long> 
	 */
	
	/**
	 * Preguntas Teoricas:
	 */
	
	/**
	 * 1.- ¿En que fichero está la configuración de conexion a base de datos de Spring/Hibernate?
	 * .- Config.java
	 * .- src.main.resources.application.properties <= TRUE
	 */
	
	/**
	 * 2.- ¿El campo Long que hay en la declaración del CategoriasRepository a que corresponde?
	 * .- A un identificador interno de Hibernate
	 * .- Al tipo de ID de la clase Categoria <= TRUE
	 * .- Al campo que vamos a usar para buscar en la base de datos
	 * .- A la longitud de los campos que se pueden usar en la clase Categoria
	 */
	
	/**
	 * 3.- ¿Para que usamos la clase categoriasRepository?
	 * .- Tiene todas las funciones que necesitamos para recoger/insertar información en la base de datos
	 * .- Para conectar con la base de datos; y luego usamos otra clase para recoger la información
	 * .- Para identificar donde tenemos que subir el código de la practicas
	 * .- No me preguntes; voté a Kodos
	 */

}
