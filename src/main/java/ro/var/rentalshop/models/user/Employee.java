package ro.var.rentalshop.models.user;

import java.time.LocalDate;


public class Employee extends User {
    public Employee(int id, String firstName, String lastName, String username, String password, LocalDate birthDate,
                    LocalDate registeredOn, LocalDate deletedOn, Address address) {
        super(id, firstName, lastName, username, password, birthDate, registeredOn, deletedOn, address);
    }

}
