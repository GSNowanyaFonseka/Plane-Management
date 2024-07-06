import java.util.Scanner; // import scanner class from java util package

public class PlaneManagement{// create public class called Planetest


    // create an array to tickets
    static Ticket[] arrayTicket=new Ticket[52];
    static double price;
    static int ticketCount=0;
    static double totalPrice=0;
    static Ticket Ticket; // 
    

    public static int[][] seat;   //declaring seat array

    static {
        seat=new int [4][];
        seat[0]=new int[14];
        seat[1]=new int[12];
        seat[2]=new int[12];
        seat[3]=new int[14];}

    public static double price(int columnNumber){  // create method for price
        
        //calculating price according to the columnNumber of seat
        if(columnNumber<=5){
            price=200;
        }
        else if(columnNumber>=6 && columnNumber<=9){
            price=150;
        }
        else if(columnNumber>=10 && columnNumber<=14){
            price=180;
        }
        else{
            price=0;
        }
        return price;

        
    }

    // create a method of buyseat for getting the row letter and the column number of the seat that user want to buy
    public static void buy_seat(Scanner input){

        show_seating_plan(seat); //calling to the seat method

        System.out.print("Enter row letter of the seat: "); // get the row letter from the user
        char rowLetter=input.next().toUpperCase().charAt(0);

        System.out.print("Enter column Number of the seat: "); // get the column number from the user
        int columnNumber=input.nextInt();

        //declaring rowIndex variable and assigning it with the value of row letter converted to uppercase
        int rowIndex=rowLetter-'A';

        //decalring columnIndex variable and assign coulmnNumber to it
        int columnIndex=columnNumber-1;

        //checking whether the seat location is valid and the seat has already booked or not
        if(rowIndex>=0 && rowIndex<14 && columnIndex>=0 && columnIndex<seat[0].length){

            //check if the seat row index and column index is equal to zero, if it is true then book the seat
            if(seat[rowIndex][columnIndex]==0){
                System.out.println("Your booking is done\n");
                seat[rowIndex][columnIndex]=1;
            }

            //else if it is equal to 1, then display the seat as booked
            else if(seat[rowIndex][columnIndex]==1){
                System.out.println("The seat has already booked\n");
            }
        }

        //if the given inputs are invalid then display the seat location as invalid
        else{
            System.out.print("Invalid seat location, enter valid seat location \n");
        }
                price(columnNumber);
                totalPrice+=price;
                
                //System.out.println("seat price is : "+seatprice);

                // getting input from user 
                System.out.print("Enter your name : ");
                String name=input.next();
                System.out.print("Enter your surname : ");
                String surname=input.next();
                
                System.out.print("Enter your email : ");
                String email=input.next();
                System.out.println();

                // create a Person object for the ticket
                Person person=new Person(name,surname,email);

                Ticket ticket=new Ticket (rowIndex,(char)rowLetter,columnNumber,price,person );
                //ticket.printTicketInfo(writer);

                arrayTicket[ticketCount++]=ticket;
                //ticketCount++;

               ticket.save();

    }

    // create a method of buyseat for getting the row letter and the column number of the seat that user want to buy
    public static void cancel_seat(Scanner input){

        // get the row letter from the user
        System.out.print("Enter row letter of the seat: ");
        char rowLetter=input.next().toUpperCase().charAt(0);

        // get the column number from the user
        System.out.print("Enter column Number of the seat: ");
        int columnNumber=input.nextInt();

        //declaring rowIndex variable and assigning it with the value of row letter converted to lowercase
        int rowIndex=rowLetter-'A';

        //decalring columnIndex variable and assign coulmnNumber to it
        int columnIndex=columnNumber-1;

        //checking whether the seat location is valid and the seat has already booked or not
        if(rowIndex>=0 && rowIndex<14 && columnIndex>=0 && columnIndex<seat[0].length){

        
            if(seat[rowIndex][columnIndex]==1){
                System.out.println("Your booking is canceled\n");
                
                seat[rowIndex][columnIndex]=0;
            }

            //else if it is equal to 1, then display the seat as booked
            else if(seat[rowIndex][columnIndex]==0){
                System.out.println("The seat is already available\n");
            }
        }
        //if the given inputs are invalid then display the seat location as invalid
        else{
            System.out.println("Invalid seat location, enter valid seat location \n");
        }

        //totalPrice-=price;

        cancelTicket(rowLetter,columnIndex);

    }

    public static void cancelTicket(char rowLetter, int columnIndex) {
        for (int i = 0; i < ticketCount; i++) {
            if (arrayTicket[i].getrowLetter() == rowLetter && arrayTicket[i].getSeat() == columnIndex+1) {
                for (int j = i + 1; j < ticketCount-1; j++) {
                    arrayTicket[j] = arrayTicket[j+1]; // shift
                }
                totalPrice=totalPrice - arrayTicket[i].getPrice();
                ticketCount--;
                return; 
            }
        }
    }

    // create a method for display seating plan
    public static void show_seating_plan(int [][] seat){
        
        //declaring and initializing row variable
        char row='A';

        //display the number of each columns of the seats
        for (int column=1;column<=14;column++){
            System.out.printf("%4s",column);
        }

        System.out.println("\n");

        //display seating paln
        for(int i=0;i<seat.length;i++){
            if(row<='D'){
                System.out.print(row);
                row++;
            }
                for(int j=0;j<seat[i].length;j++){
                    if(seat[i][j]==1){
                        System.out.printf("%4s"," X ");
                    }
                
                    else{
                        System.out.printf("%4s"," O ");
                    }
                }
        System.out.println("\n");
        }
    }
    
    //create updatingSeatingPlan method
    public static void updatingSeatingPlan( Scanner input){
        //declaring and initializing row variable
        char row='A';

        //display the number of each columns of the seats
        for (int column=1;column<=14;column++){
            System.out.printf("%4s",column);
        }

        System.out.println("\n");

        //display seating paln
        for(int i=0;i<seat.length;i++){
            if(row<='D'){
                System.out.print(row);
                row++;
            }
                for(int j=0;j<seat[i].length;j++){
                    if(seat[i][j]==0){
                        System.out.printf("%4s"," X ");
                    }
                
                    else{
                        System.out.printf("%4s"," O ");
                    }
                }
        System.out.println("\n");
        }
    }

    public static void first_available_seat(int[][] seat){
        for (int i = 0; i < seat.length; i++) {
            for (int j = 0; j < seat[i].length; j++) {
                if (seat[i][j]==0) {
                    char Letter=(char)('A'+i);
                    System.out.println("A seat at position (" + Letter + ", " + (j + 1) + ") is available.\n");
                    return; // Exit the method once the first available seat is found
                }
            }
        }
        // If no available seat is found, print a message
        System.out.println("No available seats found.\n");
    }

    public static void print_tickets_info(){

        for(int j=0;j<ticketCount;j++){
            System.out.println("Ticket "+(j+1));
            arrayTicket[j].printTicketInfo();
            System.out.println();
        }
        System.out.println("Total price : $"+totalPrice);
        
    }

    public static void search_ticket(Scanner input){
        // get the row letter from the user
        System.out.print("Enter row letter of the seat: ");
        int rowIndex=input.next().toUpperCase().charAt(0)-'A';

        // get the column number from the user
        System.out.print("Enter column Number of the seat: ");
        int columnIndex=input.nextInt()-1;

        boolean found=false;

        for(int i=0;i<ticketCount;i++){
            if(arrayTicket[i].getRow()==rowIndex && arrayTicket[i].getSeat()==columnIndex+1){
                arrayTicket[i].printTicketInfo();
                found=true;
                break;
            }
        }
        if(!found){
            System.out.println("The seat is already availlable\n");
        }
    }


    //main method
    public static void main(String[]args) throws Exception {
    
        // display menu 
		String star_line="*".repeat(57);

		System.out.print(star_line);
		System.out.println();
		System.out.println("\n*\t\t\tMENU OPTIONS\t\t\t*\n");

		System.out.print(star_line);
		System.out.println();


		System.out.println("\n\t1) Buy a seat\n");
		System.out.println("\t2) Cancel a seat\n");
		System.out.println("\t3) Find first available seat\n");
		System.out.println("\t4) Show seating plan\n");
		System.out.println("\t5) Print tickets informations and total sales\n");
		System.out.println("\t6) Search ticket\n");
		System.out.println("\t0) Quit\n");
		System.out.print(star_line);
		System.out.println("\n");

        // declaring variable
        int option;

        // create an object for getting input
        Scanner input=new Scanner(System.in);

        // using do-while loop for getting input from the user until user input 0 to exit 
        do{
            System.out.print("Enter an option from the menu : ");
            option =input.nextInt();
            System.out.println();

            // call to the each methods according to the user input 
            switch(option){

                case 1:
                    buy_seat(input);
                    break;

                case 2:
                    cancel_seat(input);
                    break;

                case 3:
                    first_available_seat(seat);
                    break;

                case 4:
                    show_seating_plan(seat);
                    break;

                case 5:
                    print_tickets_info();
                    break;

                case 6:
                    search_ticket(input);
                    break;
                
                case 0:
                    System.out.println("Thank you, Good bye...\n");
                    break;
                    
            }
        }while(option!=0);

        input.close();

    }
}
