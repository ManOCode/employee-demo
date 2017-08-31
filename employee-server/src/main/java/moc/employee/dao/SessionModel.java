package moc.employee.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "session")
public class SessionModel extends AbstractModel {

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private UserModel user;

	@Column(name = "token")
	private String token;

	@Column(name = "session_start")
	private Date sessionStart;

	private transient Date sessionActive;

	@Column(name = "session_end")
	private Date sessionEnd;

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getSessionStart() {
		return sessionStart;
	}

	public void setSessionStart(Date sessionStart) {
		this.sessionStart = sessionStart;
	}

	public Date getSessionActive() {
		return sessionActive;
	}

	public void setSessionActive(Date sessionActive) {
		this.sessionActive = sessionActive;
	}

	public Date getSessionEnd() {
		return sessionEnd;
	}

	public void setSessionEnd(Date sessionEnd) {
		this.sessionEnd = sessionEnd;
	}

}