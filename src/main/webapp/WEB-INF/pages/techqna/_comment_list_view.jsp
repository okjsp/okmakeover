<%--
User: langerhans
Date: 2014. 02. 10.
Time: 오후 4:48
Description :
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="util" uri="http://www.okjsp.net/jstl/util" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

		<h4>Comments <small>${fn:length(comments)}</small></h4>
		<c:forEach items="${comments}" var="comment">
			<c:set var="commentuser" value="${comment.user}"></c:set>
			<div class="panel panel-success">
				<div class="panel-heading clearfix">
					<div class="pull-left">
						<span class="glyphicon glyphicon glyphicon glyphicon-ok"></span>
						<img src="/assets/images/@temp_profile.jpg" class="profile-img"/> <a href="#">${commentuser.nickName}</a> | <small><fmt:formatDate type="both" value="${comment.writeDate}" dateStyle="short" timeStyle="short" /></small>
					</div>
<%--					
				    <div class="vote-btn btn-group">
				        <button type="button" class="btn btn-success btn-xs"><span class="glyphicon glyphicon-thumbs-up"></span></button>
				        <button type="button" class="btn btn-default btn-xs disabled">1000</button>
				        <button type="button" class="btn btn-warning btn-xs"><span class="glyphicon glyphicon-thumbs-down"></span></button>
				    </div>
--%>				    
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
