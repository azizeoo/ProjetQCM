package ma.norsys.formation.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SUBSCRIBER")
public class Subscriber {
	@Id
	@Column(name = "SUBSCRIBER_ID")
	private long idSubscriber;

	private String firstName;
	private String lastName;
	private String email;

	
	public Subscriber() {
	
	}

	public long getIdSubscriber() {
		return idSubscriber;
	}

	public void setIdSubscriber(long idSubscriber) {
		this.idSubscriber = idSubscriber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	

}