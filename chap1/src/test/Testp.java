package test;

import org.junit.Test;

import service.CheckSignInServiceImplement;


public class Testp 
{
	@Test
	public void test1()
	{
		CheckSignInServiceImplement c = new CheckSignInServiceImplement() ;
		System.out.println(c.checkSignIn("huze", "zpark") );
	}
}
