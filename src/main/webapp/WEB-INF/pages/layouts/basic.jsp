<%--
  User: langerhans
  Date: 2013. 10. 30.
  Time: 오전 1:41
  Description : 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<html>
<head>
    <title><decorator:title default="OKJSP" /></title>
    <script src="/components/require.js"></script>
    <script src="/app/app.js"></script>
    <decorator:head />
</head>
<body>
    <h1>OK JSP</h1>

    <decorator:body />
</body>
</html>