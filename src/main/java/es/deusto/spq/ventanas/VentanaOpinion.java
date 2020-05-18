package es.deusto.spq.ventanas;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import es.deusto.spq.Opinion;
import es.deusto.spq.Users;
import es.deusto.spq.connection.Connect;
import javax.swing.JProgressBar;

/**
 * Ventana que da opcion a poner una valoracion del 1 al 5 y escribir una opinion, 
 * ademas luego da opcion a mandarlo.
 */

public class VentanaOpinion extends JFrame {

	private JRadioButton estrella1, estrella2, estrella3, estrella4, estrella5;
	private JButton botonSiguiente, botonAtras;
	private ButtonGroup radioButtonsEstrellas;
	private JTextArea texto;
	private JLabel comentario, valoracion, error;
	private JScrollPane scroll;
	private Users main_User;
	private int charCount = 0;
	private JProgressBar progressBar;
	private JLabel lblChars;
	private Thread update;

	/**
	 * Esta clase abre una ventana para que el usuario pueda dejar una reseña de la aplicación
	 * @param us
	 */
	public VentanaOpinion(Users us) {
		super("Opinion");
		this.main_User = us;
		this.setSize(720, 480);
		getContentPane().setLayout(null);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel ventanaOpinion = new JPanel();
		ventanaOpinion.setLayout(null);
		getContentPane().add(ventanaOpinion);
		ventanaOpinion.setVisible(true);

		estrella1 = new JRadioButton("1⭐");
		estrella1.setActionCommand("1");
		estrella1.setBounds(100, 50, 90, 50);
		estrella2 = new JRadioButton("2 ⭐");
		estrella2.setActionCommand("2");
		estrella2.setBounds(227, 50, 90, 50);
		estrella3 = new JRadioButton("3⭐ ");
		estrella3.setActionCommand("3");
		estrella3.setBounds(335, 50, 90, 50);
		estrella4 = new JRadioButton("4 ⭐");
		estrella4.setActionCommand("4");
		estrella4.setBounds(452, 50, 90, 50);
		estrella5 = new JRadioButton("5⭐ "/* , true */);
		estrella5.setActionCommand("5");
		estrella5.setBounds(570, 50, 90, 50);

		radioButtonsEstrellas = new ButtonGroup();
		radioButtonsEstrellas.add(estrella1);
		radioButtonsEstrellas.add(estrella2);
		radioButtonsEstrellas.add(estrella3);
		radioButtonsEstrellas.add(estrella4);
		radioButtonsEstrellas.add(estrella5);

		botonAtras = new JButton();
		botonAtras.setText("Atrás");
		botonAtras.setBounds(10, 340, 200, 30);

		botonSiguiente = new JButton();
		botonSiguiente.setText("Enviar Opinion");
		botonSiguiente.setBounds(500, 340, 200, 30);

		valoracion = new JLabel();
		valoracion.setText("Valoración:");
		valoracion.setBounds(10, 10, 100, 20);

		comentario = new JLabel();
		comentario.setText("Comentario:");
		comentario.setBounds(10, 130, 100, 20);

		texto = new JTextArea();
		texto.setFocusable(true);
		texto.setLineWrap(true);
		texto.setWrapStyleWord(true);
		texto.setMargin(new Insets(10, 10, 10, 10));
		texto.setCaretPosition(0);
		scroll = new JScrollPane(texto);
		scroll.setBounds(10, 150, 690, 150);
		getContentPane().add(scroll);

		error = new JLabel();
		error.setText("Falta valoracion o comentario.");
		error.setForeground(Color.red);
		error.setVisible(false);
		error.setBounds(500, 320, 200, 20);

		getContentPane().add(estrella1);
		getContentPane().add(estrella2);
		getContentPane().add(estrella3);
		getContentPane().add(estrella4);
		getContentPane().add(estrella5);
		getContentPane().add(botonSiguiente);
		getContentPane().add(botonAtras);
		getContentPane().add(comentario);
		getContentPane().add(valoracion);
		getContentPane().add(scroll);
		getContentPane().add(error);
		
		progressBar = new JProgressBar();
		progressBar.setBounds(20, 311, 66, 14);
		getContentPane().add(progressBar);
		progressBar.setMaximum(500);progressBar.setMinimum(0);
		progressBar.setValue(0);
		
		lblChars = new JLabel("500 chars");
		lblChars.setBounds(98, 311, 66, 14);
		getContentPane().add(lblChars);

		update = new Thread() {
			@Override
			public void run() {
				while(texto.isEnabled()) {
					progressBar.setValue(texto.getText().length());
					if(texto.getText().length() > 500) {
						lblChars.setForeground(Color.red);
					}else {
						lblChars.setForeground(Color.black);
					}
				}
			}
		};
		update.start();
		botonSiguiente.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (!radioButtonsEstrellas.isSelected(null) && !texto.getText().equals("")) {
					//System.out.println("TODO OK" + radioButtonsEstrellas.getSelection().getActionCommand());
					error.setVisible(false);
					// CODIGO DE CONTINUAR, AQUI
					if(texto.getText().length()<=500) {
						Opinion op = new Opinion();
						op.setComentario(texto.getText());
						op.setValoracion(Integer.parseInt(radioButtonsEstrellas.getSelection().getActionCommand()));
						//System.out.println(main_User.getEmail());
						op.setEmail(main_User.getEmail());
						Connect cn = new Connect();
						if(cn.SaveOpinion(op)) {
							JOptionPane.showMessageDialog(null, "¡Opinión enviada con éxito!");
						}else {
							JOptionPane.showMessageDialog(null, "La opinión no se puedo enviar correctamente ");
						}
					}else {
						JOptionPane.showMessageDialog(null, "El mensaje debe de ser de 500 caracteres como máximo");
					}
					
				} else if (radioButtonsEstrellas.isSelected(null) || texto.getText().equals("")) {
					
					error.setVisible(true);
					// NO TIENE VALORACION U OPINION, NO DEBERIAMOS SEGUIR
				}

			}
		});
		
		botonAtras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				try {
					update.stop();
				} catch (ThreadDeath e2) {
					e2.printStackTrace();
				}
			}
		});
		
	}
}
