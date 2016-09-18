package interceptors;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

import entities.User;

public class LoginInterceptor implements Interceptor {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		System.out.println("LOGIN_INTERCEPTOR");
        Map<String, Object> sessionMap = (Map<String, Object>) actionInvocation.getInvocationContext().getSession();
        sessionMap.put("target",actionInvocation.getInvocationContext().getName());
        User user = (User)sessionMap.get("user");
        if(user == null){
            return "login";
        }
        return actionInvocation.invoke();
        
	}
	

}
