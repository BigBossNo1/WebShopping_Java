package Model;

import Entity.Product;
import Entity.ProductCategory;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

public class DAOProductCategory extends DbContext {

    public int getIdProductByName(String name) {
        int id = 0;
        Vector<ProductCategory> vector = new Vector<>();
        try {
            String sql = "select * from ProductCategory where category_name = " + name;
            Statement statement = _connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int categoryID = rs.getInt(1);
                String category_name = rs.getString(2);
                boolean status = rs.getBoolean(3);
                ProductCategory newProductcategory = new ProductCategory(categoryID, category_name, status);
                vector.add(newProductcategory);
            }
            ProductCategory productCategory = vector.get(0);
            id = productCategory.getCategoryID();
        } catch (Exception e) {
            //log
        }
        return id;
    }
}
