package Ejercicio1;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class QuizApp {
	
	
	String[] preguntas = 	{
			"Pregunta #1: Científicamente ¿cuál película es considerada de las mas aterradoras?",
			"Pregunta #2: ¿En que año se estreó la primer pelicula de STAR WARS?",
			"Pregunta #3: ¿De qué planeta proviene la raza de los 'Transformers'?",
			"Pregunta #4: ¿Qué actor interpretó a Mark Zuckerberg la pelicula de 'The Social Network'?",
			"Pregunta #5: ¿A que casa de Hogwards pertenece el personaje de Harry Potter?"
		};

	String[][] respuestas = {
				{"Insidious", "Sinister", "The Exorcist", "El Conjuro", "Chucky"}, 									// Sinister
				{"1969", "1977", "1980", "1976", "2000"}, 															// 1977
				{"Cybertron", "Unicron", "Primus", "Gigantion", "Tierra"}, 											// Cybertron
				{"Mark Zuckemberg", "Andrew Garfield", "Justin Timberlake", "Jesse Eisenberg", "Max Minghella"}, 	// Jesse Eisenberg
				{"Slytherin", "Ravenclaw", "Hufflepuff", "Hogwards", "Gryffindor"}									// Gryffindor
			};	
	
	char[] respuestasCorrectas = 	{'B', 'B', 'A', 'D', 'E'};
	
	char pregunta;
	char respuesta;
	int index;
	int preguntasCorrectas = 0;
	int totalPreguntas = preguntas.length;
	double resultadoFinal;
	
	
	public void siguientePregunta() {
		if (index >= totalPreguntas) {
			JOptionPane.showMessageDialog(null, "No hay mas preguntas");
		}
		else {
			lblPregunta.setText(preguntas[index]);
			
			radRespuestaA.setText(respuestas[index][0]);
			radRespuestaB.setText(respuestas[index][1]);
			radRespuestaC.setText(respuestas[index][2]);
			radRespuestaD.setText(respuestas[index][3]);
			radRespuestaE.setText(respuestas[index][4]);
		}
	}

	
	public void mostrarRespuestas() {
		/* EN CASO DE QUE SE REQUIRA MOSTRAR LA RESPUESTA CORRECTA AL DAR CLICK EN EL BOTON DE SIGUIENTE
		 * 
		if (respuestasCorrectas[index] != 'A') 
			radRespuestaA.setForeground(new Color(255, 0, 0));
		
		if (respuestasCorrectas[index] != 'B') 
			radRespuestaB.setForeground(new Color(255, 0, 0));
		
		if (respuestasCorrectas[index] != 'C') 
			radRespuestaC.setForeground(new Color(255, 0, 0));
		
		if (respuestasCorrectas[index] != 'D') 
			radRespuestaD.setForeground(new Color(255, 0, 0));

		if (respuestasCorrectas[index] != 'E') 
			radRespuestaE.setForeground(new Color(255, 0, 0)); 
		*/
		
		Timer espera = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				/* REESTABLECER COLORES
				 * 
				radRespuestaA.setForeground(new Color(0, 0, 0));
				radRespuestaB.setForeground(new Color(0, 0, 0));
				radRespuestaC.setForeground(new Color(0, 0, 0));
				radRespuestaD.setForeground(new Color(0, 0, 0));
				radRespuestaE.setForeground(new Color(0, 0, 0));
				*/
				
				respuesta = ' ';
			
				index++;
				siguientePregunta();
			}
		});
		espera.setRepeats(false);
		espera.start();
	}
	
	
	public void mostrarResultados() {
		radRespuestaA.setEnabled(false);
		radRespuestaB.setEnabled(false);
		radRespuestaC.setEnabled(false);
		radRespuestaD.setEnabled(false);
		radRespuestaE.setEnabled(false);
		btnAnterior.setEnabled(false);
		btnSiguiente.setEnabled(false);
		
		resultadoFinal = (preguntasCorrectas/(double)totalPreguntas * 100);
		String totalAciertos = preguntasCorrectas + "/" + totalPreguntas;
		
		lblCantidadCalificacion.setText(String.valueOf(resultadoFinal));
		lblCantidadAciertos.setText(totalAciertos);
		
		if (resultadoFinal >= 70 ) {
			lblCantidadCalificacion.setForeground(new Color(34,139,34));
		} else if (resultadoFinal < 70 && resultadoFinal >= 50) {
			lblCantidadCalificacion.setForeground(new Color(204, 204, 0));
		} else {
			lblCantidadCalificacion.setForeground(new Color(255, 0, 0));
		}
		
		
		if (resultadoFinal >= 4 ) {
			lblCantidadAciertos.setForeground(new Color(34,139,34));
		} else if (resultadoFinal < 4 && resultadoFinal >= 2) {
			lblCantidadAciertos.setForeground(new Color(204, 204, 0));
		} else {
			lblCantidadAciertos.setForeground(new Color(255, 0, 0));
		}
		
		// JOptionPane.showMessageDialog(null, "CALIFICACIÓN FINAL: " + resultadoFinal + "\nACIERTOS: " + preguntasCorrectas + "/" + totalPreguntas);
		
	}
	
	private JFrame frmQuizApp;
	private JLabel lblPregunta;
	private JRadioButton radRespuestaA;
	private JRadioButton radRespuestaB;
	private JRadioButton radRespuestaC;
	private JRadioButton radRespuestaD;
	private JButton btnSiguiente;
	private JButton btnVerResultados;
	private JRadioButton radRespuestaE;
	private JButton btnAnterior;
	private JLabel lblCalificacion;
	private JLabel lblAciertos;
	private JLabel lblCantidadCalificacion;
	private JLabel lblCantidadAciertos;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuizApp window = new QuizApp();
					window.frmQuizApp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public QuizApp() {
		initialize();
	}

	private void initialize() {	
		frmQuizApp = new JFrame();
		frmQuizApp.setTitle("Quiz App\r\n");
		frmQuizApp.setResizable(false);
		frmQuizApp.setBounds(100, 100, 570, 351);
		frmQuizApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmQuizApp.getContentPane().setLayout(null);
		
		JLabel lblTitulo = new JLabel("Quiz App");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Rubik", Font.BOLD, 45));
		lblTitulo.setBounds(10, 11, 250, 55);
		frmQuizApp.getContentPane().add(lblTitulo);
		
		lblPregunta = new JLabel("Pregunta #");
		lblPregunta.setBounds(10, 77, 534, 14);
		frmQuizApp.getContentPane().add(lblPregunta);
		
		radRespuestaA = new JRadioButton("Respuesta A");
		radRespuestaA.setBounds(20, 98, 524, 23);
		frmQuizApp.getContentPane().add(radRespuestaA);
		
		radRespuestaB = new JRadioButton("Respuesta B");
		radRespuestaB.setBounds(20, 124, 524, 23);
		frmQuizApp.getContentPane().add(radRespuestaB);
		
		radRespuestaC = new JRadioButton("Respuesta C");
		radRespuestaC.setBounds(20, 150, 524, 23);
		frmQuizApp.getContentPane().add(radRespuestaC);
		
		radRespuestaD = new JRadioButton("Respuesta D");
		radRespuestaD.setBounds(20, 176, 524, 23);
		frmQuizApp.getContentPane().add(radRespuestaD);
		
		radRespuestaE = new JRadioButton("Respuesta E");
		radRespuestaE.setBounds(20, 202, 524, 23);
		frmQuizApp.getContentPane().add(radRespuestaE);
		
		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == btnSiguiente && radRespuestaA.isSelected()) {
					respuesta = 'A';
					if (respuesta == respuestasCorrectas[index]) {
						preguntasCorrectas++;
					}
				}
				
				if (e.getSource() == btnSiguiente && radRespuestaB.isSelected()) {
					respuesta = 'B';
					if (respuesta == respuestasCorrectas[index]) {
						preguntasCorrectas++;
					}
				}
				
				if (e.getSource() == btnSiguiente && radRespuestaC.isSelected()) {
					respuesta = 'C';
					if (respuesta == respuestasCorrectas[index]) {
						preguntasCorrectas++;
					}
				}
				
				if (e.getSource() == btnSiguiente && radRespuestaD.isSelected()) {
					respuesta = 'D';
					if (respuesta == respuestasCorrectas[index]) {
						preguntasCorrectas++;
					}
				}
				
				if (e.getSource() == btnSiguiente && radRespuestaE.isSelected()) {
					respuesta = 'E';
					if (respuesta == respuestasCorrectas[index]) {
						preguntasCorrectas++;
					}
				}
				mostrarRespuestas();
			}
		});
		btnSiguiente.setBounds(434, 232, 110, 31);
		frmQuizApp.getContentPane().add(btnSiguiente);
		
		btnAnterior = new JButton("Anterior");
		btnAnterior.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				--index;
				lblPregunta.setText(preguntas[index]);
				radRespuestaA.setText(respuestas[index][0]);
				radRespuestaB.setText(respuestas[index][1]);
				radRespuestaC.setText(respuestas[index][2]);
				radRespuestaD.setText(respuestas[index][3]);
				radRespuestaE.setText(respuestas[index][4]);
				
				respuesta = ' ';
			}
		});
		btnAnterior.setBounds(314, 232, 110, 31);
		frmQuizApp.getContentPane().add(btnAnterior);
		
		
		ButtonGroup respuestas = new ButtonGroup();
		respuestas.add(radRespuestaA);
		respuestas.add(radRespuestaB);
		respuestas.add(radRespuestaC);
		respuestas.add(radRespuestaD);
		respuestas.add(radRespuestaE);
		
		
		
		btnVerResultados = new JButton("Ver Resultados");
		btnVerResultados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarResultados();
			}
		});
		btnVerResultados.setBounds(10, 274, 534, 31);
		frmQuizApp.getContentPane().add(btnVerResultados);
		
		lblCalificacion = new JLabel("Calificaci\u00F3n: ");
		lblCalificacion.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCalificacion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCalificacion.setBounds(327, 11, 97, 14);
		frmQuizApp.getContentPane().add(lblCalificacion);
		
		lblAciertos = new JLabel("Aciertos: ");
		lblAciertos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAciertos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAciertos.setBounds(327, 36, 97, 14);
		frmQuizApp.getContentPane().add(lblAciertos);
		
		lblCantidadCalificacion = new JLabel("0");
		lblCantidadCalificacion.setHorizontalAlignment(SwingConstants.LEFT);
		lblCantidadCalificacion.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCantidadCalificacion.setBounds(434, 11, 97, 14);
		frmQuizApp.getContentPane().add(lblCantidadCalificacion);
		
		lblCantidadAciertos = new JLabel("0");
		lblCantidadAciertos.setHorizontalAlignment(SwingConstants.LEFT);
		lblCantidadAciertos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCantidadAciertos.setBounds(434, 36, 97, 14);
		frmQuizApp.getContentPane().add(lblCantidadAciertos);
		
		
		

		siguientePregunta();
	}
}
