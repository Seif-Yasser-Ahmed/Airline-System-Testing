package com.example.ainline_system_team5;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static jdk.internal.org.jline.utils.AttributedCharSequence.ForceMode.None;

public class Person {
    String firstname;
    String lastname;
    int id;
    int Age;
    char gender;
    private static int nextId = 0;
    String address;
    int phone_num;
    String email;
    String password;
    private ArrayList<Booking> bookingHistory= new ArrayList<Booking>();
    public static ArrayList<Person> PersonList = new ArrayList<Person>();
    private Map idmap=new HashMap();
    public Person() {
    	this.id=nextId;
    	nextId++;
    	PersonList.add(this);
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
    public Person(String fname,String lname,String pass,String mail,int phone,String add){
        this.firstname=fname;
        this.lastname=lname;
        this.email=mail;
        this.password=pass;
        this.phone_num=phone;
        this.address=add;
        this.id=nextId;
    	nextId++;
        PersonList.add(this);
//        idmap.put(id,this);
    }

    public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getFirstname(){
        return this.firstname;
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
    public void removeBooking(Booking booking) {
    	bookingHistory.remove(booking);
    }
    public List<Booking> getBookings(){
        return bookingHistory;
    }
    public Map getIdmap(){
        return idmap;
    }
    public String getPersonDetails() {
    	StringBuilder details = new StringBuilder();
        details.append("Person ID: ").append(id).append("\n");
        details.append("First Name: ").append(firstname).append("\n");
        details.append("Second Name: ").append(lastname).append("\n");
        details.append("Phone Number: ").append(phone_num).append("\n");
        details.append("Email: ").append(email).append("\n");
//        details.append("Bookings: ").append(bookingHistory).append("\n");
        details.append("Address: ").append(address).append("\n");
      
        return details.toString();
    }
    public List<Flight> searchFlights(Airport from ,Airport to){
    	Airport airport=new Airport();
    	return airport.searchFlights(from, to);
    }
    public Booking getBookingDetails(String id) {
    	for(int i=0;i<bookingHistory.size();i++) {
    		if(bookingHistory.get(i).bookingID.equals(id)) {
    			return bookingHistory.get(i);
    		}
    	}
    	return null;
    } 



}
