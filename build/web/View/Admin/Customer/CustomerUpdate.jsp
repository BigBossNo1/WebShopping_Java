<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector"%>
<%@page import="Entity.Customer"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Customer List</title>
        <link href="Asset/User/StyleIndex.css" rel="stylesheet" type="text/css"/>
        <link href="Asset/Admin/Product/StyleInsertProduct.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%Vector<Customer> vector =(Vector<Customer>)
        request.getAttribute("vector");
Customer cust = vector.get(0);
        %>
        <%@include file="../Layout/Header.jsp" %>
        <div class="container">
            <%@include file="../Layout/Menu.jsp" %>
            <div class="content">
                <div class="add-product-form">
                    <h2>Cập Nhật Thông Tin Khách Hàng</h2>
                    <form action="CustomerController" method="post">

                        <label for="customer_name">Tên người dùng:</label>
                        <input type="text" id="customer_name" name="customer_name" value="<%=cust.getCustomer_name()%>" required>

                        <label for="phoneNumber">Điện thoại</label>
                        <input type="text" id="phoneNumber" name="phoneNumber" value="<%=cust.getPhonenumber()%>" required>

                        <label for="email">Email</label>
                        <input type="email" id="quantity" name="email" value="<%=cust.getEmail()%>" required>

                        <label for="address">Địa chỉ</label>
                        <input type="text" id="address" name="address" value="<%=cust.getCustomeraddress()%>" required>

                        <button type="submit" name="submit">Cập nhật</button>
                        <a href="CustomerController">
                            <button type="button">Hủy cập nhật</button>
                        </a>
                        <input type="hidden" name="service" value="update">
                        <input type="hidden" name="id" value="<%=cust.getCustomer_id()%>">

                    </form>
                </div>

            </div>
        </div>
        <footer class="footer">
            <%@include file="../Layout/Footer.jsp" %>
        </footer>
    </body>
</html>