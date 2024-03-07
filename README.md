# Manage-and-track-seat-reservations

    A new company managing a private plane has asked you to create a Java program to manage and track seat reservations     
    effectively. Your assignment involves designing and implementing this program.


![image](https://github.com/wickramasinghe07/Manage-and-track-seat-reservations/assets/102098023/31c77adf-c834-4e9c-9217-8ebb02892e16)


In the above picture, you can notice four rows of seats labelled as A, B, C and D, and it is important to note that these rows have varying seat capacities (either 12 or 14 seats). Seats are coded according to their row and seat number and have different prices according to their colour. For example, the seat marked with an ‘X’ is considered seat B2 and costs £200.


Task 1
    
      Add a user menu in your main method that displays the following menu and asks the user to select an option. Option ‘0’         should terminate the program without crashing or giving an error. The rest of the options will be implemented in the           next tasks.
      
        System.out.println("1. Buy a seat");
        System.out.println("2. Cancel a seat");
        System.out.println("3. Find first available seat");
        System.out.println("4. Show seating plan");
        System.out.println("5. Print tickets information and total sales");
        System.out.println("6. Search ticket");
        System.out.println("0. Quit");

Task 2

      Create a method called buy_seat that asks the user to input a row letter and a seat number. Check that the row and 
      seat entered are valid and that the seat is available (free). Record the seat as sold (as described in Task 1). Call 
      this method when the user selects ‘1’ in the main menu.


Task 3

    Create a method called cancel_seat that makes a seat available. It should ask the user to input a row number and a seat 
    number. Check that the row and seat are valid, and that the seat is not available already.

 Task 4 
 
     Create a method called find_first_available that find the first seat which is still available. You should search in row 
     A first, then B, then C and then D. Call this method when the user selects ‘3’ in the main menu 


Task 5 

    Create a method called show_seating_plan that shows the seats that are available and the seats that have been sold. 
    Display available seats with the character ‘O’ and the sold seats with ‘X’. Call this method when the user selects ‘4’ 
    in the main menu.

        Option 4: Show Seating Plan
        Row A: O O O O O X X X X X 
        Row B: O O O O O O O X X X 
        Row C: O O O O O O O O O O 
        Row D: O O O O O O O O O O


Task 6 

    Create a new class file called Person (Person.java) with the following attributes: name, surname, and email. Add a           constructor that takes the 3 variables as input to create an object Person. Add all the getters and setters of the           class Person. Add a method that prints the information from Person.


Task 7 

    Create a new class file called Ticket (Ticket.java) with the following attributes: row, seat, price, and Person. Person       is an object created using the class Person from Task 7.

Task 8

    In the main program, add a array of Tickets to store all the tickets sold in that session. 

    1)
      Extend the buy_seat method such that when buying a ticket, it asks for all the information of a Person, creates a new         Ticket with the corresponding price and seat information and adds the ticket to the new array of Tickets.
    2)
      Extend the cancel_seat method such that when cancelling a ticket, it removes the ticket from the array list of tickets.

Task 9

    Create a method called print_tickets_info that prints the information of all tickets that have been sold during the          session, and calculates the total price of the tickets sold during the session Example, if ticket A1 and B7 were sold         during the session, the total amount would be £350 (A1 = £200 + B2 = £150). Call this method when the user selects ‘5’       in the main menu.

Task 10

    Create a method called search_ticket that asks the user to input a row letter and a seat number and searches if someone      has bought that seat. If someone has bought the seat, it will print the Ticket and Person information, otherwise will        display ‘This seat is available’. Call this method when the user selects ‘6’ in the main menu.

Task 12

    Add a method save in the class Ticket that saves the information of the Ticket (including the Person) in a file. The         name of the file should be the name of the row and the seat number (e.g., A2.txt for a ticket sold in row A seat 2).         Call this method every time a ticket is sold.


