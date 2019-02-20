package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DeckDetails;

/**
 * Servlet implementation class AllDecksServlet
 */
@WebServlet("/NewDeckServlet")
public class NewDeckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewDeckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MagicCardHelper mch = new MagicCardHelper();
		DeckDetailsHelper hdh = new DeckDetailsHelper();
		List<DeckDetails> abc = hdh.getLists();
		
		request.setAttribute("AllDecks", abc);
		request.setAttribute("AllCards", mch.showAllItems());
		
		
		if(abc.isEmpty()){
			request.setAttribute("AllDecks", " ");
		}
		
		if(mch.showAllItems().isEmpty()){
				request.setAttribute("AllCards", " ");
		}
		
		getServletContext().getRequestDispatcher("/newDeck.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
