package com.example.ainline_system_team5;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Stack;

public class Flight {
    enum flightstatus{Static,Delayed,Tookoff,Arrived};
    static int FlightID;
    public static Airport from;
    public static Airport to;
    LocalDateTime datetime;
    static flightstatus status=flightstatus.Static;


    public int getFlightID() {
        return FlightID;
    }

    public flightstatus getFlightStatus(){
        return status;
    }


}
