<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Home Page Viet TN Blog</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="slide">
		<div class="container">
			<h3>Welcom to TN Viet Blog!</h3>
	
		</div>
	</div>
	

	
	
	
		
		<div class="container content">
			<div class="row">
				<div class="col-md-8">
				
					
					<c:forEach var="tempPost" items="${resultPost}">
					<div class="postContent">
							<div class="row">
								<div class="col-md-12">
									<h3><div class="postTittle">${tempPost.tittle}</div></h3>
								</div>
								
								<div class="col-md-12">
									<div class="signatureAuthor">
										Written by: <span class="postAuthor">${tempPost.author}</span> <br>
										Date Reslese: <span class="postDate">${tempPost.date}</span>
										</div>
								</div>
								
								<div class="col-md-12">
									<div class="postBody">${tempPost.body}</div>
								</div>
								
								<hr>
								<hr>
								
							</div>
					
					</div> <!-- end postContent Class -->
					</c:forEach>
					
				</div>
				
				
				
				
				
				
				<div class="col-md-4">
					<div class="col-md-12">
						<form:form action="searchHome" method="POST">
							Search: <input type="text" name="theSearchName" />
							
							<input type="submit" value="Search"/>
						</form:form>
					</div>
					<br>
					<br>
					<div class="col-md-12">
						<div class="alert alert-info">
						About
						</div>
					</div>
					<div class="col-md-12">
						<img class="logo" src="${pageContext.request.contextPath}/resources/images/tien123.jpg">
					</div>
					
					<div class="col-md-12">
					<br>
						My name is: Nguyen Viet Tien <br>
						Birthday: 19/08/1994 <br>
						Adress: My Dinh 2, Nam Tu Liem, Ha Noi
					<br>
					<br> 
					</div>
				
					<div class="col-md-12">
						<div class="alert alert-success">
						Social
						</div>
					</div>
					<div class="col-md-12">
						<a href="https://www.facebook.com/viet2tn"><i class="infoSocial fab fa-facebook"></i></a>
						<a href="#"><i class="infoSocial fab fa-twitter"></i></a>
						<a href="#"><i class="infoSocial fab fa-pinterest-square"></i></a>
					</div>
				
				</div>
				
			</div>
		</div>
	
	
	
	
	
	
	
	<jsp:include page="footer.jsp"></jsp:include>

	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>

</body>
</html>