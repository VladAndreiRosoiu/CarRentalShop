package ro.var.rentalshop.models.car.dacia;

import ro.var.rentalshop.models.car.Car;
import ro.var.rentalshop.models.car.FuelType;
import ro.var.rentalshop.models.car.RentCategory;

public class Dacia extends Car {

    private String make;
    public Dacia(int id, String color, long vin, int rentPricePerDay, int depositRequired,
                 int seatNumber, FuelType fuelType, RentCategory rentCategory) {
        super(id, color, vin, rentPricePerDay, depositRequired, seatNumber, fuelType, rentCategory);
        this.make="Dacia";
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }
}
