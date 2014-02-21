<%--
User: langerhans
Date: 2014. 02. 10.
Time: 오후 4:48
Description :
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
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
                action="/techqna/${boardId}/${categoryId}/">
            <div class="form-group">
                <f:label path="qnaTitle" cssClass="col-sm-2 control-label">제목</f:label>
                <div class="col-sm-10">
                    <f:input path="qnaTitle" cssClass="form-control" placeholder="제목을 입력해 주세요."/>
                    <f:errors path="qnaTitle" cssClass="help-block" />
                </div>
            </div>
            <div class="form-group">
                <f:label path="content" class="col-sm-2 control-label">내용</f:label>
                <div class="col-sm-10">
                    <f:textarea path="content" cssClass="form-control" placeholder="내용을 입력해 주세요." rows="10"></f:textarea>
                </div>
            </div>
            <%-- 
            <div class="form-group">
                <label for="content" class="col-sm-2 control-label">첨부파일</label>
                <div class="col-sm-10">
                    <input type="file" class="form-control" />
                </div>
            </div>
            --%>
             
            <div class="form-group">
                <f:label path="tagList" cssClass="col-sm-2 control-label">Tag</f:label>
                <div class="col-sm-10">
                    <%-- <input id="tagList" name="tag" class="form-control" type="text" /> --%>
                    <f:input path="tagList" cssClass="form-control"/>
                    <f:errors path="tagList" cssClass="help-block" />
                </div>
            </div>

            <div class="form-group">
                <div class="text-center">
                    <input type="submit" class="btn btn-success btn-mg" value="저장" role="button" />
                    <a href="/techqna/${boardId}/${categoryId}" id="cancelBtn" class="btn btn-default btn-mg" role="button">취소</a>
                </div>
            </div>

        </f:form>
    </div>

</body>
</html>