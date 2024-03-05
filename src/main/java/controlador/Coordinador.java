package controlador;

import java.sql.SQLException;
import java.util.List;

import javax.management.InstanceNotFoundException;
import javax.swing.JOptionPane;

import modelo.Logica;
import modelo.dao.PersonaDao;
import modelo.vo.PersonaVo;
import modelo.vo.ProductsVo;
import vista.VentanaEliminar;
import vista.VentanaInsertar;
import vista.VentanaListar;
import vista.VentanaPrincipal;
import vista.VentanaUpdate;

public class Coordinador {

	private Logica miLogica;
//	private VentanaPrincipal miVentanaPrincipal;
//	private VentanaRegistro miVentanaRegistro;
//	private VentanaBuscar miVentanaBuscar;
//	
	private VentanaInsertar miVentanaInsertar;

	private VentanaListar miVentanaListar;

	private VentanaEliminar miVentanaEliminar;
	
	private VentanaUpdate miVentanaUpdate;

	// public VentanaPrincipal getMiVentanaPrincipal() {
//		return miVentanaPrincipal;
//	}
//	public void setMiVentanaPrincipal(VentanaPrincipal miVentanaPrincipal) {
//		this.miVentanaPrincipal = miVentanaPrincipal;
//	}
//	public VentanaRegistro getMiVentanaRegistro() {
//		return miVentanaRegistro;
//	}
//	public void setMiVentanaRegistro(VentanaRegistro miVentanaRegistro) {
//		this.miVentanaRegistro = miVentanaRegistro;
//	}
//	public VentanaBuscar getMiVentanaBuscar() {
//		return miVentanaBuscar;
//	}
//	public void setMiVentanaBuscar(VentanaBuscar miVentanaBuscar) {
//		this.miVentanaBuscar = miVentanaBuscar;
//	}
	public Logica getMiLogica() {
		return miLogica;
	}

	public void setMiLogica(Logica miLogica) {
		this.miLogica = miLogica;
	}

	public VentanaInsertar getMiVentanaInsertar() {
		return miVentanaInsertar;
	}

	public void setMiVentanaInsertar(VentanaInsertar miVentanaInsertar) {
		this.miVentanaInsertar = miVentanaInsertar;
	}

	public VentanaListar getMiVentanaListar() {
		return miVentanaListar;
	}

	public void setMiVentanaListar(VentanaListar miVentanaListar) {
		this.miVentanaListar = miVentanaListar;
	}

	public VentanaEliminar getMiVentanaEliminar() {
		return miVentanaEliminar;
	}

	public void setMiVentanaEliminar(VentanaEliminar miVentanaEliminar) {
		this.miVentanaEliminar = miVentanaEliminar;
	}

	public VentanaUpdate getMiVentanaUpdate() {
		return miVentanaUpdate;
	}

	public void setMiVentanaUpdate(VentanaUpdate miVentanaUpdate) {
		this.miVentanaUpdate = miVentanaUpdate;
	}

	

//////////////////////////////////////////////////////////

	public void mostrarVentanaInsertar() {
		miVentanaInsertar.setVisible(true);
	}

	public void mostrarVentanaListar() {
		miVentanaListar.setVisible(true);
	}
	public void mostrarVentanaEliminar() {
		miVentanaEliminar.setVisible(true);
	}
	public void mostrarVentanaUpdate() {
		miVentanaUpdate.setVisible(true);
	}

//	public void mostrarVentanaRegistro() {
//		miVentanaRegistro.setVisible(true);
//	}
//	public void mostrarVentanaConsulta() {
//		miVentanaBuscar.setVisible(true);
//	}

//	public void registrarPersona(PersonaVo miPersona) {
//		miLogica.validarRegistro(miPersona);
//	}
//	
//	public PersonaVo buscarPersona(String codigoPersona) {
//		return miLogica.validarConsulta(codigoPersona);
//	}
//	
//	public void modificarPersona(PersonaVo miPersona) {
//		miLogica.validarModificacion(miPersona);
//	}
//	public void eliminarPersona(String codigo) {
//		miLogica.validarEliminacion(codigo);
//	}
	public void insertarProducto(ProductsVo miProducto) {
		try {
			miLogica.validarInsertarProducto(miProducto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mostrarVentanaError("fallo insertar");
		}
	}

	public ProductsVo buscarPorId(Integer productid) {
		ProductsVo _producto = null;
		try {
			_producto = miLogica.validarBuscarPorId(productid);
		} catch (InstanceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mostrarVentanaError("fallo no se encuentra");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mostrarVentanaError("fallo sql");
		}
		return _producto;
	}

	public List<ProductsVo> buscarTodos() {
		List<ProductsVo> _lista = null;
		try {
			_lista = miLogica.validarBuscarTodos();
		} catch (InstanceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mostrarVentanaError("fallo no se encuentra");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mostrarVentanaError("fallo sql");
		}
		return _lista;
	}
	public void eliminar(Integer productId) {
		try {
			miLogica.validarEliminarProducto(productId);
		} catch (InstanceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mostrarVentanaError("no se encuentra ese producto");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mostrarVentanaError("fallo sql");
		}
	}
	public void update(ProductsVo _producto) {
		try {
			miLogica.validarUpdateProducto(_producto);
		} catch (InstanceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mostrarVentanaError("no se encuentra ese producto");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mostrarVentanaError("fallo sql");
		}
	}

	public void mostrarVentanaError(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
	}
}
