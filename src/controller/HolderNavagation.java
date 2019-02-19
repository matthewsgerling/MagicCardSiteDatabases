package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.HolderDetails;
import model.MagicCards;

/**
 * Servlet implementation class HolderNavagation
 */
@WebServlet("/HolderNavagation")
public class HolderNavagation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HolderNavagation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HolderDetailsHelper hdh = new HolderDetailsHelper();
		String act = request.getParameter("doThisToItem");

		if (act == null) {
			getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
		} else if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				HolderDetails listToDelete = hdh.searchForListById(tempId);
				hdh.deleteItem(listToDelete);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to click a button");
			} finally {
				getServletContext().getRequestDispatcher("/AllHandServlet").forward(request, response);
			}

		} else if (act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				HolderDetails listToEdit = hdh.searchForListById(tempId);
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
				getServletContext().getRequestDispatcher("/edit-list.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
			}

		} else if (act.equals("add")) {
			getServletContext().getRequestDispatcher("/addItemsForListServlet").forward(request, response);
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
