package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CardHolder;
import model.DeckDetails;
import model.MagicCards;

/**
 * Servlet implementation class createNewDeck
 */
@WebServlet("/createNewDeck")
public class createNewDeck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createNewDeck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MagicCardHelper mch = new MagicCardHelper();
		String deckName = request.getParameter("deckName");
		System.out.println("Deck Name: "+ deckName);
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String holderName = request.getParameter("holderName");
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		}catch(NumberFormatException ex) {
			ld = LocalDate.now();
		}
		String[] selectedItems = request.getParameterValues("allCardsToAdd");
		List<MagicCards> selectedCardsInList = new ArrayList<MagicCards>();
		if (selectedItems != null && selectedItems.length > 0) {
			for(int i = 0; i<selectedItems.length; i++) {
				System.out.println(selectedItems[i]);
				MagicCards m = mch.searchForItemByID(Integer.parseInt(selectedItems[i]));
				selectedCardsInList.add(m);
			}
		}
		CardHolder holder = new CardHolder(holderName);
		DeckDetails dd = new DeckDetails(deckName, ld, holder);
		dd.setListOfCards(selectedCardsInList);
		DeckDetailsHelper hdh = new DeckDetailsHelper();
		hdh.insertNewDeckDetails(dd);
		System.out.println("Success!");
		System.out.println(dd.toString());
		getServletContext().getRequestDispatcher("/AllDeckServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}