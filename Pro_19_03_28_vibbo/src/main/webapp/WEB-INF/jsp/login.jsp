<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://getbootstrap.com/docs/4.1/examples/sign-in/signin.css">
<style>

body{
background: url(Imagenes/tienda-online.jpg) no-repeat center center fixed;
-webkit-background-size: cover;
-moz-background-size: cover;
-o-background-size: cover;
background-size: cover;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form class="form-signin" id="registro" name="registro" method="post" action= "entrar">
		
		
		
		
		
		Usuario: <input type="text" class="form-control" placeholder="user"
			name="id_usuario" id="id_usuario" /><br> 
		Password: <input type="password"
			class="form-control" placeholder="password" name="password"
			id="password"  /><br> 
		
		<a href="user/entrar">	<input class="btn btn-lg btn-primary btn-block" type="submit" name="acceder"
			value="ACCEDER"> </a><br>
			<input class="btn btn-lg btn-primary btn-block" type="reset" name="reset"
			value="RESET">
			<h6><a href="registro">Registrarse</a></h6><br>
			<h6>${mensaje}</h6>
			<h6>${mensaje1}</h6>
			
	</form>

</body>
</html>