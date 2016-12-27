package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CheckSignInServiceImplement;
import entity.SignIn;

public class CheckSignInServlet extends HttpServlet
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2316370718835216055L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		request.setCharacterEncoding("gbk") ;
		response.setCharacterEncoding("gbk");
		
		
		System.out.println(request.getParameter("username")+ request.getParameter("username").equals("username"));
		
		response.setContentType("text/html") ;
		
		PrintWriter ps = response.getWriter() ;
		CheckSignInServiceImplement cssi = new CheckSignInServiceImplement();
	
		String username = request.getParameter("username") ;
		String password = request.getParameter("password") ;
		SignIn si = cssi.upperString(username, password);
		
		if(cssi.checkSignIn(username,password))
		{
			ps.println("<html><body>"+"¹§Ï²"+si.getUsername()+"\t"+si.getPassword()+"</body></html>");
			
		}else
		{
			
			ps.println("<html><body>"+"Ê§°Ü"+si.getUsername()+"\t"+si.getPassword()+"</body></html>");
		}
	}
	
}
