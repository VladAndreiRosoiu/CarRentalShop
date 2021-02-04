package ro.var.rentalshop.models.user;

import ro.var.rentalshop.models.Rental;

import java.util.Date;
import java.util.List;

public class Client extends User{

    private DrivingLicence drivingLicence;
    private List<Rental> rentals;
    public Client(int id, String firstName, String lastName, String username,
                  String password, Date birthDate, Date registeredOn, Date deletedOn, Address address,
                  DrivingLicence drivingLicence, List<Rental> rentals) {
        super(id, firstName, lastName, username, password, birthDate, registeredOn, deletedOn, address);
        this.drivingLicence=drivingLicence;
        this.rentals=rentals;
    }

    public DrivingLicence getDrivingLicence() {
        return drivingLicence;
    }

    public void setDrivingLicence(DrivingLicence drivingLicence) {
        this.drivingLicence = drivingLicence;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(List<Rental> rentals) {
        this.rentals = rentals;
    }
}
