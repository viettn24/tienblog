<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Home Page Viet TN Blog</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<hr>

	<div class="container">
		<a href="${pageContext.request.contextPath}/user/addNewPost"><div class="btn btn-info">Add New Post</div></a>
	</div>

	<div class="container">
			<div class="row">
				<div class="col-md-1">Post ID</div> 
				<div class="col-md-2">Title</div> 
				<div class="col-md-3">Body Content</div>
				<div class="col-md-2">Author</div> 
				<div class="col-md-1">Date</div>  
			</div>
	</div>
	<c:forEach var="tempPost" items="${postResult}">
		<c:url var="updateLink" value="/user/showFormForUpdate">
			<c:param name="postId" value="${tempPost.id}"></c:param>
		</c:url>
		<c:url var="deleteLink" value="/user/deletePost">
			<c:param name="deleteId" value="${tempPost.id}"></c:param>
		
		</c:url>
		<div class="container">
			<div class="row"> 
				<div class="col-md-1">${tempPost.id}</div> 
				<div class="col-md-2">${tempPost.tittle}</div> 
				<div class="col-md-3">${tempPost.body}</div>
				<div class="col-md-2">${tempPost.author}</div> 
				<div class="col-md-1">${tempPost.date}</div> 
				<div class="col-md-1"></div> 
				<div class="col-md-2"><a href="${updateLink}">Update | <a href="${deleteLink}">Delete</a></a></div>
				
			</div>
		</div>
		
	
	</c:forEach>
	
<jsp:include page="footer.jsp"></jsp:include>

</body>




</html>

