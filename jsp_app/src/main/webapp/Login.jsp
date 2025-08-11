<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background: #f9f9f9;
        color: #222;
        margin: 0;
        padding: 40px 0;
    }
    .container {
        background: #fff;
        border-radius: 6px;
        box-shadow: 0 2px 8px rgba(0,0,0,0.05);
        max-width: 320px;
        margin: 0 auto;
        padding: 24px 20px;
    }
    h2 {
        text-align: center;
        color: #1565c0;
        margin-bottom: 20px;
    }
    input[type="text"], input[type="password"] {
        width: 100%;
        padding: 8px;
        margin: 8px 0 16px 0;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }
    input[type="submit"] {
        width: 100%;
        background: #1565c0;
        color: #fff;
        border: none;
        padding: 10px;
        border-radius: 4px;
        font-size: 1em;
        cursor: pointer;
    }
    input[type="submit"]:hover {
        background: #0d47a1;
    }
</style>
</head>
<body>
    <div class="container">
        <h2>Login</h2>
        <form action="LoginController" method="post">
            <input type="text" name="username" placeholder="Username" required>
            <input type="password" name="password" placeholder="Password" required>
            <input type="submit" value="Login">
        </form>
    </div>
</body>
</html>