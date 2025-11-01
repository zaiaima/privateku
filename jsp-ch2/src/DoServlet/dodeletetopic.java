package DoServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TopicDao;

@WebServlet("/dodeletetopic")
public class dodeletetopic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public dodeletetopic() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int tid=Integer.parseInt(request.getParameter("tid"));
	TopicDao dao=new TopicDao();
	try {
		dao.delete(tid);
	} catch (Exception e) {
		e.printStackTrace();
	}
	response.sendRedirect("showtopic.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
