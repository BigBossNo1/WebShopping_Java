<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector"%>
<%@page import="Entity.Orders"%> 
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Your Website</title>
        <link href="Asset/User/StyleIndex.css" rel="stylesheet" type="text/css"/>
        <link href="sset/Cart/StyleCart.css" rel="stylesheet" type="text/css"/>
        <link href="Asset/Order/StyleOrderIndex.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="../../User/Layout/Header.jsp" %>
        <div class="container">
            <%@include file="../../User/Layout/Menu.jsp" %>
            <div class=""><%@include file="../LayoutOrder.jsp" %></div>
            <div class="content">
                <table border="1">
                    <thead>
                        <tr>
                            <th>Tên Khách Hàng</th>
                            <th>Địa Chỉ</th>
                            <th>Ngày Mua Hàng</th>
                            <th>Số Điện Thoại</th>
                            <th>Trạng Thái</th>
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
                            <td>Chưa Xác Nhận</td>
                            <td>Chi Tiết</td>
                        </tr>
                        <% } %>
                    </tbody>
                </table>    
            </div>

        </div>
        <%@include file="../../User/Layout/Footer.jsp" %>    
    </body>
</html>