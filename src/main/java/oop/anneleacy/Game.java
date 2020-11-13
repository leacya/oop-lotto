package oop.anneleacy;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Himansh Arora
 */
public class Game
{

    private ArrayList<Ticket> tickets = new ArrayList<>();
    private ArrayList<Integer> winningNumbers = new ArrayList<>();
    private int jackpotAmount;
    private int match3Amount;
    private int maxRange;

    public Game(ArrayList<Ticket> tickets, ArrayList<Integer> winningNumbers, int jackpotAmount, int Match3Amount, int maxRange)
    {
        this.tickets = tickets;
        this.winningNumbers = winningNumbers;
        this.jackpotAmount = jackpotAmount;
        this.match3Amount = Match3Amount;
        this.maxRange = maxRange;
    }

    public Game(ArrayList<Ticket> tickets)
    {
        this.tickets = tickets;
    }

    public Game(int jackpotAmount, int Match3Amount, int maxRange)
    {
        this.jackpotAmount = jackpotAmount;
        this.match3Amount = Match3Amount;
        this.maxRange = maxRange;
        tickets = new ArrayList<>();
    }

    /**
     * adds a ticket to Game if not null
     *
     * @param t new ticket added to Game
     */
    public void addTicket(Ticket t)
    {
        if (t != null)
        {
            tickets.add(t);
        }
    }

    /**
     * gets the tickets of the Game
     *
     * @return the tickets of the Game
     */
    public ArrayList<Ticket> getTickets()
    {
        return tickets;
    }

    /**
     * gets the winning numbers of the Game
     *
     * @return the winning numbers of the Game
     */
    public ArrayList<Integer> getWinningNumbers()
    {
        return winningNumbers;
    }

    /**
     * gets the Jackpot amount of the Game
     *
     * @return the Jackpot amount of the Game
     */
    public int getJackpotAmount()
    {
        return jackpotAmount;
    }

    /**
     * gets the Match3 amount of the Game
     *
     * @return the Match3 amount of the Game
     */
    public int getMatch3Amount()
    {
        return match3Amount;
    }

    /**
     * gets the maximum range of the Game
     *
     * @return the maximum range of the Game
     */
    public int getMaxRange()
    {
        return maxRange;
    }

    /**
     * changes the ticket of the Game to tickets
     *
     * @param tickets new value of the ticket
     */
    public void setTickets(ArrayList<Ticket> tickets)
    {
        this.tickets = tickets;
    }

    /**
     * changes the winning numbers of the Game to winningNumbers
     *
     * @param winningNumbers new value of winning numbers
     */
    public void setWinningNumbers(ArrayList<Integer> winningNumbers)
    {
        this.winningNumbers = winningNumbers;
    }

    /**
     * changes the Jackpot amount of the Game to jackpotAmount
     *
     * @param jackpotAmount new value of Jackpot amount
     */
    public void setJackpotAmount(int jackpotAmount)
    {
        this.jackpotAmount = jackpotAmount;
    }

    /**
     * changes the Match3 amount of the Game to Match3Amount
     *
     * @param Match3Amount new value of Match3 amount
     */
    public void setMatch3Amount(int Match3Amount)
    {
        this.match3Amount = Match3Amount;
    }

    /**
     * changes the maximum range of the Game to maxRange
     *
     * @param maxRange new value of maximum range
     */
    public void setMaxRange(int maxRange)
    {
        this.maxRange = maxRange;
    }

    /**
     * displays all the tickets on the Game
     */
    public void displayAllTickets()
    {
        for (int i = 0; i < tickets.size(); i++)
        {
            System.out.println("\n" + tickets.get(i));
        }
    }

    /**
     * displays the ticket with a particular valid name
     *
     * @param names the particular name
     */
    public void displayTicket(String names)
    {
        boolean checkValid = false;
        for (int i = 0; i < tickets.size(); i++)
        {
            if (names.equalsIgnoreCase(tickets.get(i).getName()))
            {
                System.out.println("\n" + names + "'s Ticket = " + tickets.get(i));
                checkValid = true;
            }
        }
        if (!checkValid)                                                 //if user enters an invalid address
        {
            System.out.println("\nInvalid name entered, try again");
        }
    }

    /**
     * generates an Integer ArrayList of 4 distinct randomly generated, sorted
     * numbers
     */
    public void drawNumbers()
    {
        Random rand = new Random();
        for (int i = 0; i < 4; i++)
        {
            winningNumbers.add(rand.nextInt(maxRange) + 1);
            int j = 0;
            while (j < i)
            {
                if (winningNumbers.get(i) == winningNumbers.get(j))
                {
                    i--;
                }
                j++;
            }
        }
        Collections.sort(winningNumbers);
    }

    /**
     * displays the names of people with 'x' number of matches
     *
     * @param x any integer
     */
    public void displayMatches(int x)
    {
        for (int i = 0; i < tickets.size(); i++)
        {
            if (tickets.get(i).howManyMatches(winningNumbers) == x)
            {
                System.out.println("\n" + tickets.get(i).getName() + " has got " + x + " matches!");
            }
        }
        if (x < 0 || x > winningNumbers.size())                           //if user enters any negative number, or
        {                                                                 // a number greater than max matches possible
            System.out.println("\nPlease enter a valid number and try again");
        }
    }

    /**
     * displays people with a particular address
     *
     * @param address the particular address
     */
    public void displayPlayersWithAddress(String address)
    {
        boolean checkValid = false;

        System.out.println("\nFollowing is the list of people from " + address);

        for (int i = 0; i < tickets.size(); i++)
        {
            if (address.equalsIgnoreCase(tickets.get(i).getAddress()))
            {
                System.out.println(tickets.get(i).getName());
                checkValid = true;
            }
        }
        if (!checkValid)                                                         //if user enters an invalid address
        {
            System.out.println("\nInvalid address entered, try again");
        }
    }

    /**
     * returns the count of people who chose a particular number
     *
     * @param num the particular number
     * @return the count
     */
    public int countWhoChoseNumber(int num)
    {
        int count = 0;
        for (int i = 0; i < tickets.size(); i++)
        {
            for (int j = 0; j < tickets.get(i).getNumsChosen().size(); j++)
            {
                if (num == tickets.get(i).getNumsChosen().get(j))
                {
                    count++;
                }
            }
        }
        if (num < 0 || num > maxRange)                                    //if user enters any negative number, or
        {                                                                 // a number greater than maximum range
            System.out.println("\nPlease enter a valid number and try again");
        }
        return count;
    }

    /**
     * displays the people who chose Invalid range of numbers
     */
    public void displayInvalidRangeTickets()
    {
        for (int i = 0; i < tickets.size(); i++)
        {
            for (int j = 0; j < tickets.get(i).getNumsChosen().size(); j++)
            {
                if (tickets.get(i).getNumsChosen().get(j) < 1 || tickets.get(i).getNumsChosen().get(j) > maxRange)
                {
                    System.out.println("\n" + tickets.get(i).getName());
                }
            }
        }
    }

    /**
     * displays the people who chose a same number more than once
     */
    public void displayNonUniqueTickets()
    {
        for (int i = 0; i < tickets.size(); i++)
        {
            for (int j = 0; j < tickets.get(i).getNumsChosen().size(); j++)
            {
                for (int k = 0; k < tickets.get(i).getNumsChosen().size(); k++)
                {
                    if (k > j && tickets.get(i).getNumsChosen().get(j) == tickets.get(i).getNumsChosen().get(k))
                    {
                        System.out.println("\n" + tickets.get(i).getName());
                    }
                }
            }
        }
    }



//     Some additional improvements
//
//


    /**
     * displays all the statistics of the matches in Game
     */
    public void displayAllMatches()
    {
        System.out.printf("\n%-10s%4s\n", "Name", "Matches");
        for (int i = 0; i < tickets.size(); i++)
        {
            System.out.printf("%-10s%4d\n",tickets.get(i).getName(), tickets.get(i).howManyMatches(winningNumbers));
        }
    }

    /**
     * displays the people who won an amount
     */
    public void displayWinners()
    {
        System.out.println("\nFollowing person(s) hit the Jackpot!");
        for (int i = 0; i < tickets.size(); i++)
        {
            if (tickets.get(i).howManyMatches(winningNumbers) == 4)
            {
                System.out.println(tickets.get(i).getName());
            }
        }

        System.out.println("\nFollowing person(s) won the Match3 Amount!");
        for (int i = 0; i < tickets.size(); i++)
        {
            if (tickets.get(i).howManyMatches(winningNumbers) == 3)
            {
                System.out.println(tickets.get(i).getName());
            }
        }
        System.out.println("\n*prize will be distributed equally if more than 1 person wins");
    }

    /**
     * Displays the names of people that have Ticket with the same names
     */
    public void displayTicketsWithSameName()
    {
        System.out.println("\nFollowing is the list of tickets with same name");
        for (int i = 0; i < tickets.size(); i++)
        {
            for (int j = 0; j < tickets.size(); j++)
            {
                if (i != j && tickets.get(i).getName().equalsIgnoreCase(tickets.get(j).getName()))
                {
                    System.out.println(tickets.get(i));
                }
            }
        }
    }

    /**
     * Displays the number of matching numbers for person(s) called name
     *
     * @param name the name entered
     */
    public void displayMatchesByName(String name)
    {
        boolean checkValid = false;

        for (int i = 0; i < tickets.size(); i++)
        {
            if (name.equalsIgnoreCase(tickets.get(i).getName()))
            {
                System.out.println("\n" + name + "'s Ticket= " + tickets.get(i).howManyMatches(winningNumbers) + " matches");
                checkValid = true;
            }
        }
        if (!checkValid)                                                         //if user enters an invalid name
        {
            System.out.println("\nInvalid name entered, try again");
        }
    }

    /**
     * Display all the player names in an ascending order
     */
    public void displayPlayersAsc()
    {
        ArrayList<String> SortedNames = new ArrayList<>();
        for (int i = 0; i < tickets.size(); i++)
        {
            SortedNames.add(tickets.get(i).getName());
        }
        Collections.sort(SortedNames);
        System.out.println("\n" + SortedNames);

    }

    /**
     * Display all the player names in an descending order
     */
    public void displayPlayersDesc()
    {
        ArrayList<String> SortedNames = new ArrayList<>();
        for (int i = 0; i < tickets.size(); i++)
        {
            SortedNames.add(tickets.get(i).getName());
        }
        Collections.sort(SortedNames);
        Collections.reverse(SortedNames);
        System.out.println("\n" + SortedNames);

    }

    @Override
    public String toString()
    {
        return "Game{" + "Tickets=" + tickets + ", \nWinning Numbers=" + winningNumbers + ", \nJackpot Amount=" + jackpotAmount + ", \nMatch3 Amount=" + match3Amount + ", \nMaximum Range=" + maxRange + '}';
    }

    /**
     * Read the Ticket details from text file filename
     * @param fileName
     * @throws FileNotFoundException
     */
    public void readData(String fileName) throws FileNotFoundException
    {
        Scanner TicketData = new Scanner(new File(fileName));

        while (TicketData.hasNext())
        {
            addTicket(new Ticket(TicketData.next(), TicketData.next(), TicketData.nextLong(), TicketData.nextInt(), TicketData.nextInt(), TicketData.nextInt(), TicketData.nextInt()));
        }
    }

}

