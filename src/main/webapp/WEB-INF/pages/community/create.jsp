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
        <h3>Community - 공통게시판</h3>
    </div>
    <f:form commandName="post" id="postForm" cssClass="form-horizontal" role="form" method="POST">

       <%@ include file="_form.jsp"%>

        <div class="form-group">
            <div class="text-center">
                <input type="submit" class="btn btn-success btn-mg" value="저장" role="button" />
                <a href="list.jsp" id="cancelBtn" class="btn btn-default btn-mg" role="button">취소</a>
            </div>
        </div>

    </f:form>
</div>

</body>
</html>