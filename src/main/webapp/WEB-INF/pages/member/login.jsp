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
    <form class="form-signin" method="post" action="/user/login/process" role="form">
        <h2 class="form-signin-heading">로그인</h2>
        <input type="text" class="form-control" placeholder="아이디" required autofocus>
        <input type="password" class="form-control" placeholder="비밀번호" required>
        <label class="checkbox">
            <input type="checkbox" value="remember-me"> 자동 로그인
        </label>
        <button class="btn btn-lg btn-primary btn-block" type="submit">로그인</button>
    </form>
</body>
</html>
