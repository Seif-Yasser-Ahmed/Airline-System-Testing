package com.example.ainline_system_team5;

import static jdk.internal.org.jline.utils.AttributedCharSequence.ForceMode.None;

public class Person {
    String firstname;
    String lastname;
    int id;
    String address;
    long phone_num;
    String email;
    String password;
    public Flight searchflight(Airport from,Airport to){
        for(int x=0;x<Airport.flights.size();x++){
            if (Airport.flights.get(x).from==from&&Airport.flights.get(x).to==to){
                return Airport.flights.get(x);
            }
        }
        return null;
    }
    public Flight.flightstatus getFlightStatus(){
        return Flight.status;
    }

}
