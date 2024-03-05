package modelo;

import java.sql.SQLException;
import java.util.List;

import javax.management.InstanceNotFoundException;
import javax.swing.JOptionPane;

import modelo.conexion.Conexion;
import modelo.dao.PersonaDao;
import modelo.dao.ProductsDao;
import modelo.vo.PersonaVo;
import modelo.vo.ProductsVo;
import controlador.Coordinador;

public class Logica {

	private Coordinador miCoordinador;
	public static boolean consultaPersona = false;
	public static boolean modificaPersona = false;

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;

	}

	public void validarRegistro(PersonaVo miPersona) {
		PersonaDao miPersonaDao;
		if (miPersona.getIdPersona() > 99) {
			miPersonaDao = new PersonaDao();
			miPersonaDao.registrarPersona(miPersona);
		} else {
			JOptionPane.showMessageDialog(null, "El documento de la persona debe ser mas de 3 digitos", "Advertencia",
					JOptionPane.WARNING_MESSAGE);

		}

	}

	public PersonaVo validarConsulta(String codigoPersona) {
		PersonaDao miPersonaDao;

		try {
			int codigo = Integer.parseInt(codigoPersona);
			if (codigo > 99) {
				miPersonaDao = new PersonaDao();
				consultaPersona = true;
				return miPersonaDao.buscarPersona(codigo);
			} else {
				JOptionPane.showMessageDialog(null, "El documento de la persona debe ser mas de 3 digitos",
						"Advertencia", JOptionPane.WARNING_MESSAGE);
				consultaPersona = false;
			}

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Debe ingresar un dato numerico", "Error", JOptionPane.ERROR_MESSAGE);
			consultaPersona = false;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Se ha presentado un Error", "Error", JOptionPane.ERROR_MESSAGE);
			consultaPersona = false;
		}

		return null;
	}

	public void validarModificacion(PersonaVo miPersona) {
		PersonaDao miPersonaDao;
		if (miPersona.getNombrePersona().length() > 5) {
			miPersonaDao = new PersonaDao();
			miPersonaDao.modificarPersona(miPersona);
			modificaPersona = true;
		} else {
			JOptionPane.showMessageDialog(null, "El nombre de la persona debe ser mayor a 5 digitos", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
			modificaPersona = false;
		}
	}

	public void validarEliminacion(String codigo) {
		PersonaDao miPersonaDao = new PersonaDao();
		miPersonaDao.eliminarPersona(codigo);
	}

	public void validarInsertarProducto(ProductsVo miProducto) throws SQLException {
		
		Conexion con = new Conexion();
		
		ProductsDao.insertarProducts(con.getConnection(), miProducto);
		
		con.desconectar();
	}
	public ProductsVo validarBuscarPorId(Integer productId)throws SQLException, InstanceNotFoundException{

		Conexion con = new Conexion();
		
		ProductsVo resultado = ProductsDao.buscarPorId(productId, con.getConnection());
		con.desconectar();
		return resultado;
		
	}
	public List<ProductsVo> validarBuscarTodos()throws SQLException, InstanceNotFoundException{

		Conexion con = new Conexion();
		
		List<ProductsVo> resultado = ProductsDao.buscarTodos(con.getConnection());
		con.desconectar();
		return resultado;
		
	}
	public void validarEliminarProducto(Integer productId)throws SQLException, InstanceNotFoundException{
		Conexion con = new Conexion();
		
		ProductsDao.eliminar(productId, con.getConnection());
		
		con.desconectar();
	}
	public void validarUpdateProducto(ProductsVo miProducto)throws SQLException, InstanceNotFoundException{
		Conexion con = new Conexion();
		ProductsDao.actualizar(miProducto, con.getConnection());
		con.desconectar();
	}

}
