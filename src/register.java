

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		
		String query = "insert into user (email,password,nameAndSurname) VALUES ('"+email+"','"+password+"','"+name+"')";
		String query2 = "CREATE  TABLE IF NOT EXISTS `mircotech`.`"+email+"|||cart`(`model` VARCHAR(255),`name` VARCHAR(255),`price` VARCHAR(255),PRIMARY KEY (`model`))";
		databaseOperation db = new databaseOperation();
		Boolean control=db.insertTable(query);
		Boolean control2=db.createTable(query2);
		
		if(control=true) {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}

	}

}
