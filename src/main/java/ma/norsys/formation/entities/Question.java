package ma.norsys.formation.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * @author HBALI
 *
 */
@Entity
@Table(name = "QUESTION")
public class Question {

	@Id
	@Column(name = "QUESTION_ID")
	private long idQuestion;

	@Column(name = "QUESTION_LIB")
	private String libelle;

	@OneToMany(cascade= CascadeType.ALL,  fetch=FetchType.EAGER)
	private List<Response> lesReponses;

	public Question(long idQuestion, String libelle, List<Response> lesReponses) {
		this.idQuestion = idQuestion;
		this.libelle = libelle;
		this.lesReponses = lesReponses;
	}

	public Question() {
	}

	public long getIdQuestion() {
		return idQuestion;
	}

	public void setIdQuestion(long idQuestion) {
		this.idQuestion = idQuestion;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public void setLesReponses(List<Response> lesReponses) {
		this.lesReponses = lesReponses;
	}

	public List<Response> getLesReponses() {
		return lesReponses;
	}

}
