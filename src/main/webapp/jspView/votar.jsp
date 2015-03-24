<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Votaciones</title>
</head>
<body>
	<c:set var="rView" scope="request" value="${votar}"/>
	
	<form action="/JEE_ECP/jsp/votar" method="post">
		<p>Pregunta: ${rView.pregunta}
		</p>
		
		<input type="hidden" name="id" value="${rView.idTema}"/>
		<p>Nivel de estudios:
			<select size="${rView.length}" name="estudio">
				<c:forEach var="estudio" items="${rView.estudios}">
					<option>${estudio}</option>
				</c:forEach>
			</select>
		</p>
		<p>Puntuación:
			<select name="puntos">
				<c:forEach var="punto" items="${rView.puntuacion}">
					<option>${punto}</option>
				</c:forEach>
			</select>
		</p>
		<input type="submit" value="Enviar votación" />
	</form>
</body>
</html>