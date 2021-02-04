package ro.var.rentalshop.models.car.mercedes;

import ro.var.rentalshop.models.car.Car;
import ro.var.rentalshop.models.car.FuelType;
import ro.var.rentalshop.models.car.RentCategory;

public class Mercedes extends Car {
    private String make;

    public Mercedes(int id, String color, long vin, int rentPricePerDay, int depositRequired, int seatNumber, FuelType fuelType, RentCategory rentCategory, String make) {
        super(id, color, vin, rentPricePerDay, depositRequired, seatNumber, fuelType, rentCategory);
        this.make = "Mercedes";
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }
}
