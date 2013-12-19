<%--
  User: langerhans
  Date: 2013. 12. 18.
  Time: 오후 5:29
  Description : 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta name="decorator" content="basic" />
</head>
<body>
    <div class="page-header">
        <h3>Sample Board</h3>
    </div>
    <f:form commandName="sampleBoardForm" cssClass="form-horizontal" role="form">

        <%@ include file="_form.jsp" %>

        <div class="form-group">
            <div class="text-center">
                <input type="submit" class="btn btn-primary btn-lg" value="등록" role="button" />
                <a href="/sample/${categoryId}" id="cancelBtn" class="btn btn-default btn-lg" role="button">취소</a>
            </div>
        </div>

    </f:form>

</body>
</html>