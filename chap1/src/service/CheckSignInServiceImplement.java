package service;

import java.sql.Connection;
import java.sql.SQLException;

import util.JDBCUtil;
import dao.SignInDaoImplement;
import entity.SignIn;

public class CheckSignInServiceImplement implements CheckSignInService
{

	public boolean checkSignIn(String username, String password) 
	{
		Connection con = null ;
		try
		{
			con = JDBCUtil.getConnection();
			System.out.println("====\t"+con);

			con.setAutoCommit(false) ;
			SignInDaoImplement sii = new SignInDaoImplement();
			
			boolean success = sii.checkSignIn(username, password) ;
			System.out.println("====00000"+success);

			con.commit() ;
			System.out.println("====0000011");

			return success ;

			
		} catch (Exception e)
		{
			e.printStackTrace();
			try
			{
				con.rollback() ;
			} catch (SQLException e1) 
			{

				e1.printStackTrace();
			}
			return false ;
		}finally
		{
			try 
			{
				System.out.println("=======1");

				JDBCUtil.close(null, null, con);
				
				System.out.println("====0000011111}}}}}}}}}}");

			} catch (Exception e)
			{

				e.printStackTrace();
			}

		}

		
	}

	public SignIn upperString(String username, String password)
	{
		SignIn si = new SignIn();
		
		si.setUsername(username.toUpperCase());
		si.setPassword(password.toUpperCase());

		return si;
	}
	
	
	
	
}
