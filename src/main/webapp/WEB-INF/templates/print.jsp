<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title><decorator:title default="Parents.com" /></title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/app.css" />
<decorator:head />
</head>

<body class="print <decorator:getProperty property="body.class" />">
	<a href="javascript:window.history.back()" class="back">Back</a>
	<decorator:body />

</body>
</html>