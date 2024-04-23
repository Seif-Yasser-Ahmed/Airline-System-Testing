package com.example.ainline_system_team5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tickets {

    private static List<String> issuedTicketIds = new ArrayList<>();
    
    private Seat seat;
    private Customer passenger; // to gather passenger data
    private Flight flight; // to gather flight data (plane capacity, date, etc.)
    private String ticketId; // ticketId = seatnum+destinationCode
    private boolean isBusiness;
    private boolean isEconomy;
    private String status; //Confirmed, pending or cancelled
    private String seatNum; // 000, 001,.., 400 (max)
    private double price; // depends on age + there is tax
    private int baggageAllowance; // weight and no. of bags allowed

    public Tickets(Seat seat, Customer passenger, Flight flight, boolean isBusiness, boolean isEconomy,
                   String status, String seatNum, double price, int baggageAllowance) {
        this.passenger = passenger;
        this.flight = flight;
        this.isBusiness = isBusiness;
        this.isEconomy = isEconomy;
        this.status = status;
        this.price = price;
        this.baggageAllowance = baggageAllowance;

        setTicketId(seat.getSeatNumber().toString(), flight.getFlightIdAsString());
      
        setSeatNum(seatNum);
        setFlightId(flight.getFlightID());
    }
    
    public Tickets() {}
    
    //getters 
    
    public Customer getPassenger() {
        return passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public boolean isBusiness() {
        return isBusiness;
    }

    public boolean isEconomy() {
        return isEconomy;
    }

    public String getStatus() {
        return status;
    }

    public String getSeatNum() {
        return seatNum;
    }

    public double getPrice() {
        return price;
    }

    public int getBaggageAllowance() {
        return baggageAllowance;
    }
    
    public String getTicketId() {
        return ticketId;
    }
    
    //setters
    
    public void setPassenger(Customer passenger) {
        if (passenger != null) {
            this.passenger = passenger;
        } else {
            System.out.println("Error: Passenger can't be null.");
        }
    }
    
    public void setFlight(Flight flight) {
        
        if (flight != null) {
             this.flight = flight;
         } else {
             System.out.println("Error: Flight can't be null.");
         }
    }
    
    
    public void setTicketId(String seatNum, String flightId) {
        Scanner scanner = new Scanner(System.in);
        String newTicketId = flightId + seatNum;

        while (issuedTicketIds.contains(newTicketId)) {
            System.out.println("Seat already occupied");
            System.out.print("Enter a valid seat number: ");
            String validSeatNum = scanner.nextLine();
            newTicketId = flightId + formatSeatOrFlightId(validSeatNum); 
            seatNum = validSeatNum;
        }
        issuedTicketIds.add(newTicketId);

        this.ticketId = newTicketId;
        this.seatNum = seatNum;
    }

    public void setSeatNum(String seatNum) {
        Scanner scanner = new Scanner(System.in);
        String inputSeatNum;
        do {
            System.out.print("Enter seat number (3 characters or less): ");
            inputSeatNum = scanner.nextLine();
            if (inputSeatNum.length() > 3) {
                System.out.println("Error: Seat number cannot be greater than 3 characters.");
            }
        } while (inputSeatNum.length() > 3);
        this.seatNum = formatSeatOrFlightId(inputSeatNum);
    }

    public void setFlightId(int flightId) {
        Scanner scanner = new Scanner(System.in);
        String inputFlightId;
        do {
            System.out.print("Enter flight ID (3 characters or less): ");
            inputFlightId = scanner.nextLine();
            if (inputFlightId.length() > 3) {
                System.out.println("Error: Flight ID cannot be greater than 3 characters.");
            }
        } while (inputFlightId.length() > 3);
//        flight.setFlightID(formatSeatOrFlightId(inputFlightId));
    }


    public String formatSeatOrFlightId(String id) {
        if (id.length() == 1) {
            return "00" + id;
        } else if (id.length() == 2) {
            return "0" + id;
        } else if (id.length() == 3) {
            return id;
        } else {
            return "000"; // Default value if the length is greater than 3
        }
    }


    public List<String> getIssuedTicketIds() {
        return issuedTicketIds;
    }

    public void setClassType(boolean isBusiness, boolean isEconomy) {
        if (isEconomy == isBusiness) {
            System.out.println("Error, economy and business can't have same value");
        } else {
            this.isEconomy = isEconomy;
            this.isBusiness = isBusiness;
        }
    }
    
    public void setStatus(String status) {
        if("Cancelled".equals(status) || "Pending".equals(status) || "Purchased".equals(status)) {
            this.status = status;
        } else {
            System.out.println("Invalid status");
        }
    }

    public void setPrice(double price) {
        if (passenger != null) {
            if (passenger.getAge() < 15) {
                this.price = price - (price * 0.5);
            } else {
                this.price = price;
            }
        } else {
            System.out.println("Error: Passenger information is missing.");
        }
    }

    public void setBaggageAllowance(int baggageAllowance) {
        if (baggageAllowance >= 15 && baggageAllowance <= 30) {
            this.baggageAllowance = baggageAllowance;
        } else {
            System.out.println("Invalid baggage allowance");
        }
    }

}
