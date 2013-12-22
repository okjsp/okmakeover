<%--
  User: langerhans
  Date: 2013. 10. 30.
  Time: 오전 1:32
  Description :
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta name="decorator" content="basic" />
</head>
<body>
    <div class="page-header">
        <h3>Sample Board</h3>
    </div>

    <div class="table-responsive">
        <table class="table table-hover">
            <colgroup>
                <col style="width:10%;" />
                <col  />
                <col style="width:20%;" />
                <col style="width:20%;" />
                <col style="width:10%;" />
            </colgroup>
            <thead>
            <tr>
                <th>No</th>
                <th>제목</th>
                <th>작성일</th>
                <th>이름</th>
                <th>조회수</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${samples}" var="sample">
            <tr>
                <td>${sample.id}</td>
                <td><a href="/sample/${categoryId}/${sample.id}">${sample.title}</a></td>
                <td><fmt:formatDate type="both" value="${sample.writeDate}" dateStyle="short" timeStyle="short" /> </td>
                <td>${sample.writeId}</td>
                <td>${sample.viewCount}</td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>


    <div class="col-sm-6">
        <c:if test="${paging.page > 1}">
            <a href="/sample_ng/${categoryId}?page=${paging.page-1}" class="btn btn-default btn-mg">< 이전</a>&nbsp;
        </c:if>
        <c:if test="${paging.lastIndex < paging.totalCount}">
            <a href="/sample_ng/${categoryId}?page=${paging.page+1}" class="btn btn-default btn-mg">다음 ></a>
        </c:if>
    </div>
    <div class="col-sm-6">
        <a href="/sample/${categoryId}/create" class="btn btn-primary pull-right" role="button">글쓰기</a>
    </div>
</body>
</html>