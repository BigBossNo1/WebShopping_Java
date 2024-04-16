<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <%@include file="../User/Layout/Header.jsp" %>
        <div class="container">
            <%@include file="../User/Layout/Menu.jsp" %>
            <%@include file="LayoutOrder.jsp" %>
        </div>
        <%@include file="../User/Layout/Footer.jsp" %>    
    </body>
</html>


