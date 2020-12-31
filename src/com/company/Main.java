package com.company;

import java.util.*;
public class Main {

    public static void main(String[] args) {
        // write your code here
        Theatre theatre = new Theatre("Inox", 4, 10);
        List<Theatre.Seat> seatCopy = new ArrayList<>(theatre.getSeats());
        List<Theatre.Seat> seatCopy2 = new ArrayList<>(theatre.getSeats());

        System.out.println("\nPrinting seats");
        printList(seatCopy);

//        seatCopy.get(1).reserve();

//        theatre.getSeats();

//        if(theatre.reserveSeat("A1")){
//            System.out.println("Please Pay");
//        } else {
//            System.out.println("Sorry, seat is taken");
//        }

        Collections.reverse(seatCopy);
        System.out.println("Printing reverse");
        printList(seatCopy);

        Collections.shuffle(seatCopy2);
        System.out.println("Printing shuffled");
        printList(seatCopy2);

        System.out.println("After swapping 1st and 2nd seat in the original seat list");
        Collections.swap(theatre.getSeats(), 0, 1);
        printList(theatre.getSeats());


        Theatre.Seat minSeat = Collections.min(theatre.getSeats());
        Theatre.Seat maxSeat = Collections.max(theatre.getSeats());
        System.out.println("The first seat -> " + minSeat.getSeatNumber());
        System.out.println("The last seat -> " + maxSeat.getSeatNumber());

        List<Theatre.Seat> priceSeats = new ArrayList<>(theatre.getSeats());
        priceSeats.add(theatre.new Seat("A00", 182));
        priceSeats.add(theatre.new Seat("B00", 182));
        System.out.println("priceList");
        //Collections.sort(priceSeats); //using compareTo
        Collections.sort(priceSeats, PRICE_ORDER); //using Comparator
        printList(priceSeats);


//        printList(seatCopy);
//        if(theatre.reserveSeat("C1")){
//            System.out.println("Please Pay");
//        } else {
//            System.out.println("Sorry, seat is taken");
//        }
    }

    static final Comparator<Theatre.Seat> PRICE_ORDER = new Comparator<Theatre.Seat>() {
        @Override
        public int compare(Theatre.Seat seat1, Theatre.Seat seat2) {
            if(seat1.getPrice() > seat2.getPrice())
                return 1;
            else if(seat1.getPrice() < seat2.getPrice())
                return -1;
            else
                return 0;
        }
    };



    public static void printList(List<Theatre.Seat> list){
//        System.out.println("Printing " + list);
        for(Theatre.Seat seat: list){
            System.out.println(" " + seat.getSeatNumber() + " -> Rs." + seat.getPrice());
        }
        System.out.println();
        System.out.println("=====================================================\n");
    }
}
