package ro.var.rentalshop.services;

import ro.var.rentalshop.models.user.User;

import java.sql.SQLException;

public interface AuthenticationService {
    int getUser(String username) throws SQLException;
    User doAuth(int id, String password) throws SQLException;

}
