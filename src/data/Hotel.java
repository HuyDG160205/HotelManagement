/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Gia Huy
 */
public class Hotel {

    private String hotel_Id;
    private String hotel_Name;
    private int hotel_Room_Available;
    private String hotel_Addess;
    private int hotel_Phone;
    private int hotel_Rating;

    public Hotel(String hotel_Id, String hotel_Name, int hotel_Room_Available, String hotel_Addess, int hotel_Phone, int hotel_Rating) {
        this.hotel_Id = hotel_Id;
        this.hotel_Name = hotel_Name;
        this.hotel_Room_Available = hotel_Room_Available;
        this.hotel_Addess = hotel_Addess;
        this.hotel_Phone = hotel_Phone;
        this.hotel_Rating = hotel_Rating;
    }

    public int getHotel_Phone() {
        return hotel_Phone;
    }

    public String getHotel_Id() {
        return hotel_Id;
    }

    public String getHotel_Name() {
        return hotel_Name;
    }

    public int getHotel_Room_Available() {
        return hotel_Room_Available;
    }

    public String getHotel_Addess() {
        return hotel_Addess;
    }

    public int getHotel_Rating() {
        return hotel_Rating;
    }

    public void setHotel_Name(String hotel_Name) {
        this.hotel_Name = hotel_Name;
    }

    public void setHotel_Room_Available(int hotel_Room_Available) {
        this.hotel_Room_Available = hotel_Room_Available;
    }

    public void setHotel_Addess(String hotel_Addess) {
        this.hotel_Addess = hotel_Addess;
    }

    public void setHotel_Phone(int hotel_Phone) {
        this.hotel_Phone = hotel_Phone;
    }

    public void setHotel_Rating(int hotel_Rating) {
        this.hotel_Rating = hotel_Rating;
    }

    
    public void ShowInFor() {
        String str = String.format(
                "%s|%s|%2d|%-10s|%d|%d",
                hotel_Id,
                hotel_Name,
                hotel_Room_Available,
                hotel_Addess,
                hotel_Phone,
                hotel_Rating
        );
        System.out.println(str);
    }

    @Override
    public String toString() {
        String str = String.format(
                "%s|%s|%2d|%-10s|%d|%d",
                hotel_Id,
                hotel_Name,
                hotel_Room_Available,
                hotel_Addess,
                hotel_Phone,
                hotel_Rating
        );
        return str;
    }

}
