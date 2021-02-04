package ro.var.rentalshop.models;

import java.util.Date;

public class Payment {
    private int id;
    private Rental rental;
    private int amountPaid;
    private Date paidOn;

    public Payment(int id, Rental rental, int amountPaid, Date paidOn) {
        this.id = id;
        this.rental = rental;
        this.amountPaid = amountPaid;
        this.paidOn = paidOn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }

    public int getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(int amountPaid) {
        this.amountPaid = amountPaid;
    }

    public Date getPaidOn() {
        return paidOn;
    }

    public void setPaidOn(Date paidOn) {
        this.paidOn = paidOn;
    }
}
