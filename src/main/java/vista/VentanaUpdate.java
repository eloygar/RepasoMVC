package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;
import modelo.vo.ProductsVo;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaUpdate extends JFrame {

	private Coordinador miCoordinador; // objeto miCoordinador que permite la relacion entre esta clase y la clase
	// coordinador
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaUpdate frame = new VentanaUpdate();
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
	public VentanaUpdate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(46, 30, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(46, 83, 96, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("pepe butanero");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		btnNewButton.setBounds(247, 65, 85, 21);
		contentPane.add(btnNewButton);
	}
	
	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}
	public void update() {
		ProductsVo _producto =miCoordinador.buscarPorId(Integer.parseInt(textField.getText()));
		_producto.setProductName(textField_1.getText());
		miCoordinador.update(_producto);
		
	}

}
