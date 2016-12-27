package dao;

import entity.SignIn;

public interface SignInDao
{
	public SignIn queryByUsername(String username) ;
	
	public boolean checkSignIn(String username , String password);
}

