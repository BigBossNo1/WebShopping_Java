<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Form Đăng Ký</title>
        <link href="Asset/Home/StyleRegister.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <h2>Đăng Kí Quản Trị</h2>
            <form action="ServiceController" method="post">
                <label for="staff_name">Tên nhân viên:</label>
                <input type="text" id="staff_name" name="staff_name" required>

                <label for="email">Email:</label>
                <input type="text" id="email" name="email" required>

                <label for="phoneNumber">Số điện thoại:</label>
                <input type="text" id="phoneNumber" name="phoneNumber" required>


                <button type="submit" name="submit">Đăng Ký</button>
                <a href="SraffController?service=login">
                    <button type="button">Hủy Đăng ký</button>
                </a>
                <input type="hidden" name="service" value="registerAdmin">
            </form>
        </div>

    </body>
</html>

