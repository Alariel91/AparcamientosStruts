<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="es.open4job.model.vo.*"%>
<%@ page import="java.util.List"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><bean:message key="listado.title" /></title>
</head>
<body>
	<h1>
		<bean:message key="listado.titulo" />
	</h1>
<!-- ITERATE PARA PONER EL ARRAYLIST COMO SI FUERA UN FOR -->
	<logic:iterate name="listaAparcamiento" id="listaAparcamiento">

		<p>
			<bean:message key="listado.id" />
			<bean:write name="listaAparcamiento" property="id" />
		</p>
		<p>
			<bean:message key="listado.latitud" />
			<bean:write name="listaAparcamiento" property="latitud" />
		</p>
		<p>
			<bean:message key="listado.longitud" />
			<bean:write name="listaAparcamiento" property="longitud" />
		</p>
		<p>
			<bean:message key="listado.nombre" />
			<bean:write name="listaAparcamiento" property="titulo" />
		</p>
		<p>
			<bean:message key="listado.icono" />
			<bean:write name="listaAparcamiento" property="icono" />
		</p>
	</logic:iterate>


</body>
</html>
