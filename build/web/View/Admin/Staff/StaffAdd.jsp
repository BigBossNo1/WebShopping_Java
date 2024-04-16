<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Staff List</title>
        <link href="Asset/User/StyleIndex.css" rel="stylesheet" type="text/css"/>
        <link href="Asset/Admin/Product/StyleInsertProduct.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="../Layout/Header.jsp" %>
        <div class="container">
            <%@include file="../Layout/Menu.jsp" %>
            <div class="content">
                <div class="add-product-form">
                    <h2>Thêm mới nhân viên</h2>
                    <form action="SraffController" method="post">
                        <label for="staff_name">Tên nhân viên:</label>
                        <input type="text" id="staff_name" name="staff_name" required>

                        <label for="email">Email:</label>
                        <input type="text" id="email" name="email" required>

                        <label for="phoneNumber">Số điện thoại:</label>
                        <input type="text" id="phoneNumber" name="phoneNumber" required>


                        <button type="submit" name="submit">Thêm mới</button>
                        <a href="SraffController">
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