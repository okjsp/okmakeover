<%--
User: langerhans
Date: 2014. 02. 10.
Time: 오후 4:48
Description :
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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

        <div class="form-group clearfix">
            <form id="boardForm" class="form-inline" role="form" method="post">
                <div class="input-group col-xs-4 pull-right">
                    <input id="search" name="search" type="text" class="form-control" placeholder="검색" />
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="button"><span class="glyphicon glyphicon-search"></span></button>
                    </span>
                </div>
            </form>
        </div>

        <div class="list-group">
      		<c:forEach items="${questions}" var="question">
      		<c:set var="user" value="${question.user}"></c:set>
      		<div class="list-group-item clearfix">
                <span class="badge"><span class="glyphicon glyphicon glyphicon-comment"></span> 14</span>
                <div class="qna-point col-md-2">
                    <div>
                        <span class="glyphicon glyphicon-thumbs-up"></span>
                        <span>${question.recommendCount}</span>
                    </div>
                    <div>
                        <span class="glyphicon glyphicon glyphicon glyphicon-ok"></span>
                        <span>해결</span>
                    </div>
                </div>
                <div class="col-md-9">
                    <h4 class="list-group-item-heading"><a href="view.jsp">${question.qnaTitle}</a></h4>
                    <p class="list-group-item-text"><img src="/assets/images/@temp_profile.jpg" class="profile-img"/> <a href="#">${user.nickName}</a> | <fmt:formatDate type="both" value="${question.writeDate}" dateStyle="short" timeStyle="short" /></p>
                    <c:forEach items="${question.tagList}" var="tag">
                    <span class="label label-info">${tag.tagName}</span>
                    </c:forEach>
                </div>
            </div>
      		</c:forEach>  
        </div>

        <div class="pull-left">
            <a href="#" class="btn btn-default btn-mg">< 이전</a>&nbsp;
            <a href="#" class="btn btn-default btn-mg">다음 ></a>
        </div>
        <div class="pull-right">
            <a href="form.jsp" class="btn btn-primary" role="button">글쓰기</a>
        </div>
    </div>

</body>
</html>