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
            <h3>Tech Q&A</h3>
        </div>

        <h2>게시물 제목</h2>
        <p><img src="/assets/images/@temp_profile.jpg" class="profile-img"/> <a href="#">langerhans</a> | <small>14. 1. 23 오후 8:17</small></p>
        <div class="lead">
            <p>
                게시물 내용내용내용<br/>
                게시물 내용내용내용<br/>
                게시물 내용내용내용
            </p>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading"><h4 class="panel-title">Attachments</h4></div>
            <div class="list-group">
                <a href="#" class="list-group-item"><span class="glyphicon glyphicon-file"></span> filename.doc</a>
                <a href="#" class="list-group-item"><span class="glyphicon glyphicon-picture"></span> filename.jpg</a>
            </div>
        </div>

        <form id="removeForm" method="post">
            <input type="hidden" name="_method" value="delete"/>
            <div class="btn-group pull-left">
                <button type="button" class="btn btn-success"><span class="glyphicon glyphicon-thumbs-up"></span></button>
                <button type="button" class="btn btn-default disabled">1000</button>
                <button type="button" class="btn btn-warning"><span class="glyphicon glyphicon-thumbs-down"></span></button>
            </div>
            <div class="pull-right">
                <button type="submit" id="deleteBtn" class="btn btn-default btn-mg" role="button">삭제</button>
                <a href="form.jsp" id="modifyBtn" class="btn btn-default btn-mg" role="button">수정</a>
                <button type="button" class="btn btn-default btn-mg" role="button">책갈피</button>
                <a href="list.jsp" class="btn btn-default btn-mg" role="button">목록</a>
            </div>
        </form>

        <div class="comments">
            <h4>Comments <small>20</small></h4>
            <div class="panel panel-success">
                <div class="panel-heading clearfix">
                    <div class="pull-left">
                        <span class="glyphicon glyphicon glyphicon glyphicon-ok"></span>
                        <img src="/assets/images/@temp_profile.jpg" class="profile-img"/> <a href="#">langerhans</a> | <small>14. 1. 23 오후 8:17</small>
                    </div>
                    <div class="vote-btn btn-group">
                        <button type="button" class="btn btn-success btn-xs"><span class="glyphicon glyphicon-thumbs-up"></span></button>
                        <button type="button" class="btn btn-default btn-xs disabled">1000</button>
                        <button type="button" class="btn btn-warning btn-xs"><span class="glyphicon glyphicon-thumbs-down"></span></button>
                    </div>
                </div>
                <div class="panel-body">
                    코맨트 코맨트 코맨트 <br/>
                    코맨트 코맨트 코맨트
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading clearfix">
                    <div class="pull-left">
                        <img src="/assets/images/@temp_profile.jpg" class="profile-img"/> <a href="#">langerhans</a> | <small>14. 1. 23 오후 8:17</small>
                    </div>
                    <div class="vote-btn btn-group">
                        <button type="button" class="btn btn-success btn-xs"><span class="glyphicon glyphicon-thumbs-up"></span></button>
                        <button type="button" class="btn btn-default btn-xs disabled">99</button>
                        <button type="button" class="btn btn-warning btn-xs"><span class="glyphicon glyphicon-thumbs-down"></span></button>
                    </div>
                    <!-- 자신의 글은 삭제버튼 -->
                    <button type="button" class="close" aria-hidden="true">&times;</button>
                </div>
                <div class="panel-body">
                    코맨트 코맨트 코맨트 <br/>
                    코맨트 코맨트 코맨트
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading clearfix">
                    <div class="pull-left">
                        <img src="/assets/images/@temp_profile.jpg" class="profile-img"/> <a href="#">langerhans</a> | <small>14. 1. 23 오후 8:17</small>
                    </div>
                    <div class="vote-btn btn-group">
                        <button type="button" class="btn btn-success btn-xs"><span class="glyphicon glyphicon-thumbs-up"></span></button>
                        <button type="button" class="btn btn-default btn-xs disabled">33</button>
                        <button type="button" class="btn btn-warning btn-xs"><span class="glyphicon glyphicon-thumbs-down"></span></button>
                    </div>
                </div>
                <div class="panel-body">
                    코맨트 코맨트 코맨트 <br/>
                    코맨트 코맨트 코맨트
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading clearfix">
                    <div class="pull-left">
                        <img src="/assets/images/@temp_profile.jpg" class="profile-img"/> <a href="#">langerhans</a> | <small>14. 1. 23 오후 8:17</small>
                    </div>
                    <div class="vote-btn btn-group">
                        <button type="button" class="btn btn-success btn-xs"><span class="glyphicon glyphicon-thumbs-up"></span></button>
                        <button type="button" class="btn btn-default btn-xs disabled">44</button>
                        <button type="button" class="btn btn-warning btn-xs"><span class="glyphicon glyphicon-thumbs-down"></span></button>
                    </div>
                </div>
                <div class="panel-body">
                    코맨트 코맨트 코맨트 <br/>
                    코맨트 코맨트 코맨트
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading clearfix">
                    <div class="pull-left">
                        <img src="/assets/images/@temp_profile.jpg" class="profile-img"/> <a href="#">langerhans</a> | <small>14. 1. 23 오후 8:17</small>
                    </div>
                    <div class="vote-btn btn-group">
                        <button type="button" class="btn btn-success btn-xs"><span class="glyphicon glyphicon-thumbs-up"></span></button>
                        <button type="button" class="btn btn-default btn-xs disabled">11</button>
                        <button type="button" class="btn btn-warning btn-xs"><span class="glyphicon glyphicon-thumbs-down"></span></button>
                    </div>
                </div>
                <div class="panel-body">
                    코맨트 코맨트 코맨트 <br/>
                    코맨트 코맨트 코맨트
                </div>
            </div>

            <form method="post">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">Input Comment</h4>
                    </div>
                    <div class="panel-body">
                        <textarea class="form-control"></textarea>
                    </div>

                    <div class="form-group">
                        <div class="text-center">
                            <input type="submit" class="btn btn-success btn-lg" value="저장" role="button" />
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</body>
</html>