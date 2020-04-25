package es.deusto.spq.paneles;

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
import java.util.ArrayList;
import java.util.stream.StreamSupport;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.commons.net.ftp.FTPFile;

import es.deusto.spq.Users;
import es.deusto.spq.connection.ConnectFTP;

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
	private Choice Cfolders , C_files; private ArrayList<FTPFile> carp , fich;
	private String path;
	public Panel_FTP(Users us) {
		this.main_user = us;
		this.setBounds(0 , 0 , 574 , 470);
		this.setBackground(Color.white);
		this.setLayout(null);
		this.setVisible(false);
		p = this;
		cFTP = new ConnectFTP(main_user);
		path = "\\"+main_user.getEmail()+"\\";
		///Componentes	
		
		
		JButton button = new JButton("Subir Archivo");
		button.setBounds(20, 76, 150, 30);
		add(button);
		
		JButton btnDescargarArchivo = new JButton("Descargar Archivo");
		btnDescargarArchivo.setBounds(20, 127, 150, 30);
		add(btnDescargarArchivo);
		
		Cfolders = new Choice();
		Cfolders.add("../");
		Cfolders.setBounds(210, 127, 130, 30);
		carp = cFTP.getUserFolders(path);
		for(int i = 0; i<carp.size() ; i++) {
			if( carp.get(i) instanceof FTPFile ) {
				Cfolders.add(carp.get(i).getName());
			}
		}
		add(Cfolders);
		
		C_files = new Choice();
		C_files.add("../");
		C_files.setBounds(360, 127, 130, 20);
		fich = cFTP.getUserFiles(path);
		for( int i = 0 ; i < fich.size() ; i++ ) {
			if( fich.get(i) instanceof FTPFile ) {
				if( fich.get(i).isFile() ) {
				C_files.add(fich.get(i).getName());
				}
			}
		}
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
		
		JLabel lblPath = new JLabel(path);
		lblPath.setBounds(200, 390, 250, 30);
		lblPath.setBorder(BorderFactory.createLineBorder(Color.black));
		add(lblPath);
		
		JButton btnR = new JButton("R");  //Refresh
		btnR.setBounds(401, 153, 49, 23);
		add(btnR);
		
		//Logica
		button_back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				path = "\\"+main_user.getEmail()+"\\";
				btnR.doClick();
			}
		});
		Cfolders.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				//Se actualiza el path con la carpeta seleccionada
				if(Cfolders.getSelectedItem() == "../") {
					path = "\\"+main_user.getEmail()+"\\";
				}else {
					path = "\\"+main_user.getEmail()+"\\" + Cfolders.getSelectedItem();
				}
				lblPath.setText(path);
				//Se actualiza el choice que muestra los ficheros
				C_files.removeAll();
				C_files.add("../");
				fich.clear();
				fich = cFTP.getUserFiles(path);
				for( int i = 0 ; i < fich.size() ; i++ ) {
					if( fich.get(i) instanceof FTPFile ) {
						if( fich.get(i).isFile() ) {
						C_files.add(fich.get(i).getName());
						}
					}
				}
				
			}
		});
		C_files.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				//Se actualiza el path segun el archivo que coges
				if( C_files.getSelectedItem() != "../" ) {
					path = "\\"+main_user.getEmail()+"\\"+Cfolders.getSelectedItem()+"\\"+C_files.getSelectedItem();
					System.out.println(path);
					lblPath.setText(path);
				}
			}
		});
		btnR.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				C_files.removeAll();
				C_files.add("../");
				fich.clear();
				fich = cFTP.getUserFiles(path);
				for( int i = 0 ; i < fich.size() ; i++ ) {
					if( fich.get(i) instanceof FTPFile ) {
						if( fich.get(i).isFile() ) {
						C_files.add(fich.get(i).getName());
						}
					}
				}
				carp.clear();
				Cfolders.removeAll();
				carp = cFTP.getUserFolders(path);
				Cfolders.add("../");
				for(int i = 0; i<carp.size() ; i++) {
					if( carp.get(i) instanceof FTPFile ) {
						Cfolders.add(carp.get(i).getName());
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
				txtnombre.setBounds(100 , 0 , 130 , 30);
				frameAddFolder.getContentPane().add(nombre);frameAddFolder.getContentPane().add(txtnombre);
				JButton enviar = new JButton("Crear");
				enviar.setBounds(75 , 35 , 100 , 30);
				frameAddFolder.getContentPane().add(enviar);
				
				enviar.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if(!txtnombre.getText().isEmpty()) {
							if(cFTP.createDir( "\\"+main_user.getEmail()+"\\"+txtnombre.getText())) {
								JOptionPane.showMessageDialog(null, "Carpeta creada con exito");
								frameAddFolder.dispose();
							}else {
								JOptionPane.showMessageDialog(null, "La carpeta no se ha creado con exito");							
							}
						}
					}
				});
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
				if ( cFTP.uploadFile(fichero , path) ) {
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
				JFileChooser ch = new JFileChooser(path);
				ch.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				ch.showOpenDialog(p);
				File pathDes = ch.getSelectedFile();
				if(C_files.getSelectedItem() != "../") {
					if(cFTP.downloadFile(pathDes.getPath())) {
						JOptionPane.showMessageDialog(null, "Archivo subido correctamente");
					}else {
						System.out.println("No se ha podido subir el archivo");
					}
				}
			}
		});
	}
}
