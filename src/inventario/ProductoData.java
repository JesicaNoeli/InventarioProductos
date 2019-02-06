/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario;


import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Popa
 */
public class ProductoData {
  private Connection connection = null;
    
    public ProductoData(Conexion conexion) {
        try {
            connection = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error al abrir al obtener la conexion");
        }
    } 
    
   public void guardarProducto (Producto producto){
     try {
       String sql = "INSERT INTO producto (codigo, marca, tipo, precioCosto, precioFinal, stock) VALUES ( ?, ? , ? , ?, ?, ? );"; 
        PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
         statement.setString(1, producto.getCodigo());
         statement.setString(2, producto.getMarca());
         statement.setString(3, producto.getTipo());
         statement.setDouble(4, producto.getPrecioCosto());
         statement.setDouble(5, producto.getPrecioFinal());
         statement.setInt(6, producto.getStock());
         
          statement.executeUpdate();
          statement.close();
    
         
     }catch (SQLException ex) {
       System.out.println("Error al insertar un producto: " + ex.getMessage());   
     }  
   }
  public void editarProducto (Producto producto){
     try {
       String sql = "UPDATE producto SET  precioCosto = ?, precioFinal = ?, stock = ? WHERE codigo = ?;"; 
        PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
         statement.setDouble(1, producto.getPrecioCosto());
         statement.setDouble(2, producto.getPrecioFinal());
         statement.setInt(3, producto.getStock());
         statement.setString(4,producto.getCodigo());
         
          statement.executeUpdate();
          statement.close();
    
         
     }catch (SQLException ex) {
       System.out.println("Error al editar un producto: " + ex.getMessage());   
     }  
   } 
   public Producto buscarProducto(String codigo) {
       Producto producto = null;
         try {

            String sql = "SELECT * FROM producto WHERE codigo = ?;";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, codigo);

            //System.out.printnl(Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                producto = new Producto();
                producto.setCodigo(resultSet.getString("codigo"));
                producto.setMarca(resultSet.getString("marca"));
                producto.setTipo(resultSet.getString("tipo"));
                producto.setPrecioCosto(resultSet.getDouble("precioCosto"));
                producto.setPrecioFinal(resultSet.getDouble("precioFinal"));
                producto.setStock(resultSet.getInt("stock"));

            }
            statement.close();

        } catch (SQLException ex) {
            System.out.println("Error al mostrar producto por codigo: " + ex.getMessage());
        }

        return producto;
    }
   public List<Producto> obtenerProductos() {
        List<Producto> productos = new ArrayList<Producto>();

        try {
         String sql = "SELECT * FROM producto;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Producto producto;
            
          while (resultSet.next()) {
                producto = new Producto();
                producto.setCodigo(resultSet.getString("codigo"));
                producto.setMarca(resultSet.getString("marca"));
                producto.setTipo(resultSet.getString("tipo"));
                producto.setPrecioCosto(resultSet.getDouble("precioCosto"));
                producto.setPrecioFinal(resultSet.getDouble("precioFinal"));
                producto.setStock(resultSet.getInt("stock"));

                productos.add(producto);
            }
            statement.close();  
        } catch (SQLException ex) {
            System.out.println("Error al mostrar productos: " + ex.getMessage());
        }
        return productos;
}
    public List<Producto> inStock(String tipo) {
        List<Producto> productos = new ArrayList<Producto>();

        try {
         String sql = "SELECT * FROM producto WHERE tipo LIKE ? AND stock > 0;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Producto producto;
            
          while (resultSet.next()) {
                producto = new Producto();
                producto.setCodigo(resultSet.getString("codigo"));
                producto.setMarca(resultSet.getString("marca"));
                producto.setTipo(resultSet.getString("tipo"));
                producto.setPrecioCosto(resultSet.getDouble("precioCosto"));
                producto.setPrecioFinal(resultSet.getDouble("precioFinal"));
                producto.setStock(resultSet.getInt("stock"));

                productos.add(producto);
            }
            statement.close();  
        } catch (SQLException ex) {
            System.out.println("Error al mostrar productos: " + ex.getMessage());
        }
        return productos;
}
   
    public void borrarProducto(String codigo){
    try {
            
            String sql = "DELETE FROM producto WHERE codigo =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, codigo);
           
            
            statement.executeUpdate();
            
            
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al borrar un producto: " + ex.getMessage());
        }
      
    }
    
    public boolean isCodigoExistente(String codigo) {
       boolean data = false;
        try {

            String sql = "SELECT * FROM producto WHERE codigo = ?;";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, codigo);
            ResultSet resultSet = statement.executeQuery();

            data = resultSet.first();
            statement.close();

        } catch (SQLException ex) {
            System.out.println("Error al mostrar producto por ID: " + ex.getMessage());
        }
        return data;
    }
    
}