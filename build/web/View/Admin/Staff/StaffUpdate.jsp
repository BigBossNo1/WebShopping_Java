<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector"%>
<%@page import="Entity.Staff"%>

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
        <%Vector<Staff> vector =(Vector<Staff>)
        request.getAttribute("vector");
Staff staff = vector.get(0);
        %>
        <%@include file="../Layout/Header.jsp" %>
        <div class="container">
            <%@include file="../Layout/Menu.jsp" %>
            <div class="content">
                <div class="add-product-form">
                    <h2>Cập Nhật Nhân Viên</h2>
                    <form action="SraffController" method="post">
                        <label for="staff_name">Tên sản phẩm:</label>
                        <input type="text" id="staff_name" name="staff_name" value="<%=staff.getStaff_name()%>" required>

                        <label for="email">Email:</label>
                        <input type="text" id="email" name="email" value="<%=staff.getEmail()%>" required>

                        <label for="phoneNumber">Số điện thoại</label>
                        <input type="text" id="phoneNumber" name="phoneNumber" value="<%=staff.getPhonenumber()%>" required>
                        
                        <button type="submit" name="submit">Cập nhật</button>
                        <a href="SraffController">
                            <button type="button">Hủy cập nhật</button>
                        </a>
                        <input type="hidden" name="service" value="update">
                        <input type="hidden" name="id" value="<%=staff.getStaff_id()%>">

                    </form>
                </div>

            </div>
        </div>
        <footer class="footer">
            <%@include file="../Layout/Footer.jsp" %>
        </footer>
    </body>
</html>