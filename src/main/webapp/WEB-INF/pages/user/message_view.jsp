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

        <p><img src="/assets/images/@temp_profile.jpg" class="profile-img"/> <a href="#">langerhans</a> | <small>14. 1. 23 오후 8:17</small></p>
        <div class="lead">
            <p>
                쪽지내용 내용내용내용<br/>
                쪽지내용 내용내용내용<br/>
                쪽지내용 내용내용내용
            </p>
        </div>

        <form id="removeForm" method="post">
            <div class="pull-right">
                <button type="submit" id="deleteBtn" class="btn btn-default btn-mg" role="button">삭제</button>
                <a href="message_list.jsp" class="btn btn-default btn-mg" role="button">목록</a>
            </div>
        </form>

        <div class="comments">

            <form method="post">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">답장쓰기</h4>
                    </div>
                    <div class="panel-body">
                        <textarea class="form-control" rows="5"></textarea>
                    </div>

                    <div class="form-group">
                        <div class="text-center">
                            <input type="submit" class="btn btn-success btn-lg" value="보내기" role="button" />
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</body>
</html>