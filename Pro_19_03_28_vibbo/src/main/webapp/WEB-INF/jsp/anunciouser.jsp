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


<div class="container">
<h2>${anunciouser.titulo}</h2>
<table class="table table-striped">
	
  	<thead>
  	<tr>
      <th><h3>Vendedor</h3></th>
      <th><h3>Título</h3></th> 
      <th><h3>Descripción</h3></th>
      <th><h3>Precio</h3></th>
      <th><h3>Telefono</h3></th>
      <th><h3>Email</h3></th>
   </tr>
   
	<tr>
	  <td><h5>${anunciouser.id_usuario}</h5></td>
	  <td><h5>${anunciouser.titulo}</h5></td>
	  <td><h5>${anunciouser.descripcion}</h5></td>
	  <td><h5>${anunciouser.precio}</h5></td>
	  <td><h5>${telefono}</h5></td>
	  <td><h5>${email}</h5></td>
	  
	  <td><a href="modifyanuncio?titulo=${anunciouser.titulo}&descripcion=${anunciouser.descripcion}&idcategorias=${anunciouser.idcategorias}&precio=${anunciouser.precio}&prioridad=${anunciouser.prioridad}">MODIFICAR ANUNCIO</a></td>
	  <td><a href="eliminar?id_usuario=${anunciouser.id_usuario}&id_anuncio= ${anunciouser.id_anuncio}&titulo=${anunciouser.titulo}&descripcion=${anunciouser.descripcion}&precio=${anunciouser.precio}&prioridad=${anunciouser.prioridad}">ELIMINAR ANUNCIO</a></td>
	</tr>
	
	
	</table><br>
	<h5>${mensaje3}</h5><br>
	<h5><a href="perfiluser">Volver a mi perfil</a></h5><br>
	</div>
</body>
</html>