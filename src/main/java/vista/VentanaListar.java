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
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class VentanaListar extends JFrame {

	private Coordinador miCoordinador; // objeto miCoordinador que permite la relacion entre esta clase y la clase
										// coordinador
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JButton btnNewButtonListAll;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaListar frame = new VentanaListar();
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
	public VentanaListar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(43, 23, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("Listar por id");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarId();
			}
		});
		btnNewButton.setBounds(172, 22, 127, 21);
		contentPane.add(btnNewButton);

		btnNewButtonListAll = new JButton("Listar todos");
		btnNewButtonListAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarTodos();

			}
		});
		btnNewButtonListAll.setBounds(309, 22, 85, 21);
		contentPane.add(btnNewButtonListAll);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 53, 416, 200);
		contentPane.add(scrollPane);
				
						textArea = new JTextArea();
						scrollPane.setViewportView(textArea);
						textArea.setLineWrap(true);
	}

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}

	public void listarId() {
		Integer id = Integer.parseInt(textField.getText());

		ProductsVo _producto = miCoordinador.buscarPorId(id);
		if (_producto != null)
			textArea.setText(_producto.toString());

	}

	public void listarTodos() {
		List<ProductsVo> lista;
		lista= miCoordinador.buscarTodos();
		String texto="";
		if(lista!=null){
			for (ProductsVo productsVo : lista) {
				texto+=productsVo.toString();
			}
			textArea.setText(texto);
		}
	}
}
