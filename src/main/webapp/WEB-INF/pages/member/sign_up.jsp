<%--
  User: langerhans
  Date: 2013. 12. 26.
  Time: 오후 2:27
  Description : 회원 로그인 폼
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="decorator" content="basic" />
</head>
<body>
    <form class="form-signup form-horizontal" name="signupForm" role="form">
        <h2 class="form-signin-heading">회원가입</h2>
        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">이름</label>
            <div class="col-sm-10">
                <input type="text" id="name" class="form-control" placeholder="실명" required="true" />
            </div>
        </div>
        <div class="form-group">
            <label for="loginId" class="col-sm-2 control-label">아이디</label>
            <div class="col-sm-10">
                <input type="text" id="loginId" class="form-control" placeholder="영문소문자 숫자 _ 조합 4-12자리" required="true" />
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-sm-2 control-label">비밀번호</label>
            <div class="col-sm-10">
                <input type="password" id="password" class="form-control" placeholder="영문 숫자 특수문자 조합 6-" required="true" />
            </div>
        </div>
        <div class="form-group">
            <label for="passwordConfirm" class="sr-only control-label">비밀번호 재입력</label>
            <div class="col-sm-push-2 col-sm-10">
                <input type="password" id="passwordConfirm" class="form-control" placeholder="비밀번호 재입력" required="true" />
            </div>
        </div>
        <div class="form-group">
            <label for="nickName" class="col-sm-2 control-label">닉네임</label>
            <div class="col-sm-10">
                <input type="text" id="nickName" class="form-control" placeholder="닉네임" required="true" />
            </div>
        </div>
        <div class="form-group">
            <label for="email" class="col-sm-2 control-label">이메일</label>
            <div class="col-sm-10">
                <input type="email" id="email" class="form-control" placeholder="이메일 (example@okjsp.net)" required="true" />
            </div>
        </div>
        <div class="form-group">
            <label for="tel" class="col-sm-2 control-label">연락처</label>
            <div class="col-sm-10">
                <input type="tel" id="tel" class="form-control" placeholder="연락처 (000-0000-0000)" required="true" />
            </div>
        </div>

        <div class="form-group">
            <div class="text-center">
                <button type="button" ng-click="save()" class="btn btn-primary btn-mg" role="button" ng-disabled="sampleForm.$invalid">저장</button>
                <button type="button" ng-click="cancel()" class="btn btn-default btn-mg" role="button">취소</button>
            </div>
        </div>
    </form>
</body>
</html>
