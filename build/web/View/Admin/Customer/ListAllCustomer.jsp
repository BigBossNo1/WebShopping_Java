<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector"%>
<%@page import="Entity.Customer"%> 
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Product List</title>
        <link href="Asset/User/StyleIndex.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="../Layout/Header.jsp" %>
        <div class="container">
            <%@include file="../Layout/Menu.jsp" %>
            <div class="content">
                 <form action="CustomerController" method="post">
                    <input type="text" id="searchInput" name="value" placeholder="Tìm kiếm...">
                    <button type="submit">Tìm kiếm</button>
                    <input type="hidden" name="service" value="search">
                </form>
                <h1></h1>
                <button class="green-button" onclick="window.location.href = 'CustomerController?service=insert'">Thêm mới khách hàng</button>
                <h1></h1>
                <table border="1">
                    <thead>
                        <tr>
                            <th>Tên Người Dùng</th>
                            <th>Số Điện Thoại</th>
                            <th>Email</th>
                            <th>Địa Chỉ</th>
                            <th>Thao Tác</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% Vector<Customer> customerList = (Vector<Customer>) request.getAttribute("customerList"); %>
                        <% for (Customer customers : customerList) { %>
                        <tr>
                            <td><%= customers.getCustomer_name() %></td>
                            <td><%= customers.getPhonenumber() %></td>
                            <td><%= customers.getEmail() %></td>
                            <td><%= customers.getCustomeraddress()%></td>
                            <td>
                                <a href="CustomerController?service=update&id=<%= customers.getCustomer_id() %>">Sửa</a>__
                                <a href="#" onclick="confirmDelete('<%= customers.getCustomer_id() %>')">Xóa</a>
                            </td>

                        </tr>
                        <% } %>
                    </tbody>
                </table>
            </div>
        </div>
        <footer class="footer">
            <%@include file="../Layout/Footer.jsp" %>
        </footer>
        <script>
            function confirmDelete(customerId) {
                if (confirm("Bạn có chắc chắn muốn xóa không?")) {
                    window.location.href = "CustomerController?service=deleteProduct&id=" + customerId;
                } else {
                    //
                }
            }
        </script>
    </body>
</html>
