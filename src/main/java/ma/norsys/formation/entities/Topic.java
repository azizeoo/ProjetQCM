package ma.norsys.formation.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * @author technomaker04
 *
 */
@Entity
@Table(name = "TOPIC")
public class Topic {
	
	@Id
	@Column(name = "TOPIC_ID")
	private long idTopic;
	
	@Column(name = "TOPIC_LIB")
	private String libelle;
	@Fetch(FetchMode.SELECT)
	@OneToMany(cascade= CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Question> lesQuestions;
	
	public Topic(long idTopic, String libelle) {
		this.idTopic = idTopic;
		this.libelle = libelle;
	}
	public Topic() {
	}
	public long getIdTopic() {
		return idTopic;
	}
	public void setIdTopic(long idTopic) {
		this.idTopic = idTopic;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public List<Question> getLesQuestions() {
		return lesQuestions;
	}
	public void setLesQuestions(List<Question> lesQuestions) {
		this.lesQuestions = lesQuestions;
	}


}
