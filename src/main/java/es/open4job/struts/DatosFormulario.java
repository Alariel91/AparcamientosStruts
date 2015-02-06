package es.open4job.struts;

import org.apache.commons.validator.GenericValidator;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMessage;

public class DatosFormulario extends ActionForm{
String texto;
String nombre;
/*
 * Getters & setters
 */
public String getTexto() {
	return texto;
}
public void setTexto(String texto) {
	this.texto = texto;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
/*
 * (non-Javadoc)
 * @see org.apache.struts.action.ActionForm#validate(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest)
 * metodo que controla los errores de los campos que mandamos en el formulario
 * es decir si en este caso texto y nombre estan en blanco o son null
 */
public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {  
    ActionErrors errors = new ActionErrors();  
      
    if (GenericValidator.isBlankOrNull(this.texto) ) {  
        errors.add("texto", new ActionMessage("error.texto"));  
    }  
      
    if (GenericValidator.isBlankOrNull(this.nombre) ) {  
        errors.add("nombre", new ActionMessage("error.nombre"));  
    }  
      
    return errors;  
}  
}