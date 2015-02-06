package es.open4job.struts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class HelloWorldAction extends Action{
	public ActionForward execute(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)
	        throws Exception {
		/*
		 * Le dices cual van a ser los datos del formulario que estan
		 * en nuestra clase DatosFormulario
		 */
		DatosFormulario datos = (DatosFormulario) form;
		
		/*
		 * -- CODIGO ANTERIOR ---
		String texto= request.getParameter("texto");
		String nombre= request.getParameter("nombre");
		HttpSession session=request.getSession(true);
		session.setAttribute("texto", texto);
		session.setAttribute("nombre", nombre);
		 */
		
		/*
		 * Le mandamos el mapping con la key "success" que correspondera
		 * a hola.jsp que esta puesto en struts-config.xml
		 */
		
			return mapping.findForward("success");
		}
}
