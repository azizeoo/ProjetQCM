package ma.norsys.formation.service;

import ma.norsys.formation.dao.IDaoQuestionnaire;
import ma.norsys.formation.entities.Questionnaire;
import ma.norsys.formation.entities.Subscriber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceQuestionnaireImpl implements IServiceQuestionnaire {

	
    @Autowired
	IDaoQuestionnaire daoQuestionnaire;
	
	public IDaoQuestionnaire getDaoQuestionnaire() {
		return daoQuestionnaire;
	}


	public void setDaoQuestionnaire(IDaoQuestionnaire daoQuestionnaire) {
		this.daoQuestionnaire = daoQuestionnaire;
	}


	public ServiceQuestionnaireImpl() {
	}
	
	
	@Transactional
	public Questionnaire findQuetinnaireById(long id) {
		
		return daoQuestionnaire.findQuetinnaireById(id);
	}

	
	@Transactional
	public void addQuestionnaire(Questionnaire qten) {

		daoQuestionnaire.addQuestionnaire(qten);
		
	}
	@Transactional
	public Subscriber findSubscriberById(long id) {
		
		return daoQuestionnaire.findSubscriberById(id);
	}

}
