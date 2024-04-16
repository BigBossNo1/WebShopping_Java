package Controller;

import Entity.Customer;
import Entity.Staff;
import Model.DAOCustomer;
import Model.DAOStaff;
import com.oracle.wls.shaded.org.apache.bcel.generic.AALOAD;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "ServiceController", urlPatterns = {"/ServiceController"})
public class ServiceController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DAOCustomer daoCustomer = new DAOCustomer();
        DAOStaff daoStaff = new DAOStaff();
        try (PrintWriter out = response.getWriter()) {
            String service = request.getParameter("service");
            if (service == null) {
                service = "null";
            }
            if (service.equals("registerUser")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    request.getRequestDispatcher("View/Home/RegisterUser.jsp").forward(request, response);
                } else {
                    String customerName = request.getParameter("customer_name");
                    String phoneNumber = (request.getParameter("phoneNumber"));
                    String email = (request.getParameter("email"));
                    String address = (request.getParameter("address"));
                    Customer newCustomer = new Customer(customerName, phoneNumber, email, address);
                    daoCustomer.insertCustomer(newCustomer);
                    response.sendRedirect("CustomerController?service=login");
                }
            }
            if (service.equals("registerAdmin")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    request.getRequestDispatcher("View/Home/RegisterAdmin.jsp").forward(request, response);
                } else {
                    String staffName = request.getParameter("staff_name");
                    String email = (request.getParameter("email"));
                    String phoneNumber = (request.getParameter("phoneNumber"));
                    Staff newStaff = new Staff(staffName, email, phoneNumber);
                    daoStaff.insertStaff(newStaff);
                    response.sendRedirect("SraffController?service=login");
                }
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
