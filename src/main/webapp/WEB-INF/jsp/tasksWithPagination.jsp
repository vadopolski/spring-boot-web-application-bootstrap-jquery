<html>
<head>
	<title>Welcome</title>
	<link href="/webjars/bootstrap/3.3.6/css/bootstrap.min.css"
		rel="stylesheet">
	<link href="/css/custom.css"
		rel="stylesheet">
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div class="container">
		<table class="table table-striped">
			<caption>Your todos are ${userName}</caption>
			<thead>
				<tr>
					<th>Description</th>
					<th>Target Date</th>
					<th>Is it Done?</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</thead>
            <tbody>
                <c:forEach var="listValue" items="${taskList}">
                    <tr>
                        <td>${listValue.name}</td>
                        <td>${listValue.date}</td>
                        <td>${listValue.isUrgent}</td>
                        <td><a class="btn btn-warning" href="/edit-todo">Edit Todo</a></td>
                        <td><a class="btn btn-warning" href="/delete-todo">Delete Todo</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
		<div>
			<a class="btn btn-default" href="/add-todo">Add a Todo</a>
		</div>
		<script src="/webjars/jquery/1.9.1/jquery.min.js"></script>
		<script src="/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		<script src="/js/custom.js"></script>
	</div>
</body>
</html>
