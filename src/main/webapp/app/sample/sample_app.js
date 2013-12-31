(function() {

    /**
     * Initialize Module
     */
    var sampleApp = angular.module('SampleApp', ['ngRoute', 'ngResource']);

    /**
     * Module Config
     */
    sampleApp.config(function($routeProvider, $locationProvider) {

        /**
         * HTML5에서 지원하는 History API 를 이용한다.
         * History API를 지원하지 않는 브라우져에서는 hashBang 방식을 이용한다.
         *
         * 이를 이용할 경우 $route를 이용한 페이지에서 a href 는 페이지 이동이 아닌 stateChage만 일어난다.
         * 그러므로 만약 페이지 이동을 시켜야 될 겨우에는 a 에 target="_self" 를 지정해줘야 한다.
         */
        $locationProvider.html5Mode(true).hashPrefix('!');

        /**
         * Route Config
         * URL에 따라 호출되는 controller 와 templateUrl을 지정한다.
         * 그러면 해당 url 이 호출 될 경우 지정된 controller에서 $scope 에 값을 셋팅 후
         * template 에 $scope 에 저장된 값들이 bind 된다.
         */
        $routeProvider
            .when('/:categoryId', {
                controller: 'SampleListCtrl',
                templateUrl: '/tmpl/sample/sample_list.html'
            })
            .when('/:categoryId/view/:id', {
                controller: 'SampleViewCtrl',
                templateUrl: '/tmpl/sample/sample_view.html'
            })
            .when('/:categoryId/modify/:id', {
                controller: 'SampleModifyCtrl',
                templateUrl: '/tmpl/sample/sample_form.html'
            })
            .when('/:categoryId/create', {
                controller: 'SampleCreateCtrl',
                templateUrl: '/tmpl/sample/sample_form.html'
            });
    });


    /**
     * Factories
     *$resource를 이용하여 서버와 RESTful 통신을 하는 ORM Style의 기능을 구현 한다.
     *
     * 예)
     * Sample.query() > GET /sample_ng/1
     * Sample.get({id: 1}) > GET /sample_ng/1/view/1
     * sample.$save() > POST /sample/1  (sample instance 에 id가 없을 경우)
     * sample.$save() > POST /sample/1/1  (sample instance 에 id가 있을 경우)
     * sample.$remove()  > DELETE /sample/1/1
     *
     */
    sampleApp.factory('Sample', function($resource, $routeParams){

        // java의 net.okjsp.sample.SampleNgController 확인
        return $resource('/sample_ng/:categoryId/:id.json',
            {
                categoryId: $routeParams.categoryId,
                id:'@id'
            },
            {
                /**
                 * 목록 JSON 에 Paging 정보를 추가해서 넘기기 위해 list Method를 구현한다.
                 */
                list: {
                    method: 'GET'
                }
            });

    });


    /**
     * Controllers
     */
    // List Controller
    sampleApp.controller('SampleListCtrl', function($scope, $routeParams, $location, Sample) {
        $scope.categoryId = $routeParams.categoryId;

        Sample.list({page: $routeParams.page}, function(data) {
            $scope.samples = data.list;
            $scope.paging = data.paging;
        });

    });

    // View Controller
    sampleApp.controller('SampleViewCtrl', function($scope, $location, $routeParams, Sample) {
        $scope.categoryId = $routeParams.categoryId;
        $scope.sample = Sample.get({id: $routeParams.id});

        $scope.remove = function() {
            if(confirm("게시물을 삭제하시겠습니까?")) {
                $scope.sample.$remove(function(u, responseHeaders) {
                    $location.path('/'+$routeParams.categoryId);
                });
            }
        }
    });

    // Modify Controller
    sampleApp.controller('SampleModifyCtrl', function($scope, $location, $routeParams, Sample) {
        $scope.categoryId = $routeParams.categoryId;
        $scope.sample = Sample.get({id: $routeParams.id});

        $scope.save = function() {
            $scope.sample.$save(function(u, responseHeaders) {
                $location.path('/'+$routeParams.categoryId);
            });
        };

        $scope.cancel = function() {
            window.history.back();
        };
    });

    // Create Controller
    sampleApp.controller('SampleCreateCtrl', function($scope, $location, $route, $routeParams, Sample) {
        $scope.categoryId = $routeParams.categoryId;
        $scope.sample = new Sample({categoryId: $routeParams.categoryId});

        $scope.save = function() {
            $scope.sample.$save(function(u, responseHeaders) {
                $location.path('/'+$routeParams.categoryId);
            });
        };

        $scope.cancel = function() {
            window.history.back();
        };
    });
})();