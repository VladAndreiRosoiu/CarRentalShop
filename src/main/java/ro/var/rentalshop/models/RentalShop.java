package ro.var.rentalshop.models;

import ro.var.rentalshop.models.user.Client;
import ro.var.rentalshop.models.user.Employee;
import ro.var.rentalshop.models.user.User;

import java.util.Scanner;

public class RentalShop {
    private Scanner sc = new Scanner(System.in);
    private boolean isLoggedIn;


    public void initiateRentalShop(User user) {
        do {
            if (user instanceof Client) {
                isLoggedIn = true;
                Client loggedInClient = (Client) user;
                doClientLogic(loggedInClient);
            } else if (user instanceof Employee) {
                isLoggedIn = true;
                Employee loggedInEmployee = (Employee) user;
                doEmployeeLogic(loggedInEmployee);
            }
        } while (isLoggedIn);
    }

    private void doClientLogic(Client client) {
        printClientMenu();
        System.out.println("Please enter choice accordingly:");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                showPersonalInfo();
                break;
            case 2:
                displayCars();
                break;
            case 3:
                searchCar();
                break;
            case 4:
                rentCar();
                break;
            case 5:
                returnCar();
                break;
            case 6:
                //log out
                isLoggedIn = false;
                break;
            case 7:
                //exist app
                System.exit(0);
                break;
            default:
                //default
        }
    }

    private void printClientMenu() {
        System.out.println("Menu");
        System.out.println("1 - Show personal info");
        System.out.println("2 - Show cars");
        System.out.println("3 - Search car");
        System.out.println("4 - Rent car");
        System.out.println("5 - Return car");
        System.out.println("6 - Log out");
        System.out.println("7 - Exit");
    }

    private void returnCar() {
    }

    private void rentCar() {
    }

    private void showPersonalInfo() {
    }

    private void doEmployeeLogic(Employee employee) {

    }

    private void displayCars() {
    }

    private void searchCar() {
    }

    private void printSearchMenu() {
        //TODO implement search
    }
}
