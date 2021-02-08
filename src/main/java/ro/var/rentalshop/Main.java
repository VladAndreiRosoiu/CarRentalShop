package ro.var.rentalshop;

import ro.var.rentalshop.models.RentalShop;
import ro.var.rentalshop.models.user.User;
import ro.var.rentalshop.services.AuthenticationServiceImpl;

import java.sql.SQLException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws SQLException {
        AuthenticationServiceImpl authenticationService = new AuthenticationServiceImpl();
        RentalShop rentalShop = new RentalShop();
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter username:");
        String username = sc.next();
        int id = authenticationService.getUser(username);
        if (id > 0) {
            System.out.println("Please enter password:");
            String password = sc.next();
            User user = authenticationService.doAuth(id, password);
            if (user != null) {
                rentalShop.initiateRentalShop(user);
            } else {
                System.out.println("Wrong password!");
            }
        } else {
            System.out.println("Wrong username!");
        }
    }
}
