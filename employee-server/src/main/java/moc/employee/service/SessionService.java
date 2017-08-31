package moc.employee.service;

public interface SessionService {

	public String login(String username, String password);

	public boolean hasAccess(String token);
}