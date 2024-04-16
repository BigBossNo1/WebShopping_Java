<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Entity.Staff"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Your Website</title>
    <link href="Asset/User/StyleIndex.css" rel="stylesheet" type="text/css"/>
    <!-- Thêm thư viện Chart.js -->
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body>
    <%@include file="Layout/Header.jsp" %>
    <div class="container">
        <%@include file="Layout/Menu.jsp" %>
        <div class="content">
            <div class="product-row">
                <!-- Biểu đồ bán hàng -->
                <div class="sales-chart">
                    <canvas id="salesChart" width="400" height="200"></canvas>
                </div>
            </div>
        </div>
    </div>
    <footer class="footer">
        <%@include file="Layout/Footer.jsp" %>
    </footer>
    <script src="Asset/Admin/StyleIndex.js" type="text/javascript"></script>
</body>
</html>


