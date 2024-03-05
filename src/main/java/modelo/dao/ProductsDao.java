package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import javax.management.InstanceNotFoundException;

//import modelo.conexion.Conexion;
import modelo.vo.ProductsVo;

public class ProductsDao {

	// funcion insertar
	public static void insertarProducts(Connection con, ProductsVo producto) throws SQLException {
		// Preparar la consulta SQL para insertar un nuevo producto
		String query = "INSERT INTO Products (ProductName, SupplierID, CategoryID, QuantityPerUnit, UnitPrice, "
				+ "UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		// Crear un objeto PreparedStatement
		PreparedStatement ps = con.prepareStatement(query);

		// Establecer los parámetros del PreparedStatement con los valores del producto
		ps.setString(1, producto.getProductName());
		ps.setInt(2, producto.getSupplierId());
		ps.setInt(3, producto.getCategoryId());
		ps.setString(4, producto.getQuantityPerUnit());
		ps.setDouble(5, producto.getUnitPrice());
		ps.setShort(6, producto.getUnitsInStock());
		ps.setShort(7, producto.getUnitsOnOrder());
		ps.setShort(8, producto.getReorderLevel());
		ps.setByte(9, producto.getDiscontinued());

		// Ejecutar la consulta
		ps.executeUpdate();

		// Cerrar el PreparedStatement
		ps.close();
	}

	// funcion buscar por id
	public static ProductsVo buscarPorId(Integer productId, Connection con)
			throws SQLException, InstanceNotFoundException {
		// Preparar la consulta SQL para buscar un producto por su ID
		String query = "SELECT * FROM Products WHERE ProductID = ?";

		// Crear un objeto PreparedStatement
		PreparedStatement pstmt = con.prepareStatement(query);

		// Establecer el parámetro del PreparedStatement con el productId proporcionado
		pstmt.setInt(1, productId);

		// Ejecutar la consulta
		ResultSet rs = pstmt.executeQuery();

		// Verificar si se encontró algún resultado
		if (rs.next()) {
			// Crear un objeto ProductsVo y establecer sus atributos con los valores
			// obtenidos de la consulta
			ProductsVo producto = new ProductsVo();
			producto.setProductId(rs.getInt("ProductID"));
			producto.setProductName(rs.getString("ProductName"));
			producto.setSupplierId(rs.getInt("SupplierID"));
			producto.setCategoryId(rs.getInt("CategoryID"));
			producto.setQuantityPerUnit(rs.getString("QuantityPerUnit"));
			producto.setUnitPrice(rs.getDouble("UnitPrice"));
			producto.setUnitsInStock(rs.getShort("UnitsInStock"));
			producto.setUnitsOnOrder(rs.getShort("UnitsOnOrder"));
			producto.setReorderLevel(rs.getShort("ReorderLevel"));
			producto.setDiscontinued(rs.getByte("Discontinued"));

			// Cerrar el ResultSet y el PreparedStatement
			rs.close();
			pstmt.close();

			// Devolver el producto encontrado
			return producto;
		} else {
			// Si no se encontró ningún producto con el ID dado, lanzar una excepción
			throw new InstanceNotFoundException("Producto con ID " + productId + " no encontrado.");
		}
	}

	public static List<ProductsVo> buscarTodos(Connection con) throws SQLException {
		List<ProductsVo> listaProductos = new ArrayList<>();

		// Preparar la consulta SQL para buscar todos los productos
		String query = "SELECT * FROM Products";

		// Crear un objeto PreparedStatement
		PreparedStatement ps = con.prepareStatement(query);

		// Ejecutar la consulta
		ResultSet rs = ps.executeQuery();

		// Recorrer los resultados y crear objetos ProductsVo para cada fila
		while (rs.next()) {
			ProductsVo producto = new ProductsVo();
			producto.setProductId(rs.getInt("ProductID"));
			producto.setProductName(rs.getString("ProductName"));
			producto.setSupplierId(rs.getInt("SupplierID"));
			producto.setCategoryId(rs.getInt("CategoryID"));
			producto.setQuantityPerUnit(rs.getString("QuantityPerUnit"));
			producto.setUnitPrice(rs.getDouble("UnitPrice"));
			producto.setUnitsInStock(rs.getShort("UnitsInStock"));
			producto.setUnitsOnOrder(rs.getShort("UnitsOnOrder"));
			producto.setReorderLevel(rs.getShort("ReorderLevel"));
			producto.setDiscontinued(rs.getByte("Discontinued"));

			// Agregar el producto a la lista
			listaProductos.add(producto);
		}

		// Cerrar el ResultSet y el PreparedStatement
		rs.close();
		ps.close();

		// Devolver la lista de productos
		return listaProductos;
	}

	public static void actualizar(ProductsVo productVo, Connection con) throws SQLException, InstanceNotFoundException {
		// Verificar si el producto existe antes de intentar actualizarlo
		if (buscarPorId(productVo.getProductId(), con) == null) {
			throw new InstanceNotFoundException("El producto con ID " + productVo.getProductId() + " no existe.");
		}

		// Preparar la consulta SQL para actualizar el producto
		String query = "UPDATE Products SET ProductName = ?, SupplierID = ?, CategoryID = ?, "
				+ "QuantityPerUnit = ?, UnitPrice = ?, UnitsInStock = ?, UnitsOnOrder = ?, "
				+ "ReorderLevel = ?, Discontinued = ? WHERE ProductID = ?";

		// Crear un objeto PreparedStatement
		PreparedStatement ps = con.prepareStatement(query);

		// Establecer los parámetros del PreparedStatement con los valores del producto
		ps.setString(1, productVo.getProductName());
		ps.setInt(2, productVo.getSupplierId());
		ps.setInt(3, productVo.getCategoryId());
		ps.setString(4, productVo.getQuantityPerUnit());
		ps.setDouble(5, productVo.getUnitPrice());
		ps.setShort(6, productVo.getUnitsInStock());
		ps.setShort(7, productVo.getUnitsOnOrder());
		ps.setShort(8, productVo.getReorderLevel());
		ps.setByte(9, productVo.getDiscontinued());
		ps.setInt(10, productVo.getProductId());

		// Ejecutar la consulta de actualización
		ps.executeUpdate();

		// Cerrar el PreparedStatement
		ps.close();
		
	}


	public static void eliminar(Integer productId, Connection con) throws SQLException, InstanceNotFoundException {
		// Verificar si el producto existe antes de intentar eliminarlo
		if (buscarPorId(productId, con) == null) {
			throw new InstanceNotFoundException("El producto con ID " + productId + " no existe.");
		}

		// Preparar la consulta SQL para eliminar el producto
		String query = "DELETE FROM Products WHERE ProductID = ?";

		// Crear un objeto PreparedStatement
		PreparedStatement pstmt = con.prepareStatement(query);

		// Establecer el parámetro del PreparedStatement con el productId proporcionado
		pstmt.setInt(1, productId);

		// Ejecutar la consulta de eliminación
		pstmt.executeUpdate();

		// Cerrar el PreparedStatement
		pstmt.close();
	}

}
