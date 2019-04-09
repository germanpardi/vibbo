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
<!-- Bootstrap CSS -->

<div class="container">
<h2>Categorias</h2>
<table class="table table-striped">
	
  	<thead>
  	<tr>
      <th><h2>Anuncios de ${descripcioncategoria}</h2></th>
   </tr>
   
	<c:forEach var="ac" items="${anuncios}"> 
	<tr>
	  <td><h3><a href= "anuncioprior?descripcion= ${ac.getDescripcion()}&id_anuncio=${ac.getId_anuncio()}">${ac.titulo}</a></h3></td>  
	</tr>
	</c:forEach>
	
	</table><br>
	<h2><a href= index><input type= "button" class= "btn btn-default btn-sm" value = "HOME"></a></h2>
</div>


</body>
</html>