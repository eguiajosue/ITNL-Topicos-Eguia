package ValidarExpresion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.Stack;

public class validarExpresion {

	private JFrame frame;
	private JTextField txtExpresion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					validarExpresion window = new validarExpresion();
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
	public validarExpresion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 398, 210);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtExpresion = new JTextField();
		txtExpresion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtExpresion.setBounds(60, 71, 255, 36);
		frame.getContentPane().add(txtExpresion);
		txtExpresion.setColumns(10);
		
		JButton btnValidarExpresion = new JButton("Validad Expresi\u00F3n");
		btnValidarExpresion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Stack<Character> stackElementos = new Stack<Character>();
				String expresion = txtExpresion.getText();
				char arrayElementos[] = expresion.toCharArray();
				boolean valido = false;
				
				for (int i = 0; i < arrayElementos.length; i++) {
//					System.out.println(arrayElementos[i]);
					if (arrayElementos[i] == '(') {
						stackElementos.push(arrayElementos[i]);
					}
					if (arrayElementos[i] == ')') {
						if (stackElementos.empty()) {
							valido = false;
							break;
						} else {
							stackElementos.pop();
						}
					}
				}
				
				if (valido == true) {
					JOptionPane.showMessageDialog(null, "La expresion: " + expresion + " es correcta");
				} else {
					JOptionPane.showMessageDialog(null, "La expresion: " + expresion + " es incorrecta");
				}
				
			}
		});
		btnValidarExpresion.setBounds(60, 124, 255, 36);
		frame.getContentPane().add(btnValidarExpresion);
		
		JLabel lblNewLabel = new JLabel("Validaci\u00F3n de Parentesis");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 26));
		lblNewLabel.setBounds(10, 11, 362, 49);
		frame.getContentPane().add(lblNewLabel);
	}
}
