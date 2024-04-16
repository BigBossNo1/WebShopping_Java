<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector"%>
<%@page import="Entity.OrderDetail"%> 
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
                <table border="1">
                    <% Vector<Orders> infor = (Vector<Orders>) request.getAttribute("InforCustomer"); 
                if (infor != null) { %>
                    <div>Tên khách hàng : <%= infor.get(0).getCustomer_name() %></div>
                    <div>Địa chỉ : <%= infor.get(0).getCustomeraddress() %></div>
                    <div>Số điện thoại : <%= infor.get(0).getCustomer_phone() %></div>
                    <div>Ngày đặt hàng : <%= infor.get(0).getCreate_date() %></div>
                    <%      
                    } %>
                    <thead>
                        <tr>
                            <th>Mã Sản Phẩm</th>
                            <th>Số Lượng</th>
                            <th>Giá Tiền</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% Vector<OrderDetail> orderDetailList = (Vector<OrderDetail>) request.getAttribute("orderDetailList"); 
                        int id = 0;
                        if (orderDetailList != null) {
                            for (OrderDetail ord : orderDetailList) { %>
                        <tr>
                            <td><%= ord.getProduct_id() %></td>
                            <td><%= ord.getQuantity() %></td>
                            <td><%= ord.getPrice() %></td>
                        </tr>
                        <%      id = ord.getOrder_id();
                            }
                        } %>
                    </tbody>
                </table>   
                <div>
                    <button onclick="window.location.href = '/Web_Shopping/OrderProcessingController?service=confirm&id=<%= id %>';">Xác Nhận Đơn Hàng</button>
                </div>
            </div>
        </div>
        <footer class="footer">
            <%@include file="../../Admin/Layout/Footer.jsp" %>
        </footer>
    </body>
</html>
