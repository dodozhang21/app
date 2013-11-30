<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>

<head>
	<title>Checklist</title>
	<script>var name = 'hi';</script>
</head>
<body class="checklist">
	<div id="upper-main">
		<c:if test="${!empty userLists}">
			<h2 class="userLists">My Lists</h2>
			<ul class="userLists">
				<c:forEach items="${userLists}" var="checklist">
					<li>
						<a href="detail/${checklist.id}">${checklist.name}</a>
						<span class="lastUpdated"><joda:format value="${checklist.lastUpdated}" style="SM" /></span>
					</li>
				</c:forEach>
			</ul>
		</c:if>
		<h2 class="otherLists">Other Lists</h2>
		<ul class="otherLists">
			<c:forEach items="${lists}" var="checklist">
				<li>
					<a href="detail/${checklist.id}">${checklist.name}</a>
					<span class="lastUpdated"><joda:format value="${checklist.lastUpdated}" style="SM" /></span>
				</li>
			</c:forEach>
		</ul>
	</div>
</body>
