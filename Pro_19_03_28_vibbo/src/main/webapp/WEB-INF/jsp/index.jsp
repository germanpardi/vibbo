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
background: url(Imagenes/tienda-online.jpg) center center fixed;
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
<!-- Bootstrap CSS -->




<div class="container">
<h2>VIBBO</h2><br>
<table class="table table-striped">
	
  	<thead>
  	<tr>
      <th><h2>Categorias</h2></th>
   </tr>
   
	<c:forEach var="categoria" items="${categorias}"> 
	<tr>
	  <td><h3><a href= "anuncioscategoria?descripcioncategoria= ${categoria.getDescripcion()}&idcategorias=${categoria.getIdcategorias()}">${categoria.descripcion}</a></h3></td>  
	</tr>
	</c:forEach>
	
	</table><br>
<table class="table table-striped">
	
  	<thead>
  	<tr>
      <th><h4><p style= "color:rgb(251,252,252);" >ANUNCIOS DESTACADOS</p></h4></th>
   </tr>
   
	<c:forEach var="ap" items="${anunciosprior}"> 
	<tr>
	  <td><h6><a href= "anuncioprior?titulo= ${ap.getTitulo()}&id_anuncio=${ap.getId_anuncio()}">${ap.titulo}</a></h6></td>  
	</tr>
	</c:forEach>
	
	</table><br>
</div>

<div class="container">

<form class="form-signin" id="busqueda" name="busqueda" method="post" action= "buscaranuncios">
<input type="text" class="form-control" placeholder="busqueda"name="busqueda" id="busqueda"/><h2>
<input type= "submit" class= "btn btn-lg btn-primary btn-block" value = "BUSCAR"></h2><br><br><br><br><br><br><br><br><br><br><br><br>
</form>

<h2><a href= user/login><input type= "button" class= "btn btn-lg btn-primary btn-block" value = "ANUNCIATE"></a></h2>
</div>
</body>
</html>