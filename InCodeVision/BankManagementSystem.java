package InCodeVision;

import java.util.Scanner;

public class BankManagementSystem {
    // Account Details
    static int accountNumber[] = new int[100];
    static String accountName[] = new String[100];
    static double balance[] = new double[100];
    static int accountnumber = 100001;
    
    
    
    //USER COUNT
    static int accountcount = 0;
    
    static Scanner sc = new Scanner(System.in);
    
    static void start(){
        System.out.println("=====================================================================WELCOME TO INCODEVISION Bank Account Managment System============================================================================");
        System.out.println("1.CREATE A NEW ACCOUNT");
        System.out.println("2.DEPOSIT");
        System.out.println("3.WITHDRAWAL");
        System.out.println("4.CHECK YOUR BALANCE");
        System.out.print("Enter your Input : ");
        int input = sc.nextInt();
        if(input == 1 ){
            createAccount();
        }
        else if(input ==2){
            deposit();
        }
        else if(input ==3){
            withdraw();
        }
        else if(input ==4){
            checkBalance();
        }
        else{
            System.out.println("PLEASE ENTER CORRECT INPUT ACCORDING TO YOUR REQUIREMENTS");
            start();
        }
        System.out.println("------------------------------------------------------------------------------------------");
    }
    static void createAccount(){

        //input user information
        System.out.print("ENTER YOUR NAME : ");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.print("ENTER INITIAL DEPOSIT(MINIMUM - 1000) : ");
        int ammount = sc.nextInt();
        
        //storing user information
        accountNumber[accountcount] = accountnumber;
        accountName[accountcount] = name;
        balance[accountcount] = ammount;
        
        
        //Display account information
        System.out.println("==============================================================================CONGRATULATIONS YOUR ACCOUNT IS SUCCESSFULLY CREATED==============================================================================");
        System.out.println("YOUR ACCOUNT DETAILS ARE : - ");
        System.out.println("ACCOUNT NUMBER : " + accountNumber[accountcount]);
        System.out.println("ACCOUNT NAME : " + accountName[accountcount]);
        
        if(ammount >=1000){
            System.out.println("ACCOUNT BALANCE : " + balance[accountcount]);
        }
        else{
            System.out.println("PLEASE DEPOSIT MINIMUM AMMOUNT");
        }
        
        
        //increment
        accountnumber++;
        accountcount++;
        start(); 
    }
    static void deposit(){

        System.out.print("ENTER YOUR ACCOUNT NUMBER : ");
        int accnumber = sc.nextInt();
        boolean found = false;
        for(int i=0;i<=accountcount;i++){
            if(accountNumber[i] == accnumber){

                found = true;

                System.out.print("ENTER THE AMMOUNT YOU WANT TO DEPOSIT : ");
                int amm = sc.nextInt();
                balance[i] += amm;
                
                System.out.println("-----------------------------------------------------------------------------------------YOUR BALANCE IS SUCCESSFULLY DEPOSITED---------------------------------------------------------------------------------------------");
                
                System.out.println("YOUR ACCOUNT DETAILS ARE : - ");
                System.out.println("ACCOUNT NUMBER : " + accountNumber[i]);
                System.out.println("ACCOUNT NAME : " + accountName[i]);
                System.out.println("ACCOUNT BALANCE : " + balance[i]);
                

                start();
            }
        }

        if(!found) {
        System.out.println("ACCOUNT NUMBER NOT FOUND");
        }

        start();
    }
    static void withdraw(){
        System.out.print("ENTER YOUR ACCOUNT NUMBER : ");
        int accnumber = sc.nextInt();
        boolean found = false;
        for(int i=0;i<=accountcount;i++){
            if(accountNumber[i] == accnumber){
                found = true;
                System.out.print("ENTER THE AMMOUNT YOU WANT TO WITHDRAW : ");
                int amm = sc.nextInt();

                if(balance[i] - amm >= 0){
                    balance[i] -= amm;

                    System.out.println("-----------------------------------------------------------------------------------------YOUR BALANCE IS SUCCESSFULLY WITHDRAWED---------------------------------------------------------------------------------------------");
                    
                    System.out.println("YOUR ACCOUNT DETAILS ARE : - ");
                    System.out.println("ACCOUNT NUMBER : " + accountNumber[i]);
                    System.out.println("ACCOUNT NAME : " + accountName[i]);
                    System.out.println("ACCOUNT BALANCE : " + balance[i]);
                }
                else{
                    System.out.println("---------------------------------------------------------------------------YOUR WITHDRAWAL AMMOUNT EXCEEDS THE EXISTING BALANCE OF YOUR ACCOUNT--------------------------------------------------------------------------");
                } 
            }   
        }
        if(!found) {
        System.out.println("ACCOUNT NUMBER NOT FOUND");
        }

        start();         
    }
    static void checkBalance(){
        System.out.print("ENTER YOUR ACCOUNT NUMBER : ");
        int accnumber = sc.nextInt();
        boolean found = false;

        for(int i=0;i<=accountcount;i++){
            if(accountNumber[i] == accnumber){
                found = true;
                    System.out.println("-----------------------------------------------------------------------------------------BALANCE OF " + accountName[i] +
                    " WITH ACCOUNT NUMBER " + accountNumber[i] +  " IS " +  balance[i] + "---------------------------------------------------------------------------------------------");
                    
            }   
        }

        if(!found) {
        System.out.println("ACCOUNT NUMBER NOT FOUND");
        }

        start();
    }


    static void main(){
        start();
    }
    
}