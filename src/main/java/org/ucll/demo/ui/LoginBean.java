package org.ucll.demo.ui;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.ucll.demo.service.api.java.to.UserDetail;

@Named
@SessionScoped
public class LoginBean extends FormBean {
	private static final long serialVersionUID = 1L;

	private UserDetail person;

	private String personId;
	private String password;

	public String cancel() {
		return "loginform";
	}
	
	public boolean isLoggedIn(){
		return person != null;
	}
	

	/*
	 * public String validateUsernamePassword() { boolean valid =
	 * LoginDAO.validate(user, pwd); if (valid) { HttpSession session =
	 * SessionUtils.getSession(); session.setAttribute("username", user); return
	 * "admin"; } else { FacesContext.getCurrentInstance().addMessage( null, new
	 * FacesMessage(FacesMessage.SEVERITY_WARN,
	 * "Incorrect Username and Passowrd",
	 * "Please enter correct username and Password")); return "login"; } }
	 */

	public String login() {
		String nextPage = "";
		try {
			person = getService().getUserIfAuthenticated(personId, password);
			if(person == null){
				setMessage("Invalid userid/password combination");
				nextPage = "loginform";
			} else {
				nextPage = "personoverview";
			}
		} catch (Exception e) {
			setMessage(e);
			nextPage = "login";
		} finally {
			setPersonId(null);
			setPassword(null);
		}
		return nextPage;
	}

	public String logout() {
		person = null;
		return "login";
	}

	/*
	 * public String logout() {
	 * FacesContext.getCurrentInstance().getExternalContext().invalidateSession(
	 * ); return "login?faces-redirect=true"; }
	 */

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

}