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
background: url(Imagenes/tienda-online.png) no-repeat center center fixed;
-webkit-background-size: cover;
-moz-background-size: cover;
-o-background-size: cover;
background-size: cover;
}
</style>
<meta charset="ISO-8859-1">
<title>Perfil del usuario</title>
</head>
<body>
<!-- Bootstrap CSS -->

<div class="container">

<table class="table table-striped">
	
  	<thead>
  	<tr>
      <th><h2>Anuncios de ${id_usuario}</h2></th>
   </tr>
   
	<c:forEach var="ac" items="${anuncios}"> 
	<tr>
	  <td><h3><a href= "anunciouser?descripcion= ${ac.getDescripcion()}&id_anuncio=${ac.getId_anuncio()}&titulo=${ac.getTitulo()}&precio=${ac.getPrecio()}">${ac.titulo}</a></h3></td> 
	  
	</tr>
	</c:forEach>
	 <td><a href="crearanuncio">ANUNCIAR PRODUCTO</a></td> <br><br>
	</table><br>
</div>


</body>
</html>