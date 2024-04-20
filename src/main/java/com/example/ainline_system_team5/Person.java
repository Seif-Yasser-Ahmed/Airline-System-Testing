package com.example.ainline_system_team5;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static jdk.internal.org.jline.utils.AttributedCharSequence.ForceMode.None;

public class Person {
    String firstname;
    String lastname;
    int id;
    private static int nextId = 1;
    String address;
    int phone_num;
    String email;
    String password;
    private List<Booking> bookingHistory;
    private List<Person> PersonList;
    private Map idmap=new HashMap();
    public Person() {
    	this.id=nextId;
    	nextId++;
    }
//    public Person(int id) {
//    	this.id=id;
//    	idmap.put(idmap, this);
//    }
    public Person(String fname,String lname){
        this.firstname=fname;
        this.lastname=lname;
        this.id=nextId;
        nextId++;
    	
        PersonList.add(this);
        
//        idmap.put(id,this);
    }
    public Person(String fname,String lname,int id,String pass,String mail,int phone,String add){
        this.firstname=fname;
        this.lastname=lname;
        this.id=id;
        this.email=mail;
        this.password=pass;
        this.phone_num=phone;
        this.address=add;
        this.id=nextId;
    	nextId++;
        PersonList.add(this);
//        idmap.put(id,this);
    }

    public String getFirstname(){
        return firstname;
    }
    public String getFullName(){
        return (firstname+" "+lastname);
    }
    //Tested
    public void setFirstName(String fname){
        firstname=fname;
    }
    //Tested
    public void setLastName(String lname){
        lastname=lname;
    }
    //Tested
    public void setPassword(String pass){
        this.password=pass;
    }
    public int getId() {
        return id;
    }
    //Tested
    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }
    //Tested
    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone_num() {
        return phone_num;
    }
    //Tested
    public void setPhone_num(int phone_num) {
        this.phone_num = phone_num;
    }

    public String getEmail() {
        return email;
    }
    //Tested
    public void setEmail(String email) {
        this.email = email;
    }
    //To be Tested after Booking.java is implemented
    public void addBooking(Booking booking) {
    	bookingHistory.add(booking);
    }
    public List<Booking> getBookings(){
        return bookingHistory;
    }
    public Map getIdmap(){
        return idmap;
    }

    //------ To be moved to: Booking.java
//    public void addBooking(Booking booking){
//        bookingHistory.add(booking);
//    }
    //------ To be moved to: Flight.java
//    public Flight searchflight(Airport from,Airport to){
//        for(int x=0;x<Airport.flights.size();x++){
//            if (Airport.flights.get(x).from==from &&Airport.flights.get(x).to==to){
//                return Airport.flights.get(x);
//            }
//        }
//        return null;
//    }
//    public Flight.flightstatus getFlightStatus(){
//        return Flight.status;
//    }



}
