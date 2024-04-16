package Controller;

import Entity.Customer;
import Entity.Product;
import Entity.Staff;
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

@WebServlet(name = "ProductController", urlPatterns = {"/ProductController"})
public class ProductController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        DAOProduct daoProduct = new DAOProduct();
        String service = request.getParameter("service");
        try (PrintWriter out = response.getWriter()) {
            Customer customer = (Customer) session.getAttribute("inforCustomerLogin");
            Staff staff = (Staff) session.getAttribute("inforStaffLogin");
            if (staff == null && customer == null) {
                if (!response.isCommitted()) {
                    request.getRequestDispatcher("View/Home/ChoseOption.jsp").forward(request, response);
                } else {
                    System.out.println("Cannot forward after response has been committed");
                }
            }
            if (service == null) {
                service = "listAll";
            }
            if (service.equals("listAll")) {
                Vector<Product> vector;
                vector = daoProduct.getListProduct("select * from Product");
                request.setAttribute("productList", vector);
                request.getRequestDispatcher("View/Admin/Product/ListAllProduct.jsp").forward(request, response);
            }
            if (service.equals("insert")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    request.getRequestDispatcher("View/Admin/Product/ProductAdd.jsp").forward(request, response);
                } else {
                    String productName = request.getParameter("product_name");
                    int categoryID = Integer.parseInt(request.getParameter("categoryID"));
                    double price = Double.parseDouble(request.getParameter("price"));
                    int quantity = Integer.parseInt(request.getParameter("quantity"));
                    boolean status = Boolean.parseBoolean(request.getParameter("status"));
                    Product newProduct = new Product(productName, categoryID, price, quantity, status);
                    daoProduct.insertProduct(newProduct);
                    response.sendRedirect("ProductController");
                }
            }
            if (service.equals("update")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    int id = Integer.parseInt(request.getParameter("id"));
                    Vector<Product> vector = daoProduct.getListProduct("select * from Product where product_id =" + id);
                    request.setAttribute("vector", vector);
                    RequestDispatcher dispath
                            = request.getRequestDispatcher("View/Admin/Product/ProductUpdate.jsp");
                    dispath.forward(request, response);
                } else {
                    int id = Integer.parseInt(request.getParameter("id"));
                    String productName = request.getParameter("product_name");
                    int categoryID = Integer.parseInt(request.getParameter("categoryID"));
                    double price = Double.parseDouble(request.getParameter("price"));
                    int quantity = Integer.parseInt(request.getParameter("quantity"));
                    boolean status = Boolean.parseBoolean(request.getParameter("status"));
                    Product newProduct = new Product(id, productName, categoryID, price, quantity, status);
                    daoProduct.updateProduct(newProduct);
                    response.sendRedirect("ProductController");
                }
            }
            if (service.equals("deleteProduct")) {
                String id = request.getParameter("id");
                int idInt = Integer.parseInt(id);
                daoProduct.deleteProduc(idInt);
                response.sendRedirect("ProductController");
            }
            if (service.equals("search")) {
                String value = request.getParameter("value");
                if (value == null) {
                    response.sendRedirect("ProductController");
                } else {
                    Vector<Product> vector;
                    vector = daoProduct.getListProduct("select * from Product where product_name like'%" + value + "%' ");
                    request.setAttribute("productList", vector);
                    request.getRequestDispatcher("View/Admin/Product/ListAllProduct.jsp").forward(request, response);
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
