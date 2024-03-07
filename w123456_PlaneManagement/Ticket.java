import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Ticket {
    private String row;
    private int seat;
    private double price;
    private Person person;

    // Constructor
    public Ticket(String row, int seat, double price, Person person) {
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;

        // Save ticket information to file when a ticket is sold
        save();
    }

    // Getters and Setters (unchanged)

    // Method to print Ticket information (unchanged)

    // Method to save Ticket information to file
    public void save() {
        String fileName = row + seat + ".txt";

        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println("Ticket Information:");
            writer.println("Row: " + row);
            writer.println("Seat: " + seat);
            writer.println("Price: " + price);
            writer.println("Person Information:");
            writer.println("Name: " + person.getName());
            writer.println("Surname: " + person.getSurname());
            writer.println("Email: " + person.getEmail());
            System.out.println("Ticket information saved to file: " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving ticket information to file: " + fileName);
            e.printStackTrace();
        }
    }
}

