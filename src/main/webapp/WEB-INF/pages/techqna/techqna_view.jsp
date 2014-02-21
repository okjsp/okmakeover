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
        
        <c:set var="item" value="${question}"></c:set>
        <%@ include file="_question_view.jsp"%>
        
		<c:forEach items="${answers}" var="item">
        	<%@ include file="_answer_view.jsp"%>
		</c:forEach>
		
		<sec:authorize ifAnyGranted="ROLE_USER">	
			<f:form commandName="answer" id="answserForm" cssClass="form-horizontal" role="form" method="POST"
					action="/techqna/${boardId}/${categoryId}/${writeNo}/answer">
				
				<input type="hidden" name="tagList"/>
				
				<div class="form-group">
					<f:label path="content" class="col-sm-2 control-label">답변</f:label>
					<div class="col-sm-10">
						<f:textarea path="content" cssClass="form-control" placeholder="답변을 입력해 주세요." rows="10"></f:textarea>
					</div>
				</div>
            	
				<div class="form-group">
					<div class="text-center">
						<input type="submit" class="btn btn-success btn-mg" value="답변" role="button" />
					</div>
				</div>
			</f:form>
		</sec:authorize>
    </div>
</body>
</html>