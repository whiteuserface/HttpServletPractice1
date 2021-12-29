package Main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entities.Student;
import Service.AllService;


@WebServlet("/insertstudent")
public class InsertStudent extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		AllService as = new AllService();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		try {
			String name = request.getParameter("name");
			as.insertStudent(name);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
