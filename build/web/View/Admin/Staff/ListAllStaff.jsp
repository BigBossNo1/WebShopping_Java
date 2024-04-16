<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector"%>
<%@page import="Entity.Staff"%> 
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
                <form action="SraffController" method="post">
                    <input type="text" id="searchInput" name="value" placeholder="Tìm kiếm...">
                    <button type="submit">Tìm kiếm</button>
                    <input type="hidden" name="service" value="search">
                </form>
                <h1></h1>
                <button class="green-button" onclick="window.location.href = 'SraffController?service=insert'">Thêm mới nhân viên</button>
                <h1></h1>
                <table border="1">
                    <thead>
                        <tr>
                            <th>Tên Nhân Viên</th>
                            <th>Email</th>
                            <th>Số Điện Thoại</th>
                            <th>Thao Tác</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% Vector<Staff> staffList = (Vector<Staff>) request.getAttribute("staffList"); %>
                        <% for (Staff st : staffList) { %>
                        <tr>
                            <td><%= st.getStaff_name() %></td>
                            <td><%= st.getEmail() %></td>
                            <td><%= st.getPhonenumber() %></td>
                            <td>
                                <a href="SraffController?service=update&id=<%= st.getStaff_id() %>">Sửa</a>__
                                <a href="#" onclick="confirmDelete('<%= st.getStaff_id() %>')">Xóa</a>
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
            function confirmDelete(staffId) {
                if (confirm("Bạn có chắc chắn muốn xóa không?")) {
                    window.location.href = "SraffController?service=deleteStaff&id=" + staffId;
                } else {
                    //
                }
            }
        </script>
    </body>
</html>
