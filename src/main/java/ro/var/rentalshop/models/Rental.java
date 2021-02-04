package ro.var.rentalshop.models;

import ro.var.rentalshop.models.car.Car;
import ro.var.rentalshop.models.user.Client;
import ro.var.rentalshop.models.user.Employee;

import java.util.Date;
import java.util.Objects;

public class Rental {
    private Car car;
    private Client client;
    private Date rentalDate;
    private Date returnDate;
    private RentalStatus rentalStatus;
    private String statusReason;
    private Date statusOn;
    private Employee employee;

    public Rental(Car car, Client client, Date rentalDate, Date returnDate, RentalStatus rentalStatus, String statusReason, Date statusOn, Employee employee) {
        this.car = car;
        this.client = client;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.rentalStatus = rentalStatus;
        this.statusReason = statusReason;
        this.statusOn = statusOn;
        this.employee = employee;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public RentalStatus getRentalStatus() {
        return rentalStatus;
    }

    public void setRentalStatus(RentalStatus rentalStatus) {
        this.rentalStatus = rentalStatus;
    }

    public String getStatusReason() {
        return statusReason;
    }

    public void setStatusReason(String statusReason) {
        this.statusReason = statusReason;
    }

    public Date getStatusOn() {
        return statusOn;
    }

    public void setStatusOn(Date statusOn) {
        this.statusOn = statusOn;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rental rental = (Rental) o;
        return Objects.equals(car, rental.car) && Objects.equals(client, rental.client) && Objects.equals(rentalDate, rental.rentalDate) && Objects.equals(returnDate, rental.returnDate) && rentalStatus == rental.rentalStatus && Objects.equals(statusReason, rental.statusReason) && Objects.equals(statusOn, rental.statusOn) && Objects.equals(employee, rental.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(car, client, rentalDate, returnDate, rentalStatus, statusReason, statusOn, employee);
    }

    @Override
    public String toString() {
        return "Rental{" +
                "car=" + car +
                ", client=" + client +
                ", rentalDate=" + rentalDate +
                ", returnDate=" + returnDate +
                ", rentalStatus=" + rentalStatus +
                ", statusReason='" + statusReason + '\'' +
                ", statusOn=" + statusOn +
                ", employee=" + employee +
                '}';
    }
}
