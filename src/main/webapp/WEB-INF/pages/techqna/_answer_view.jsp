<%--
User: langerhans
Date: 2014. 02. 10.
Time: 오후 4:48
Description :
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="util" uri="http://www.okjsp.net/jstl/util" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<c:set var="user" value="${item.user}"></c:set>
<c:set var="recommendOper" value="${item.boardRecommendOperator}"></c:set>
<p><img src="/assets/images/@temp_profile.jpg" class="profile-img"/> <a href="#">${user.nickName}</a> | <small><fmt:formatDate type="both" value="${item.writeDate}" dateStyle="short" timeStyle="short" /></small></p>
<div class="lead">
    <p>${util:nlToBr(item.content)}</p>
    <%--
       <div class="panel panel-default">
        <div class="panel-heading"><h4 class="panel-title">Attachments</h4></div>
        <div class="list-group">
            <a href="#" class="list-group-item"><span class="glyphicon glyphicon-file"></span> filename.doc</a>
            <a href="#" class="list-group-item"><span class="glyphicon glyphicon-picture"></span> filename.jpg</a>
        </div>
    </div>
    --%>
</div>

<sec:authorize ifAnyGranted="ROLE_USER">
    <div class="btn-group pull-left">
        <a href="/techqna/${boardId}/${categoryId}/${writeNo}/answer/${item.writeNo}/good" class="btn btn-success"><span class="glyphicon glyphicon-thumbs-up"></span></a>
        <button type="button" class="btn btn-default disabled">${recommendOper.getRecommendOpposeCount()}</button>
        <a href="/techqna/${boardId}/${categoryId}/${writeNo}/answer/${item.writeNo}/bad" class="btn btn-warning"><span class="glyphicon glyphicon-thumbs-down"></span></a>
    </div>
    <div class="pull-right">
        <a href="/techqna/${boardId}/${categoryId}/${writeNo}/answer/${item.writeNo}/modify" id="modifyBtn" class="btn btn-default btn-mg" role="button">수정</a>
        <button type="button" class="btn btn-default btn-mg" role="button">책갈피</button>
            <%--
                        <a href="/techqna/${boardId}/${categoryId}" class="btn btn-default btn-mg" role="button">목록</a>
            --%>
    </div>
</sec:authorize>
<%--	
	<sec:authorize ifNotGranted="ROLE_USER">
		<div class="pull-right">
		    <a href="/techqna/${boardId}/${categoryId}" class="btn btn-default btn-mg" role="button">목록</a>
		</div>
	</sec:authorize>
--%>
<div class="comments">
    <c:set var="comments" value="${item.commentList}"></c:set>
    <%@ include file="_comment_list_view.jsp"%>

    <sec:authorize ifAnyGranted="ROLE_USER">
        <f:form commandName="comment" cssClass="form-horizontal" role="form" method="POST"
                action="/techqna/${boardId}/${categoryId}/${writeNo}/answer/${item.writeNo}/comment">
            <div class="panel panel-default">

                <%@ include file="_comment_form.jsp"%>

                <div class="form-group">
                    <div class="text-center">
                        <input type="submit" class="btn btn-success btn-lg" value="저장" role="button" />
                    </div>
                </div>
            </div>
        </f:form>
    </sec:authorize>
</div>


