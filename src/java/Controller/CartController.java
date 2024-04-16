package Controller;

import Entity.Customer;
import Entity.OrderDetail;
import Entity.Orders;
import Entity.Product;
import Entity.ProductCart;
import Entity.Staff;
import Model.DAOOrder;
import Model.DAOOrderDetail;
import Model.DAOProduct;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "CartController", urlPatterns = {"/CartController"})
public class CartController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        DAOProduct daoProduct = new DAOProduct();
        DAOOrder daoOrder = new DAOOrder();
        DAOOrderDetail daoOrderDetail = new DAOOrderDetail();
        String service = request.getParameter("service");
        try (PrintWriter out = response.getWriter()) {
            Customer customerFist = (Customer) session.getAttribute("inforCustomerLogin");
            Staff staff = (Staff) session.getAttribute("inforStaffLogin");
            if (staff == null && customerFist == null) {
                if (!response.isCommitted()) {
                    request.getRequestDispatcher("View/Home/ChoseOption.jsp").forward(request, response);
                } else {
                    System.out.println("Cannot forward after response has been committed");
                }
            }
            if (service.equals("addToCart")) {
                String id = request.getParameter("id");
                ProductCart proCart = (ProductCart) session.getAttribute("cart_" + id);
                if (proCart == null) { 
                    Vector<Product> vector
                            = daoProduct.getListProduct("select * from Product where product_id="
                                    + Integer.parseInt(id));
                    Product pro = vector.get(0);
                    proCart = new ProductCart();
                    proCart.setProduct_id(pro.getProduct_id());
                    proCart.setProduct_name(pro.getProduct_name());
                    proCart.setPrice(pro.getPrice());
                    proCart.setQuantity(1);
                    session.setAttribute("cart_" + id, proCart);
                } else { 
                    proCart.setQuantity(proCart.getQuantity() + 1);
                    session.setAttribute("cart_" + id, proCart);
                }
                request.getRequestDispatcher("View/Cart/ShowCart.jsp").forward(request, response);
            }
            if (service.equals("updateCart") == true) {
                String quantity_raw = request.getParameter("quantity");
                String id = request.getParameter("id");
                ProductCart pb = (ProductCart) session.getAttribute("cart_" + id);
                pb.setQuantity(Integer.parseInt(quantity_raw));
                session.setAttribute("cart_" + id, pb);
                request.getRequestDispatcher("View/Cart/ShowCart.jsp").forward(request, response);
            }
            if (service.equals("showCart")) {
                RequestDispatcher dispath
                        = request.getRequestDispatcher("View/Cart/ShowCart.jsp");
                dispath.forward(request, response);
            }
            if (service.equals("confirmOrder")) {
                request.getRequestDispatcher("View/Cart/ConfirmOrder.jsp").forward(request, response);
            }
            if ("payMent".equals(service)) {
                Customer customer = (Customer) session.getAttribute("inforCustomerLogin");
                LocalDateTime dateOrder = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String date = dateOrder.format(formatter);
                Orders newOrder = new Orders(customer.getCustomer_id(), customer.getCustomer_name(), customer.getCustomeraddress(), customer.getPhonenumber(), date, 1);
                int orderID = daoOrder.insertOrder(newOrder);
                java.util.Enumeration em = session.getAttributeNames();
                while (em.hasMoreElements()) {
                    String key = em.nextElement().toString();
                    if (key.startsWith("cart_")) {
                        ProductCart pro = (ProductCart) session.getAttribute(key);
                        double price = pro.getQuantity() * pro.getPrice();
                        OrderDetail newOrderDetail = new OrderDetail(orderID, pro.getProduct_id(), pro.getQuantity(), price);
                        daoOrderDetail.insertOrderDetail(newOrderDetail);
                        session.removeAttribute(key);
                    }
                }
                request.getRequestDispatcher("View/User/Cart/OrderSuccessful.jsp").forward(request, response);
            }
            if (service.equals("deleteAll")) {
                java.util.Enumeration em = session.getAttributeNames();
                while (em.hasMoreElements()) {
                    String key = em.nextElement().toString();
                    if (key.startsWith("cart_")) {
                        session.removeAttribute(key);
                    }
                }
                response.sendRedirect("CartController?service=showCart");
            }
            if (service.equals("deleteById")) {
                String id = request.getParameter("id");
                java.util.Enumeration em = session.getAttributeNames();
                while (em.hasMoreElements()) {
                    String key = em.nextElement().toString();
                    if (key.startsWith("cart_"+id)) {
                        session.removeAttribute(key);
                    }
                }
                response.sendRedirect("CartController?service=showCart");
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
