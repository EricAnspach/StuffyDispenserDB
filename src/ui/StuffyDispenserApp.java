
package ui;

import business.Stuffy;
import db.StuffyDB;
import util.Console;

import java.sql.SQLException;
import java.util.*;



public class StuffyDispenserApp {

	public static void main(String[] args) {
		StuffyDB stuffyDB = new StuffyDB();		

		Console.displayLine("Welcome to the Stuffy Dispenser Application!\n");
		int option;

		do {
			Console.displayLine("\nMenu");
			Console.displayLine("1 - List all Stuffy");
			Console.displayLine("2 - Grab a Stuffy");
			Console.displayLine("3 - Add a Stuffy");
			Console.displayLine("4 - Update a Stuffy");
			Console.displayLine("5 - Exit\n");

			option = Console.getInt("Enter option: ", 0, 6);

			switch (option) {
				case 1:
					// get a list of all stuffies
					try {
						List<Stuffy> stuffies = stuffyDB.getAll();
						Console.displayLine("Stuffies List:");
						for (Stuffy s : stuffies) {
							System.out.println(s.toString());
						}
					} catch (SQLException e) {
						System.out.println("Exception occurred getting all stuffies.");
						e.printStackTrace();
					}
					break;
				case 2:
					// Grab stuffy
					try {
						List<Stuffy> stuffies = stuffyDB.getAll();

						int size = stuffies.size();
						int randomInt = (int)((Math.random() * size) + 1);
						Stuffy stuffy = stuffies.get(randomInt);
						
						if (stuffyDB.delete(stuffy)) {
							System.out.println("You got a stuffy! " + stuffy);
						}
					} catch (SQLException e) {
						System.out.println("Exception occurred getting a stuffy.");
						e.printStackTrace();
					}
					break;
				case 3:
					// Add Stuffy
					Console.displayLine("New Stuffy...");
					String type = Console.getString("Type?    ");
					String size = Console.getString("Size?    ");
					String color = Console.getString("Color?   ");
					Stuffy stuffy = new Stuffy(0, type, size, color);
					try {
						if (stuffyDB.add(stuffy)) {
							System.out.println(stuffy.toString());
						}
					} catch (Exception e) {
						System.out.println("Exception occurred adding a stuffy.");
						e.printStackTrace();
					}		
					break;
				case 4:
					// Update Stuffy
					int stuffyToUpdate = Console.getInt("Enter ID of stuffy to update: ");
					type = Console.getString("Type?    ");
					size = Console.getString("Size?    ");
					color = Console.getString("Color?   ");
					stuffy = new Stuffy(0, type, size, color);
					
					try {
						if(stuffyDB.update(stuffy)) {
							Console.displayLine("Stuffy was updated");
						}
					} catch (Exception e) {
						System.out.println("Exception occurred updating stuffy.");
						e.printStackTrace();
					}			

//					modify values in database for ID
					// display stuffy
					
					break;
				case 5:
					break;
			}
			
		} while (option != 5);
		Console.displayLine("\nBye!");
	}
	

}
