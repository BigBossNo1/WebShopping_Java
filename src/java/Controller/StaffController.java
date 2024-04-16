package Controller;

import Entity.Product;
import Entity.Staff;
import Model.DAOStaff;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Vector;

public class StaffController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DAOStaff daoStaff = new DAOStaff();
        HttpSession session = request.getSession(true);
        try (PrintWriter out = response.getWriter()) {
            String service = request.getParameter("service");
            if (service == null) {
                service = "listAll";
            }
            if (service.equals("listAll")) {
                Vector<Staff> vector;
                vector = daoStaff.getListStaff("select * from Staff");
                request.setAttribute("staffList", vector);
                request.getRequestDispatcher("View/Admin/Staff/ListAllStaff.jsp").forward(request, response);
            }
            if (service.equals("login")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    request.getRequestDispatcher("View/Home/LoginAdmin.jsp").forward(request, response);
                } else {
                    String email = request.getParameter("email");
                    String phoneNumber = request.getParameter("phoneNumber");

                    boolean checkLogin = daoStaff.loginAdmin(email, phoneNumber);
                    if (checkLogin == true) {
                        //session
                        Staff staffLogin = daoStaff.getStaffByEmail(email, phoneNumber);
                        session.setAttribute("inforStaffLogin", staffLogin);
                        request.getRequestDispatcher("View/Admin/Index.jsp").forward(request, response);
                    } else {
                        request.getRequestDispatcher("View/Home/LoginAdmin.jsp").forward(request, response);
                    }
                }
            }
            if (service.equals("insert")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    request.getRequestDispatcher("View/Admin/Staff/StaffAdd.jsp").forward(request, response);
                } else {
                    String staffName = request.getParameter("staff_name");
                    String email = (request.getParameter("email"));
                    String phoneNumber = (request.getParameter("phoneNumber"));
                    Staff newStaff = new Staff(staffName, email, phoneNumber);
                    daoStaff.insertStaff(newStaff);
                    response.sendRedirect("SraffController");
                }
            }
            if (service.equals("update")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    int id = Integer.parseInt(request.getParameter("id"));
                    Vector<Staff> vector = daoStaff.getListStaff("select * from Staff where staff_id =" + id);
                    request.setAttribute("vector", vector);
                    RequestDispatcher dispath
                            = request.getRequestDispatcher("View/Admin/Staff/StaffUpdate.jsp");
                    dispath.forward(request, response);
                } else {
                    int staff_id = Integer.parseInt(request.getParameter("id"));
                    String staff_Name = request.getParameter("staff_name");
                    String email = request.getParameter("email");
                    String phoneNumber = request.getParameter("phoneNumber");
                    Staff newStaff = new Staff(staff_id, staff_Name, email, phoneNumber);
                    daoStaff.updateStaff(newStaff);
                    response.sendRedirect("SraffController");
                }
            }
            if (service.equals("deleteStaff")) {
                String id = request.getParameter("id");
                int idInt = Integer.parseInt(id);
                daoStaff.deleteStaff(idInt);
                response.sendRedirect("SraffController");
            }
            if (service.equals("search")) {
                String value = request.getParameter("value");
                if (value == null) {
                    response.sendRedirect("SraffController");
                } else {
                    Vector<Staff> vector;
                    vector = daoStaff.getListStaff("select * from Staff where staff_name like'%" + value + "%' ");
                    request.setAttribute("staffList", vector);
                    request.getRequestDispatcher("View/Admin/Staff/ListAllStaff.jsp").forward(request, response);
                }
            }
            if (service.equals("logout")) {
                session.removeAttribute("inforStaffLogin");
                response.sendRedirect("SraffController?service=login");
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
