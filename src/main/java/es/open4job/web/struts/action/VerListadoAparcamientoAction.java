package es.open4job.web.struts.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.open4job.model.dao.AparcamientoDAO;
import es.open4job.model.vo.AparcamientoVO;
import es.open4job.web.struts.form.VerListadoAparcamientoForm;

public class VerListadoAparcamientoAction extends Action {
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		AparcamientoDAO daoObj = new AparcamientoDAO();
		
		// Creo la lista
		List<AparcamientoVO> listaAparcamiento = new ArrayList<AparcamientoVO>();
		listaAparcamiento = daoObj.getallAparcamientos();
		request.setAttribute("listaAparcamiento", listaAparcamiento);
		
		return mapping.findForward("success");

	}
}
