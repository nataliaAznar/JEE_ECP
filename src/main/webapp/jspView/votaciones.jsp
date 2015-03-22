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
	<h3>Lista de <b>Votaciones</b></h3>
	<c:set var="rView" scope="request" value="${votaciones}" />
	<p>Temas:</p>
		<ul>
			<c:forEach var="tema" items="${rView.temas}">
				<li>${tema.getNombre()}
					<table>
						<tr>
							<th>Número de votos</th>
							<c:forEach var="estudio" items="${rView.estudios}">
								<th>${estudio}</th>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="votacion" items="${rView.getVotacion(tema.getId())}">	
								<td>${votacion}</td>
							</c:forEach>
						</tr>		
					</table>
				</li>
			</c:forEach>
		</ul>
</body>
</html>