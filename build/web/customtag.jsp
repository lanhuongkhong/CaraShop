<%@ taglib uri="/WEB-INF/tlds/TagCustom" prefix="tc" %>

<%-- 
    Document   : customtag
    Created on : 17 thg 10, 2024, 03:33:20
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <!-- Sử dụng Custom Tag với các thuộc tính name và time -->
        <tc:TagCustom name="Lan" time="yyyy-MM-dd" />

        <!-- Sử dụng Custom Tag với chỉ thuộc tính name -->
        <tc:TagCustom name="Enndme" />
    </body>
</html>
