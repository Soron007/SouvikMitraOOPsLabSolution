package sysadminapp;

import java.util.Locale;
import java.util.Scanner;

public class Employee {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity=500;
    private int defaultPasswordLength =16; /*need length mentioning for pass generation*/
    private String alternateEmail;
    private String companySuffix = "hacker.com";

    //    Constructor for First and Lastname
    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
//        System.out.println("Email Created: " + this.firstName + " " + this.lastName);

// Method here prompting for department and return the dept
        this.department = setDepartment();
//        System.out.println("Department is: " + this.department);

//        Method here for displaying a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your Password is: " + this.password);

//        firstname.lastname combination for email
    email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department.toLowerCase() + "." + companySuffix;
//        System.out.println("Your email is: " + email);
    }

    //    Prompt for Department
    private String setDepartment() {
        System.out.print("Employee name: "+ firstName + " " + "\nEnter the department\n1 for Technical\n2 for Admin\n3 for Human Resource\n4 for Legal\n0 for none\nEnter department number: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) {
            return "Technical";
        } else if (depChoice == 2) {
            return "Admin";
        } else if (depChoice == 3) {
            return "HumanResource";
        } else if (depChoice == 4) {
            return "Legal";
        } else {
            return "";
        }
    }
//    Random Password Generator
private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!#@$%^&*()_+";
        char[] password = new char[length];
        for(int i =0 ; i<length; i++){
             int rand = (int) (Math.random() * passwordSet.length());
             password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
}
//    Mailbox Capacity Setting
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }

//    Setting for Alternate Email

    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }

//    Change password feature
public void changePassword(String password){
        this.password = password;
}

public int getMailboxCapacity(){ return mailboxCapacity;}
    public String getAlternateEmail(){return alternateEmail;}
    public String getPassword(){return password;}


    public String showInfo(){
        return "Display Name: " + firstName + " " + lastName +
                "\nCompany email: " + email +
                "\nMailbox capacity: " + mailboxCapacity + "mb";
    }
}
