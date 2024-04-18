package com.JC.service;

import com.JC.exceptions.LoginException;
import com.JC.model.UserLogin;

public interface LoginService {

    public String login (UserLogin userLogin) throws LoginException;
	
	public String logout (String Key) throws LoginException;
}
