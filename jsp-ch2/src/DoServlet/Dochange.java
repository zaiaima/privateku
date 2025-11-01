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

@WebServlet("/dochange.pwd")
public class Dochange extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Dochange() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.设置请求字符集
		request.setCharacterEncoding("utf-8");
		// 2.获得表单书据
		String Oldupwd = request.getParameter("Oldupwd");
		String upwd=request.getParameter("upwd");
		String reupwd = request.getParameter("reupwd");
		HttpSession session=request.getSession();
		// 3判断输入是否正确
		NewsUsers users=(NewsUsers)session.getAttribute("users");
		String uname=users.getUname();
		
		
		// 3.1原密码与新密码不一致且跳转到登录页面
		if (!users.getUpwd().equals(Oldupwd)) {
			session.setAttribute("errMsgOldupwd", "原始密码错误请从新输入");
			response.sendRedirect("change.jsp");
			return;
		}
		// 3.2两次新密码bu一致
		if(!upwd.equals(reupwd)){
			session.setAttribute("errMsgUpwd", "密码不一致请从新输入");
			response.sendRedirect("change.jsp");
			return;
		}
		// 4. 注册完成,跳转页面
		NewsUsersDao dao = new NewsUsersDao();
		try {
			dao.changePwd(uname, upwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 5.登录
		response.sendRedirect("login.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
