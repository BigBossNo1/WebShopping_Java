package Controller;

import Entity.Customer;
import Entity.OrderDetail;
import Entity.Orders;
import Entity.Staff;
import Model.DAOOrder;
import Model.DAOOrderDetail;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Vector;

@WebServlet(name = "OrderController", urlPatterns = {"/OrderController"})
public class OrderController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        DAOOrder daoOrder = new DAOOrder();
        DAOOrderDetail daoOrderDetail = new DAOOrderDetail();
        try (PrintWriter out = response.getWriter()) {
            String service = request.getParameter("service");
            //check Login
            Customer customerFist = (Customer) session.getAttribute("inforCustomerLogin");
            Staff staff = (Staff) session.getAttribute("inforStaffLogin");
            if (staff == null && customerFist == null) {
                if (!response.isCommitted()) {
                    request.getRequestDispatcher("View/Home/ChoseOption.jsp").forward(request, response);
                } else {
                    System.out.println("Cannot forward after response has been committed");
                }
            }
            //
            if (service == null) {
                service = "Change";
                request.getRequestDispatcher("View/Order/OrderIndex.jsp").forward(request, response);
            }
            if (service.equals("choseOrder")) {
                Customer customer = (Customer) session.getAttribute("inforCustomerLogin");
                int customerID = customer.getCustomer_id();
                Vector<Orders> vector;
                vector = daoOrder.getListOrder("select * from Orders where statuss =1 and customer_id = " + customerID);
                request.setAttribute("orderList", vector);
                request.getRequestDispatcher("View/Order/Chose/Ordered.jsp").forward(request, response);
            }
            if (service.equals("choseConfirm")) {
                Customer customer = (Customer) session.getAttribute("inforCustomerLogin");
                int customerID = customer.getCustomer_id();
                Vector<Orders> vector;
                vector = daoOrder.getListOrder("select * from Orders where statuss =2 and customer_id = " + customerID);
                request.setAttribute("orderList", vector);
                request.getRequestDispatcher("View/Order/Chose/Confirmed.jsp").forward(request, response);
            }
            if (service.equals("detail")) {
                String orderID = request.getParameter("id");
                Vector<OrderDetail> vector;
                vector = daoOrderDetail.getListOrderDetail("select * from OrderDetail where order_id = " + orderID);
                request.setAttribute("orderDetailList", vector);
                request.getRequestDispatcher("View/Order/View/Detail.jsp").forward(request, response);
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
