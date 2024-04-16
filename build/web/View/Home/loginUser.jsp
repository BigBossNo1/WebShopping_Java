<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <link href="Asset/Home/StyleLogin.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <form action="CustomerController" method="post">
        <h1>Trang Đăng Nhập Của Người Dùng</h1>
        <label for="username">Tên Đăng Nhập</label>
        <input type="text" id="email" name="email" required>
        <label for="password">Mật Khẩu</label>
        <input type="password" id="phoneNumber" name="phoneNumber" required>
        <button type="submit" name="submit">Đăng Nhập</button>
        <input type="hidden" name="service" value="login">
        <p>Bạn chưa có tài khoản u? <a href="ServiceController?service=registerUser">Đăng ký</a>.</p>
    </form>
</body>
</html>

