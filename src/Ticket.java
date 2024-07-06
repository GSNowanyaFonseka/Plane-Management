import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ticket {
    private int rowIndex;
    private char rowLetter;
    private int columnIndex;
    private double price;
    private Person person;

    // create an objecgt to getting input from the user
    Scanner input=new Scanner(System.in);

    //create constructor method
    public Ticket(int rowIndex,char rowLetter, int columnIndex,double price,Person person){
        this.rowIndex=rowIndex;
        this.rowLetter=(char)('A'+rowIndex);
        this.columnIndex=columnIndex;
        this.price=price;
        this.person=person;

    }

    // create a method for get the row
    public int getRow(){
        return rowIndex;
    }

    //set the row
    public void setRow(int rowIndex){
        this.rowIndex=rowIndex;
    }

    public char getrowLetter(){
        return rowLetter;
    }

    public void setRowLetter(char rowLetter){
        this.rowLetter=rowLetter;
    }

    //get the seat
    public int getSeat(){
        return columnIndex;
    }

    //set the seat
    public void setSeat(int columnIndex){
        this.columnIndex=columnIndex;
    }

    //get the price
    public double getPrice(){
        return price;
    }

    //set the price
    public void setPrice(double price){
        this.price=price;
    }

    public Person getPerson(){
        return person;
    }

    public void setPerson(Person person){
        this.person=person;
    }

    //method print ticketInfo 
    public void printTicketInfo(){
        //char rowLetter=(char)('A'+rowIndex);
        System.out.println("Ticket Information");
        System.out.println("Row       : "+rowLetter);
        System.out.println("Seat      : "+columnIndex);
        System.out.println("Price     : $"+price);
        System.out.println("Person Information");
        person.personInfo();

        //return rowLetter;
    }

    public void save(){
        try{
            FileWriter writer=new FileWriter(rowLetter+""+columnIndex+".txt");
            writer.write("Ticket Information"+"\n");
            writer.write("Seat      : "+columnIndex+"\n");
            writer.write("Price     : $"+price+"\n");
            writer.write("Person Information"+"\n"); 
            writer.write("Name      : "+ person.getName()+"\n");
            writer.write("Surname   : "+ person.getSurname()+"\n");
            writer.write("Email     : "+ person.getEmail()+"\n");// Call the existing method to get ticket info string
            writer.close();
            System.out.println("Ticket information are saved");
        } catch(IOException e){
            System.out.println("The ticket is not saved due to an error");
        }
    }
}
