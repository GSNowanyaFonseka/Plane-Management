//import java.util.Scanner;
public class Person {
    private String name;
    private String surname;
    private String email;

    //Constructor method
    public Person(String name, String surname, String email){
        this.name=name;
        this.surname=surname;
        this.email=email;
    }
    // getters and setters
    
    // get the name
    public String getName(){
        return name;
    }

    //set the name
    public void setName(String name){
        this.name=name;
    }

    // get the surname
    public String getSurname(){
        return surname;
    }

    // set the surname
    public void setSurname(String surname){
        this.surname=surname;
    }

    // get the email
    public String getEmail(){
        return email;
    }

    // set the email
    public void setemail(String email){
        this.email=email;
    }

    //create a method for print person's information
    public void personInfo() {
        System.out.println("Name: "+name);
        System.out.println("Surname: "+surname);
        System.out.println("Email: "+email+"\n");
    }


}
