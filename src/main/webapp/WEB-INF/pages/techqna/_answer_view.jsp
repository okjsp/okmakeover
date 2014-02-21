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
	
	<c:set var="user" value="${item.user}"></c:set>
	<c:set var="recommendOper" value="${question.boardRecommendOperator}"></c:set>
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
		<form id="removeForm" method="post" action="/techqna/${boardId}/${categoryId}/${item.writeNo}">
		    <input type="hidden" name="_method" value="delete"/>
		    <sec:authentication  property="principal.userId" var="secUserId" />
				<div class="btn-group pull-left">
				    <button type="button" class="btn btn-success"><span class="glyphicon glyphicon-thumbs-up"></span></button>
				    <button type="button" class="btn btn-default disabled">${recommendOper.getRecommendOpposeCount()}</button>
				    <button type="button" class="btn btn-warning"><span class="glyphicon glyphicon-thumbs-down"></span></button>
				</div>
				<div class="pull-right">
					<c:if test="${item.userId == secUserId}">
						<button type="submit" id="deleteBtn" class="btn btn-default btn-mg" role="button">삭제</button>
						<a href="/techqna/${boardId}/${categoryId}/${item.writeNo}/modify" id="modifyBtn" class="btn btn-default btn-mg" role="button">수정</a>
					</c:if>
					<button type="button" class="btn btn-default btn-mg" role="button">책갈피</button>
					<a href="/techqna/${boardId}/${categoryId}" class="btn btn-default btn-mg" role="button">목록</a>
		    	</div>
		</form>
	</sec:authorize>
	<sec:authorize ifNotGranted="ROLE_USER">
		<div class="pull-right">
		    <a href="/techqna/${boardId}/${categoryId}" class="btn btn-default btn-mg" role="button">목록</a>
		</div>
	</sec:authorize>
	<div class="comments">
		<c:set var="comments" value="${item.commentList}"></c:set>
		<h4>Comments <small>${fn:length(comments)}</small></h4>
		<c:forEach items="${comments}" var="comment">
			<c:set var="commentuser" value="${comments.user}"></c:set>
			<div class="panel panel-success">
				<div class="panel-heading clearfix">
					<div class="pull-left">
						<span class="glyphicon glyphicon glyphicon glyphicon-ok"></span>
						<img src="/assets/images/@temp_profile.jpg" class="profile-img"/> <a href="#">${commentuser.nickName}</a> | <small><fmt:formatDate type="both" value="${comment.writeDate}" dateStyle="short" timeStyle="short" /></small>
					</div>
				    <div class="vote-btn btn-group">
				        <button type="button" class="btn btn-success btn-xs"><span class="glyphicon glyphicon-thumbs-up"></span></button>
				        <button type="button" class="btn btn-default btn-xs disabled">1000</button>
				        <button type="button" class="btn btn-warning btn-xs"><span class="glyphicon glyphicon-thumbs-down"></span></button>
				    </div>
				</div>
				<div class="panel-body">${util:nlToBr(comment.content)}</div>
			</div>
		</c:forEach>
<%--		
		<div class="panel panel-default">
			<div class="panel-heading clearfix">
				<div class="pull-left">
					<img src="/assets/images/@temp_profile.jpg" class="profile-img"/> <a href="#">langerhans</a> | <small>14. 1. 23 오후 8:17</small>
				</div>
				<div class="vote-btn btn-group">
					<button type="button" class="btn btn-success btn-xs"><span class="glyphicon glyphicon-thumbs-up"></span></button>
					<button type="button" class="btn btn-default btn-xs disabled">99</button>
					<button type="button" class="btn btn-warning btn-xs"><span class="glyphicon glyphicon-thumbs-down"></span></button>
				</div>
				<!-- 자신의 글은 삭제버튼 -->
				<button type="button" class="close" aria-hidden="true">&times;</button>
			</div>
			<div class="panel-body">
				코맨트 코맨트 코맨트 <br/>
				코맨트 코맨트 코맨트
			</div>
		</div>
--%>	
		<form method="post">
		    <div class="panel panel-default">
		        <div class="panel-heading">
		            <h4 class="panel-title">Input Comment</h4>
		        </div>
		        <div class="panel-body">
		            <textarea class="form-control"></textarea>
		        </div>
		
		        <div class="form-group">
		            <div class="text-center">
		                <input type="submit" class="btn btn-success btn-lg" value="저장" role="button" />
		            </div>
		        </div>
		    </div>
		</form>
	</div>
