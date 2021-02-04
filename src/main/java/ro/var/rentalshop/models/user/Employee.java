package ro.var.rentalshop.models.user;

import java.util.Date;

public class Employee extends  User{
    public Employee(int id, String firstName, String lastName, String username, String password, Date birthDate, Date registeredOn, Date deletedOn, Address address) {
        super(id, firstName, lastName, username, password, birthDate, registeredOn, deletedOn, address);
    }
}
