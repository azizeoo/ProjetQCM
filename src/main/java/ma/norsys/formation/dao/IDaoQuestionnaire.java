package ma.norsys.formation.dao;

import ma.norsys.formation.entities.Questionnaire;
import ma.norsys.formation.entities.Subscriber;

public interface IDaoQuestionnaire {

	Questionnaire findQuetinnaireById(long id);

	public void addQuestionnaire(Questionnaire qten);

	public Subscriber findSubscriberById(long id);

}
