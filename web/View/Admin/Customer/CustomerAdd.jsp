<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Product List</title>
        <link href="Asset/User/StyleIndex.css" rel="stylesheet" type="text/css"/>
        <link href="Asset/Admin/Product/StyleInsertProduct.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="../Layout/Header.jsp" %>
        <div class="container">
            <%@include file="../Layout/Menu.jsp" %>
            <div class="content">
                <div class="add-product-form">
                    <h2>Thêm mới khách hàng</h2>
                    <form action="CustomerController" method="post">
                        <label for="customer_name">Tên người dùng:</label>
                        <input type="text" id="customer_name" name="customer_name" required>

                        <label for="phoneNumber">Điện thoại</label>
                        <input type="text" id="phoneNumber" name="phoneNumber" required>

                        <label for="email">Email</label>
                        <input type="email" id="quantity" name="email" required>
                        
                        <label for="address">Địa chỉ</label>
                        <input type="text" id="address" name="address" required>

                        <button type="submit" name="submit">Thêm mới</button>
                        <a href="CustomerController">
                            <button type="button">Hủy Thêm</button>
                        </a>
                        <input type="hidden" name="service" value="insert">
                    </form>
                </div>

            </div>
        </div>
        <footer class="footer">
            <%@include file="../Layout/Footer.jsp" %>
        </footer>
    </body>
</html>