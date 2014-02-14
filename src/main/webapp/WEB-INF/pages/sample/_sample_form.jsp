<%--
  User: langerhans
  Date: 2013. 12. 18.
  Time: 오후 5:29
  Description :
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
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