package ch09.security.jaas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class JAASLoginModule implements LoginModule {
	private CallbackHandler handler;
	private Subject subject;
	
	private UserPrincipal userPrincipal;
	private RolePrincipal rolePrincipal;
	
	private String userId;
    private List<String> userRoles;

	@Override
	public void initialize(Subject subject, 
			CallbackHandler callbackHandler,
			Map<String, ?> sharedState, Map<String, ?> options) {
		handler = callbackHandler;
		this.subject = subject;
	}

	@Override
	public boolean login() throws LoginException {
		Callback[] callbacks = new Callback[2];
	    callbacks[0] = new NameCallback("login");
	    callbacks[1] = new PasswordCallback("password", true);

	    try {
	      // 由容器的JAAS模組取回使用者輸入的user/password(credentials)
	      handler.handle(callbacks);  
	      String name = ((NameCallback) callbacks[0]).getName();
	      String password = String.valueOf((
	    		  (PasswordCallback) callbacks[1]).getPassword());

          // 開始檢查使用者的身分	      
	      if (name != null  &&  password != null ) {
	    	  // 由資料庫內的資料來核對Credentials。
	    	  LoginService ls = new LoginService();
	    	  Collection<String> roles = ls.checkPassword(name, password);
	    	  userId = name;
		      userRoles = new ArrayList<String>();
		      if (roles == null){
		    	  throw new LoginException("帳號/密碼錯誤");
		      }
	    	  for(String role: roles){
	    		  	//該使用者所有的角色全部要加入List<String>
	    		  	userRoles.add(role);
	    	  }
	          return true;
	      }
	      // 如果身分驗證失敗，丟出例外LoginException
	      throw new LoginException("Authentication failed");
	    } catch (IOException e) {
	      throw new LoginException(e.getMessage());
	    } catch (UnsupportedCallbackException e) {
	      throw new LoginException(e.getMessage());
	    }
	}

	@Override
	public boolean commit() throws LoginException {
		//如果login()傳回true, JAAS框架會呼叫此方法
		userPrincipal = new UserPrincipal(userId);
	    subject.getPrincipals().add(userPrincipal);

	    if (userRoles != null && userRoles.size() > 0) {
	      for (String groupName : userRoles) {
	        rolePrincipal = new RolePrincipal(groupName);
	        subject.getPrincipals().add(rolePrincipal);
	      }
	    }
	    return true;
	}

	@Override
	public boolean abort() throws LoginException {
		return false;
	}

	@Override
	public boolean logout() throws LoginException {
		subject.getPrincipals().remove(userPrincipal);
	    subject.getPrincipals().remove(rolePrincipal);
	    return true;
	}
}
