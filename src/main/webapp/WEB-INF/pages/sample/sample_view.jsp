<%--
  User: langerhans
  Date: 2013. 10. 30.
  Time: 오전 1:32
  Description :
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta name="decorator" content="basic" />
</head>
<body>
    <div class="page-header">
        <h3>Sample Board</h3>
    </div>

    <h2>${sample.title}</h2>
    <p>${sample.user.nickName} | <small><fmt:formatDate type="both" value="${sample.writeDate}" dateStyle="short" timeStyle="short" /></small></p>
    <p class="lead">${sample.content}</p>



    <f:form commandName="removeForm" method="delete" action="/sample/${categoryId}/remove/${sample.id}">
    <div class="pull-right">
        <a href="/sample/${categoryId}/modify/${sample.id}" id="modifyBtn" class="btn btn-default btn-mg" role="button">수정</a>
        <button type="submit" id="deleteBtn" class="btn btn-default btn-mg" role="button">삭제</button>
    </div>
    </f:form>

    <content tag="script">
        <script>
            require(['jquery'], function($) {
                $('#removeForm').submit(function() {
                  return confirm('게시물을 삭제하시겠습니까?');
                });
            });
        </script>
    </content>
</body>
</html>