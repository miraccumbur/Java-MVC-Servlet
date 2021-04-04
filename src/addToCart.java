

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class addToCart
 */
@WebServlet("/addToCart/*")
public class addToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addToCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int ignoreAmt = request.getContextPath().length() + request.getServletPath().length();
	    String modelName= request.getRequestURI().substring(ignoreAmt+1);
		
		String email=(String)session.getAttribute("enteredUserEmail");
		databaseOperation db = new databaseOperation();
		ArrayList<String>array=db.getAItem(modelName);
		System.out.println(array.get(0)+array.get(1)+array.get(3));
		int stock=db.getStock(modelName);
		System.out.println(stock);
		if((stock-1)>=0) {
			stock=stock-1;
		}
		String query = "insert into `mircotech`.`"+email+"|||cart`  (`model`,`name`,`price`) VALUES ('"+array.get(0)+"','"+array.get(1)+"','"+array.get(3)+"')";
		String query2 = "UPDATE `mircotech`.`items` SET `stock` = '"+stock+"' WHERE (`model` = '"+modelName+"')";
		Boolean control=db.insertTable(query);
		db.update(query2);
		
		request.getRequestDispatcher("/addToCart.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
