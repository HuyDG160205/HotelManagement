/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runtime;

import data.Hotel;
import data.HotelManagement;
import ui.Menu;

/**
 *
 * @author Gia Huy
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String url = "D:\\K19-java\\HotelManagementProgram\\Hotel.txt";
        HotelManagement h1 = new HotelManagement();
        h1.loadFromFile(url);

        Menu menu = new Menu("________Hotel Management Program________");
        menu.addNewOption("Adding new Hotel.");
        menu.addNewOption("Checking exits Hotel.");
        menu.addNewOption("Updating Hotel information.");
        menu.addNewOption("Deleting Hotel.");
        menu.addNewOption("Searching Hotel.");
        menu.addNewOption("Displaying a hotel list (descending by Hotel_Name).");
        menu.addNewOption("Others Quit.");
        Menu submenu = new Menu("__Search__");
        submenu.addNewOption("Searching by Hotel_id.");
        submenu.addNewOption("Searching by Hotel_name.");
        while (true) {
            menu.print();
            int choice = menu.getChoice();
            switch (choice) {
                case 1: {
                    h1.addNewHotel();
                    break;
                }
                case 2: {
                    h1.checkExistHotel();
                    break;
                }
                case 3: {
                    h1.updateHotel();
                    break;
                }
                case 4: {
                    h1.DeleteHotel();
                    break;
                }
                case 5: {
                    submenu.print();
                    int choice2 = submenu.getChoice();
                    switch (choice2) {
                        case 1: {
                            h1.SearchHotelById();
                            break;
                        }
                        case 2: {
                            h1.SearchHotelByName();
                            break;
                        }
                    }
                    break;
                }
                case 6: {
                    h1.showHotelList();
                    break;
                }
                case 7: {
                    h1.ExistProgram(url);
                    break;
                }
            }
        }

    }

}
