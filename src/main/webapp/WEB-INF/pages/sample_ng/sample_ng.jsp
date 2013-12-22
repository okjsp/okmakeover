<%--
  User: langerhans
  Date: 2013. 10. 30.
  Time: 오전 1:32
  Description :
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="SampleBoard">
<head>
    <meta name="decorator" content="basic" />
    <base href="/sample_ng/" />
</head>
<body>
    <div class="page-header">
        <h3>Sample Board</h3>
    </div>

    <div ng-view>
    </div>


    <content tag="script">
        <script src="/components/angular.min.js"></script>
        <script src="/components/angular-route.min.js"></script>
        <script src="/components/angular-resource.min.js"></script>
        <script src="/components/i18n/angular-locale_ko-kr.js"></script>
        <script src="/app/sample/sampleBoard.js"></script>
    </content>
</body>
</html>