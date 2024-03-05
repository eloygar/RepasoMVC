package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;
import modelo.vo.ProductsVo;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class VentanaInsertar extends JFrame {

	private Coordinador miCoordinador; //objeto miCoordinador que permite la relacion entre esta clase y la clase coordinador
	
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldPrice;
	private JTextField textFieldStock;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInsertar frame = new VentanaInsertar();
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
	public VentanaInsertar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Insertar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertar();
			}
		});
		btnNewButton.setBounds(300, 29, 85, 21);
		contentPane.add(btnNewButton);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(55, 30, 96, 19);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setBounds(55, 77, 96, 19);
		contentPane.add(textFieldPrice);
		textFieldPrice.setColumns(10);
		
		textFieldStock = new JTextField();
		textFieldStock.setBounds(55, 135, 96, 19);
		contentPane.add(textFieldStock);
		textFieldStock.setColumns(10);
	}
	

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}
	public void insertar() {
		ProductsVo producto = new ProductsVo();
		
		producto.setProductName(textFieldName.getText());
		producto.setSupplierId(1);
		producto.setCategoryId(1);
		producto.setQuantityPerUnit("1");
		producto.setUnitPrice((double)Double.parseDouble(textFieldPrice.getText()));
		producto.setUnitsInStock((short)Integer.parseInt(textFieldStock.getText()));
		producto.setUnitsOnOrder((short) 1);
		producto.setReorderLevel((short) 12);
		producto.setDiscontinued((byte) 1);
		
		miCoordinador.insertarProducto(producto);
		System.out.println("hola");
	}
}
