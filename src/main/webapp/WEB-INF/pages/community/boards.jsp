<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <meta name="decorator" content="basic" />
</head>
<body>

    <ul>
        <c:forEach var="board" items="${BOARD_NAMES}">
            <li><a href="/community/3/${board.key}">${board.value}</a></li>
        </c:forEach>
    </ul>
    
    <content tag="script">
        <script src="/components/jquery-1.10.2.min.js"></script>
    </content>
</body>
</html>