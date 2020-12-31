package com.company;

import java.util.*;

public class Theatre {
    private final String theatreName;
    private List<Seat> seats = new LinkedList<>();

    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;
        int lastRow = 'A' + (numRows - 1);
        for(char row='A'; row<=lastRow; row++){
            for(int seatnum=0; seatnum<seatsPerRow; seatnum++){
                double price = 100;

                if((row < 'D') && (seatnum >= 4 && seatnum <= 9)){
                    price = 180;
                } else if((row > 'F') || (seatnum < 4 || seatnum >9)){
                    price = 70;
                }

                Seat seat = new Seat((row +  Integer.toString(seatnum)), price);
                seats.add(seat);
            }
        }
    }


    public String getTheatreName() {
        return theatreName;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public boolean reserveSeat(String seatNumber){
        Seat requestedSeat = new Seat(seatNumber, 0);
        int foundSeat = Collections.binarySearch(seats, requestedSeat);
        if(foundSeat >=0 ){
            return seats.get(foundSeat).reserve();
        } else {
            System.out.println("There is no seat " + seatNumber);
            return false;
        }

//        for(Seat seat: seats){
//            if(seat.getSeatNumber().equals(seatNumber)){
//                requestedSeat = seat;
//                break;
//            }
//        }
//        if(requestedSeat == null){
//            System.out.println("There is no seat" + seatNumber);
//            return false;
//        }
//        return requestedSeat.reserve();

    }





    public class Seat implements Comparable<Seat>{
        private final String seatNumber;
        private boolean reserved = false;
        private double price;

        public Seat(String seatNumber, double price){
            this.seatNumber = seatNumber;
            this.price = price;
        }


        public String getSeatNumber() {
            return seatNumber;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }

        public boolean reserve() {
            if(!this.reserved){
                this.reserved = true;
                System.out.println("Seat " + seatNumber + " reserved");
                return true;
            } else {
                return false;
            }
        }


        public boolean cancel(){
            if(this.reserved){
                this.reserved = false;
                System.out.println("Reservation of seat " + seatNumber + " cancelled");
                return true;
            } else {
                return false;
            }
        }


    }

}
