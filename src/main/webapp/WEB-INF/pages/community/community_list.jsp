<%--
  User: langerhans
  Date: 2014. 02. 10.
  Time: 오후 4:48
  Description :
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html lang="ko">
<head>
    <meta name="decorator" content="basic" />
</head>
<body>

    <div class="col-md-9">
        <div class="page-header">
            <h3>Community - ${BOARD_NAMES[categoryId]}</h3>
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
            <c:forEach items="${articles}" var="article">
            <div class="list-group-item">
                <span class="badge"><span class="glyphicon glyphicon glyphicon-comment"></span> ${article.commentCount}</span>
                <h4 class="list-group-item-heading"><a href="/community/${boardId}/${categoryId}/${article.writeNo}">${article.title}</a></h4>
                <p class="list-group-item-text">
                    <img src="/assets/images/@temp_profile.jpg" class="profile-img"/> <a href="#">${article.nickname}</a> | ${article.writeDate}
                </p>
            </div>
            </c:forEach>
            <c:if test="${fn:length(articles) == 0}">
                <div class="list-group-item">
                    <p class="list-group-item-text">게시물이 없습니다.</p>
                </div>
            </c:if>
        </div>

        <div class="pull-left">
            <c:if test="${paging.page > 1}">
                <a href="/community/${boardId}/${categoryId}?page=${paging.page-1}" class="btn btn-default btn-mg">< 이전</a>&nbsp;
            </c:if>
            <c:if test="${paging.lastIndex < paging.totalCount}">
                <a href="/community/${boardId}/${categoryId}?page=${paging.page+1}" class="btn btn-default btn-mg">다음 ></a>
            </c:if>
        </div>
        <div class="pull-right">
            <a href="/community/${boardId}/${categoryId}/create" class="btn btn-primary" role="button">글쓰기</a>
        </div>
    </div>

</body>
</html>