<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Gestión de Autores</title>
<link rel="stylesheet" type="text/css" href="estilos/style.css">
<script defer src="script.js"></script>
</head>
<body>


	<%!
	String nombre;
	
	%>
	
	
		<div class="parent">
			<div class="div1">
				<img src="img/logo.png" width="60" height="60">
			</div>
			<div class="div2">
				<h1>Insertar Autores</h1>
			</div>

			<div class="div3">
			<div id="formularioAutor" class="autoresInsertar" >
			
					<h2>El autor se ha insertado correctamente</h2>
					<button type="submit" formaction="index.html">Cerrar</button>
				</div>
				
			</div>
			<div class="div6"><button type="submit" formaction="autoresInsertar.html">Nuevo Autor</button>
			<button type="submit">Listado autores</button>
			</div>
			
			
		</div>
	
</body>
</html>