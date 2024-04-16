package Model;

import Entity.Customer;
import Entity.Staff;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOCustomer extends DbContext {

    public boolean loginUser(String email, String phoneNumber) {
        String sql = "SELECT * FROM Customer WHERE email = ? AND phonrnumber = ?";

        try {
            PreparedStatement statement = _connection.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, phoneNumber);

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Customer getCustomerByEmail(String email, String phoneNumber) {
        Customer newcustomer = null;

        try {
            String sql = "SELECT * FROM Customer WHERE email = ? AND phonrnumber = ?";
            PreparedStatement statement = _connection.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, phoneNumber);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                int customer_id = rs.getInt(1);
                String customer_name = rs.getString(2);
                String phoneNumbers = rs.getString(3);
                String emails = rs.getString(4);
                String customerAddress = rs.getString(5);
                newcustomer = new Customer(customer_id, customer_name, phoneNumbers, emails, customerAddress);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newcustomer;
    }

    ///
    public Vector<Customer> getListCustomer(String sql) {
        Vector<Customer> vector = new Vector<>();
        try {
            Statement statement = _connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int customer_id = rs.getInt(1);
                String customer_name = rs.getString(2);
                String email = rs.getString(4);
                String phoneNumber = rs.getString(3);
                String address = rs.getString(5);
                Customer newCustomer = new Customer(customer_id, customer_name, phoneNumber, email, address);
                vector.add(newCustomer);
            }
        } catch (Exception e) {
            //log
        }
        return vector;
    }

    public int deleteCustomer(int id) {
        int n = 0;
        String sql = "delete from Customer where customer_id = " + id;

        try {
            Statement state = _connection.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int insertCustomer(Customer customer) {
        int n = 0;
        String sql = "INSERT INTO Customer (customer_name, phonrnumber, email,customeraddress) VALUES (?, ?, ?,?)";
        try {
            PreparedStatement pre = _connection.prepareStatement(sql);
            pre.setString(1, customer.getCustomer_name());
            pre.setString(2, customer.getPhonenumber());
            pre.setString(3, customer.getEmail());
            pre.setString(4, customer.getCustomeraddress());
            n = pre.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int updateCustomer(Customer customer) {
        int n = 0;
        String sqlUpdate = "UPDATE [dbo].[Customer] SET [customer_name] = ?, [phonrnumber] = ?, [email] = ? , [customeraddress] = ? WHERE [customer_id] = ?";
        try {
            PreparedStatement statement = _connection.prepareStatement(sqlUpdate);
            statement.setString(1, customer.getCustomer_name());
            statement.setString(2, customer.getPhonenumber());
            statement.setString(3, customer.getEmail());
            statement.setString(4, customer.getCustomeraddress());
            statement.setInt(5, customer.getCustomer_id());

            n = statement.executeUpdate();
        } catch (Exception ex) {
            //log
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public static void main(String[] args) {
        DAOCustomer dao = new DAOCustomer();
        boolean check = dao.loginUser("toanle@gmail.com", "1111");
        if (check == true) {
            System.out.println("oke");
        } else {
            System.out.println("Not oke");
        }
        Customer cus = new Customer(5, "Trung Trần", "0988466321", "trung@gmail.com", "Quận 1 - Hồ Chí Minh");
        dao.updateCustomer(cus);
    }
}
