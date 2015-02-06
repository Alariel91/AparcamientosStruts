package es.open4job.web.struts.form;

import org.apache.struts.action.ActionForm;

public class VerListadoAparcamientoForm extends ActionForm {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int id;
	public double latitud;
	public double longitud;
	public String titulo;
	public String icono;

	/*
	 * Getters & setters
	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIcono() {
		return icono;
	}

	public void setIcono(String icono) {
		this.icono = icono;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.struts.action.ActionForm#validate(org.apache.struts.action
	 * .ActionMapping, javax.servlet.http.HttpServletRequest) metodo que
	 * controla los errores de los campos que mandamos en el formulario es decir
	 * si en este caso texto y nombre estan en blanco o son null
	 */
	/*
	public ActionErrors validate(
			org.apache.struts.action.ActionMapping mapping,
			javax.servlet.http.HttpServletRequest request) {
		
		ActionErrors errors = new ActionErrors();

		if (GenericValidator.isBlankOrNull(this.titulo)) {
			errors.add("titulo", new ActionMessage("error.texto"));
		}

		if (GenericValidator.isBlankOrNull(this.icono)) {
			errors.add("icono", new ActionMessage("error.nombre"));
		}

		return errors;
	}
*/
}