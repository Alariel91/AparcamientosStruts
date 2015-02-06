<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello World struts</title>
</head>
<body>
<!-- 
out.println("<h2>Texto: " + session.getAttribute("texto") + "</h2>");
out.println("<h2>Nombre: " + session.getAttribute("nombre") + "</h2>");
 -->

<h1><bean:write name="DatosFormulario" property="texto" /></h1>
<h1><bean:write name="DatosFormulario" property="nombre" /></h1>
</body>
</html>
