<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector"%>
<%@page import="Entity.Orders"%> 
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Product List</title>
        <link href="Asset/User/StyleIndex.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="../../Admin/Layout/Header.jsp" %>
        <div class="container">
            <%@include file="../../Admin/Layout/Menu.jsp" %>
            <div class="content">   
                <h1>Các Đơn Hàng Đã Đặt</h1>
                <table border="1">
                    <thead>
                        <tr>
                            <th>Tên Khách Hàng</th>
                            <th>Địa Chỉ</th>
                            <th>Ngày Mua Hàng</th>
                            <th>Số Điện Thoại</th>
                            <th>Thao Tác</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% Vector<Orders> orderList = (Vector<Orders>) request.getAttribute("orderList"); %>
                        <% for (Orders ord : orderList) { %>
                        <tr>
                            <td><%= ord.getCustomer_name() %></td>
                            <td><%= ord.getCustomeraddress() %></td>
                            <td><%= ord.getCreate_date() %></td>
                            <td><%= ord.getCustomer_phone() %></td>
                            <td><a href="OrderProcessingController?service=detail&id=<%= ord.getOrder_id() %>">Chi Tiết</a></td>
                        </tr>
                        <% } %>
                    </tbody>
                </table>
            </div>
        </div>
        <footer class="footer">
            <%@include file="../../Admin/Layout/Footer.jsp" %>
        </footer>
    </body>
</html>