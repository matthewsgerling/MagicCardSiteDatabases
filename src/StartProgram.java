import java.util.List;
import java.util.Scanner;

import controller.MagicCardHelper;
import model.MagicCards;

public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static MagicCardHelper mch = new MagicCardHelper();

		private static void addAnItem() {
			System.out.print("Enter a Name: ");
			String name = in.nextLine();
			System.out.print("Enter the Type: ");
			String type = in.nextLine();
			System.out.print("Enter the Mana Cost: ");
			int manacost = in.nextInt();
			
			MagicCards toAdd = new MagicCards(name, type, manacost);
			mch.insertItem(toAdd);
		}

		private static void deleteAnItem() {
			System.out.print("Enter the Name to delete: ");
			String name = in.nextLine();
			System.out.print("Enter the Type to delete: ");
			String type = in.nextLine();
			System.out.print("Enter the Mana Cost to delete: ");
			int manacost = in.nextInt();
			MagicCards toDelete = new MagicCards(name, type, manacost);
			mch.deleteItem(toDelete);
		}

		private static void editAnItem() {
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Name");
			System.out.println("2 : Search by Type");
			int searchBy = in.nextInt();
			in.nextLine();
			List<MagicCards> foundType;
			if (searchBy == 1) {
				System.out.print("Enter the name of the card: ");
				String Name = in.nextLine();
				foundType = mch.searchForItemByName(Name);
			} else {
				System.out.print("Enter the type: ");
				String type = in.nextLine();
				foundType = mch.searchForItemByType(type);

			}

			if (!foundType.isEmpty()) {
				System.out.println("Found Results.");
				for (MagicCards c : foundType) {
					System.out.println(c.getId() + " : " + c.toString());
				}
				System.out.print("Which card to edit: ");
				int idToEdit = in.nextInt();

				MagicCards toEdit = mch.searchForItemByID(idToEdit);
				System.out.println("Retrieved " + toEdit.getName() + " A/An " + toEdit.getType() + " Card with Mana Cost of " + toEdit.getManaCost());
				System.out.println("1 : Update Name");
				System.out.println("2 : Update Type");
				System.out.println("3 : Update Mana Cost");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Name: ");
					String newName = in.nextLine();
					toEdit.setName(newName);
				} else if (update == 2) {
					System.out.print("New type: ");
					String newType = in.nextLine();
					toEdit.setType(newType);
				} else if (update == 3) {
					System.out.print("New Mana Cost: ");
					int newManaCost = in.nextInt();
					toEdit.setManaCost(newManaCost);
				} 

				mch.updateItem(toEdit);

			} else {
				System.out.println("---- No results found");
			}

		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Magic Card list ---");
			while (goAgain) {
				System.out.println("*  Select an item:");
				System.out.println("*  1 -- Add an item");
				System.out.println("*  2 -- Edit an item");
				System.out.println("*  3 -- Delete an item");
				System.out.println("*  4 -- View the list");
				System.out.println("*  5 -- Exit the program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addAnItem();
				} else if (selection == 2) {
					editAnItem();
				} else if (selection == 3) {
					deleteAnItem();
				} else if (selection == 4) {
					viewTheList();
				} else {
					//lih.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			// TODO Auto-generated method stub
			List<MagicCards> allItems = mch.showAllItems();
			for(MagicCards singleItem : allItems){
				System.out.println(singleItem.returnCardDetails());
			}
		}

	}