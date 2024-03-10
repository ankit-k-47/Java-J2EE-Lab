import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static void print(Contact c) {
        System.out.println("Name : " + c.getName());
        System.out.println("Number : " + c.getNumber());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Contact> contactList = new ArrayList<>();
        
        System.out.println("Enter the number of contacts to be saved : ");
        int numberOfContacts = sc.nextInt();
        sc.nextLine(); // consume newline
        for (int i = 0; i < numberOfContacts; i++) {
            System.out.println("Enter the name of the person : ");
            String name = sc.nextLine();
            System.out.println("Enter the number of the person : ");
            long number = sc.nextLong();
            sc.nextLine(); // consume newline
            Contact c1 = new Contact(name, number);
            contactList.add(c1);
        }

        for (Contact c : contactList) {
            print(c);
        }

        System.out.println("Enter the number of missed calls: ");
        int numberOfMissedCalls = sc.nextInt();
        HashMap<Long, String> missedCalls = new HashMap<>();
        for (int i = 0; i < numberOfMissedCalls; i++) {
            System.out.println("Enter the calling number : ");
            long missedNumber = sc.nextLong();
            String name = "Private Caller";
            for (Contact c : contactList) {
                if (c.getNumber().equals(missedNumber)) {
                    name = c.getName();
                    break;
                }
            }
            missedCalls.put(missedNumber, name);
        }
        missedCalls.forEach((number, name) -> System.out.println("Number : " + number + " Name: " + name));

        System.out.println("Enter the number to delete : ");
        long delNumber = sc.nextLong();
        contactList.removeIf(c -> c.getNumber().equals(delNumber));
        for (Contact c : contactList) {
            print(c);
        }

        sc.close(); // Closing scanner
    }
}
