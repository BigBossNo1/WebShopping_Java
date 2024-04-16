package Model;

import Entity.Customer;
import Entity.Orders;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOOrder extends DbContext {

    public Vector<Orders> getListOrder(String sql) {
        Vector<Orders> vector = new Vector<>();
        try {
            Statement statement = _connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int order_id = rs.getInt(1);
                int customer_id = rs.getInt(2);
                String customer_name = rs.getString(3);
                String customeraddress = rs.getString(4);
                String customer_phone = rs.getString(5);
                String create_date = rs.getString(6);
                int status = rs.getInt(7);
                Orders order = new Orders(order_id, customer_id, customer_name, customeraddress, customer_phone, create_date, status);
                vector.add(order);
            }
        } catch (Exception e) {
            //log
        }
        return vector;
    }

    public int insertOrder(Orders orders) {
        int n = 0;
        int orderID = 0;
        String sql = "INSERT INTO Orders (customer_id, customer_name, customeraddress,customer_phone,create_date,statuss) VALUES (?, ?, ?,?,?,?)";
        try {
            PreparedStatement pre = _connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pre.setInt(1, orders.getCustomer_id());
            pre.setString(2, orders.getCustomer_name());
            pre.setString(3, orders.getCustomeraddress());
            pre.setString(4, orders.getCustomer_phone());
            pre.setString(5, orders.getCreate_date());
            pre.setInt(6, orders.getStatus());
            n = pre.executeUpdate();

            if (n > 0) {
                ResultSet resultSet = pre.getGeneratedKeys();
                if (resultSet.next()) {
                    orderID = resultSet.getInt(1);
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(DAOOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orderID;
    }

    public int updateOrder(int id) {
                int n = 0;
        String sqlUpdate = "UPDATE [dbo].[Orders] SET [statuss] = 2 WHERE [order_id] = ?";
        try {
            PreparedStatement statement = _connection.prepareStatement(sqlUpdate);
            statement.setInt(1, id);
            n = statement.executeUpdate();
        } catch (Exception ex) {
            //log
            Logger.getLogger(DAOStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public static void main(String[] args) {
        DAOOrder dao = new DAOOrder();
        Orders or = new Orders(1, "hehe", "jj", "02", "11-12-2003", 1);
        int n = dao.insertOrder(or);
//        System.out.println(n);
        Vector<Orders> vt = dao.getListOrder("select * from Orders where order_id = 5");
        Orders hh = vt.get(0);
        System.out.println(hh.getCustomer_name());
    }

}
