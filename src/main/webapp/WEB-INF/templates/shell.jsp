<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title><decorator:title default="Parents.com" /></title>

<link rel="stylesheet" type="text/css" href="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/themes/smoothness/jquery-ui.min.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/app.css" />
 <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
 <script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>

<decorator:head />
</head>

<body class="shell <decorator:getProperty property="body.class" />">
	<div id="container">
	<header>
		header
	</header>
	
	<nav>
		nav
	</nav>
	
	<section id="upperMain">
		<decorator:getProperty property="div.upper-main"/>
	</section>
	
	<section id="upperRight">
		upper right ad
	</section>
	
	<section id="main">
		<decorator:getProperty property="div.lower-main"/>
	</section>
	
	<section id="right">
		right ad
	</section>
	
	</div>
	
	<footer>footer</footer>
	
	<decorator:body />
	
	<% /*
	<script src='http://localhost:3000/socket.io/socket.io.js'></script>
	<script src='http://localhost:3001/browser-sync-client.min.js'></script>
	*/ %>
</body>
</html>