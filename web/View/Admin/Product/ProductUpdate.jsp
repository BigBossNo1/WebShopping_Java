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
        <link href="Asset/Admin/Product/StyleInsertProduct.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%Vector<Product> vector =(Vector<Product>)
        request.getAttribute("vector");
Product pro = vector.get(0);
        %>
        <%@include file="../Layout/Header.jsp" %>
        <div class="container">
            <%@include file="../Layout/Menu.jsp" %>
            <div class="content">
                <div class="add-product-form">
                    <h2>Cập Nhật Sản Phẩm</h2>
                    <form action="ProductController" method="post">
                        <label for="product_name">Tên sản phẩm:</label>
                        <input type="text" id="product_name" name="product_name" value="<%=pro.getProduct_name()%>" required>
                        <label for="categoryID">ID danh mục:</label>
                        <select id="categoryID" name="categoryID">
                            <option value="1">Điện Thoại</option>
                            <option value="2">Máy Tính</option>
                            <option value="3">Cục Sạc</option>
                            <option value="4">Ốp Lưng</option>
                            <option value="4">Phụ Kiện</option>
                        </select>

                        <label for="price">Giá bán:</label>
                        <input type="text" id="price" name="price" value="<%=pro.getPrice()%>" required>

                        <label for="quantity">Số lượng:</label>
                        <input type="text" id="quantity" name="quantity" value="<%=pro.getQuantity()%>" required>

                        <label for="status">Trạng thái:</label>
                        <select id="status" name="status">
                            <option value="true">Còn hàng</option>
                            <option value="false">Hết hàng</option>
                        </select>

                        <button type="submit" name="submit">Cập nhật</button>
                        <a href="ProductController">
                            <button type="button">Hủy cập nhật</button>
                        </a>
                        <input type="hidden" name="service" value="update">
                        <input type="hidden" name="id" value="<%=pro.getProduct_id()%>">

                    </form>
                </div>

            </div>
        </div>
        <footer class="footer">
            <%@include file="../Layout/Footer.jsp" %>
        </footer>
    </body>
</html>