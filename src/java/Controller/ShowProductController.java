package Controller;

import Entity.Customer;
import Entity.Product;
import Entity.Staff;
import Model.DAOProduct;
import Model.DAOProductCategory;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Vector;

@WebServlet(name = "ShowProductController", urlPatterns = {"/ShowProductController"})
public class ShowProductController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        DAOProductCategory daoProductCategory = new DAOProductCategory();
        DAOProduct daoProduct = new DAOProduct();
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
            if (service.equals("Find")) {
                int categoryID = Integer.parseInt(request.getParameter("id"));
                Vector<Product> vector = daoProduct.getListProduct("select * from Product where categoryID = " + categoryID);
                request.setAttribute("productList", vector);
                request.getRequestDispatcher("View/User/Product/ListProductFind.jsp").forward(request, response);
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
