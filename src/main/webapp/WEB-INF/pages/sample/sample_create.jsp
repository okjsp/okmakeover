<%--
  User: langerhans
  Date: 2013. 12. 18.
  Time: 오후 5:29
  Description : 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta name="decorator" content="basic" />
</head>
<body>
    <div class="page-header">
        <h3>Sample Board</h3>
    </div>
    <f:form commandName="sampleBoard" method="POST" cssClass="form-horizontal" role="form" action="/sample/${categoryId}">

        <%@ include file="_sample_form.jsp" %>

        <div class="form-group">
            <div class="text-center">
                <input type="submit" class="btn btn-primary btn-mg" value="저장" role="button" />
                <a href="/sample/${categoryId}" id="cancelBtn" class="btn btn-default btn-mg" role="button">취소</a>
            </div>
        </div>

    </f:form>

</body>
</html>