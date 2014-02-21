<%--
User: langerhans
Date: 2014. 02. 10.
Time: 오후 4:48
Description :
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<!doctype html>
<html lang="ko">
<head>
    <meta name="decorator" content="basic" />
</head>
<body>

    <div class="col-md-9">
        <div class="page-header">
            <h3>Tech Q&A</h3>
        </div>

        <f:form commandName="techQna" cssClass="form-horizontal" role="form" method="post" 
                action="/techqna/${boardId}/${categoryId}/${writeNo}">
                
			<%@ include file="_question_form.jsp"%>
			    
			<div class="form-group">
			    <div class="text-center">
			        <input type="submit" class="btn btn-success btn-mg" value="저장" role="button" />
			        <a href="/techqna/${boardId}/${categoryId}/${writeNo}" id="cancelBtn" class="btn btn-default btn-mg" role="button">취소</a>
			    </div>
			</div>

        </f:form>
    </div>

</body>
</html>