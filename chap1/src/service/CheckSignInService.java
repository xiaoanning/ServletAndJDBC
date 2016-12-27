package service;

import entity.SignIn;

public interface  CheckSignInService
{
	public boolean checkSignIn(String username ,String password);
	
	public SignIn upperString (String username ,String password);
}
