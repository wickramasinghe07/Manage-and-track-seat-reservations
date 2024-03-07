import java.util.Scanner;

public class SeatManagementSystem {

    private static int[] seats;

    public static void main(String[] args) {
        initializeSeats(); // Initialize all seats to be available

        System.out.println("Welcome to the Seat Management System");

        while (true) {
            displayUserMenu();
            int choice = getChoice();

            switch (choice) {
                case 1:
                    buySeat();
                    break;
                case 2:
                    cancelSeat();
                    break;
                case 3:
                    findFirstAvailableSeat();
                    break;
                case 4:
                    displaySeats();
                    break;
                case 5:
                    printTicketsInformation();
                    break;
                case 6:
                    searchTicket();
                    break;
                case 0:
                    System.out.println("Quitting the Seat Management System. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayUserMenu() {
        System.out.println("\nUser Menu:");
        System.out.println("1. Buy a seat");
        System.out.println("2. Cancel a seat");
        System.out.println("3. Find first available seat");
        System.out.println("4. Show seating plan");
        System.out.println("5. Print tickets information and total sales");
        System.out.println("6. Search ticket");
        System.out.println("0. Quit");
    }




    private static void buySeat() {
        displaySeats();
        System.out.println("Option 1: Buy a seat");

        Scanner scanner = new Scanner(System.in);

        // Get row letter from user
        System.out.print("Enter the row letter (A-Z): ");
        String rowLetter = scanner.nextLine().toUpperCase();

        // Validate row letter
        if (!rowLetter.matches("[A-Z]")) {
            System.out.println("Invalid row letter. Please enter a single uppercase letter.");
            return;
        }

        // Get seat number from user
        System.out.print("Enter the seat number (1-" + seats.length + "): ");
        int seatNumber;
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            System.out.print("Enter the seat number (1-" + seats.length + "): ");
            scanner.next(); // Consume the invalid input
        }
        seatNumber = scanner.nextInt();

        // Validate seat number
        if (seatNumber < 1 || seatNumber > seats.length) {
            System.out.println("Invalid seat number. Please enter a number between 1 and " + seats.length + ".");
            return;
        }

        // Check if the seat is available
        if (seats[seatNumber - 1] == 1) {
            System.out.println("Seat " + seatNumber + " in row " + rowLetter + " is already sold. Please choose another seat.");
        } else {
            // Get person information from user
            System.out.print("Enter the person's name: ");
            String name = scanner.next();

            System.out.print("Enter the person's surname: ");
            String surname = scanner.next();

            System.out.print("Enter the person's email: ");
            String email = scanner.next();

            // Create a Person object
            Person person = new Person(name, surname, email);

            // Create a Ticket object with the Person and Seat information
            Ticket ticket = new Ticket(rowLetter, seatNumber, calculateTicketPrice(rowLetter), person);

            // Sell the seat (set it to 1)
            seats[seatNumber - 1] = 1;

            // Add the Ticket to the ArrayList of Tickets
            ticketsList.add(ticket);

            // Print information
            System.out.println("Seat " + seatNumber + " in row " + rowLetter + " sold successfully!");
            ticket.printTicketInfo();
        }
    }
    




    private static void cancelSeat() {
        displaySeats();
        System.out.println("Option 2: Cancel a seat");

        Scanner scanner = new Scanner(System.in);

        // Get row letter from user
        System.out.print("Enter the row letter (A-Z): ");
        String rowLetter = scanner.nextLine().toUpperCase();

        // Validate row letter
        if (!rowLetter.matches("[A-Z]")) {
            System.out.println("Invalid row letter. Please enter a single uppercase letter.");
            return;
        }

        // Get seat number from user
        System.out.print("Enter the seat number (1-" + seats.length + "): ");
        int seatNumber;
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            System.out.print("Enter the seat number (1-" + seats.length + "): ");
            scanner.next(); // Consume the invalid input
        }
        seatNumber = scanner.nextInt();

        // Validate seat number
        if (seatNumber < 1 || seatNumber > seats.length) {
            System.out.println("Invalid seat number. Please enter a number between 1 and " + seats.length + ".");
            return;
        }

        // Check if the seat is already available
        if (seats[seatNumber - 1] == 0) {
            System.out.println("Seat " + seatNumber + " in row " + rowLetter + " is already available. Nothing to cancel.");
        } else {
            // Make the seat available (set it to 0)
            seats[seatNumber - 1] = 0;

            // Remove the corresponding Ticket from the ArrayList
            removeTicket(rowLetter, seatNumber);

            System.out.println("Seat " + seatNumber + " in row " + rowLetter + " is now available.");
        }
    }

    private static void removeTicket(String row, int seatNumber) {
        for (Ticket ticket : ticketsList) {
            if (ticket.getRow().equals(row) && ticket.getSeat() == seatNumber) {
                ticketsList.remove(ticket);
                return;
            }
        }
        System.out.println("Ticket not found for Seat " + seatNumber + " in row " + row);
    }

    // Other methods remain unchanged...

    private static double calculateTicketPrice(String row) {
        // Add your logic to calculate the ticket price based on the row
        // This is just a placeholder, you can replace it with your actual pricing logic
        return 10.0;
    }






    private static void findFirstAvailableSeat() {
        System.out.println("Option 3: Find first available seat");

        for (int row = 0; row < 4; row++) {
            char rowLetter = (char) ('A' + row);

            for (int seatNumber = 1; seatNumber <= seats.length; seatNumber++) {
                if (seats[seatNumber - 1] == 0) {
                    System.out.println("First available seat found: Row " + rowLetter + ", Seat " + seatNumber);
                    return;
                }
            }
        }

        System.out.println("No available seats found.");
    }



    private static void printTicketsInformation() {
        System.out.println("Option 5: Print Tickets Information");

        if (ticketsList.isEmpty()) {
            System.out.println("No tickets have been sold during this session.");
        } else {
            double totalAmount = 0;

            System.out.println("Tickets Sold during this session:");
            for (Ticket ticket : ticketsList) {
                ticket.printTicketInfo();
                totalAmount += ticket.getPrice();
            }

            System.out.println("Total Amount for Tickets Sold: £" + totalAmount);
        }
    }




    private static void searchTicket() {
        System.out.println("Option 6: Search Ticket");

        Scanner scanner = new Scanner(System.in);

        // Get row letter from user
        System.out.print("Enter the row letter (A-Z): ");
        String rowLetter = scanner.nextLine().toUpperCase();

        // Validate row letter
        if (!rowLetter.matches("[A-Z]")) {
            System.out.println("Invalid row letter. Please enter a single uppercase letter.");
            return;
        }

        // Get seat number from user
        System.out.print("Enter the seat number (1-" + seats.length + "): ");
        int seatNumber;
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            System.out.print("Enter the seat number (1-" + seats.length + "): ");
            scanner.next(); // Consume the invalid input
        }
        seatNumber = scanner.nextInt();

        // Validate seat number
        if (seatNumber < 1 || seatNumber > seats.length) {
            System.out.println("Invalid seat number. Please enter a number between 1 and " + seats.length + ".");
            return;
        }

        // Search for the ticket in the ArrayList
        for (Ticket ticket : ticketsList) {
            if (ticket.getRow().equals(rowLetter) && ticket.getSeat() == seatNumber) {
                System.out.println("Ticket Information for Seat " + seatNumber + " in row " + rowLetter + ":");
                ticket.printTicketInfo();
                return;
            }
        }

        System.out.println("This seat is available.");
    }

   
}


