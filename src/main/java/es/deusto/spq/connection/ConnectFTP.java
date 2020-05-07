package es.deusto.spq.connection;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import es.deusto.spq.Users;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class ConnectFTP {
	private static final String ORIGINAL= "ÁáÉéÍíÓóÚúÑñÜü";private static final String REPLACEMENT = "AaEeIiOoUuNnUu";
	private final String userFTP = "CalculaTUS_II";
	private final String pass = "BI7812cb!";
	private Users main_user;
	private FTPClient cliente = new FTPClient();
	private Connect c = new Connect();
	
	public static String stripAccents(String str) {
	    if (str == null || str =="") {
	        return null;
	    }
	    char[] array = str.toCharArray();
	    for (int index = 0; index < array.length; index++) {
	        int pos = ORIGINAL.indexOf(array[index]);
	        if (pos > -1) {
	            array[index] = REPLACEMENT.charAt(pos);
	        }
	    }
	    return new String(array);
	}
	
	public ConnectFTP (Users user) {
		if( user != null &&  c.buscar_usuario(user.getEmail())) {
			this.main_user = user;
		}else {
		}
	}
	
	public boolean OpenConexion() {
		if( main_user != null && c.buscar_usuario(main_user.getEmail())) {
			try {
				cliente.connect("83.213.204.144", 21);
				//cliente.enterLocalPassiveMode();
				cliente.changeWorkingDirectory("/"+main_user.getEmail());
				boolean login = cliente.login(userFTP, pass);
				if(login) {
					System.out.println("Conectado al servidor");
					cliente.enterLocalPassiveMode();
					cliente.changeWorkingDirectory("/"+main_user.getEmail());
					return true;
				}else {
					System.out.println("Fallo al conectarse");
					return false;
				}
			}catch (IOException ioE) {
				System.out.println(ioE);
				ioE.printStackTrace();
				return false;
			}
		}else {
			return false;
		}
	}
	public boolean closeConnection() {
		if( main_user != null && c.buscar_usuario(main_user.getEmail()) ) {
			try {
				cliente.disconnect();
				return true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}else {
			return false;
		}
	}
	public boolean regisUserFolder() {
		if( main_user != null && c.buscar_usuario(main_user.getEmail()) ) {
			try {
				OpenConexion();
				boolean creado = cliente.makeDirectory("/"+main_user.getEmail());
				closeConnection();
				return creado;
			} catch (IOException e) {
				System.out.println(e);
				e.printStackTrace();
				return false;
			}
		}else {
			return false;
		}
	}
	public boolean uploadFile( File f , String path) {
		if(f != null && path != "") {
			try {
				OpenConexion();
				FileInputStream is = new FileInputStream(f);
				String nom = stripAccents(f.getName());
				cliente.storeFile(path+"\\"+nom, is);
				closeConnection();
				return true;
			} catch (FileNotFoundException e) {
				System.out.println("FILE NOT FOND"+e);
				//e.printStackTrace();
				return false;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("IO"+e);
				//e.printStackTrace();
				return false;
			}
		}else {
			return false;
		}
	}
	public boolean downloadFile(String path) {
		File f2 = new File(path);
		if( path != "" && f2.exists() && path != null ) {
			try {
				OpenConexion();
				//TODO
				File f = new File(path);
				FileOutputStream fos = new FileOutputStream(f);
				cliente.retrieveFile(path+f.getName(), fos);
				closeConnection();
				return true;
			}catch(Exception e) {
				System.out.println(e);
				e.printStackTrace();
				return false;
			}
		}else {
			return false;
		}
	}
	public ArrayList<FTPFile> getUserFolders(String path){
		if( path != "" && path != null) {
			ArrayList<FTPFile> carpetas = new ArrayList<FTPFile>();
			carpetas.add(null);
			System.out.println(path);
			try {
				OpenConexion();
				FTPFile[] car = cliente.listDirectories(path);
				closeConnection();
				for( FTPFile  f : car ){
					carpetas.add(f);
				}
				return carpetas;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}else {
			return null;
		}
		
	}
	public ArrayList<FTPFile> getUserFiles(String path) {
		if( path != null && path != "null" ) {
			ArrayList<FTPFile> ficheros = new ArrayList<FTPFile>();
			ficheros.add(null);
			try {
				OpenConexion();
				FTPFile[] fich = cliente.listFiles(path);
				closeConnection();
				for( FTPFile f : fich ) {
					ficheros.add(f);
				}
				return ficheros;
			}catch(Exception e) {
				System.out.println(e);
				e.printStackTrace();
				return null;
			}
		}else {
			return null;
		}
	}
	public boolean createDir(String path) {
		if( path != null && path != "null" ) {
			try {
				OpenConexion();
				System.out.println("Este es path de la nueva carpeta " + path);
				if(cliente.makeDirectory(path)) {
					closeConnection();
					return true;
				}else {
					closeConnection();
					return false;
				}
				
			}catch(Exception e) {
				System.out.println(e);
				e.printStackTrace();
				return false;
			}
		}else {
			return false;
		}
	}
}
