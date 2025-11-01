package DoServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.NewsUsersDao;
import entity.NewsUsers;

@WebServlet("/doLogin")
public class DoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DoLogin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.设置请求字符集
		  request.setCharacterEncoding("utf-8");
		  // 2.获得表单书据
		  String uname=request.getParameter("uname");  
		  String upwd=request.getParameter("upwd");  
		  // 3. 跳转页面
		  NewsUsersDao dao=new NewsUsersDao();
		  NewsUsers users=null;
		try {
			users = dao.login(uname, upwd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

			HttpSession session=request.getSession();
			
		  if(users!=null){
			  session.setAttribute("users", users);
		      response.sendRedirect("index.jsp");
		  }else{
		      session.setAttribute("errMsg", "用户名或密码错误");
		      response.sendRedirect("login.jsp");
		  }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
