<%--
  User: langerhans
  Date: 2014. 2. 11.
  Time: 오후 1:54
  Description : create.jsp
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="ko">
<head>
    <meta name="decorator" content="basic" />
</head>
<body>

<div class="col-md-9">
    <div class="page-header">
        <h3>Community - ${BOARD_NAME}</h3>
    </div>
    <f:form commandName="article" id="articleForm" cssClass="form-horizontal" role="form" method="POST"
            action="/community/${boardId}/${categoryId}/${article.writeNo}">

        <f:hidden path="boardId" />
        <f:hidden path="writeNo" />

        <%@ include file="_community_form.jsp"%>

        <div class="form-group">
            <div class="text-center">
                <input type="submit" class="btn btn-success btn-mg" value="저장" role="button" />
                <a href="/community/${boardId}/${categoryId}/${article.writeNo}" id="cancelBtn" class="btn btn-default btn-mg" role="button">취소</a>
            </div>
        </div>

    </f:form>
</div>

</body>
</html>