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
		<div class="social">
			<a href="../print/${checklist.id}" class="print">Print</a>
		</div>
		<h2>${checklist.name}</h2>
		
		<% // spring form %>
		<form:form modelAttribute="checklist" method="POST" cssClass="checklist">
		
			<form:input path="name" cssClass="name" /> <input type="submit" class="rename" value="Rename" />
			<form:errors path="name" cssClass="error" />
			
			<input type="hidden" id="nextIndex" value="${fn:length(checklist.tasks)}"/>
			
			<ul>
			<c:forEach items="${checklist.tasks}"  var="task" varStatus="status">
			
				<li class="${task.completed ? 'completed' : ''}">
					${task.description}
					<form:checkbox path="tasks[${status.index}].completed" />
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
	
	<script type="text/javascript">Checklist(contextRoot);</script>
</body>
