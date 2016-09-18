package actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport implements SessionAware{

	private Map<String, Object> sessionMap; 
	
	@Override
	public String execute() throws Exception {
		logoutUser();
		return SUCCESS;
	}

	private void logoutUser() {
		sessionMap.clear();
	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
	
	

}
