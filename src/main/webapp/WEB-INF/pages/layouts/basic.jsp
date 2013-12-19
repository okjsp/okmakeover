<%--
  User: langerhans
  Date: 2013. 10. 30.
  Time: 오전 1:41
  Description : 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>

<html lang="ko"<decorator:getProperty property="ng-app" writeEntireProperty="true" />>
<head>
    <meta charset="utf-8">
    <title><decorator:title default="OKJSP" /></title>

    <link rel="stylesheet" href="/assets/css/bootstrap.css" />
    <link rel="stylesheet" href="/assets/css/bootstrap-theme.css" />
    <link rel="stylesheet" href="/assets/css/custom.css" />

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <decorator:head />
</head>
<body<decorator:getProperty property="body.ng-controller" writeEntireProperty="true" />>
<div id="wrap">
    <div class="navbar navbar-default navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/">OK JSP</a>
            </div>
            <div class="collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#">Cummunity</a></li>
                    <li><a href="#">Tech Q&A</a></li>
                    <li><a href="#">Job</a></li>
                </ul>

                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#">Signup</a></li>
                    <li><a href="#">Log in</a></li>
                </ul>
            </div><!--/.nav-collapse -->
        </div>
    </div>

    <div class="container">

        <decorator:body  />

    </div><!-- /.container -->
</div>

<div id="footer">
    <div class="container">
        <p class="text-muted">okjsp.net 2013</p>
    </div>
</div>

<script src="/components/require.js"></script>
<script src="/app/app.js?v=1387207266"></script>

<decorator:getProperty property="page.script"/>

</body>
</html>