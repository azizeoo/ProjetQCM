package ma.norsys.formation.service;

import ma.norsys.formation.dao.IDaoQuestionnaire;
import ma.norsys.formation.entities.Questionnaire;
import ma.norsys.formation.entities.Subscriber;

public interface IServiceQuestionnaire {

	Questionnaire findQuetinnaireById(long id);

	public void addQuestionnaire(Questionnaire qten);

	public Subscriber findSubscriberById(long id);

	public IDaoQuestionnaire getDaoQuestionnaire();

	public void setDaoQuestionnaire(IDaoQuestionnaire daoQuestionnaire);
}
