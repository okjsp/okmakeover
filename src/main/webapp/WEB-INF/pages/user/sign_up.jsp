<%--
  User: langerhans
  Date: 2013. 12. 26.
  Time: 오후 2:27
  Description : 회원 로그인 폼
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta name="decorator" content="basic" />
</head>
<body>
    <f:form commandName="userForm" method="post" class="form-signup form-horizontal" role="form">
        <h2 class="form-signin-heading">회원가입</h2>
        <f:errors path="*" cssClass="error" />
        <div class="form-group">
            <f:label path="name" class="col-sm-2 control-label">이름</f:label>
            <div class="col-sm-10">
                <f:input type="text" path="name" class="form-control" placeholder="실명" required="true" />
            </div>
        </div>
        <div class="form-group">
            <f:label path="password" class="col-sm-2 control-label">비밀번호</f:label>
            <div class="col-sm-10">
                <f:input type="password" path="password"  class="form-control" placeholder="영문 숫자 특수문자 조합 6-" required="true" />
            </div>
        </div>
        <div class="form-group">
            <f:label path="passwordConfirm" class="sr-only control-label">비밀번호 재입력</f:label>
            <div class="col-sm-push-2 col-sm-10">
                <f:input type="password" path="passwordConfirm" class="form-control" placeholder="비밀번호 재입력" required="true" />
            </div>
        </div>
        <div class="form-group">
            <f:label path="nickName" class="col-sm-2 control-label">닉네임</f:label>
            <div class="col-sm-10">
                <f:input type="text" path="nickName" class="form-control" placeholder="닉네임" required="true" />
            </div>
        </div>
        <div class="form-group">
            <f:label path="email" class="col-sm-2 control-label">이메일</f:label>
            <div class="col-sm-10">
                <f:input type="email" path="email" class="form-control" placeholder="이메일 (example@okjsp.net)" required="true" />
            </div>
        </div>
        <div class="form-group">
            <f:label path="tel" class="col-sm-2 control-label">연락처</f:label>
            <div class="col-sm-10">
                <f:input type="tel" path="tel" class="form-control" placeholder="연락처 (000-0000-0000)" required="true" />
            </div>
        </div>

        <div class="form-group">
            <div class="text-center">
                <button type="submit" class="btn btn-primary btn-mg" role="button" ng-disabled="sampleForm.$invalid">저장</button>
                <button type="button" class="btn btn-default btn-mg" role="button">취소</button>
            </div>
        </div>
    </f:form>
</body>
</html>
