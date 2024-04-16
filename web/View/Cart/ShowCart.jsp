<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Entity.ProductCart"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Your Website</title>
        <link href="Asset/User/StyleIndex.css" rel="stylesheet" type="text/css"/>
        <link href="Asset/Cart/StyleCart.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="../User/Layout/Header.jsp" %>
        <div class="container">
            <%@include file="../User/Layout/Menu.jsp" %>
            <div class="app__body-content">
                <div class="app__body-products">
                    <h1 class="name">GIỎ HÀNG CỦA BẠN</h1>
                    <table>
                        <tr>
                            <th>Tên sản phẩm</th>
                            <th>Số lượng</th>
                            <th>Giá bán</th>
                            <th>Tổng giá</th>
                            <th>Thao tác</th>
                        </tr>
                        <%  
                            double granTotal = 0; // Khởi tạo biến granTotal
                            java.util.Enumeration em = session.getAttributeNames();
                            while(em.hasMoreElements()) {
                                String key = em.nextElement().toString();
                                if (key.startsWith("cart_")) {
                                    ProductCart pro = (ProductCart) session.getAttribute(key);
                                    double subtotal = pro.getQuantity() * pro.getPrice();
                                    granTotal += subtotal; // Cộng dồn vào granTotal
                        %>
                        <tr>
                            <td><%= pro.getProduct_name() %></td>
<!--                            <td><div><input type="text" value="<%= pro.getQuantity() %>"></div></td>-->
                            <td>
                                <div>
                                    <input type="number" id="quantity_<%= pro.getProduct_id() %>" value="<%= pro.getQuantity() %>" onblur="updateQuantity(<%= pro.getProduct_id() %>)">
                                </div>
                            </td>
                            <td><%= pro.getPrice() %></td>
                            <td><%= subtotal %></td>
                            <td> <button class="remove-button" onclick="window.location.href = '/Web_Shopping/CartController?service=deleteById&id=<%= pro.getProduct_id() %>';">Xóa</button></td>
                        </tr>
                        <% 
            }
        }
                        %>
                    </table>
                    <div>
                        <p>Tổng tiền thanh toán: <%= granTotal %></p> 
                        <a href="/Web_Shopping/CartController?service=confirmOrder" class="confirm-button">Xác nhận đặt hàng</a>
                        <span> | </span>
                        <a href="CartController?service=deleteAll" class="delete-all-button">Xóa tất cả</a>
<!--                        <span> | </span>-->
<!--                        <a href="#" class="update">Mua Tiếp</a>-->
                    </div>
                </div>
            </div>
        </div>
        <%@include file="../User/Layout/Footer.jsp" %>    
        <script>
            function updateQuantity(productId) {
                var quantity = document.getElementById("quantity_" + productId).value;
                window.location.href = '/Web_Shopping/CartController?service=updateCart&id=' + productId + '&quantity=' + quantity;
            }
        </script>
    </body>
</html>
