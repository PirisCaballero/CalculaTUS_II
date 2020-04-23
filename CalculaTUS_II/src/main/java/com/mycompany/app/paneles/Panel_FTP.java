package com.mycompany.app.paneles;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.StreamSupport;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.commons.net.ftp.FTPFile;

import com.mycompany.app.Users;
import com.mycompany.app.connection.ConnectFTP;
import java.awt.Choice;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Panel_FTP extends JPanel{
	
	/**
	 * Betha 1.1
	 */
	private static final long serialVersionUID = 1L;
	private Users main_user;
	private ConnectFTP cFTP;
	private JPanel p;
	private String lastDir = "";private File fichero;private JFileChooser fileChooser;
	private Choice Cfolders , C_files; private FTPFile[] carpetas , ficheros;
	private String FolSel , path;
	public Panel_FTP(Users us) {
		this.main_user = us;
		this.setBounds(0 , 0 , 574 , 470);
		this.setBackground(Color.white);
		this.setLayout(null);
		this.setVisible(false);
		p = this;
		cFTP = new ConnectFTP(main_user);
		FolSel = "\\"+main_user.getEmail()+"\\";
		path = "\\"+main_user.getEmail()+"\\";
		///Componentes	
		
		
		JButton button = new JButton("Escoger Archivo");
		button.setBounds(20, 76, 150, 30);
		add(button);
		
		JButton btnDescargarArchivo = new JButton("Descargar Archivo");
		btnDescargarArchivo.setBounds(20, 127, 150, 30);
		add(btnDescargarArchivo);
		
		Cfolders = new Choice();
		Cfolders.add("../");
		carpetas = cFTP.getUserFolders(FolSel);
		for( FTPFile f : carpetas ) {
			Cfolders.add(f.getName());
		}
		Cfolders.setBounds(210, 127, 130, 30);
		add(Cfolders);
		
		C_files = new Choice();
		C_files.add("../");
		ficheros = cFTP.getUserFiles(path);
		for(FTPFile f : ficheros) {
			if(!f.isDirectory())
			C_files.add(f.getName());
		}
		C_files.setBounds(360, 127, 130, 20);
		add(C_files);
		
		JLabel lblCarpetas = new JLabel("Carpetas");
		lblCarpetas.setHorizontalAlignment(SwingConstants.CENTER);
		lblCarpetas.setBounds(210, 76, 130, 30);
		add(lblCarpetas);
		
		JLabel lblFicheros = new JLabel("Ficheros");
		lblFicheros.setHorizontalAlignment(SwingConstants.CENTER);
		lblFicheros.setBounds(360, 76, 130, 30);
		add(lblFicheros);
		
		JButton button_addFolder = new JButton("+");
		button_addFolder.setBounds(220, 153, 41, 23);
		add(button_addFolder);
		
		JButton button_back = new JButton("<--");
		button_back.setBounds(271, 153, 55, 23);
		add(button_back);
		
		//Logica
		Cfolders.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if( Cfolders.getSelectedItem() != "../"+main_user.getEmail() ) {
					FolSel = Cfolders.getSelectedItem();
					C_files.removeAll();
					C_files.add("../"+FolSel );
					path +=Cfolders.getSelectedItem()+"\\";
					ficheros = cFTP.getUserFiles(path);
					for(FTPFile f : ficheros) {
						if(!f.isDirectory())
						C_files.add(f.getName());
					}
					carpetas = null;
					carpetas = cFTP.getUserFolders(path);
					Cfolders.removeAll();
					Cfolders.add("../"+FolSel);
					for(FTPFile f : carpetas) {
						Cfolders.add(f.getName());
					}
				}
			}
		});
		button_addFolder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame frameAddFolder = new JFrame("Add Folder");
				frameAddFolder.setSize(250 , 100);
				frameAddFolder.setResizable(false);
				frameAddFolder.setLocationRelativeTo(null);
				frameAddFolder.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frameAddFolder.getContentPane().setLayout(null);
				frameAddFolder.setVisible(true);
				JLabel nombre = new JLabel("Carpeta: ");
				nombre.setHorizontalAlignment(SwingConstants.CENTER);
				nombre.setBounds(0 , 0 , 100 , 30);
				final JTextField txtnombre = new JTextField(); //he puesto final pork si no da error en mvn compile
				txtnombre.setBounds(100 , 0 , 150 , 30);
				frameAddFolder.add(nombre);frameAddFolder.add(txtnombre);
				JButton enviar = new JButton("Crear");
				enviar.setBounds(75 , 35 , 100 , 30);
				frameAddFolder.add(enviar);
				
				enviar.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if(!txtnombre.getText().isEmpty()) {
							if(cFTP.createDir(path+txtnombre.getText())) {
								JOptionPane.showMessageDialog(null, "Carpeta creada con exito");
							}else {
								JOptionPane.showMessageDialog(null, "La carpeta no se ha creado con exito");							}
						}
					}
				});
			}
		});
		button_back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				C_files.removeAll();
				C_files.add("../" );
				path = "\\"+main_user.getEmail()+"\\";
				ficheros = cFTP.getUserFiles(path);
				for(FTPFile f : ficheros) {
					if(!f.isDirectory())
					C_files.add(f.getName());
				}
				carpetas = null;
				carpetas = cFTP.getUserFolders(path);
				Cfolders.removeAll();
				Cfolders.add("../");
				for(FTPFile f : carpetas) {
					Cfolders.add(f.getName());
				}
			}
		});
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(lastDir == "") {
					fileChooser = new JFileChooser();
				}else {
					JFileChooser fileChooser = new JFileChooser();
					fileChooser.setCurrentDirectory(fichero);
					lastDir = fichero.getAbsolutePath();
				}
				
				fileChooser.showOpenDialog(p);
				fichero = fileChooser.getSelectedFile();
				lastDir = fichero.getParent();
				if ( cFTP.uploadFile(fichero) ) {
					JOptionPane.showMessageDialog(null, "Archivo subido correctamente");
				}else {
					JOptionPane.showMessageDialog(null, "No se ha podiod subir el archivo");
				}
				
			}
		});
		btnDescargarArchivo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
