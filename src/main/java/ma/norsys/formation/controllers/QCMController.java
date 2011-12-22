package ma.norsys.formation.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.norsys.formation.entities.Questionnaire;
import ma.norsys.formation.entities.Subscriber;
import ma.norsys.formation.service.IServiceQuestionnaire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class QCMController {
	@Autowired
	IServiceQuestionnaire serviceQuestionnaire;

	/**
	 * cette méthode permet de récuperer le questionnaire ansi que l'utilisateur
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */

	@RequestMapping("/formulaire")
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		long iduser = Long.valueOf(request.getParameter("iduser"));
		long idques = Long.valueOf(request.getParameter("idques"));
		Questionnaire questionnaireDB = serviceQuestionnaire.findQuetinnaireById(idques);
		
		Subscriber subscriberDB = serviceQuestionnaire.findSubscriberById(iduser);
		Collection<Subscriber> subscribersDB = new ArrayList<Subscriber>();
		subscribersDB.add(subscriberDB);
		questionnaireDB.setSubscribers(subscribersDB);
		
		return new ModelAndView("formulaire", "questionnaire", questionnaireDB);
	}

	/**
	 * cette méthode sert a traiter les réponses de l'utilisateur et lui renvoyer le resultats 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/correction")
	protected ModelAndView handleRequestInternall(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		long iduserreponse = Long.parseLong(request.getParameter("iduserreponse"));
		String[] res = request.getParameterValues("response");
		
		Subscriber subscriberDB = serviceQuestionnaire
				.findSubscriberById(iduserreponse);
		
		Map<String, String[]> reponsess = request.getParameterMap();

		return new ModelAndView("resultats", "subscriberDB", subscriberDB);
	}

	public IServiceQuestionnaire getServiceQuestionnaire() {
		return serviceQuestionnaire;
	}

	public void setServiceQuestionnaire(
			IServiceQuestionnaire serviceQuestionnaire) {
		this.serviceQuestionnaire = serviceQuestionnaire;
	}

}
