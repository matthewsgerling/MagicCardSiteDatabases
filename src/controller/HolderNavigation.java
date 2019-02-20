package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DeckDetails;
import model.MagicCards;

/**
 * Servlet implementation class HolderNavagation
 */
@WebServlet("/HolderNavigation")
public class HolderNavigation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HolderNavigation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DeckDetailsHelper hdh = new DeckDetailsHelper();
		String act = request.getParameter("doThisToItem");

		if (act == null) {
			getServletContext().getRequestDispatcher("/AllDeckServlet").forward(request, response);
		} else if (act.equals("delete")) {
			System.out.println("deleting");
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				System.out.println(tempId);
				DeckDetails deckToDelete = hdh.searchForListById(tempId);
				hdh.deleteItem(deckToDelete);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to click a button");
			} finally {
				getServletContext().getRequestDispatcher("/AllDeckServlet").forward(request, response);
			}

		} else if (act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				DeckDetails listToEdit = hdh.searchForListById(tempId);
				MagicCardHelper mch = new MagicCardHelper();
				List<MagicCards> allItems = mch.showAllItems();
				List<MagicCards> currentListItems = listToEdit.getListOfCards();
				for (int i = 0; i < allItems.size(); i++) {
					for (int j = 0; j < currentListItems.size(); j++) {
						if (allItems.get(i).getId() == currentListItems.get(j).getId()) {
							allItems.remove(i);
						}
					}
				}
				request.setAttribute("listToEdit", listToEdit);
				request.setAttribute("allItemsToAdd", allItems);
				getServletContext().getRequestDispatcher("/EditDeck.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				getServletContext().getRequestDispatcher("/AllDeckServlet").forward(request, response);
			}

		} else if (act.equals("add")) {
			getServletContext().getRequestDispatcher("/NewDeckServlet").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
