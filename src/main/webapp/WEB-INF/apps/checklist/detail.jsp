<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<head>
	<title>Checklist - ${checklist.name}</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/apps/checklist.css" />
	<script type="text/javascript">var contextRoot = '${pageContext.request.contextPath}';</script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/apps/checklist.js"></script>
</head>
<body class="checklist detail">
	<div id="upper-main">
		<h2>${checklist.name}</h2>
		<form:form modelAttribute="checklist" method="POST" cssClass="checklist">
			<form:input path="name" cssClass="name" /> <input type="submit" class="rename" value="Rename" />
			<input type="hidden" id="nextIndex" value="${fn:length(checklist.tasks)}"/>
			
			<ul>
			<c:forEach items="${checklist.tasks}"  var="task" varStatus="status">
			
				<li class="${task.completed ? 'completed' : 'uncompleted'}">
					<form:checkbox path="tasks[${status.index}].completed" label="${task.description}"  />
					<form:hidden path="tasks[${status.index}].description" value="${task.description}" />
				</li>
				
			</c:forEach>
			</ul>
			
			<input id="newTask" /> <input type="button" class="addTask" value="Add Task" />
			
			<div class="saveWrapper">
				<input type="submit" class="save" value="Save Changes" />
			</div>
		</form:form>
		
		<a href="${pageContext.request.contextPath}/checklist/" class="back">Back</a>

	</div>
</body>
