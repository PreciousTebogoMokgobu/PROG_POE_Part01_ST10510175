/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog_poe_part1;


public class UserLogin {

    // declaring
    private String storedUsername;
    private String storedPassword;

    // checking if the username is valid
    public boolean checkUserName(String username) {

        // Username must contain "_" and be 5 characters or less
        return username.contains("_") && username.length() <= 5;
    }

    // checking if the password is strong
    public boolean checkPasswordComplexity(String password) {

        // Checking if password has a capital letter
        boolean hasCapital = password.matches(".*[A-Z].*");

        // Checking if password has a number
        boolean hasNumber = password.matches(".*[0-9].*");

        // Checking if password has a special character
        boolean hasSpecial = password.matches(".*[@#$%^&+=!].*");

        // Password must be at least 8 characters and meet all conditions
        return password.length() >= 8 && hasCapital && hasNumber && hasSpecial;
    }

    // registering the user
    public void registerUser(String username, String password) {

        // Checking username
        if (!checkUserName(username)) {
            System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.");
        }

        // Checking password
        else if (!checkPasswordComplexity(password)) {
            System.out.println("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.");
        }

        // If both are correct
        else {
            storedUsername = username;
            storedPassword = password;

            System.out.println("User successfully registered.");
        }
    }

    // checking login details
    public boolean loginUser(String username, String password) {

        // Compare entered username and password with stored ones
        return username.equals(storedUsername) && password.equals(storedPassword);
    }

    // returning login status
    public void returnLoginStatus(boolean loginSuccess) {

        // checking if login is correct or incorrect
        if (loginSuccess) {
            System.out.println("Login successful.");
        } else {
            System.out.println("Username or password incorrect.");
        }
    }
}