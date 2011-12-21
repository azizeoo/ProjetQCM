package ma.norsys.formation.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author HBALI
 *
 */
@Entity
@Table(name = "RESPONSE")
public class Response {
	@Id
	@Column(name = "RESPONSE_ID")
	private long idR;
	@Column(name = "LIBELLE")
	private String libelle;
	@Column(name = "IS_CORRECT")
	private boolean isCorrect;
	
	public Response(long idR, String libelle, boolean isCorrect) {
		this.idR = idR;
		this.libelle = libelle;
		this.isCorrect = isCorrect;
	}

	public Response() {
	}

	public long getIdR() {
		return idR;
	}
	public void setIdR(long idR) {
		this.idR = idR;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

	public boolean isCorrect() {
		return isCorrect;
	}
}
