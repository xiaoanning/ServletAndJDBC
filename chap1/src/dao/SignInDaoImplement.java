package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.JDBCUtil;
import entity.SignIn;

public class SignInDaoImplement implements SignInDao
{
	public SignIn queryByUsername(String username)
	{
		Connection con = null ;
		PreparedStatement ps = null ;
		ResultSet rs = null ;
		SignIn si = new SignIn() ;
		
		try 
		{
			con = JDBCUtil.getConnection() ;		
			
			System.out.println("1111"+ con.toString() );
			
			ps = con.prepareStatement("select * from test_user where username = ?");
			ps.setString(1, username) ;
			
			rs = ps.executeQuery();
			
			if(rs.next())
			{
				
				si.setUsername(username);
				si.setPassword(rs.getString(2));
								
				return si ;
			}
			
			return null ;
			
		} catch (Exception e) 
		{
			System.out.println("11===11"+ con == null);
			e.printStackTrace();
			return null ;
		}finally
		{
			
			try 
			{
				JDBCUtil.close(ps,rs,null);
			} catch (Exception e) 
			{

				e.printStackTrace();
			}
		}
		
		
		
	}
	
	public boolean checkSignIn(String username , String password)
	{
		SignIn si = queryByUsername(username);
		
		if(si == null )
		{
			
			return false ;
		}else if ( !si.password.equals(password))
		{
			return false ;
		}else
		{
			return true ;
		}
		
	}

}
