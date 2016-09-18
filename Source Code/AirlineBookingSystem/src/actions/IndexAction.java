package actions;

import com.opensymphony.xwork2.Action;

import entities.User;

public class IndexAction implements Action {

	private User user;
	@Override
	public String execute() throws Exception {
		if(user==null)
			return "not_logged_in";
		else
			return "logged_in";
	}

}
