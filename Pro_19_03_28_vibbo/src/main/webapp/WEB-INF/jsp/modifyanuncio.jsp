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

<form class="form-signin" id="registro" name="registro" method="post" action= "modificar">
		<%
		String titulo = (String)session.getAttribute("titulo");
		String descripcion = (String)session.getAttribute("descripcion");
		String precio = (String)session.getAttribute("precio");
		%>
		
		Título: <input type="text" class="form-control" placeholder="titulo"
			name="titulo" id="titulo" value = "<%=titulo %>" /><br> 
		
		Categoría: <select
			class="form-control" name="idcategorias"
			id="idcategorias">
			<option value="1">ROPA</option>
			<option value="2">ELECTRONICA</option>
			<option value="3">HOGAR</option>
			
		</select> <br>
			
		Descripción: <input type="text"
			class="form-control" placeholder="descripcion" name="descripcion"
			id="descripcion"value = "<%=descripcion %>"   /><br> 
		Prioridad: <select
			class="form-control" name="prioridad"
			id="prioridad">
			<option value="1" SELECTED>Prioridad 1</option>
			<option value="2">Prioridad 2</option>
			
		</select> <br> 	
		Precio: <input type="text"
			class="form-control" placeholder="precio" name="precio"
			id="precio" value = "<%=precio %>"  /><br> 
		
		<a href= "user/modificar"><input class="btn btn-lg btn-primary btn-block" type="submit" name="acceder"
			value="MODIFICAR"></a><br>
			<input class="btn btn-lg btn-primary btn-block" type="reset" name="reset"
			value="RESET">
			<h6><a href="perfiluser">Mi perfil</a></h6><br>
			<h6>${mensaje2}</h6>
			
			
	</form>

</body>
</html>