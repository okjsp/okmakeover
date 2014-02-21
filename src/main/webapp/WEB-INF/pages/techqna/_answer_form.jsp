<%--
User: langerhans
Date: 2014. 02. 10.
Time: 오후 4:48
Description :
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

            <f:hidden path="qnaTitle" />
            <f:hidden path="tagList" />
            
            <div class="form-group">
                <f:label path="content" class="col-sm-2 control-label">내용</f:label>
                <div class="col-sm-10">
                    <f:textarea path="content" cssClass="form-control" placeholder="내용을 입력해 주세요." rows="10"></f:textarea>
                </div>
            </div>
            <%-- 
            <div class="form-group">
                <label for="content" class="col-sm-2 control-label">첨부파일</label>
                <div class="col-sm-10">
                    <input type="file" class="form-control" />
                </div>
            </div>
            --%>
<%--            
            <div class="form-group">
                <f:label path="summary" cssClass="col-sm-2 control-label">수정내역</f:label>
                <div class="col-sm-10">
                    <f:input path="summary" cssClass="form-control"/>
                    <f:errors path="summary" cssClass="help-block" />
                </div>
            </div>
--%>
