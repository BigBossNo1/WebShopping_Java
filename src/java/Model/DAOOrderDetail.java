package Model;

import Entity.OrderDetail;
import Entity.Orders;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOOrderDetail extends DbContext {

    public Vector<OrderDetail> getListOrderDetail(String sql) {
        Vector<OrderDetail> vector = new Vector<>();
        try {
            Statement statement = _connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int order_id = rs.getInt(1);
                int product_id = rs.getInt(2);
                int quantity = rs.getInt(3);
                double price = rs.getDouble(4);
                OrderDetail orderDetail = new OrderDetail(order_id, product_id, quantity, price);
                vector.add(orderDetail);
            }
        } catch (Exception e) {
            //log
        }
        return vector;
    }

    public int insertOrderDetail(OrderDetail ordersDetail) {
        int n = 0;
        String sql = "INSERT INTO OrderDetail (order_id, product_id, quantity,price) VALUES (?, ?, ?,?)";
        try {
            PreparedStatement pre = _connection.prepareStatement(sql);
            pre.setInt(1, ordersDetail.getOrder_id());
            pre.setInt(2, ordersDetail.getProduct_id());
            pre.setInt(3, ordersDetail.getQuantity());
            pre.setDouble(4, ordersDetail.getPrice());
            n = pre.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(DAOOrderDetail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
    public static void main(String[] args) {
        DAOOrderDetail dao = new DAOOrderDetail();
        OrderDetail or = new OrderDetail(1, 1, 4, 3);
        dao.insertOrderDetail(or);
    }
}
