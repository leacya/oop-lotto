package oop.anneleacy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Himansh Arora
 */
public class Ticket
{

    private String name;
    private String address;
    private long phone;
    private ArrayList<Integer> numsChosen = new ArrayList<>();

    public Ticket(String name, String address, long phone, int num0, int num1, int num2, int num3)
    {
        this.name = name;
        this.address = address;
        this.phone = phone;

        numsChosen.add(num0);
        numsChosen.add(num1);
        numsChosen.add(num2);
        numsChosen.add(num3);

        this.numsChosen = numsChosen;
        Collections.sort(numsChosen);

    }

    public Ticket(String name, String address, long phone)
    {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public Ticket(String name, String address, long phone, ArrayList<Integer> numsChosen)
    {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.numsChosen = numsChosen;
    }

    public Ticket(String name, String address, ArrayList<Integer> numsChosen)
    {
        this.name = name;
        this.address = address;
        this.numsChosen = numsChosen;
    }

    public Ticket(long phone, ArrayList<Integer> numsChosen)
    {
        this.phone = phone;
        this.numsChosen = numsChosen;
    }

    public Ticket(long phone)
    {
        this.phone = phone;
    }

    public Ticket(ArrayList<Integer> numsChosen)
    {
        this.numsChosen = numsChosen;
    }

    public Ticket()
    {
    }

    /**
     * gets the name on the Ticket
     *
     * @return the name on the Ticket
     */
    public String getName()
    {
        return name;
    }

    /**
     * gets the address on the Ticket
     *
     * @return the address on the Ticket
     */
    public String getAddress()
    {
        return address;
    }

    /**
     * gets the phone number on the Ticket
     *
     * @return the phone number on the Ticket
     */
    public long getPhone()
    {
        return phone;
    }

    /**
     * gets the numbers chosen on the Ticket
     *
     * @return the numbers chosen on the Ticket
     */
    public ArrayList<Integer> getNumsChosen()
    {
        return numsChosen;
    }

    /**
     * changes the name on the Ticket to name
     *
     * @param name new name for the Ticket
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * changes the address on the Ticket to address
     *
     * @param address new address for the Ticket
     */
    public void setAddress(String address)
    {
        this.address = address;
    }

    /**
     * changes the phone number on the Ticket to phone
     *
     * @param phone new phone number for the Ticket
     */
    public void setPhone(long phone)
    {
        this.phone = phone;
    }

    /**
     * changes the chosen numbers on the Ticket to numsChosen
     *
     * @param numsChosen new numbers chosen for the Ticket
     */
    public void setNumsChosen(ArrayList<Integer> numsChosen)
    {
        this.numsChosen = numsChosen;
    }

    /**
     * counts the number of matches in two Integer ArrayLists
     *
     * @param actualNumbers the foreign list, comparing which checking is done from
     * @return the count of matches
     */
    public int howManyMatches(ArrayList<Integer> actualNumbers)
    {
        int count = 0;

        for (int i = 0; i < numsChosen.size(); i++)
        {
            for (int j = 0; j < numsChosen.size(); j++)
            {
                if (actualNumbers.get(i) == numsChosen.get(j))
                {
                    count++;
                }
            }
        }
        return count;
    }

//    @Override
//    public String toString()
//    {
//        return "Ticket{" +
//                "name='" + name + '\'' +
//                ", address='" + address + '\'' +
//                ", phone=" + phone +
//                ", numsChosen=" + numsChosen +
//                '}';
//    }


    @Override
    public String toString()
    {
        return String.format("Name: %-10s, Address: %-10s, Phone: %-10s, Ticket Numbers: %-15s", name, address, phone, numsChosen);
    }
}

