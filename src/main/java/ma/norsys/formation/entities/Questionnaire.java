package ma.norsys.formation.entities;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author HBALI
 *
 */
@Entity
@Table(name = "QUESTIONNAIRE")
public class Questionnaire {
	
	@Id
	@Column(name = "QUESTIONNAIRE_ID")
	private long idQuestionnaire;
	
	@ManyToOne
	private Topic topic;

	@ManyToOne
	private User user;
	
	@ManyToMany(cascade= CascadeType.ALL)
    private Collection<Subscriber> subscribers;
	
	public Questionnaire(long idQuestionnaire, Topic topic) {
		this.idQuestionnaire = idQuestionnaire;
		this.topic = topic;
	}
	

	public Questionnaire() {
	}


	public long getIdQuestionnaire() {
		return idQuestionnaire;
	}

	public void setIdQuestionnaire(long idQuestionnaire) {
		this.idQuestionnaire = idQuestionnaire;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}


	public Collection<Subscriber> getSubscribers() {
		return subscribers;
	}


	public void setSubscribers(Collection<Subscriber> subscribers) {
		this.subscribers = subscribers;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

	

}