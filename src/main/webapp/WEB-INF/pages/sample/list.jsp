<%--
  User: langerhans
  Date: 2013. 10. 30.
  Time: 오전 1:32
  Description :
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="sampleBoard">
<head>
    <meta name="decorator" content="basic" />
</head>
<body ng-controller="ListCtrl">
    <div class="page-header">
        <h3>Sample Board</h3>
    </div>

    <div>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>No</th>
                <th>제목</th>
                <th>작성일</th>
                <th>이름</th>
                <th>조회수</th>
            </tr>
            </thead>
            <tbody>
            <tr ng-repeat="sample in Samples">
                <td>1</td>
                <td>test123123123</td>
                <td>2013/12/05</td>
                <td>tester</td>
                <td>12</td>
            </tr>
            </tbody>
        </table>
    </div>


    <content tag="script">
        <script type="text/javascript" src="/components/angular.min.js"></script>
        <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.5/angular-route.min.js"></script>
        <script>
            var sampleBoard = angular.module('sampleBoard', ['ngRoute'])
                    .config(function($routeProvider) {
                        $routeProvider
                                .when('/sample/:categoryId', {
                                    controller: 'ListCtrl',
                                    templateUrl: '/tmpl/sample/list.html'
                                });
                    })
                    .controller('ListCtrl', ['$scope', function() {
                        $scope.data = {};
                    }]);
        </script>
    </content>
</body>
</html>