package Model;

import Entity.Product;
import Entity.Staff;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOStaff extends DbContext {

    public boolean loginAdmin(String email, String phoneNumber) {
        String sql = "SELECT * FROM Staff WHERE email = ? AND phonenumber = ?";

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

    public Staff getStaffByEmail(String email, String phoneNumber) {
        Staff newStaff = null;

        try {
            String sql = "SELECT * FROM Staff WHERE email = ? AND phonenumber = ?";
            PreparedStatement statement = _connection.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, phoneNumber);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                int staff_id = rs.getInt(1);
                String staff_name = rs.getString(2);
                String emailUser = rs.getString(3);
                String phoneNumberUser = rs.getString(4);
                newStaff = new Staff(staff_id, staff_name, emailUser, phoneNumberUser);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return newStaff;
    }

    ///
    public Vector<Staff> getListStaff(String sql) {
        Vector<Staff> vector = new Vector<>();
        try {
            Statement statement = _connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int staff_id = rs.getInt(1);
                String staff_name = rs.getString(2);
                String email = rs.getString(3);
                String phoneNumber = rs.getString(4);
                Staff newStaff = new Staff(staff_id, staff_name, email, phoneNumber);
                vector.add(newStaff);
            }
        } catch (Exception e) {
            //log
        }
        return vector;
    }

    public int deleteStaff(int id) {
        int n = 0;
        String sql = "delete from Staff where staff_id = " + id;

        try {
            Statement state = _connection.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int insertStaff(Staff staff) {
        int n = 0;
        String sql = "INSERT INTO Staff (staff_name, email, phonenumber) VALUES (?, ?, ?)";
        try {
            PreparedStatement pre = _connection.prepareStatement(sql);
            pre.setString(1, staff.getStaff_name());
            pre.setString(2, staff.getEmail());
            pre.setString(3, staff.getPhonenumber());
            n = pre.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(DAOStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int updateStaff(Staff staff) {
        int n = 0;
        String sqlUpdate = "UPDATE [dbo].[Staff] SET [staff_name] = ?, [email] = ?, [phonenumber] = ? WHERE [staff_id] = ?";
        try {
            PreparedStatement statement = _connection.prepareStatement(sqlUpdate);
            statement.setString(1, staff.getStaff_name());
            statement.setString(2, staff.getEmail());
            statement.setString(3, staff.getPhonenumber());
            statement.setInt(4, staff.getStaff_id());

            n = statement.executeUpdate();
        } catch (Exception ex) {
            //log
            Logger.getLogger(DAOStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public static void main(String[] args) {
        DAOStaff dao = new DAOStaff();
        Vector<Staff> staff = dao.getListStaff("select * from Staff");
        for (Staff staff1 : staff) {
            System.out.println(staff1.getStaff_name());
        }
        Staff staff1 = new Staff(1, "Lê Văn Toàn", "levantoan@gmail.com", "03557252033");
        dao.updateStaff(staff1);
    }

}
