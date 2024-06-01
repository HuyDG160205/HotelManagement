/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;
import javax.print.DocFlavor;
import utils.Inputter;

/**
 *
 * @author Gia Huy
 */
public class HotelManagement {

    ArrayList<Hotel> hoList = new ArrayList<>();

    public boolean loadFromFile(String url) {
        File f = new File(url);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(f));
            String line = reader.readLine();
            while (line != null) {
                StringTokenizer st = new StringTokenizer(line, "|");
                String id = st.nextToken().trim();
                String name = st.nextToken().trim();
                int room = Integer.parseInt(st.nextToken().trim());
                String address = st.nextToken().trim();
                int phone = Integer.parseInt(st.nextToken().trim());
                int rating = Integer.parseInt(st.nextToken().trim());

                hoList.add(new Hotel(id, name, room, address, phone, rating));

                line = reader.readLine();
            }
            //xong thi return true
            return true;
        } catch (Exception e) {
            System.out.println("Cannot read Hotel file: " + e);
            return false;
        }
    }

    //showList
    public void showHotelList() {
        if (hoList.isEmpty()) {
            System.out.println("There is existing");
            return;
        }
        Comparator ordByName = new Comparator<Hotel>() {
            @Override
            public int compare(Hotel o1, Hotel o2) {
                if (o1.getHotel_Name().compareTo(o2.getHotel_Name()) > 0) {
                    return 1;
                }
                return -1;
            }
        };

        Collections.sort(hoList, ordByName);
        for (Hotel hotel : hoList) {
            hotel.ShowInFor();
        }
    }

    //tìm hotel có không
    public void checkExistHotel() {
        String keyId = Inputter.getString("Input KeyId", "This field is required");
        boolean exist = false;
        for (int i = 0; i <= hoList.size() - 1; i++) {
            if (hoList.get(i).getHotel_Id().equalsIgnoreCase(keyId)) {
                System.out.println("Exist Hotel");
                exist = true;
            }
        }
        if (!exist) {
            System.out.println("No hotel Found!");
        }

    }

    public int findIndexById(String keyId) {
        for (int i = 0; i <= hoList.size() - 1; i++) {
            if (hoList.get(i).getHotel_Id().equalsIgnoreCase(keyId)) {
                return i;
            }
        }
        return -1;
    }

    //addNewHotel
    public void addNewHotel() {
        String id;
        boolean isDup;
        do {
            isDup = false;
            id = Inputter.getString("Input a new id",
                    "This field is required");
            int pos = findIndexById(id);

            if (pos != -1) {
                System.out.println("This id already exist");
                isDup = true;
            }
        } while (isDup);
        String name = Inputter.getString("Input a Name", "This field is required");
        int room = Inputter.getAnInteger("Input room", "Room must be higher than 0", 0, 100);
        String address = Inputter.getString("Input an address", "This field is required");
        int phone = Integer.parseInt(Inputter.getString("Input phone number", "This field is required", "\\d{10}"));
        int rating = Inputter.getAnInteger("Input rating", "Rating must be higher than 0 lower than 5", 0, 5);

        hoList.add(new Hotel(id, name, room, address, phone, rating));

        if (Inputter.getAnInteger("Do you want to go to add more hotel (1)", "This field is required") == 1) {
            addNewHotel();
        }
    }

    //update hotel
    public void updateHotel() {
        String keyId = Inputter.getString("Input hotelid to update", "This field is required");

        int pos = findIndexById(keyId);
        Hotel hot = pos == -1 ? null : hoList.get(pos);

        if (hot == null) {
            System.out.println("No Hotel Found!");
            return;
        } else {
            System.out.println("Hotel information before update");
            hot.ShowInFor();
            System.out.println("Updating...");
            String name = Inputter.getString("Input a Name", "This field is required");
            int room = Inputter.getAnInteger("Input room", "Room must be higher than 0", 0, 100);
            String address = Inputter.getString("Input an address", "This field is required");
            int phone = Integer.parseInt(Inputter.getString("Input phone number", "This field is required", "\\d{10}"));
            int rating = Inputter.getAnInteger("Input rating", "Rating must be higher than 0 lower than 5", 0, 5);

            hot.setHotel_Addess(address);
            hot.setHotel_Name(name);
            hot.setHotel_Phone(phone);
            hot.setHotel_Rating(rating);
            hot.setHotel_Room_Available(room);
        }
    }

    public void DeleteHotel() {
        String keyId = Inputter.getString("Input hotelid to delete", "This field is required");

        int pos = findIndexById(keyId);
        Hotel hot = pos == -1 ? null : hoList.get(pos);

        if (hot == null) {
            System.out.println("No Hotel Found!");
            return;
        } else {
            System.out.println("Hotel Information");
            hot.ShowInFor();
            if (Inputter.getAnInteger("Do you want to delete this hotel?", "This field is required") == 1) {
                hoList.remove(pos);
                System.out.println("successful");
            }
        }
    }

    public void SearchHotelById() {
        String keyId = Inputter.getString("Input hotel Id", "This field is required");
        int pos = findIndexById(keyId);
        Hotel hot = pos == -1 ? null : hoList.get(pos);

        if (hot == null) {
            System.out.println("This hotel does not exist");
        } else {
            System.out.println("The hotel information: ");
            hot.ShowInFor();
        }
    }

    public void SearchHotelByName() {
        String keyId = Inputter.getString("Input hotel Id", "This field is required");
        int pos = -1;
        for(int i = 0; i<= hoList.size() -1; i++){
            if(hoList.get(i).getHotel_Name().equalsIgnoreCase(keyId)){
                pos = i;
                break;
            }
        }
        
        Hotel hot = pos == -1 ? null : hoList.get(pos);

        if (hot == null) {
            System.out.println("This hotel does not exist");
        } else {
            System.out.println("The hotel information: ");
            hot.ShowInFor();
        }
    }
    
    public boolean ExistProgram(String url){
        File f = new File(url);
        
        try{
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(f));
        
            for (Hotel hotel : hoList) {
                writer.write(hotel.toString());
                writer.write("\n");
            }
            writer.flush();
            
            return true;
        }catch(Exception e){
            System.out.println("Exist File fail" + e);
            return false;
        }
    }

}
