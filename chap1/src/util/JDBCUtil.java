package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class JDBCUtil 
{
	private static Properties p = new Properties();
	
	static
	{
		InputStream is = null ;
		
		is = JDBCUtil.class.getResourceAsStream("/jdbc.property");
		
		try 
		{
			p.load(is) ;
		} catch (IOException e) 
		{
			e.printStackTrace();
		}finally
		{
			
			try 
			{
				is.close();
			} catch (IOException e) 
			{

				e.printStackTrace();
			}
		}
		
	}
	
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	public static Connection getConnection() throws Exception
	{
		Connection con =  tl.get();
		
		if( con == null)
		{
			Class.forName(p.getProperty("driver"));
			
			con = DriverManager.getConnection(p.getProperty("url"), p.getProperty("username"), p.getProperty("password"));
			
			System.out.println("==--==="+con);
			
			tl.set(con);
		}
		
		return con ;
		
	}
	
	public static void close(PreparedStatement ps , ResultSet rs , Connection con) throws Exception
	{
		if(rs != null)
		{	
			rs.close();
		}
		
		if(ps != null)
		{	
			ps.close();
		}
		
		if(con != null)
		{	
			con.close();
			tl.remove();
		}
	}

	

	
}
