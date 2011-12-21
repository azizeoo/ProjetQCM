package ma.norsys.formation.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ma.norsys.formation.entities.Topic;
@Repository
public class DaoTopicImpl implements IDaoTopic {
	@Autowired
	private SessionFactory sessionFactory;
	@Transactional
	public void addTopic(Topic topic) {
		sessionFactory.getCurrentSession().save(topic);
	}

}
