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
import model.HolderDetails;
import model.MagicCards;

/**
 * Servlet implementation class createNewHand
 */
@WebServlet("/createNewHand")
public class createNewHand extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createNewHand() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MagicCardHelper mch = new MagicCardHelper();
		String HandName = request.getParameter("HandName");
		System.out.println("Hand Name: "+ HandName);
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String shopperName = request.getParameter("holderName");
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		}catch(NumberFormatException ex) {
			ld = LocalDate.now();
		}
		String[] selectedItems = request.getParameterValues("allcardsToAdd");
		List<MagicCards> selectedCardsInList = new ArrayList<MagicCards>();
		if (selectedItems != null && selectedItems.length > 0) {
			for(int i = 0; i<selectedItems.length; i++) {
				System.out.println(selectedItems[i]);
				MagicCards m = mch.searchForItemByID(Integer.parseInt(selectedItems[i]));
				selectedCardsInList.add(m);
			}
		}
		CardHolder holder = new CardHolder(shopperName);
		HolderDetails hd = new HolderDetails(HandName, ld, holder);
		hd.setListOfCards(selectedCardsInList);
		HolderDetailsHelper hdh = new HolderDetailsHelper();
		hdh.insertNewListDetails(hdh);
		System.out.println("Success!");
		System.out.println(hd.toString());
		getServletContext().getRequestDispatcher("/AllHandsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}