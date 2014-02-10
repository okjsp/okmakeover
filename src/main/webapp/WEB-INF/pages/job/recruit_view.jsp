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
            <h3>구인</h3>
        </div>

        <h2>여의도 증권사 3개월 Java프로젝트 <small>프리랜서(계약직)</small></h2>

        <div class="form-horizontal job-view">

            <div class="form-group">
                <label class="col-sm-2 control-label">회사이름</label>
                <div class="col-sm-5">
                    <p class="form-control-static">좋은회사</p>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">담당자 연락처</label>
                <div class="col-sm-7">
                    <p class="form-control-static">000-0000-0000</p>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">근무지역</label>
                <div class="col-sm-3">
                    <p class="form-control-static">서울, 여의도</p>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">고용형태</label>
                <div class="col-sm-6">
                    <p class="form-control-static">프리랜서(계약직)</p>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">근무기간</label>
                <div class="col-sm-6">
                    <p class="form-control-static">20130112 ~ 20140112</p>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">복리후생</label>
                <div class="col-sm-10">
                    <p class="form-control-static">
                        <span class="label label-success">국민연금</span> <span class="label label-success">건강보험</span>
                    </p>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-2 control-label">기술키워드</label>
                <div class="col-sm-10">
                    <p class="form-control-static">
                        <span class="label label-info">Java</span> <span class="label label-info">JSP</span>
                    </p>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-2 control-label">업무내용</label>
                <div class="col-sm-10">
                    <p class="form-control-static">
                        웹개발 ...
                    </p>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">회사소개</label>
                <div class="col-sm-10">
                    <p class="form-control-static">
                        어려서부터 우리집은 가난했었고.<br/>
                        남들은 다하는 외식 몇 번 한적이 없었고.<br/>
                    </p>
                </div>
            </div>

        </div>

        <form id="removeForm" method="post">
            <input type="hidden" name="_method" value="delete"/>
            <div class="pull-right">
                <button type="submit" id="deleteBtn" class="btn btn-default btn-mg" role="button">삭제</button>
                <a href="hunting_form.jsp" id="modifyBtn" class="btn btn-default btn-mg" role="button">수정</a>
                <button type="button" class="btn btn-default btn-mg" role="button">책갈피</button>
                <a href="hunting_list.jsp" class="btn btn-default btn-mg" role="button">목록</a>
            </div>
        </form>

    </div>
</body>
</html>