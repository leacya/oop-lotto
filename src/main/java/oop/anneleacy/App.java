package oop.anneleacy;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Himansh Arora
 */
public class App
{

    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Are you an admin?\n[1]Yes\n[2]No");
        int admin = keyboard.nextInt();

        if (admin == 1)
        {
            final String passwordSet = "test";
            int attempts = 3;
            String passwordEntered = "";

            System.out.print("");
            passwordEntered = keyboard.nextLine();

            while (attempts-- > 0 && !passwordSet.equals(passwordEntered))
            {
                System.out.print("Enter your password: ");
                passwordEntered = keyboard.nextLine();
                if (passwordEntered.equals(passwordSet))
                {
                    System.out.println("\nWelcome!\n");
                }
                else
                {
                    System.out.println("Incorrect. Number of attempts remaining: " + attempts);
                }
            }
            if (!passwordSet.equals(passwordEntered))
            {
                System.out.println("!! Access denied !!");
                System.exit(1);
            }
        }

        Game g1 = new Game(5000, 3000, 30);

        Scanner TicketData = new Scanner(new File("ticketData.txt"));

        while (TicketData.hasNext())
        {
            g1.addTicket(new Ticket(TicketData.next(), TicketData.next(), TicketData.nextLong(), TicketData.nextInt(), TicketData.nextInt(), TicketData.nextInt(), TicketData.nextInt()));
        }

        g1.drawNumbers();

        System.out.println("Winning numbers = " + g1.getWinningNumbers());

        g1.addTicket(new Ticket("Tom", "Dublin", 123456789, g1.getWinningNumbers()));  //to make sure one person gets 4 matches
        g1.addTicket(new Ticket("Jerry", "Dundalk", 123456789, g1.getWinningNumbers().get(0), g1.getWinningNumbers().get(1), g1.getWinningNumbers().get(2), 7));   //to make sure one person gets 3 matches

        int option;

        g1.displayMenu();
        System.out.print("\nPlease enter option:");
        option = keyboard.nextInt();
        String temp = keyboard.nextLine();
        while (option != 14)
        {
            if (option == 1)
            {
                g1.displayAllTickets();
            }
            else if (option == 2)
            {
                g1.displayAllMatches();
            }
            else if (option == 3)
            {
                g1.displayNonUniqueTickets();
            }
            else if (option == 4)
            {
                g1.displayInvalidRangeTickets();
            }
            else if (option == 5)
            {
                System.out.println("Enter a valid name");
                String name = keyboard.nextLine();

                g1.displayTicket(name);
            }
            else if (option == 6)
            {
                System.out.println("Enter x");
                int x = keyboard.nextInt();

                g1.displayMatches(x);
            }
            else if (option == 7)
            {
                System.out.println("Enter address");
                String address = keyboard.nextLine();

                g1.displayPlayersWithAddress(address);
            }
            else if (option == 8)
            {
                System.out.println("Enter the number");
                int num = keyboard.nextInt();

                int count = g1.countWhoChoseNumber(num);
                System.out.println("\n" + count + " people chose number " + num + " in their ticket");
            }
            else if (option == 9)
            {
                System.out.println("Enter a valid name");
                String name = keyboard.nextLine();

                g1.displayMatchesByName(name);
            }
            else if (option == 10)
            {
                System.out.println(g1);
            }
            else if (option == 11)
            {
                g1.displayWinners();
            }
            else if (option == 12)
            {
                g1.displayTicketsWithSameName();
            }
            else if (option == 13)
            {
                System.out.println("Choose Format\n1. Ascending\n2. Descending");
                int num = keyboard.nextInt();

                if (num == 1)
                {
                    g1.displayPlayersAsc();
                }
                else if (num == 2)
                {
                    g1.displayPlayersDesc();
                }
                else
                {
                    System.out.println("Choose 1 or 2");
                }
            }
            else
            {
                System.out.println("please enter valid option [1,14]");
            }
            g1.displayMenu();
            System.out.print("Please enter option:");
            option = keyboard.nextInt();
            String tempp = keyboard.nextLine();
        }
    }

}


