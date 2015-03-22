<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Votaciones</title>
</head>
<body>
	<h2>Lista de votaciones</h2>
	<c:set var="rView" scope="request" value="${votar}" />
	<p>Tema: ${rView.tema.nombre}</p>
	<p>Nivel de estudios:
	<select size="${rView.estudios.length }" >
		<c:forEach var="estudio" items="${rView.estudios}">
			<option>${estudio}</option>
		</c:forEach>
	</select>
	</p>
	
</body>
</html>