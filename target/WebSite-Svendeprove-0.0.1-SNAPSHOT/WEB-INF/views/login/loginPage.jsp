<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
    <head>
        <title>Yahoo!!</title>
    </head>
    <body>
    <form action="/login.do" method="post">
        <input type="text" name="name">
        <input type="password" name="password">
        <input type="submit">
    </form>
    <p><font color="red">${errorMessage}</p>
    </body>
</html>