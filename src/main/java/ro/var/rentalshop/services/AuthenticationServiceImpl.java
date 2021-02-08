package ro.var.rentalshop.services;

import ro.var.rentalshop.db.DBConnection;
import ro.var.rentalshop.models.rental.Rental;
import ro.var.rentalshop.models.user.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthenticationServiceImpl implements AuthenticationService {

    Connection connection = new DBConnection().getConnection();

    @Override
    public int getUser(String username) throws SQLException {
        int id = -1;
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT id FROM rentalshopDB.users WHERE username= ? ");
        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            id = resultSet.getInt("id");
        }
        return id;
    }

    @Override
    public User doAuth(int id, String password) throws SQLException {
        User user = null;
        PreparedStatement pStmtUser = connection.prepareStatement("SELECT * FROM users WHERE id = ?");
        pStmtUser.setString(1, String.valueOf(id));
        ResultSet rSetUser = pStmtUser.executeQuery();
        rSetUser.next();
        if (rSetUser.getString("user_password").equals(password)) {
            PreparedStatement pStmtAddress = connection.prepareStatement(
                    "SELECT * FROM addresses WHERE id = ?");
            pStmtAddress.setString(1, rSetUser.getString("id_address"));
            ResultSet rSetAddress = pStmtAddress.executeQuery();
            if (rSetUser.getString("user_type").equals("CLIENT")) {
                user = setClient(rSetUser, rSetAddress);
            } else if (rSetUser.getString("user_type").equals("EMPLOYEE")) {
                user = setEmployee(rSetUser, rSetAddress);
            }
        }
        return user;
    }

    private Address getAddress(ResultSet rSetAddress) throws SQLException {
        rSetAddress.next();
        return new Address(
                Integer.parseInt(rSetAddress.getString("id")),
                rSetAddress.getString("street_name"),
                rSetAddress.getString("street_no"),
                rSetAddress.getString("building"),
                rSetAddress.getString("floor_no"),
                rSetAddress.getString("apartment_no"),
                rSetAddress.getString("city"),
                rSetAddress.getString("country")
        );
    }

    private Client setClient(ResultSet rSetUser, ResultSet rSetAddress) throws SQLException {
        List<Rental> rentalList = new ArrayList<>();
        return new Client(
                Integer.parseInt(rSetUser.getString("id")),
                rSetUser.getString("first_name"),
                rSetUser.getString("last_name"),
                rSetUser.getString("username"),
                rSetUser.getString("user_password"),
                rSetUser.getDate("birthdate").toLocalDate(),
                rSetUser.getDate("registered_on").toLocalDate(),
                rSetUser.getDate("deleted_on").toLocalDate(),
                getAddress(rSetAddress),
                new DrivingLicence(
                        rSetUser.getDate("driving_licence_issue_date").toLocalDate(),
                        rSetUser.getDate("driving_licence_expire_date").toLocalDate(),
                        DrivingLicenceCategory.valueOf(rSetUser.getString("driving_licence_category"))
                ),
                rentalList
        );
    }

    private Employee setEmployee(ResultSet rSetUser, ResultSet rSetAddress) throws SQLException {
        return new Employee(Integer.parseInt(rSetUser.getString("id")),
                rSetUser.getString("first_name"),
                rSetUser.getString("last_name"),
                rSetUser.getString("username"),
                rSetUser.getString("user_password"),
                rSetUser.getDate("birthdate").toLocalDate(),
                rSetUser.getDate("registered_on").toLocalDate(),
                rSetUser.getDate("deleted_on").toLocalDate(),
                getAddress(rSetAddress));
    }

}



