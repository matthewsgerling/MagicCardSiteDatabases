package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.MagicCards;

/**
 * Servlet implementation class EditCard
 */
@WebServlet("/EditCard")
public class EditCard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MagicCardHelper mch = new MagicCardHelper();
		
		String name = request.getParameter("cardName");
		String type = request.getParameter("cardType");
		String manacost = request.getParameter("manaCost");
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		MagicCards CardToUpdate = mch.searchForItemByID(tempId);
		CardToUpdate.setName(name);
		CardToUpdate.setType(type);
		CardToUpdate.setManaCost(Integer.parseInt(manacost));
		
		mch.updateItem(CardToUpdate);
		
		getServletContext().getRequestDispatcher("/AllCards").forward(request, response);

	}

}
