/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario;

import java.sql.Connection;
import java.sql.Date;
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
public class ProductoPerecederoData {
  private Connection connection = null;
    
    public ProductoPerecederoData(Conexion conexion) {
        try {
            connection = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error al abrir al obtener la conexion");
        }
    } 
    
   public void guardarProductoPerecedero (ProductoPerecedero producto){
     try {
       String sql = "INSERT INTO productoperecedero (codigo, marca, tipo, precioCosto, precioFinal, stock, fechaVencimiento) VALUES ( ?, ? , ? , ?, ?, ?, ? );"; 
        PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
         statement.setString(1, producto.getCodigo());
         statement.setString(2, producto.getMarca());
         statement.setString(3, producto.getTipo());
         statement.setDouble(4, producto.getPrecioCosto());
         statement.setDouble(5, producto.getPrecioFinal());
         statement.setInt(6, producto.getStock());
         statement.setDate(7, Date.valueOf(producto.getFechaVencimiento()));
          statement.executeUpdate();
          statement.close();
    
         
     }catch (SQLException ex) {
       System.out.println("Error al insertar un producto: " + ex.getMessage());   
     }  
   }
    public void editarProductoPerecedero (ProductoPerecedero producto){
     try {
       String sql = "UPDATE productoperecedero SET  precioCosto = ?, precioFinal = ?, stock = ? WHERE codigo = ?;"; 
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
     public ProductoPerecedero buscarProductoPerecedero (String codigo) {
       ProductoPerecedero producto = null;
         try {

            String sql = "SELECT * FROM productoperecedero WHERE codigo = ?;";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, codigo);

            //System.out.printnl(Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                producto = new ProductoPerecedero();
                producto.setCodigo(resultSet.getString("codigo"));
                producto.setMarca(resultSet.getString("marca"));
                producto.setTipo(resultSet.getString("tipo"));
                producto.setPrecioCosto(resultSet.getDouble("precioCosto"));
                producto.setPrecioFinal(resultSet.getDouble("precioFinal"));
                producto.setStock(resultSet.getInt("stock"));
                producto.setFechaVencimiento(resultSet.getDate("fechaVencimiento").toLocalDate());
            }
            statement.close();

        } catch (SQLException ex) {
            System.out.println("Error al mostrar producto por codigo: " + ex.getMessage());
        }

        return producto;
    }
   public List<ProductoPerecedero> obtenerProductosP() {
        List<ProductoPerecedero> productosP = new ArrayList<ProductoPerecedero>();

        try {
         String sql = "SELECT * FROM productoperecedero;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            ProductoPerecedero producto;
            
          while (resultSet.next()) {
                producto = new ProductoPerecedero();
                producto.setCodigo(resultSet.getString("codigo"));
                producto.setMarca(resultSet.getString("marca"));
                producto.setTipo(resultSet.getString("tipo"));
                producto.setPrecioCosto(resultSet.getDouble("precioCosto"));
                producto.setPrecioFinal(resultSet.getDouble("precioFinal"));
                producto.setStock(resultSet.getInt("stock"));
                producto.setFechaVencimiento(resultSet.getDate("fechaVencimiento").toLocalDate());
                
                productosP.add(producto);
            }
            statement.close();  
        } catch (SQLException ex) {
            System.out.println("Error al mostrar producto por codigo: " + ex.getMessage());
        }
        return productosP;
}
   public void borrarProductoP (String codigo){
    try {
            
            String sql = "DELETE FROM productoperecedero WHERE codigo =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, codigo);
           
            
            statement.executeUpdate();
            
            
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al borrar un producto: " + ex.getMessage());
        }
     
    }
   
   public List<ProductoPerecedero> inStockTipo(String tipo) {
        List<ProductoPerecedero> productosP = new ArrayList<ProductoPerecedero>();

        try {
         String sql = "SELECT * FROM productoperecedero WHERE tipo LIKE ? AND stock > 0;";
            PreparedStatement statement = connection.prepareStatement(sql);
             statement.setString(1, tipo);
            ResultSet resultSet = statement.executeQuery();
            ProductoPerecedero producto;
            
            
          while (resultSet.next()) {
                producto = new ProductoPerecedero();
                producto.setCodigo(resultSet.getString("codigo"));
                producto.setMarca(resultSet.getString("marca"));
                producto.setTipo(resultSet.getString("tipo"));
                producto.setPrecioCosto(resultSet.getDouble("precioCosto"));
                producto.setPrecioFinal(resultSet.getDouble("precioFinal"));
                producto.setStock(resultSet.getInt("stock"));
                producto.setFechaVencimiento(resultSet.getDate("fechaVencimiento").toLocalDate());

                productosP.add(producto);
            }
            statement.close();  
        } catch (SQLException ex) {
            System.out.println("Error al mostrar productos: " + ex.getMessage());
        }
        return productosP;
}
  public List<ProductoPerecedero> inStockMarca(String marca) {
        List<ProductoPerecedero> productosP = new ArrayList<ProductoPerecedero>();

        try {
         String sql = "SELECT * FROM productoperecedero WHERE marca LIKE ? AND stock > 0;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, marca);
            ResultSet resultSet = statement.executeQuery();
            ProductoPerecedero producto;
             
            
          while (resultSet.next()) {
                producto = new ProductoPerecedero();
                producto.setCodigo(resultSet.getString("codigo"));
                producto.setMarca(resultSet.getString("marca"));
                producto.setTipo(resultSet.getString("tipo"));
                producto.setPrecioCosto(resultSet.getDouble("precioCosto"));
                producto.setPrecioFinal(resultSet.getDouble("precioFinal"));
                producto.setStock(resultSet.getInt("stock"));
                producto.setFechaVencimiento(resultSet.getDate("fechaVencimiento").toLocalDate());

                productosP.add(producto);
            }
            statement.close();  
        } catch (SQLException ex) {
            System.out.println("Error al mostrar productos: " + ex.getMessage());
        }
        return productosP;
}  
   
   
   public boolean isCodigoExistenteP(String codigo) {
       boolean data = false;
        try {

            String sql = "SELECT * FROM productoperecedero WHERE codigo = ?;";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, codigo);
            ResultSet resultSet = statement.executeQuery();

            data = resultSet.first();
            statement.close();

        } catch (SQLException ex) {
            System.out.println("Error al mostrar productoP por ID: " + ex.getMessage());
        }
        return data;
    }
   
   }       

