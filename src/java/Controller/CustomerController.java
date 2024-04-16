package Controller;

import Entity.Customer;
import Entity.Staff;
import Model.DAOCustomer;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Vector;

@WebServlet(name = "CustomerController", urlPatterns = {"/CustomerController"})
public class CustomerController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DAOCustomer daoCustomer = new DAOCustomer();
        HttpSession session = request.getSession(true);
        try (PrintWriter out = response.getWriter()) {
            String service = request.getParameter("service");
            if (service == null) {
                service = "listAll";
            }
            if (service.equals("listAll")) {
                Vector<Customer> vector;
                vector = daoCustomer.getListCustomer("select * from Customer");
                request.setAttribute("customerList", vector);
                request.getRequestDispatcher("View/Admin/Customer/ListAllCustomer.jsp").forward(request, response);
            }
            if (service.equals("login")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    request.getRequestDispatcher("View/Home/loginUser.jsp").forward(request, response);
                } else {
                    String email = request.getParameter("email");
                    String phoneNumber = request.getParameter("phoneNumber");

                    boolean checkLogin = daoCustomer.loginUser(email, phoneNumber);
                    if (checkLogin == true) {
                        //session
                        Customer customerLogin = daoCustomer.getCustomerByEmail(email, phoneNumber);
                        session.setAttribute("inforCustomerLogin", customerLogin);
                        request.getRequestDispatcher("View/User/Index.jsp").forward(request, response);
                    } else {
                        request.getRequestDispatcher("View/Home/loginUser.jsp").forward(request, response);
                    }
                }
            }
            ///
            if (service.equals("insert")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    request.getRequestDispatcher("View/Admin/Customer/CustomerAdd.jsp").forward(request, response);
                } else {
                    String customerName = request.getParameter("customer_name");
                    String phoneNumber = (request.getParameter("phoneNumber"));
                    String email = (request.getParameter("email"));
                    String address = (request.getParameter("address"));
                    Customer newCustomer = new Customer(customerName, phoneNumber, email, address);
                    daoCustomer.insertCustomer(newCustomer);
                    response.sendRedirect("CustomerController");
                }
            }
            if (service.equals("update")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    int id = Integer.parseInt(request.getParameter("id"));
                    Vector<Customer> vector = daoCustomer.getListCustomer("select * from Customer where customer_id =" + id);
                    request.setAttribute("vector", vector);
                    RequestDispatcher dispath
                            = request.getRequestDispatcher("View/Admin/Customer/CustomerUpdate.jsp");
                    dispath.forward(request, response);
                } else {
                    int customer_id = Integer.parseInt(request.getParameter("id"));
                    String customerName = request.getParameter("customer_name");
                    String phoneNumber = (request.getParameter("phoneNumber"));
                    String email = (request.getParameter("email"));
                    String address = (request.getParameter("address"));
                    Customer newCustomer = new Customer(customer_id, customerName, phoneNumber, email, address);
                    daoCustomer.updateCustomer(newCustomer);
                    response.sendRedirect("CustomerController");
                }
            }
            if (service.equals("deleteCustomer")) {
                String id = request.getParameter("id");
                int idInt = Integer.parseInt(id);
                daoCustomer.deleteCustomer(idInt);
                response.sendRedirect("CustomerController");
            }
            if (service.equals("search")) {
                String value = request.getParameter("value");
                if (value == null) {
                    response.sendRedirect("CustomerController");
                } else {
                    Vector<Customer> vector;
                    vector = daoCustomer.getListCustomer("select * from Customer where customer_name like'%" + value + "%' ");
                    request.setAttribute("customerList", vector);
                    request.getRequestDispatcher("View/Admin/Customer/ListAllCustomer.jsp").forward(request, response);
                }
            }
            if (service.equals("logout")) {
                session.removeAttribute("inforCustomerLogin");
                response.sendRedirect("CustomerController?service=login");
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
