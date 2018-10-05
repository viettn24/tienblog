<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!Doctype=html>
<html>
<head>
	<title>Add New Post</title>
</head>
	<form:form action="savePost" modelAttribute="newPost" method="POST">
		<form:hidden path="id"/>
		Tittle: <form:input path="tittle"/>
		Content: <form:input path="body"/>
		Author: <form:input path="author"/>
		Date: <form:input path="date"/>
		<input type="submit" value="Save Post">
	
	</form:form>

</html>
