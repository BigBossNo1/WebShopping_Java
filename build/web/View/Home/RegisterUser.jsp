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
            <h2>Đăng Kí Người Dùng</h2>
            <form action="ServiceController" method="post">
                <label for="customer_name">Tên người dùng:</label>
                <input type="text" id="customer_name" name="customer_name" required>

                <label for="phoneNumber">Điện thoại</label>
                <input type="text" id="phoneNumber" name="phoneNumber" required>

                <label for="email">Email</label>
                <input type="email" id="quantity" name="email" required>

                <label for="address">Địa chỉ</label>
                <input type="text" id="address" name="address" required>

                <button type="submit" name="submit">Đăng ký</button>
                <a href="CustomerController?service=login">
                    <button type="button">Hủy Đăng ký</button>
                </a>
                <input type="hidden" name="service" value="registerUser">
            </form>
        </div>

    </body>
</html>
