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
    <link href="StyleIndex.css" rel="stylesheet" type="text/css"/>
</head>
<body>
    <%@include file="Layout/Header.jsp" %>
    <div class="container">
        <%@include file="Layout/Menu.jsp" %>
        <div class="content">
            <div class="welcome-message">
                <h2>Chào mừng bạn đến với cửa hàng!</h2>
                <p>Hãy chọn danh mục sản phẩm bên cạch để tiếp tục mua sắm nhé </p>
            </div>
        </div>
    </div>
    <%@include file="Layout/Footer.jsp" %>    
</body>
</html>
