<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Entity.Product"%> 
<%@ page import="java.util.Vector" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Your Website</title>
    <link href="Asset/User/StyleIndex.css" rel="stylesheet" type="text/css"/>
</head>
<body>
    <%@include file="../Layout/Header.jsp" %>
    <div class="container">
        <%@include file="../Layout/Menu.jsp" %>
        <div class="content">
            <div class="product-row">
                <% Vector<Product> productList = (Vector<Product>) request.getAttribute("productList");
                if (productList != null && !productList.isEmpty()) {
                    // Nếu danh sách sản phẩm không rỗng, hiển thị sản phẩm
                    for (Product listprodcuctFind : productList) { %>
                    <div class="product">
                        <h3><%= listprodcuctFind.getProduct_name() %></h3>
                        <p>Giá bán :<%= listprodcuctFind.getPrice() %>$</p>
                        <p>Còn <%= listprodcuctFind.getQuantity() %> sản phẩm</p>
                        <a href="CartController?service=addToCart&id=<%= listprodcuctFind.getProduct_id() %>" class="add-to-cart-btn">Thêm vào giỏ hàng</a>
                    </div>
                <% } 
                } else {
                %>
                <p><font color="Green"><strong>MẶT HÀNG NÀY TẠM THỜI ĐANG HẾT !!</strong></p>
                <% } %>
            </div>
        </div>
    </div>
    <%@include file="../Layout/Footer.jsp" %>    
</body>
</html>
