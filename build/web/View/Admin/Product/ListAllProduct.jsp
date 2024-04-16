<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector"%>
<%@page import="Entity.Product"%> 
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
                 <form action="ProductController" method="post">
                    <input type="text" id="searchInput" name="value" placeholder="Tìm kiếm...">
                    <button type="submit">Tìm kiếm</button>
                    <input type="hidden" name="service" value="search">
                </form>
                <h1></h1>
                <button class="green-button" onclick="window.location.href = 'ProductController?service=insert'">Thêm mới sản phẩm</button>
                <h1></h1>
                <table border="1">
                    <thead>
                        <tr>
                            <th>Tên Sản Phẩm</th>
                            <th>Giá Bán</th>
                            <th>Số Lượng</th>
                            <th>Trang Thái</th>
                            <th>Thao Tác</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% Vector<Product> productList = (Vector<Product>) request.getAttribute("productList"); %>
                        <% for (Product product : productList) { %>
                        <tr>
                            <td><%= product.getProduct_name() %></td>
                            <td><%= product.getPrice() %></td>
                            <td><%= product.getQuantity() %></td>
                            <td><%= product.isStatus() ? "Còn Hàng" : "Hết Hàng" %></td>
                            <td>
                                <a href="ProductController?service=update&id=<%= product.getProduct_id() %>">Sửa</a>__
                                <a href="#" onclick="confirmDelete('<%= product.getProduct_id() %>')">Xóa</a>
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
            function confirmDelete(productId) {
                if (confirm("Bạn có chắc chắn muốn xóa không?")) {
                    window.location.href = "ProductController?service=deleteProduct&id=" + productId;
                } else {
                    //
                }
            }
        </script>
    </body>
</html>
