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
        <form id="boardForm" class="form-horizontal" role="form" method="post">

            <div class="form-group">
                <label for="title" class="col-sm-2 control-label">제목</label>
                <div class="col-sm-10">
                    <input id="title" name="title" class="form-control" type="text" />
                </div>
            </div>

            <div class="form-group">
                <label for="name" class="col-sm-2 control-label">회사이름</label>
                <div class="col-sm-5">
                    <input id="name" name="name" class="form-control" type="text" />
                </div>
            </div>
            <div class="form-group">
                <label for="tel" class="col-sm-2 control-label">담당자 연락처</label>
                <div class="col-sm-7">
                    <input id="tel" name="tel" class="form-control" type="text" />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">근무지역</label>
                <div class="col-sm-3">
                    <select class="form-control" id="location" name="location">
                        <option>모든 지역</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">고용형태</label>
                <div class="col-sm-6">
                    <select class="form-control">
                        <option>정규직(신입)</option>
                        <option>정규직(경력)</option>
                        <option>프리랜서(계약직)</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">근무기간</label>
                <div class="col-sm-6">
                    <div class="input-group">
                        <input id="start" name="start" class="form-control" placeholder="YYYYMMDD" type="text" />
                        <span class="input-group-addon">~</span>
                        <input id="end" name="start" class="form-control" placeholder="YYYYMMDD" type="text" />
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">복리후생</label>
                <div class="col-sm-10">
                    <label><input type="checkbox" /> 국민연금</label>
                    <label><input type="checkbox" /> 건강보험</label>
                    <label><input type="checkbox" /> 고용보험</label>
                    <label><input type="checkbox" /> 산재보험</label>
                    <label><input type="checkbox" /> 야근수당</label>
                    <label><input type="checkbox" /> 식대(점심)</label>
                    <label><input type="checkbox" /> 식대(저녁)</label>
                    <label><input type="checkbox" /> 교통비</label>
                    <label><input type="checkbox" /> 통신비</label>
                    <label><input type="checkbox" /> 퇴직금</label>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <label class="control-label">기타 :</label> <input id="etc" name="etc" class="form-control" type="text" />
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-2 control-label">기술키워드(Tag)</label>
                <div class="col-sm-10">
                    <input id="tag" name="tag" class="form-control" type="text" />
                    <span class="help-block">, 으로 구분하세요. 예) Java, JSP, AngularJS</span>
                </div>
            </div>

            <div class="form-group">
                <label for="content2" class="col-sm-2 control-label">업무내용</label>
                <div class="col-sm-10">
                    <textarea id="content2" name="content2" class="form-control" rows="10"></textarea>
                </div>
            </div>
            <div class="form-group">
                <label for="content" class="col-sm-2 control-label">회사소개</label>
                <div class="col-sm-10">
                    <textarea id="content" name="content" class="form-control" rows="10"></textarea>
                </div>
            </div>

            <div class="form-group">
                <div class="text-center">
                    <input type="submit" class="btn btn-success btn-mg" value="저장" role="button" />
                    <a href="hunting_list.jsp" id="cancelBtn" class="btn btn-default btn-mg" role="button">취소</a>
                </div>
            </div>

        </form>
    </div>
</body>
</html>