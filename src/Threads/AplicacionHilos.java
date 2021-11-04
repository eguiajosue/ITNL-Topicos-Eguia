package Threads;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class AplicacionHilos {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AplicacionHilos window = new AplicacionHilos();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	
	public AplicacionHilos() {
		initialize();
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 376, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(10, 51, 340, 45);
		frame.getContentPane().add(progressBar);
		
		JButton btnNewButton = new JButton("Ejercutar Ciclos");
		btnNewButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				Thread hilos = new Thread() {
					public void run() {
						progressBar.setMaximum(500000);
						
						for (int i = 0; i < 500000; i++) {
							System.out.println("Iteracion: " + i);
							progressBar.setValue(i);
						}
						progressBar.setValue(0);
					}
				};
				hilos.start();
			}
			
		});
		btnNewButton.setBounds(105, 128, 170, 23);
		frame.getContentPane().add(btnNewButton);
	}
	
	
}
