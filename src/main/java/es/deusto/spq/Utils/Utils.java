package es.deusto.spq.Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Utils {
	private Properties p;
	/**
	 * Esta funcion lee el archivo properties y configura la aplicacion
	 */
	public String propertiesReader(String properti) {
		p = new Properties();
		String propertie = null;
		File ar = new File(".properties");
		try {
			FileReader F = new FileReader(ar);
			p.load(F);
			propertie = p.getProperty(properti);
			F.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			propertie = null;
		} catch (IOException e) {
			e.printStackTrace();
			propertie = null;
		}
		return propertie;
	}
	
	/**
	 * Este metodo comprueba el archivo .properties y devuelve si el usuario quiere usar una base de datos remota o quiere tener la suya propia en local
	 * @return boolean
	 * @deprecated
	 * No se hace test, ya que no se usa
	 */
	public boolean BaseRemota() {
		boolean remoto = false;
		String p = "BaseDeDatos_Remota";
		if (propertiesReader(p)==null ) {
			//System.out.println("No esta seleccionado");
			remoto = true;
		}else {
			if(propertiesReader(p).equals("False")) {
			//	System.out.println("Usar base local");
				remoto = false;
			}else {
				//System.out.println("Usar base remota");
				remoto = true;
			}
		}
		return remoto;
	}
	/**
	 * Devuelve la informacion del servidor remoto
	 * @return HashMap
	 */
	public HashMap<String , String> getServerData (){
		HashMap<String , String> serverData = new HashMap<>();
		serverData.put("Servidor", propertiesReader("Servidor"));
		serverData.put("Nombre_BBDD", propertiesReader("Nombre_BBDD"));
		serverData.put("Nombre_Usuario", propertiesReader("Nombre_Usuario"));
		serverData.put("Contraseña", propertiesReader("Contraseña"));
		return serverData;
	}
	/**
	 * Esta clase devuelve la conexion a la base de datos, ya sea local o remota
	 * @return
	 */
	public Connection crearConexion() {
		Connection cn;
			HashMap<String , String> SD = getServerData();
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException ex) {
				System.out.println("Error al registrar el driver de MySQL: " + ex);
			}
			try {
				cn = DriverManager.getConnection(SD.get("Servidor")+"/"+SD.get("Nombre_BBDD"), SD.get("Nombre_Usuario"),
				SD.get("Contraseña"));
				return cn;
			} catch (SQLException sqlE) {
				sqlE.printStackTrace();
				return null;
			}
		
	}
	public static void main(String[] args) {
		Utils u = new Utils();
		
	}

}
