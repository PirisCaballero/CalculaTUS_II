package com.mycompany.app.Connection;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import com.mycompany.app.Users;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ConnectFTP {
	private static final String ORIGINAL= "ÁáÉéÍíÓóÚúÑñÜü";private static final String REPLACEMENT = "AaEeIiOoUuNnUu";
	private final String userFTP = "CalculaTUS_II";
	private final String pass = "BI7812cb!";
	private Users main_user;
	private FTPClient cliente = new FTPClient();
	
	public static String stripAccents(String str) {
	    if (str == null) {
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
		this.main_user = user;
	}
	
	public boolean OpenConexion() {
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
	}
	public boolean closeConnection() {
		try {
			cliente.disconnect();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public boolean regisUserFolder() {
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
	}
	public boolean uploadFile( File f) {
		try {
			OpenConexion();
			FileInputStream is = new FileInputStream(f);
			String nom = stripAccents(f.getName());
			cliente.storeFile(nom, is);
			closeConnection();
			return true;
		} catch (FileNotFoundException e) {
			System.out.println("FILE NOT FOND"+e);
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IO"+e);
			e.printStackTrace();
			return false;
		}
	}
	public File downloadFile(String path , String path_Descarga) {
		File f = null;
		try {
			OpenConexion();
			//TODO
			String var = path.replace("\\", "/");
			String[] nom = var.split("/");System.out.println( nom[ nom.length-1 ] );
			
			File descarga = new File(path_Descarga+"/"+nom[ nom.length-1 ]);
			OutputStream out = new BufferedOutputStream( new FileOutputStream(descarga));
			boolean des = cliente.retrieveFile(path, out);
			closeConnection();
			System.out.println(des);
			return f;
		}catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
			return null;
		}
	}
	public FTPFile[] getUserFolders(String path){
		System.out.println(path);
		try {
			OpenConexion();
			FTPFile[] carpetas = cliente.listDirectories(path);
			closeConnection();
			return carpetas;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public FTPFile [] getUserFiles(String path) {
		try {
			OpenConexion();
			FTPFile[] ficheros = cliente.listFiles(path);
			System.out.println(ficheros.length);
			closeConnection();
			return ficheros;
		}catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
			return null;
		}
	}
	public boolean createDir(String path) {
		
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
	}
	public static void main(String[] args) {
		Users us = new Users("Admin", "Root", "admin@root.es", "root", 1, "null");
		ConnectFTP ftp = new ConnectFTP(us);
		ftp.getUserFiles("\\"+us.getEmail()+"\\Carpeta 1");
		ftp.downloadFile("D:\\Server\\FTP\\"+us.getEmail()+"\\Carpeta 2\\Carpeta 3\\Ficherito.txt" , "src/main/");
	}
	
}