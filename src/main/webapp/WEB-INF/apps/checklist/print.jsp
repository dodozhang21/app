<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
	<title>Checklist - Print - ${checklist.name}</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/apps/checklist.css" />
</head>
<body class="checklist">
	<section id="checklist">
	<h2>${checklist.name}</h2>
	
	<ul>
	<c:forEach items="${checklist.tasks}"  var="task">
	
		<li class="${task.completed ? 'completed' : ''}">
			${task.description}
		</li>
		
	</c:forEach>
	</ul>
	</section>
	
</body>