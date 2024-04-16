<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector"%>
<%@page import="Entity.OrderDetail"%> 
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
                            <th>Mã Sản Phẩm</th>
                            <th>Số Lượng</th>
                            <th>Giá Tiền</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% Vector<OrderDetail> orderDetailList = (Vector<OrderDetail>) request.getAttribute("orderDetailList"); %>
                        <% for (OrderDetail ord : orderDetailList) { %>
                        <tr>
                            <td><%= ord.getProduct_id() %></td>
                            <td><%= ord.getQuantity() %></td>
                            <td><%= ord.getPrice() %></td>
                        </tr>
                        <% } %>
                    </tbody>
                </table>    
            </div>

        </div>
        <%@include file="../../User/Layout/Footer.jsp" %>    
    </body>
</html>