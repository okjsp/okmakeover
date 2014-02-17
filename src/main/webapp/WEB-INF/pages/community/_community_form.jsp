<%--
  User: langerhans
  Date: 2014. 02. 10.
  Time: 오후 4:48
  Description :
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

    <div class="form-group">
        <f:label path="title" cssClass="col-sm-2 control-label">제목</f:label>
        <div class="col-sm-10">
            <f:input path="title" cssClass="form-control" placeholder="제목을 입력해 주세요." />
            <f:errors path="title" cssClass="help-block" />
        </div>
    </div>
    <div class="form-group">
        <f:label path="content" cssClass="col-sm-2 control-label">내용</f:label>
        <div class="col-sm-10">
            <f:textarea path="content" cssClass="form-control" placeholder="내용을 입력해 주세요." rows="10"></f:textarea>
        </div>
    </div>
    <%--<div class="form-group">
        <f:label path="attachFile" cssClass="col-sm-2 control-label">첨부파일</f:label>
        <div class="col-sm-10">
            <f:input path="attachFile" type="file" class="form-control" />
        </div>
    </div>--%>