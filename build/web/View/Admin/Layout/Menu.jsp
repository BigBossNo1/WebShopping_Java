<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="menu">
    <div class="menu-options">
        <a href="ProductController?service=listAll" class="menu-button">Sản Phẩm</a>
        <!--        <a href="computers.html" class="menu-button">Danh Mục Sản Phẩm</a>-->
        <a href="SraffController?service=listAll" class="menu-button">Nhân Viên</a>
        <a href="OrderProcessingController?service=showListOrderNew" class="menu-button">Đơn Chưa Xác Nhận</a>
        <a href="OrderProcessingController?service=showListOrderConfirm" class="menu-button">Đơn Đã Xác Nhận</a>
        <a href="CustomerController" class="menu-button">Khách Hàng</a>
    </div>
</div>
