<%--
  User: langerhans
  Date: 2013. 10. 30.
  Time: 오전 1:32
  Description : Index Page
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="decorator" content="basic" />
</head>
<body>
	<h1>${message}</h1>

    <ul>
        <li><a href="/sample/1">/sample/1</a> <small>(<b>JSP</b> Version Sample Board)</small></li>
        <li><a href="/sample_ng/1">/sample_ng/1</a> <small>(<b>AngularJS</b> Version Sample Board)</small></li>
    </ul>

    <content tag="script">
        <script src="/components/jquery-1.10.2.min.js"></script>
    </content>
</body>
</html>