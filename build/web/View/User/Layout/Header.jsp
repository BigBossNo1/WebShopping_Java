<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Entity.Customer"%>
<footer>
    <% Customer customer = (Customer) session.getAttribute("inforCustomerLogin"); %>
    <h2>Xin chào : <%= customer.getCustomer_name() %></h2>
    <div class="footer-content">
        <div class="footer-buttons">
            <a href="/Web_Shopping/SraffController?service=login" class="button">Trang Admin</a>
            <a href="CustomerController?service=logout" class="button">Đăng Xuất</a>
            <a href="CartController?service=showCart" class="button">Giỏ Hàng</a>
            <a href="OrderController" class="button">Đơn Hàng</a>
        </div>
    </div>
</footer>
