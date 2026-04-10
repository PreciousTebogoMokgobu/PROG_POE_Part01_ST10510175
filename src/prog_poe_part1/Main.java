/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog_poe_part1;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        // Scanner to get input from user
        Scanner input = new Scanner(System.in);

        // object of UserLogin class
        UserLogin login = new UserLogin();

        // REGISTRATION
        System.out.println("Register");

        boolean isRegistered = false;

        // loop until user enters correct username and password
        while (!isRegistered) {

            // input to user to enter username
            System.out.println("Enter username:");
            String username = input.nextLine();

            // input to user to enter password
            System.out.println("Enter password:");
            String password = input.nextLine();

            // check username
            if (!login.checkUserName(username)) {
                System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.");
            }

            // check password
            else if (!login.checkPasswordComplexity(password)) {
                System.out.println("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.");
            }

            // if both are correct
            else {
                login.registerUser(username, password);
                isRegistered = true; // stop loop
            }
        }

        //LOGIN 
        System.out.println("\nLogin");

        boolean loggedIn = false;

        // loop until correct login
        while (!loggedIn) {

            // input to user to enter username again
            System.out.println("Enter username:");
            String loginUser = input.nextLine();

            // input to user to enter password again
            System.out.println("Enter password:");
            String loginPass = input.nextLine();

            boolean success = login.loginUser(loginUser, loginPass);

            // output
            login.returnLoginStatus(success);

            if (success) {
                loggedIn = true; // stop loop
            }
        }

        // close scanner
        input.close();
    }
}