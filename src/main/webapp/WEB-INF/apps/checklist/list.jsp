<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>

<head>
	<title>Checklist</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/apps/checklist.css" />
	<script type="text/javascript">var contextRoot = '${pageContext.request.contextPath}';</script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/apps/checklist.js"></script>
</head>
<body class="checklist">
	<div id="upper-main">
		<c:if test="${!empty userLists}">
			<h2 class="userLists">My Lists</h2>
			<ul class="userLists">
				<c:forEach items="${userLists}" var="checklist">
					<li>
						<a class="checklist" href="detail/${checklist.id}">${checklist.name}</a>
						<span class="lastUpdated"><joda:format value="${checklist.lastUpdated}" style="SM" /></span>
					</li>
				</c:forEach>
			</ul>
		</c:if>
		<h2 class="otherLists">Other Lists</h2>
		<ul class="otherLists">
			<c:forEach items="${lists}" var="checklist">
				<li>
					<a class="checklist" href="detail/${checklist.id}">${checklist.name}</a>
					<span class="lastUpdated"><joda:format value="${checklist.lastUpdated}" style="SM" /></span>
				</li>
			</c:forEach>
		</ul>
		
		
		
	
		<div id="dialog-modal" title="Your Username" class="hide">
			<p>Please enter your username:</p>
			<p><input id="username" /></p>
		</div>
	</div>
</body>
