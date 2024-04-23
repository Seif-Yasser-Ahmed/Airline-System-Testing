package com.example.ainline_system_team5;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Stack;

public class Flight {
	private List<Flight> seats;
    public enum flightstatus{Static,Delayed,Tookoff,Arrived};
    private int FlightID;
    private Airport from;
    private Airport to;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private int availableSeats;
    static flightstatus status;

    public Flight() {}
    public Flight(int FlightID,Airport from,Airport to) {
    	LocalDateTime newDatetime = LocalDateTime.of(2024,4,25,12,0);
    	this.FlightID = FlightID;
    	this.from = from;
        this.to = to;
//        this.arrivalTime = arrivalTime;
        this.departureTime = newDatetime;
    }
    public Flight(int FlightID,Airport from, Airport to,flightstatus status,LocalDateTime departureTime,LocalDateTime arrivalTime) { 
        this.FlightID = FlightID;
    	this.from = from;
        this.to = to;
        this.status = status;
        Airport.flights.add(this);
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }
    
   
    public void setFlightStatus(flightstatus status){
         this.status = status;
    }
    public void setDepartureTime(LocalDateTime departureTime){
        this.departureTime = departureTime;
   }
    public void setArrivalTime(LocalDateTime arrivalTime){
        this.arrivalTime = arrivalTime;
   }
    public void setFlightID(int ID){
        this.FlightID = ID;
    }
    public Airport getFrom() {
        return from;
    }

    public Airport getTo() {
        return to;
    }
    public int getFlightID() {
        return FlightID;
    }
    public flightstatus getFlightStatus(){
        return status;
   }
    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }
    public LocalDateTime getDepartureTime() {
        return departureTime;
    }
    public String getFlightIdAsString() {
        return String.valueOf(FlightID);
    }
    @Override
    public String toString() {
        return "Flight{" +
                "flightNumber='" + FlightID + '\'' +
                ", From='" + from + '\'' +
                ", To='" + to + '\'' +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", availableSeats=" + availableSeats +
                ", Status=" + status +
                '}';
    }
	
	

}