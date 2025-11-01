package DoServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.NewsUsersDao;

@WebServlet("/doregister")
public class Doregister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Doregister() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.设置请求字符集
		request.setCharacterEncoding("utf-8");
		// 2.获得表单书据
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		String reupwd = request.getParameter("reupwd");
		NewsUsersDao dao = new NewsUsersDao();
		
		boolean b=false;
		try {
			b = dao.isUnameExist(uname);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HttpSession session=request.getSession();
		
		if(b){
			session.setAttribute("errMsgUname","用户名存在请从新输入");
			response.sendRedirect("register.jsp");
			return;
		}
		
		if (!upwd.equals(reupwd)) {
			session.setAttribute("errMsgUpwd", "两次密码不一致");
			response.sendRedirect("register.jsp");
			return;
		}
		// 3. 注册完成,跳转页面
		
		try {
			dao.register(uname, upwd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
