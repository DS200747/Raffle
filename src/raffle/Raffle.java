package raffle;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class Raffle {

    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static ArrayList<Integer> PurchasedTickets = new ArrayList<>();
    private static ArrayList<String> People = new ArrayList<>();
    private static boolean winner = false;

    public static void raffleMenu() {

        Random rand = new Random();

        try {
            System.out.println("What is your name?");
            String name = input.readLine();
            People.add(name);
            System.out.println("How many tickets would you like?");
            int tickets = Integer.parseInt(input.readLine());

            System.out.println(name + ", your ticket numbers are: ");

            for (int i = 0; i < tickets; i++) {
                int ticketNum = rand.nextInt((50 - 1) + 1) + 1;
                System.out.print(" " + ticketNum + " ");
                PurchasedTickets.add(ticketNum);
            }

        } catch (Exception e) {
            System.out.println("EXCEPTION: ERROR OCCURED");
        }
    }

    public static void ticketCheck() {
        int won = 0;
        try {
            System.out.println("What is your name?");
            String person = input.readLine();
            System.out.println(PurchasedTickets.size());
            if (People.contains(person)) {
                System.out.println("Your tickets are " + PurchasedTickets);
                System.out.println("Checking if you have won...");
                int j = 0;
                int flag = 0;
                for (int i = 0; i < PurchasedTickets.size(); i++) {
                    int m = PurchasedTickets.get(i) / 2;
                    flag =0;
                    if (PurchasedTickets.get(i) == 0 || PurchasedTickets.get(i) == 1) {
                        System.out.println("You have not won with ticket " + PurchasedTickets.get(i));
                    } else {
                        for (j = 2; j <= m; j++) {
                            if (PurchasedTickets.get(i) % j == 0) {
                                System.out.println("You have not won with ticket " + PurchasedTickets.get(i));
                                flag = 1;
                                break;
                            }
                        }
                        if (flag == 0) {
                            System.out.println("You have won with ticket " + PurchasedTickets.get(i));
                            won++;
                        }
                    }
                }
            } else {
                System.out.println("You have not purchased any tickets recently.");
            }
        } catch (Exception e) {
            System.out.println("ERROR: EXCEPTION OCCURED.");
        }

        if (won == 0) {
            System.out.println("You have no winning tickets.");
            winner = false;
        } else if (won > 0) {
            System.out.println("You have " + won + " winning tickets!");
            winner = true;
        }
        System.out.println("Clering tickets from system...");
        PurchasedTickets.clear();
        People.clear();
    }

    public static void main(String[] args) {

        boolean check = false;

        System.out.println("Welcome! Prime numbers are winners in the raffle! \n Please make a selection:");
        do {
            try {
                System.out.println("\n Would you like to buy, check or neither?");
                String answer = input.readLine();

                switch (answer) {
                    case ("buy"):
                        raffleMenu();
                        break;
                    case ("check"):
                        ticketCheck();
                        break;
                    case ("neither"):
                        System.out.println("Okay! Bye!");
                        check = true;
                        break;
                    default:
                        System.out.println("ERROR: Inavlid answer.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("EXCEPTION: ERROR OCCURED");
            }
        } while (check == false);

    }

}
