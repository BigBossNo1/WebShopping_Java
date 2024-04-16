package Model;

import Entity.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOProduct extends DbContext {

    public Vector<Product> getListProduct(String sql) {
        Vector<Product> vector = new Vector<>();
        try {
            Statement statement = _connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int product_id = rs.getInt(1);
                String product_name = rs.getString(2);
                int categoryID = rs.getInt(3);
                double price = rs.getDouble(4);
                int quantity = rs.getInt(5);
                boolean status = rs.getBoolean(6);
                Product newProduct = new Product(product_id, product_name, categoryID, price, quantity, status);
                vector.add(newProduct);
            }
        } catch (Exception e) {
            //log
        }
        return vector;
    }

    public int deleteProduc(int id) {
        int n = 0;
        String sql = "delete from Product where product_id = " + id;

        try {
            Statement state = _connection.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int insertProduct(Product product) {
        int n = 0;
        String sql = "INSERT INTO Product (product_name, categoryID, price, quantity, statuss) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement pre = _connection.prepareStatement(sql);
            pre.setString(1, product.getProduct_name());
            pre.setInt(2, product.getCategoryID());
            pre.setDouble(3, product.getPrice());
            pre.setInt(4, product.getQuantity());
            pre.setBoolean(5, product.isStatus());
            n = pre.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int updateProduct(Product product) {
        int n = 0;
        String sqlUpdate = "UPDATE [dbo].[Product] SET [product_name] = '" + product.getProduct_name()
                + "' ,[categoryID] = " + product.getCategoryID()
                + " ,[price] = " + product.getPrice()
                + " ,[quantity] = '" + product.getQuantity()
                + "' ,[statuss] = '" + product.isStatus() + "'"
                + " WHERE [product_id] =" + product.getProduct_id() + "";
        try {
            Statement statement = _connection.createStatement();
            n = statement.executeUpdate(sqlUpdate);
        } catch (Exception ex) {
            //log
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public static void main(String[] args) {
        DAOProduct dao = new DAOProduct();
        Product product = new Product(7,"I phone 14", 1, 4000, 32, false);
        dao.updateProduct(product);
    }
}
