package ro.var.rentalshop;

import ro.var.rentalshop.models.user.Client;
import ro.var.rentalshop.models.user.Employee;
import ro.var.rentalshop.models.user.User;
import ro.var.rentalshop.services.AuthenticationServiceImpl;

import java.sql.SQLException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws SQLException {
        AuthenticationServiceImpl authenticationService = new AuthenticationServiceImpl();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter username");
        String username = scanner.next();
        int id = authenticationService.getUser(username);
        if (id > 0) {
            System.out.println("Enter password");
            String password = scanner.next();
            User authUser = authenticationService.doAuth(id, password);
            if (authUser != null) {
                System.out.println("Authenticated as ");
                System.out.println(authUser.getFirstName() + " " + authUser.getLastName());
                System.out.println(authUser.getAddress().getCity());
                if (authUser instanceof Client) {
                    System.out.println("CLIENT");
                } else if (authUser instanceof Employee) {
                    System.out.println("EMPLOYEE");
                }
            } else {
                System.out.println("Wrong password!");
            }
        }else {
            System.out.println("Wrong username");
        }
    }
}
