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
        <h3>Tech Q&A - ${BOARD_NAMES[categoryId]}</h3>
    </div>

    <form id="boardForm" class="form-horizontal" role="form" method="post">

        <div class="form-group">
            <label for="title" class="col-sm-2 control-label">제목</label>
            <div class="col-sm-10">
                <input id="title" name="title" class="form-control" placeholder="제목을 입력해 주세요." type="text" value="asdasd"/>
            </div>
        </div>
        <div class="form-group">
            <label for="content" class="col-sm-2 control-label">내용</label>
            <div class="col-sm-10">
                <textarea id="content" name="content" class="form-control" placeholder="내용을 입력해 주세요." type="email" rows="10">asdasdasd</textarea>
            </div>
        </div>
        <div class="form-group">
            <label for="content" class="col-sm-2 control-label">첨부파일</label>
            <div class="col-sm-10">
                <input type="file" class="form-control" />
            </div>
        </div>
        <div class="form-group">
            <label for="content" class="col-sm-2 control-label">Tag</label>
            <div class="col-sm-10">
                <input id="tag" name="tag" class="form-control" type="text" />
            </div>
        </div>

        <div class="form-group">
            <div class="text-center">
                <input type="submit" class="btn btn-success btn-mg" value="저장" role="button" />
                <a href="list.jsp" id="cancelBtn" class="btn btn-default btn-mg" role="button">취소</a>
            </div>
        </div>

    </form>
</div>

</body>
</html>