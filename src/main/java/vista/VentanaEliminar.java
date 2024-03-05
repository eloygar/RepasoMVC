package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaEliminar extends JFrame {
	private Coordinador miCoordinador; // objeto miCoordinador que permite la relacion entre esta clase y la clase
	// coordinador
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEliminar frame = new VentanaEliminar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaEliminar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				eliminar();
			}

		});
		btnNewButton.setBounds(284, 60, 85, 21);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(67, 61, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
	}


	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}
	private void eliminar() {
		miCoordinador.eliminar(Integer.parseInt(textField.getText()));
		
	}
}
