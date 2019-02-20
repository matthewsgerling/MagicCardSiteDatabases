package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CardHolder;
import model.DeckDetails;
import model.MagicCards;

/**
 * Servlet implementation class editHand
 */
@WebServlet("/EditDeckServlet")
public class EditDeckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditDeckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DeckDetailsHelper hdh = new DeckDetailsHelper();
		MagicCardHelper mch = new MagicCardHelper();
		CardHolderHelper chh = new CardHolderHelper();
		
		int idToEdit = Integer.parseInt(request.getParameter("id"));
		DeckDetails toEdit = hdh.searchForListById(idToEdit);
		String deckName = request.getParameter("deckName");
		System.out.println("Deck Name: " + deckName);
		toEdit.setDeckName(deckName);

		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");

		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			ld = LocalDate.now();
		}
		toEdit.setDeckCreated(ld);

		String HolderName = request.getParameter("holderName");
		CardHolder holder;
		try {
			holder = chh.searchForHolderByName(HolderName);
		} catch (NoResultException ex) {
			holder = new CardHolder(HolderName);
		} catch (Exception ex) {
			holder = new CardHolder(HolderName);
		}
		toEdit.setHolder(holder);
		
		List<MagicCards> previousListOfCards = toEdit.getListOfCards();

		String[] selectedItems = request.getParameterValues("itemsToAdd");
		List<MagicCards> selectedItemsInList = new ArrayList<MagicCards>();

		if (selectedItems != null && selectedItems.length > 0 ) {
			for (int i = 0; i < selectedItems.length; i++) {
				System.out.println(selectedItems[i]);
				MagicCards c = mch.searchForItemByID(Integer.parseInt(selectedItems[i]));
				selectedItemsInList.add(c);

			}

			previousListOfCards.addAll(selectedItemsInList);
		}

		toEdit.setListOfCards(previousListOfCards);

		hdh.updateList(toEdit);

		System.out.println("Success!");
		System.out.println(toEdit.toString());

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
