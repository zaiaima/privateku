package ch4.serverlt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

@WebServlet("/dologin")
public class DologinServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DologinServelt() {
        super();
    }
   
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");
    	String uname=request.getParameter("uname");
    	String upwd=request.getParameter("upwd");
    	
    	HttpSession session=request.getSession();
    	
    	if ("sa".equals(uname) && "sa".equals(upwd)) {
    		session.setAttribute("uname",uname);
			response.sendRedirect("index.jsp");
		}else{
			session.setAttribute("errMsg", "用户名与密码不匹配");
			response.sendRedirect("login.jsp");
		}
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
