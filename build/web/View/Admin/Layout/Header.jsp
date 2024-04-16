<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Entity.Staff"%>
<footer>
    <% Staff sta = (Staff) session.getAttribute("inforStaffLogin"); %>
    <h2>Trang Admin - Xin chào : <%= sta.getStaff_name() %></h2>
    <div class="footer-content">
        <div class="footer-buttons">
            <!--                    <a href="login.html" class="button">Đăng Nhập</a>-->
            <a href="SraffController?service=logout" class="button">Đăng Xuất</a>
            <a href="/Web_Shopping/CustomerController?service=login" class="button">Trang Mua Sắm</a>
        </div>
    </div>
</footer>
