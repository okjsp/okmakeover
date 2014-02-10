<%--
User: langerhans
Date: 2014. 02. 10.
Time: 오후 4:48
Description :
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="ko">
<head>
    <meta name="decorator" content="basic" />
</head>
<body>
    <div class="col-md-9">
        <div class="page-header">
            <h3>쪽지</h3>
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

            <ul class="nav nav-tabs">
                <li class="active"><a href="message_list.jsp">받은 쪽지함</a></li>
                <li><a href="message_list.jsp">보낸 쪽지함</a></li>
            </ul>

            <a href="message_view.jsp" class="list-group-item">
                <span class="badge"><span class="glyphicon glyphicon glyphicon-comment"></span></span>
                <p class="list-group-item-text"><img src="/assets/images/@temp_profile.jpg" class="profile-img"/> langerhans | 14. 1. 23 오후 8:17</p>
                <p>내용내용내용</p>
            </a>

            <a href="message_view.jsp" class="list-group-item">
                <span class="badge"><span class="glyphicon glyphicon glyphicon-comment"></span></span>
                <p class="list-group-item-text"><img src="/assets/images/@temp_profile.jpg" class="profile-img"/> langerhans | 14. 1. 23 오후 8:17</p>
                <p>내용내용내용</p>
            </a>

            <a href="message_view.jsp" class="list-group-item">
                <span class="badge"><span class="glyphicon glyphicon glyphicon-comment"></span></span>
                <p class="list-group-item-text"><img src="/assets/images/@temp_profile.jpg" class="profile-img"/> langerhans | 14. 1. 23 오후 8:17</p>
                <p>내용내용내용</p>
            </a>

            <a href="message_view.jsp" class="list-group-item">
                <p class="list-group-item-text"><img src="/assets/images/@temp_profile.jpg" class="profile-img"/> langerhans | 14. 1. 23 오후 8:17</p>
                <p>내용내용내용</p>
            </a>

            <a href="message_view.jsp" class="list-group-item">
                <p class="list-group-item-text"><img src="/assets/images/@temp_profile.jpg" class="profile-img"/> langerhans | 14. 1. 23 오후 8:17</p>
                <p>내용내용내용</p>
            </a>

            <a href="message_view.jsp" class="list-group-item">
                <p class="list-group-item-text"><img src="/assets/images/@temp_profile.jpg" class="profile-img"/> langerhans | 14. 1. 23 오후 8:17</p>
                <p>내용내용내용</p>
            </a>

            <a href="message_view.jsp" class="list-group-item">
                <p class="list-group-item-text"><img src="/assets/images/@temp_profile.jpg" class="profile-img"/> langerhans | 14. 1. 23 오후 8:17</p>
                <p>내용내용내용</p>
            </a>

            <a href="message_view.jsp" class="list-group-item">
                <p class="list-group-item-text"><img src="/assets/images/@temp_profile.jpg" class="profile-img"/> langerhans | 14. 1. 23 오후 8:17</p>
                <p>내용내용내용</p>
            </a>

            <a href="message_view.jsp" class="list-group-item">
                <p class="list-group-item-text"><img src="/assets/images/@temp_profile.jpg" class="profile-img"/> langerhans | 14. 1. 23 오후 8:17</p>
                <p>내용내용내용</p>
            </a>

            <a href="message_view.jsp" class="list-group-item">
                <p class="list-group-item-text"><img src="/assets/images/@temp_profile.jpg" class="profile-img"/> langerhans | 14. 1. 23 오후 8:17</p>
                <p>내용내용내용</p>
            </a>
        </div>

        <div class="pull-left">
            <a href="#" class="btn btn-default btn-mg">< 이전</a>&nbsp;
            <a href="#" class="btn btn-default btn-mg">다음 ></a>
        </div>
        <div class="pull-right">
            <a href="message_form.jsp" class="btn btn-primary" role="button">새 쪽지</a>
        </div>
    </div>
</body>
</html>