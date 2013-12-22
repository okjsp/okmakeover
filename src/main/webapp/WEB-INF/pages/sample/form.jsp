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

        <div class="form-group">
            <f:label path="title" cssClass="col-sm-2 control-label">제목</f:label>
            <div class="col-sm-8">
                <f:input path="title" cssClass="form-control" placeholder="제목을 입력해 주세요." />
            </div>
        </div>
        <div class="form-group">
            <f:label path="content" cssClass="col-sm-2 control-label">내용</f:label>
            <div class="col-sm-8">
                <f:textarea path="content" type="email" rows="10" cssClass="form-control" placeholder="내용을 입력해 주세요." />
            </div>
        </div>

        <div class="form-group">
            <div class="text-center">
                <input type="submit" class="btn btn-primary btn-mg" value="저장" role="button" />
                <a href="/sample/${categoryId}" id="cancelBtn" class="btn btn-default btn-mg" role="button">취소</a>
            </div>
        </div>

    </f:form>

</body>
</html>