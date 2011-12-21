package ma.norsys.formation.dao;

import ma.norsys.formation.dao.IDaoQuestionnaire;
import ma.norsys.formation.entities.Questionnaire;
import ma.norsys.formation.entities.Subscriber;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class DaoQuestionnaireImpl implements IDaoQuestionnaire {
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public Questionnaire findQuetinnaireById(long id) {

		Questionnaire questionnaire = (Questionnaire) sessionFactory
				.getCurrentSession().get(Questionnaire.class, id);
		return questionnaire;
	}

	@Transactional
	public void addQuestionnaire(Questionnaire qten) {

		sessionFactory.getCurrentSession().save(qten);

	}

	@Transactional
	public Subscriber findSubscriberById(long id) {

		Subscriber sub = (Subscriber) sessionFactory.getCurrentSession().get(
				Subscriber.class, id);
		return sub;
	}

}
