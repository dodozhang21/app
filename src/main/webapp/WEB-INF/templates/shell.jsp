<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title><decorator:title default="Parents.com" /></title>

<link rel="stylesheet" type="text/css" href="<c:url value="css/app.css"/>" />

<decorator:head />
</head>

<body class="shell <decorator:getProperty property="body.class" />">
	<header>
		header
	</header>
	
	<nav>
		nav
	</nav>
	
	<section id="upperMain">
		<decorator:getProperty property="page.upperMain"/>
	</section>
	
	<section id="upperRight">
		upper right ad
	</section>
	
	<section id="main">
		<decorator:getProperty property="page.main"/>
	</section>
	
	<section id="right">
		right ad
	</section>
	
	<footer>footer</footer>
</body>